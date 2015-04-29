package org.swg.xml;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
/**
 * û��ʹ��Jar��������ʹ����JDK�ķ�ʽ
 * DocumentBuilderFactory-->DocumentBuilder-->Document
 * @author sun
 *
 */
public class XmlDemo {
	public static void main(String[] args) {
		//����һ��������
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		//DocumentBuilder
		try {
			//db
			DocumentBuilder db = dbf.newDocumentBuilder();
			//xml�ļ���������Document
			Document document = db.parse(System.getProperty("user.dir")+"/bin/bookStore.xml");
			//xml�ļ����ж��ٽڵ㣬�Ǹ��ڵ㡣
			NodeList bookList = document.getElementsByTagName("book");
			System.out.println("һ����"+bookList.getLength()+"����");
			//����bookList
			//����һ�������ֻ��һ�����ԵĴ�����
			for(int i = 0;i<bookList.getLength();i++){
				System.out.println("=========��"+(i+1)+"����=========");
				Node book = bookList.item(i);
				NamedNodeMap attrs = book.getAttributes();
				System.out.println("��"+(i+1)+"������"+attrs.getLength()+"������");
				//ÿ��book�м�������
				for(int j = 0;j<attrs.getLength();j++){
					System.out.println(attrs.item(j).getNodeName()+":"+attrs.item(j).getNodeValue());
				}
				//ȷ��ֻ��һ�����ԣ�����ǿתΪElement���͡�
				Element book2 = (Element)bookList.item(i);
				System.out.println("id:"+book2.getAttribute("id"));
				System.out.println("*********�ӽڵ�**********");
				//Dom��ʽ����xml�ļ����ӽڵ����������� 
				NodeList childNodes = book.getChildNodes();
				System.out.println("����"+childNodes.getLength()+"���ӽڵ�");
				for(int k = 0; k<childNodes.getLength();k++){
					//���ֽڵ����ͣ��γ����õ���Node.Element_Node
					//�ڵ�ֵʵ�������ӽڵ���ӽڵ�
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
