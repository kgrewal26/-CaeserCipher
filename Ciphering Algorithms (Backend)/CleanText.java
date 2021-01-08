package cipherProject;
/**
 * 
 * @author Kaveet Grewal
 * @version 1.0
 * @since April 2020
 *
 */
public class CleanText {


	/**
	 * Updates the list to add new words
	 * @param list
	 * @param words
	 * @return updatedList
	 */
	public static WordList updateList(WordList list, String[] words) {
		
		//loop through every index in the list
		for (int index = 0; index < words.length; index++) {
			
			//the temp word is equal to the word at the index
			Word tempWord = new Word(words[index]);
			
			//try to add the temp word
			list.addWord(tempWord);
		}
		
		
		return list;
		
		
	}
	
	/**
	 * cleans the text given just the text
	 * @param phrase
	 * @return phrase split into an array
	 */
	public static String[] clean(String phrase) {
		
		//trim and split
		phrase.trim();
		String[]words = phrase.split(" ");
		
		//go through every word and regex and replace
		for (int index = 0; index < words.length; index++) {
			words[index] = words[index].replaceAll("[^a-zA-Z0-9]", "");
			//trim again
			words[index] = words[index].trim();
		}
		
		return words;
		
	}

	
	/**
	 * Cleans the text given the text and a language
	 * @param phrase
	 * @param language
	 * @return phrase split into an array
	 */
	public static String[] clean(String phrase, String language) {
		
		String phraseTemp = "";
		
		//trim and uppercase
		phrase = phrase.trim();
		phrase = phrase.toUpperCase();
		
		
		//loop through every character in the phrase
		for (int index = 0; index < phrase.length(); index++) {
			
			//if the character exists in the language alphabet, or is a space
			if ((language.indexOf(phrase.charAt(index)) >= 0) || (phrase.charAt(index) == (' '))) {
				
				//add it to the temp phrase
				phraseTemp = phraseTemp + phrase.charAt(index);
			}
		}
		
		phraseTemp = phraseTemp.trim();
		//System.out.println(phraseTemp);

		//split the temp phrase into array
		String[] words = phraseTemp.split(" ");
		
		//trim each word
		for (int index = 0; index < words.length; index++) {
			words[index] = words[index].trim();
		}
		
		return words;
		
	}
}
