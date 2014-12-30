package domains;

/**
 * Created by Administrator on 2014/12/28.
 */
public class Item {
    private String barCode;
    private String name;
    private String unit;
    private double price;
    private double discount;
    private int account;
    private double subtotal;


    public Item(String barCode, String name, String unit, double price,double discount) {

        this.barCode = barCode;
        this.name = name;
        this.unit = unit;
        this.price = price;
        this.discount=discount;
    }

    public String getName() {
        return name;
    }

    public String getUnit() {
        return unit;
    }

    public double getPrice() {
        return price;
    }
    public double getDiscount(){
        return discount;
    }
    public void count() {
        account= account+1;

    }
    public void setSubtotal()
    {
         subtotal =account*price;
    }
    public int getAccount()
    {
        return account;
    }
    public double getSubtotal()
    {
        return subtotal;
    }
    public void setdiscount()
    {
        subtotal=account*price*discount;
    }
}
