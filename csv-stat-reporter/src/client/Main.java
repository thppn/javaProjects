package client;

import java.util.ArrayList;
import java.util.Scanner;

import datamodel.IResult;
import datamodel.MeasurementRecord;
import mainengine.IMainEngine;
import mainengine.MainEngineFactory;

public class Main {
	
	private static Scanner input;
	private static IMainEngine mainengine;
	private static IResult data;
	private static ArrayList<MeasurementRecord> inputData;

	public static void init() {
		System.out.println("Welcome to this project!\n");
		MainEngineFactory factory = new MainEngineFactory();
		mainengine = factory.createMainEngine("MainEngine");
	}

	public static void main(String[] args) {
		
		init();
		
		input = new Scanner(System.in);
		while(true) {
			System.out.println("\nMenu:\n1. Load data from file.\n2. Aggregate data loaded.\n3. Export results to file.\n4. Exit\n(1-4): ");
			switch(input.nextInt()) {
			case 1:
				loadData();
				continue;
			case 2:
				aggregateData();
				continue;
			case 3:
				exportData();
				continue;
			case 4:
				System.out.println("See you soon! Bye!");
				return;
			default:
				System.out.println("No such option. Try again");
			}
		}
	}
	public static void exportData() {
		if(mainengine.reportResultInFile(data, getReportType(), getFileName()) == 0) {
			System.out.println("Data succesfully exported!");
		}
		else {
			System.out.println("Oops! Something went wrong. Please try again");
		}
	}
	private static String getReportType() {
		input.nextLine();
		System.out.println("Please provide the report type to export(html|md|txt): ");
		return input.nextLine();
	}
	public static void aggregateData() {
		data = mainengine.aggregateByTimeUnit(inputData, getAggregatorType(), getAggFunction(), getDescription());
		if(data == null) {
			System.out.println("Oops! Something went wrong. Please try again");
		}
		else{
			System.out.println("Aggregation Succesfull!");
		}
	}
	private static String getAggFunction() {
		input.nextLine();
		System.out.println("Please provide aggregation function(avg|sum):\t");
		return input.nextLine();
	}
	private static String getAggregatorType() {
		input.hasNextLine();
		while(true) {
			System.out.println("Please provide aggregator type:\n1. Season\n2. Periodofday\n3. Dayofweek\n4. Month\n(1-4):\t");
			switch(input.nextInt()) {
			case 1:
				return "season";
			case 2:
				return "periodofday";
			case 3:
				return "dayofweek";
			case 4:
				return "month";
		}
		System.out.println("Oops! Something went wrong. Please try again");
		}
	}
	private static String getDescription() {
		input.nextLine();
		System.out.println("Please provide the description for the analysis(\\n for newLine):\t");
		return input.nextLine();
	}
	public static void loadData() {
		
		inputData = new ArrayList<MeasurementRecord>();
		mainengine.loadData(getFileName(), getDelimeter(), getHasHeaderLine(), getNumFields(), inputData);	
		if(inputData == null) {
			System.out.println("Oops! Something went wrong. Please try again");
		}
		else {
			System.out.println("Data succesfully loaded!");
		}
	}

	private static String getFileName() {
		input.nextLine();
		System.out.print("Please provide path to file:\t");
		return input.nextLine();
	}
	private static String getDelimeter() {
		input.nextLine();
		System.out.print("Please provide delimeter:\t");
		return input.nextLine();
	}
	private static int getNumFields() {
		input.nextLine();
		System.out.print("Number of fields:\t");
		return input.nextInt();
	}
	private static boolean getHasHeaderLine() {
		input.nextLine();
		System.out.print("Headerline exists (true|false)?:\t");
		return input.nextBoolean();
	}
}
