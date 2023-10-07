package dev.camilo.graphqlmutations.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@Setter
@ToString
public class Review {

  @Id
  @GeneratedValue
  private Integer id;
  private String title;
  private String comment;

  public Review() {
  }

  public Review(String title, String comment) {
    this.title = title;
    this.comment = comment;
  }
}

