package org.wenb.ems.test;
    import java.io.File;  
	import java.io.FileWriter;  
	import java.util.Iterator;  
	import java.util.List;  
	import org.dom4j.Attribute;  
	import org.dom4j.Document;  
	import org.dom4j.DocumentHelper;  
	import org.dom4j.Element;  
	import org.dom4j.io.OutputFormat;  
	import org.dom4j.io.SAXReader;  
	import org.dom4j.io.XMLWriter;  
	import org.junit.Test;  
	public class Dom4jDeom {  
	   @Test  
	    public void test1() throws Exception {  
	        SAXReader reader = new SAXReader(); //创建阅读器  
	        Document document = reader.read(new File("src\\code.xml"));//加载XML文档  
	        Element root = document.getRootElement(); //获取根元素  
	        display(root);  
	    }  
	        private void display(Element root) {  
	        // TODO Auto-generated method stub  
	        displayAttr(root); //获取属性  
	        for (Iterator<Element> i = root.elementIterator(); i.hasNext();) {  
	            Element ele = i.next();  
	            if (ele.isTextOnly()) {  
	                displayAttr(ele);  
	                System.out.println(ele.getText());  
	            } else {  
	                display(ele); //递归调用  
	            }  
	        }  
	    }  
	    @SuppressWarnings("unchecked")  
	    private void displayAttr(Element root) {  
	        // TODO Auto-generated method stub  
	        for (Iterator<Attribute> j = root.attributeIterator(); j.hasNext();) {  
	            Attribute attr = j.next();  
	            System.out.println(attr.getName()+ " " + attr.getValue() + " " + attr.getNodeType() + " " + attr.getNodeTypeName());  
	        }  
	    }  
	}  
