public class Toppings {
    private String name;
    private double costPerInch;

    //In this constructor, set the private name equal to the parameter name
    //Then, make an if statement that if the name is any of the available toppings, set the costPerInch equal to the cost of what the specific topping cost per inch
    Toppings(String name) {
        this.name = name;
        if (name.equals("Pepperoni") || name.equals("pepperoni")) {
            costPerInch = 0.02;
        }
        else if (name.equals("Onions") || name.equals("onions")) {
            costPerInch = 0.005;
        }
        else if (name.equals("Peppers") || name.equals("peppers")) {
            costPerInch = 0.01;
        }
        else if (name.equals("Bacon") || name.equals("bacon")) {
            costPerInch = 0.03;
        }
        else if (name.equals("Chicken") || name.equals("chicken")) {
            costPerInch = 0.04;
        }
        else if (name.equals("Mushrooms") || name.equals("mushrooms")) {
            costPerInch = 0.005;
        }
    }

    //Return the name for the getName accessor
    public String getName() {
        return name;
    }
    
    //Return the costPerInch for the getCostPerInch accessor
    public double getCostPerInch() {
        return costPerInch;
    }
}
