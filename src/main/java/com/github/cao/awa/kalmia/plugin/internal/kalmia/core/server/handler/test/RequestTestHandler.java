package com.github.cao.awa.kalmia.plugin.internal.kalmia.core.server.handler.test;

import com.github.cao.awa.apricot.annotations.auto.Auto;
import com.github.cao.awa.kalmia.annotations.plugin.PluginRegister;
import com.github.cao.awa.kalmia.event.kalmiagram.handler.network.inbound.test.RequestTestEventHandler;
import com.github.cao.awa.kalmia.network.packet.inbound.test.RequestTestPacket;
import com.github.cao.awa.kalmia.network.router.kalmia.RequestRouter;
import com.github.cao.awa.modmdo.annotation.platform.Server;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Auto
@Server
@PluginRegister(name = "kalmia_core")
public class RequestTestHandler implements RequestTestEventHandler {
    private static final Logger LOGGER = LogManager.getLogger("RequestTestHandler");

    @Auto
    @Server
    @Override
    public void handle(RequestRouter router, RequestTestPacket packet) {
        LOGGER.info("---TEST---");
    }
}
