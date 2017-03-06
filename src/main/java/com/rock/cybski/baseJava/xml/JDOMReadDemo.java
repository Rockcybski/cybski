package com.rock.cybski.baseJava.xml;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

public class JDOMReadDemo {
	public static void main(String[] args) throws FileNotFoundException,
			JDOMException, IOException {
		// Analyze book.xml by JDOM
		// Preparation
		SAXBuilder saxBuilder = new SAXBuilder();
		// Builder InputStream 
		InputStream in = new FileInputStream("demo/book.xml");
		//Builder InputStreamReader handle the charset of xml file
		InputStreamReader isr = new InputStreamReader(in,"UTF-8");
		//Build Document
		Document doc = saxBuilder.build(isr);
		// Get root element from Document
		Element rootElement = doc.getRootElement();
		// Get all children nodes from root elements
		List<Element> bookList = rootElement.getChildren();
		
		Book newbook = null;
		List<Book> bookObjList = new ArrayList<Book>();

		for (Element book : bookList) {
			newbook = new Book();
			System.out.println("=====Start to analyze No."
					+ (bookList.indexOf(book) + 1) + "book=====");
			// Analyse book attributes
			List<Attribute> attrList = book.getAttributes();
			// Traverse attrList
			for (Attribute attr : attrList) {
				String attrName = attr.getName();
				String attrValue = attr.getValue();
				if(attrName.equals("id")) newbook.setId(attrValue);
				System.out.println("AttrName: "+ attrName +" | AttrValue: "+attrValue);
			}
			//Traverse childNodes
			List<Element> bookChildren = book.getChildren();
			for(Element child:bookChildren){
				String childName = child.getName();
				String childValue = child.getValue();
				if(childName.equals("name")){
					newbook.setName(childValue);
				}else if(childName.equals("author")){
					newbook.setAuthor(childValue);
				}else if(childName.equals("year")){
					newbook.setYear(childValue);
				}else if(childName.equals("price")){
					newbook.setPrice(childValue);
				}else if(childName.equals("language")){
					newbook.setLanguage(childValue);
				}
				System.out.println("childName: "+ childName +" | childValue: "+childValue);
			}
			bookObjList.add(newbook);
			System.out.println("=====End analyzing No."
					+ (bookList.indexOf(book) + 1) + "book=====");
			System.out.println();
		}
		for(Book b:bookObjList){
			System.out.println(b);
		}
	}
}
