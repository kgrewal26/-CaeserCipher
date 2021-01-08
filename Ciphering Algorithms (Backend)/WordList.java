package cipherProject;
/**
 * 
 * @author Kaveet Grewal
 * @version 1.0
 * @since April 2020
 *
 */
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

public class WordList implements Serializable {

	private static final long serialVersionUID = 3L;
	private ArrayList<Word> words;
	private String language;
	private int count;
	
	/**
	 * Creates a word list given the language
	 * @param language
	 */
	public WordList(String language) {
		this.words = new ArrayList<Word>();
		this.language = language;
		this.count = 0;
	}
	
	/**
	 * Gets and returns the words in the word list
	 * @return words
	 */
	public ArrayList<Word> getWords() {
		return words;
	}
	
	/**
	 * changes the words in list
	 * @param words
	 */
	public void setWords(ArrayList<Word> words) {
		this.words = words;
	}
	
	/**
	 * Returns the language of the list
	 * @return language
	 */
	public String getLanguage() {
		return language;
	}
	
	/**
	 * sets the language of the list
	 * @param language
	 */
	public void setLanguage(String language) {
		this.language = language;
	}
	
	/**
	 * gets the word count of list
	 * @return the word count
	 */
	public int getCount() {
		return count;
	}
	
	/**
	 * sets the new count 
	 * @param count
	 */
	public void setCount(int count) {
		this.count = count;
	}
	
	/**
	 * finds a word in the list and returns the frequency
	 * @param newWord
	 * @return frequency
	 */
	public int getFreq(String newWord) {
		
		//look for the word and return the frequency
		for (Word word: words) {
			if (word.getWord().equals(newWord)) {
				return word.getFreq();
			}
		}
		return 0;
	}
	
	/**
	 * Adding a word to the list
	 * @param newWord
	 * @return true or false
	 */
	public boolean addWord(Word newWord) {
			
		//try to look for the word
		for (Word word: words) {
			
			//if its there increase the freq and return true to end the method
			if (word.getWord().equals(newWord.getWord())) {
				word.increaseFreq();
				return true;
			}	
		}	
	
		//if it wasn't there add it
		words.add(newWord);
		setCount(getCount() + 1);
		return false;
	}
	
	
	public boolean removeWord(Word badWord) {
		
		for (Word word: words) {
			
			if (word.getWord().equals(badWord.getWord())){
				words.remove(word);
				return true;
			}
		}
		
		return false;
	}
	
	/**
	 * sorts a list
	 */
	public void sort() {
		Collections.sort(words, new WordComparator());
	}
	
	/**
	 * check for a word
	 * @param wordCandidate
	 * @return true or false
	 */
	public boolean wordFound(String wordCandidate) {
		
		//go through all the words
		for (Word words: words) {
			//if it matches the candidate return true
			if (words.getWord().equals(wordCandidate)) {
				return true;
			}
		}
		
		return false;
	}
	
	/**
	 * get all words in an array
	 * @return the word array
	 */
	public String[] getAllWords() {
		
		//all words in a string
		String[] allWords = new String[words.size()];
		
		//add each word string to the string array
		for (Word word: words) {
			allWords[words.indexOf(word)] = word.getWord();
		}
		return allWords;
	}
	

	/**
	 * removes words given a threshold
	 * @param threshHold
	 */
	public void removeWeakWords(int threshHold) {
		
		ArrayList<Word> temp = new ArrayList<Word>();
		
		//go through each word if its below the threshold remove it
		for (Word word: words) {
			if (word.getFreq()>threshHold) {
				temp.add(word);
			}
		}
		words = temp;
	}
	
	/**
	 * removes words given a certain percent
	 */
	public void removeWeakWords(double percent) {
		
		// remove percentage of words form the list
		ArrayList<Word> temp = new ArrayList<Word>();
		sort();
		
		// keeping only x percent of the words
		int threshHold = (int)(percent*words.size());
        for (int i = 0; i <= threshHold;i++) {
        	temp.add(words.get(i));
        }
        words = temp;
        count = words.size();
	}
	
	@Override
	public String toString() {
		String info = this.language + " total: " + this.count + "\n";
		
		for (Word word: words) {
			info += word.getWord() + ": " + word.getFreq() + "\n";
		}
		return info;
	}
}


