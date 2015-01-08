package domains;

import java.io.FileReader;
import java.io.IOException;

/**
 * Created by yQ on 2015/1/3.
 */
public class menu {
    private  String [] barcode =new String[10];
    private String [] _name=new String[10];
    private String [] _unit=new String[10];
    private String [] _price =new String[10];
    private String [] _discount=new String[10];
    private String [] _promotion=new String[10];
    int i=0;
    public  menu() throws IOException {
        FileReader fr = new FileReader("C:\\Users\\xyl_c\\Documents\\Tencent Files\\451126338\\FileRecv\\POS-Seed\\1.txt");
        int ch = 0;
        int temp=0;
        int j;

        for(j=0;j<10;j++)
        {
            barcode[j]="";
            _name[j]="";
            _unit[j]="";
            _price[j]="";
            _discount[j]="";
            _promotion[j]="";
        }

        while((ch = fr.read())!=-1 ){

            if(ch ==39)
            {
                while(true ) {
                    ch=fr.read();
                    if (ch ==39) {
                        // barCode=barcode;

                        break;
                    } else {
                        barcode[i] = barcode[i] + (char)ch;
                    }
                }
            }
            if(ch == 123)
            {
                while(true){
                    ch=fr.read();
                    if(ch==110){
                        while(true ) {
                            ch=fr.read();
                            if (ch==39) {
                                while (true) {
                                    ch=fr.read();
                                    if (ch==39) {
                                        // name = _name;
                                        break;
                                    } else {
                                        _name[i] = _name[i] + (char)ch;
                                    }
                                }
                            }
                            if(ch==10)
                            {
                                break;
                            }
                        }
                    }
                    else if(ch == 117){
                        while(true ) {
                            ch=fr.read();
                            if(ch == 39)
                            {
                                while(true ) {
                                    ch=fr.read();
                                    if (ch == 39) {
                                        // unit=_unit;
                                        break;
                                    } else {
                                        _unit[i] = _unit[i] + (char)ch;
                                    }
                                }
                            }
                            if(ch==10)
                            {
                                break;
                            }
                        }
                    }else if(ch == 112){
                        while(true ) {
                            ch=fr.read();
                            if(ch==114)
                            {
                                ch=fr.read();
                                if(ch==105) {
                                    while (true) {
                                        ch = fr.read();
                                        if (ch == 58) {
                                            while (true) {
                                                ch = fr.read();
                                                if (ch == 10) {
                                                    //price=Integer.parseInt(_price);
                                                    temp = 1;
                                                    break;
                                                } else {
                                                    _price[i] = _price[i] + (char) ch;
                                                }
                                            }
                                        }
                                        if(temp==1)
                                        {
                                            break;
                                        }

                                    }
                                }
                                else if(ch==111)
                                {
                                    while (true) {
                                        ch = fr.read();
                                        if (ch == 58) {
                                            while (true) {
                                                ch = fr.read();
                                                if (ch == 13) {
                                                    //price=Integer.parseInt(_price);
                                                    temp = 1;
                                                    break;
                                                } else {
                                                    _promotion[i] = _promotion[i] + (char) ch;
                                                }
                                            }
                                        }
                                        if(temp==1)
                                        {
                                            break;
                                        }
                                    }
                                }
                            }
                            if(temp==1)
                            {
                                temp=0;
                                break;
                            }
                        }
                    }
                    else if(ch== 100){
                        while(true ) {
                            ch= fr.read();
                            if(ch == 58)
                            {
                                while(true ) {
                                    ch=fr.read();
                                    if (ch == 10) {
                                        //discount=Integer.parseInt(_discount);
                                        temp=1;
                                        break;
                                    } else {
                                        _discount[i] = _discount[i] + (char)ch;
                                    }
                                }
                            }
                            if(temp==1)
                            {
                                temp=0;
                                break;
                            }
                        }
                    }
                    else if(ch== 100){
                        while(true ) {
                            ch= fr.read();
                            if(ch == 58)
                            {
                                while(true ) {
                                    ch=fr.read();
                                    if (ch == 10) {
                                        //discount=Integer.parseInt(_discount);
                                        temp=1;
                                        break;
                                    } else {
                                        _discount[i] = _discount[i] + (char)ch;
                                    }
                                }
                            }
                            if(temp==1)
                            {
                                temp=0;
                                break;
                            }
                        }
                    }
                    else if(ch== 125)
                    {
                        i=i+1;
                        break;
                    }

                }
            }


        }
//        for(j=0;j<i;j++) {
//            System.out.print(barcode[j]);
//            System.out.print("\n");
//            System.out.print(_name[j]);
//            System.out.print("\n");
//            System.out.print(_unit[j]);
//            System.out.print("\n");
//            System.out.print(_price[j]);
//            System.out.print("\n");
//            System.out.print(_discount[j]);
//            System.out.print("\n");
//
//        }

    }
    public int check(String barCode) {
        int j = 0;
        int temp=0;
        for (; j < i; j++) {
            if (barCode.equals(barcode[j])) {
                temp=1;
                break;
            }
        }
        if(temp==1)
        {
            return j;
        }
        else
        {
            System.out.print("不存在！");
            System.exit(0);
            return -1;
        }
    }
    public String getbarcode(int id){
        if(barcode[id]=="")
        {
            System.out.print("不存在！");
            System.exit(0);
        }
        return barcode[id];
    }
    public String getname(int id){
        if(_name[id]=="")
        {
            System.out.print("不存在！");
            System.exit(0);
        }
        return _name[id];
    }
    public String getunit(int id){
        if(_unit[id]=="")
        {
            System.out.print("不存在！");
            System.exit(0);
        }
        return _unit[id];
    }
    public double getprice(int id){
        double price;
        price=Double.valueOf(_price[id]);
        if(price==0)
        {
            System.out.print("不存在！");
            System.exit(0);
        }
        return price;
    }
    public double getdiscount(int id){
        double discount;
        if(_discount[id]=="")
            _discount[id]="1";
        discount=Double.valueOf(_discount[id]);
        return discount;
    }

    public boolean getpromotion(int id) {
        boolean promotion;
        promotion=Boolean.parseBoolean(_promotion[id]);
        return promotion;
    }
}
