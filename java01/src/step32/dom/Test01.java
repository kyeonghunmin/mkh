package step32.dom;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;

public class Test01 {

  public static void main(String[] args) throws Exception {
    // 1) DocumentBuilder 공장을 준비한다.
    DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
    System.out.println(dbf.getClass().getName());
    
    // 2) 공장으로부터 DocumentBuilder 객체를 생성한다.
    //    XML 문서를 분석하여 태그 별로 tree 구조를 만든다.
    DocumentBuilder db = dbf.newDocumentBuilder();
    
    // 3) XML 파일을 분석하여, DOM 객체 Tree를 만든다.
    //    (./sample.xml을 읽어서 DOM 객체를 만든다.)
    Document doc = db.parse(new File("./sample.xml"));
    
    // 4) DOM 트리에서 원하는 태그를 꺼낸다.
    //    book이라는 태그를 찾는다.
    NodeList bookList = doc.getElementsByTagName("book"); 
    
    for (int i = 0; i < bookList.getLength(); i++) {
      printBookInfo((Element)bookList.item(i));
    }
  }

  private static void printBookInfo(Element element) {
    Element title = (Element)element.getElementsByTagName("title").item(0);
    Element price = (Element)element.getElementsByTagName("price").item(0);
    
    System.out.println("-----------------------------------");
    if (title != null) {
      Text titleText = (Text)title.getFirstChild();
      System.out.printf("제목: %s\n", titleText.getWholeText());
    }
    
    if (price != null) {
      Text priceText = (Text)price.getFirstChild();
      System.out.printf("가격: %s\n", priceText.getWholeText());      
    }    
  }

}

// Node 인터페이스
// => Element, Comment, Text 등..
