package com.github.cao.awa.kalmia.network.handler.inbound;

import com.github.cao.awa.apricot.util.collection.ApricotCollectionFactor;
import com.github.cao.awa.kalmia.identity.LongAndExtraIdentity;
import com.github.cao.awa.kalmia.network.handler.PacketHandler;
import com.github.cao.awa.kalmia.network.packet.Packet;
import com.github.cao.awa.kalmia.network.router.kalmia.RequestRouter;
import com.github.cao.awa.kalmia.network.router.kalmia.status.RequestState;
import com.github.zhuaidadaya.rikaishinikui.handler.universal.entrust.EntrustEnvironment;

import java.util.Set;

public class AuthedRequestHandler extends PacketHandler<AuthedRequestHandler> {
    private static final Set<RequestState> ALLOW_STATUS = EntrustEnvironment.operation(ApricotCollectionFactor.hashSet(),
                                                                                       set -> {
                                                                                           set.add(RequestState.AUTHED);
                                                                                       }
    );

    private LongAndExtraIdentity accessIdentity;

    public LongAndExtraIdentity accessIdentity() {
        return this.accessIdentity;
    }

    public void accessIdentity(LongAndExtraIdentity accessIdentity) {
        this.accessIdentity = accessIdentity;
    }

    @Override
    public void inbound(Packet<AuthedRequestHandler> packet, RequestRouter router) {
        packet.inbound(router,
                       this
        );
    }

    @Override
    public Set<RequestState> allowStates() {
        return ALLOW_STATUS;
    }
}
