package com.amigoscode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public record Book(Integer id, String name, Integer pageCount, Integer authorId) {
    public static List<Book> books = new ArrayList<>(Arrays.asList(
            new Book(1, "Foundation", 452, 1),
            new Book(2, "I Robot", 280, 1),
            new Book(3, "Harry Potter and Goblet of Fire", 714, 2),
            new Book(4, "Three Body Problem", 600, 3)
    ));

    public static Book createBook(String name, Integer pageCount, Integer authorId) {
        int nextId = books.stream().mapToInt(Book::id).max().orElse(0) + 1;
        Book newBook = new Book(nextId, name, pageCount, authorId);
        books.add(newBook);
        return newBook;
    }

    public static Optional<Book> getBookById(Integer id) {
        return books.stream().filter(b -> b.id.equals(id)).findFirst();
    }
}
