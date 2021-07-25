package com.learn.dynamodb.controller;

import com.learn.dynamodb.model.Author;
import com.learn.dynamodb.repository.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/author")
@RequiredArgsConstructor
public class AuthorController {

    private final AuthorRepository authorRepository;

    @PostMapping
    public ResponseEntity<Void> createAuthor(@RequestBody Author author, UriComponentsBuilder uriBuilder){
        Author authorWithHash = authorRepository.save(author);
        URI uri = uriBuilder.path("/api/v1/author/{id}").buildAndExpand(authorWithHash.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }

    @GetMapping
    public ResponseEntity<Iterable<Author>> listAuthor(){
        Iterable<Author> authors = authorRepository.findAll();

        return ResponseEntity.ok(authors);
    }
}
