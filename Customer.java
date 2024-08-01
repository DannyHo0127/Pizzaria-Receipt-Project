/*
Danny Ho
dkho
12/5/2022
CPSC 1060
*/
public class Customer {
    //Create private fields String name, boolean isRewardsMember,  double rewardsPoiints and set it 20.0
    //Create privat long phoneNumber and String email
    private String name;
    private boolean isRewardsMember;
    private double rewardsPoints = 20.0;
    private long phoneNumber;
    private String email;

    //Create a customer constrcutor with parameter String name and set the private name equal to parameter
    //This is for customers who choose not to be a rewards member
    public Customer(String name) {
        this.name = name;
    }

    //Create another customer constructor with parameters String name, long phoneNumber, and String email
    //Set private fields equal to parameters
    //This constructor is for customers who wants to be a rewards members
    public Customer(String name, long phoneNumber, String email) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    //for this method, set rewardspoints equal to rewards points plus points 
    public void addRewardsPoints(double points) {
        rewardsPoints = rewardsPoints + points;
    }

    //for this method, set rewardspoints equal to rewards points minus points
    public void useRewardsPoints(double points) {
        rewardsPoints = rewardsPoints - points;
    }

    //Create a setter or mutator setIsRewardsMember to see if this customer is a rewards member or not
    //This method has a parameter isRewardsMember, which can return true or false
    //set the private boolean isRewardsMember equal to the parameter
    public void setIsRewardsMember(boolean isRewardsMember){
        this.isRewardsMember = isRewardsMember;
    }
    
    //Create an accessor getName to return customer Name
    //This is used for the receipt to print out the customer's name
    public String getName() {
        return name;
    }
    
    //Create an accessor getRewardsPoints and return rewardsPoints
    //This is used for the receipt to tell the customer how many points are left
    public double getRewardsPoints() {
        return rewardsPoints;
    }

    //Create an access getIsRewardsMember and return isRewardsMember
    //This is used to determine if this customer is a rewardsMember or not in the receipt
    //If they are, use points
    //If not, don't use the points
    public boolean getIsRewardsMember() {
        return isRewardsMember;
    }
}
