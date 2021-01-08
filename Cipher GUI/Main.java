package application;
	
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import cipherProject.*;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;


public class Main extends Application {
	
	//attributes and fields
	private Pane root;
	private Scene scene;
	
	
	private String dbFileName, trainingFileName, cipherFileName, decryptFileName;
	private TabPane tabs;
	private Tab tabDB, tabExp, tabCiphText, tabCiphFile, tabSettings, tabDecryptText, tabDecryptFile;
	
	private TextArea displayInfo, displayExp, displayCiphText, displayCiphFile, enterCiphText, enterDecryptText, displayDecryptText, displayDecryptFile;

	
	private ScrollPane scInfo, scExp, scCiphText, scCiphFile, scDecryptText, scDecryptFile;
	
	private Button chooseBtn, updateDB, sortFreq, sortAlpha, dbBtn, showDB, dbBtn2, showCiphText, showCiphFile, ciphFilesBtn, decryptText, decryptFile, chooseDecryptFile; 
	private RadioButton english, french, spanish, italian;
	
	private ToggleGroup language;

	private DirectoryChooser dc;
	private File holder;
	
	private ComboBox<File> choicesFile, choicesDB, choicesDB2, choicesCipher, choicesDecrypt;
	private ObservableList<File> options;
	
	private Label promptEnterDecrypt, promptDecryptText, promptLanguage, promptEnterCipher, promptCipherText;
	
	private Alphabet alphabet;
	private WordList words;
	
	private GridPane grdPInfo, grdPExp, grdPCiphFile, grdPCiphText, grdPSettings, grdPDecryptText, grdPDecryptFile;
	
	
	public void initTabDecryptFile() {
		
		tabDecryptFile = new Tab("Decrypt File");
		
		chooseDecryptFile = new Button("Choose Decrypt File");
		choicesDecrypt = new ComboBox<File>();
		
		decryptFile = new Button("Decrypt File");
		
		displayDecryptFile = new TextArea();
		displayDecryptFile.setMinSize(50, 50);
		displayDecryptFile.setEditable(false);
		
		scDecryptFile = new ScrollPane();
		scDecryptFile.setContent(displayDecryptFile);
		
		
		grdPDecryptFile = new GridPane();
		grdPDecryptFile.setHgap(5);
		grdPDecryptFile.setVgap(10);
		GridPane.setConstraints(chooseDecryptFile, 0, 1);
		GridPane.setConstraints(choicesDecrypt, 0, 3);
		GridPane.setConstraints(decryptFile, 0, 4);
		GridPane.setConstraints(scDecryptFile, 0, 5);
		
		grdPDecryptFile.getChildren().addAll(chooseDecryptFile, choicesDecrypt, decryptFile, scDecryptFile);
		tabDecryptFile.setContent(grdPDecryptFile);
	}
	/**
	 * Creating the Info Tab for the Program
	 */
	public void initTabInfo() {
		
		//create tab
		tabDB = new Tab("Train Database");
		
		//create text area and attach scroll wheel
		displayInfo = new TextArea();
		displayInfo.setMinSize(50, 50);
		displayInfo.setEditable(false);
		scInfo = new ScrollPane();
		scInfo.setContent(displayInfo);
		
		//buttons
		chooseBtn = new Button("Choose Files");
		dbBtn = new Button("Select Database Directory");
		updateDB = new Button("Update Database");	
		
		//combo boxes for fiels
		choicesFile = new ComboBox<File>();
		choicesDB = new ComboBox<File>();
		
		//Layout manager
		grdPInfo = new GridPane();
		grdPInfo.setHgap(5);
		grdPInfo.setVgap(10);
		GridPane.setConstraints(chooseBtn, 0,1);
		GridPane.setConstraints(choicesFile, 0,2);
		GridPane.setConstraints(dbBtn, 0, 3);
		GridPane.setConstraints(choicesDB, 0, 4);
		GridPane.setConstraints(scInfo, 0,9);
		GridPane.setConstraints(updateDB, 0, 10);
		
		//add elements to gridpane and set content
		grdPInfo.getChildren().addAll(chooseBtn,scInfo,choicesFile, updateDB, dbBtn, choicesDB);
		tabDB.setContent(grdPInfo);
	}
	

	
	/**
	 * The Explore Tab for the Program
	 */
	public void initTabExp() {
		
		//create tab
		tabExp = new Tab("Explore Database");
		
		
		//display text and attach scroll wheel
		displayExp = new TextArea();
		displayExp.setMinSize(50, 50);
		displayExp.setEditable(false);
		
		scExp = new ScrollPane();
		scExp.setContent(displayExp);
		
		//useful buttons
		dbBtn2 = new Button("Select Database Directory");
		showDB = new Button("Load Database");
		sortFreq = new Button("Sort Frequency");
		sortAlpha = new Button("Sort Alphabetically");
		
		
		//combobox for files
		choicesDB2 = new ComboBox<File>();
		
		
		//layout manager
		grdPExp = new GridPane();
		grdPExp.setHgap(5);
		grdPExp.setVgap(10);
		GridPane.setConstraints(dbBtn2, 0, 1);
		GridPane.setConstraints(choicesDB2, 0, 2);
		GridPane.setConstraints(scExp, 0, 3);
		GridPane.setConstraints(showDB, 0, 4);
		GridPane.setConstraints(sortFreq, 0, 5);
		GridPane.setConstraints(sortAlpha, 0, 6);
		
		
		//add elements
		grdPExp.getChildren().addAll(dbBtn2, choicesDB2, scExp, showDB, sortFreq, sortAlpha);
		tabExp.setContent(grdPExp);
	}
	
