import domains.*;
import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by Administrator on 2014/12/28.
 */
public class PosTest {
    @Test
    public void testReadrightfile() throws Exception {
        // given
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
        System.out.println("成功读取文件！");
    }//正确的

    @Test
    public void testReadwrongfl() throws  Exception{
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
    }//找不到文件

    @Test
    public void testmemberfilewrong() throws Exception{
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
    }//会员文档读入有误

    @Test
    public void testlistfilewrong() throws Exception{
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
    }//商品列表文件读入错误

    @Test
    public void testproductmenufilewrong() throws Exception{
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
    }//商品索引文件读取错误

    @Test
    public void testamemberbuyonekindonegoodswithnodiscount() throws Exception{
        int m;
        Item cokeCola1 = new Item();

        ArrayList<userData> vip =  new ArrayList<userData>();

        ArrayList<Item> cokeCola = new ArrayList<Item>();
        String fs=new String("C:\\Users\\xyl_c\\Documents\\Tencent Files\\451126338\\FileRecv\\POS-Seed\\1.txt");
        String fl=new String("C:\Users\yQ\Documents\Tencent Files\799782239\FileRecv\FileRecv\POS-Seed\test\列表信息\\list.txt");
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
        String actualShoppingList=pos.getShoppingList(shoppingChart);
        String expectShoppingList=
                "***商店购物清单***\n"
                +"会员编号：USER 001积分：0\n"
                +"----------------------\n"
                +"名称：可口可乐，数量：1瓶，单价：3.00(元)，小计：3.00(元)\n"
                +"----------------------\n"
                +"总计：3.00(元)\n"
                +"**********************\n";
        assertThat(actualShoppingList,is(expectShoppingList));
    }//一个会员买了一个一种不打折商品

    @Test
    public void testamemberbuyonekindonegoodswithdiscount() throws Exception{
        int m;
        Item cokeCola1 = new Item();

        ArrayList<userData> vip =  new ArrayList<userData>();

        ArrayList<Item> cokeCola = new ArrayList<Item>();
        String fs=new String("C:\\Users\\xyl_c\\Documents\\Tencent Files\\451126338\\FileRecv\\POS-Seed\\1.txt");
        String fl=new String("C:\Users\yQ\Documents\Tencent Files\799782239\FileRecv\FileRecv\POS-Seed\test\列表信息 - 副本\\list.txt");
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
        String actualShoppingList=pos.getShoppingList(shoppingChart);
        String expectShoppingList=
                "***商店购物清单***\n"
                        +"会员编号：USER 001积分：0\n"
                        +"----------------------\n"
                        +"名称：电池，数量：1个，单价：2.00(元)，小计：1.20(元)\n"
                        +"----------------------\n"
                        +"总计：1.20(元)\n"
                        +"节省：0.80(元)\n"
                        +"**********************\n";
        assertThat(actualShoppingList,is(expectShoppingList));
    }//一个会员买了一个一种打折商品

    @Test
    public void testapersonbuyonekindonegoodswithnodiscount() throws Exception{
        int m;
        Item cokeCola1 = new Item();

        ArrayList<userData> vip =  new ArrayList<userData>();

        ArrayList<Item> cokeCola = new ArrayList<Item>();
        String fs=new String("C:\\Users\\xyl_c\\Documents\\Tencent Files\\451126338\\FileRecv\\POS-Seed\\1.txt");
        String fl=new String("C:\Users\yQ\Documents\Tencent Files\799782239\FileRecv\FileRecv\POS-Seed\test\列表信息 - 副本 (2)\\list.txt");
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
        String actualShoppingList=pos.getShoppingList(shoppingChart);
        String expectShoppingList=
                "***商店购物清单***\n"
                        +"名称：雪碧，数量：1瓶，单价：3.00(元)，小计：3.00(元)\n"
                        +"----------------------\n"
                        +"总计：3.00(元)\n"
                        +"**********************\n";
        assertThat(actualShoppingList,is(expectShoppingList));
    }//一个普通人买了一个一种不打折商品

