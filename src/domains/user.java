package domains;

import com.sun.xml.internal.txw2.output.XmlSerializer;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
import java.util.ArrayList;

/**
 * Created by yQ on 2015/1/6.
 */
public class user {

    private userData out;
    private ArrayList<userData> user = new ArrayList<userData>();
    //user out = new user();
    private ArrayList<userData> vip =  new ArrayList<userData>();


    public void setUser(ArrayList<userData> user) {
        this.user = user;
    }

    public ArrayList<userData> getUser() {
        return user;
    }
    private String path = "C:\\Users\\xyl_c\\Documents\\Tencent Files\\451126338\\FileRecv\\POS-Seed\\VIP.xml";
    //读取积分信息
     public  ArrayList<userData> getVIPdatafromXML() {
        File xmlFile = new File(path);
        int m,temp=-1;
        try {
            DocumentBuilder builder = null;
            DocumentBuilderFactory factory = DocumentBuilderFactory
                    .newInstance();
            builder = factory.newDocumentBuilder();
            Document document = builder.parse(xmlFile);
            Element element = document.getDocumentElement();

            NodeList noticeNodes = element.getElementsByTagName("vip");
            for (int i = 0; i < noticeNodes.getLength(); i++) {
                Element noticeElement = (Element) noticeNodes.item(i);
                userData userInfo = new userData();

                NodeList childNodes = noticeElement.getChildNodes();

                for (int j = 0; j < childNodes.getLength(); j++) {
                    if (childNodes.item(j).getNodeType() == Node.ELEMENT_NODE) {
                        if ("usercode".equals(childNodes.item(j).getNodeName())) {
                            userInfo.setUsercode(childNodes.item(j).getFirstChild()
                                    .getNodeValue());
                        } else if ("integral".equals(childNodes.item(j)
                                .getNodeName())) {
                            userInfo.setIntegrat(Integer.parseInt(childNodes.item(j)
                                    .getFirstChild().getNodeValue()));
                        }
                    }
                }
                vip.add(userInfo);
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
        for(m=0;m<vip.size();m++)
        {
            temp=check(vip.get(m).getUsercode());
            if(temp!=-1) {
                user.get(temp).setIntegrat(vip.get(m).getIntegral());
            }
        }
        return vip;
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
    public void setuser(String fu) throws IOException {
        FileReader fr =new FileReader(fu);
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

    public void adduser(String fl) throws IOException {
        FileReader fr = new FileReader(fl);
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
    public void change(userData changedata){
        int i,temp=-1;

            temp=check(changedata.getUsercode());

            if (temp != -1) {

                user.get(temp).setIntegral2(changedata.getIntegral());

            }

        VIPDataToXML creat=new VIPDataToXML(user);
        creat.DataToXML();
    }

}
