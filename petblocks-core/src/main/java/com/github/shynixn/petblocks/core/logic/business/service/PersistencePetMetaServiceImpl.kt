package com.github.shynixn.petblocks.core.logic.business.service

import com.github.shynixn.petblocks.api.PetBlocksApi
import com.github.shynixn.petblocks.api.business.controller.PetBlockController
import com.github.shynixn.petblocks.api.business.service.ConcurrencyService
import com.github.shynixn.petblocks.api.business.service.PersistencePetMetaService
import com.github.shynixn.petblocks.api.persistence.controller.PetMetaController
import com.github.shynixn.petblocks.api.persistence.entity.PetMeta
import com.github.shynixn.petblocks.core.logic.business.extension.async
import com.github.shynixn.petblocks.core.logic.business.extension.sync
import com.google.inject.Inject
import java.util.*
import java.util.concurrent.CompletableFuture

/**
 * Created by Shynixn 2018.
 * <p>
 * Version 1.2
 * <p>
 * MIT License
 * <p>
 * Copyright (c) 2018 by Shynixn
 * <p>
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * <p>
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 * <p>
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
class PersistencePetMetaServiceImpl @Inject constructor(private val concurrencyService: ConcurrencyService) : PersistencePetMetaService {
    private var petBlockController: PetBlockController<*>? = null
    private var petMetaController: PetMetaController<*>? = null

    /**
     * Returns [CompletableFuture] with a list of stored [PetMeta].
     */
    override fun getAll(): CompletableFuture<List<PetMeta>> {
        initializeDependencies()

        val completableFuture = CompletableFuture<List<PetMeta>>()
        val activePetMetas = petBlockController!!.all.map { p -> p.meta }

        async(concurrencyService) {
            val petMetaList = petMetaController!!.all

            petMetaList.toTypedArray().forEach { item ->

                activePetMetas.forEach { active ->
                    if (active.id == item.id) {
                        petMetaList.remove(item)
                        petMetaList.add(active)
                    }
                }

            }

            sync(concurrencyService) {
                completableFuture.complete(petMetaList)
            }
        }

        return completableFuture
    }

    /**
     * Returns the petMeta of from the given player uuid. Creates
     * a new one if it does not exist yet. Gets it from the runtime when a pet
     * currently uses the meta data of the player.
     */
    override fun getOrCreateFromPlayerUUID(uuid: UUID): CompletableFuture<PetMeta> {
        initializeDependencies()

        val completableFuture = CompletableFuture<PetMeta>()
        val optPetBlock = petBlockController!!.getFromUUID(uuid)

        if (optPetBlock.isPresent) {
            val meta = optPetBlock.get().meta

            sync(concurrencyService) {
                completableFuture.complete(meta)
            }
        } else {
            async(concurrencyService) {
                val optResult = petMetaController!!.getFromUUID(uuid)

                if (optPetBlock.isPresent) {
                    sync(concurrencyService) {
                        completableFuture.complete(optResult.get())
                    }
                } else {
                    val petMeta = petMetaController!!.createFromUUID(uuid)
                    petMetaController!!.store(petMeta)

                    sync(concurrencyService) {
                        completableFuture.complete(petMeta)
                    }
                }
            }
        }

        return completableFuture
    }

    /**
     * Saves the given [petMeta] instance and returns a [CompletableFuture] with the same petMeta instance.
     */
    override fun save(petMeta: PetMeta): CompletableFuture<PetMeta> {
        initializeDependencies()

        val completableFuture = CompletableFuture<PetMeta>()

        async(concurrencyService) {
            petMetaController!!.store(petMeta)
            completableFuture.complete(petMeta)

            sync(concurrencyService) {
                val petBlock = petBlockController!!.getFromUUID(petMeta.playerMeta.uuid)

                if (petBlock.isPresent) {
                    petBlock.get().respawn()
                }
            }
        }
        return completableFuture
    }

    /**
     * Helper.
     */
    private fun initializeDependencies() {
        if (petBlockController == null) {
            petBlockController = PetBlocksApi.getDefaultPetBlockController<Any>() as PetBlockController<*>
            petMetaController = PetBlocksApi.getDefaultPetMetaController<Any>() as PetMetaController<*>
        }
    }
}