package com.xxxmkxxx.simplemed.features.mapper;

import com.xxxmkxxx.simplemed.features.mapper.converters.Converter;

public record ModelConverterManager<D>(Converter<D> converter) {
    public D createDTO() {
        return converter.convert();
    }
}
