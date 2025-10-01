package dev.kuchishkin.library;

import dev.kuchishkin.model.Publication;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private final List<Publication> publications;

    public Library() {
        this.publications = new ArrayList<>();
    }

    public Library(List<Publication> publications) {
        this.publications = publications != null ? new ArrayList<>(publications) : new ArrayList<>();
    }

    public void addPublication(Publication pub){
        if(pub != null && !publications.contains(pub)){
            publications.add(pub);
        }
    }

    public void listPublications(){
        System.out.println("Publications:");
        publications.forEach(System.out::println);
        System.out.println();
    }

    public void searchByAuthor(String author){
        System.out.println("Found Publications by Author:");
        publications.stream()
                .filter(pub -> pub.getAuthor().equals(author))
                .forEach(System.out::println);
        System.out.println();
    }

    public  void searchByTitle(String title){
        System.out.println("Found Publications by Title:");
        publications.stream()
                .filter(pub -> pub.getTitle().equals(title))
                .forEach(System.out::println);
        System.out.println();
    }

    public void searchByYear(int year){
        System.out.println("Found Publications by Year:");
        publications.stream()
                .filter(pub -> pub.getYear() == year)
                .forEach(System.out::println);
        System.out.println();
    }
}
