package ru.rnikonorov.grpcserver;

import io.grpc.stub.StreamObserver;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.server.service.GrpcService;
import ru.rnikonorov.protos.HelloReply;
import ru.rnikonorov.protos.HelloRequest;
import ru.rnikonorov.protos.MyServiceGrpc.MyServiceImplBase;
import ru.rnikonorov.service.GreetingsService;

@GrpcService
@Slf4j
@RequiredArgsConstructor
public class GreetingsServer extends MyServiceImplBase {

    private final GreetingsService greetingsService;

    @Override
    public void sayHello(final HelloRequest request, final StreamObserver<HelloReply> responseObserver) {
        final HelloReply reply = HelloReply.newBuilder()
                .setGreeting(greetingsService.greetClient(request.getName()))
                .build();
        log.info("Sending {}", reply);
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }
}
