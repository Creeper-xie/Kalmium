package com.github.cao.awa.kalmia.plugin.internal.eventbus.handler.chat.session.listeners;

import com.github.cao.awa.kalmia.network.router.kalmia.RequestRouter;
import com.github.cao.awa.kalmia.plugin.internal.eventbus.handler.EventBusHandler;
import com.github.cao.awa.kalmia.session.Session;

import java.util.List;

public interface SessionListenersUpdateEventBusHandler extends EventBusHandler {
    void handle(RequestRouter router, byte[] receipt, List<Session> sessions);
}
