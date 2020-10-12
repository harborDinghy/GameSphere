package controller;

import java.io.*;
import java.util.*;

import com.google.gson.*;
import models.*;
import org.jetbrains.annotations.*;

public class Library {
    private final File libFile = new File("src/main/resources/LibraryGameSphere.txt");

    public void addBook(@NotNull String bookName, String authorName) throws IOException {
        Book book = Book.builder()
                .bookName(bookName.toLowerCase())
                .author(Author.builder().name(authorName.toLowerCase()).build())
                .build();
        FileWriter writer = new FileWriter(libFile, true);
        if (!isDuplicate(bookName)) {
            writer.write(book.getAuthor().getName() + ":" + book.getBookName() + "\n");
            writer.flush();
        }
        writer.close();
    }

    public File getLibFile() {
        return libFile;
    }

    public String bookFinder(@NotNull String author) throws IOException {
        String resAsJson;
        var list = new ArrayList<String>();
        FileReader reader = new FileReader(libFile);
        BufferedReader br = new BufferedReader(reader);
        String line = br.readLine();
        while (line != null) {
            if(line.contains(author.toLowerCase())) {
                list.add(line.substring(line.lastIndexOf(":") + 1));
            }
            line = br.readLine();
        }
        reader.close();
        if(list.isEmpty()) {
            resAsJson = "Books not found";
        } else {
            resAsJson = new Gson().toJson(list);
        }
        return resAsJson;
    }

    private Boolean isDuplicate(String book) throws IOException {
        boolean duplicate = false;
        FileReader reader = new FileReader(libFile);
        BufferedReader br = new BufferedReader(reader);
        String line = br.readLine();
        while (line != null && !duplicate) {
            if(line.contains(book.toLowerCase())) {
                duplicate = true;
            }
            line = br.readLine();
        }
        reader.close();
        return duplicate;
    }
}
