package edu.ggc.jdavis37;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**class FileSelect
 * 
 * @author Jason Davis - jdavis37
 * @version 1.0
 * Course : Intermediate Programming 2013
 * Written : Feb. 7 2013
 * 
 * FileSelect contains all of the methods to open / display / and save a file
 * of the user's choosing and to throw a new exception error if the user input
 * is invalid.
 */
public class FileSelect
{
	/** Scanner : keyboard is an instance of Scanner
	 * used to read keyboard input in getFileName below
	 * String : SUGGESTION is a constant default value for file selection
	 * - sadly the default value is set for the desktop of my Linux box
	 */
	private Scanner keyboard;
	private final String SUGGESTION = "/home/jason/Desktop/test.txt";
	
	/**method : getFileName
	 * getFileName takes a message and suggestion
	 * @param suggestion the suggested / default value for the file path written as
	 * 		  a directory structure "/home/something/filename.txt"
	 * @param message by accepting a message for the filename / path the method can be reused later
	 * @return the path to the file as a string.
	 */
	private String getFileName(String message, String suggestion)
	{
		keyboard = new Scanner(System.in);
		System.out.println(message);
		String filePath = keyboard.next();
		if(filePath.equals("") || filePath.equals("1")){
			filePath = suggestion;
		}
		return filePath;
	}
	
	/**method : showFile
	 * showFile uses getFileName to create a file and then a scanner to iterate
	 * over the lines in the file and output them to the console
	 * @throws FileNotFoundException if the file is not found
	 * @throws FileMissingException if the file is not found and this 
	 * 		   is called before FileNotFoundException 
	 */
	private void showFile() throws FileMissingException, FileNotFoundException
	{
		String message = "Please enter the full path of the file to view.\n" +
  				 			String.format("Or type 1 for %s:", this.SUGGESTION);
		
		File openFile = new File(this.getFileName(message, this.SUGGESTION));
		
		Scanner fileScan = new Scanner(openFile);
		
		while(fileScan.hasNextLine())
		{
			System.out.println(fileScan.nextLine());
		}
		fileScan.close();
	}

	/**method : showReverseFile
	 * showReverseFile uses getFileName to create a file and then a scanner to iterate
	 * over the lines in the file put them into an ArrayList and output them to the 
	 * console in reverse order
	 * @throws FileNotFoundException if the file is not found
	 * @throws FileMissingException if the file is not found and this 
	 * 		   is called before FileNotFoundException 
	 */
	private void showReverseFile() throws FileMissingException, FileNotFoundException
	{
		String message = "Please enter the full path of the file to view the lines reversed.\n" +
		 				  String.format("Or type 1 for %s:", this.SUGGESTION);

		File openFile = new File(this.getFileName(message, this.SUGGESTION));

		Scanner fileScan = new Scanner(openFile);		
		ArrayList<String> reverse = new ArrayList<String>();
		while(fileScan.hasNextLine())
		{
			reverse.add(fileScan.nextLine());
		}
		
		for(int i = reverse.size(); i > 0; i--)
		{
			System.out.println(reverse.get(i-1));
		}
		fileScan.close();
	}
	
	/**
	 * NEWSUGGESTION is a constant default for the output file location
	 */
	private final String NEWSUGGESTION = "/home/jason/Desktop/testout.txt";
	
	/**method : writeFile
	 * writeFile opens 2 File objects 1 for reading from with a Scanner
	 * the second for writing to with a FileWriter the lines from the first 
	 * are written to the second
	 * @throws IOException
	 */
	private void writeFile() throws IOException
	{
		String message = "Please enter the full path of the file to read from.\n" +
		 			String.format("Or type 1 for %s:", this.SUGGESTION);

		File openFile = new File(this.getFileName(message, this.SUGGESTION));
		
		Scanner out = new Scanner(openFile);
		
		String newMessage = "Please enter the full path to save the output to.\n" +
		   				 String.format("Or type 1 for %s:", this.NEWSUGGESTION);
		
		String fileName = this.getFileName(newMessage, this.NEWSUGGESTION);
	
		File newFile = new File(fileName);
		
		FileWriter fw = new FileWriter(newFile);
		
		while(out.hasNextLine())
		{
			fw.write(out.nextLine() + "\r\n");
		}
		
		System.out.println("All lines written to file.");
		
		fw.close();

		out.close();
	}
	
	
	/**method : main
	 * This main method creates an instance of the FileSelect and uses the
	 * showFile, showReverseFile, and writeFile methods.  All of this is done
	 * in a try...catch block which makes use of the FileMissingException 
	 * error and it's getMessage method.  In addition it can catch the standard
	 * IOException and FileNotFound exceptions.
	 * @param args console parameters
	 */
	public static void main(String[] args)
	{
		try
		{
			FileSelect fs = new FileSelect();
		
			fs.showFile();
			
			System.out.println();
			fs.showReverseFile();
			
			System.out.println();
			fs.writeFile();
		}
		catch(FileMissingException ex)
		{
			System.out.println(ex.getMessage());
		}
		catch(FileNotFoundException e) 
		{
			System.out.println(e.getMessage());
		} 
		catch (IOException e)
		{
			System.out.println(e.getMessage());
		}
		
	}
	
	
}