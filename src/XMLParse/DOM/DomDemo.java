package XMLParse.DOM;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
public class DomDemo implements XmlDocument{

	private Document document;
	//private String fileName;
	public DomDemo(){
		//this.fileName = fileName;
		init();
	}
	private void init(){
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			this.document = builder.newDocument();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}
	
	@Override
	public void createXml(String fileName) {
		Element root = this.document.createElement("employees");
		this.document.appendChild(root);
		Element employee = this.document.createElement("employee");
		Element name = this.document.createElement("name");
		name.appendChild(this.document.createTextNode("Liu Sha"));
		employee.appendChild(name);
		Element sex = this.document.createElement("sex");
		sex.appendChild(this.document.createTextNode("Male"));
		employee.appendChild(sex);
		Element age = this.document.createElement("age");
		age.appendChild(this.document.createTextNode("30"));
		employee.appendChild(age);
		root.appendChild(employee);
		TransformerFactory tFactory = TransformerFactory.newInstance();
		try {
			Transformer transformer = tFactory.newTransformer();
			DOMSource source = new DOMSource(document);
			transformer.setOutputProperty(OutputKeys.ENCODING, "gb2312");
			transformer.setOutputProperty(OutputKeys.INDENT,"yes");
			PrintWriter pw = new PrintWriter(new FileOutputStream("C:/Users/sliu239/Documents/My Projects/practice/JavaGenericsAndCollection/"+fileName));
			StreamResult result = new StreamResult(pw);
			transformer.transform(source, result);
		} catch ( FileNotFoundException | TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Document Creation is done");
	}

	public void parserXml(String fileName) {
		try {
			DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = builderFactory.newDocumentBuilder();
			Document document = db.parse("C:/Users/sliu239/Documents/My Projects/practice/JavaGenericsAndCollection/"+fileName);
			NodeList employees = document.getChildNodes();
			for(int i=0;i<employees.getLength();i++){
				Node employee = employees.item(i);
				NodeList employeeInfo = employee.getChildNodes();
				for(int j=0;j<employeeInfo.getLength();j++){
					Node node = employeeInfo.item(j);
					NodeList employeeMeta = node.getChildNodes();
					for(int k=0;k<employeeMeta.getLength();k++){
						System.out.println(employeeMeta.item(k).getNodeName() +":"+employeeMeta.item(k).getTextContent());
					}
				}
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
	
	public static void main(String args[]){
		DomDemo demo = new DomDemo();
		demo.createXml("DomDemoXML");
		demo.parserXml("DomDemoXML");
	}
	

}
