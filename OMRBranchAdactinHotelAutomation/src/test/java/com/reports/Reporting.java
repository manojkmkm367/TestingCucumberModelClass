package com.reports;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import net.masterthought.cucumber.ReportBuilder;

/**
 * 
 * @author manoj
 * @Description User can generate JVM report
 * @Date 21-09-2022
 *
 */
public class Reporting {

	/**
	 * @Description User to generate JVM report
	 * @param jsonFile
	 */
	public static void generatesJvmReport(String jsonFile) {
		File file = new File(System.getProperty("user.dir") + "\\target");

		net.masterthought.cucumber.Configuration configuration = new net.masterthought.cucumber.Configuration(file,
				"Adactin Hotel");

		configuration.addClassifications("Browesr", "Chrome");
		configuration.addClassifications("Browser version", "105");
		configuration.addClassifications("OS", "WIN10");
		configuration.addClassifications("sprint", "10");

		List<String> jsonfile = new ArrayList<String>();
		jsonfile.add(jsonFile);

		ReportBuilder reportBuilder = new ReportBuilder(jsonfile, configuration);

		reportBuilder.generateReports();

	}

}
