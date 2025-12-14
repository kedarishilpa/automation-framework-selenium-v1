package com.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import com.constants.Env;
import com.google.gson.Gson;
import com.ui.pojo.Config;
import com.ui.pojo.Environment;

public class JSONUtility {

	public static Environment readJson(Env env) {

		Gson gson = new Gson();

		File jsonFile = new File(System.getProperty("user.dir") + "\\config\\config.json");

		System.out.println("Loading config: " + jsonFile.getAbsolutePath() + " exists=" + jsonFile.exists());
		FileReader fileReader = null;
		try {
			fileReader = new FileReader(jsonFile);
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}

		Config config = gson.fromJson(fileReader, Config.class);

		System.out.println(config.getEnvironments().get("QA").getURL());
		Environment environment = config.getEnvironments().get("QA");

		return environment;

	}

}
