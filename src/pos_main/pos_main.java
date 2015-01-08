package pos_main;

import domains.Item;
import domains.Pos;
import domains.ShoppingChart;
import domains.menu;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by xyl_c on 2014/12/30.
 */
public class pos_main {
    public static void main(String [] args) throws IOException {
        int m;
        Item cokeCola1 = new Item();
        ArrayList<Item> cokeCola = new ArrayList<Item>();
        cokeCola=cokeCola1.setmenu();

        ShoppingChart shoppingChart = new ShoppingChart();
        for(m=0;m<cokeCola.size();m++) {
            shoppingChart.add(cokeCola.get(m));
        }
        Pos pos = new Pos();
        System.out.println(pos.getShoppingList(shoppingChart));
    }
}
