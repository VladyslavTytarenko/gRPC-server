package org.grpc;

import com.grpc.GreetingServiceGrpc.GreetingServiceImplBase;
import com.grpc.GreetingServiceOuterClass.HelloRequest;
import com.grpc.GreetingServiceOuterClass.HelloResponse;
import io.grpc.stub.StreamObserver;

public class GreetingServiceImpl extends GreetingServiceImplBase {

    @Override
    public void greeting(HelloRequest request, StreamObserver<HelloResponse> responseObserver) {
        System.out.println(request);
        HelloResponse response = HelloResponse.newBuilder()
                .setGreeting("Hello from server, " + request.getName()).build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
