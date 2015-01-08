import domains.Item;
import domains.Pos;
import domains.ShoppingChart;
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

        ArrayList<Item> cokeCola = new ArrayList<Item>();
        String fs=new String("C:\\Users\\xyl_c\\Documents\\Tencent Files\\451126338\\FileRecv\\POS-Seed(1)\\POS-Seed\\1.txt");
        String fl=new String("C:\\Users\\xyl_c\\Documents\\Tencent Files\\451126338\\FileRecv\\POS-Seed(1)\\POS-Seed\\2.txt");


        cokeCola=cokeCola1.setmenu(fl,fs);

        ShoppingChart shoppingChart = new ShoppingChart();
        for(m=0;m<cokeCola.size();m++) {
            shoppingChart.add(cokeCola.get(m));
        }
        // when
        Pos pos = new Pos();
        String actualShoppingList = pos.getShoppingList(shoppingChart);


        // then
        String expectedShoppingList =
                "***商店购物清单***\n"
                        + "名称：雪碧，数量：4瓶，单价：3.00(元)，小计：9.00(元)\n"
                        + "名称：可口可乐，数量：3瓶，单价：3.00(元)，小计：6.00(元)\n"
                        + "名称：电池，数量：2个，单价：2.00(元)，小计：3.20(元)\n"
                        + "----------------------\n"
                        +"挥泪赠送商品：\n"
                        +"名称：雪碧数量：1瓶\n"
                        +"名称：可口可乐数量：1瓶\n"
                        + "----------------------\n"
                        + "总计：18.20(元)\n"
                        + "节省：6.80(元)\n"
                        + "**********************\n";
        assertThat(actualShoppingList, is(expectedShoppingList));
    }

    @Test
    public void testReadwrongfl() throws  Exception{
        int m;
        Item cokeCola1 = new Item();

        ArrayList<Item> cokeCola = new ArrayList<Item>();
        String fs=new String("C:\\Users\\xyl_c\\Documents\\Tencent Files\\451126338\\FileRecv\\POS-Seed(1)\\POS-Seed\\1.txt");
        String fl=new String("C:\\Users\\xyl_c\\Documents\\Tencent Files\\451126338\\FileRecv\\POS-Seed(1)\\POS-Seed\\3.txt");


        cokeCola=cokeCola1.setmenu(fl,fs);

        ShoppingChart shoppingChart = new ShoppingChart();
        for(m=0;m<cokeCola.size();m++) {
            shoppingChart.add(cokeCola.get(m));
        }
        // when
        Pos pos = new Pos();
        String actualShoppingList = pos.getShoppingList(shoppingChart);


        // then
        //String expectedShoppingList =

        //assertThat(actualShoppingList, is(expectedShoppingList));
        System.out.print("不存在！");
    }

    @Test
    public void  testReadnopromotion() throws  Exception{
        // given
        int m;
        Item cokeCola1 = new Item();

        ArrayList<Item> cokeCola = new ArrayList<Item>();
        String fs=new String("C:\\Users\\xyl_c\\Documents\\Tencent Files\\451126338\\FileRecv\\POS-Seed(1)\\POS-Seed\\fst.txt");
        String fl=new String("C:\\Users\\xyl_c\\Documents\\Tencent Files\\451126338\\FileRecv\\POS-Seed(1)\\POS-Seed\\2.txt");


        cokeCola=cokeCola1.setmenu(fl,fs);

        ShoppingChart shoppingChart = new ShoppingChart();
        for(m=0;m<cokeCola.size();m++) {
            shoppingChart.add(cokeCola.get(m));
        }
        // when
        Pos pos = new Pos();
        String actualShoppingList = pos.getShoppingList(shoppingChart);


        // then
        String expectedShoppingList =
                "***商店购物清单***\n"
                        + "名称：雪碧，数量：4瓶，单价：3.00(元)，小计：12.00(元)\n"
                        + "名称：可口可乐，数量：3瓶，单价：3.00(元)，小计：9.00(元)\n"
                        + "名称：电池，数量：2个，单价：2.00(元)，小计：3.20(元)\n"
                        + "----------------------\n"
                        +"挥泪赠送商品：\n"
                        + "----------------------\n"
                        + "总计：24.20(元)\n"
                        + "节省：0.80(元)\n"
                        + "**********************\n";
        assertThat(actualShoppingList, is(expectedShoppingList));
    }

    @Test
    public void testOneKindOneGoodsWithPromotion()throws Exception{
        int m;
        Item cokeCola1 = new Item();

        ArrayList<Item> cokeCola = new ArrayList<Item>();
        String fs=new String("C:\\Users\\xyl_c\\Documents\\Tencent Files\\451126338\\FileRecv\\POS-Seed(1)\\POS-Seed\\1.txt");
        String fl=new String("C:\\Users\\xyl_c\\Documents\\Tencent Files\\451126338\\FileRecv\\POS-Seed(1)\\POS-Seed\\2.txt");


        cokeCola=cokeCola1.setmenu(fl,fs);

        ShoppingChart shoppingChart = new ShoppingChart();
        for(m=0;m<cokeCola.size();m++) {
            shoppingChart.add(cokeCola.get(m));
        }
        // when
        Pos pos = new Pos();
        String actualShoppingList = pos.getShoppingList(shoppingChart);
        String expectedShoppingList =
                "***商店购物清单***\n"
                        + "名称：雪碧，数量：1瓶，单价：3.00(元)，小计：3.00(元)\n"
                        + "----------------------\n"
                        +"挥泪赠送商品：\n"
                        + "----------------------\n"
                        + "总计：3.00(元)\n"
                        + "节省：0.00(元)\n"
                        + "**********************\n";
        assertThat(actualShoppingList, is(expectedShoppingList));
    }

    @Test
    public void testOneKindManyGoodsWithPromotionNoDiscount()throws Exception{
        int m;
        Item cokeCola1 = new Item();

        ArrayList<Item> cokeCola = new ArrayList<Item>();
        String fs=new String("C:\\Users\\xyl_c\\Documents\\Tencent Files\\451126338\\FileRecv\\POS-Seed(1)\\POS-Seed\\1.txt");
        String fl=new String("C:\\Users\\xyl_c\\Documents\\Tencent Files\\451126338\\FileRecv\\POS-Seed(1)\\POS-Seed\\2.txt");


        cokeCola=cokeCola1.setmenu(fl,fs);

        ShoppingChart shoppingChart = new ShoppingChart();
        for(m=0;m<cokeCola.size();m++) {
            shoppingChart.add(cokeCola.get(m));
        }
        // when
        Pos pos = new Pos();
        String actualShoppingList = pos.getShoppingList(shoppingChart);
        String expectedShoppingList =
                "***商店购物清单***\n"
                        + "名称：雪碧，数量：5瓶，单价：3.00(元)，小计：12.00(元)\n"
                        + "----------------------\n"
                        +"挥泪赠送商品：\n"
                        +"名称：雪碧数量：1瓶\n"
                        + "----------------------\n"
                        + "总计：12.00(元)\n"
                        + "节省：3.00(元)\n"
                        + "**********************\n";
        assertThat(actualShoppingList, is(expectedShoppingList));
    }

    @Test
    public void testOneKindManyGoodsWithPromotionWithDiscount()throws Exception{
        int m;
        Item cokeCola1 = new Item();

        ArrayList<Item> cokeCola = new ArrayList<Item>();
        String fs=new String("C:\\Users\\xyl_c\\Documents\\Tencent Files\\451126338\\FileRecv\\POS-Seed(1)\\POS-Seed\\1.txt");
        String fl=new String("C:\\Users\\xyl_c\\Documents\\Tencent Files\\451126338\\FileRecv\\POS-Seed(1)\\POS-Seed\\2.txt");


        cokeCola=cokeCola1.setmenu(fl,fs);

        ShoppingChart shoppingChart = new ShoppingChart();
        for(m=0;m<cokeCola.size();m++) {
            shoppingChart.add(cokeCola.get(m));
        }
        // when
        Pos pos = new Pos();
        String actualShoppingList = pos.getShoppingList(shoppingChart);
        String expectedShoppingList =
                "***商店购物清单***\n"
                        + "名称：电池，数量：3个，单价：2.00(元)，小计：4.80(元)\n"
                        + "----------------------\n"
                        +"挥泪赠送商品：\n"
                        + "----------------------\n"
                        + "总计：4.80(元)\n"
                        + "节省：1.20(元)\n"
                        + "**********************\n";
        assertThat(actualShoppingList, is(expectedShoppingList));
    }

    @Test
    public void testManyKindsOneGoodsWithPromotion()throws Exception{
        int m;
        Item cokeCola1 = new Item();

        ArrayList<Item> cokeCola = new ArrayList<Item>();
        String fs=new String("C:\\Users\\xyl_c\\Documents\\Tencent Files\\451126338\\FileRecv\\POS-Seed(1)\\POS-Seed\\1.txt");
        String fl=new String("C:\\Users\\xyl_c\\Documents\\Tencent Files\\451126338\\FileRecv\\POS-Seed(1)\\POS-Seed\\2.txt");


        cokeCola=cokeCola1.setmenu(fl,fs);

        ShoppingChart shoppingChart = new ShoppingChart();
        for(m=0;m<cokeCola.size();m++) {
            shoppingChart.add(cokeCola.get(m));
        }
        // when
        Pos pos = new Pos();
        String actualShoppingList = pos.getShoppingList(shoppingChart);
        String expectedShoppingList =
                "***商店购物清单***\n"
                        + "名称：雪碧，数量：1瓶，单价：3.00(元)，小计：3.00(元)\n"
                        +"名称：可口可乐，数量：1瓶，单价：3.00(元)，小计：3.00(元)\n"
                        +"名称：电池，数量：1个，单价：2.00(元)，小计：1.60(元)\n"
                        + "----------------------\n"
                        +"挥泪赠送商品：\n"
                        + "----------------------\n"
                        + "总计：7.60(元)\n"
                        + "节省：0.40(元)\n"
                        + "**********************\n";
        assertThat(actualShoppingList, is(expectedShoppingList));
    }

    @Test
    public void testManyKindsManyGoodsWithPromotionNoDiscount()throws Exception{
        int m;
        Item cokeCola1 = new Item();

        ArrayList<Item> cokeCola = new ArrayList<Item>();
        String fs=new String("C:\\Users\\xyl_c\\Documents\\Tencent Files\\451126338\\FileRecv\\POS-Seed(1)\\POS-Seed\\1.txt");
        String fl=new String("C:\\Users\\xyl_c\\Documents\\Tencent Files\\451126338\\FileRecv\\POS-Seed(1)\\POS-Seed\\2.txt");


        cokeCola=cokeCola1.setmenu(fl,fs);

        ShoppingChart shoppingChart = new ShoppingChart();
        for(m=0;m<cokeCola.size();m++) {
            shoppingChart.add(cokeCola.get(m));
        }
        // when
        Pos pos = new Pos();
        String actualShoppingList = pos.getShoppingList(shoppingChart);
        String expectedShoppingList =
                "***商店购物清单***\n"
                        + "名称：雪碧，数量：4瓶，单价：3.00(元)，小计：9.00(元)\n"
                        +"名称：可口可乐，数量：3瓶，单价：3.00(元)，小计：6.00(元)\n"
                        + "----------------------\n"
                        +"挥泪赠送商品：\n"
                        +"名称：雪碧数量：1瓶\n"
                        +"名称：可口可乐数量：1瓶\n"
                        + "----------------------\n"
                        + "总计：15.00(元)\n"
                        + "节省：6.00(元)\n"
                        + "**********************\n";
        assertThat(actualShoppingList, is(expectedShoppingList));
    }

    @Test
    public void testManyKindsManyGoodsWithPromotionWithDiscount()throws Exception{
        int m;
        Item cokeCola1 = new Item();

        ArrayList<Item> cokeCola = new ArrayList<Item>();
        String fs=new String("C:\\Users\\xyl_c\\Documents\\Tencent Files\\451126338\\FileRecv\\POS-Seed(1)\\POS-Seed\\1.txt");
        String fl=new String("C:\\Users\\xyl_c\\Documents\\Tencent Files\\451126338\\FileRecv\\POS-Seed(1)\\POS-Seed\\2.txt");


        cokeCola=cokeCola1.setmenu(fl,fs);

        ShoppingChart shoppingChart = new ShoppingChart();
        for(m=0;m<cokeCola.size();m++) {
            shoppingChart.add(cokeCola.get(m));
        }
        // when
        Pos pos = new Pos();
        String actualShoppingList = pos.getShoppingList(shoppingChart);
        String expectedShoppingList =
                "***商店购物清单***\n"
                        + "名称：雪碧，数量：4瓶，单价：3.00(元)，小计：9.00(元)\n"
                        +"名称：可口可乐，数量：3瓶，单价：3.00(元)，小计：6.00(元)\n"
                        +"名称：电池，数量：3个，单价：2.00(元)，小计：4.80(元)\n"
                        + "----------------------\n"
                        +"挥泪赠送商品：\n"
                        +"名称：雪碧数量：1瓶\n"
                        +"名称：可口可乐数量：1瓶\n"
                        + "----------------------\n"
                        + "总计：19.80(元)\n"
                        + "节省：7.20(元)\n"
                        + "**********************\n";
        assertThat(actualShoppingList, is(expectedShoppingList));
    }

}