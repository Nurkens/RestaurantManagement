import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;









public class Main {
    public static void main(String[] args) {
        Restaurant restaurantSystem = new Restaurant();

        Meal meal1 = new Meal("1", "Burger", 10.0);
        Meal meal2 = new Meal("2", "Pizza", 15.0);
        Meal meal3 = new Meal("3", "Pasta", 12.0);
        Meal meal4 = new Meal("4","French Fries",4);
        Meal meal5 = new Meal("5","Cold Drinks",14);
        Meal meal6 = new Meal("6","Iced Tea",5);



        restaurantSystem.addMeal(meal1);
        restaurantSystem.addMeal(meal2);
        restaurantSystem.addMeal(meal3);
        restaurantSystem.addMeal(meal4);
        restaurantSystem.addMeal(meal5);
        restaurantSystem.addMeal(meal6);

        VipUser user1 = new VipUser("SNK", "Nurken",0.1);
        VipUser user2 = new VipUser("KAD", "Kadyrzhan",0.1);
        VipUser user3 = new VipUser("NUR", "Nurdaulet",0.1);
        OrdinaryUser user4 = new OrdinaryUser("JN","John");
        restaurantSystem.addUser(user1);
        restaurantSystem.addUser(user2);
        restaurantSystem.addUser(user3);
        restaurantSystem.addUser(user4);



        restaurantSystem.menu();
    }
}
