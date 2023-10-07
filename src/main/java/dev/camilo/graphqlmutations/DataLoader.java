package dev.camilo.graphqlmutations;

import dev.camilo.graphqlmutations.model.Book;
import dev.camilo.graphqlmutations.model.Review;
import dev.camilo.graphqlmutations.repository.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataLoader {

  @Bean
  CommandLineRunner commandLineRunner(BookRepository bookRepository) {
    return args -> {
      Book reactiveSpring = new Book("Spring in Action", 500, "Ben Haskell");
      Review review = new Review("Great book!", "I loved it a lot");
      reactiveSpring.setReviews(List.of(review));
      bookRepository.save(reactiveSpring);
    };
  };
}

