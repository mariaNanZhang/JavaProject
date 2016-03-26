package com.xml.test;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
public class DOMTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder db=dbf.newDocumentBuilder();
			Document d= db.parse("books.xml");		
			NodeList bookList = d.getElementsByTagName("book");
			System.out.println("there are : "+bookList.getLength()+" books");
			for(int i=0; i< bookList.getLength(); i++){
				System.out.println("---------begin to output " + (i+1) + " book----------");
				Node book = bookList.item(i);
				NamedNodeMap attrs = book.getAttributes();
				System.out.println("The "+(i+1) + "  book has "+attrs.getLength()+" attributes");
				for (int j=0; j<attrs.getLength();j++){
					Node attr=attrs.item(j);
					System.out.println("get attribute Node name: "+attr.getNodeName());
					System.out.println("get attribute value: "+attr.getNodeValue());
					
				}
//				Element book = (Element)bookList.item(i);
//				String attrValue=book.getAttribute("id");
//				System.out.println("id atrribute value is : " +attrValue);
				NodeList childNodes=book.getChildNodes();
				System.out.println("Book " +(i+1) + " has " + childNodes.getLength()+"node");
				for(int k=0; k<childNodes.getLength();k++){
					if(childNodes.item(k).getNodeType()==Node.ELEMENT_NODE){
					System.out.println(childNodes.item(k).getNodeName()+":"
							+ childNodes.item(k).getFirstChild().getNodeValue());
//					System.out.println(childNodes.item(k).getNodeName()+":"
//							+ childNodes.item(k).getTextContent());
					}
				}
				System.out.println("---------finish to output " + (i+1) + " book----------");
			}
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	}
	}

}
