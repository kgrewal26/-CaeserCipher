package cipherProject;
/**
 * 
 * @author Kaveet Grewal
 * @version 1.0
 * @since April 2020
 *
 */
import java.nio.charset.StandardCharsets;
public enum Alphabet {
	
	
	ENGLISH("ENG", "A B C D E F G H I J K L M N O P Q R S T U V W X Y Z"),
	FRENCH("FRE", "A À Â Æ B C Ç D E É È Ê Ë F G H I Î Ï J K L M N O Ô Œ P Q R S T U Ù Û Ü V W X Y Ÿ Z"),
	SPANISH("SPA", "A B C D E F G H I J K L M N Ñ O P Q R S T U V W X Y Z"),
	ITALIAN("ITA", "A B C D E F G H I L M N O P Q R S T U V Z"),
	GREEK("GRE", "Α Β Γ Δ Ε Ζ Η Θ Ι Κ Λ Μ Ν Ξ Ο Π Ρ Σ Τ Υ Φ Χ Ψ Ω");
	
	
	
	private String code;
	private String letters;
	
	Alphabet(String code, String alphabet) {
		
		this.code = code;
		this.letters = alphabet;
		
	}

	public String getLetters() {
		return letters;
	}

	public String getCode() {
		return code;
	}
	
	public int getNumLetters() {
		
		char[] letters = this.getLetters().replaceAll(" ", "").toCharArray();
		
		return letters.length;
	}
}
