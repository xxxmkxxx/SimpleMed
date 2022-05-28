package com.xxxmkxxx.simplemed.common;

import java.util.ArrayList;
import java.util.List;

public class ConverterManager<W, M> {
    public List<W> convertModelList(List<M> models, Converter converter) {
        List<W> wrappers = new ArrayList<>();

        for (M model : models) {
            wrappers.add((W) converter.convert(model));
        }

        return wrappers;
    }

    @FunctionalInterface
    public interface Converter<W, M> {
        W convert(M model);
    }
}
