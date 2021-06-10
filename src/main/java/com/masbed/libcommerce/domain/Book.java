package com.masbed.libcommerce.domain;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String title;

    @NotBlank
    @Size(max = 500)
    private String resume;

    private String markdown;

    @NotNull
    private BigDecimal price;

    @NotNull
    @Min(10)
    private Integer pagesNumber;

    @NotNull
    private String isbn;

    @Future
    private Date release;

    @ManyToOne
    @NotNull
    @Valid
    private Category category;

    @ManyToOne
    @NotNull
    @Valid
    private Author author;

    @Deprecated
    public Book(){}

    public Book(@NotBlank String title, @NotBlank @Size(max = 500) String resume, String markdown,
                @NotBlank BigDecimal price, @NotNull @Min(10) Integer pagesNumber,
                @NotNull String isbn, @Future Date release,
                @NotNull Category category, @NotNull Author author) {
        this.title = title;
        this.resume = resume;
        this.markdown = markdown;
        this.price = price;
        this.pagesNumber = pagesNumber;
        this.isbn = isbn;
        this.release = release;
        this.category = category;
        this.author = author;
    }



    public String getTitle() {
        return title;
    }

    public String getResume() {
        return resume;
    }

    public String getMarkdown() {
        return markdown;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Integer getPagesNumber() {
        return pagesNumber;
    }

    public String getIsbn() {
        return isbn;
    }

    public Date getRelease() {
        return release;
    }

    public Category getCategory() {
        return category;
    }

    public Author getAuthor() {
        return author;
    }
}
