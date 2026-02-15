package com.utility;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import com.constants.Env;

public class PropertiesUtil {

    private static Map<String, Properties> cache = new HashMap<>();

    private static Properties loadFile(String folder, String fileName) {

        String key = folder + "/" + fileName;

        if (cache.containsKey(key)) {
            return cache.get(key);
        }

        Properties prop = new Properties();

        try (InputStream is = PropertiesUtil.class
                .getClassLoader()
                .getResourceAsStream(folder + "/" + fileName + ".properties")) {

            if (is == null) {
                throw new RuntimeException(
                        "Properties file not found in classpath: "
                                + folder + "/" + fileName + ".properties");
            }

            prop.load(is);
            cache.put(key, prop);

        } catch (IOException e) {
            throw new RuntimeException("Unable to load properties file", e);
        }

        return prop;
    }


    // ---------- Environment Config ----------
    public static String readConfig(Env env, String key) {
        Properties prop = loadFile("config", env.name());
        return prop.getProperty(key);
    }

    // ---------- Locator Files ----------
    public static String readLocator(String pageName, String key) {
        Properties prop = loadFile("locators", pageName);
        return prop.getProperty(key);
    }
}
