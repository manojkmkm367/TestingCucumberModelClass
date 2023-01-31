package com.runner;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.reports.Reporting;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

/**
 * 
 * @author manoj
 * @Description User can build a Communication between Feature Files and
 *              StepDefinition Files
 * @Date 21-09-2022
 *
 */
@RunWith(Cucumber.class)
@CucumberOptions(tags = "@CancelPage", dryRun = false, glue = "com.stepdefinition", 
features = "src\\test\\resources", monochrome = true, plugin = {
		"pretty", "json:target/output.json" }, stepNotifications = true)

public class TestRunnerClass {

	/**
	 * @Description Its used to generate JVM report from JSON report
	 */
	@AfterClass
	public static void report() {

		Reporting.generatesJvmReport(System.getProperty("user.dir") + "\\target\\output.json");
	}
}
