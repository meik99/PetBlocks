package com.github.shynixn.petblocks.sponge.logic.business.helper

import com.github.shynixn.petblocks.api.business.entity.GUIItemContainer
import com.github.shynixn.petblocks.api.business.entity.PetBlock
import com.github.shynixn.petblocks.api.business.entity.PetBlocksPlugin
import com.github.shynixn.petblocks.api.business.enumeration.ChatColor
import com.github.shynixn.petblocks.api.business.enumeration.ParticleType
import com.github.shynixn.petblocks.api.business.enumeration.Permission
import com.github.shynixn.petblocks.api.business.enumeration.Version
import com.github.shynixn.petblocks.api.persistence.entity.ChatMessage
import com.github.shynixn.petblocks.api.persistence.entity.EngineContainer
import com.github.shynixn.petblocks.api.persistence.entity.PetMeta
import com.github.shynixn.petblocks.core.logic.persistence.configuration.Config
import com.github.shynixn.petblocks.sponge.logic.business.PetBlocksManager
import com.github.shynixn.petblocks.sponge.nms.VersionSupport
import org.spongepowered.api.Game
import org.spongepowered.api.Sponge
import org.spongepowered.api.command.CommandSource
import org.spongepowered.api.data.type.HandTypes
import org.spongepowered.api.entity.Entity
import org.spongepowered.api.entity.Transform
import org.spongepowered.api.entity.living.player.Player
import org.spongepowered.api.item.inventory.Inventory
import org.spongepowered.api.item.inventory.ItemStack
import org.spongepowered.api.item.inventory.property.SlotIndex
import org.spongepowered.api.item.inventory.property.SlotPos
import org.spongepowered.api.item.inventory.type.CarriedInventory
import org.spongepowered.api.item.inventory.type.GridInventory
import org.spongepowered.api.plugin.PluginContainer
import org.spongepowered.api.scheduler.Task
import org.spongepowered.api.text.Text
import org.spongepowered.api.text.serializer.TextSerializers
import org.spongepowered.api.world.World
import java.io.InputStream
import java.util.*
import java.util.function.Consumer

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
/**
 * Sends a console [message].
 */
fun Any.sendConsoleMessage(message: String) {
    Sponge.getServer().console.sendMessage(message.translateToText())
}

/**
 * Is this the pet entity?
 */
fun Entity.isPetOfPlayer(player: Player): Boolean {
    try {
        val petblock = PetBlocksManager.petBlocksManager!!.petBlockController.getFromPlayer(player)
        if (petblock.isPresent) {
            val block = petblock.get()
            if (block.armorStand != null && block.engineEntity != null && (block.armorStand == this || block.engineEntity == this)) {
                return true
            }
        }
    } catch (ignored: Exception) {
    }

    return false
}

/**
 * Returns if this entity is a pet.
 */
fun Entity.isPet(): Boolean {
    try {
        for (block in PetBlocksManager.petBlocksManager!!.petBlockController.all) {
            if (block?.armorStand != null && block.engineEntity != null && (block.armorStand == this || block.engineEntity == this)) {
                return true
            }
        }
    } catch (ignored: Exception) {
    }

    return false
}

/**
 * Updates the inventory of the player.
 */
fun CarriedInventory<*>.updateInventory() {
    ReflectionCache.updateInventoryMethod.invoke(null, this.carrier.get())
}

/**
 * Kotlin resolve syntactic sugar.
 */
inline fun <reified S> PetBlocksPlugin.resolve(): S {
    return this.resolve(S::class.java)
}

/**
 * Sets the item in the players arm.
 */
fun CarriedInventory<*>.setItemStackInHand(itemStack: ItemStack?, offHand: Boolean = false) {
    if (!this.carrier.isPresent || this.carrier.get() !is Player) {
        throw IllegalArgumentException("Inventory is not the inventory of a SpongePlayer!")
    }

    if (offHand) {
        (this.carrier.get() as Player).setItemInHand(HandTypes.OFF_HAND, itemStack)
    } else {
        (this.carrier.get() as Player).setItemInHand(HandTypes.MAIN_HAND, itemStack)
    }
}

