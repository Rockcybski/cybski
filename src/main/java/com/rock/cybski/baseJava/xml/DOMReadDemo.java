package com.rock.cybski.baseJava.xml;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DOMReadDemo {
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		//Step1 create DocumentBuilderFactory
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		//Step2 create DocumentBuilder
		DocumentBuilder db = dbf.newDocumentBuilder();
		//Step3 get org.w3c.dom.Document by DocumentBuilder.parse(...) xml file
		org.w3c.dom.Document doc = db.parse("demo/book.xml");
		
		//Step4 Analyze xml
		//get nodeList of book
		NodeList bookList = doc.getElementsByTagName("book");
		System.out.println("There're totally "+ bookList.getLength()+" books.");
		//traverse bookList
		for(int i=0;i<bookList.getLength();i++){
			System.out.println("====================Start of No."+(i+1)+"=======================");
			//1. If don't know attr of book node
			//Get book node index by item(i)
			Node book = bookList.item(i);
			//Get all attributes collections of book node
			NamedNodeMap attrs = book.getAttributes();
			System.out.println("Book No."+(i+1)+" has "+ attrs.getLength()+" attributes.");
			//traverse attributes
			for(int j=0;j<attrs.getLength();j++){
				Node attr = attrs.item(j);
				//Get Attr Name
				System.out.print("Attribute Name: "+ attr.getNodeName()+ " | ");
				//Get Attr Value
				System.out.println("Attribute Value: "+ attr.getNodeValue());
			}
			//2. If already book node only has id attr
//			Element book = (Element) bookList.item(i);
//			String attrValue = book.getAttribute("id");
//			System.out.println("Id attribute value: "+attrValue);
			
			//traverse childNodes of book
			NodeList childNodes = book.getChildNodes();
			//blank/breakline will also be trated as childNode (text node)
			System.out.println("No."+(i+1)+" has "+childNodes.getLength()+" childNodes");
			for(int k=0;k<childNodes.getLength();k++){
				//distinguish text node and element node
				if(childNodes.item(k).getNodeType() == Node.ELEMENT_NODE){
					System.out.print("No."+(k+1)+"Node:---");
					String eleNodeName = childNodes.item(k).getNodeName();
//					String eleNodeValue = childNodes.item(k).getNodeValue();  Will be null
//					String eleNodeValue = childNodes.item(k).getFirstChild().getNodeValue();
					String eleNodeValue = childNodes.item(k).getTextContent();
					System.out.println("elementName:"+eleNodeName + " | "+"elementValue:"+eleNodeValue);
				}
			}
			System.out.println("====================End of No."+(i+1)+"=========================");
			System.out.println();
		}
	}
}
