package de.hhu.bsinfo.infinileap.example.demo;

import de.hhu.bsinfo.infinileap.binding.*;
import de.hhu.bsinfo.infinileap.example.base.CommunicationDemo;
import de.hhu.bsinfo.infinileap.util.CommunicationBarrier;
import de.hhu.bsinfo.infinileap.util.Requests;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.ValueLayout;
import lombok.extern.slf4j.Slf4j;
import picocli.CommandLine;

@Slf4j
@CommandLine.Command(
        name = "messaging",
        description = "Exchanges a message between two nodes."
)
public class Messaging extends CommunicationDemo {

    private static final String MESSAGE = "Hello Infinileap!";

    private static final byte[] MESSAGE_BYTES = MESSAGE.getBytes();
    private static final int MESSAGE_SIZE = MESSAGE_BYTES.length;

    private final CommunicationBarrier barrier = new CommunicationBarrier();

    @Override
    protected void onClientReady(Context context, Worker worker, Endpoint endpoint) throws InterruptedException {

        // Allocate a buffer and write the message
        final var source = MemorySegment.ofArray(MESSAGE_BYTES);
        final var buffer = arena.allocate(MESSAGE_SIZE);
        buffer.copyFrom(source);

        // Send the buffer to the server
        log.info("Sending buffer");

        var request = endpoint.sendTagged(buffer, Tag.of(0L), new RequestParameters()
                    .setSendCallback(barrier::release));

        Requests.await(worker, barrier);
        Requests.release(request);
    }

    @Override
    protected void onServerReady(Context context, Worker worker, Endpoint endpoint) throws InterruptedException {

        // Allocate a buffer for receiving the remote's message
        var buffer = arena.allocate(MESSAGE_SIZE);

        // Receive the message
        log.info("Receiving message");

        var request = worker.receiveTagged(buffer, Tag.of(0L), new RequestParameters()
                .setReceiveCallback(barrier::release));

        Requests.await(worker, barrier);
        Requests.release(request);

        log.info("Received \"{}\"", new String(buffer.toArray(ValueLayout.JAVA_BYTE)));
    }
}