	public void initTabCipherFile() {
		
		//create tab
		tabCiphFile = new Tab("Cipher File");
		
		displayCiphFile = new TextArea();
		displayCiphFile.setMinSize(50, 50);
		displayCiphFile.setEditable(false);
		
		//scroll wheel
		scCiphFile = new ScrollPane();
		scCiphFile.setContent(displayCiphFile);
		
		
		//useful buttons
		ciphFilesBtn = new Button("Select File Directory");
		showCiphFile = new Button("Show File Cipher");
		
		
		//combobox
		choicesCipher = new ComboBox<File>();
		
		
		
		grdPCiphFile = new GridPane();
		grdPCiphFile.setHgap(5);
		grdPCiphFile.setVgap(10);
		GridPane.setConstraints(ciphFilesBtn, 0, 1);
		GridPane.setConstraints(choicesCipher, 0, 2);
		GridPane.setConstraints(scCiphFile, 0, 4);
		GridPane.setConstraints(showCiphFile, 0, 5);
		
		grdPCiphFile.getChildren().addAll(ciphFilesBtn, choicesCipher, scCiphFile, showCiphFile);
		tabCiphFile.setContent(grdPCiphFile);
		
	}
	
	public void initTabCipherText() {
		tabCiphText = new Tab("Cipher Text");
		
		promptCipherText = new Label("Ciphered Text: ");
		displayCiphText = new TextArea();
		displayCiphText.setPrefSize(500, 50);
		displayCiphText.setEditable(false);
		
		
		promptEnterCipher = new Label("Enter Text To Cipher: ");
		enterCiphText = new TextArea();
		enterCiphText.setPrefSize(500, 50);
		enterCiphText.setEditable(true);
		
		scCiphText = new ScrollPane();
		scCiphText.setContent(displayCiphText);
		
		//useful buttons
		showCiphText = new Button("Show Cipher");
		
		
		grdPCiphText = new GridPane();
		grdPCiphText.setHgap(5);
		grdPCiphText.setVgap(10);
		GridPane.setConstraints(enterCiphText, 0, 3);
		GridPane.setConstraints(showCiphText, 0, 7);
		GridPane.setConstraints(scCiphText, 0, 12);
		GridPane.setConstraints(promptEnterCipher, 0, 2);
		GridPane.setConstraints(promptCipherText, 0, 11);
		
		grdPCiphText.getChildren().addAll(enterCiphText, showCiphText, scCiphText, promptEnterCipher, promptCipherText);
		tabCiphText.setContent(grdPCiphText);
		
	}
	
