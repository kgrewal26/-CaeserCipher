package cipherProject;

import java.io.FileNotFoundException;
import java.io.IOException;

public class MergeDB {

	
	public static void MergeDatabase(String database1, String database2) throws FileNotFoundException, ClassNotFoundException, IOException{
		
		WordList words1 = (WordList) ReadWriteFiles.deSerialize(database1);
		WordList words2 = (WordList) ReadWriteFiles.deSerialize(database2);
		
		for (Word words: words2.getWords()) {
			words1.addWord(words);
		}
		
		ReadWriteFiles.serialize(database1, words1);
	}
}
