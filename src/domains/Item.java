package domains;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;


/**
 * Created by Administrator on 2014/12/28.
 */
public class Item {
    int i=0;
    private String barCode="";
    private String name;
    private String unit;
    private double price;
    private double discount;
    private double vipdiscount;
    private int account;
    private int accounting;
    private double subtotal;
    private boolean promote;


//    public Item(String barCode, String name, String unit, double price,double discount) {
//
//        this.barCode = barCode;
//
//        this.name = name;
//        this.unit= unit;
//        this.price = price;
//        this.discount=discount;
//    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public void setPromote(boolean promote) {
        this.promote = promote;
    }

    public void setVipdiscount(double vipdiscount)
    {
        this.vipdiscount=vipdiscount;
    }
    public double getVipdiscount()
    {
        return  vipdiscount;
    }


    public void setAccounting()
    {
        accounting=account-1;
    }
    public boolean getPromote()
    {
        return  promote;
    }
    public int getAccounting()
    {
        return accounting;
    }
    public String getName() {
        return name;
    }

    public String getUnit() {
        return unit;
    }

    public double getPrice() {
        return price;
    }
    public double getDiscount(){
        return discount;
    }
    public void count() {
        account= account+1;

    }
    public void setSubtotal(int account)
    {
         subtotal =account*price;
    }

    public void setVipsubtotal()
    {
        subtotal=account*price*discount*vipdiscount;
    }

    public int getAccount()
    {
        return account;
    }
    public double getSubtotal()
    {
        return subtotal;
    }
    public void setdiscount()
    {
        subtotal=account*price*discount;
    }
    public ArrayList<Item> setmenu(String fl,String fs) throws IOException {
        ArrayList<Item> itemss = new ArrayList<Item>();
        user use=new user();
        FileReader fr = new FileReader(fl);

        int ch=0;
        int temp=0;
        String tempbarcode="";

        while((ch = fr.read())!=-1 ) {
            if(ch==105){
                while(true) {
                    ch = fr.read();
                    if(ch==91) {
                        while(true) {
                            ch=fr.read();
                            if (ch == 39) {
                                while (true) {
                                    ch = fr.read();
                                    if (ch == 39) {
                                        // barCode=barcode;
                                        menu in = new menu(fs);
                                        Item insert = new Item();
                                        temp = in.check(tempbarcode);
                                        insert.setBarCode(in.getbarcode(temp));
                                        insert.setName(in.getname(temp));
                                        insert.setUnit(in.getunit(temp));
                                        insert.setPrice(in.getprice(temp));
                                        insert.setDiscount(in.getdiscount(temp));
                                        insert.setPromote(in.getpromotion(temp));
                                        insert.setVipdiscount(in.getvipdiscount(temp));


                                        itemss.add(insert);
                                        tempbarcode = "";
                                        i = i++;
                                        break;
                                    } else {
                                        tempbarcode = tempbarcode + (char) ch;
                                    }
                                }
                            }if(ch==93) {
                                temp=1;
                                break;
                            }
                        }

                    }if(temp==1)
                    {
                        break;
                    }


                }
            }
            if(temp==1)
            {
                break;
            }
        }
        return itemss;
    }

}
