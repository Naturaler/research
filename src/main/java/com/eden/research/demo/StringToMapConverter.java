package com.eden.research.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.GenericConverter;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Slf4j
public class StringToMapConverter implements GenericConverter {
    @Override
    public Set<ConvertiblePair> getConvertibleTypes() {
        ConvertiblePair pair = new ConvertiblePair(String.class, Map.class);
        return Collections.singleton(pair);
    }

    @Override
    public Object convert(Object source, TypeDescriptor sourceType, TypeDescriptor targetType) {
        log.info("自定义 StringToMapConverter。source: {}", source);
        if (source == null) {
            return null;
        }
        String s = source.toString();
        String[] kv = s.split(",");
        Map<String, String> map = new HashMap<>(kv.length);
        for (String item : kv) {
            String[] pair = item.split(":");
            map.put(pair[0], pair[1]);
        }
        return map;
    }
}
