package com.github.cao.awa.kalmia.event.kalmiagram.handler.network.inbound.login.feedback;

import com.github.cao.awa.apricot.annotations.auto.Auto;
import com.github.cao.awa.kalmia.annotations.auto.event.AutoHandler;
import com.github.cao.awa.kalmia.event.kalmiagram.handler.network.NetworkEventHandler;
import com.github.cao.awa.kalmia.event.kalmiagram.network.inbound.login.feedback.LoginSuccessEvent;
import com.github.cao.awa.kalmia.network.packet.inbound.login.feedback.LoginSuccessPacket;
import com.github.cao.awa.modmdo.annotation.platform.Client;

@Auto
@Client
@AutoHandler(LoginSuccessEvent.class)
public interface LoginSuccessEventHandler extends NetworkEventHandler<LoginSuccessPacket, LoginSuccessEvent> {
}
