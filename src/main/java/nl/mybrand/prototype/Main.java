package nl.mybrand.prototype;

import nl.mybrand.prototype.ui.MainMenu;

import java.util.Scanner;

public class Main {

    private final Scanner scanner;

    public Main() {
        this.scanner = new Scanner(System.in);
    }

    public static void main(String[] args) {
        new Main().startMainMenu();
    }

    private void startMainMenu() {
        boolean applicationLoop;

        MainMenu mainMenu = new MainMenu(scanner);
        System.out.println("\nApplicatie wordt opgestart..");
        do {
            applicationLoop = mainMenu.mainMenuChoices();
        } while (applicationLoop);
    }

}
