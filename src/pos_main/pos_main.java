package pos_main;

import domains.Item;
import domains.Pos;
import domains.ShoppingChart;

/**
 * Created by xyl_c on 2014/12/30.
 */
public class pos_main {
    public static void main(String [] args){
        Item cokeCola = new Item("ITEM000004", "电池", "个", 2.00,0.8);
        Item cokeCola1 = new Item("ITEM000004", "电池", "个", 2.00,0.8);
        Item cokeCola2 = new Item("ITEM000010", "可口可乐", "个", 3.00,0.8);
        ShoppingChart shoppingChart = new ShoppingChart();
        shoppingChart.add(cokeCola);
        shoppingChart.add(cokeCola1);
        shoppingChart.add(cokeCola2);
        Pos pos = new Pos();
        System.out.println(pos.getShoppingList(shoppingChart));
    }
}
