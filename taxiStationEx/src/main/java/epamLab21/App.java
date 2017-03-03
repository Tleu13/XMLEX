package epamLab21;

import epamLab21.XML.DOMp;
import epamLab21.XML.SAXp;
import epamLab21.XML.STAXp;
import epamLab21.XML.ValidatorXSD;
import epamLab21.classes.CarTaxi;
import epamLab21.classes.CarTaxiList;
import epamLab21.services.TaxiStation;

import java.util.List;

/**
 * Hello JavaLab21!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        final String XMLPATH = "src/main/resources/TaxiStation.xml";
        final String XSDPATH = "src/main/resources/Station.xsd";

        ValidatorXSD.validateXML(XSDPATH,XMLPATH);

        DOMp domP = new DOMp(XMLPATH);
        SAXp saxP = new SAXp(XMLPATH);
        STAXp staxP = new STAXp(XMLPATH);

        List<CarTaxi> domList = domP.getCarTaxiList();
        List<CarTaxi> saxList = saxP.getCarTaxiList();
        List<CarTaxi> staxList = staxP.getCarTaxiList();

        CarTaxiList domCarList = new CarTaxiList();
        CarTaxiList saxCarList = new CarTaxiList();
        CarTaxiList staxCarList = new CarTaxiList();

        domCarList.addList(domList);
        saxCarList.addList(saxList);
        staxCarList.addList(staxList);

        System.out.println(domCarList.equals(saxCarList));
        System.out.println(saxCarList.equals(staxCarList));
        System.out.println(staxCarList.equals(domCarList));


    }

}
