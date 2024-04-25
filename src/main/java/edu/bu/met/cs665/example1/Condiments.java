package edu.bu.met.cs665.example1;

import java.util.Scanner;


public class Condiments {
    private static final int MIN_UNITS = 0;
    private static final int MAX_UNITS = 3;
    private final int[] units;

    public Condiments() {
        units = new int[2];
    }

    /**
     * method to add condiments to drinks
     * @return int
     */
    public int[] addCondiments() {
        Scanner scanner = new Scanner(System.in);
        setUnits(scanner, "Milk");
        setUnits(scanner, "Sugar");
        return units;
    }

    /**
     * method to set units
     * @param scanner
     * @param condimentName
     * return void
     */
    private void setUnits(Scanner scanner, String condimentName) {
        boolean invalid = true;
        int index = condimentName.equalsIgnoreCase("Milk") ? 0 : 1;

        while (invalid) {
            System.out.print("Number of units of " + condimentName + " (0-3): ");
            int temp = scanner.nextInt();
            if (temp < MIN_UNITS || temp > MAX_UNITS) {
                System.out.println("Invalid number of units !!!");
            } else {
                units[index] = temp;
                invalid = false;
            }
        }
    }

    //getter for milk units
    public int getMilkUnits() {
        return units[0];
    }

    //getter for sugar units
    public int getSugarUnits() {
        return units[1];
    }

    //setter
    public void setUnits(int[] units) {
        this.units[0] = units[0];
        this.units[1] = units[1];
    }
}
