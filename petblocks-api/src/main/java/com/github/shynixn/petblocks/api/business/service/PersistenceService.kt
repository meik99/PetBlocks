package com.github.shynixn.petblocks.api.business.service

import com.github.shynixn.petblocks.api.persistence.entity.PetMeta
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
interface PersistenceService {
    /**
     * Returns [CompletableFuture] with a list of stored [PetMeta].
     */
    fun getAll(): CompletableFuture<List<PetMeta>>

    /**
     * Returns [CompletableFuture] with optional newly created [PetMeta] instance or empty optional if not found.
     */
    fun <P> getFromPlayer(player: P): CompletableFuture<Optional<PetMeta>>

    /**
     * Returns [CompletableFuture] with the [PetMeta] instance of the given player. Creates a new [PetMeta] instance and
     * stores it in the storage if it does not already exist.
     */
    fun <P> getOrCreateFromPlayer(player: P): CompletableFuture<PetMeta>

    /**
     * Saves the given [petMeta] instance and returns a [CompletableFuture] with the same petMeta instance.
     */
    fun save(petMeta: PetMeta): CompletableFuture<PetMeta>
}