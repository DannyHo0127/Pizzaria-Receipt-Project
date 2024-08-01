import java.util.ArrayList;
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class Pizzeria {
    public static void main(String[] args) {
        //Create a scanner and variables, booleans, character fields
        //Create a file output Stream called file stream and printWriter named outFS
        //Make Char userInput to read the next char input 
        //Create three booleans: exitMenu, validDiameter, and validToppings, set all to false
        //exitMenu is to keep track if the user wants to exit the menu or continue building pizzas
        //validDiameter is to test if the diameter is valid or not and ValidToppings is to test if numToppings is valid or not
        //Create String userName for the name, and int pizzaDiameter and numToppings
        //Then, create a string called toppingName to read topping inputs
        //Create double totalCost to keep tract of costs and set it equal to 0.00
        //Then, create an ArrayList called pizza to store and keep count on pizzas being made
        //Create int tipAmount and double tipPercent. Tip amound read the customer input and tipPercent convert the tip amount to a percentage
        //Create a boolean validTip to see if the input for tip is valid or not
        //Create int pizzaRemove to read input of customer if customer wants to delete a pizza
        //Create boolean validRemoval to test if the pizzaRemove input is valid or not
        //Create String customerName for their name, String customerResponse to see if they want to be a member or not
        //two booleans validResponse to check if response is valid or not and isMember to see if customer is a member or not
        //Set both booleans to false
        //Create longPhone number and set it equal to 0 and String customerEmail and set it equal to null
        //Create boolean willUseRewardsPoints to see if customer wants to use it or not
        //Create String customerPointResonse to record the customer's response to using points
        Scanner scnr = new Scanner(System.in);
        FileOutputStream fileStream = null;
        PrintWriter outFS = null;
        char userInput;
        boolean exitMenu = false;
        boolean validDiameter = false;
        boolean validToppings = false;
        String userName;
        int pizzaDiameter;
        int numToppings;
        String toppingName;
        double totalCost = 0.00;
        ArrayList<Pizza> pizzas = new ArrayList<Pizza>();
        int tipAmount;
        double tipPercent;
        boolean validTip = false;
        int pizzaRemove;
        boolean validRemoval = false;
        String customerName;
        String customerResponse;
        boolean validResponse = false;
        boolean isMember = false;
        long phoneNumber = 0;
        String customerEmail = null;
        boolean willUseRewardsPoints = false;
        String customerPointsResponse;
        
        //Print out intro and ask customer's name and set scanner for customerName
        //print the methos printMenu, which is a method to print out all menu options
        //Then set up scanner for userInput to read input chars from user
        System.out.println("Welcome to Adkins Pizzeria!");
        System.out.println("");
        System.out.println("What is your name?");
        customerName = scnr.next();
        System.out.println("Here are your options of what you can do:");
        System.out.println("");
        printMenu();
        userInput = scnr.next().charAt(0);

        //Make a while loop that while exitMenu is false, continue looping the menu
        //Make an if, else if, and else statement inside the while loop
        while (exitMenu == false){
            //If userInput is z, print questions and set scanners for userName, pizzaDiameter, and numToppings
            //Make a while loop for diameter that while validDiameter is false:
            //make an if statement that if pizzaDiameter is less than 6 or greater than 54,
            //then, print and ask user to input a correct size
            //Else, set validDiameter to true, meaning pizzaDiameter is valid, then set validDiameter to false to reset the loop
            //Do the same thing for numToppings as well, make a while loop with validToppings to false
            //make an if statement that if toppings is less than 0 or greater than 6,
            //Ask user to re enter a valid topping number
            //else means numToppings is valid, set validTopping to true, and reset the loop by setting ValidTopping to false again
            if (userInput == 'z') {
                System.out.println("");
                System.out.println("What would you like the name of this pizza to be?");
                System.out.println("");
                userName = scnr.next();
                System.out.println("");
                System.out.println("Ok, what size would you like your pizza to be?");
                System.out.println("");
                pizzaDiameter = scnr.nextInt();
                while(validDiameter == false) {
                    if (pizzaDiameter < 6 || pizzaDiameter > 54) {
                        System.out.println("");
                        System.out.println("Please put in a correct pizza size (6-54)");
                        System.out.println("");
                        pizzaDiameter = scnr.nextInt();
                    }
                    else {
                        validDiameter = true;
                    }
                }
                validDiameter = false;
                System.out.println("");
                System.out.println("How many toppings would you like on your pizza?");
                System.out.println("");
                numToppings = scnr.nextInt();
                while(validToppings == false) {
                    if (numToppings < 0 || numToppings > 6) {
                        System.out.println("");
                        System.out.println("Please put in a correct number of toppings (0-6)");
                        System.out.println("");
                        numToppings = scnr.nextInt();
                    }
                    else {
                        validToppings = true;
                    }
                }
                validToppings = false;
                //Create a string array with size numToppings
                //Create a double topping cost and set it equal to 0.0
                //Make an if statement that if numToppings is greater than 0, 
                //make a for loop with int i = 0, i loop until less than numToppings, and increment i by 1
                //In the for loop, print out what topping customer would like with scanner for toppingName
                //make an if statement that while method isValidTopping is false, make and if-else statement
                //If isValidTopping return true, break out of while loop
                //else, print and ask customer to enter valid toppings with a scanner
                //After the while loop, set toppingList[i] equal to toppingName
                //Create topping object to the topping class constructor
                //Set topping cost equal to topping cost plus topping.getcostPerInch(accessor) in the topping class
                String [] toppingList = new String[numToppings];
                double toppingCost = 0.0;
                if (numToppings > 0) {
                    for (int i = 0; i < numToppings; ++i) {
                        System.out.println("What topping would you like?");
                        toppingName = scnr.next();
                        while(isValidTopping(toppingName) == false) {
                            if (isValidTopping(toppingName) == true){
                            break;
                            }
                            else {
                                System.out.println("Invalid Topping. Please input one of the following available toppings: Pepperoni, Bacon, Mushrooms, Chicken, Peppers, Onions");
                                toppingName = scnr.next();
                            }
                        }
                        toppingList[i] = toppingName;
                        Toppings topping = new Toppings(toppingName);
                        toppingCost = toppingCost + topping.getCostPerInch();
                    }
                }
                //Then, create a pizza object with parameters of diameter, array toppingList, userName for the pizza class
                //Set two pizza methods for setNumToppings and setToppingCost to transfer the parameters numTopppings and topping cost
                //The numToppings is used for a loop to print out what toppings the customer ordered
                //The toppingCost is used to determine the total cost of toppings the customer ordered.
                //Then, add the object pizza into the ArrayList pizzas to keep track of orders
                //Print out that pizza of the name and diameter has been added
                //Then, make an if statement that if numToppings is 0, print the userName's pizza has no toppings
                //else, print the userName has the following toppings: with the method allToppingsToString() from the pizza class
                //this method puts all the toppings to a string and return that string
                //Set totalCost equal to total cost plus pizza object of the calculatedTotalCost
                //Then print how much the pizza cost to two decimal places
                //Then, print what would the user like to do next
                //Then, printMenu and set userInput scanner to see what the user wants to do next
                Pizza pizza = new Pizza(pizzaDiameter, toppingList, userName);
                pizza.setNumToppings(numToppings);
                pizza.setToppingCost(toppingCost);
                pizzas.add(pizza);
                System.out.println("Added a pizza named " + userName + " with a " + pizzaDiameter + " inch diameter.");
                System.out.println("");
                if (numToppings == 0) {
                    System.out.println(userName + " has the following toppings: NONE ");
                }
                else {
                    System.out.print(userName + " has the following toppings: ");
                    System.out.println(pizza.allToppingsToString());
                    System.out.println("");
                }
                totalCost = totalCost + pizza.calculateTotalCost();
                System.out.println("");
                System.out.printf("This pizza costs $%.2f.\n", pizza.calculateTotalCost());
                System.out.println("");
                System.out.println("What would you like to do next?");
                System.out.println("");
                printMenu();
                userInput = scnr.next().charAt(0);
            }
            //else if userInput is t, print out totalCost to two decimal places
            //Then, print what would the user like to do next
            //Then printMenu and set userInput scanner to see what the user wants to do next
            else if (userInput == 't'){
                System.out.println("");
                System.out.printf("Total: $%.2f\n", totalCost);
                System.out.println("");
                System.out.println("What would you like to do next?");
                System.out.println("");
                printMenu();
                userInput = scnr.next().charAt(0);
            }
            //else if userInput is q, clear the ArrayList Pizza and reset totalCost
            //Then, print the introduction again to go on to the next customer
            else if (userInput == 'q') {
                pizzas.clear();
                totalCost = 0.00;
                System.out.println("Welcome to Adkins Pizzeria!");
                System.out.println("");
                System.out.println("What is your name?");
                customerName = scnr.next();
                System.out.println("Here are your options of what you can do:");
                System.out.println("");
                printMenu();
                userInput = scnr.next().charAt(0);
            }
            //else if userInput is r, make and if else statement
            else if (userInput =='r') {
                //If the ArrayList pizzas is empty, print out that customer can not get a receipt if they haven't ordered anything
                //Print out what the customer would like to do next with the printMenu and userInput scanner
                if (pizzas.isEmpty()) {
                    System.out.println("");
                    System.out.println("You can't get a receipt if you haven't ordered anything!");
                    System.out.println("");
                    System.out.println("What would you like to do next?");
                    System.out.println("");
                    printMenu();
                    userInput = scnr.next().charAt(0);
                }
                //Else means that the customer have already ordered
                //Print out if customer wants to be a rewards member or not 
                //Set up scanner for customerResponse
                //Then create a while loop to check if customer response is valid or not
                //While valid response is false, if customerResponse is yea or no set valid response to true
                //else, ask the custome to say yes or no and set up scanner
                //Then, reset by setting validResponse to false again
                //Make an if statement that if customer says yes, set isMember equal to true, else set isMember to false
                //Create an if statement that if isMember is true
                //Print questions and set scanners for customer's phoneNumber and email use the variables phoneNumber and customerEmail
                //Then, ask if customer wants to use their points and set scanner for customerPointResponse
                //Create a while statement to check if customerPointResponse if valid
                //While validResponse is false, make an if else statement
                //if the response if yes or no, set validResponse to true
                //Else ask the customer to select yes or no and set up scanner for customerPointResponse
                //Then, make an if else statement that 
                //if customerPointResponse is yes, set willUseRewardsPoints to true and print that the rewards points are used
                //else, set willUseRewardsPoints to false
                //Print out to ask customer for tip percent and set scanner for tipAmount
                //Make a while loop that while validTip is false, make and if else statement
                //If tipAmount is less than 0 and greater than 100, print out the tip is invalid and ask customer to input again between 0 and 100
                //Set scanner again for tipAmount
                //Else mean that tipAmount is valid and set validTip to true
                //Set validTip to false again to reset the validTip loop Checker for the next customer
                //Set tipPercent equal to tipAmount divide by 100.0, converting int tipAmount to double tipPercent
                else {
                    System.out.println("Alright, " + customerName + " before we print out your receipt, would you like to become a rewards member?");
                    customerResponse = scnr.next();
                    while(validResponse == false) {
                        if (customerResponse.equalsIgnoreCase("Yes") || customerResponse.equalsIgnoreCase("No")) {
                            validResponse = true;
                        }
                        else {
                            System.out.println("Please select either Yes or No.");
                            customerResponse = scnr.next();
                        }
                    }
                    validResponse = false;
                    if (customerResponse.equalsIgnoreCase("Yes")) {
                        isMember = true;
                    }
                    else {
                        isMember = false;
                    }
                    if (isMember == true) {
                        System.out.println("Ok, I am going to sign you up for our rewards program.");
                        System.out.println("Can I have your phone number?");
                        phoneNumber = scnr.nextLong();
                        System.out.println("And can I have an email?");
                        customerEmail = scnr.next();
                        System.out.println("Would you like to use your rewards?");
                        System.out.println("You have 20.0 points");
                        customerPointsResponse = scnr.next();
                        while(validResponse == false) {
                            if (customerPointsResponse.equalsIgnoreCase("Yes") || customerPointsResponse.equalsIgnoreCase("No")) {
                                validResponse = true;
                            }
                            else {
                                System.out.println("Please select either Yes or No.");
                                customerPointsResponse = scnr.next();
                            }
                        }
                        if (customerPointsResponse.equalsIgnoreCase("Yes")) {
                            willUseRewardsPoints = true;
                            System.out.println("Ok, we will use the rewards points from your account today.");
                        }
                        else {
                            willUseRewardsPoints = false; 
                        }
                    }
                    validResponse = false;
                    System.out.println("Please input a tip percent.");
                    tipAmount = scnr.nextInt();
                    while(validTip == false) {
                        if (tipAmount < 0 || tipAmount > 100) {
                            System.out.println("Invalid tip percent. Please input a tip percent between 0 and 100.");
                            tipAmount = scnr.nextInt();
                        }
                        else {
                            validTip = true;
                        }
                    }
                    validTip = false;
                    tipPercent = tipAmount / 100.0;
                    //Make an if else statement that if customer is a member
                    //Create a customer object with parameters customerName, phoneNumber, and customerEmail
                    //Also, use setter customer2.setIsRewardsMember(isMember) to tell customer.java that the customer is a rewardsMembers
                    //Then, set isMember to false for the next customer
                    //Create a receipt constructor with parameters ArrayList pizzas, doubletipPercent, customer object, and boolean willUseRewardsPoints
                    //Then set receipt methods to print out pizzaInformation and ending calculation results
                    //The pizzaInformation method will print out each pizza created with toppings and cost respectively
                    //then, use the addEndingCalculation method will print out the total, tip, tax, rewardspoints used, final cost, points added, and points remaining
                    //Then, use a try and catch statement to export results into a text file
                    //Try created a fileStream named customeName + Receipt.txt
                    //Also set printWriter outFS to fileStream
                    //Then use the statement outFS.println(receipt.getReceiptInfo) to print the receipt into a text file
                    //The receipt.getReceiptInfo returns a string that contains the customer's receipt content
                    //Then, print out that the Receipt is Made and close the print write outFS
                    //Then, catch any file exceptions and print out that there was an error to printing the receipt.
                    //Then, clear the ArrayList pizzas and set totalCost to 0.00 so the next customer can get a new receipt for new pizzas
                    //else means that customer is not a rewardsmember,
                    //Create a customer object with only customerName as the parameter
                    //Use setter customer1.setIsRewardsMember to tell customer.java that this customer is not a rewards member
                    //then, create a receipt object with parameters ArrayList pizzas, double tipPercent, customer object, and boolean willUseRewardsPoints
                    //Then set receipt methods to print out pizzaInformation and ending calculation results
                    //Then pizzaInformation method will print out each pizza created with toppings and cost respectively
                    //then, use the addEndingCalculation method will print out the total, tip, tax, rewardspoints used, final cost, points added, and points remaining
                    //Use the same try and catch statement for the if statement to print out receipt to text file
                    //Then, clear the ArrayList pizzas and set totalCost to 0.00 so the next customer can get a new receipt for new pizzas
                    //after the if else statement, print out introduction again
                    //Ask for customer's name and set customerName scanner and print menu with userInput scanner
                    if (isMember == true){
                        Customer customer2 = new Customer(customerName, phoneNumber, customerEmail);
                        customer2.setIsRewardsMember(isMember);
                        isMember = false;
                        Receipt receipt = new Receipt(pizzas, tipPercent, customer2, willUseRewardsPoints);
                        receipt.pizzaInformation();
                        receipt.addEndingCalculations();
                        try {
                            fileStream = new FileOutputStream(customer2.getName() + "Receipt.txt");
                            outFS = new PrintWriter(fileStream);
                            outFS.println(receipt.getReceiptInfo());
                            System.out.println("Receipt Made");
                            outFS.close();
                        }
                        catch (FileNotFoundException exception) {
                            System.out.println("Error making receipt");
                         }         
                        pizzas.clear();
                        totalCost = 0.00;
                    }
                    else {
                        Customer customer1 = new Customer(customerName);
                        customer1.setIsRewardsMember(isMember);
                        Receipt receipt = new Receipt(pizzas, tipPercent, customer1, willUseRewardsPoints);
                        receipt.pizzaInformation();
                        receipt.addEndingCalculations();
                        try {
                            fileStream = new FileOutputStream(customer1.getName() + "Receipt.txt");
                            outFS = new PrintWriter(fileStream);
                            outFS.println(receipt.getReceiptInfo());
                            System.out.println("Receipt Made");
                            outFS.close();
                        }
                        catch (FileNotFoundException exception) {
                            System.out.println("Error making receipt");
                         }     
                        pizzas.clear();
                        totalCost = 0.00;
                    }
                    System.out.println("Welcome to Adkins Pizzeria!");
                    System.out.println("");
                    System.out.println("What is your name?");
                    customerName = scnr.next();
                    System.out.println("Here are your options of what you can do:");
                    System.out.println("");
                    printMenu();
                    userInput = scnr.next().charAt(0);
                }
            }
            //if userInput is d, create an if else statement
            else if (userInput == 'd') {
                //if ArrayList pizzas is empty, print out that customer can not select this option because they havent added a pizza yet
                //Then, ask customer what would they do next and print menu. Then, set scanner for userInput
                if (pizzas.isEmpty()) {
                    System.out.println("");
                    System.out.println("You can not select this menu option until you add a pizza.");
                    System.out.println("");
                    System.out.println("What would you like to do next?");
                    System.out.println("");
                    printMenu();
                    userInput = scnr.next().charAt(0);
                }
                //Else means that customer has made a pizza and would like to remove a certain pizza
                //Print out what customer would like to delete and provide a list of pizzas the customered ordered
                //set up a receipt constructor with parameters of the ArrayList pizzas only
                //Then, print out pizzaInformation and ask customer to select a pizza to remove and set up scanner for pizzaRemove
                //Make a while loop to check if pizzaRemove has a valid input
                //while validRemoval is false, make an if else statement
                //If pizzaRemove is less than 1 or greater than ArrayList pizzas size, print out that customer can delete from 1 to pizzas size
                //Then set scanner for pizzaRemove again
                //else means that pizzaRemove input is valid and set validRemoval to true
                //Then set up receipt method removePizza with parameters of int pizzaRemove
                //This method will remove the pizza object in the ArrayList
                //Then print out pizza information infomation to see the results of the pizza removal
                //Then ask the customer what would they like to do next and printMenu and set userInput scanner again
                else {
                    System.out.println("Which pizza would you like to delete?");
                    System.out.println("Here is the list of pizzas that are available:");
                    Receipt receipt = new Receipt(pizzas);
                    receipt.pizzaInformation();
                    System.out.println("Please select which number pizza you would like to delete:");
                    pizzaRemove = scnr.nextInt();
                    while(validRemoval == false) {
                        if (pizzaRemove < 1 || pizzaRemove > pizzas.size()){
                            System.out.println("You can only delete pizzas numbered 1 to " + pizzas.size());
                            pizzaRemove = scnr.nextInt();
                        }
                        else {
                            validRemoval = true;
                        }
                    }
                    receipt.removePizza(pizzaRemove);
                    System.out.println("");
                    System.out.println("Here is your list of pizzas now:");
                    System.out.println("");
                    receipt.pizzaInformation();
                    System.out.println("");
                    System.out.println("What would you like to do next?");
                    System.out.println("");
                    printMenu();
                    userInput = scnr.next().charAt(0);
                }
            }
            //else if userInput is c, quit the system
            else if (userInput == 'c') {
                System.exit(0);
            }
            //else means that user did not put valid menu option and print to ask user to put valid menu option
            //Set up userInput scanner
            else {
                System.out.println("Please input a valid menu option:");
                userInput = scnr.next().charAt(0);
            }
        }
    }
    //Make a private static void method printMenu to print the menu options and ask the user to make a selection
    private static void printMenu() {
        System.out.println("MENU");
        System.out.println("");
        System.out.println("z - Add a Pizza");
        System.out.println("");
        System.out.println("t - Print the total");
        System.out.println("");
        System.out.println("r - Print the receipt");
        System.out.println("");
        System.out.println("d - Delete a pizza that was ordered");
        System.out.println("");
        System.out.println("q - Quit");
        System.out.println("");
        System.out.println("c - Close the pizzeria for the day");
        System.out.println("");
        System.out.println("Please make a selection:");
        System.out.println("");
    }       

    //Make a private static boolean method isValidTopping with string name
    //Make and if else statement that if the parameter name is one of the valid toppings, return true
    //Else, means that toppingName is not one of the valid Toppings, which returns false
    //Use the .equalsIgnoreCase to ignore the capital and lowercase letters of the parameter name
    private static boolean isValidTopping(String name) {
        if (name.equalsIgnoreCase("Pepperoni")) {
            return true;
        }
        else if (name.equalsIgnoreCase("Onions")) {
            return true;
        }
        else if (name.equalsIgnoreCase("Peppers")) {
            return true;
        }
        else if (name.equalsIgnoreCase("Bacon")) {
            return true;
        }
        else if (name.equalsIgnoreCase("Chicken")) {
            return true;
        }
        else if (name.equalsIgnoreCase("Mushrooms")) {
            return true;
        }
        else {
            return false;
        }
    }
}
