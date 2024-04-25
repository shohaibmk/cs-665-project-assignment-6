package edu.bu.met.cs665.example1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;



public class Billing {
    private final Scanner scanner;
    private final List<List<HashMap<String, int[]>>> drinksList;

    public Billing() {
        scanner = new Scanner(System.in);
        drinksList = new ArrayList<>();
    }

    public void createBill() {
        boolean exit = false;
        int choice;
        do {
            displayMenu();
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    addDrink(new Coffee().addCoffee());
                    break;
                case 2:
                    addDrink(new Tea().addTea());
                    break;
                case 3:
                    viewDrinks();
                    break;
                case 4:
                    removeDrink();
                    break;
                case 5:
                    brew();
                    break;
                case 6:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid Choice !!!\n\n");
            }
        } while (!exit);
    }

    private void displayMenu() {
        System.out.println("\n\nMenu:");
        System.out.println("1) Add Coffee");
        System.out.println("2) Add Tea");
        System.out.println("3) View Order");
        System.out.println("4) Remove Drinks");
        System.out.println("5) Brew");
        System.out.println("6) Exit");
        System.out.print("Choice: ");
    }

    /**
     * method to add drinks to the drinks list
     *
     * @param drink
     * return void
     */
    private void addDrink(List<HashMap<String, int[]>> drink) {
        drinksList.add(drink);
    }

    /**
     * method to brew the drink
     *
     * @return void
     */
    private void brew() {
        System.out.println("Brewing Drinks for you!!!\nPlease be patient");
    }

    /**
     * View drinks list
     *
     * @return void
     */
    private void viewDrinks() {
        System.out.println("Drinks:-");
        int itemNumber = 1;
        for (List<HashMap<String, int[]>> drink : drinksList) {
            for (HashMap<String, int[]> drinkMap : drink) {
                String drinkName = drinkMap.keySet().iterator().next();
                int[] condiments = drinkMap.get(drinkName);
                System.out.println(itemNumber++ + ") " + drinkName + " [milk: " + condiments[0] + ", sugar: " + condiments[1] + "]");
            }
        }
    }

    /**
     * Remove drinks from the drinks list
     *
     * @return void
     */
    private void removeDrink() {
        try {
            System.out.println("Select drink to remove:");
            viewDrinks();
            int choice = scanner.nextInt();
            drinksList.remove(choice - 1);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Invalid choice!");
        }
    }
}
