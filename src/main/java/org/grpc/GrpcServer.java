package org.grpc;

import io.grpc.Server;
import io.grpc.ServerBuilder;

public class GrpcServer {

    private final static int PORT = 8080;

    public void run() {
        Server server = ServerBuilder
                .forPort(PORT)
                .addService(new GreetingServiceImpl())
                .build();

        startServer(server);
    }

    private static void startServer(Server server) {
        try {
            server.start();
            System.out.println("gRPC server started.");
            server.awaitTermination(); // Interrupt server when application will be terminated
        } catch (Exception e) {
            throw new RuntimeException("Can't start gRPC server.");
        }
    }
}
