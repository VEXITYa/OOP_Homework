package dev.kuchishkin;


import dev.kuchishkin.library.Library;
import dev.kuchishkin.model.Book;
import dev.kuchishkin.model.Magazine;
import dev.kuchishkin.model.Newspaper;
import dev.kuchishkin.model.Publication;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while(!exit){
            System.out.println("""
                    Actions:
                    1. Add new Publication
                    2. Show all Publications
                    3. Search Publications by Author
                    4. Search Publications by Title
                    5. Search Publications by Year
                    6. Show amount of Publications
                    0. Exit
                    """);
            System.out.println("Select an action:");
            int actionChoice = readInt(scanner);
            Publication publication = null;
            switch(actionChoice){
                case 1:
                    System.out.println("""
                            Choose type of publication:
                            1. Book
                            2. Magazine
                            3. Newspaper
                            """);
                    int typeChoice = readInt(scanner);
                    switch(typeChoice){
                        case 1, 2, 3:
                            System.out.println("Enter publication title:");
                            String title = scanner.nextLine();
                            System.out.println("Enter publication author:");
                            String author = scanner.nextLine();
                            System.out.println("Enter publication year:");
                            int year = readInt(scanner);
                            switch(typeChoice){
                                case 1:
                                    System.out.println("Enter ISBN:");
                                    String isbn = scanner.nextLine();
                                    publication = new Book(title, author, year, isbn);
                                    break;
                                case 2:
                                    System.out.println("Enter issue number:");
                                    int issue = readInt(scanner);
                                    publication = new Magazine(title, author, year, issue);
                                    break;
                                case 3:
                                    System.out.println("Enter publication day:");
                                    String day = scanner.nextLine();
                                    publication = new Newspaper(title, author, year, day);
                                    break;
                            }
                            library.addPublication(publication);
                            break;
                        default:
                            System.out.println("Invalid input");
                    }
                    break;
                case 2:
                    System.out.println("List of all publications:");
                    library.listPublications();
                    break;
                case 3:
                    System.out.println("Enter author:");
                    String author = scanner.nextLine();
                    library.searchByAuthor(author);
                    break;
                case 4:
                    System.out.println("Enter title:");
                    String title = scanner.nextLine();
                    library.searchByTitle(title);
                    break;
                case 5:
                    System.out.println("Enter year:");
                    int year = readInt(scanner);
                    library.searchByYear(year);
                    break;
                case 6:
                    System.out.println("Amount of publications: " + Publication.getPublicationCount());
                    System.out.println();
                    break;
                case 0:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid input");
            }
        }
    }


    private static int readInt(Scanner scanner){
        while(true){
            String input = scanner.nextLine().trim();
            if (input.matches("\\d{1,4}")) {
                return Integer.parseInt(input);
            }
            System.out.println("Invalid input: Enter one number");
        }
    }
}