package com.github.cao.awa.kalmia.plugin.internal.eventbus.handler.chat.session.in;

import com.github.cao.awa.kalmia.identity.LongAndExtraIdentity;
import com.github.cao.awa.kalmia.identity.PureExtraIdentity;
import com.github.cao.awa.kalmia.network.router.kalmia.RequestRouter;
import com.github.cao.awa.kalmia.plugin.internal.eventbus.handler.EventBusHandler;

public interface ChatInSessionEventBusHandler extends EventBusHandler {
    void handle(RequestRouter router, byte[] receipt, LongAndExtraIdentity targetUser, PureExtraIdentity sessionIdentity);
}
