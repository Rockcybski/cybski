package com.rock.cybski.baseJava.xml;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

public class DOM4JCreateXMLDemo {
	
	/**
	 * Create RSS XML
	 * @throws IOException 
	 */
	public static void createXML() throws IOException{
		//Step1, create document, presents the whole xml document
		Document document = DocumentHelper.createDocument();
		//Step2, create rootElement
		Element rss = document.addElement("rss");
		//Step3, add attribute 'version' to rss
		rss.addAttribute("version", "2.0");
		//Step4, generate childNode and content
		Element channel = rss.addElement("channel");
		Element title = channel.addElement("title");
		title.setText("<![The News]>");
		
		//Step5, Set the format of xml
		OutputFormat format = OutputFormat.createPrettyPrint();
//		format.setEncoding("GBK");
		//Step6, generate xml file
		File file = new File("demo/rssnewsDOM4J.xml");
		//Create XMLWriter
		XMLWriter writer = new XMLWriter(new FileOutputStream(file), format);
		writer.setEscapeText(false); //Set if escape characters, default true
		writer.write(document);
		writer.close();
		
	}
	
	public static void main(String[] args) throws IOException {
		createXML();
	}
}
