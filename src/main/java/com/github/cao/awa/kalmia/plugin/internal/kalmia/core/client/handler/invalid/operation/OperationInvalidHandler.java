package com.github.cao.awa.kalmia.plugin.internal.kalmia.core.client.handler.invalid.operation;

import com.github.cao.awa.apricot.annotations.auto.Auto;
import com.github.cao.awa.kalmia.annotations.plugin.PluginRegister;
import com.github.cao.awa.kalmia.event.kalmiagram.handler.network.inbound.invalid.operation.OperationInvalidEventHandler;
import com.github.cao.awa.kalmia.network.packet.inbound.invalid.operation.OperationInvalidPacket;
import com.github.cao.awa.kalmia.network.router.kalmia.RequestRouter;
import com.github.cao.awa.modmdo.annotation.platform.Client;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Auto
@Client
@PluginRegister(name = "kalmia_client")
public class OperationInvalidHandler implements OperationInvalidEventHandler {
    private static final Logger LOGGER = LogManager.getLogger("OperationInvalidHandler");

    @Client
    @Override
    public void handle(RequestRouter router, OperationInvalidPacket packet) {
        LOGGER.info("Operation invalid because: {}",
                    packet.reason()
        );
    }
}
