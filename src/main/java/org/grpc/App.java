package org.grpc;

public class App {
    public static void main( String[] args ) {
        GrpcServer server = new GrpcServer();
        server.run();
    }
}
