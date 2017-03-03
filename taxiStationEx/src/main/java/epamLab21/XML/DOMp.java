package epamLab21.XML;

import epamLab21.classes.CarTaxi;
import epamLab21.classes.ComfortTaxi;
import epamLab21.classes.EconomTaxi;
import epamLab21.classes.VipTaxi;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.imageio.IIOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by akmatleu on 28.02.17.
 */
public class DOMp {

    private String XMLPath;
    private List<CarTaxi> carTaxiList;
    private CarTaxi carTaxi;

    public DOMp(String XMLPath) {
        this.XMLPath = XMLPath;

        File xmlFile = new File(this.XMLPath);
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder;

        try{

            documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document doc = documentBuilder.parse(xmlFile);
            NodeList nodeList = doc.getElementsByTagName("CarTaxi");
            carTaxiList = new ArrayList<CarTaxi>();
            for (int i = 0 ; i < nodeList.getLength();i++){
                Node node = nodeList.item(i);
                if(node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    switch (element.getAttribute("typeTaxi")) {
                        case "EconomTaxi" :
                            carTaxi = new EconomTaxi();
                            setFieldsCarTaxi(carTaxi,element);
                            break;
                        case "ComfortTaxi" :
                            carTaxi = new ComfortTaxi();
                            setFieldsCarTaxi(carTaxi,element);
                            break;
                        case "VipTaxi":
                            carTaxi = new VipTaxi();
                            setFieldsCarTaxi(carTaxi,element);
                            break;
                    }
                }
            }

        }catch (ParserConfigurationException | SAXException | IOException e1){
                e1.printStackTrace();
        }
    }



    private  void setFieldsCarTaxi(CarTaxi carTaxi, Element element){

        carTaxi.setModel(element.getElementsByTagName("model").item(0).getTextContent());
        carTaxi.setVolumeOfEngine(Double.parseDouble(element.getElementsByTagName("volumeOfEngine").item(0).getTextContent()));
        carTaxi.setModelYear(Integer.parseInt(element.getElementsByTagName("modelYear").item(0).getTextContent()));
        carTaxi.setLicencePlate(Integer.parseInt(element.getElementsByTagName("licencePlate").item(0).getTextContent()));
        carTaxi.setMaxSpeed(Integer.parseInt(element.getElementsByTagName("maxSpeed").item(0).getTextContent()));
        carTaxi.setPrice(Integer.parseInt(element.getElementsByTagName("price").item(0).getTextContent()));
        carTaxi.setPetrolConsumption(Integer.parseInt(element.getElementsByTagName("petrolConsumption").item(0).getTextContent()));

        carTaxiList.add(carTaxi);
    }

    public List<CarTaxi> getCarTaxiList() {
        return carTaxiList;
    }
}
