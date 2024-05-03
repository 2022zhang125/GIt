package com.hbsfdxlxy.xml.test;

import org.dom4j.*;
import org.dom4j.io.SAXModifier;
import org.dom4j.io.SAXReader;
import org.junit.Test;
import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.List;

public class ParseXmlByDom4JTest {
    @Test
    public void testParseMyBatisConfigXmlTest02(){
        // 获取配置文件的default,transactionManager的type,以及数据源类型,property的所有key = value
        SAXReader reader = new SAXReader();
        Document document = null;
        try {
            // 第一步：创建SAMReader对象
            document = reader.read(ClassLoader.getSystemClassLoader().getResourceAsStream("mybatis-config.xml"));
            // 第二步：获取default值
            // 获取根节点
            Element rootElement = document.getRootElement();
            String xpath = "/"+rootElement.getName()+"/environments";
            // 通过xpath去定位到节点(获取environments节点)
            Element environments = (Element) document.selectSingleNode(xpath);
            // 获取default值
            System.out.println("default值为：" + environments.attributeValue("default"));

            // 第二步：获取transactionManager的Type值
            String xpath2 = "/configuration/environments/environment[@id='"+environments.attributeValue("default")+"']";
            Element environment = (Element) document.selectSingleNode(xpath2);
            // 使用element()函数，取出字节点
            System.out.println("事务管理器为："+environment.element("transactionManager").attributeValue("type"));

            // 第三步：获取数据源类型
            System.out.println("数据源类型为：" + environment.element("dataSource").attributeValue("type"));

            // 第四步：获取property的key=value对
            List<Element> dataSourceList = environment.element("dataSource").elements();
            dataSourceList.forEach(property ->{
                // 取出name
                String name = property.attributeValue("name");
                String value = property.attributeValue("value");
                System.out.println(name + " = " + value);
            });
        } catch (DocumentException e) {
            throw new RuntimeException(e);
        }
    }
    @Test
    public void testParseMyBatisConfigXml() throws Exception {
        // 获取default对应的url
        // 创建SAXRReader对象
        SAXReader reader = new SAXReader();
        Document document = reader.read(ClassLoader.getSystemClassLoader().getResourceAsStream("mybatis-config.xml"));
        String xpath = "/configuration/environments";
        Element environments = (Element) document.selectSingleNode(xpath);

        // 获取default值
        Attribute aDefault = environments.attribute("default");

        // 获取environment属性
        String xpath2 = xpath+"/environment[@id='"+aDefault+"']";
        Element environment = (Element) document.selectSingleNode(xpath2);

        // 获取该节点下的transactionManager节点
        Element transactionManager = environment.element("transactionManager");

         List<Node> environmentList = document.selectNodes(xpath2);
         // 获取该属性下的id值
        environmentList.forEach(environment -> {
            // 获取对应environment下的id值
            Element e = (Element) environment;
            Attribute id = e.attribute("id");
            // 当我们的id等于我们的默认值时，就进行查询url操作
            if(aDefault.getValue().equals(id.getValue())){
                List<Node> properties = e.selectNodes("dataSource/property");
                properties.forEach(property->{
                    Element es = (Element) property;
                    Attribute name = es.attribute("name");
                    if("url".equals(name.getValue())){
                        Attribute value = es.attribute("value");
                        System.out.println(value.getValue());
                    }
                });
            }
        });
    }
}
