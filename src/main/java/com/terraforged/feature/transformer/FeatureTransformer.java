package com.terraforged.feature.transformer;

import com.terraforged.feature.transformer.json.JsonTransformer;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.IFeatureConfig;

import java.util.function.Function;

public interface FeatureTransformer extends Function<ConfiguredFeature<?, ?>, ConfiguredFeature<?, ?>> {

    ConfiguredFeature<?, ?> transform(ConfiguredFeature<?, ?> feature);

    default ConfiguredFeature<?, ?> apply(ConfiguredFeature<?, ?> feature) {
        return transform(feature);
    }

    static FeatureTransformer of(ConfiguredFeature<?, ?> feature) {
        return f -> feature;
    }

    static <T extends IFeatureConfig> FeatureTransformer of(Feature<T> feature, T config) {
        return of(feature.func_225566_b_(config));
    }

    static JsonTransformer.Builder builder() {
        return new JsonTransformer.Builder();
    }
}