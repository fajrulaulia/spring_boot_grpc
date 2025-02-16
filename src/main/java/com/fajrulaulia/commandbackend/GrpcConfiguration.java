package com.fajrulaulia.commandbackend;

import com.fajrulaulia.commandbackend.services.BlogService;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

@Configuration
public class GrpcConfiguration {

    private final BlogService blogService;

    @Autowired
    public GrpcConfiguration(BlogService blogService) {
        this.blogService = blogService;
    }

    @Bean
    public Server grpcServer() throws IOException, InterruptedException {
        Server server = ServerBuilder.forPort(9458)
                .addService(blogService)  // Use the injected BlogService
                .build();

        server.start();
        System.out.println("gRPC server started on port 9458");
        server.awaitTermination();
        return server;
    }
}
