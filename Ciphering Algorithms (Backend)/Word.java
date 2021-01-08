package cipherProject;
/**
 * 
 * @author Kaveet Grewal
 * @version 1.0
 * @since April 2020
 *
 */
import java.io.Serializable;


public class Word implements Serializable, Comparable<Word> {


	private static final long serialVersionUID = 1L;
	private String word;
	private int freq;
	
	/**
	 * Constructor
	 * @param word
	 * @param freq
	 */
	public Word(String word, int freq) {
		this.word = word;
		this.freq = freq;
	}
	
	/**
	 * Additional constructor
	 * @param word
	 */
	public Word(String word) {
		this.word = word;
		this.freq = 1;
	}
	
	/**
	 * get the string value of the word
	 * @return word
	 */
	public String getWord() {
		return word;
	}

	/**
	 * change the string value of the word
	 * @param word
	 */
	public void setWord(String word) {
		this.word = word;
	}
	
	/**
	 * Gets the frequency of the word
	 * @return words frequency
	 */
	public int getFreq() {
		return freq;
	}

	/**
	 * changes the words frequency
	 * @param freq
	 */
	public void setFreq(int freq) {
		this.freq = freq;
	}

	/**
	 * Increases the frequency of a word by 1
	 */
	public void increaseFreq() {
		this.freq++;
	}
	
	/**
	 * Adds two frequencys together
	 * @param freq
	 */
	public void addFreq(int freq) {
		this.freq = this.freq + freq;
	}
	
	
	/**
	 * Compares two words (i didn't use this but its here for flexibility)
	 * @param the compared word
	 * @return an integer
	 */
	@Override
	public int compareTo(Word  word) {
		if (this.freq<word.getFreq()) {
			return 1;
		} else if (this.freq==word.getFreq()) {
			return 0;
		} else {
			return -1;
		}
	}

	
}
