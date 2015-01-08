package domains;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by yQ on 2015/1/6.
 */
public class user {

    private userData out;
    private ArrayList<userData> user = new ArrayList<userData>();
    //user out = new user();


    public void setUser(ArrayList<userData> user) {
        this.user = user;
    }

    public ArrayList<userData> getUser() {
        return user;
    }

    public int check(String usercode){
        int i,temp=0;
        for(i=0;i<user.size();i++) {
            if(usercode.equals(user.get(i).getUsercode())){
                temp=1;
                break;
            }
        }
        if(temp==1)
        {
            return i;
        }
        else{
            System.out.print("不存在！");
            System.exit(0);
            return -1;
        }
    }

    public userData getOut() {
        return out;
    }
    public void setuser() throws IOException {
        FileReader fr =new FileReader("F:\\POS-Seed(1)\\POS-Seed\\3.txt");
        int ch = 0;
        int temp=0;
        int i=0;
        String tempusercode="";
        String tempname="";
        String tempisvip="";
        boolean isvip;

        while((ch = fr.read())!=-1 ) {

            userData in = new userData();
            if(ch ==39)
            {
                while(true ) {
                    ch=fr.read();
                    if (ch ==39) {
                        // barCode=barcode;



                        break;
                    } else {
                        tempusercode = tempusercode + (char)ch;
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
                                        in.set_name(tempname);
                                        in.setUsercode(tempusercode);

                                        break;
                                    } else {
                                       tempname = tempname + (char)ch;
                                    }
                                }
                            }
                            if(ch==44)
                            {
                                break;
                            }
                            if(ch==10)
                            {
                                break;
                            }
                        }
                    }

                    else if(ch== 105){
                        while(true ) {
                            ch= fr.read();
                            if(ch == 58)
                            {
                                while(true ) {
                                    ch=fr.read();
                                    if (ch == 10||ch==13) {
                                        //discount=Integer.parseInt(_discount);

                                        isvip=Boolean.parseBoolean(tempisvip);
                                        in.set_isvip(isvip);
                                        temp=1;
                                        break;
                                    } else {
                                        tempisvip = tempisvip + (char)ch;
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
                        this.user.add(in);
                        tempusercode="";
                        tempname="";
                        tempisvip="";
                        break;
                    }

                }
            }
        }
    }



    public void adduser() throws IOException {
        FileReader fr = new FileReader("F:\\POS-Seed(1)\\POS-Seed\\2.txt");
        int ch=0;
        int temp=0;
        String tempbarcode="";
        while((ch = fr.read())!=-1 ) {
            if(ch==117){
                while(true) {
                    ch = fr.read();
                    if(ch==58) {
                        while(true) {
                            ch=fr.read();
                            if (ch == 39) {
                                while (true) {
                                    ch = fr.read();
                                    if (ch == 39) {
                                        // barCode=barcode;


                                        temp = check(tempbarcode);
                                        out=user.get(temp);
                                        tempbarcode = "";
                                        temp=1;
                                        break;
                                    } else {
                                        tempbarcode = tempbarcode + (char) ch;
                                    }
                                }
                            }
                            if(ch==44) {
                                temp=1;
                                break;
                            }
                        }

                    }
                    if(temp==1) {

                        break;
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
