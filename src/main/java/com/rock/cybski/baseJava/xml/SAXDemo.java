package com.rock.cybski.baseJava.xml;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.sax.SAXTransformerFactory;
import javax.xml.transform.sax.TransformerHandler;
import javax.xml.transform.stream.StreamResult;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.AttributesImpl;
import org.xml.sax.helpers.DefaultHandler;

public class SAXDemo {
	public static ArrayList<Book> parserXML() throws SAXException, IOException, ParserConfigurationException {
		// Step1 get instance of SAXParserFactory
		SAXParserFactory factory = SAXParserFactory.newInstance();
		// Step2 get SAXParser instance by factory
		SAXParser saxParser = factory.newSAXParser();
		// Step3 parse xml file, need DefaultHandler
		SAXParserHander dh = new SAXParserHander();
		saxParser.parse("demo/book.xml", dh);
		return dh.getBookList();
	}
	
	public static void createXML() throws SAXException, IOException, ParserConfigurationException, TransformerConfigurationException{
		ArrayList<Book> bookList = parserXML();
		//Create xml
		//Step1, create SAXTransformerFactory
		SAXTransformerFactory tff = (SAXTransformerFactory) SAXTransformerFactory.newInstance();
		//Step2, create TransformerHandler
		TransformerHandler handler = tff.newTransformerHandler();
		//Step3, create Transformer
		Transformer tf = handler.getTransformer();
		//Step4, set xml by Transformer
		tf.setOutputProperty(OutputKeys.ENCODING, "UTF-8"); //set encoding
		tf.setOutputProperty(OutputKeys.INDENT, "yes");	//set breakline
		//Step5, create Result
		File file = new File("demo/bookSax.xml");
		if(!file.exists()){
			file.createNewFile();
		}
		Result result = new StreamResult(new FileOutputStream(file));
		//Step6, connect result and handler
		handler.setResult(result);
		//Step7, use handler to write xml
		//Open document
		handler.startDocument();
			//<bookstore>
			AttributesImpl attr = new AttributesImpl();
			handler.startElement("", "", "bookstore", attr);
			for(Book book:bookList){
				//<book>
				attr.clear();
				attr.addAttribute("", "", "id", "", book.getId());
				handler.startElement("", "", "book", attr);
					//<name>XXXX</name>
					if(book.getName()!=null && !book.getName().trim().equals("")){
						attr.clear();
						handler.startElement("", "", "name", attr);
						handler.characters(book.getName().toCharArray(), 0, book.getName().length());
						handler.endElement("", "", "name");
					}
					//<year>XXXX</year>
					if(book.getYear()!=null && !book.getYear().trim().equals("")){
						attr.clear();
						handler.startElement("", "", "year", attr);
						handler.characters(book.getYear().toCharArray(), 0, book.getYear().length());
						handler.endElement("", "", "year");
					}
					//<author>XXXX</author>
					if(book.getAuthor()!=null && !book.getAuthor().trim().equals("")){
						attr.clear();
						handler.startElement("", "", "author", attr);
						handler.characters(book.getAuthor().toCharArray(), 0, book.getAuthor().length());
						handler.endElement("", "", "author");
					}
					//<price>XXXX</price>
					if(book.getPrice()!=null && !book.getPrice().trim().equals("")){
						attr.clear();
						handler.startElement("", "", "price", attr);
						handler.characters(book.getPrice().toCharArray(), 0, book.getPrice().length());
						handler.endElement("", "", "price");
					}
					//<language>XXXX</language>
					if(book.getLanguage()!=null && !book.getLanguage().trim().equals("")){
						attr.clear();
						handler.startElement("", "", "language", attr);
						handler.characters(book.getLanguage().toCharArray(), 0, book.getLanguage().length());
						handler.endElement("", "", "language");
					}
				handler.endElement("", "", "book");
				}
			//</bookstore>
			handler.endElement("", "", "bookstore");
		//Close document
		handler.endDocument();
	}

	public static void main(String[] args) throws ParserConfigurationException,
			SAXException, IOException, TransformerConfigurationException {
//		ArrayList<Book> bookList = parserXML();
//		for (Book book : bookList) {
//			System.out.println(book.getId() + "," + book.getName() + ","
//					+ book.getAuthor() + "," + book.getYear() + ","
//					+ book.getPrice() + "," + book.getLanguage());
//		}
		createXML();
	}
}

class SAXParserHander extends DefaultHandler {
	private int bookIndex = 0;
	private String value = null;// save text value of child node
	private Book newBook = null;
	private ArrayList<Book> bookList = new ArrayList<Book>();

	/**
	 * traverse xml start tag
	 */
	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		super.startElement(uri, localName, qName, attributes);
		// Analyze attribute of book start element
		if (qName.equals("book")) {
			bookIndex++;
			// Create new book to store data
			newBook = new Book();
			System.out.println("==================Start Book" + bookIndex
					+ "===================");
			// 1. If already know the attribute of book
			// String value = attributes.getValue("id");
			// System.out.println(value);
			// 2. If don't know the attribute of book
			int num = attributes.getLength(); // the number of attributes
			for (int i = 0; i < num; i++) {
				System.out.println(attributes.getQName(i)/* Name */+ " | "
						+ attributes.getValue(i)/* Value */);
				if (attributes.getQName(i).equals("id")) {
					newBook.setId(attributes.getValue(i));
				}
			}
		} else if (!(qName.equals("book") && qName.equals("bookstore"))) {
			System.out.print(qName + ": ");
		}
	}

	/**
	 * traverse xml end tag
	 */
	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		super.endElement(uri, localName, qName);
		// Analyze attribute of book end element
		if (qName.equals("book")) {
			System.out.println("===================End Book" + bookIndex
					+ "===================");
			System.out.println();
			bookList.add(newBook);
		} else if (qName.equals("name")) {
			newBook.setName(value);
		} else if (qName.equals("author")) {
			newBook.setAuthor(value);
		} else if (qName.equals("year")) {
			newBook.setYear(value);
		} else if (qName.equals("price")) {
			newBook.setPrice(value);
		} else if (qName.equals("language")) {
			newBook.setLanguage(value);
		}

	}

	/**
	 * 
	 */
	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		super.characters(ch, start, length);
		value = new String(ch, start, length);
		if (!(value.trim().isEmpty() || value.trim().equals(null)))
			System.out.println(value);
	}

	/**
	 * Mark the start of analyze
	 */
	@Override
	public void startDocument() throws SAXException {
		super.startDocument();
		System.out.println("SAX Analyze Start...");
	}

	/**
	 * Mark the end of analyze
	 */
	@Override
	public void endDocument() throws SAXException {
		super.endDocument();
		System.out.println("SAX Analyze End...");
	}

	public ArrayList<Book> getBookList() {
		return bookList;
	}
}