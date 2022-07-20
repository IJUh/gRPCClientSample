package com.example.demo;

import com.demo.grpc.HelloRequest;
import com.demo.grpc.HelloResponse;
import com.demo.grpc.HelloServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class GrpcClient {
    public static void main(String[] args) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8080)
                .usePlaintext()
                .build();

        HelloServiceGrpc.HelloServiceBlockingStub stub = HelloServiceGrpc.newBlockingStub(channel);

        HelloResponse helloResponse = stub.hello(HelloRequest.newBuilder()
                .setFirstName("Velnova")
                .setLastName("Jung")
                .build());

        System.out.println("response : " + helloResponse);

        channel.shutdown();

    }
}