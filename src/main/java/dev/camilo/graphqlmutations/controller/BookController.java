package dev.camilo.graphqlmutations.controller;

import dev.camilo.graphqlmutations.model.Book;
import dev.camilo.graphqlmutations.model.BookInput;
import dev.camilo.graphqlmutations.repository.BookRepository;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/api/books")
public class BookController {

  private final BookRepository bookRepository;

  public BookController(BookRepository bookRepository) {
    this.bookRepository = bookRepository;
  }

  @QueryMapping
  public List<Book> findAllBooks() {
    return bookRepository.findAll();
  }

  @MutationMapping
  public Book createBook(
      @Argument String title,
      @Argument Integer pages,
      @Argument String author) {
    Book bookToSave = new Book(title, pages, author);
    return bookRepository.save(bookToSave);
  }

  @MutationMapping
  public Book addBook(@Argument BookInput book) {
    return bookRepository.save(new Book(book.title(), book.pages(), book.author()));
  }

  @MutationMapping
  public List<Book> batchCreateBooks(@Argument List<BookInput> books) {
    return bookRepository.saveAll(books.stream().map(book -> new Book(book.title(), book.pages(), book.author())).toList());
  }

  @MutationMapping
  public Book updateBook(@Argument Integer id, @Argument BookInput book) {
    Book bookToUpdate = bookRepository.findById(id).orElse(null);
    if(bookToUpdate == null) {
      throw new RuntimeException("Book not found");
    }
    bookToUpdate.setTitle(book.title());
    bookToUpdate.setPages(book.pages());
    bookToUpdate.setAuthor(book.author());
    bookRepository.save(bookToUpdate);
    return bookToUpdate;
  }

  @MutationMapping
  public void deleteBook(@Argument Integer id) {
    bookRepository.deleteById(id);
  }
}
