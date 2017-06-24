package XMLParse.DOM4J;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Iterator;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

public class Dom4JDemo implements XmlDocument{
	
	public void createDocument(String fileName){
		Document document = DocumentHelper.createDocument();
		Element employees = document.addElement("employees");
		Element employee = employees.addElement("employee");
		Element name = employee.addElement("name");
		name.setText("ddvip");
		Element sex = employee.addElement("sex");
		sex.setText("male");
		Element age = employee.addElement("age");
		age.setText("30");
		try {
			Writer fileWriter = new FileWriter("C:/Users/sliu239/Documents/My Projects/practice/JavaGenericsAndCollection/"+fileName);
			XMLWriter xmlWriter = new XMLWriter(fileWriter);
			xmlWriter.write(document);
			xmlWriter.close();
			System.out.println("the document creation is done");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}
	
	public void parseDocument(String fileName){
		File inputXml = new File("C:/Users/sliu239/Documents/My Projects/practice/JavaGenericsAndCollection/"+fileName);
		SAXReader saxReader = new SAXReader();
		try {
			Document document = saxReader.read(inputXml);
			Element employees = document.getRootElement();
			for(Iterator<Element> i=employees.elementIterator();i.hasNext();){
				Element employee = i.next();
				for(Iterator<Element> j=employee.elementIterator();j.hasNext();){
					Element node = j.next();
					System.out.println(node.getName()+":"+node.getText());
				}
			}
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String args[]){
		Dom4JDemo demo = new Dom4JDemo();
		demo.createDocument("Dom4JDemoXML");
		demo.parseDocument("Dom4JDemoXML");
	}
}