	public void initTabSettings() {
		
		tabSettings = new Tab("Settings");
		
		promptLanguage = new Label("Select A Language");
				
		//radiobuttons for language
		english = new RadioButton("English");
		french = new RadioButton("French");
		spanish = new RadioButton("Spanish");
		italian  = new RadioButton("Italian");
		
		
		//put rad buttons in a group so only 1 can be checked at a time
		language = new ToggleGroup();
		english.setToggleGroup(language);
		french.setToggleGroup(language);
		spanish.setToggleGroup(language);
		italian.setToggleGroup(language);
		
		grdPSettings = new GridPane();
		grdPSettings.setHgap(30);
		grdPSettings.setVgap(15);
		GridPane.setConstraints(promptLanguage, 0 ,3);
		GridPane.setConstraints(english, 0, 4);
		GridPane.setConstraints(french, 0, 5);
		GridPane.setConstraints(spanish, 0, 6);
		GridPane.setConstraints(italian, 0, 7);
		
		grdPSettings.getChildren().addAll(english, french, italian, spanish, promptLanguage);
		tabSettings.setContent(grdPSettings);
		
	}
	
	public void initTabDecryptText() {
		
		
		tabDecryptText = new Tab("Decrypt Text");
		
		promptEnterDecrypt = new Label("Enter Text To Decrypt:");
		
		enterDecryptText = new TextArea();
		enterDecryptText.setPrefSize(500, 30);
		
		decryptText = new Button("Decrypt Text");
		
		promptDecryptText = new Label("Decrypted Text:");
		
		displayDecryptText = new TextArea();
		displayDecryptText.setPrefSize(500, 50);
		displayDecryptText.setEditable(false);
		
		scDecryptText = new ScrollPane();
		scDecryptText.setContent(displayDecryptText);
		
		
		
		grdPDecryptText = new GridPane();
		grdPDecryptText.setHgap(5);
		grdPDecryptText.setVgap(10);
		
		GridPane.setConstraints(enterDecryptText, 0, 3);
		GridPane.setConstraints(promptEnterDecrypt, 0, 2);
		GridPane.setConstraints(scDecryptText, 0, 12);
		GridPane.setConstraints(promptDecryptText, 0, 11);
		GridPane.setConstraints(decryptText, 0, 7);
		
		
		grdPDecryptText.getChildren().addAll(enterDecryptText, scDecryptText, promptEnterDecrypt, promptDecryptText, decryptText);
		
		tabDecryptText.setContent(grdPDecryptText);
		
	}
	
	/**
	 * The method that bridges the start to the tabs
	 */
	public void init() {
		
		//directory choosers and tabs are created
		dc = new DirectoryChooser();
		tabs = new TabPane();
		
		//call and create tabs, add them
		initTabInfo();
		initTabExp();
		initTabCipherFile();
		initTabCipherText();
		initTabSettings();
		initTabDecryptText();
		initTabDecryptFile();
		
		tabs.getTabs().add(tabDB);
		tabs.getTabs().add(tabExp);
		tabs.getTabs().add(tabCiphFile);
		tabs.getTabs().add(tabCiphText);
		tabs.getTabs().add(tabDecryptText);
		tabs.getTabs().add(tabDecryptFile);
		tabs.getTabs().add(tabSettings);
		
		//new vbox and add tabs 
		root = new VBox(10);
		root.getChildren().add(tabs);
		root.setPadding(new Insets(12, 12, 12, 12));
		scene = new Scene(root,660,500);
	}
	
