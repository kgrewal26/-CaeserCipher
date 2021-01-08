package cipherProject;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
public class Driver {

	public static void main(String[] args) {
		/*	
		String[] englishTrainingText = {"trainingText/englishTraining1.txt"}; 
		String[] spanishTrainingText = {"trainingText/SpanishTraining1.txt"};
		String[] frenchTrainingText = {"trainingText/FrenchTraining1.txt"}; 
		String[] italianTrainingText = {"trainingText/ItalianTraining1.txt"};
		
		try {
			Database.buildDB("English", englishTrainingText, "db/English", Alphabet.ENGLISH);
			Database.buildDB("Spanish", spanishTrainingText, "db/Spanish", Alphabet.SPANISH);
			Database.buildDB("Italian", italianTrainingText, "db/Italian", Alphabet.ITALIAN);
			Database.buildDB("French", frenchTrainingText, "db/French", Alphabet.FRENCH);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		*/
		
		/*
		try {
			System.out.println(CipherText.cipherTextFile("AliceAdventureInWonderlnd.txt", Alphabet.ENGLISH));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		
		/*
		String text = "sameer abhi divij kaveet";
		System.out.println(text);
		String cipheredText = CipherText.cipherText(text, Alphabet.ENGLISH);
		System.out.println(cipheredText);
		
		try {
			WordList words = (WordList) ReadWriteFiles.deSerialize("trainingText/English");
			String decrypt = DecryptText.decryptText(Alphabet.ENGLISH, cipheredText, words);
			System.out.println(decrypt);
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		*/
	}
}
