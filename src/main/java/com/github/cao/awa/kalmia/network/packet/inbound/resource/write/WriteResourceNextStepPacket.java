package com.github.cao.awa.kalmia.network.packet.inbound.resource.write;

import com.github.cao.awa.apricot.annotations.auto.Auto;
import com.github.cao.awa.apricot.io.bytes.reader.BytesReader;
import com.github.cao.awa.kalmia.annotations.actor.Getter;
import com.github.cao.awa.kalmia.annotations.auto.event.network.NetworkEventTarget;
import com.github.cao.awa.kalmia.annotations.auto.network.unsolve.AutoData;
import com.github.cao.awa.kalmia.annotations.auto.network.unsolve.AutoSolvedPacket;
import com.github.cao.awa.kalmia.annotations.inaction.DoNotSet;
import com.github.cao.awa.kalmia.event.kalmiagram.network.inbound.resource.write.WriteResourceNextStepEvent;
import com.github.cao.awa.kalmia.network.handler.inbound.AuthedRequestHandler;
import com.github.cao.awa.kalmia.network.packet.Packet;

@AutoSolvedPacket(id = 300001, crypto = true)
@NetworkEventTarget(WriteResourceNextStepEvent.class)
public class WriteResourceNextStepPacket extends Packet<AuthedRequestHandler> {
    @AutoData
    @DoNotSet
    private boolean expectStop;

    public WriteResourceNextStepPacket(boolean expectStop) {
        this.expectStop = expectStop;
    }

    @Auto
    public WriteResourceNextStepPacket(BytesReader reader) {
        super(reader);
    }

    @Getter
    public boolean expectStop() {
        return this.expectStop;
    }
}
