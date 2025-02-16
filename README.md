# Command Backend Service

This is a Spring Boot backend service for managing blog posts. The service exposes gRPC endpoints to interact with blog data, such as creating and deleting blog posts. It is designed with a clean architecture using Spring Data JPA for database interactions.

## Features

- Create a new blog post.
- Delete an existing blog post.
- Use gRPC for communication.

## Technologies Used

- **Spring Boot**: A Java-based framework for building backend applications.
- **gRPC**: A high-performance RPC framework used to define and implement service methods.
- **JPA**: Java Persistence API for interacting with relational databases.
- **PostgreSQL**: A relational database to store blog data.
- **Protocol Buffers (Protobuf)**: For defining the structure of the gRPC requests and responses.

## Project Structure

- `BlogService`: A service that implements the gRPC service for creating and deleting blogs.
- `BlogRepository`: A Spring Data JPA repository interface for interacting with the blog database.
- `BlogServiceGrpc`: Generated gRPC classes from `.proto` files.
- `BlogRequest`, `BlogResponse`, `BlogListResponse`: Protobuf messages for gRPC communication.


## Script
```bash
brew install maven ## I use maven so use it :)
brew install protobuf ## Protocol buffers (Google's data interchange format)
brew install protoc-gen-grpc-java # Install Plugin protobuf for Java
make generate # generate the Java objects and gRPC classes

## Run it
```

## Screenshot
Created 
<img width="1440" alt="image" src="https://github.com/user-attachments/assets/899b2f01-f13e-4486-8425-3e2faaf42826" />

Detail (for list not from Spring, but from gRPC Golang
<img width="1440" alt="image" src="https://github.com/user-attachments/assets/5a8f7968-94fe-4f19-b1af-b99bfdb6f332" />

Delete
<img width="1440" alt="image" src="https://github.com/user-attachments/assets/0f25ca69-0398-4d26-be55-9cfadd6b0098" />

Check All (for list not from Spring, but from gRPC Golang
<img width="1440" alt="image" src="https://github.com/user-attachments/assets/b550a231-e6e0-4959-b19e-dcfc0ccfab08" />


