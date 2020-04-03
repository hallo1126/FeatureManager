package com.terraforged.feature.transformer;

import net.minecraft.world.gen.feature.ConfiguredFeature;

public class FeatureInserter {

    private final Type type;
    private final ConfiguredFeature<?, ?> feature;

    public FeatureInserter(ConfiguredFeature<?, ?> feature, Type type) {
        this.feature = feature;
        this.type = type;
    }

    public ConfiguredFeature<?, ?> getFeature() {
        return feature;
    }

    public Type getType() {
        return type;
    }

    public enum Type {
        BEFORE,
        AFTER,
    }
}
