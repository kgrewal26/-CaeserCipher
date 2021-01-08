package cipherProject;
/**
 * 
 * @author Kaveet Grewal
 * @version 1.0
 * @since April 2020
 *
 */
import java.io.FileNotFoundException;
import java.io.IOException;

public class Database {

	/**
	 * Builds the database given the files, language, alphabet and storage location.
	 * @param language
	 * @param trainingFiles
	 * @param dbFileName
	 * @param alphabet
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public static void buildDB(String language, String[] trainingFiles, String dbFileName, Alphabet alphabet) throws IOException, ClassNotFoundException{
		
		String tempPhrase = "";
		Word badWord = new Word("");
		
		//add the files into one big string
		for (int index = 0; index < trainingFiles.length; index++) {
			tempPhrase = tempPhrase + ReadWriteFiles.readFile(trainingFiles[index]);
		}
	
		//clean the string into an array
		String[]newWords = CleanText.clean(tempPhrase, alphabet.getLetters());
		
		
		//if the database exists
		try {
			
			//take the wordlist from the file
			WordList words = (WordList) ReadWriteFiles.deSerialize(dbFileName);
			
			//update the list
			words = CleanText.updateList(words, newWords);
			words.removeWord(badWord);
			words.removeWeakWords(0.01);
			System.out.println(words.toString());
			
			//serialize
			ReadWriteFiles.serialize(dbFileName, words);
			
		} catch (IOException e) {
			
			//do this if no wordlist/database exists, follow same procedure, will only run once per language. Code is pretty much the same
			WordList words = new WordList(language);
			
			words = CleanText.updateList(words, newWords);
			
			words.removeWeakWords(0.01);
			
			System.out.println(words.toString());
			
			ReadWriteFiles.serialize(dbFileName, words);
			
			
		}
		
	}
}
