package com.github.shynixn.petblocks.core.logic.persistence.entity;

import com.github.shynixn.petblocks.api.business.entity.GUIItemContainer;
import com.github.shynixn.petblocks.api.business.enumeration.RideType;
import com.github.shynixn.petblocks.api.persistence.entity.EngineContainer;
import com.github.shynixn.petblocks.api.persistence.entity.Particle;
import com.github.shynixn.petblocks.api.persistence.entity.Sound;

import java.util.Optional;

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
public abstract class EngineData<Player> extends PersistenceObject implements EngineContainer<GUIItemContainer<Player>> {

    protected GUIItemContainer<Player> itemContainer;

    protected String entity;
    protected RideType rideType;

    protected Sound ambientSound;
    protected Sound walkingSound;

    protected String petName;

    protected ParticleEntity particleEffectMeta;

    /**
     * Initializes a new engine data
     *
     * @param id id.
     */
    public EngineData(long id) {
        super();
        this.setId(id);
    }

    /**
     * Returns the optional default pet name for this engine.
     *
     * @return petName
     */
    @Override
    public Optional<String> getPetName() {
        if (this.petName == null) {
            return Optional.empty();
        }

        return Optional.of(this.petName);
    }

    /**
     * Returns the optional default particle effect for this engine.
     *
     * @return particle effect
     */
    @Override
    public Optional<Particle> getParticleEffect() {
        if (this.particleEffectMeta == null) {
            return Optional.empty();
        }

        return Optional.of(this.particleEffectMeta);
    }

    /**
     * Returns the walking sound
     *
     * @return walkingSound
     */
    @Override
    public Sound getWalkingSound() {
        return this.walkingSound;
    }

    /**
     * Returns the ambient sound
     *
     * @return ambientSound
     */
    @Override
    public Sound getAmbientSound() {
        return this.ambientSound;
    }

    /**
     * Returns the rideType
     *
     * @return rideType
     */
    @Override
    public RideType getRideType() {
        return this.rideType;
    }

    /**
     * Returns the entityType
     *
     * @return entityType
     */
    @Override
    public String getEntityType() {
        return this.entity;
    }

    /**
     * Returns the guiItem of the engine
     *
     * @return guiItem
     */
    @Override
    public GUIItemContainer<Player> getGUIItem() {
        return this.itemContainer;
    }
}
