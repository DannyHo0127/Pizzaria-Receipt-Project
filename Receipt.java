/*
Danny Ho
dkho
12/5/2022
CPSC 1060
*/
//import a java decimal format statement to round calculations to two decimal places
//I needed to do this, so I can round all the calculations into two decimal places to add to the receiptInfo, so I can print out the receiptInfo into a text file
//Here is a link of where I got this info from: https://mkyong.com/java/java-display-double-in-2-decimal-points/
import java.util.ArrayList;
import java.text.DecimalFormat;
public class Receipt {
    //Create private field ArrayList pizzas, double total set it equal to 0.0, receiptString and set it equal to =RECEIEPT=
    //Create private double tipPercent, object pizzaObject, final double salesTaxRate and set it equal to 0.06
    //Then, create double tipTotal, double taxTotal, and double finalTotal
    //Then, create object customer, boolean willUseRewardsPoints, and double tempFinal
    //The orignalFinal is used because the final total changed because of the points 
    //and I need the original cost to determine how many points the customer earned
    //Create a String called Receipt Info that takes in the receipt content
    //Everytime there is a system.out.print statement I will add the statement into the receiptInfo string with a new line
    //Create a private static final decimalformat named df and round to two decimal places
    private ArrayList<Pizza> pizzas;
    private double total = 0.0;
    private String receiptString = "=======RECEIPT========";
    private double tipPercent;
    private Pizza pizzaObject;
    final double salesTaxRate = 0.06;
    private double tipTotal;
    private double taxTotal;
    private double finalTotal;
    private Customer customer;
    private boolean willUseRewardsPoints;
    private double originalFinal;
    private String receiptInfo;
    private static final DecimalFormat df = new DecimalFormat("0.00");
    

    //Create a receipt constructor with parameters ArrayList pizzas and double tipPercent
    //Set private fields equal to parameters
    //This constructor is used for if userInput is r to print out receipt
    Receipt(ArrayList<Pizza> pizzas, double tipPercent, Customer customer, boolean willUseRewardsPoints) {
        this.pizzas = pizzas;
        this.tipPercent = tipPercent; 
        this.customer = customer;
        this.willUseRewardsPoints = willUseRewardsPoints;
    }

    //Create another receipt constructor with parameters ArrayList and set private fields equal to parameters
    //this constructor is used for if userInput is d to delete pizzas
    Receipt(ArrayList<Pizza> pizzas) {
        this.pizzas = pizzas;
    }

    //Create a void method removePizza with parameters int numRemove
    //This method is remove the pizza the customer asked to remove
    //Set an ArrayList method .remove() and do pizzas.remove(numRemove -1), make sure to -1 to numRemove because index starts at 0
    //This way, the system will remove the pizza object in the ArrayList
    public void removePizza(int numRemove) {
        pizzas.remove(numRemove - 1);
    }

    //Create a void method pizzaInformation(), which goes through the ArrayList and prints out pizza infomation for each pizza ordered
    //Everytime there we print something, add it to the string receiptInfo and use "\n" to print a new line
    //Use the df.format(input) statement to round calculations two to decimal places when addint and print statement into the string
    //First print out receipt string and make a for loop with int i = 0, i loop until less than pizzas size and i increment by 1
    //Set pizzaObject to ArrayList pizzas.get(i) and print out infomation.
    //Print pizza (i+1), since i starts at 0, with the pizzaObject diameter
    //Print out pizzaObject name and has the following toppings
    //make an if else statement that if pizzaObject numToppings is 0, print out NONE
    //Else means that the pizza has toppings and use method pizzaObject.allToppingsToString to print out toppings ordered
    //Then print out cost of the specific pizza to two decimal places
    //Then set total to total plus pizzaObject total calculations
    public void pizzaInformation(){
        System.out.println(receiptString);
        receiptInfo = receiptString + "\n";
        for (int i = 0; i < pizzas.size(); i++) {
            pizzaObject = pizzas.get(i);
            System.out.println("Pizza " + (i + 1) + ": " + pizzaObject.getDiameter() + " inch diameter");
            receiptInfo = receiptInfo + "Pizza " + (i + 1) + ": " + pizzaObject.getDiameter() + " inch diameter\n";
            System.out.print(pizzaObject.getName() + " has the toppings ");
            receiptInfo = receiptInfo + pizzaObject.getName() + " has the toppings ";
            if (pizzaObject.getNumToppings() == 0) {
                System.out.println("NONE");
                receiptInfo = receiptInfo + "NONE\n";
            }
            else {
                System.out.println(pizzaObject.getPizzaToppings());
                receiptInfo = receiptInfo + pizzaObject.getPizzaToppings() + "\n";
            }
            System.out.printf("Cost:  $%.2f\n", pizzaObject.calculateTotalCost());
            receiptInfo = receiptInfo + "Cost:  $" + df.format(pizzaObject.calculateTotalCost()) + "\n";
            total = total + pizzaObject.calculateTotalCost();
        }
    }

