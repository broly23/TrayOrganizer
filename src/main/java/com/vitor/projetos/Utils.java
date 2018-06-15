package com.vitor.projetos;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class Utils {

	private static String report = "";

	public static Egg[][] convertCsvToArray(String dirCSV) {

		String csvString = null;

		try {
			csvString = FileUtils.readFileToString(new File(dirCSV));
		} catch (IOException e) {
			e.printStackTrace();
		}

		String[] csvLines = csvString.split("\n");
		int lines = csvLines.length;
		int rows = csvLines[0].split(",").length;

		Egg[][] eggs = new Egg[lines][rows];

		for (int el = 0; el < lines; el++) {
			String[] line = csvLines[el].split(",");
			for (int er = 0; er < rows; er++) {
				boolean whole = !(line[er].toUpperCase().equals("C"));
				eggs[el][er] = new Egg(whole);
			}
		}

		return eggs;

	}

	public static boolean validateArray(Egg[][] array) {
		return array.length == array[0].length;
	}

	public static Egg[][] eggsTransfer(Egg[][] eggs) {
		report = "";
		int lines = eggs.length;
		int rows = eggs[0].length;
		Egg[][] newEggs = new Egg[lines][rows];
		for (int cl = 0; cl < lines; cl++) {
			report = report + "Na linha " + (cl + 1) + " ovos inteiros nas posições:";
			for (int cr = 0; cr < rows; cr++) {
				if (eggs[cl][cr].getWhole()) {
					newEggs[cl][cr] = eggs[cl][cr];
					report = report + " " + (cr + 1) + ",";
				}
			}
			report = report.substring(0, report.length() - 1);
			report = report + "\n";
		}
		eggs = null;
		return newEggs;
	}

	public static void writeReport(String report, String dirCSV) {
		try {
			FileUtils.writeStringToFile(new File(dirCSV), report);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static String getReport() {
		return report;
	}

	public static String convertArraytoCsv(Egg[][] newEggs) {
		
		String arrayToString = "";

		for (int cl = 0; cl < newEggs.length; cl++) {
			for (int cr = 0; cr < newEggs[0].length; cr++) {
				if (newEggs[cl][cr] == null)
					arrayToString = arrayToString + "null,";
				else 
					arrayToString = arrayToString + "O,";
			}
			arrayToString = arrayToString.substring(0,arrayToString.length() -1);
			arrayToString = arrayToString + "/n";
		}
		return arrayToString;

	}

}
