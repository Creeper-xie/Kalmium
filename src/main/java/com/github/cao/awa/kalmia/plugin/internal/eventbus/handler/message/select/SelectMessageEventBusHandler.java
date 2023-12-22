package com.github.cao.awa.kalmia.plugin.internal.eventbus.handler.message.select;

import com.github.cao.awa.kalmia.identity.PureExtraIdentity;
import com.github.cao.awa.kalmia.network.router.kalmia.RequestRouter;
import com.github.cao.awa.kalmia.plugin.internal.eventbus.handler.EventBusHandler;

public interface SelectMessageEventBusHandler extends EventBusHandler {
    void handle(RequestRouter router, byte[] receipt, PureExtraIdentity sessionId, long from, long to);
}
