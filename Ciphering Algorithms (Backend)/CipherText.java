package cipherProject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class CipherText {

	
	
	
	public static String cipherTextFile(String filename, Alphabet alphabet) throws IOException {
		
		String textClean[] = CleanText.clean(ReadWriteFiles.readFile(filename), alphabet.getLetters());
		
		System.out.println(Arrays.toString(textClean));
		
		char[] letters = alphabet.getLetters().replaceAll(" ", "").toCharArray();
		
		String cipheredText = "";
		Random rand = new Random();
		int key = rand.nextInt(letters.length) + 1;
		
		ArrayList<String> words = new ArrayList<>();
		
		
		for (int arrayIndex = 0; arrayIndex < textClean.length; arrayIndex++) {
			
			StringBuilder word = new StringBuilder(textClean[arrayIndex]);
			
			for (int wordIndex = 0; wordIndex < textClean[arrayIndex].length(); wordIndex++) {
				if (word.charAt(wordIndex) == (' ')) {
					//do nothing
				}else {
					word.setCharAt(wordIndex, letters[(word.charAt(wordIndex) + key) % letters.length]);
				}
			}
			cipheredText = cipheredText + word.toString() + " ";

		}
		
		return cipheredText;
		
	}
	
	
	public static String cipherText(String text, Alphabet alphabet) {
		
		String textClean[] = CleanText.clean(text, alphabet.getLetters());
		
		char[] letters = alphabet.getLetters().replaceAll(" ", "").toCharArray();
		
		String cipheredText = "";
		Random rand = new Random();
		int key = rand.nextInt(letters.length) + 1;
		
		for (int arrayIndex = 0; arrayIndex < textClean.length; arrayIndex++) {
			
			StringBuilder word = new StringBuilder(textClean[arrayIndex]);
			
			for (int wordIndex = 0; wordIndex < textClean[arrayIndex].length(); wordIndex++) {
				if (word.charAt(wordIndex) == (' ')) {
					//do nothing
				}else {
					word.setCharAt(wordIndex, letters[(word.charAt(wordIndex) + key) % letters.length]);
				}
			}
			
			cipheredText = cipheredText  + word.toString() + " "; 
		}
		
		return cipheredText;
		
	}
	
	
	public static String cipherGivenKey(String text, Alphabet alphabet, int key) {
		
		String textClean[] = CleanText.clean(text, alphabet.getLetters());
		
		char[] letters = alphabet.getLetters().replaceAll(" ", "").toCharArray();
		
		String cipheredText = "";
		
		
		for (int arrayIndex = 0; arrayIndex < textClean.length; arrayIndex++) {
			
			StringBuilder word = new StringBuilder(textClean[arrayIndex]);
			
			for (int wordIndex = 0; wordIndex < textClean[arrayIndex].length(); wordIndex++) {
				if (word.charAt(wordIndex) == (' ')) {
					//do nothing
				}else {
					word.setCharAt(wordIndex, letters[(word.charAt(wordIndex) + key) % letters.length]);	
				}
			}
			
			cipheredText = cipheredText  + word.toString() + " "; 
		}
		
		return cipheredText;
		
	}
	
	
}
