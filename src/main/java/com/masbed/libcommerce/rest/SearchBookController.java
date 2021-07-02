package com.masbed.libcommerce.rest;

import com.masbed.libcommerce.domain.Book;
import com.masbed.libcommerce.util.StandardError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Arrays;
@RestController
public class SearchBookController {
        @PersistenceContext
        private EntityManager entityManager;

        @GetMapping(value = "/api/book/{id}")
        public ResponseEntity<?> searchList(@PathVariable("id") Long id) {

            Book book = entityManager.find(Book.class, id);

            if(book == null){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new StandardError(Arrays.asList("This book ID don't exists")));
            }

            return ResponseEntity.ok().body(book);
        }


}
