package com.ibtech.task2.xmlParse;




import java.io.IOException;
import java.io.PrintWriter;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import com.ibtech.bag.Bag;
import com.ibtech.bag.BagKey;



@WebServlet("/XMLParseTask")
public class XMLParseServer extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public XMLParseServer() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		
		XMLParse xmlParse = new XMLParse();
		try {
			
			Bag bag = xmlParse.XMLParseAndCommandRun(request.getReader().lines().collect(Collectors.joining()));
			PrintWriter writer = response.getWriter();
			
			writer.append("<CreatedCustomer>");
			writer.append("<name>" + bag.getValue(BagKey.CNAME).toString() + "</name>");
			writer.append("<surname>" + bag.getValue(BagKey.CSURNAME).toString() + "</surname>");
			writer.append("</CreatedCustomer>");
			
			System.out.println("CreatedCustomer: "+ bag.getValue(BagKey.CNAME).toString() +" "+ bag.getValue(BagKey.CSURNAME).toString());
			System.out.println("Posted");
		} catch (ParserConfigurationException | SAXException e) {
	
			e.printStackTrace();
		}  catch (Exception e) {
		
			e.printStackTrace();
		}
		
	}

}
