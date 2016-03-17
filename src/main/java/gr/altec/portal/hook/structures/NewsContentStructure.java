/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.altec.portal.hook.structures;

import com.liferay.portal.model.Image;
import gr.altec.portal.hook.IContentStructure;
import java.io.StringWriter;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamWriter;

/**
 *
 * @author bats-pc
 */
public class NewsContentStructure implements IContentStructure {

    @Override
    public String generateContentStructure() {
        
        StringWriter stringWriter = new StringWriter();

        XMLOutputFactory xMLOutputFactory = XMLOutputFactory.newInstance();
        XMLStreamWriter xMLStreamWriter;
        
        try {
            xMLStreamWriter = xMLOutputFactory.createXMLStreamWriter(stringWriter);
            //doc start
            xMLStreamWriter.writeStartDocument();
            //start of root element
            xMLStreamWriter.writeStartElement("root");
            
            
            
            //end of root element
            xMLStreamWriter.writeEndElement();
            //end of doc
            xMLStreamWriter.writeEndDocument();
            
        } catch(Exception ex) {
            
        }
        
        
        return null;
    }

    @Override
    public String populateContentStructure() {
        return null;
    }
    
}
