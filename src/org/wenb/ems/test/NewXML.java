package org.wenb.ems.test;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
public class NewXML {
 /**
  * 
  * 用DOM4J创建一个XML文件
  * @param args
  */
 
 public boolean newXMl(String fileName){
  
  boolean returnValue=false;
  
  //定义一个XML文档
  
  Document docement=DocumentHelper.createDocument();
  
  //设置XML文档的元素
  Element rootElement=docement.addElement("DOM4J创建XML文档");
  
  rootElement.addComment("镜花水月2007-4-24晚上创建");
  
  Element nameElement=rootElement.addElement("镜花水月");
  
  nameElement.addAttribute("名字","不告诉你");
  
  Element schoolElement=nameElement.addElement("学校");
  
  schoolElement.setText("西安翻译学院");
  
  Element cityElement=rootElement.addElement("城市");
  
  cityElement.setText("上海");
  
  Element homeElement=cityElement.addElement("住址");
  
  homeElement.setText("徐家汇");
  
  //创建XML文档 
  try {
   
            /** 格式化输出,类型IE浏览一样 */
   
   OutputFormat format = OutputFormat.createPrettyPrint();
   
   /** 指定XML编码 */
   
   format.setEncoding("GBK");
   
   XMLWriter writer=new XMLWriter(new FileWriter(new File(fileName)),format); 
            
          writer.write(docement);
          
   writer.close();
   
   return returnValue=true;   
   
   
  } catch (IOException e) {
   
   e.printStackTrace();
  }
  
  
  
  return returnValue;
  
 }
 
 /**
  * 
  * 用DOM4J修改一个XML文件
  * @param args
  * 
  */
 
 public boolean update(String fileName,String newFileName){
  
  boolean returnValaue=false;
  
  
  
  SAXReader reader=new SAXReader();
  
  try {
   Document docement=reader.read(new File(fileName));
   
   List list=null;
   
   list=docement.selectNodes("/DOM4J创建XML文档/镜花水月/@名字");
   
   Iterator it=list.iterator();
   
   while(it.hasNext()){
    Attribute attribute=(Attribute) it.next();
    if(attribute.getValue().equals("不告诉你")){
     attribute.setValue("还是不告诉你");
    }
   }
   
   //将就该写入新的文件 
   
   try {
    //转码
    OutputFormat format=OutputFormat.createPrettyPrint();
    
    format.setEncoding("GBK");
    
    XMLWriter writer=new XMLWriter(new FileWriter(new File(newFileName)),format);
    
    writer.write(docement);
    
    writer.close();
    
    return returnValaue=true;
    
   } catch (IOException e) {
    
    e.printStackTrace();
   }
   
   
  } catch (DocumentException e) {
   
   e.printStackTrace();
  }
  
  return returnValaue;
 }
 public static void main(String[] args) {
  
  NewXML newXml=new NewXML();
  
  String name="newXML.xml";
  
  String newName="UpdateXML.xml";
  
  if(!newXml.newXMl(name)){
   System.out.println("创建出现错误！");
   return ;
  }else{
   System.out.println("创建XML成功！");
  }
  
  if(!newXml.update(name,newName)){
   System.out.println("修改出现错误！");
   return;
  }else{
   System.out.println("修改XML成功");
  }
  
 }
}

