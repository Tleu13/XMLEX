package epamLab21.XML;

import org.xml.sax.SAXException;

import javax.imageio.IIOException;
import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;

/**
 * Created by akmatleu on 28.02.17.
 */
public class ValidatorXSD {


    public static boolean validateXML (String xsdPath, String xmlPath){

        try {
            SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = factory.newSchema(new File(xsdPath));
            Validator validator = schema.newValidator();
            validator.validate(new StreamSource(new File(xmlPath)));
            System.out.println("Valid XML");

        } catch (SAXException | IOException e){

            System.out.println("Not Valid Xml because:"+e.getMessage());
            return false;
        }

        return true;

    }




}
