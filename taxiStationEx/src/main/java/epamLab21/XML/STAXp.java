package epamLab21.XML;

import epamLab21.classes.CarTaxi;
import epamLab21.classes.ComfortTaxi;
import epamLab21.classes.EconomTaxi;
import epamLab21.classes.VipTaxi;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by akmatleu on 28.02.17.
 */
public class STAXp {

    private List<CarTaxi> carTaxiList;
    private CarTaxi carTaxi = null;

    public STAXp(String XMLPath) {
        carTaxiList = new ArrayList<CarTaxi>();
        XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
        try {
            XMLEventReader xmlEventReader = xmlInputFactory.createXMLEventReader(new FileInputStream(XMLPath));

            while(xmlEventReader.hasNext()){
                XMLEvent xmlEvent = xmlEventReader.nextEvent();
                if (xmlEvent.isStartElement()){
                    StartElement startElement = xmlEvent.asStartElement();
                    if (startElement.getName().getLocalPart().equals("CarTaxi")){
                        Attribute typeTaxiAttribute = startElement.getAttributeByName(new QName("typeTaxi"));
                        if (typeTaxiAttribute != null){

                            switch (typeTaxiAttribute.getValue()){
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
                        }
                    }
                    else if (startElement.getName().getLocalPart().equals("model")){
                        xmlEvent = xmlEventReader.nextEvent();
                        carTaxi.setModel(xmlEvent.asCharacters().getData());
                    } else if (startElement.getName().getLocalPart().equals("volumeOfEngine")){
                        xmlEvent = xmlEventReader.nextEvent();
                        carTaxi.setVolumeOfEngine(Double.parseDouble(xmlEvent.asCharacters().getData()));
                    } else if (startElement.getName().getLocalPart().equals("modelYear")){
                        xmlEvent = xmlEventReader.nextEvent();
                        carTaxi.setModelYear(Integer.parseInt(xmlEvent.asCharacters().getData()));
                    } else if (startElement.getName().getLocalPart().equals("licencePlate")){
                        xmlEvent = xmlEventReader.nextEvent();
                        carTaxi.setLicencePlate(Integer.parseInt(xmlEvent.asCharacters().getData()));
                    } else if (startElement.getName().getLocalPart().equals("maxSpeed")){
                        xmlEvent = xmlEventReader.nextEvent();
                        carTaxi.setMaxSpeed(Integer.parseInt(xmlEvent.asCharacters().getData()));
                    } else if (startElement.getName().getLocalPart().equals("price")){
                        xmlEvent = xmlEventReader.nextEvent();
                        carTaxi.setPrice(Integer.parseInt(xmlEvent.asCharacters().getData()));
                    } else if (startElement.getName().getLocalPart().equals("petrolConsumption")){
                        xmlEvent = xmlEventReader.nextEvent();
                        carTaxi.setPetrolConsumption(Integer.parseInt(xmlEvent.asCharacters().getData()));
                    }

                }

                if (xmlEvent.isEndElement()){
                    EndElement endElement = xmlEvent.asEndElement();

                    if (endElement.getName().getLocalPart().equals("CarTaxi")){

                        carTaxiList.add(carTaxi);
                    }
                }
            }
        } catch (FileNotFoundException | XMLStreamException ex) {
            ex.printStackTrace();
        }
    }




    public List<CarTaxi> getCarTaxiList() {
        return carTaxiList;
    }
}
