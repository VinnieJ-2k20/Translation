package com.gmail.ptimofejev;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Map;
import java.util.Scanner;

public class Vocabulary implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Map<String, String> words;
	
	public Vocabulary() {
		
	}

	public Vocabulary(Map<String, String> words) {
		this.words = words;
	}

	public Map<String, String> getWords() {
		return words;
	}

	public void setWords(Map<String, String> words) {
		this.words = words;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void addWordPairManual () {
		Scanner scan = new Scanner(System.in);
		System.out.println("Write original English word and press ENTER");
		String english = scan.nextLine();
		System.out.println("Write Ukrainian translation and press ENTER");
		String ukrainian = scan.nextLine();
		scan.close();
		words.put(english, ukrainian);
		System.out.println("Word pair added");
	}
	
	public void writeToFile(File file) {
		try (ObjectOutputStream ous1 = new ObjectOutputStream(new FileOutputStream(file))) {
			file.createNewFile();
			ous1.writeObject(this);
			System.out.println("Vocabulary successfully written to file");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public String toString() {
		return "Vocabulary [words=" + words + "]";
	}

}
