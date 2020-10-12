package controller;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.io.PrintWriter;

public class LibFactory {
    Library lib = new Library();
    public void createLibrary() throws IOException {
        for (int i = 0; i < 15; i++) {
            lib.addBook("book" + i, "author1");
        }
        for (int i = 15; i < 27 ; i++) {
            lib.addBook("book" + i, "author2");
        }
        for (int i = 27; i < 45; i++) {
            lib.addBook("book" + i, "author3");
        }
    }

    public String bookFinder (@NotNull String author) throws IOException {
        String result = lib.bookFinder(author);
        return result;
    }

    public void clearLib() throws IOException {
        PrintWriter writer = new PrintWriter(lib.getLibFile());
        writer.print("");
        writer.close();
    }

    public void addBook(@NotNull String bookName, String author) throws IOException {
        lib.addBook(bookName, author);
    }
}
