package ru.rnikonorov.grpcclient;

import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;
import ru.rnikonorov.protos.HelloRequest;
import ru.rnikonorov.protos.MyServiceGrpc;

@Service
@Slf4j
public class ClientService {

    @GrpcClient("myService")
    private MyServiceGrpc.MyServiceBlockingStub myServiceBlockingStub;


    public String sayHello(final String name) {
        final HelloRequest request = HelloRequest.newBuilder()
                .setName(name)
                .build();
        log.info("Sending hello from {}", name);
        return myServiceBlockingStub.sayHello(request).getGreeting();
    }
}
