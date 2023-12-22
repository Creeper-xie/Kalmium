package com.github.cao.awa.kalmia.event.kalmiagram.handler.network.inbound.login.token;

import com.github.cao.awa.apricot.annotations.auto.Auto;
import com.github.cao.awa.kalmia.annotations.auto.event.AutoHandler;
import com.github.cao.awa.kalmia.event.kalmiagram.handler.network.inbound.login.LoginEventHandler;
import com.github.cao.awa.kalmia.event.kalmiagram.network.inbound.login.token.LoginWithTokenEvent;
import com.github.cao.awa.kalmia.network.packet.inbound.login.token.LoginWithTokenPacket;
import com.github.cao.awa.modmdo.annotation.platform.Server;

@Auto
@Server
@AutoHandler(LoginWithTokenEvent.class)
public interface LoginWithTokenEventHandler extends LoginEventHandler<LoginWithTokenPacket, LoginWithTokenEvent> {
}
