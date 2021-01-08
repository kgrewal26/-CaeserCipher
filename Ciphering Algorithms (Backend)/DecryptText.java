package cipherProject;

import java.io.IOException;

public class DecryptText {

	
	
	
	public static String decryptText(Alphabet alphabet, String text, WordList languageWords) {
		
		int maxWordMatches = 0;
		int bestKey = 0;
		
		
		for (int key = 0; key < alphabet.getNumLetters(); key++) {
		
			String cipheredText= CipherText.cipherGivenKey(text, alphabet, key);
			
			int sum = 0;
			
			String words[] = CleanText.clean(cipheredText);
			
			for (int wordIndex = 0; wordIndex < words.length; wordIndex++) {
				
				if (languageWords.wordFound(words[wordIndex])) {
					sum++;
				}
			}
			
			
			if(sum > maxWordMatches) {
				maxWordMatches = sum;
				bestKey = key;
			}	
		}
				
		return CipherText.cipherGivenKey(text, alphabet, bestKey);
		
	}
	
	
	public static String decryptFile(Alphabet alphabet, String fileName, WordList languageWords) throws IOException {
		
		String text = ReadWriteFiles.readFile(fileName);
		
		
		return decryptText(alphabet, text, languageWords);
	}
}
