package dev.kuchishkin.model;

import java.util.Objects;

abstract public class Publication implements Printable {
    private String title;
    private String author;
    private int  year;
    private static int publicationCount = 0;
    public static int getPublicationCount() {
        return publicationCount;
    }
    public static void addPublication() {
        publicationCount++;
    }
    public Publication(String title, String author, int year) {
        setTitle(title);
        setAuthor(author);
        setYear(year);
        addPublication();
    }
    public Publication() {}
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        if(title != null &&  !title.isEmpty()){
            this.title = title;
        }
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        if(author != null &&  !author.isEmpty()){
            this.author = author;
        }
    }
    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }
    @Override
    public String toString() {
        return "Title: " + title + ", Author: " + author + ", Year: " + year;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        else if (obj instanceof Publication other) {
            return title.equals(other.title) &&
                    author.equals(other.author) &&
                    year == other.year;
        }
        return false;
    }
    @Override
    public int hashCode() {
        return Objects.hash(title, author, year);
    }
    public abstract String getType();
    @Override
    public void  printDetails() {
        System.out.println(this);
    }
}
