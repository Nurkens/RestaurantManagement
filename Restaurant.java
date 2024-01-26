import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Restaurant {
    private List<Meal> menu;
    private List<User> users;
    private List<Order> orders;

    public Restaurant() {
        menu = new ArrayList<>();
        users = new ArrayList<>();
        orders = new ArrayList<>();
    }

    public void showMenu() {
        System.out.println("===== Menu =====");
        for (Meal meal : menu) {
            System.out.println(meal.getMealId() + " - " + meal.getName() + " - $" + meal.getPrice());
        }
        System.out.println("================");
    }



    public void addMeal(Meal meal) {
        menu.add(meal);
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void orderMeal(Meal meal, User user) {
        if ("VIP".equals(user.getUserStatus())) {
            VipUser vipUser = (VipUser) user;
            double discountedPrice = meal.getPrice() * (1 - vipUser.getDiscount());
            Meal discountedMeal = new Meal(meal.getMealId(), meal.getName(), discountedPrice);
            orders.add(new Order(discountedMeal, user));
        } else {
            orders.add(new Order(meal, user));
        }
        System.out.println("Order placed successfully.");
    }

    public void editOrder(Order order, Meal newMeal) {
        order = new Order(newMeal, order.getUser());
        System.out.println("Order edited successfully.");
    }

    public void cancelOrder(Order order) {
        orders.remove(order);
        System.out.println("Order canceled successfully.");
    }

    public void menu() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("===== Restaurant Management System =====");
            System.out.println("1. Show Menu");
            System.out.println("2. Add a New Meal");
            System.out.println("3. Add a New User");
            System.out.println("4. Order a Meal");
            System.out.println("5. Edit an Order");
            System.out.println("6. Cancel an Order");
            System.out.println("7. Exit");
            System.out.println("8:Show users");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                showMenu();
            } else if (choice == 2) {
                System.out.println("\n== Add a New Meal ==\n");
                System.out.print("Enter meal ID: ");
                String mealId = scanner.nextLine();
                System.out.print("Enter meal name: ");
                String mealName = scanner.nextLine();
                System.out.print("Enter meal price: $");
                double mealPrice = scanner.nextDouble();
                scanner.nextLine(); // Consume newline

                addMeal(new Meal(mealId, mealName, mealPrice));
                System.out.println("Meal added successfully.");
            } else if (choice == 3) {
                System.out.println("\n== Add a New User ==\n");
                System.out.print("Enter user ID: ");
                String userId = scanner.nextLine();
                System.out.print("Enter username: ");
                String username = scanner.nextLine();
                System.out.println("Enter the status of the user (VIP/Ordinary): ");
                String userStatus = scanner.nextLine();

                if ("VIP".equalsIgnoreCase(userStatus)) {
                    System.out.print("Enter discount for VIP user (0.10 for 10%): ");
                    double discount = scanner.nextDouble();
                    scanner.nextLine();
                    addUser(new VipUser(userId, username, discount));
                } else {
                    addUser(new OrdinaryUser(userId, username));
                }

                System.out.println("User added successfully.");
            } else if (choice == 4) {
                System.out.println("\n== Order a Meal ==\n");
                showMenu();
                System.out.print("Enter meal ID you want to order: ");
                String mealId = scanner.nextLine();
                System.out.print("Enter your user ID: ");
                String userId = scanner.nextLine();

                Meal selectedMeal = null;
                for (Meal meal : menu) {
                    if (meal.getMealId().equals(mealId)) {
                        selectedMeal = meal;
                        break;
                    }
                }

                User selectedUser = null;
                for (User user : users) {
                    if (user.getUserId().equals(userId)) {
                        selectedUser = user;
                        break;
                    }
                }

                if (selectedMeal != null && selectedUser != null) {
                    orderMeal(selectedMeal, selectedUser);
                } else {
                    System.out.println("Invalid meal ID or user ID.");
                }
            } else if (choice == 5) {
                System.out.println("\n== Edit an Order ==\n");

            } else if (choice == 6) {
                System.out.println("\n== Cancel an Order ==\n");

            } else if (choice == 7) {
                break;}
            else if (choice == 8) {
                    showOrdersByUser();
                }
            else {
                System.out.println("Invalid choice. Please enter a valid option.");
            }
        }

        System.out.println("\nThank you for using the Restaurant Management System!");
    }
    public void showOrdersByUser() {
        System.out.println("===== Orders by User =====");
        for (User user : users) {
            System.out.println("User: " + user.getUsername());


            boolean hasOrders = false;
            for (Order order : orders) {
                if (order.getUser().equals(user)) {
                    System.out.println("  - " + order.getMeal().getName() + " - $" + order.getMeal().getPrice());
                    hasOrders = true;
                }
            }

            if (!hasOrders) {
                System.out.println("No orders placed.");
            }

            System.out.println("===========================");
        }
    }


}