package edu.ggc.jdavis37;

import java.io.FileNotFoundException;

/**class : FileMissingException
 * 
 * @author Jason Davis - jdavis37
 * @version 1.0
 * Course : Intermediate Programming 2013
 * Written : Feb. 7 2013
 * 
 * FileMissingException extends FileNotFoundException its primary purpose
 * is to demonstrate the creation of a custom exception error and in the
 * implementation of the exception error in the FileSelect class.
 *
 */
public class FileMissingException extends FileNotFoundException
{
	/** long : serialVersionUID
	 * this is a unique identifier for this exception.
	 */
	private static final long serialVersionUID = -5035015479816525879L;

	public FileMissingException(String message)
	{
		super(message);
	}
}