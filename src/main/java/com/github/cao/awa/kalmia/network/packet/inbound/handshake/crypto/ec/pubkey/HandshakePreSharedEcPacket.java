package com.github.cao.awa.kalmia.network.packet.inbound.handshake.crypto.ec.pubkey;

import com.github.cao.awa.apricot.annotations.auto.Auto;
import com.github.cao.awa.apricot.io.bytes.reader.BytesReader;
import com.github.cao.awa.kalmia.annotations.actor.Getter;
import com.github.cao.awa.kalmia.annotations.auto.event.network.NetworkEventTarget;
import com.github.cao.awa.kalmia.annotations.auto.network.unsolve.AutoData;
import com.github.cao.awa.kalmia.annotations.auto.network.unsolve.AutoSolvedPacket;
import com.github.cao.awa.kalmia.annotations.inaction.DoNotSet;
import com.github.cao.awa.kalmia.event.kalmiagram.network.inbound.handshake.crypto.ec.pubkey.HandshakePreSharedEcEvent;
import com.github.cao.awa.kalmia.network.handler.handshake.HandshakeHandler;
import com.github.cao.awa.kalmia.network.packet.Packet;
import com.github.cao.awa.modmdo.annotation.platform.Client;
import com.github.cao.awa.modmdo.annotation.platform.Server;

@AutoSolvedPacket(id = 1, crypto = false)
@NetworkEventTarget(HandshakePreSharedEcEvent.class)
public class HandshakePreSharedEcPacket extends Packet<HandshakeHandler> {
    @AutoData
    @DoNotSet
    private String cipherField;

    @Server
    public HandshakePreSharedEcPacket(String cipherField) {
        this.cipherField = cipherField;
    }

    @Auto
    @Client
    public HandshakePreSharedEcPacket(BytesReader reader) {
        super(reader);
    }

    @Getter
    public String cipherField() {
        return this.cipherField;
    }
}
