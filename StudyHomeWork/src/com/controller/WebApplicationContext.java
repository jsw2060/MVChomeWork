package com.controller;
import java.io.*;
import java.util.*;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
public class WebApplicationContext {
    private Map clsMap=new HashMap();
    public WebApplicationContext(String path)
    {
    	try
        {
        	SAXParserFactory spf=
        			SAXParserFactory.newInstance();
        	// ╫л╠шео 
        	SAXParser sp=spf.newSAXParser();
        	HandlerMapping hm=new HandlerMapping();
        	sp.parse(new File(path), hm);
        	clsMap=hm.clsMap;
        	
        }catch(Exception ex){}
    }
    public Object getBean(String id)
    {
    	return clsMap.get(id);
    }
}