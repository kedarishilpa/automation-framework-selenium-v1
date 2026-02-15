package com.utility;

public class EnvironmentManager {

    private static final String ENV =
            System.getProperty("env", "QA");

    public static String getEnv() {
        return ENV;
    }
}
