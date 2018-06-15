package com.vitor.projetos;

import com.vitor.projetos.Utils;


public class App 
{
    public static void main( String[] args )
    {
        Egg[][] csv = Utils.convertCsvToArray("/home/marques/Desktop/bandeja.csv");
        //String[][] csv = Utils.convertCsvToArray("/home/marques/Desktop/testeOvos.csv");
    	
        if (Utils.validateArray(csv)) {
			System.out.println("Array com largura e altura iguais");
		} else {
			System.out.println("Array com largura e altura diferentes");
		}
        
        Egg[][] newEggs = Utils.eggsTransfer(csv);
        
        Utils.writeReport(Utils.getReport(), "/home/marques/Desktop/bandeja_report.csv");
        
        String newBandeja = Utils.convertArraytoCsv(newEggs);
        System.out.println(newBandeja);
    }

	
}
