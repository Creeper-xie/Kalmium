package com.github.cao.awa.kalmia.plugin.internal.kalmia.core.server.handler.chat.session.request;

import com.github.cao.awa.apricot.annotations.auto.Auto;
import com.github.cao.awa.apricot.identifier.BytesRandomIdentifier;
import com.github.cao.awa.kalmia.annotations.plugin.PluginRegister;
import com.github.cao.awa.kalmia.bootstrap.Kalmia;
import com.github.cao.awa.kalmia.event.kalmiagram.handler.network.inbound.chat.session.request.RequestDuetSessionEventHandler;
import com.github.cao.awa.kalmia.identity.LongAndExtraIdentity;
import com.github.cao.awa.kalmia.identity.PureExtraIdentity;
import com.github.cao.awa.kalmia.network.handler.inbound.AuthedRequestHandler;
import com.github.cao.awa.kalmia.network.packet.inbound.chat.session.in.ChatInSessionPacket;
import com.github.cao.awa.kalmia.network.packet.inbound.chat.session.request.RequestDuetSessionPacket;
import com.github.cao.awa.kalmia.network.router.kalmia.RequestRouter;
import com.github.cao.awa.kalmia.session.SessionAccessibleData;
import com.github.cao.awa.kalmia.session.duet.DuetSession;
import com.github.cao.awa.modmdo.annotation.platform.Server;

@Auto
@Server
@PluginRegister(name = "kalmia_core")
public class RequestDuetSessionHandler implements RequestDuetSessionEventHandler {
    @Auto
    @Server
    @Override
    public void handle(RequestRouter router, RequestDuetSessionPacket packet) {
        LongAndExtraIdentity targetIdentity = packet.targetUser();
        AuthedRequestHandler handler = packet.handler();

        PureExtraIdentity sessionIdentity = Kalmia.SERVER.userManager()
                                                         .duetSession(handler.accessIdentity(),
                                                                      targetIdentity
                                                         );
        if (sessionIdentity == null) {
            sessionIdentity = Kalmia.SERVER.sessionManager()
                                           .add(new DuetSession(PureExtraIdentity.create(BytesRandomIdentifier.create(16)),
                                                                handler.accessIdentity(),
                                                                targetIdentity
                                           ));

            // Update session data.
            Kalmia.SERVER.userManager()
                         .duetSession(handler.accessIdentity(),
                                      targetIdentity,
                                      sessionIdentity
                         );

            // Update accessible.
            Kalmia.SERVER.sessionManager()
                         .updateAccessible(
                                 sessionIdentity,
                                 handler.accessIdentity(),
                                 SessionAccessibleData :: accessibleChat
                         );
            Kalmia.SERVER.sessionManager()
                         .updateAccessible(
                                 sessionIdentity,
                                 targetIdentity,
                                 SessionAccessibleData :: accessibleChat
                         );
        }

        router.send(new ChatInSessionPacket(
                targetIdentity,
                sessionIdentity
        ));
    }
}
