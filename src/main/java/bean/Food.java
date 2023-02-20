package bean;

public class Food {

    private String name;
    private double  cost;

    public Food(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Food(double getCost) {this.cost = cost;}

    public double getCost() {return cost;}
}