    //Create a public void method addEndingCalculations(), which print out the total of pizzas, tax cost, tip cost, and final cost
    //Everytime there we print something, add it to the string receiptInfo and use "\n" to print a new line
    //Use the df.format(input) statement to round calculations two to decimal places when addint and print statement into the string
    //first set receiptString equal to "======"
    //Then, set tax total equal to total  times salesTaxRate
    //Then set tip total equal to total plus taxTota times the tipPercent
    //Then, set final total equal to total plus tipTotal plus taxTotal
    //Then, print out the total of pizzas, taxTotal and tip total to two decimal places
    //Then create and if statement that is customer wants to use rewardspoints
    //create another if statement: if rewardspoints is greater than total
    //Use customer.useRewardsPoints with parameters final total and print out that the rewardsPoints used is the finalTotal
    //Then, set orginalFinal equal to finalTotal and print out final total is 0.00
    //else, means that RewardsPoints is not greater than final total 
    //Print out the rewardsPoints used and set originalFinal equal to final
    //Then, set final total equal to final total minus rewards points 
    //Then, use customer.useRewardsPoints with parameters customer.getRewardsPoints
    //Then, print out final total to two decimal places
    //then else in the first if statement means that the customer does not want to use RewardsPoints
    //Set originalFinal equal to finalTotal and print out finalTotal to two decimal places and rewardsPoints used: 0.00s
    //Then print out receiptString again to format the receipt
    public void addEndingCalculations(){
        receiptString = "======================";
        taxTotal = total * salesTaxRate;
        tipTotal = (total + taxTotal) * tipPercent;
        finalTotal = total + tipTotal + taxTotal;
        System.out.println(receiptString);
        receiptInfo = receiptInfo + receiptString + "\n";
        System.out.printf("Total: $%.2f\n", total);
        receiptInfo = receiptInfo + "Total: $" + df.format(total) + "\n";
        System.out.printf("Tax: $%.2f\n", taxTotal);
        receiptInfo = receiptInfo + "Tax: $" + df.format(taxTotal) + "\n";
        System.out.printf("Tip: $%.2f\n", tipTotal);
        receiptInfo = receiptInfo + "Tip: $" + df.format(tipTotal) + "\n";
        if (willUseRewardsPoints == true){
            if (finalTotal - customer.getRewardsPoints() < 0){
                customer.useRewardsPoints(finalTotal);
                System.out.printf("Rewards Points Used: %.2f\n", finalTotal);
                receiptInfo = receiptInfo + "Rewards Points Used: " + df.format(finalTotal) + "\n";
                originalFinal = finalTotal;
                System.out.println("Final Total: $0.00");
                receiptInfo = receiptInfo + "Final Total: $0.00\n";
            }
            else {
                System.out.printf("Rewards Points Used: %.2f\n", customer.getRewardsPoints());
                receiptInfo = receiptInfo + "Rewards Points Used: " + df.format(customer.getRewardsPoints()) + "\n";
                originalFinal = finalTotal;
                finalTotal = finalTotal - customer.getRewardsPoints();
                customer.useRewardsPoints(customer.getRewardsPoints());
                System.out.printf("Final Total: $%.2f\n", finalTotal);
                receiptInfo = receiptInfo + "Final Total: $" + df.format(finalTotal) + "\n";
            }
        }
        else {
            originalFinal = finalTotal;
            System.out.println("Rewards Points Used: 0.00");
            receiptInfo = receiptInfo + "Rewards Points Used: 0.00\n";
            System.out.printf("Final Total: $%.2f\n", finalTotal);
            receiptInfo = receiptInfo + "Final Total: $" + df.format(finalTotal) + "\n";
        }
        System.out.println(receiptString);
        receiptInfo = receiptInfo + receiptString + "\n";
        //Make an if statement that is customer is a rewards member print out that todays transaction for customer name
        //Print out the rewardsPoints added was (originalFinal times 0.20) 
        //Use customer.addRewardsPoints with parameters (originalFinal times 0.20) to add rewardspoints in the customer.java
        //Then print out how many points are remaining by using the accessor customer.getRewardsPoints()
        //Then print out receiptString
        //else means that customer is not a member and print out transaction for customer's name
        //Then, print that customer did not gain or have rewards points and print receiptString
        if (customer.getIsRewardsMember() == true){
            System.out.println("Today's Transaction for " + customer.getName() + ":");
            receiptInfo = receiptInfo + "Today's Transaction for " + customer.getName() + ":\n";
            System.out.printf("Rewards Points Added: %.2f\n",(originalFinal * 0.20));
            receiptInfo = receiptInfo + "Rewards Points Added: " + df.format(originalFinal * 0.20) + "\n";
            customer.addRewardsPoints(originalFinal * 0.20);
            System.out.printf("Rewards Points Remaining: %.2f\n", customer.getRewardsPoints());
            receiptInfo = receiptInfo + "Rewards Points Remaining: " + df.format(customer.getRewardsPoints()) + "\n";
            System.out.println(receiptString);
            receiptInfo = receiptInfo + receiptString + "\n";
        } 
        else {
            System.out.println("Today's Transaction for " + customer.getName() + ":");
            receiptInfo = receiptInfo + "Today's Transaction for " + customer.getName() + ":\n";
            System.out.println("Rewards Points Added: 0.00");
            receiptInfo = receiptInfo + "Rewards Points Added: 0.00\n";
            System.out.println("Rewards Points Remaining: 0.00");
            receiptInfo = receiptInfo + "Rewards Points Remaining: 0.00\n";
            System.out.println(receiptString);
            receiptInfo = receiptInfo + receiptString + "\n";
        }
    }

    //Create an accessor name getReceiptInfo that returen the string receiptInfo
    public String getReceiptInfo() {
        return receiptInfo;
    }
}
