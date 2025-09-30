package dev.kuchishkin.model;

import java.util.Objects;

public class Magazine extends Publication{
    private int issueNumber;

    public Magazine(String title, String author, int year, int issueNumber){
        super(title, author, year);
        setIssueNumber(issueNumber);
    }
    public Magazine(){
        super();
    }
    public int getIssueNumber() {
        return issueNumber;
    }
    public void setIssueNumber(int issueNumber) {
        if(issueNumber > 0){
            this.issueNumber = issueNumber;
        }
    }
    @Override
    public String getType() {
        return "Magazine";
    }
    @Override
    public String toString() {
        return "type: Magazine, " + super.toString() + ", issueNumber: " + issueNumber;
    }
    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Magazine magazine){
            return super.equals(magazine) && issueNumber == magazine.getIssueNumber();
        }
        return false;
    }
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), issueNumber);
    }

    @Override
    public void printDetails() {
        System.out.println(this);
    }
}
