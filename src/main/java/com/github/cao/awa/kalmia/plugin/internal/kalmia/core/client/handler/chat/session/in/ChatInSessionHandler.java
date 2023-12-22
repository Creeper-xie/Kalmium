package com.github.cao.awa.kalmia.plugin.internal.kalmia.core.client.handler.chat.session.in;

import com.github.cao.awa.apricot.annotations.auto.Auto;
import com.github.cao.awa.kalmia.annotations.plugin.PluginRegister;
import com.github.cao.awa.kalmia.event.kalmiagram.handler.network.inbound.chat.session.in.ChatInSessionEventHandler;
import com.github.cao.awa.kalmia.network.packet.inbound.chat.session.in.ChatInSessionPacket;
import com.github.cao.awa.kalmia.network.router.kalmia.RequestRouter;
import com.github.cao.awa.modmdo.annotation.platform.Client;

@Auto
@Client
@PluginRegister(name = "kalmia_client")
public class ChatInSessionHandler implements ChatInSessionEventHandler {
    @Auto
    @Client
    @Override
    public void handle(RequestRouter router, ChatInSessionPacket packet) {
        System.out.println("Requested session for " + packet.targetUser() + ": " + packet.sessionIdentity());
    }
}
