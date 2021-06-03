package com.masbed.libcommerce.rest.contract;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.masbed.libcommerce.domain.Author;
import com.masbed.libcommerce.domain.Book;
import com.masbed.libcommerce.domain.Category;
import com.masbed.libcommerce.validator.Exist;
import org.springframework.ui.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.util.Date;

public class NewBookRequest {

    @NotBlank
    @Exist(domainClass = Book.class, fildname = "title", expected = false)
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
    @Exist(domainClass = Book.class, fildname = "isbn", expected = false)
    private String isbn;

    @Future
    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    private Date release;

    @NotNull
    @Exist(domainClass = Category.class, fildname = "id", expected = true)
    private Long categoryId;

    @NotNull
    @Exist(domainClass = Author.class, fildname = "id", expected = true)
    private Long authorId;

    @Deprecated
    public NewBookRequest(){}

    public NewBookRequest(@NotBlank String title, @NotBlank @Size(max = 500) String resume, String markdown,
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

    public Book toModel(){
        return new Book(title,resume,markdown,price,pagesNumber,isbn,release,categoryId,authorId);
    }
}
