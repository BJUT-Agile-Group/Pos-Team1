package domains;

import java.util.ArrayList;

/**
 * Created by Administrator on 2014/12/28.
 */
public class ShoppingChart {
    private ArrayList<Item> items = new ArrayList<Item>();
    private userData userinfo=new userData();
    public void add(Item item) {
        this.items.add(item);
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void addUser(userData user)
    {
        this.userinfo=user;
    }
    public userData getUserinfo(){
        return  userinfo;
    }
}
