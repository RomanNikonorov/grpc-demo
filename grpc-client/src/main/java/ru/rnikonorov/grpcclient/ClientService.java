package ru.rnikonorov.grpcclient;

import com.google.rpc.Code;
import com.google.rpc.Status;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

import ru.rnikonorov.protos.HelloRequest;
import ru.rnikonorov.protos.MyServiceGrpc.MyServiceBlockingStub;

@Service
@Slf4j
public class ClientService {

    @GrpcClient("myService")
    private MyServiceBlockingStub myServiceBlockingStub;


    public String sayHello(final String name) {
        final Status status = Status.newBuilder()
                .setCode(Code.INTERNAL.getNumber())
                .build();
        final HelloRequest request = HelloRequest.newBuilder()
                .setName(name)
                .build();
        log.info("Sending hello from {}", name);
        return myServiceBlockingStub.sayHello(request).getGreeting();
    }
}
