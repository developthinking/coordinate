package util;

import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

public class PropertiesUtil {
	/**
	 * 指定配置文件信息读取
	 * @return
	 */
    public static Properties getProperties(String fileNameIn) {
    	//默认文件名称
    	String fileName = "property.properties";
    	if (StringUtils.isNotBlank(fileNameIn)) {
    		fileName = fileNameIn;
    	}

        InputStream inputStream = null;

        try {
        	inputStream = ClassLoader.getSystemResourceAsStream(fileName);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Properties properties = new Properties();
        try {
            properties.load(new InputStreamReader(inputStream, "UTF-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return properties;
    }
    /**
     * 配置信息读取
     * @param fileNameIn
     * @return
     */
    public static String getInfoByKey(String fileNameIn, String propertyKey) {
    	//配置信息读取
    	Properties properties=getProperties(fileNameIn);
    	//配置关键字读取
        return properties.getProperty(propertyKey);
    }
}
