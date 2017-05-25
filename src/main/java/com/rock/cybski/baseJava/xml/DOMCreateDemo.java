//package com.rock.cybski.baseJava.xml;
//
//import java.io.File;
//
//import javax.xml.parsers.DocumentBuilder;
//import javax.xml.parsers.DocumentBuilderFactory;
//import javax.xml.parsers.ParserConfigurationException;
//import javax.xml.transform.OutputKeys;
//import javax.xml.transform.Transformer;
//import javax.xml.transform.TransformerException;
//import javax.xml.transform.TransformerFactory;
//import javax.xml.transform.dom.DOMSource;
//import javax.xml.transform.stream.StreamResult;
//
//import org.w3c.dom.Document;
//import org.w3c.dom.Element;
//
//
//public class DOMCreateDemo {
//	public static void main(String[] args) throws ParserConfigurationException, TransformerException {
//		//Step1 create DocumentBuilderFactory
//		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
//		//Step2 create DocumentBuilder
//		DocumentBuilder db = dbf.newDocumentBuilder();
//		//Step3 create new Document
//		Document doc = db.newDocument();
//		//set standalone = yes and hide in xml header
//		doc.setXmlStandalone(true);
//		//Step4 write rootElement
//		Element bookstore = doc.createElement("bookstore");
//		Element book = doc.createElement("book");//Create book and add to bookstore root element
//		book.setAttribute("id", "1");//Create attr for book
//		Element name = doc.createElement("name");//Create child node name for book
//		name.setTextContent("AAAAA");//set text content
//		book.appendChild(name);//Add name to book
//		bookstore.appendChild(book);//Add book to bookstore
//		doc.appendChild(bookstore);//Add bookstore to document
//		
//		//Transformer domTree to xml
//		TransformerFactory tff = TransformerFactory.newInstance();
//		Transformer tf = tff.newTransformer();
//		tf.setOutputProperty(OutputKeys.INDENT, "yes");//break line
//		tf.transform(new DOMSource(doc), new StreamResult(new File("demo/bookDom.xml")));
//		
//	}
//}
