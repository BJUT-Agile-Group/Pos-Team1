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

        ArrayList<userData> vip =  new ArrayList<userData>();

        ArrayList<Item> cokeCola = new ArrayList<Item>();
        String fs=new String("C:\\Users\\xyl_c\\Documents\\Tencent Files\\451126338\\FileRecv\\POS-Seed\\1.txt");
        String fl=new String("C:\\Users\\xyl_c\\Documents\\Tencent Files\\451126338\\FileRecv\\POS-Seed\\2.txt");
        String fu=new String("C:\\Users\\xyl_c\\Documents\\Tencent Files\\451126338\\FileRecv\\POS-Seed\\3.txt");
        user use=new user();
        userData out=new userData();
        use.setuser(fu);
        //读取xml  usercode 跟 integral保存进入相应usercode
        use.getVIPdatafromXML();
        use.adduser(fl);
        out=use.getOut();

        cokeCola=cokeCola1.setmenu(fl,fs);

        ShoppingChart shoppingChart = new ShoppingChart();
        shoppingChart.addUser(out);
        for(m=0;m<cokeCola.size();m++) {
            shoppingChart.add(cokeCola.get(m));
        }
        Pos pos = new Pos();
        System.out.println(pos.getShoppingList(shoppingChart));
        use.change(out);
        //写入xml

    }


}
