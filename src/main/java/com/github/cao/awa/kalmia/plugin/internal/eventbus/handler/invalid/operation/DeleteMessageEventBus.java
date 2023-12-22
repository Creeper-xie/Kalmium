package com.github.cao.awa.kalmia.plugin.internal.eventbus.handler.invalid.operation;

import com.github.cao.awa.apricot.annotations.auto.Auto;
import com.github.cao.awa.kalmia.event.kalmiagram.handler.network.inbound.message.delete.DeleteMessageEventHandler;
import com.github.cao.awa.kalmia.network.packet.inbound.message.delete.DeleteMessagePacket;
import com.github.cao.awa.kalmia.network.router.kalmia.RequestRouter;
import com.github.cao.awa.kalmia.plugin.internal.eventbus.EventBus;
import com.github.cao.awa.modmdo.annotation.platform.Server;

public class DeleteMessageEventBus extends EventBus<DeleteMessageEventBusHandler> implements DeleteMessageEventHandler {
    @Auto
    @Server
    @Override
    public void handle(RequestRouter router, DeleteMessagePacket packet) {
        trigger(handler -> handler.handle(router,
                                          packet.receipt(),
                                          packet.sessionIdentity(),
                                          packet.seq()
        ));
    }
}
