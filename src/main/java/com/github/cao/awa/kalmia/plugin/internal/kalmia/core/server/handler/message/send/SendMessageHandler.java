package com.github.cao.awa.kalmia.plugin.internal.kalmia.core.server.handler.message.send;

import com.github.cao.awa.apricot.annotations.auto.Auto;
import com.github.cao.awa.kalmia.annotations.plugin.PluginRegister;
import com.github.cao.awa.kalmia.bootstrap.Kalmia;
import com.github.cao.awa.kalmia.constant.KalmiaConstant;
import com.github.cao.awa.kalmia.event.kalmiagram.handler.network.inbound.message.send.SendMessageEventHandler;
import com.github.cao.awa.kalmia.mathematic.Mathematics;
import com.github.cao.awa.kalmia.message.Message;
import com.github.cao.awa.kalmia.message.cover.CoverMessage;
import com.github.cao.awa.kalmia.message.cover.processor.coloregg.MeowMessageProcessor;
import com.github.cao.awa.kalmia.message.user.UserMessage;
import com.github.cao.awa.kalmia.network.packet.inbound.message.send.SendMessagePacket;
import com.github.cao.awa.kalmia.network.packet.inbound.message.send.SendMessageRefusedPacket;
import com.github.cao.awa.kalmia.network.packet.inbound.message.send.SentMessagePacket;
import com.github.cao.awa.kalmia.network.router.kalmia.RequestRouter;
import com.github.cao.awa.kalmia.session.Session;
import com.github.cao.awa.kalmia.setting.session.SessionSettings;
import com.github.cao.awa.modmdo.annotation.platform.Server;
import com.github.cao.awa.viburnum.util.bytes.BytesUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.UUID;

@Auto
@Server
@PluginRegister(name = "kalmia_core")
public class SendMessageHandler implements SendMessageEventHandler {
    private static final Logger LOGGER = LogManager.getLogger("SendMessageHandler");

    @Server
    @Override
    public void handle(RequestRouter router, SendMessagePacket packet) {
        LOGGER.info("""
                            --Send message--
                            UID: {}
                            IDT: {}
                            SID: {}
                            MSG:{}""",
                    packet.handler()
                          .accessIdentity(),
                    Mathematics.radix(packet.receipt(),
                                      36
                    ),
                    packet.sessionIdentity(),
                    packet.message()
        );

        Session session = Kalmia.SERVER.sessionManager()
                                       .session(packet.sessionIdentity());

        boolean accessible = false;

        if (session != null) {
            accessible = session.accessible(router.accessIdentity());
        }

        if (accessible) {
            Message message;

            byte[] msg = packet.message();

            if (! packet.signed() && ! packet.crypted()) {
                // Meow when user do not to sign.
                msg = Kalmia.SERVER.messageProcessor(MeowMessageProcessor.ID)
                                   .process(msg,
                                            router.accessIdentity()
                                   );
            }

            if (! packet.crypted()) {
                for (UUID processor : session.settings()
                                             .get(SessionSettings.ENABLED_PROCESSORS)
                                             .processors()) {
                    Kalmia.SERVER.messageProcessor(processor)
                                 .process(msg,
                                          router.accessIdentity()
                                 );
                }
            }

            if (Arrays.equals(msg,
                              packet.message()
            )) {
                message = new UserMessage(
                        packet.keyIdentity(),
                        packet.message(),
                        packet.signIdentity(),
                        packet.sign(),
                        router.accessIdentity()
                );
            } else {
                message = new CoverMessage(
                        // Source data.
                        packet.message(),
                        router.accessIdentity(),
                        packet.signIdentity(),
                        packet.sign(),
                        // Cover data.
                        msg,
                        // TODO the cover sender need be a account.
                        KalmiaConstant.UNMARKED_LONG_AND_EXTRA_IDENTITY,
                        // TODO the cover message need to sign.
                        KalmiaConstant.UNMARKED_PURE_IDENTITY,
                        BytesUtil.EMPTY
                );

                LOGGER.info("Processor has processed message");
            }

            long seq = Kalmia.SERVER.messageManager()
                                    .send(
                                            packet.sessionIdentity(),
                                            message
                                    );

            // Response to client send result.
            router.send(new SentMessagePacket(session.identity(),
                                              seq,
                                              message
            ).receipt(packet.receipt()));

            LOGGER.info("Sent message at seq {}: {}",
                        seq,
                        Mathematics.radix(packet.receipt(),
                                          36
                        )
            );
        } else {
            // Unable to access the session.
            router.send(new SendMessageRefusedPacket("message.send.refused.session.unable.access").receipt(packet.receipt()));
            LOGGER.warn("The session {} is not accessible",
                        packet.sessionIdentity()
            );
        }
    }
}
