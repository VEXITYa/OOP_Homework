package dev.kuchishkin.model;

import java.util.Objects;

public class Book extends Publication{
    private String ISBN;

    public Book(String title, String author, int year, String ISBN) {
        super(title, author, year);
        setISBN(ISBN);
    }

    public Book(){
        super();
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        if(ISBN != null && !ISBN.isEmpty()){
            this.ISBN = ISBN;
        }
    }

    @Override
    public String getType(){
        return "Book";
    }

    @Override
    public boolean equals(Object obj){
        if(obj instanceof Book book){
            return super.equals(book) && ISBN.equals(book.getISBN());
        }
        return false;
    }

    @Override
    public String toString(){
        return "type: Book, " + super.toString() + ", ISBN: " + ISBN;
    }

    @Override
    public int hashCode(){
        return Objects.hash(super.hashCode(), ISBN);
    }

    @Override
    public void printDetails() {
        System.out.println(this);
    }
}
