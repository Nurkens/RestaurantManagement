public abstract class User {
    private String userId;
    private String username;

    private String userStatus;



    public User(String userId, String username,String userStatus) {
        this.userId = userId;
        this.username = username;
        this.userStatus = userStatus;

    }

    public String getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }
    public String getUserStatus(){
        return userStatus;
    }


}