package com.masbed.libcommerce.rest.contract;

import com.masbed.libcommerce.domain.Author;
import com.masbed.libcommerce.domain.Book;
import com.masbed.libcommerce.domain.Category;

import java.math.BigDecimal;
import java.util.Date;

public class DetailBookResponse {

    private String title;
    private String resume;
    private String markdown;
    private BigDecimal price;
    private Integer pagesNumber;
    private String isbn;
    private Date release;

    private DetailAuthorResponse author;
    private Category category;

    public DetailBookResponse(Book book) {
        title = book.getTitle();
        resume= book.getResume();
        markdown = book.getMarkdown();
        price = book.getPrice();
        pagesNumber = book.getPagesNumber();
        isbn = book.getIsbn();
        release = book.getRelease();
        author = new DetailAuthorResponse(book.getAuthor());
        category = book.getCategory();

    }
}
