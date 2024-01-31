package com.realworld.service;

import com.realworld.model.Author;
import com.realworld.repository.AuthorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {
    private AuthorRepository authorRepository;

    public Author saveAuthor(Author author) {
        return authorRepository.save(author);
    }

    public List<Author> getAllPerson() {
        return authorRepository.findAll();
    }

    public List< Author > getByName(String name) {
        return authorRepository.getByName(name);
    }

    public Optional< Author > getById(Long id) {
        return authorRepository.findById(id);
    }

    public void deleteById(Long id) {
        authorRepository.deleteById(id);
    }
}
