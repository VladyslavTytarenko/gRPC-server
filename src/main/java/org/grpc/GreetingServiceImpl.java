package org.grpc;

import com.grpc.GreetingServiceGrpc.GreetingServiceImplBase;
import com.grpc.GreetingServiceOuterClass.HelloRequest;
import com.grpc.GreetingServiceOuterClass.HelloResponse;
import io.grpc.stub.StreamObserver;

import java.util.stream.IntStream;

import static java.lang.String.format;

public class GreetingServiceImpl extends GreetingServiceImplBase {

    private static final int FROM = 0;
    private static final int TO = 20;
    private static final int SLEEP_TIME_MILLIS = 100;

    @Override
    public void greeting(HelloRequest request, StreamObserver<HelloResponse> responseObserver) {
        System.out.println(request);

        IntStream.range(FROM, TO)
                .forEach(i -> {
                    sleep();
                    HelloResponse response = HelloResponse.newBuilder()
                            .setGreeting(format("Hello from server, %s, attempt: %d", request.getName(), i)).build();
                    responseObserver.onNext(response);
                });

        responseObserver.onCompleted();
    }

    private void sleep() {
        try {
            Thread.sleep(SLEEP_TIME_MILLIS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
