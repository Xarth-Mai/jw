package cn.fjzzit.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 简单的配置读取工具类，提供从 classpath 下加载配置文件的能力。
 */
public class ConfigManager {
    private static Properties properties = new Properties();

    static {
        try (InputStream is = ConfigManager.class.getClassLoader().getResourceAsStream("config.properties")) {
            if (is != null) {
                properties.load(is);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private ConfigManager() {
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}
