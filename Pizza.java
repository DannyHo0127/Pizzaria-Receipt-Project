/*
Danny Ho
dkho
12/5/2022
CPSC 1060
*/
public class Pizza {
    //Create private fields int diameter, string name, double area, int numToppings, double topping cost, and array toppingList
    //Then, create a string pizzaToppings to convert the array toppingList to a string, set pizzaToppings to nothing
    private int diameter;
    private String name;
    private double area;
    private int numToppings;
    private double toppingCost;
    private String [] toppingList;
    private String pizzaToppings = "";

    //Set final doubls for cheese, sauce, and dough cost per inch
    final double cheeseCostPerInch = .028;
    final double sauceCostPerInch = .039;
    final double doughCostPerInch = .008;

    //Set private fields equal to the parameters for this pizza constructor
    public Pizza(int diameter, String[] toppingList, String name) {
       this.diameter = diameter;
       this.toppingList = toppingList;
       this.name = name;
    }
    //Create two new setter methods setNumToppings and setToppingCost
    //These method is to transfer more info for the pizza object
    //The numToppings is used for allToppingsToString, to loop the array of toppings into a string plus a comma
    //It is used to determine how many times the allToppingsToString is looped
    //The topping cost is used for calculateToppingCost, the toppingCost is the total cost of toppings order
    //This is to determine the total cost of toppings
    public void setNumToppings(int numToppings) {
        this.numToppings = numToppings;
    }
    public void setToppingCost(double toppingCost) {
        this.toppingCost = toppingCost;
    }
    //This method calculates the total cost of pizza
    //create double totalCost and set totalCost equal to calculateBaseCost plus calculateToppingsCost 
    //return totalCost
    public double calculateTotalCost() {
        double totalCost;
        totalCost = calculateBaseCost() + calculateToppingsCost();
        return totalCost;
    }
    
    //Create a double totalToppings and set it equal to 0.00
    //Set area to calculateArea(diameter)
    //totalToppings will equal to toppingCost times area
    //topping cost is from the pizza object
    //return totalToppings
    private double calculateToppingsCost() {
       double totalToppings = 0.00;
       area = calculateArea(diameter);
       totalToppings = toppingCost * area;
       return totalToppings;
    }

    //Create a double baseCost
    //set area to calculateArea(diameter)
    //Set baseCost to area times cheese cost + area times sauce cost + area times dough cost
    //return baseCost
    private double calculateBaseCost() {
        double baseCost;
        area = calculateArea(diameter);
        baseCost = (area * cheeseCostPerInch ) + (area * sauceCostPerInch) + (area * doughCostPerInch);
        return baseCost;
    }

    //return name for accessor getName method
    public String getName() {
        return name;
    }

    //return diameter for accessor getDiameter method
    public int getDiameter() {
        return diameter;
    }
    //Create an accessor for numToppings. return numToppings
    //This is used for the receipt class to tell if customer ordered toppings or not
    public int getNumToppings() {
        return numToppings;
    }

    //To calculate area, set area equal to diameter/2 times diameter/2 times pi
    //Area of circle is pi time radius times radius
    //Make sure to set double for diameter, since diameter is an int
    ///return area
    private double calculateArea(int diameter) {
        area = (double)(diameter/2.0) * (double)(diameter/2.0) * Math.PI;
        return area;
    }

    //Create a public String allToppingsToString
    //Make a for loop with int i equal to 0, i loop until less than numToppings - 1, increment i by 1
    //In the for loop, set pizzaToppings equal to pizzaToppings plus toppingList[i with comma and space]
    //After the for loop, set pizzaToppings equal to pizzaToppings toppingList[numToppings -1] + a period
    public String allToppingsToString() {
        for(int i = 0; i < numToppings - 1; ++i) {
            pizzaToppings = pizzaToppings + toppingList[i] + ", ";
        }
        pizzaToppings = pizzaToppings + toppingList[numToppings - 1] + ".";
        return pizzaToppings;
    }
    //Create a getter method for pizzaToppings that returns the String pizzaToppings
    //This is used for the receipt class because if we use the allToppingsToString method again, it would duplicate the toppings into the string
    public String getPizzaToppings() {
        return pizzaToppings;
    }
}