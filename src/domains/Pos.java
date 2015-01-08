package domains;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Administrator on 2014/12/28.
 */
public class Pos {
    public String getShoppingList(ShoppingChart shoppingChart) throws IOException {
        ArrayList<Item> items = shoppingChart.getItems();
        ArrayList<Item> itemss = new ArrayList<Item>();
        userData userinfo=shoppingChart.getUserinfo();
        int i, j;
        int point;
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
                        sign=0;
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
        for (i=0;i<itemss.size();i++)
        {
           if(itemss.get(i).getPromote()==true)
           {
               if (itemss.get(i).getAccount()>=2)
               {
                   itemss.get(i).setAccounting();
                   itemss.get(i).setSubtotal(itemss.get(i).getAccounting());
                   Discountprice=Discountprice+itemss.get(i).getPrice()*1;
               }
               else{
                   if(userinfo.is_isvip()==true)
                   {
                       itemss.get(i).setSubtotal(itemss.get(i).getAccount());
                       Discountprice=Discountprice+itemss.get(i).getSubtotal()*(1-itemss.get(i).getVipdiscount());
                       itemss.get(i).getVipdiscount();
                   }
                   else{
                       itemss.get(i).setSubtotal(itemss.get(i).getAccount());
                   }

               }
           } else {
               if(itemss.get(i).getDiscount()!=1) {
                   if(userinfo.is_isvip()==true)
                   {
                        itemss.get(i).setSubtotal(itemss.get(i).getAccount());
                        Discountprice=Discountprice+itemss.get(i).getSubtotal()*(1-itemss.get(i).getDiscount()*itemss.get(i).getVipdiscount());
                        itemss.get(i).setVipsubtotal();
                   }
                   else
                   {
                       itemss.get(i).setSubtotal(itemss.get(i).getAccount());
                       Discountprice=Discountprice+itemss.get(i).getSubtotal()*(1-itemss.get(i).getDiscount());
                       itemss.get(i).setdiscount();
                   }

               }
               else{
                   if(userinfo.is_isvip()==true)
                   {
                       itemss.get(i).setSubtotal(itemss.get(i).getAccount());
                       Discountprice=Discountprice+itemss.get(i).getSubtotal()*(1-itemss.get(i).getVipdiscount());
                       itemss.get(i).setVipsubtotal();
                   }
                   else
                   {
                       itemss.get(i).setSubtotal(itemss.get(i).getAccount());
                   }


               }
           }
            total=total+itemss.get(i).getSubtotal();
        }
        if(userinfo.is_isvip()) {
            if (userinfo.getIntegral() >= 0 && userinfo.getIntegral() <= 200) {
                point = (int) total / 5;
                userinfo.setIntegrat(point);
            } else if (userinfo.getIntegral() > 200 && userinfo.getIntegral() <= 500) {
                point = 3 * ((int) total / 5);

                userinfo.setIntegrat(point);
            } else if (userinfo.getIntegral() > 500) {
                point = 5 * ((int) total / 5);
                userinfo.setIntegrat(point);
            }
        }


        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("***商店购物清单***\n");
        if(userinfo.is_isvip()==true)
        {
            stringBuilder.append("会员编号：")
                        .append(userinfo.get_name())
                        .append("积分：")
                        .append(userinfo.getIntegral())
                        .append("\n")
                        .append("----------------------")
                        .append("\n");
        }
        for (i = 0; i < itemss.size(); i++) {

            stringBuilder.append("名称：").append(itemss.get(i).getName()).append("，")
                    .append("数量：").append(itemss.get(i).getAccount()).append(itemss.get(i).getUnit()).append("，")
                    .append("单价：").append(String.format("%.2f", itemss.get(i).getPrice())).append("(元)").append("，")
                    .append("小计：").append(String.format("%.2f", itemss.get(i).getSubtotal())).append("(元)").append("\n");



        }

        for (i=0;i<itemss.size();i++)
        {
            if(itemss.get(i).getAccounting()>0)
            {

                stringBuilder.append("----------------------\n")
                        .append("挥泪赠送商品：\n");
                break;
            }

        }

                for(i=0;i<itemss.size();i++)
                {
                    if(itemss.get(i).getAccounting()>0)
                    {
                        stringBuilder.append("名称：")
                                    .append(itemss.get(i).getName())
                                    .append("数量：")
                                    .append("1")
                                    .append(itemss.get(i).getUnit())
                                    .append("\n");
                    }
                }
        stringBuilder.append("----------------------\n");
        stringBuilder.append("总计：").append(String.format("%.2f", total)).append("(元)").append("\n");
                if(Discountprice==0)
                {}
        else {
                    stringBuilder .append("节省：").append(String.format("%.2f", Discountprice)).append("(元)").append("\n");
                }
        stringBuilder .append("**********************\n");

        return stringBuilder
                .toString();
    }
    }




