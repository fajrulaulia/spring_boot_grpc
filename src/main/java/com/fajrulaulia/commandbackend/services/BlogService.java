package com.fajrulaulia.commandbackend.services;

import com.fajrulaulia.commandbackend.generated.*;
import com.fajrulaulia.commandbackend.models.Blogs;
import com.fajrulaulia.commandbackend.repository.BlogRepository;
import io.grpc.stub.StreamObserver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


@Service
public class BlogService extends BlogServiceGrpc.BlogServiceImplBase {


    @Autowired
    private BlogRepository blogRepository;

    public BlogService(BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }

    @Override
    public void create(BlogRequest request, StreamObserver<BlogResponse> responseObserver) {
        Blogs blog = new Blogs();
        blog.setTitle(request.getTitle());
        blog.setContent(request.getContent());
        blog.setAuthor(request.getAuthor());

        String createdAtString = request.getCreatedAt();
        LocalDate createdAt = LocalDate.parse(createdAtString, DateTimeFormatter.ISO_LOCAL_DATE);
        blog.setCreatedAt(createdAt);

        blog = blogRepository.save(blog);

        BlogResponse response = BlogResponse.newBuilder()
                .setId(blog.getId())
                .setTitle(blog.getTitle())
                .setContent(blog.getContent())
                .setAuthor(blog.getAuthor())
                .setCreatedAt(blog.getCreatedAt().toString())
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void delete(BlogIdRequest request, StreamObserver<BlogResponseEmpty> responseObserver) {
        Blogs blog = new Blogs();
        blog.setId(request.getId());
        blogRepository.delete(blog);

        BlogResponseEmpty response = BlogResponseEmpty.newBuilder().build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

}
