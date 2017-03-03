package epamLab21.XML;

import epamLab21.classes.CarTaxi;
import epamLab21.classes.ComfortTaxi;
import epamLab21.classes.EconomTaxi;
import epamLab21.classes.VipTaxi;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by akmatleu on 28.02.17.
 */
public class SAXp extends DefaultHandler {

    private List<CarTaxi> carTaxiList = null;
    private CarTaxi carTaxi;

    private boolean isSetModel = false;
    private boolean isSetEngineVolume = false;
    private boolean isSetModelYear = false;
    private boolean isSetLicencePlate = false;
    private boolean isSetMaxSpeed = false;
    private boolean isSetPrice = false;
    private boolean isSetPetrolConsumption = false;


    public SAXp(String XMLPath) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = saxParserFactory.newSAXParser();
            saxParser.parse(new File(XMLPath),this);
            carTaxiList = this.getCarTaxiList();

        }catch (SAXException | ParserConfigurationException | IOException e){
            e.printStackTrace();
        }
    }


    public List<CarTaxi> getCarTaxiList() {
        return carTaxiList;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        super.startElement(uri, localName, qName, attributes);

        if (qName.equals("CarTaxi")){
            switch (attributes.getValue("typeTaxi")){
                case "EconomTaxi" :
                    carTaxi = new EconomTaxi();
                    break;
                case "ComfortTaxi" :
                    carTaxi = new ComfortTaxi();
                    break;
                case "VipTaxi" :
                    carTaxi = new VipTaxi();
                    break;
            }
            if (carTaxiList == null){
            carTaxiList = new ArrayList<CarTaxi>();
            }
        } else if (qName.equals("model")){
            isSetModel = true;
        } else if (qName.equals("volumeOfEngine")){
            isSetEngineVolume = true;
        } else if (qName.equals("modelYear")){
            isSetModelYear = true;
        }else  if (qName.equals("licencePlate")){
            isSetLicencePlate = true;
        }else if (qName.equals("maxSpeed")){
            isSetMaxSpeed = true;
        }else if (qName.equals("price")){
            isSetPrice = true;
        }else if (qName.equals("petrolConsumption")){
            isSetPetrolConsumption = true;
        }
    }


    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        super.endElement(uri, localName, qName);

        if (qName.equals("CarTaxi")){
            carTaxiList.add(carTaxi);
        }
    }


    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        super.characters(ch, start, length);

        if(isSetModel){
            carTaxi.setModel(new String(ch,start,length));
            isSetModel = false;
        }else if (isSetEngineVolume){
            carTaxi.setVolumeOfEngine(Double.parseDouble(new String(ch,start,length)));
            isSetEngineVolume = false;
        }else if(isSetModelYear){
            carTaxi.setModelYear(Integer.parseInt(new String(ch,start,length)));
            isSetModelYear = false;
        }else if(isSetLicencePlate){
            carTaxi.setLicencePlate(Integer.parseInt(new String(ch,start,length)));
            isSetLicencePlate = false;
        }else if (isSetMaxSpeed){
            carTaxi.setMaxSpeed(Integer.parseInt(new String(ch,start, length)));
            isSetMaxSpeed = false;
        }else if (isSetPrice){
            carTaxi.setPrice(Integer.parseInt(new String(ch,start,length)));
            isSetPrice = false;
        }else if (isSetPetrolConsumption){
            carTaxi.setPetrolConsumption(Integer.parseInt(new String(ch,start,length)));
            isSetPetrolConsumption = false;
        }
    }


}
