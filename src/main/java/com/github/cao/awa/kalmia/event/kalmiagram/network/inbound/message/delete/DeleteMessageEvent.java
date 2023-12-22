package com.github.cao.awa.kalmia.event.kalmiagram.network.inbound.message.delete;

import com.github.cao.awa.kalmia.event.kalmiagram.network.NetworkEvent;
import com.github.cao.awa.kalmia.network.packet.inbound.message.delete.DeleteMessagePacket;
import com.github.cao.awa.kalmia.network.router.kalmia.RequestRouter;

public class DeleteMessageEvent extends NetworkEvent<DeleteMessagePacket> {
    public DeleteMessageEvent(RequestRouter router, DeleteMessagePacket packet) {
        super(router,
              packet
        );
    }
}
