package com.twu.biblioteca;

import java.io.PrintStream;

public class Menu {
    Library library;
    PrintStream printStream;
    Display display;
    User user;

    public Menu(Library library, PrintStream printStream,
                Display display) {
        this.library = library;
        this.printStream = printStream;
        this.display = display;
    }

//    public boolean userLogin() {
//        printStream.print("Please input your library number: ");
//        String library_number = display.getUserInput();
//        printStream.println();
//        printStream.print("Please input your password: ");
//        String password = display.getUserInput();
//        printStream.println();
//        return  user.checkCredentials(library_number, password);
//    }

    public void displayMenu() {
        printStream.println("------------------------");
        printStream.println("Please select an option:");
        printStream.println("1. List Books");
        printStream.println("2. Checkout Book");
        printStream.println("3. Return Book");
        printStream.println("4. List Movies");
        printStream.println("5. Checkout Movie");
        printStream.println("6. Return Movie");
        printStream.println("7. Display User Information");
        printStream.println("Q. Quit");
        printStream.println("-------------------------");
    }

    public void selectOption(int index) {
        display.displayWelcomeMessage();
        displayMenu();
        String input = display.getUserInput();

        while (!input.equals("Q")) {
            switch (input) {
                case "1":
                    library.displayBooksWithBookNumber();
                    break;
                case "2":
                    library.checkoutBook();
                    break;
                case "3":
                    library.returnBook();
                    break;
                case "4":
                    library.displayMoviesWithMovieNumber();
                    break;
                case "5":
                    library.checkoutMovie();
                    break;
                case "6":
                    library.returnMovie();
                    break;
                case "7":
                    library.displayUserInformation(index);
                default:
                    printStream.println("Select a valid option!");
                    break;
            }
            displayMenu();
            input = display.getUserInput();
        }

    }
}
