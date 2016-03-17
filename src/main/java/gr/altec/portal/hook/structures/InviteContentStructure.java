/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.altec.portal.hook.structures;

import com.liferay.portal.model.Image;
import gr.altec.portal.hook.IContentStructure;
import java.io.IOException;
import java.io.StringWriter;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

/**
 *
 * @author bats-pc
 */
public class InviteContentStructure implements IContentStructure {

    @Override
    public String populateContentStructure() {
        return null;
    }

    String preInfo = "preInfo block";
    String info = "information";
    String dates = "dates";
    String doc_info = "document info";
    String inst = "instructions";
    String id = "21";
    String image = "/image/journal/article?img_id=107188";

    @Override
    public String generateContentStructure() {

        StringWriter stringWriter = new StringWriter();
        try {

            XMLOutputFactory xMLOutputFactory = XMLOutputFactory.newInstance();
            XMLStreamWriter xMLStreamWriter = xMLOutputFactory.createXMLStreamWriter(stringWriter);

            xMLStreamWriter.writeStartDocument();
            xMLStreamWriter.writeStartElement("root");

            xMLStreamWriter.writeAttribute("available-locales", "en_US");
            xMLStreamWriter.writeAttribute("default-locales", "en_US");

            xMLStreamWriter.writeStartElement("dynamic-element");
            xMLStreamWriter.writeAttribute("name", "invite-image");
            xMLStreamWriter.writeAttribute("type", "document_library");
            xMLStreamWriter.writeAttribute("index-type", "keyword");
            xMLStreamWriter.writeAttribute("index", "0");

            xMLStreamWriter.writeStartElement("dynamic-content");
            xMLStreamWriter.writeAttribute("language-id", "en_US");
            xMLStreamWriter.writeCData("/liferay/documents/20182/0/image1/38d13b5a-a193-4b10-857b-843c21e52717?t=1435460493539");

            //end of image dynamic content
            xMLStreamWriter.writeEndElement();
            //end of image dynamic element
            xMLStreamWriter.writeEndElement();

            xMLStreamWriter.writeStartElement("dynamic-element");
            xMLStreamWriter.writeAttribute("name", "preInfo");
            xMLStreamWriter.writeAttribute("type", "text_area");
            xMLStreamWriter.writeAttribute("index-type", "keyword");
            xMLStreamWriter.writeAttribute("index", "0");

            xMLStreamWriter.writeStartElement("dynamic-content");
            xMLStreamWriter.writeAttribute("language-id", "en_US");
            xMLStreamWriter.writeCData(preInfo);
            //end of dynamic-content
            xMLStreamWriter.writeEndElement();
            //end of dynamic-element
            xMLStreamWriter.writeEndElement();

            xMLStreamWriter.writeStartElement("dynamic-element");
            xMLStreamWriter.writeAttribute("name", "info");
            xMLStreamWriter.writeAttribute("type", "text-area");
            xMLStreamWriter.writeAttribute("index-type", "keyword");
            xMLStreamWriter.writeAttribute("index", "0");

            xMLStreamWriter.writeStartElement("dynamic-content");
            xMLStreamWriter.writeAttribute("language-id", "en_US");
            xMLStreamWriter.writeCData(info);
            //end of dynamic-content
            xMLStreamWriter.writeEndElement();
            //end of dynamic-element
            xMLStreamWriter.writeEndElement();

            xMLStreamWriter.writeStartElement("dynamic-element");
            xMLStreamWriter.writeAttribute("name", "dates");
            xMLStreamWriter.writeAttribute("type", "text-area");
            xMLStreamWriter.writeAttribute("index-type", "keyword");
            xMLStreamWriter.writeAttribute("index", "0");

            xMLStreamWriter.writeStartElement("dynamic-content");
            xMLStreamWriter.writeAttribute("language-id", "en_US");
            xMLStreamWriter.writeCData(dates);
            //end of dynamic-content
            xMLStreamWriter.writeEndElement();
            //end of dynamic-element
            xMLStreamWriter.writeEndElement();

            xMLStreamWriter.writeStartElement("dynamic-element");
            xMLStreamWriter.writeAttribute("name", "doc_info");
            xMLStreamWriter.writeAttribute("type", "text-area");
            xMLStreamWriter.writeAttribute("index-type", "keyword");
            xMLStreamWriter.writeAttribute("index", "0");

            xMLStreamWriter.writeStartElement("dynamic-content");
            xMLStreamWriter.writeAttribute("language-id", "en_US");
            xMLStreamWriter.writeCData(doc_info);
            //end of dynamic-content
            xMLStreamWriter.writeEndElement();
            //end of dynamic-element
            xMLStreamWriter.writeEndElement();

            xMLStreamWriter.writeStartElement("dynamic-element");
            xMLStreamWriter.writeAttribute("name", "inst");
            xMLStreamWriter.writeAttribute("type", "text-area");
            xMLStreamWriter.writeAttribute("index-type", "keyword");
            xMLStreamWriter.writeAttribute("index", "0");

            xMLStreamWriter.writeStartElement("dynamic-content");
            xMLStreamWriter.writeAttribute("language-id", "en_US");
            xMLStreamWriter.writeCData(inst);
            //end of dynamic-content
            xMLStreamWriter.writeEndElement();
            //end of dynamic-element
            xMLStreamWriter.writeEndElement();

            //end of root
            xMLStreamWriter.writeEndElement();

            xMLStreamWriter.writeEndDocument();

            xMLStreamWriter.flush();
            xMLStreamWriter.close();

            String xmlString = stringWriter.getBuffer().toString();

            stringWriter.close();

        } catch (XMLStreamException e) {
        } catch (IOException e) {
        }

        return stringWriter.toString();
    }

}
