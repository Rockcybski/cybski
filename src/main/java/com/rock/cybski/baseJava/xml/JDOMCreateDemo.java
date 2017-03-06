package com.rock.cybski.baseJava.xml;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.jdom2.CDATA;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

public class JDOMCreateDemo {
	/**
	 * Create RSS XML
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public static void createXML() throws FileNotFoundException, IOException{
		//Step1 create rootElement
		Element rss = new Element("rss");
		//set attribute for element
		rss.setAttribute("version", "2.0");
		//Step2 create document
		Document doc = new Document(rss);
		//Step3 create elements
		Element channel = new Element("channel");
		rss.addContent(channel);
		Element title = new Element("title");
		CDATA cdata = new CDATA("<The News>");//handle escape characters
		title.addContent(cdata);
//		title.setText("The News");
		channel.addContent(title);
		//Step4 create XMLOutputer
		XMLOutputter outputer = new XMLOutputter();
		outputer.setFormat(Format.getPrettyFormat());
		//Step5 Use XMLOutputter to transform document to xml file
		File file = new File("demo/rssnewsJDOM.xml");
		if(!file.exists()){
			file.createNewFile();
		}
		outputer.output(doc, new FileOutputStream(file));
	}
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		createXML();
	}
}
