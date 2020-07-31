import java.util.Scanner;
import java.util.ArrayList;
import java.text.DecimalFormat;


public class initialMenu {
    public static void main(String args[])
            throws java.io.IOException {
        char choice; // for user input

        System.out.println("Welcome to The Spot! WHat would you like to order?");
        System.out.println("\t" + "1. Classic Cheeseburger");
        System.out.println("\t" + "2. Club Sandwich");
        System.out.println("\t" + "3. Smokey BBQ");
        System.out.println("\t" + "4. Hawaiian Chicken");
        System.out.println("\t" + "5. Create your own.");
        choice = (char) System.in.read();
        DecimalFormat df2 = new DecimalFormat("#.##");
        double totalPrice = 0.00;
        switch (choice) { //switch statement
            case '1':
                totalPrice += 5.00;
                System.out.println("That will be: $" +  df2.format(totalPrice) + " Please pay at the register."); //need to make sure that custom order is not cheaper than cheapest item.
                break;

            case '2':
                totalPrice += 5.00;
                System.out.println("That will be: $" +  df2.format(totalPrice) + " Please pay at the register.");
                break;

            case '3':
                totalPrice += 7.00;
                System.out.println("That will be: $" +  df2.format(totalPrice) + " Please pay at the register.");
                break;

            case '4':
                totalPrice += 7.00;
                System.out.println("That will be: $" +  df2.format(totalPrice) + " Please pay at the register.");
                break;
            case '5':
                System.out.println("Okay, lets get started!");
                PriceDatabase totaler = new PriceDatabase();
                String myBread = getBreads();
                totalPrice += totaler.get_price(myBread);
                String myMeat = getMeats();
                totalPrice += totaler.get_price(myMeat);
                String myCheese = getCheeses();
                totalPrice += totaler.get_price(myCheese);
                ArrayList<String> myVeggies = getVeggies();
                for (String vegetable : myVeggies) {
                    totalPrice += totaler.get_price(vegetable);
                }
                System.out.println("Thank you for your order! Your total is $" + df2.format(totalPrice));
        }




    }

    public static String getBreads() throws java.io.IOException{
        Scanner scan = new Scanner(System.in);
        int i = 1;

        String[] breads = new String[]{"Wheat", "White", "Italian"};
        System.out.println("Choose the number for your bread: ");
        for (String bread : breads) {
            System.out.print(i + ": ");
            System.out.println(bread);
            i += 1;
        }
        int breadIndex = scan.nextInt();
        String breacChoice = breads[breadIndex - 1];

        System.out.println("You chose: " + breacChoice + "\n");
        return breacChoice;
    }

    public static String getMeats() throws java.io.IOException{
        Scanner scan = new Scanner(System.in);
        int i = 1;

        String[] meats = new String[]{"Chicken", "Beef", "Veggie"};
        System.out.println("Choose the number for your meat: ");
        for (String meat : meats) {
            System.out.print(i + ": ");
            System.out.println(meat);
            i += 1;
        }
        int meatIndex = scan.nextInt();
        String meatChoice = meats[meatIndex - 1];

        System.out.println("You chose: " + meatChoice + "\n");
        return meatChoice;
    }

    public static ArrayList<String> getVeggies() throws java.io.IOException{
        Scanner scan = new Scanner(System.in);
        boolean moreVeggies = true;
        ArrayList<String> veggieChoices = new ArrayList<String>();
       String[] veggies = new String[]{"Lettuce", "Onions", "Tomatoes", "Peppers", "Pickles"};
        while (moreVeggies) {
            int i = 1;
            for (String veggie : veggies) {
                System.out.print(i + ": ");
                System.out.println(veggie);
                i += 1;
            }
            int veggieIndex = scan.nextInt();
            veggieChoices.add(veggies[veggieIndex - 1]);
            System.out.println("Choose the number for your veggie: ");

            System.out.println("You chose: " + veggies[veggieIndex - 1] + "\n");
            System.out.println("Would you like to add another veggie (Y/N): ");
            String moreChoice = scan.next().toUpperCase();
            if (moreChoice.equals("N")) {
                moreVeggies = false;
            }
        }
        System.out.println(veggieChoices);
        return veggieChoices;
    }

    public static String getCheeses() throws java.io.IOException {
    Scanner scan = new Scanner(System.in);
    int i = 1;

    String[] cheeses = new String[]{"American", "Brie", "Cheddar", "Pepper Jack"};
       System.out.println("Choose the number for your meat: ");
        for (String cheese : cheeses) {
        System.out.print(i + ": ");
        System.out.println(cheese);
        i += 1;
    }
    int cheeseIndex = scan.nextInt();
    String cheeseChoice = cheeses[cheeseIndex - 1];

        System.out.println("You chose: " + cheeseChoice + "\n");
        return cheeseChoice;
}

}

class PriceDatabase {
    private double wheat = 1.25;
    private double white = 1.50;
    private double italian = 1.75;
    private double chicken = 1.15;
    private double beef = 1.45;
    private double veggie = 0.00;
    private double american = 0.50;
    private double brie = 0.50;
    private double cheddar = 0.50;
    private double pepper_jack = 0.50;
    private double lettuce = 0.50;
    private double onions = 0.50;
    private double tomatoe = 0.50;
    private double peppers = 0.50;
    private double pickles = 0.50;

    public double get_price(String item) {
        switch (item) {
            case "Wheat":
                return wheat;
            case "White":
                return white;
            case "Italian":
                return italian;
            case "Chicken":
                return chicken;
            case "Beef":
                return beef;
            case "Veggie":
                return veggie;
            case "Lettuce":
                return lettuce;
            case "Onions":
                return onions;
            case "Tomatoes":
                return tomatoe;
            case "Peppers":
                return peppers;
            case "Pickles":
                return pickles;
            case "American":
                return american;
            case "Brie":
                return brie;
            case "Cheddar":
                return cheddar;
            case "Pepper Jack":
                return pepper_jack;
            default:
                return 0.00;

        }

    }
}
