package com.xxxmkxxx.simplemed.common;

import java.util.ArrayList;
import java.util.List;

public class ModelConverterManager<D, M> {
    public List<D> convertModelList(List<M> models, Converter converter) {
        List<D> wrappers = new ArrayList<>();

        for (M model : models) {
            wrappers.add((D) converter.convert(model));
        }

        return wrappers;
    }

    @FunctionalInterface
    public interface Converter<D, M> {
        D convert(M model);
    }
}