/**
 * Gets the item in the players arm.
 */
fun CarriedInventory<*>.getItemStackInHand(offHand: Boolean = false): Optional<ItemStack> {
    if (!this.carrier.isPresent || this.carrier.get() !is Player) {
        throw IllegalArgumentException("Inventory is not the inventory of a SpongePlayer!")
    }

    return if (offHand) {
        (this.carrier.get() as Player).getItemInHand(HandTypes.OFF_HAND)
    } else {
        (this.carrier.get() as Player).getItemInHand(HandTypes.MAIN_HAND)
    }
}


/**
 * Sends the player the given message.
 */
fun Player.sendMessage(message: ChatMessage) {
    val components = message.components

    if (components.isEmpty()) {
        throw IllegalArgumentException("Components amount of message is 0. Are you not using the parent component?")
    }

    val finalMessage = StringBuilder()
    val cache = StringBuilder()
    finalMessage.append("{\"text\": \"\"")
    finalMessage.append(", \"extra\" : [")
    var firstExtra = false
    for (component in components) {

        if (component !is ChatColor && firstExtra) {
            finalMessage.append(", ")
        }

        when (component) {
            is ChatColor -> cache.append(component)
            is String -> {
                finalMessage.append("{\"text\": \"")
                finalMessage.append(ChatColor.translateChatColorCodes('&', cache.toString() + component))
                finalMessage.append("\"}")
                cache.setLength(0)
                firstExtra = true
            }
            else -> {
                finalMessage.append(component)
                firstExtra = true
            }
        }
    }
    finalMessage.append("]}")

    val playerResult = arrayOfNulls<Player>(1)
    playerResult[0] = this

    ReflectionCache.sendChatJsonMesssageMethod.invoke(null, finalMessage.toString(), playerResult)
}
/**
 * Unloads the given plugin.
 */
fun Game.unloadPlugin(plugin: Any) {
    Sponge.getGame().eventManager.unregisterPluginListeners(plugin)
    Sponge.getGame().commandManager.getOwnedBy(plugin).forEach(Consumer { Sponge.getGame().commandManager.removeMapping(it) })
    Sponge.getGame().scheduler.getScheduledTasks(plugin).forEach(Consumer { it.cancel() })
}

fun PluginContainer.getResource(name: String): InputStream {
    return this.getAsset(name).get().url.openStream()
}

fun PetMeta.setCostume(petBlock: PetBlock<Player, Transform<World>>?, container: GUIItemContainer<Player>?) {
    if (container == null)
        return
    setSkin(container.itemId, container.itemDamage, container.skin, container.isItemUnbreakable)
    petBlock?.respawn()
}

/**
 * Executes the given [f] for the given [plugin] on main thread.
 */
inline fun Any.sync(plugin: Any, delayTicks: Long = 0L, repeatingTicks: Long = 0L, crossinline f: () -> Unit) {
    val builder = Task.builder().execute(Runnable {
        f.invoke()
    }).delayTicks(delayTicks)

    if (repeatingTicks > 0) {
        builder.intervalTicks(repeatingTicks)
    }

    builder.submit(plugin)
}

/**
 * Executes the given [f] for the given [plugin] asynchronly.
 */
inline fun Any.async(plugin: Any, delayTicks: Long = 0L, repeatingTicks: Long = 0L, crossinline f: () -> Unit) {
    val builder = Task.builder().async().execute(Runnable {
        f.invoke()
    }).delayTicks(delayTicks)

    if (repeatingTicks > 0) {
        builder.intervalTicks(repeatingTicks)
    }

    builder.submit(plugin)
}

fun Inventory.setItem(index: Int, itemStack: ItemStack) {
    if (index == 0) {
        this.query<Inventory>(GridInventory::class.java)
                .query<Inventory>(SlotPos.of(0, 0)).set(itemStack)
    } else {
        this.query<Inventory>(GridInventory::class.java)
                .query<Inventory>(SlotIndex.of(index)).set(itemStack)
    }
}

