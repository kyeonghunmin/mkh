package step32.sax;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

public class Test03 {
  
  static class BookHandler extends DefaultHandler {
    boolean isCapture;
    
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
      if (localName.equals("title")) {
        System.out.print("제목: ");
        isCapture = true;
      } else if (localName.equals("price")) {
        System.out.print("가격: ");
        isCapture = true;
      }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
      if (localName.equals("title") || localName.equals("price")) {
        System.out.println();
        isCapture = false;
      }
    }
    
    @Override // 태그의 중간 내용을 출력한다.
    public void characters(char[] ch, int start, int length) throws SAXException {
      if (isCapture) {
        System.out.print(new String(ch, start, length));        
      }
    }
    
  }
  

  public static void main(String[] args) throws Exception {

    SAXParserFactory spf = SAXParserFactory.newInstance();
    System.out.println(spf.getClass().getName());
    
    spf.setNamespaceAware(true);
    
    SAXParser saxParser = spf.newSAXParser();
    
    XMLReader xmlReader = saxParser.getXMLReader();
   
    xmlReader.setContentHandler(new BookHandler());
    
    xmlReader.parse(convertToFileURL("./sample.xml"));
    System.out.println("분석 끝");
  }

  private static String convertToFileURL(String filename) throws IOException {
    File f = new File(filename);
    String path = f.getCanonicalPath();
    String fileURL = "file:";
    if (!path.startsWith("/")) {
      fileURL += "/";
    }
    fileURL += path;
    return fileURL;
  }

}
