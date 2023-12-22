package com.github.cao.awa.kalmia.network.packet.inbound.key.select;

import com.github.cao.awa.apricot.annotations.auto.Auto;
import com.github.cao.awa.apricot.io.bytes.reader.BytesReader;
import com.github.cao.awa.apricot.util.collection.ApricotCollectionFactor;
import com.github.cao.awa.kalmia.annotations.actor.Getter;
import com.github.cao.awa.kalmia.annotations.auto.event.network.NetworkEventTarget;
import com.github.cao.awa.kalmia.annotations.auto.network.unsolve.AutoData;
import com.github.cao.awa.kalmia.annotations.auto.network.unsolve.AutoSolvedPacket;
import com.github.cao.awa.kalmia.annotations.inaction.DoNotSet;
import com.github.cao.awa.kalmia.event.kalmiagram.network.inbound.key.select.SelectKeyStoreEvent;
import com.github.cao.awa.kalmia.identity.PureExtraIdentity;
import com.github.cao.awa.kalmia.network.handler.inbound.AuthedRequestHandler;
import com.github.cao.awa.kalmia.network.packet.Packet;
import com.github.cao.awa.modmdo.annotation.platform.Client;
import com.github.cao.awa.modmdo.annotation.platform.Server;

import java.util.List;

@AutoSolvedPacket(id = 150, crypto = true)
@NetworkEventTarget(SelectKeyStoreEvent.class)
public class SelectKeyStorePacket extends Packet<AuthedRequestHandler> {
    @AutoData
    @DoNotSet
    private List<PureExtraIdentity> keyIdentities;

    @Client
    public SelectKeyStorePacket(List<PureExtraIdentity> keyIdentities) {
        this.keyIdentities = keyIdentities;
    }

    @Client
    public SelectKeyStorePacket(PureExtraIdentity id) {
        this.keyIdentities = ApricotCollectionFactor.arrayList();
        this.keyIdentities.add(id);
    }

    @Auto
    @Server
    public SelectKeyStorePacket(BytesReader reader) {
        super(reader);
    }

    @Getter
    public List<PureExtraIdentity> keyIdentities() {
        return this.keyIdentities;
    }
}
