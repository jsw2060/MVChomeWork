package com.controller;

public class ViewResolver {
     private String prefix="view/";
     private String suffix=".jsp";
     public String jspFind(String jspName)
     {
    	 return prefix+jspName+suffix;
     }
}