fun Inventory.getItem(index: Int): ItemStack? {
    val optItemStack: Optional<ItemStack> = if (index == 0) {
        this.query<Inventory>(GridInventory::class.java)
                .query<Inventory>(SlotPos.of(0, 0)).peek()
    } else {
        this.query<Inventory>(GridInventory::class.java)
                .query<Inventory>(SlotIndex.of(index)).peek()
    }

    if (optItemStack.isPresent) {
        return optItemStack.get()
    }

    return null
}

fun PetMeta.setEngine(petBlock: PetBlock<Player, Transform<World>>?, engineContainer: EngineContainer<GUIItemContainer<Player>>?) {
    if (engineContainer == null)
        return
    setEngine(engineContainer)
    if (Config.getInstance<Any>().isCopySkinEnabled) {
        val container = engineContainer.guiItem
        setSkin(container.itemId, container.itemDamage, container.skin, container.isItemUnbreakable)
    }
    petBlock?.respawn()
}

fun PetMeta.rename(petBlock: PetBlock<Player, Transform<World>>?, name: String) {
    this.petDisplayName = name
    petBlock?.respawn()
}

fun ItemStack.getDisplayName(): String? {
    val optDisplay = this.get(org.spongepowered.api.data.key.Keys.DISPLAY_NAME)
    if (optDisplay.isPresent) {
        return optDisplay.get().translateToString()
    }
    return null
}


/**
 * Sets the particleEffect for the given petMeta and petblock.
 *
 * @param petBlock  petblock
 * @param container container
 */
fun PetMeta.setParticleEffect(petBlock: PetBlock<Player, Transform<World>>?, container: GUIItemContainer<Player>?) {
    if (container == null)
        return
    val transferOpt = Config.getInstance<Any>().particleController.getFromItem(container as GUIItemContainer<Any>)
    if (!transferOpt.isPresent)
        return
    val transfer = transferOpt.get()
    particleEffectMeta.type = transfer.type
    particleEffectMeta.speed = transfer.speed
    particleEffectMeta.amount = transfer.amount
    particleEffectMeta.offSetX = transfer.offSetX
    particleEffectMeta.offSetY = transfer.offSetY
    particleEffectMeta.offSetZ = transfer.offSetZ
    particleEffectMeta.materialName = transfer.materialName
    particleEffectMeta.data = transfer.data
    petBlock?.respawn()
}

/**
 * Tries to return the [ParticleType] from the given [name].
 */
fun String.toParticleType(): ParticleType {
    val version = VersionSupport.getServerVersion()

    ParticleType.values().forEach { p ->
        if (p.gameId_18.equals(this, true) || p.gameId_113.equals(this, true) || p.name.equals(this, true)) {
            if (version.isVersionSameOrGreaterThan(VersionSupport.fromVersion(Version.VERSION_1_12_R1))) {
                return p
            }
        }
    }

    throw IllegalArgumentException("ParticleType cannot be parsed from '" + this + "'.")
}


fun Player.hasPermissions(permission: Permission, vararg placeholder: String): Boolean {
    for (s in permission.permission) {
        var perm = s
        for (i in placeholder.indices) {
            val plc = "$$i"
            perm = perm.replace(plc, placeholder[i])
        }
        if (this.hasPermission(perm)) {
            return true
        }
    }
    return false
}

fun PetMeta.setSkin(petBlock: PetBlock<Player, Transform<World>>?, skin: String) {
    var skinHelper = skin
    if (skinHelper.contains("textures.minecraft") && !skinHelper.contains("http://")) {
        skinHelper = "http://$skin"
    }
    setSkin(CompatibilityItemType.SKULL_ITEM.id, 3, skinHelper, false)
    petBlock?.respawn()
}

