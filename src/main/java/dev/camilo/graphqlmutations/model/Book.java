package dev.camilo.graphqlmutations.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
public class Book {

  @Id
  @GeneratedValue
  private Integer id;
  private String title;
  private Integer pages;
  private String author;

  // relations
  @OneToMany(cascade = CascadeType.ALL)
  @JoinColumn(name = "book_id", referencedColumnName = "id")
  @ToString.Exclude
  private List<Review> reviews;

  public Book() {
  }

  public Book(String title, Integer pages, String author) {
    this.title = title;
    this.pages = pages;
    this.author = author;
  }
}
