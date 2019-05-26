package com.example.demo.service;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;

public class Factory {
    private static Logger logger = LoggerFactory.getLogger(Factory.class);
    private static Factory factory = null;
    private static HashMap<String, String> msgMap = new HashMap<>();

    static {
        getMsgFactory();
    }

    private Factory() {
    }

    private static Factory getMsgFactory() {
        if (null == factory) {
            factory = new Factory();
            factory.loadXML();
        }
        return factory;
    }

    private void loadXML() {
        logger.info("===开始loadXML");
        InputStream inputStream = this.getClass().getResourceAsStream("/msg.xml");
        SAXReader reader = new SAXReader();
        try {
            Document doc = reader.read(inputStream);
            Element root = doc.getRootElement();
            Element element;
            for (Iterator<?> iter = root.elementIterator("msg"); iter.hasNext(); ) {
                element = (Element) iter.next();
                msgMap.put(element.elementText("transCode"), element.elementText("class"));
            }
            inputStream.close();
        } catch (DocumentException | IOException e) {
            e.printStackTrace();
        }
    }

    public static IBaseMsg getInstance(String transCode) {
        if (!StringUtils.hasText(transCode)) {
            logger.warn("交易码transCode不能为空");
            return null;
        }
        getMsgFactory();
        IBaseMsg iBaseMsg = null;
        String className = msgMap.get(transCode);
        if (!StringUtils.hasText(className)) {
            logger.warn("消息处理类不能为空");
            return null;
        }
        try {
            iBaseMsg = (IBaseMsg) Class.forName(className.trim()).newInstance();
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return iBaseMsg;
    }
}
