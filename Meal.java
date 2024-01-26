public class Meal {
    private String mealId;
    private String name;
    private double price;

    public Meal(String mealId, String name, double price) {
        this.mealId = mealId;
        this.name = name;
        this.price = price;
    }

    public String getMealId() {
        return mealId;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}
