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
    private int account;
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
    public void setSubtotal()
    {
         subtotal =account*price;
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
    public ArrayList<Item> setmenu() throws IOException {
        ArrayList<Item> itemss = new ArrayList<Item>();

        FileReader fr = new FileReader("C:\\Users\\xyl_c\\Documents\\Tencent Files\\451126338\\FileRecv\\POS-Seed\\2.txt");
        int ch=0;
        int temp;
        String tempbarcode="";
        while((ch = fr.read())!=-1 ) {

            if (ch == 39) {
                while (true) {
                    ch = fr.read();
                    if (ch == 39) {
                        // barCode=barcode;
                        menu in = new menu();
                        Item insert = new Item();
                        temp = in.check(tempbarcode);
                        insert.setBarCode(in.getbarcode(temp));
                        insert.setName(in.getname(temp));
                        insert.setUnit(in.getunit(temp));
                        insert.setPrice(in.getprice(temp));
                        insert.setDiscount(in.getdiscount(temp));
                        insert.setPromote(in.getpromotion(temp));
                        itemss.add(insert);
                        tempbarcode="";
                        i=i++;
                        break;
                    } else {
                        tempbarcode = tempbarcode + (char) ch;
                    }
                }
            }
        }
        return itemss;
    }

}
