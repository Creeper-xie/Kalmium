package com.github.cao.awa.kalmia.network.packet.inbound.message.send;

import com.github.cao.awa.apricot.annotations.auto.Auto;
import com.github.cao.awa.apricot.io.bytes.reader.BytesReader;
import com.github.cao.awa.kalmia.annotations.actor.Getter;
import com.github.cao.awa.kalmia.annotations.auto.event.network.NetworkEventTarget;
import com.github.cao.awa.kalmia.annotations.auto.network.unsolve.AutoData;
import com.github.cao.awa.kalmia.annotations.auto.network.unsolve.AutoSolvedPacket;
import com.github.cao.awa.kalmia.annotations.inaction.DoNotSet;
import com.github.cao.awa.kalmia.event.kalmiagram.network.inbound.message.send.SendMessageRefusedEvent;
import com.github.cao.awa.kalmia.network.handler.inbound.AuthedRequestHandler;
import com.github.cao.awa.kalmia.network.packet.Packet;
import com.github.cao.awa.modmdo.annotation.platform.Client;
import com.github.cao.awa.modmdo.annotation.platform.Server;

@AutoSolvedPacket(id = 102, crypto = true)
@NetworkEventTarget(SendMessageRefusedEvent.class)
public class SendMessageRefusedPacket extends Packet<AuthedRequestHandler> {
    @AutoData
    @DoNotSet
    private String reason;

    @Server
    public SendMessageRefusedPacket(String reason) {
        this.reason = reason;
    }

    @Auto
    @Client
    public SendMessageRefusedPacket(BytesReader reader) {
        super(reader);
    }

    @Getter
    public String reason() {
        return this.reason;
    }
}
