package dev.camilo.graphqlmutations.repository;

import dev.camilo.graphqlmutations.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer> {
}
