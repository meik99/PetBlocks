package com.github.shynixn.petblocks.api.business.service

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
interface GUIService {

    /**
     * Opens the gui for the given [player]. Does nothing when the GUI is already open.
     */
    fun <P> open(player: P)

    /**
     * Closes the gui for the given [player]. Does nothing when the GUI is already closed.
     */
    fun <P> close(player: P)

    /**
     * Returns if the given [inventory] matches the inventory of this service.
     */
    fun <I> isGUIInventory(inventory: I): Boolean

    /**
     * Clears all resources the given player has allocated from this service.
     */
    fun <P> cleanResources(player: P)

    /**
     * Scrolls the loaded collection page of a [player] the given [amountOfSlots] to the right when entered a positive value.
     * Scrolls to the left when given a negative amount of Slots value.
     */
    fun <P> scrollCollectionPage(player: P, amountOfSlots: Int)

    /**
     * Executes actions when the given [player] clicks on an [item] at the given [relativeSlot].
     */
    fun <P, I> clickInventoryItem(player: P, relativeSlot: Int, item: I)

    /**
     * Loads the collection from the given [path] into the given [inventory].
     */
    fun <I> loadCollectionPage(inventory: I, path: String, permission: String? = null)
}