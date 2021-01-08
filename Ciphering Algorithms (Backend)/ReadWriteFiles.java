package cipherProject;
import java.io.BufferedReader;
/**
 * 
 * @author Kaveet Grewal
 * @version 1.0
 * @since April 2020
 *
 */
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class ReadWriteFiles {

	
	/**
	 * Takes the file and returns it as a string
	 * @param filename
	 * @return file in string form
	 * @throws IOException
	 */
	public static String readFile(String filename) throws IOException{
		
		String text = "";
		
		try {
			text = new String(Files.readAllBytes(Paths.get(filename)));
		}catch (IOException e) {
			e.printStackTrace();
		}
		
		return text;
	}
	
	/**
	 * Takes data and turns it into a file
	 * @param fileName
	 * @param serializableObject
	 * @throws IOException
	 */
	public static void serialize( String fileName, Object serializableObject) throws IOException {
		
		FileOutputStream fos = new FileOutputStream(fileName);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(serializableObject);
		
	}
	
	/**
	 * Analyzes a file and returns it as a object (string)
	 * @param fileName
	 * @return the data
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public static Object deSerialize(String fileName) throws
	
	FileNotFoundException, IOException, ClassNotFoundException {
		
	FileInputStream fis = new FileInputStream(fileName);
	ObjectInputStream ois = new ObjectInputStream(fis);
	
		
	return ois.readObject();
	}//end method deSerialize
	
}