    @Test
    public void testapersonbuyonekindonegoodswithdiscount() throws Exception{
        int m;
        Item cokeCola1 = new Item();

        ArrayList<userData> vip =  new ArrayList<userData>();

        ArrayList<Item> cokeCola = new ArrayList<Item>();
        String fs=new String("C:\\Users\\xyl_c\\Documents\\Tencent Files\\451126338\\FileRecv\\POS-Seed\\1.txt");
        String fl=new String("C:\Users\yQ\Documents\Tencent Files\799782239\FileRecv\FileRecv\POS-Seed\test\列表信息 - 副本 (3)\\list.txt");
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
        String actualShoppingList=pos.getShoppingList(shoppingChart);
        String expectShoppingList=
                "***商店购物清单***\n"
                        +"名称：电池，数量：1个，单价：2.00(元)，小计：1.60(元)\n"
                        +"----------------------\n"
                        +"总计：1.60(元)\n"
                        +"节省：0.40(元)\n"
                        +"**********************\n";
        assertThat(actualShoppingList,is(expectShoppingList));
    }//一个普通人买了一个一种打折商品

    @Test
    public void testamemberbuymanykindsonegoods() throws Exception{
        int m;
        Item cokeCola1 = new Item();

        ArrayList<userData> vip =  new ArrayList<userData>();

        ArrayList<Item> cokeCola = new ArrayList<Item>();
        String fs=new String("C:\\Users\\xyl_c\\Documents\\Tencent Files\\451126338\\FileRecv\\POS-Seed\\1.txt");
        String fl=new String("C:\Users\yQ\Documents\Tencent Files\799782239\FileRecv\FileRecv\POS-Seed\test\列表信息 - 副本 (4)d\\list.txt");
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
        String actualShoppingList=pos.getShoppingList(shoppingChart);
        String expectShoppingList=
                "***商店购物清单***\n"
                        +"会员编号：USER 001积分：2\n"
                        +"----------------------\n"
                        +"名称：可口可乐，数量：1瓶，单价：3.00(元)，小计：3.00(元)\n"
                        +"名称：雪碧，数量：1瓶，单价：3.00(元)，小计：3.00(元)\n"
                        +"名称：电池，数量：1个，单价：2.00(元)，小计：1.20(元)\n"
                        +"----------------------\n"
                        +"总计：7.20(元)\n"
                        +"节省：0.80(元)\n"
                        +"**********************\n";
        assertThat(actualShoppingList,is(expectShoppingList));
    }//一个会员买了多种一个商品（有打折，有不打折）

    @Test
    public void testamemberbuymanykindsmanygoods() throws Exception{
        int m;
        Item cokeCola1 = new Item();

        ArrayList<userData> vip =  new ArrayList<userData>();

        ArrayList<Item> cokeCola = new ArrayList<Item>();
        String fs=new String("C:\\Users\\xyl_c\\Documents\\Tencent Files\\451126338\\FileRecv\\POS-Seed\\1.txt");
        String fl=new String("C:\Users\yQ\Documents\Tencent Files\799782239\FileRecv\FileRecv\POS-Seed\test\列表信息 - 副本 (5)\\list.txt");
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
        String actualShoppingList=pos.getShoppingList(shoppingChart);
        String expectShoppingList=
                "***商店购物清单***\n"
                        +"会员编号：USER 001积分：2\n"
                        +"----------------------\n"
                        +"名称：可口可乐，数量：1瓶，单价：3.00(元)，小计：3.00(元)\n"
                        +"名称：雪碧，数量：3瓶，单价：3.00(元)，小计：6.00(元)\n"
                        +"名称：电池，数量：4个，单价：2.00(元)，小计：4.80(元)\n"
                        +"----------------------\n"
                        +"挥泪赠送商品：\n"
                        +"名称：雪碧数量：1瓶\n"
                        +"----------------------\n"
                        +"总计：13.80(元)\n"
                        +"节省：6.20(元)\n"
                        +"**********************\n";
        assertThat(actualShoppingList,is(expectShoppingList));
    }//一个会员买了多种多个商品（有打折，有买二送一）

