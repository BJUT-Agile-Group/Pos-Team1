package pos_main;

import domains.*;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by xyl_c on 2014/12/30.
 */
public class pos_main {
    public static void main(String [] args) throws IOException {
        int m;
        Item cokeCola1 = new Item();
       // Item cokeCola1 = new Item("ITEM000004", "电池", "个", 2.00,0.8);
       // Item cokeCola2 = new Item("ITEM000010", "可口可乐", "个", 3.00,0.8);
        ArrayList<Item> cokeCola = new ArrayList<Item>();
        String fs=new String("F:\\POS-Seed(1)\\POS-Seed\\1.txt");
        String fl=new String("F:\\POS-Seed(1)\\POS-Seed\\2.txt");

        user use=new user();
        userData out=new userData();
        use.setuser();
        use.adduser();
        out=use.getOut();
        System.out.print(out.getUsercode());
        System.out.print(out.get_name());
        //System.out.print(toString(out.get_isvip()));
        cokeCola=cokeCola1.setmenu(fl,fs);

        ShoppingChart shoppingChart = new ShoppingChart();
        for(m=0;m<cokeCola.size();m++) {
            shoppingChart.add(cokeCola.get(m));
        }
        Pos pos = new Pos();
        System.out.println(pos.getShoppingList(shoppingChart));
    }
}
