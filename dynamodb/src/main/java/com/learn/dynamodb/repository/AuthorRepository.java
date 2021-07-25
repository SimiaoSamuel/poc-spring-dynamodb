package com.learn.dynamodb.repository;

import com.learn.dynamodb.model.Author;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

@EnableScan
public interface AuthorRepository extends CrudRepository<Author,String> {
}
