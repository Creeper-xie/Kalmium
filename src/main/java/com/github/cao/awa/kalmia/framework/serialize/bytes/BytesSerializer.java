package com.github.cao.awa.kalmia.framework.serialize.bytes;

import com.github.cao.awa.apricot.annotations.auto.Auto;
import com.github.cao.awa.apricot.io.bytes.reader.BytesReader;
import com.github.cao.awa.kalmia.env.KalmiaEnv;
import com.github.zhuaidadaya.rikaishinikui.handler.universal.entrust.EntrustEnvironment;

@Auto
public interface BytesSerializer<T> {
    @Auto
    byte[] serialize(T target);

    @Auto
    T deserialize(BytesReader reader);

    default Class<T>[] target() {
        return EntrustEnvironment.cast(KalmiaEnv.bytesSerializerFramework.target(this));
    }

    default long id() {
        return KalmiaEnv.bytesSerializerFramework.id(this);
    }
}