    @Test
    public void testapersonbuymanykindsonegoods() throws Exception{
        int m;
        Item cokeCola1 = new Item();

        ArrayList<userData> vip =  new ArrayList<userData>();

        ArrayList<Item> cokeCola = new ArrayList<Item>();
        String fs=new String("C:\\Users\\xyl_c\\Documents\\Tencent Files\\451126338\\FileRecv\\POS-Seed\\1.txt");
        String fl=new String("C:\Users\yQ\Documents\Tencent Files\799782239\FileRecv\FileRecv\POS-Seed\test\列表信息 - 副本 (6)\\list.txt");
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
        String actualShoppingList=pos.getShoppingList(shoppingChart);
        String expectShoppingList=
                "***商店购物清单***\n"
                        +"名称：可口可乐，数量：1瓶，单价：3.00(元)，小计：3.00(元)\n"
                        +"名称：雪碧，数量：1瓶，单价：3.00(元)，小计：3.00(元)\n"
                        +"名称：电池，数量：1个，单价：2.00(元)，小计：1.60(元)\n"
                        +"----------------------\n"
                        +"总计：7.60(元)\n"
                        +"节省：0.40(元)\n"
                        +"**********************\n";
        assertThat(actualShoppingList,is(expectShoppingList));
    }//一个普通人买了多种一个商品（有打折，有不打折）

    @Test
    public void testapersonbuymanykindsmanygoods() throws Exception{
        int m;
        Item cokeCola1 = new Item();

        ArrayList<userData> vip =  new ArrayList<userData>();

        ArrayList<Item> cokeCola = new ArrayList<Item>();
        String fs=new String("C:\\Users\\xyl_c\\Documents\\Tencent Files\\451126338\\FileRecv\\POS-Seed\\1.txt");
        String fl=new String("C:\Users\yQ\Documents\Tencent Files\799782239\FileRecv\FileRecv\POS-Seed\test\列表信息 - 副本 (7)\\list.txt");
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
        String actualShoppingList=pos.getShoppingList(shoppingChart);
        String expectShoppingList=
                "***商店购物清单***\n"
                        +"名称：可口可乐，数量：1瓶，单价：3.00(元)，小计：3.00(元)\n"
                        +"名称：雪碧，数量：3瓶，单价：3.00(元)，小计：6.00(元)\n"
                        +"名称：电池，数量：4个，单价：2.00(元)，小计：6.40(元)\n"
                        +"----------------------\n"
                        +"挥泪赠送商品：\n"
                        +"名称：雪碧数量：1瓶\n"
                        +"----------------------\n"
                        +"总计：15.40(元)\n"
                        +"节省：4.60(元)\n"
                        +"**********************\n";
        assertThat(actualShoppingList,is(expectShoppingList));
    }//（一个普通人买了多种多个商品（有打折，有买二送一）

    @Test
    public void testamemberwhosepointbelowtwoh() throws Exception{
        int m;
        Item cokeCola1 = new Item();

        ArrayList<userData> vip =  new ArrayList<userData>();

        ArrayList<Item> cokeCola = new ArrayList<Item>();
        String fs=new String("C:\\Users\\xyl_c\\Documents\\Tencent Files\\451126338\\FileRecv\\POS-Seed\\1.txt");
        String fl=new String("C:\Users\yQ\Documents\Tencent Files\799782239\FileRecv\FileRecv\POS-Seed\test\列表信息 - 副本 (8)\\list.txt");
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
        String actualShoppingList=pos.getShoppingList(shoppingChart);
        String expectShoppingList=
                "***商店购物清单***\n"
                        +"会员编号：USER 001积分：153\n"
                        +"----------------------\n"
                        +"名称：可口可乐，数量：2瓶，单价：3.00(元)，小计：3.00(元)\n"
                        +"名称：雪碧，数量：4瓶，单价：3.00(元)，小计：9.00(元)\n"
                        +"名称：电池，数量：6个，单价：2.00(元)，小计：7.20(元)\n"
                        +"----------------------\n"
                        +"挥泪赠送商品：\n"
                        +"名称：可口可乐数量：1瓶\n"
                        +"名称：雪碧数量：1瓶\n"
                        +"----------------------\n"
                        +"总计：19.20(元)\n"
                        +"节省：10.80(元)\n"
                        +"**********************\n";
        assertThat(actualShoppingList,is(expectShoppingList));
    }//一个会员积分是150的会员买了19.20元的商品

