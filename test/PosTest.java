import domains.Item;
import domains.Pos;
import domains.ShoppingChart;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by Administrator on 2014/12/28.
 */
public class PosTest {
    @Test
    public void testGetCorrectShoppingListForDiscountItem() throws Exception {
        // given
        Item cokeCola = new Item("ITEM000004", "电池", "个", 2.00,0.8);
        ShoppingChart shoppingChart = new ShoppingChart();
        shoppingChart.add(cokeCola);

        // when
        Pos pos = new Pos();
        String actualShoppingList = pos.getShoppingList(shoppingChart);

        // then
        String expectedShoppingList =
                "***商店购物清单***\n"
                        + "名称：电池，数量：1个，单价：2.00(元)，小计：1.60(元)\n"
                        + "----------------------\n"
                        + "总计：1.60(元)\n"
                        + "节省：0.40(元)\n"
                        + "**********************\n";
        assertThat(actualShoppingList, is(expectedShoppingList));
    }
}