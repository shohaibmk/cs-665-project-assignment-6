package edu.bu.met.cs665.example1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Tea {
    private static final String[] TEAS = {"Black Tea", "Green Tea", "Yellow Tea"};
    private final Scanner scanner;

    public Tea() {
        this.scanner = new Scanner(System.in);
    }

    /**
     * Add tea to our drinks list
     *
     * @return List
     */
    public List<HashMap<String, int[]>> addTea() {
        List<HashMap<String, int[]>> teaList = new ArrayList<>();
        int choice;

        do {
            displayTeaMenu();
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                case 2:
                case 3:
                    teaList.add(createTea(choice));
                    break;
                default:
                    System.out.println("Invalid Choice !!!");
            }
        } while (choice < 1 || choice > 3);

        return teaList;
    }

    /**
     * method to display menu
     * return void
     */
    private void displayTeaMenu() {
        System.out.println("\n\nType of Tea: ");
        for (int i = 0; i < TEAS.length; i++) {
            System.out.println((i + 1) + ") " + TEAS[i]);
        }
        System.out.print("Choice: ");
    }

    /**
     * create tea, add condiments to it
     *
     * @param choice
     * @return Hashmap
     */
    private HashMap<String, int[]> createTea(int choice) {
        Condiments teaObject = new Condiments();
        int[] condiments = teaObject.addCondiments();
        HashMap<String, int[]> tea = new HashMap<>();
        tea.put(TEAS[choice - 1], condiments);
        return tea;
    }
}
