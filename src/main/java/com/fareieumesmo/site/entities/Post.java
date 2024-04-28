package com.fareieumesmo.site.entities;

import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "posts")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Post {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer postId;

  @Column(nullable = false, unique = true)
  private String title;

  @Column(nullable = false, unique = true)
  private String subtitle;

  @Column(nullable = false)
  private String date;

  @OneToOne
  private Author author;

  @OneToOne
  private Category category;
}
