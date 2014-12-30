package domains;

import java.util.ArrayList;

/**
 * Created by Administrator on 2014/12/28.
 */
public class Pos {
    public String getShoppingList(ShoppingChart shoppingChart) {
        ArrayList<Item> items = shoppingChart.getItems();
        ArrayList<Item> itemss = new ArrayList<Item>();
        int i, j;
        double total = 0;

        double Discountprice=0;
        int sign=0;
        Item item;
        String str1 = new String();
        String str2 = new String();
        itemss.add(items.get(0));
        str1 = items.get(0).getName();
        ArrayList<String> str = new ArrayList<String>();
        str.add(str1);
        for (i = 1; i < items.size(); i++) {

            str2 = items.get(i).getName();
            if (str1.equals(str2) == true) {

            } else {
                for (j = 0; j< str.size(); j++) {
                    if (str2.equals(str.get(j))==true) {
                        sign++;
                    } else {

                    }
                }
                if(sign==0)
                {
                    str.add(str2);
                    itemss.add(items.get(i));
                }

            }
        }
        for (i = 0; i < items.size(); i++) {
            item = items.get(i);
            for (j = 0; j< itemss.size(); j++) {
                if (item.getName().equals(itemss.get(j).getName()) == true) {
                    itemss.get(j).count();
                } else {

                }
            }
        }

        for (i = 0; i < itemss.size(); i++) {
            itemss.get(i).setSubtotal();

            Discountprice=Discountprice+itemss.get(i).getSubtotal()*(1-itemss.get(i).getDiscount());
            itemss.get(i).setdiscount();
            total = total + itemss.get(i).getSubtotal();

        }


        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("***商店购物清单***\n");
        for (i = 0; i < itemss.size(); i++) {

            stringBuilder.append("名称：").append(itemss.get(i).getName()).append("，")
                    .append("数量：").append(itemss.get(i).getAccount()).append(itemss.get(i).getUnit()).append("，")
                    .append("单价：").append(String.format("%.2f", itemss.get(i).getPrice())).append("(元)").append("，")
                    .append("小计：").append(String.format("%.2f", itemss.get(i).getSubtotal())).append("(元)").append("\n");

        }


        stringBuilder.append("----------------------\n")
                .append("总计：").append(String.format("%.2f", total)).append("(元)").append("\n")
                .append("节省：").append(String.format("%.2f", Discountprice)).append("(元)").append("\n")
                .append("**********************\n");
        return stringBuilder
                .toString();
    }
    }