fun Array<String?>.translateToTexts(): Array<Text?> {
    val copy = arrayOfNulls<Text>(this.size)
    this.forEachIndexed { i, p ->
        copy[i] = this[i]!!.translateToText()
    }
    return copy
}

fun Array<Text?>.translateToStrings(): Array<String?> {
    val copy = arrayOfNulls<String>(this.size)
    this.forEachIndexed { i, p ->
        copy[i] = this[i]!!.translateToString()
    }
    return copy
}

/**
 * Updates the inventory of the player.
 */
fun Player.updateInventory() {
    ReflectionCache.updateInventoryMethod.invoke(null, this)
}

fun Player.sendMessage(text: String) {
    sendMessage(text.translateToText())
}

fun CommandSource.sendMessage(text: String) {
    sendMessage(text.translateToText())
}

fun String.translateToText(): Text {
    return TextSerializers.LEGACY_FORMATTING_CODE.deserialize(ChatColor.translateChatColorCodes('&', this))
}

fun Text.translateToString(): String {
    return TextSerializers.LEGACY_FORMATTING_CODE.serialize(this)
}

fun String.findServerVersion(): String {
    return this.replace("VERSION", VersionSupport.getServerVersion().versionText)
}

/**
 * Sets the [skin] of the [ItemStack].
 */
fun ItemStack.setSkin(skin: String) {
    if (skin.contains("textures.minecraft.net")) {
        var helpSkin = skin
        if (!helpSkin.startsWith("http://")) {
            helpSkin = "http://$helpSkin"
        }
        ReflectionCache.setSkinUrlMethod.invoke(null, this, helpSkin)
    } else {
        ReflectionCache.setSkinOwnerMethod.invoke(null, this, skin)
    }
}

private object ReflectionCache {
    val utilsClass = Class.forName("com.github.shynixn.petblocks.sponge.nms.VERSION.NMSUtils".findServerVersion())
    val setDamageMethod = utilsClass.getDeclaredMethod("setItemDamage", ItemStack::class.java, Int::class.java)
    val updateInventoryMethod = utilsClass.getDeclaredMethod("updateInventoryFor", Player::class.java)
    val setSkinUrlMethod = utilsClass.getDeclaredMethod("setItemSkin", ItemStack::class.java, String::class.java)
    val setSkinOwnerMethod = utilsClass.getDeclaredMethod("setItemOwner", ItemStack::class.java, String::class.java)
    val setUnbreakableMethod = utilsClass.getDeclaredMethod("setItemUnbreakableTag", ItemStack::class.java, Boolean::class.java)
    val sendChatJsonMesssageMethod = utilsClass.getDeclaredMethod("sendJsonChatMessage", String::class.java, Array<Player>::class.java)
}

/**
 * Sets the itemstack unbreakable.
 */
fun ItemStack.setUnbreakable(unbreakable: Boolean) {
    ReflectionCache.setUnbreakableMethod.invoke(null, this, unbreakable)
}

/**
 * Sets the displayname of the itemstack.
 */
fun ItemStack.setDisplayName(text: String) {
    this.offer(org.spongepowered.api.data.key.Keys.DISPLAY_NAME, text.translateToText())
}

/**
 * Sets the damage of the itemstack.
 */
fun ItemStack.setDamage(damage: Int) {
    ReflectionCache.setDamageMethod!!.invoke(null, this, damage)
}

/**
 * Sets the lore of the itemstack.
 */
fun ItemStack.setLore(data: Array<String>) {
    this.offer(org.spongepowered.api.data.key.Keys.ITEM_LORE, (data as Array<String?>).translateToTexts().toList())
}

/**
 * Gets the lore of the itemstack.
 */
fun ItemStack.getLore(): Array<String> {
    if (this.get(org.spongepowered.api.data.key.Keys.ITEM_LORE).isPresent) {
        return this.get(org.spongepowered.api.data.key.Keys.ITEM_LORE).get().toTypedArray().translateToStrings() as Array<String>
    }
    return emptyArray()
}