    @Test
    public void testamemberwhosepointbelowfivehabovetwoh() throws Exception{
        int m;
        Item cokeCola1 = new Item();

        ArrayList<userData> vip =  new ArrayList<userData>();

        ArrayList<Item> cokeCola = new ArrayList<Item>();
        String fs=new String("C:\\Users\\xyl_c\\Documents\\Tencent Files\\451126338\\FileRecv\\POS-Seed\\1.txt");
        String fl=new String("C:\Users\yQ\Documents\Tencent Files\799782239\FileRecv\FileRecv\POS-Seed\test\列表信息 - 副本 (9)\\list.txt");
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
        String actualShoppingList=pos.getShoppingList(shoppingChart);
        String expectShoppingList=
                "***商店购物清单***\n"
                        +"会员编号：USER 001积分：259\n"
                        +"----------------------\n"
                        +"名称：可口可乐，数量：2瓶，单价：3.00(元)，小计：3.00(元)\n"
                        +"名称：雪碧，数量：4瓶，单价：3.00(元)，小计：9.00(元)\n"
                        +"名称：电池，数量：6个，单价：2.00(元)，小计：7.20(元)\n"
                        +"----------------------\n"
                        +"挥泪赠送商品：\n"
                        +"名称：可口可乐数量：1瓶\n"
                        +"名称：雪碧数量：1瓶\n"
                        +"----------------------\n"
                        +"总计：19.20(元)\n"
                        +"节省：10.80(元)\n"
                        +"**********************\n";
        assertThat(actualShoppingList,is(expectShoppingList));
    }//一个会员积分是250的会员买了19.20元的商品

    @Test
    public void testamemberwhosepointabovefiveh() throws Exception{
        int m;
        Item cokeCola1 = new Item();

        ArrayList<userData> vip =  new ArrayList<userData>();

        ArrayList<Item> cokeCola = new ArrayList<Item>();
        String fs=new String("C:\\Users\\xyl_c\\Documents\\Tencent Files\\451126338\\FileRecv\\POS-Seed\\1.txt");
        String fl=new String("C:\Users\yQ\Documents\Tencent Files\799782239\FileRecv\FileRecv\POS-Seed\test\列表信息 - 副本 (10)\\list.txt");
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
        String actualShoppingList=pos.getShoppingList(shoppingChart);
        String expectShoppingList=
                "***商店购物清单***\n"
                        +"会员编号：USER 001积分：535\n"
                        +"----------------------\n"
                        +"名称：可口可乐，数量：2瓶，单价：3.00(元)，小计：3.00(元)\n"
                        +"名称：雪碧，数量：4瓶，单价：3.00(元)，小计：9.00(元)\n"
                        +"名称：电池，数量：6个，单价：2.00(元)，小计：7.20(元)\n"
                        +"----------------------\n"
                        +"挥泪赠送商品：\n"
                        +"名称：可口可乐数量：1瓶\n"
                        +"名称：雪碧数量：1瓶\n"
                        +"----------------------\n"
                        +"总计：19.20(元)\n"
                        +"节省：10.80(元)\n"
                        +"**********************\n";
        assertThat(actualShoppingList,is(expectShoppingList));
    }//一个会员积分是520的会员买了19.20元的商品
}