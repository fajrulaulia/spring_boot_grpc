package com.fajrulaulia.commandbackend.repository;

import com.fajrulaulia.commandbackend.models.Blogs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogRepository extends JpaRepository<Blogs, Long> {

}
