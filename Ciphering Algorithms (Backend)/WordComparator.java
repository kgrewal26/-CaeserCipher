package cipherProject;
/**
 * 
 * @author Kaveet Grewa
 * @version 1.0
 * @since April 2020
 *
 */
import java.util.Comparator;

public class WordComparator implements Comparator <Word> {

	/**
	 * Created my own comparator to easily sort a list
	 * @param two words
	 */
	@Override
	public int compare(Word o1, Word o2) {
		
		return o2.getFreq() - o1.getFreq();
	}

}
