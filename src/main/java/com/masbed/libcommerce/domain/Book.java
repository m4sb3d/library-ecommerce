package com.masbed.libcommerce.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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

    @NotNull
    private Long categoryId;

    @NotNull
    private Long authorId;

    @Deprecated
    public Book(){}

    public Book(@NotBlank String title, @NotBlank @Size(max = 500) String resume, String markdown,
                @NotBlank BigDecimal price, @NotNull @Min(10) Integer pagesNumber,
                @NotNull String isbn, @Future Date release,
                @NotNull Long categoryId, @NotNull Long authorId) {
        this.title = title;
        this.resume = resume;
        this.markdown = markdown;
        this.price = price;
        this.pagesNumber = pagesNumber;
        this.isbn = isbn;
        this.release = release;
        this.categoryId = categoryId;
        this.authorId = authorId;
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

    public Long getCategoryId() {
        return categoryId;
    }

    public Long getAuthorId() {
        return authorId;
    }
}
