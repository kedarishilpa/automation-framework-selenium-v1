package com.utility;

import java.io.InputStream;
import java.io.InputStreamReader;

import com.google.gson.Gson;
import com.ui.pojo.Config;
import com.ui.pojo.Environment;

public class JSONUtility {

    private static Config config;

    static {
        try (InputStream is = JSONUtility.class
                .getClassLoader()
                .getResourceAsStream("config/config.json")) {

            config = new Gson().fromJson(
                    new InputStreamReader(is),
                    Config.class);

        } catch (Exception e) {
            throw new RuntimeException("Unable to load config.json", e);
        }
    }

    public static Environment getEnvironment() {

        String env = EnvironmentManager.getEnv();

        if (!config.getEnvironments().containsKey(env)) {
            throw new RuntimeException("Invalid environment: " + env);
        }

        return config.getEnvironments().get(env);
    }
}
