package com.github.cao.awa.kalmia.framework.serialize.json.type.primitive;

import com.alibaba.fastjson2.JSONObject;
import com.github.cao.awa.kalmia.annotations.auto.serializer.AutoJsonSerializer;
import com.github.cao.awa.kalmia.framework.serialize.json.JsonSerializer;

@AutoJsonSerializer(target = {Float.class, float.class})
public class JsonFloatSerializer implements JsonSerializer<Float> {
    @Override
    public void serialize(JSONObject json, String key, Float target) {
        json.put(key,
                 target
        );
    }

    @Override
    public Float deserialize(JSONObject json, String key) {
        return json.getFloat(key);
    }
}
