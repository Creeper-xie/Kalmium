package com.github.cao.awa.kalmia.framework.serialize.bytes.type.primitive;

import com.github.cao.awa.apricot.io.bytes.reader.BytesReader;
import com.github.cao.awa.kalmia.annotations.auto.serializer.AutoBytesSerializer;
import com.github.cao.awa.kalmia.framework.serialize.bytes.BytesSerializer;
import com.github.cao.awa.kalmia.mathematic.base.Base256;

@AutoBytesSerializer(value = 3, target = {Short.class, short.class})
public class BytesShortSerializer implements BytesSerializer<Short> {
    @Override
    public byte[] serialize(Short s) {
        return Base256.tagToBuf(s);
    }

    @Override
    public Short deserialize(BytesReader reader) {
        return (short) Base256.tagFromBuf(reader.read(2));
    }
}
