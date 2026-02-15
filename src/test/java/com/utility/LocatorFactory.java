package com.utility;

import java.util.Properties;

import org.openqa.selenium.By;

public class LocatorFactory {

    public static By getBy(String pageName, String key) {
    	
    	
        String locator = PropertiesUtil.readLocator(pageName, key);

        if (locator == null) {
            throw new RuntimeException("Locator not found: " + pageName + " -> " + key);
        }

        String[] parts = locator.split(":", 2);
        String type = parts[0];
        String value = parts[1];

        switch (type.toLowerCase()) {
            case "id": return By.id(value);
            case "xpath": return By.xpath(value);
            case "css": return By.cssSelector(value);
            case "name": return By.name(value);
            case "classname": return By.className(value);
            default:
                throw new RuntimeException("Invalid locator type: " + type);
        }
    }
}
