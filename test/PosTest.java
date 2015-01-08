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
    public void testGetCorrectShoppingList() throws Exception {
        // given
        int m;
        Item cokeCola1 = new Item();
        ArrayList<Item> cokeCola = new ArrayList<Item>();
        cokeCola=cokeCola1.setmenu();

        ShoppingChart shoppingChart = new ShoppingChart();
        for(m=0;m<cokeCola.size();m++) {
            shoppingChart.add(cokeCola.get(m));
        }
        Pos pos = new Pos();
        String actualShoppingList = pos.getShoppingList(shoppingChart);

        // then
        String expectedShoppingList =
                "***商店购物清单***\n"
                        + "名称：雪碧，数量：4瓶，单价：3.00(元)，小计：12.00(元)\n"
                        + "名称：可口可乐，数量：2瓶，单价：3.00(元)，小计：6.00(元)\n"
                        + "名称：电池，数量：2个，单价：2.00(元)，小计：3.20(元)\n"
                        + "----------------------\n"
                        + "总计：21.20(元)\n"
                        + "节省：0.80(元)\n"
                        + "**********************\n";
        assertThat(actualShoppingList, is(expectedShoppingList));
    }

    @Test
    public void testTheGoodsDoNotExist() throws Exception{;
        Item cokeCola1 = new Item();
        ArrayList<Item> cokeCola = new ArrayList<Item>();
        cokeCola=cokeCola1.setmenu();
        System.out.println("不存在！");
    }

    @Test
    public void testCannotFindTheFile() throws Exception{
        int m;
        Item cokeCola1 = new Item();
        ArrayList<Item> cokeCola = new ArrayList<Item>();
        cokeCola=cokeCola1.setmenu();
        System.out.println("不存在！");
    }//需修改！！！

    @Test
    public void testOneKindOneGoodsShoppingList() throws  Exception{
        int m;
        Item cokeCola1 = new Item();
        ArrayList<Item> cokeCola = new ArrayList<Item>();
        cokeCola=cokeCola1.setmenu();

        ShoppingChart shoppingChart = new ShoppingChart();
        for(m=0;m<cokeCola.size();m++) {
            shoppingChart.add(cokeCola.get(m));
        }
        Pos pos = new Pos();
        String actualShoppingList = pos.getShoppingList(shoppingChart);
        String expectedShoppingList =
                "***商店购物清单***\n"
                        + "名称：雪碧，数量：1瓶，单价：3.00(元)，小计：3.00(元)\n"
                        + "----------------------\n"
                        + "总计：3.00(元)\n"
                        + "节省：0.00(元)\n"
                        + "**********************\n";
        assertThat(actualShoppingList, is(expectedShoppingList));
    }

    @Test
    public  void testOneKindManyGoodsShoppingList() throws Exception{
        int m;
        Item cokeCola1 = new Item();
        ArrayList<Item> cokeCola = new ArrayList<Item>();
        cokeCola=cokeCola1.setmenu();

        ShoppingChart shoppingChart = new ShoppingChart();
        for(m=0;m<cokeCola.size();m++) {
            shoppingChart.add(cokeCola.get(m));
        }
        Pos pos = new Pos();
        String actualShoppingList = pos.getShoppingList(shoppingChart);
        String expectedShoppingList =
                "***商店购物清单***\n"
                        + "名称：雪碧，数量：3瓶，单价：3.00(元)，小计：9.00(元)\n"
                        + "----------------------\n"
                        + "总计：9.00(元)\n"
                        + "节省：0.00(元)\n"
                        + "**********************\n";
        assertThat(actualShoppingList, is(expectedShoppingList));
    }

    @Test
    public void testManyKindsOneGoodsShoppingList() throws Exception{
        int m;
        Item cokeCola1 = new Item();
        ArrayList<Item> cokeCola = new ArrayList<Item>();
        cokeCola=cokeCola1.setmenu();

        ShoppingChart shoppingChart = new ShoppingChart();
        for(m=0;m<cokeCola.size();m++) {
            shoppingChart.add(cokeCola.get(m));
        }
        Pos pos = new Pos();
        String actualShoppingList = pos.getShoppingList(shoppingChart);
        String expectedShoppingList =
                "***商店购物清单***\n"
                        + "名称：雪碧，数量：1瓶，单价：3.00(元)，小计：3.00(元)\n"
                        + "名称：可口可乐，数量：1瓶，单价：3.00(元)，小计：3.00(元)\n"
                        + "名称：电池，数量：1个，单价：2.00(元)，小计：1.60(元)\n"
                        + "----------------------\n"
                        + "总计：7.60(元)\n"
                        + "节省：0.40(元)\n"
                        + "**********************\n";
        assertThat(actualShoppingList, is(expectedShoppingList));
    }

    @Test
    public void testManyKindsManyGoodsShoppingList() throws Exception{
        int m;
        Item cokeCola1 = new Item();
        ArrayList<Item> cokeCola = new ArrayList<Item>();
        cokeCola=cokeCola1.setmenu();

        ShoppingChart shoppingChart = new ShoppingChart();
        for(m=0;m<cokeCola.size();m++) {
            shoppingChart.add(cokeCola.get(m));
        }
        Pos pos = new Pos();
        String actualShoppingList = pos.getShoppingList(shoppingChart);
        String expectedShoppingList =
                "***商店购物清单***\n"
                        + "名称：雪碧，数量：4瓶，单价：3.00(元)，小计：12.00(元)\n"
                        + "名称：可口可乐，数量：3瓶，单价：3.00(元)，小计：9.00(元)\n"
                        + "名称：电池，数量：3个，单价：2.00(元)，小计：4.80(元)\n"
                        + "----------------------\n"
                        + "总计：25.80(元)\n"
                        + "节省：1.20(元)\n"
                        + "**********************\n";
        assertThat(actualShoppingList, is(expectedShoppingList));
    }

   /* @Test
    public void testGetEmptyShoppingList()throws Exception{
       int m;
        Item cokeCola1 = new Item();
        ArrayList<Item> cokeCola = new ArrayList<Item>();
        cokeCola=cokeCola1.setmenu();

        ShoppingChart shoppingChart = new ShoppingChart();
        for(m=0;m<cokeCola.size();m++) {
            shoppingChart.add(cokeCola.get(m));
        }
        Pos pos = new Pos();
        String actualShoppingList = pos.getShoppingList(shoppingChart);
        String expectedShoppingList =
                "***商店购物清单***\n"
                        + "----------------------\n"
                        + "总计：0.00(元)\n"
                        + "节省：0.00(元)\n"
                        + "**********************\n";
        assertThat(actualShoppingList, is(expectedShoppingList));
    }*/
}