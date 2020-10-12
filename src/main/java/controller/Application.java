package controller;

import java.io.*;
import java.util.*;

public final class Application {
    public static void main(String[] args) throws IOException {
        LibFactory library = new LibFactory();
        library.createLibrary();
        Scanner in = new Scanner(System.in);
        System.out.println("Enter author:");
        String author = in.nextLine();
        System.out.println(library.bookFinder(author));
    }
}
