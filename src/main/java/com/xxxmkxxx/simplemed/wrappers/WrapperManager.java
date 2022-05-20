package com.xxxmkxxx.simplemed.common.wrappers;

import java.util.ArrayList;
import java.util.List;

public class WrapperManager<W, M> {
    public List<W> convertModelList(List<M> models, WrapperConverter converter) {
        List<W> wrappers = new ArrayList<>();

        for (M model : models) {
            wrappers.add((W) converter.convert(model));
        }

        return wrappers;
    }

    @FunctionalInterface
    public interface WrapperConverter<W, M> {
        W convert(M model);
    }
}
