package com.github.cao.awa.kalmia.framework.serialize.bytes.type.primitive;

import com.github.cao.awa.apricot.io.bytes.reader.BytesReader;
import com.github.cao.awa.kalmia.annotations.auto.serializer.AutoBytesSerializer;
import com.github.cao.awa.kalmia.framework.serialize.bytes.BytesSerializer;
import com.github.cao.awa.kalmia.mathematic.base.Base256;

@AutoBytesSerializer(value = 2, target = {Character.class, char.class})
public class BytesCharSerializer implements BytesSerializer<Character> {
    @Override
    public byte[] serialize(Character c) {
        return Base256.tagToBuf(c);
    }

    @Override
    public Character deserialize(BytesReader reader) {
        return (char) Base256.tagFromBuf(reader.read(2));
    }
}
