package domains;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * Created by yQ on 2014/12/2.
 */
public class VIPDataToXML {

    private ArrayList<userData> user = new ArrayList<userData>();

    public  VIPDataToXML(ArrayList<userData> user) {
        this.user = user;
    }

    public void DataToXML() {
        Document document;
        String path = "C:\\Users\\xyl_c\\Documents\\Tencent Files\\451126338\\FileRecv\\POS-Seed\\VIP.xml";
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory
                    .newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            document = builder.newDocument();
            Element root = document.createElement("vips");
            document.appendChild(root);

            for (int i=0;i<user.size();i++) {
                Element s1 = document.createElement("vip");

                Element name = document.createElement("usercode");
                name.appendChild(document.createTextNode(user.get(i).getUsercode()));
                s1.appendChild(name);

                Element num = document.createElement("integral");
                num.appendChild(document.createTextNode(String.valueOf(user.get(i).getIntegral())));
                s1.appendChild(num);
                root.appendChild(s1);
            }


            TransformerFactory tf = TransformerFactory.newInstance();
            try {
                Transformer transf = tf.newTransformer();
                DOMSource source = new DOMSource(document);
                //设置编码
                transf.setOutputProperty(OutputKeys.ENCODING, "GB2312");
                //设置输出
                transf.setOutputProperty(OutputKeys.INDENT, "yes");
                PrintWriter pw = new PrintWriter(new FileOutputStream(path));
                StreamResult result = new StreamResult(pw);
                transf.transform(source, result);
            } catch (Exception e2) {
                // TODO: handle exception
            }
           // System.out.println("创建xml成功");
        } catch (ParserConfigurationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
