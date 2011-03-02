/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package A3_LexicalHandler;

import java.io.File;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.text.StyledEditorKit.ForegroundAction;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.ext.LexicalHandler;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;

/**
 *
 * @author Leung
 */
public class MyLexicalHandler extends DefaultHandler implements LexicalHandler {

    private int cntDTD;
    private int cntCDATA;
    private boolean isCDATA = false;
    private StringBuilder strCDATAs = new StringBuilder();
    private int cntEnity;
    private Hashtable<String, Integer> tblEntities = new Hashtable<String, Integer>();
    private int cntComment;
    private StringBuilder strComments = new StringBuilder();


    // <editor-fold defaultstate="collapsed" desc="LexicalHandler Methods">
    public void startDTD(String name, String publicId, String systemId) throws SAXException {
        cntDTD++;
        System.out.println("A DTD found for " + name);
        if (publicId != null) {
            System.out.println("\tPublic ID :" + publicId);
        }
        if (systemId != null) {
            System.out.println("\tSystem ID :" + systemId);
        }
    }

    public void endDTD() throws SAXException {
    }

    public void startEntity(String name) throws SAXException {
        cntEnity++;
        if (tblEntities.containsKey(name)) {
            Integer cnt = tblEntities.get(name);
            tblEntities.put(name, (cnt.intValue() + 1));
        }else{
            tblEntities.put(name, 1);
        }
    }

    public void endEntity(String name) throws SAXException {
    }

    public void startCDATA() throws SAXException {
        cntCDATA++;
        isCDATA = true;
    }

    public void endCDATA() throws SAXException {
    }

    public void comment(char[] ch, int start, int length) throws SAXException {
        cntComment++;
        String comment = new String(ch, start, length);
        strComments.append("\n\t-" + comment);
    }// </editor-fold>

      @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if(isCDATA){
            String strCDATA = new String(ch,start,length);
            strCDATAs.append("\n\t-"+strCDATA.trim());
            isCDATA = false;
        }
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("==============================");
        System.out.println(cntDTD + " DTD found .");
        System.out.print(cntCDATA + " CDATA found .");
        System.out.println(strCDATAs.toString());
        System.out.println(cntEnity + " Entity found .");
        Enumeration<String> entityKeys = tblEntities.keys();
        while (entityKeys.hasMoreElements()) {
            String key = entityKeys.nextElement();
            System.out.println("\t- Entity [" + key + "] occurs "
                    + tblEntities.get(key));
        }
        System.out.print(cntComment + " Comment found .");
        System.out.println(strComments.toString());
    }


    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java A3_LexicalHandler.MyLexicalHandler "
                    + "[XML Document]");
            return;
        }
        try {
            XMLReader xmlReader = XMLReaderFactory.createXMLReader();
            MyLexicalHandler handler = new MyLexicalHandler();
            xmlReader.setProperty("http://xml.org/sax/properties/lexical-handler", handler);
            xmlReader.setContentHandler(handler);
            xmlReader.parse(args[0]);
            
        } catch (IOException ex) {
            Logger.getLogger(MyLexicalHandler.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(MyLexicalHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


}
