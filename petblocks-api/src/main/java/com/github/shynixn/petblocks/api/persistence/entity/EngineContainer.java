package com.github.shynixn.petblocks.api.persistence.entity;

import com.github.shynixn.petblocks.api.business.enumeration.RideType;

import java.util.Optional;

/**
 * Properties of engines.
 * <p>
 * Version 1.1
 * <p>
 * MIT License
 * <p>
 * Copyright (c) 2017 by Shynixn
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
public interface EngineContainer<T> extends Persistenceable {

    /**
     * Returns the optional default pet name for this engine.
     *
     * @return petName
     */
    Optional<String> getPetName();

    /**
     * Returns the optional default particle effect for this engine.
     *
     * @return particle effect
     */
    Optional<Particle> getParticleEffect();

    /**
     * Returns the walking sound.
     *
     * @return walkingSound
     */
    Sound getWalkingSound();

    /**
     * Returns the ambient sound.
     *
     * @return ambientSound
     */
    Sound getAmbientSound();

    /**
     * Returns the rideType.
     *
     * @return rideType
     */
    RideType getRideType();

    /**
     * Returns the entityType.
     *
     * @return entityType
     */
    String getEntityType();

    /**
     * Returns the guiItem of the engine.
     *
     * @return guiItem
     */
    T getGUIItem();
}
