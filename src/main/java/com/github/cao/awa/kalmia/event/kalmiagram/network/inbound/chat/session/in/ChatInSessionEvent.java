package com.github.cao.awa.kalmia.event.kalmiagram.network.inbound.chat.session.in;

import com.github.cao.awa.kalmia.event.kalmiagram.network.NetworkEvent;
import com.github.cao.awa.kalmia.network.packet.inbound.chat.session.in.ChatInSessionPacket;
import com.github.cao.awa.kalmia.network.router.kalmia.RequestRouter;

public class ChatInSessionEvent extends NetworkEvent<ChatInSessionPacket> {
    public ChatInSessionEvent(RequestRouter router, ChatInSessionPacket packet) {
        super(router,
              packet
        );
    }
}

