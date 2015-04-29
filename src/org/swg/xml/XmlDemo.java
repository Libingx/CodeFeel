package org.swg.xml;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
/**
 * 没有使用Jar包，这是使用了JDK的方式
 * DocumentBuilderFactory-->DocumentBuilder-->Document
 * @author sun
 *
 */
public class XmlDemo {
	public static void main(String[] args) {
		//这是一个抽象类
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		//DocumentBuilder
		try {
			//db
			DocumentBuilder db = dbf.newDocumentBuilder();
			//xml文件被解析成Document
			Document document = db.parse(System.getProperty("user.dir")+"/bin/bookStore.xml");
			//xml文件中有多少节点，非根节点。
			NodeList bookList = document.getElementsByTagName("book");
			System.out.println("一共有"+bookList.getLength()+"本书");
			//遍历bookList
			//还有一个，如果只有一个属性的处理方法
			for(int i = 0;i<bookList.getLength();i++){
				System.out.println("=========第"+(i+1)+"本书=========");
				Node book = bookList.item(i);
				NamedNodeMap attrs = book.getAttributes();
				System.out.println("第"+(i+1)+"本书有"+attrs.getLength()+"个属性");
				//每个book有几个属性
				for(int j = 0;j<attrs.getLength();j++){
					System.out.println(attrs.item(j).getNodeName()+":"+attrs.item(j).getNodeValue());
				}
				//确定只有一个属性，可以强转为Element类型。
				Element book2 = (Element)bookList.item(i);
				System.out.println("id:"+book2.getAttribute("id"));
				System.out.println("*********子节点**********");
				//Dom方式解析xml文件，子节点类型有三种 
				NodeList childNodes = book.getChildNodes();
				System.out.println("共有"+childNodes.getLength()+"个子节点");
				for(int k = 0; k<childNodes.getLength();k++){
					//三种节点类型，课程上用的是Node.Element_Node
					//节点值实质上是子节点的子节点
					if(childNodes.item(k).getNodeType()==Document.ELEMENT_NODE){
						System.out.print(childNodes.item(k).getNodeName()+":");
						System.out.println(childNodes.item(k).getFirstChild().getNodeValue());
					}
				}
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
