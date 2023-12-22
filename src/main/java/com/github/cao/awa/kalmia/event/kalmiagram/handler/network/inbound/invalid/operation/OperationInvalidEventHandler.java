package com.github.cao.awa.kalmia.event.kalmiagram.handler.network.inbound.invalid.operation;

import com.github.cao.awa.apricot.annotations.auto.Auto;
import com.github.cao.awa.kalmia.annotations.auto.event.AutoHandler;
import com.github.cao.awa.kalmia.event.kalmiagram.handler.network.NetworkEventHandler;
import com.github.cao.awa.kalmia.event.kalmiagram.network.inbound.invalid.operation.OperationInvalidEvent;
import com.github.cao.awa.kalmia.network.packet.inbound.invalid.operation.OperationInvalidPacket;
import com.github.cao.awa.modmdo.annotation.platform.Client;

@Auto
@Client
@AutoHandler(OperationInvalidEvent.class)
public interface OperationInvalidEventHandler extends NetworkEventHandler<OperationInvalidPacket, OperationInvalidEvent> {
}
