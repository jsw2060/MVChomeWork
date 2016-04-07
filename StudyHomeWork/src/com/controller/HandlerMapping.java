package com.controller;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

// sax (Simple API for XML) : r(read) 읽기전용
/*
 *		<?xml version="1.0"?> startDocument()
 * 		<beans>
 * 		startElement()
 * 			<bean>aaa</bean>
 * 			startElement() characters endElemnt()
 * 			<bean>bbb</bean>
 * 			startElement() characters endElemnt()
 * 		</beans>
 * 		endElement()
 * 								endDocument()
 * 
 * 		<bean id="list" class="MemberListModel"/>
 */
import java.util.*;
public class HandlerMapping extends DefaultHandler{
	Map clsMap = new HashMap();
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		try {
			if(qName.equals("bean")) {
				String id = attributes.getValue("id");
				String cls = attributes.getValue("class");
				System.out.println(id + "-" + cls);
				Class clsName = Class.forName(cls);
				Object obj = clsName.newInstance();
				clsMap.put(id, obj);
			}
		} catch (Exception ex) {}
	}

}
