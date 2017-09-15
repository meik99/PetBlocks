package com.github.shynixn.petblocks.business.logic.business.configuration;

import com.github.shynixn.petblocks.api.business.entity.GUIItemContainer;
import com.github.shynixn.petblocks.api.persistence.controller.ParticleController;
import com.github.shynixn.petblocks.api.persistence.entity.ParticleEffectMeta;
import com.github.shynixn.petblocks.business.logic.business.entity.ItemContainer;
import com.github.shynixn.petblocks.business.logic.persistence.entity.ParticleEffectData;
import org.bukkit.Bukkit;
import org.bukkit.configuration.MemorySection;
import org.bukkit.plugin.Plugin;

import java.io.Closeable;
import java.util.*;
import java.util.logging.Level;

/**
 * Copyright 2017 Shynixn
 * <p>
 * Do not remove this header!
 * <p>
 * Version 1.0
 * <p>
 * MIT License
 * <p>
 * Copyright (c) 2017
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
public class ParticleConfiguration implements ParticleController {

    private Plugin plugin;
    private final Map<GUIItemContainer, ParticleEffectMeta> particleCache = new HashMap<>();

    /**
     * Initializes a new engine repository
     *
     * @param plugin plugin
     */
    public ParticleConfiguration(Plugin plugin) {
        if (plugin == null)
            throw new IllegalArgumentException("Plugin cannot be null!");
        this.plugin = plugin;
    }

    /**
     * Stores a new a item in the repository
     *
     * @param item item
     */
    @Override
    public void store(GUIItemContainer item) {
        throw new RuntimeException("Not implemented!");
    }

    /**
     * Removes an item from the repository
     *
     * @param item item
     */
    @Override
    public void remove(GUIItemContainer item) {
        if (this.particleCache.containsKey(item)) {
            this.particleCache.remove(item);
        }
    }

    /**
     * Returns the amount of items in the repository
     *
     * @return size
     */
    @Override
    public int size() {
        return this.particleCache.size();
    }

    /**
     * Returns all items from the repository as unmodifiableList
     *
     * @return items
     */
    @Override
    public List<GUIItemContainer> getAll() {
        final List<GUIItemContainer> containers = new ArrayList<>(this.particleCache.keySet());
        containers.sort((o1, o2) -> new Integer(o1.getPosition()).compareTo(o2.getPosition()));
        return containers;
    }

    /**
     * Returns the container by the given order id
     *
     * @param id id
     * @return container
     */
    @Override
    public GUIItemContainer getContainerByPosition(int id) {
        for (final GUIItemContainer guiItemContainer : this.particleCache.keySet()) {
            if (guiItemContainer.getPosition() == id) {
                return guiItemContainer;
            }
        }
        return null;
    }

    /**
     * Returns the particleEffect by the given container
     *
     * @param container container
     * @return particleEffect
     */
    @Override
    public ParticleEffectMeta getByItem(GUIItemContainer container) {
        if (this.particleCache.containsKey(container)) {
            return this.particleCache.get(container);
        }
        return null;
    }

    /**
     * Reloads the content from the fileSystem
     */
    @Override
    public void reload() {
        this.particleCache.clear();
        this.plugin.reloadConfig();
        final Map<String, Object> data = ((MemorySection) this.plugin.getConfig().get("particles")).getValues(false);
        for (final String key : data.keySet()) {
            try {
                final GUIItemContainer container = new ItemContainer(Integer.parseInt(key), ((MemorySection) data.get(key)).getValues(false));
                final ParticleEffectMeta meta = new ParticleEffectData(((MemorySection) ((MemorySection) data.get(key)).getValues(false).get("effect")).getValues(true));
                this.particleCache.put(container, meta);
            } catch (final Exception e) {
                Bukkit.getLogger().log(Level.WARNING, "Failed to load particle " + key + ".", e);
            }
        }
    }

    /**
     * Closes this resource, relinquishing any underlying resources.
     * This method is invoked automatically on objects managed by the
     * {@code try}-with-resources statement.
     * <p>
     * <p>While this interface method is declared to throw {@code
     * Exception}, implementers are <em>strongly</em> encouraged to
     * declare concrete implementations of the {@code close} method to
     * throw more specific exceptions, or to throw no exception at all
     * if the close operation cannot fail.
     * <p>
     * <p> Cases where the close operation may fail require careful
     * attention by implementers. It is strongly advised to relinquish
     * the underlying resources and to internally <em>mark</em> the
     * resource as closed, prior to throwing the exception. The {@code
     * close} method is unlikely to be invoked more than once and so
     * this ensures that the resources are released in a timely manner.
     * Furthermore it reduces problems that could arise when the resource
     * wraps, or is wrapped, by another resource.
     * <p>
     * <p><em>Implementers of this interface are also strongly advised
     * to not have the {@code close} method throw {@link
     * InterruptedException}.</em>
     * <p>
     * This exception interacts with a thread's interrupted status,
     * and runtime misbehavior is likely to occur if an {@code
     * InterruptedException} is {@linkplain Throwable#addSuppressed
     * suppressed}.
     * <p>
     * More generally, if it would cause problems for an
     * exception to be suppressed, the {@code AutoCloseable.close}
     * method should not throw it.
     * <p>
     * <p>Note that unlike the {@link Closeable#close close}
     * method of {@link Closeable}, this {@code close} method
     * is <em>not</em> required to be idempotent.  In other words,
     * calling this {@code close} method more than once may have some
     * visible side effect, unlike {@code Closeable.close} which is
     * required to have no effect if called more than once.
     * <p>
     * However, implementers of this interface are strongly encouraged
     * to make their {@code close} methods idempotent.
     *
     * @throws Exception if this resource cannot be closed
     */
    @Override
    public void close() throws Exception {
        this.plugin = null;
        this.particleCache.clear();
    }
}