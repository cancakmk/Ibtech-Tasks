package com.ibtech.task2.xmlParse;

import java.io.File;
import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;

import com.ibtech.bag.Bag;
import com.ibtech.bag.BagKey;
import com.ibtech.command.CommandExecuter;
import com.ibtech.model.Customer;

public class XMLParse {

	public  Bag XMLParseFileAndCommandRun(String xmlFileName) throws Exception {

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse(new File(xmlFileName+".xml"));
		
		
		System.out.println("XML Parsing Started");

		String commandName = document.getDocumentElement().getElementsByTagName("commandName").item(0).getTextContent();
		String customerName = document.getDocumentElement().getElementsByTagName("customerName").item(0)
				.getTextContent();
		String customerSurname = document.getDocumentElement().getElementsByTagName("customerSurname").item(0).getTextContent();

		Customer customer = new Customer(customerName, customerSurname);
		System.out.println("-----> " + commandName);
		System.out.println("-----> " + customer.getName());
		System.out.println("-----> " + customer.getSurname());
		
		Bag bag = new Bag();
		bag.put(BagKey.CNAME, customer.getName());
		bag.put(BagKey.CSURNAME, customer.getSurname());
		CommandExecuter asd = new CommandExecuter();
		Bag resultBag = asd.executer(commandName, bag);
		
		return resultBag;	
	}
	
	public Bag XMLParseAndCommandRun(String body) throws Exception {

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse(new InputSource(new StringReader(body)));
		document.getDocumentElement().normalize();

		String commandName = document.getDocumentElement().getElementsByTagName("commandName").item(0).getTextContent();
		String customerName = document.getDocumentElement().getElementsByTagName("customerName").item(0)
				.getTextContent();
		String customerSurname = document.getDocumentElement().getElementsByTagName("customerSurname").item(0)
				.getTextContent();

		Customer customer = new Customer(customerName, customerSurname);
		System.out.println("-----> " + commandName);
		System.out.println("-----> " + customer.getName());
		System.out.println("-----> " + customer.getSurname());
		
		Bag bag = new Bag();
		bag.put(BagKey.CNAME, customer.getName());
		bag.put(BagKey.CSURNAME, customer.getSurname());
		CommandExecuter asd = new CommandExecuter();
		Bag resultBag =asd.executer(commandName, bag);
		
		return resultBag;	
	}

}
