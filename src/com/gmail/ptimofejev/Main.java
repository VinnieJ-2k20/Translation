package com.gmail.ptimofejev;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import java.util.HashMap;

public class Main {

	public static void main(String[] args) {
		Vocabulary vocMain = new Vocabulary(new HashMap<String, String>());
		defaultVocabularyFill(vocMain);
		vocMain.addWordPairManual();
		System.out.println(vocMain);
		File vocFile = new File("Vocabulary");
		vocMain.writeToFile(vocFile);
		File englishIn = new File("English.in");
		File ukrainianOut = new File("Ukrainian.out");
		translate(englishIn, ukrainianOut, vocMain);
	}
	
	public static void defaultVocabularyFill(Vocabulary voc1) {
		voc1.getWords().put("the", "");
		voc1.getWords().put("is", "є");
		voc1.getWords().put("London", "Лондон");
		voc1.getWords().put("Britain", "Британія");
		voc1.getWords().put("of", "");
		voc1.getWords().put("Great", "Велика");
		voc1.getWords().put("capital", "столиця");
	}
	
	public static void translate (File in, File out, Vocabulary voc) {
		String input = readFileToString(in);
		String[] inputs = input.split(" ");
		try {
			out.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		StringBuilder sb1 = new StringBuilder();
		for (int i = 0; i < inputs.length; i++) {
			sb1.append(voc.getWords().get(inputs[i]) + " ");
		}
		String result = sb1.toString();
		writeToFile(out, result);
	}
	
	public static String readFileToString(File input) {
		StringBuilder sb1 = new StringBuilder();
		String nextline = null;
		try (BufferedReader br1 = new BufferedReader(new FileReader(input))) {
			while ((nextline = br1.readLine()) != null) {
				sb1.append(nextline);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sb1.toString();
	}
	
	public static void writeToFile(File file, String toWrite) {
		try (BufferedWriter bw1 = new BufferedWriter(new FileWriter(file))) {
			bw1.write(toWrite);
			bw1.newLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
