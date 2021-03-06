package com.github.shynixn.petblocks.api.persistence.entity

import java.util.*

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
interface GUIItem {

    /** Returns a executable script */
    val executingScript: Optional<String>

    /** Returns the item displayName. */
    val displayName: String

    /** Returns the type of the item. */
    val type: Int

    /** Returns the data of the item. */
    val data: Int

    /** Returns the lore of the item. */
    val lore: List<String>

    /** Returns the skin of the item. */
    val skin: String

    /** Returns if this item is enabled. */
    val enabled: Boolean

    /** Returns the position in the inventory. */
    val position: Int

    /** Returns if the item is unbreakable. */
    val unbreakable: Boolean

    /** Returns an itemStack from the given item. */
    fun <I> toItemStack(): I
}