	public void actions(Stage stage) {
		
		
		//when combobox for databse files are interacted with
		  choicesDB.valueProperty().addListener(new ChangeListener<File>() {
		  
		  @Override public void changed(ObservableValue<? extends File> arg0, File
		  arg1, File arg2) {
			  
			  //get the filepath for the database and let the user know
			  dbFileName = arg2.getAbsolutePath();
			  displayInfo.setText(displayInfo.getText() + "\nSuccessfully Found Database file at:  \n" + dbFileName);
			  
			  
		  } });
		  
		  
		  
		  choicesCipher.valueProperty().addListener(new ChangeListener<File>() {
			  
		  @Override public void changed(ObservableValue<? extends File> arg0, File
		  arg1, File arg2) {
			  
			  //get the filepath for the database and let the user know
			  cipherFileName = arg2.getAbsolutePath();
			  displayCiphFile.setText(displayCiphFile.getText() + "\nSuccessfully Found text file at:  \n" + cipherFileName);
			  
			  
		  } });  
		 
		//when the file combobox is interacted with
		choicesFile.valueProperty().addListener(new ChangeListener<File>() {
			@Override
			public void changed(ObservableValue<? extends File> arg0, File arg1, File arg2) {
				
				//get the file path and let the user know
				trainingFileName = arg2.getAbsolutePath();
				displayInfo.setText(displayInfo.getText() + "\nSuccessfully Found Training Text File at: \n" + trainingFileName);
				
			}  
		});
		
		
		//same as database above but is for the explore page
		 choicesDB2.valueProperty().addListener(new ChangeListener<File>() {
			  
		  @Override public void changed(ObservableValue<? extends File> arg0, File arg1, File arg2) {
			  
			  
			  //get filepath and let user know
			  dbFileName = arg2.getAbsolutePath();
			  displayExp.setText(displayExp.getText() + "\nSuccessfully Found Database File at: \n" + dbFileName);
			  
		  } });

		 //file combo box for the decrypted file
		 choicesDecrypt.valueProperty().addListener(new ChangeListener<File>() {
			  
		  @Override public void changed(ObservableValue<? extends File> arg0, File arg1, File arg2) {
			  
			  
			  //get filepath and let user know
			  decryptFileName = arg2.getAbsolutePath();
			  Alert success = new Alert(AlertType.INFORMATION,  "Found file at: " + decryptFileName);
			  success.show();
			  
		  } });
		 
		 //when the database button is interacted with
		dbBtn.setOnAction(new EventHandler<ActionEvent>() {
		  
		  @Override 
		  public void handle(final ActionEvent e) { 
			
			  //get the files and place them in the combobox
			  holder = dc.showDialog(stage);
				File[] files = holder.listFiles();
				if (options!=null)
					choicesFile.getItems().removeAll(options);
				options = FXCollections.observableArrayList();
				for (File file:files) {
					options.add(file);
				}
				
				choicesDB.getItems().addAll(options);
				
		  } });
		
		
		//same as above but for the explore tab
		dbBtn2.setOnAction(new EventHandler<ActionEvent>() {
			  
			  @Override 
			  public void handle(final ActionEvent e) { 
					
				  holder = dc.showDialog(stage);
					File[] files = holder.listFiles();
					if (options!=null)
						choicesFile.getItems().removeAll(options);
					options = FXCollections.observableArrayList();
					for (File file:files) {
						options.add(file);
					}
					
					choicesDB2.getItems().addAll(options);
					
			  } });
		 
		
		//same as above but for training file names instead of database
		chooseBtn.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(final ActionEvent e) {
				//TODO
				holder = dc.showDialog(stage);
				File[] files = holder.listFiles();
				if (options!=null)
					choicesFile.getItems().removeAll(options);
				options = FXCollections.observableArrayList();
				for (File file:files) {
					options.add(file);
				}
				
				choicesFile.getItems().addAll(options);
			}
		});
		
		//same as above but for cipher file names instead of database
		ciphFilesBtn.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(final ActionEvent e) {
				//TODO
				holder = dc.showDialog(stage);
				File[] files = holder.listFiles();
				if (options!=null)
					choicesFile.getItems().removeAll(options);
				options = FXCollections.observableArrayList();
				for (File file:files) {
					options.add(file);
				}
				
				choicesCipher.getItems().addAll(options);
			}
		});
		
		//same as above but for the decrypted files
		chooseDecryptFile.setOnAction(new EventHandler<ActionEvent>() {
			  
			  @Override 
			  public void handle(final ActionEvent e) { 
				
				  //get the files and place them in the combobox
				  holder = dc.showDialog(stage);
					File[] files = holder.listFiles();
					if (options!=null)
						choicesFile.getItems().removeAll(options);
					options = FXCollections.observableArrayList();
					for (File file:files) {
						options.add(file);
					}
					
					choicesDecrypt.getItems().addAll(options);
					
			  } });
			
		
		//english radio button
		english.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(final ActionEvent e) {
				
				//make the language english and tell the user
				alphabet = Alphabet.ENGLISH;
				Alert success = new Alert(AlertType.INFORMATION,  "Changed Language to English!");
				success.show();
			}
			
		});
		
		
		//french radio button
		french.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(final ActionEvent e) {
				
				//make the language french and tell the user
				alphabet = Alphabet.FRENCH;
				Alert success = new Alert(AlertType.INFORMATION,  "Changed Language to French!");
				success.show();
			}
			
		});
		
		
		//spanish radio button
		spanish.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(final ActionEvent e) {
				
				//make the language spanish and tell user
				alphabet = Alphabet.SPANISH;
				Alert success = new Alert(AlertType.INFORMATION,  "Changed Language to Spanish!");
				success.show();
			}
			
		});
		
		
		//italian radio button
		italian.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(final ActionEvent e) {
				
				//make language italian and tell the user
				alphabet = Alphabet.ITALIAN;
				Alert success = new Alert(AlertType.INFORMATION,  "Changed Language to Italian!");
				success.show();
			}
			
		});
		
		
		//update db button
		updateDB.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(final ActionEvent e) {
				
				//create an array of text file so it can be basses through
				String[]trainingtext = {trainingFileName};
				
				try {
					//build/update the database given the paramaters
					Database.buildDB(alphabet.toString(), trainingtext, dbFileName, alphabet);
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				//set text to inform the user
				displayInfo.setText("Database Successfully Updated, View it in the Explore Page");
				displayExp.setText("");
			}
			
		});
		
		//shows/load database button
		showDB.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(final ActionEvent e) {			
				
				try {
					
					//deserialize the database given filepath, display it in the text area
					words = (WordList) ReadWriteFiles.deSerialize(dbFileName);
					displayExp.setText(words.toString());
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			
		});
		
		
		sortFreq.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				
				try {
					words = (WordList) ReadWriteFiles.deSerialize(dbFileName);
					words.sort();
					displayExp.setText(words.toString());
				} catch (ClassNotFoundException | IOException e) {
					e.printStackTrace();
				}
				
			}
			
		});
		
		showCiphFile.setOnAction(new EventHandler<ActionEvent>() {
			
			public void handle(final ActionEvent e) {

					try {
						displayCiphFile.setText(CipherText.cipherTextFile(cipherFileName, alphabet));
					} catch (IOException | NullPointerException e1) {
						Alert failure = new Alert(AlertType.ERROR,  "Ensure you have uploaded a valid file and selected a language!");
						failure.show();
					}

			}
		});
		
		showCiphText.setOnAction(new EventHandler<ActionEvent>(){
			
			public void handle(final ActionEvent e) {
				try {
					displayCiphText.setText(CipherText.cipherText(enterCiphText.getText(), alphabet)); 					
				}catch (NullPointerException e1) {
					Alert failure = new Alert(AlertType.ERROR,  "Ensure you have selected a language!");
					failure.show();
				}

			}
		});
		
		
		decryptText.setOnAction(new EventHandler<ActionEvent>() {
			
			public void handle(final ActionEvent e) {
				try {
					displayDecryptText.setText(DecryptText.decryptText(alphabet, enterDecryptText.getText(), words));	
				} catch(NullPointerException e1) {
					Alert failure = new Alert(AlertType.ERROR,  "Ensure you have uploaded a database and selected a language!");
					failure.show();
				}
				
			}
		});
		
		
		decryptFile.setOnAction(new EventHandler<ActionEvent>() {
			
			public void handle(final ActionEvent e) {
				try {
					displayDecryptFile.setText(DecryptText.decryptFile(alphabet, decryptFileName, words));
				} catch (IOException | NullPointerException e1) {
					Alert failure = new Alert(AlertType.ERROR,  "Ensure you have uploaded a database, selected a language, and a valid file!");
					failure.show();
				}
			}
		});
	}

	
	
	
	
	@Override
	public void start(Stage primaryStage) {
		init();
		primaryStage.setScene(scene);
		primaryStage.show();
		actions(primaryStage);
		
		Alert startup = new Alert(AlertType.INFORMATION, "Go To Settings and select the desired langugage!");
		startup.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	
}





	
