package dev.kuchishkin.model;

import java.util.Objects;

public class Newspaper extends Publication{
    private String publicationDay;

    public Newspaper(String title, String author, int year, String publicationDay) {
        super(title, author, year);
        setPublicationDay(publicationDay);
    }
    public String getPublicationDay() {
        return publicationDay;
    }
    public void setPublicationDay(String publicationDay) {
        if(publicationDay != null &&  !publicationDay.isEmpty()){
            this.publicationDay = publicationDay;
        }
    }
    @Override
    public String getType() {
        return "Newspaper";
    }
    @Override
    public String toString() {
        return "type: Newspaper, " + super.toString() + ", publicationDay: " + publicationDay;
    }
    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Newspaper newspaper){
            return super.equals(newspaper) && publicationDay.equals(newspaper.getPublicationDay());
        }
        return false;
    }
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), publicationDay);
    }

    @Override
    public void printDetails() {
        System.out.println(this);
    }
}
