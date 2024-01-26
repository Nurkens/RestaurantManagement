class Order {
    private Meal meal;
    private User user;

    public Order(Meal meal, User user) {
        this.meal = meal;
        this.user = user;
    }

    public Meal getMeal() {
        return meal;
    }

    public User getUser() {
        return user;
    }
}