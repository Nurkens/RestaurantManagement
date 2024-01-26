public class VipUser extends User {

    private double discount;
    public VipUser(String userId,String username,double discount){
        super(userId,username,"VIP");
        this.discount = discount;
    }


    public double getDiscount(){
        return discount;
    }

}
