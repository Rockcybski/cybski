package com.rock.cybski.baseJava.xml;

import java.util.Iterator;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class DOM4JReadDemo {
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) throws DocumentException {
		//Analyze book.xml
		//Step1, create SAXReader
		SAXReader reader = new SAXReader();
		//Step2, SAXReader.read() to load xml file to Document
		Document doc = reader.read("demo/book.xml");
		//Step3, get root element by Document.getRootElement()
		Element bookStore = doc.getRootElement();
		//Step4, get Iterator
		Iterator it = bookStore.elementIterator();
		//Step5, get books
		while(it.hasNext()){
			System.out.println("=============Start===============");
			Element book = (Element) it.next();
			//Get attributes of book
			List<Attribute> bookAttrs = book.attributes();
			for (Attribute attr:bookAttrs){
				String attrName = attr.getName();
				String attrValue = attr.getValue();
				System.out.println("AttrName: "+ attrName +" | AttrValue: "+attrValue);
			}
			
			Iterator itt = book.elementIterator();
			while(itt.hasNext()){
				Element bookChild = (Element) itt.next();
				String childName = bookChild.getName();
				String childValue = bookChild.getText();
				System.out.println("childName: "+ childName +" | childValue: "+childValue);
			}
			System.out.println("=============End===============");
		}
	}
}
