package ru.rnikonorov.grpcserver;

import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.server.service.GrpcService;
import ru.rnikonorov.protos.HelloReply;
import ru.rnikonorov.protos.HelloRequest;
import ru.rnikonorov.protos.MyServiceGrpc;

@GrpcService
@Slf4j
public class GreetingsServer extends MyServiceGrpc.MyServiceImplBase {

    @Override
    public void sayHello(final HelloRequest request, final StreamObserver<HelloReply> responseObserver) {
        final HelloReply reply = HelloReply.newBuilder()
                .setGreeting("Hello " + request.getName())
                .build();
        log.info("Sending {}", reply);
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }
}
