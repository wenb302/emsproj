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
  * ��DOM4J����һ��XML�ļ�
  * @param args
  */
 
 public boolean newXMl(String fileName){
  
  boolean returnValue=false;
  
  //����һ��XML�ĵ�
  
  Document docement=DocumentHelper.createDocument();
  
  //����XML�ĵ���Ԫ��
  Element rootElement=docement.addElement("DOM4J����XML�ĵ�");
  
  rootElement.addComment("����ˮ��2007-4-24���ϴ���");
  
  Element nameElement=rootElement.addElement("����ˮ��");
  
  nameElement.addAttribute("����","��������");
  
  Element schoolElement=nameElement.addElement("ѧУ");
  
  schoolElement.setText("��������ѧԺ");
  
  Element cityElement=rootElement.addElement("����");
  
  cityElement.setText("�Ϻ�");
  
  Element homeElement=cityElement.addElement("סַ");
  
  homeElement.setText("��һ�");
  
  //����XML�ĵ� 
  try {
   
            /** ��ʽ�����,����IE���һ�� */
   
   OutputFormat format = OutputFormat.createPrettyPrint();
   
   /** ָ��XML���� */
   
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
  * ��DOM4J�޸�һ��XML�ļ�
  * @param args
  * 
  */
 
 public boolean update(String fileName,String newFileName){
  
  boolean returnValaue=false;
  
  
  
  SAXReader reader=new SAXReader();
  
  try {
   Document docement=reader.read(new File(fileName));
   
   List list=null;
   
   list=docement.selectNodes("/DOM4J����XML�ĵ�/����ˮ��/@����");
   
   Iterator it=list.iterator();
   
   while(it.hasNext()){
    Attribute attribute=(Attribute) it.next();
    if(attribute.getValue().equals("��������")){
     attribute.setValue("���ǲ�������");
    }
   }
   
   //���͸�д���µ��ļ� 
   
   try {
    //ת��
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
   System.out.println("�������ִ���");
   return ;
  }else{
   System.out.println("����XML�ɹ���");
  }
  
  if(!newXml.update(name,newName)){
   System.out.println("�޸ĳ��ִ���");
   return;
  }else{
   System.out.println("�޸�XML�ɹ�");
  }
  
 }
}

