package mouseevents;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;



public class MouseThing
{
	protected static JButton getButton , clearButton;
	protected static JTextField field1;
	protected static JTextArea field2;
	protected static JLabel label1;
	protected JPanel pane;
	protected JPanel buttonpane;
	protected JFileChooser fileChooser;
	protected Scanner fileScan;
	protected File file;
	
	
	MouseThing()
	{
		// TODO Auto-generated method stub
		JFrame frame = new JFrame();
		frame.setSize(600, 600);
		frame.setTitle("Mouse Event Test");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		pane = new JPanel();
		buttonpane = new JPanel();
		
		pane.setLayout(new BorderLayout());
		buttonpane.setLayout(new GridLayout(2,1));
		
		label1 = new JLabel();
		label1.setBackground(Color.GRAY);
		label1.setText("test");
		pane.add(label1, BorderLayout.SOUTH);
		
		
		field1 = new JTextField(10);
		field1.setText("");
		pane.add(field1, BorderLayout.NORTH);
		
		
		getButton = new JButton();
		getButton.setText("Get Text");

		
		Listener eventListener = new Listener();
		getButton.addActionListener(eventListener);
		
		buttonpane.add(getButton);

		field2 = new JTextArea();
		pane.add(field2, BorderLayout.CENTER);
		
		clearButton = new JButton();
		clearButton.setText("Clear");
		clearButton.setSize(300, 100);
		
		clearButton.addActionListener(eventListener);
		
		buttonpane.add(clearButton);
		
		pane.add(buttonpane, BorderLayout.EAST);

		frame.add(pane);
		frame.setVisible(true);
	
		class mouseListen implements MouseListener
		{			 
			
			@Override
			public void mouseClicked(MouseEvent mE) {
				String button = "";
				if(mE.getButton() == 1)
				{
					button = "Left Button";
				}	
				else if(mE.getButton() == 3)
				{
					button = "Right Button";
				}
				if(mE.getSource() == getButton)
				{
					label1.setText(button + " clicked on Get Text Button.");
				}
				else if(mE.getSource() == clearButton)
				{
					label1.setText(button + " clicked on Clear Button.");
				}
			}

			@Override
			public void mouseEntered(MouseEvent mE) {
				if(mE.getSource() == field2)
				{
					label1.setText("Mouse entered Text Area.");
				}
				else if(mE.getSource() == field1)
				{
					label1.setText("Mouse entered Text Field.");
				}
			}

			@Override
			public void mouseExited(MouseEvent mE) {
				if(mE.getSource() == field2)
				{
					label1.setText("Mouse exited Text Area.");
				}
				else if(mE.getSource() == field1)
				{
					label1.setText("Mouse exited Text Field.");
				}
			}

			@Override
			public void mousePressed(MouseEvent mE) {
				String button = "";
				if(mE.getButton() == 1)
				{
					button = "Left Button";
				}	
				else if(mE.getButton() == 3)
				{
					button = "Right Button";
				}
				if(mE.getSource() == getButton)
				{
					label1.setText(button + " pressed on Get Text Button.");
					fileFinder();
				}
				else if(mE.getSource() == clearButton)
				{
					label1.setText(button + " pressed on Clear Button.");
				}
			}

			@Override
			public void mouseReleased(MouseEvent mE) {
				String button = "";
				if(mE.getButton() == 1)
				{
					button = "Left Button";
				}	
				else if(mE.getButton() == 3)
				{
					button = "Right Button";
				}
				if(mE.getSource() == getButton)
				{
					label1.setText(button + " released. Started on Get Text Button.");
				}
				else if(mE.getSource() == clearButton)
				{
					label1.setText(button + " released. Started on Clear Button.");
				}
			}
			
		}
		
		MouseListener m = new mouseListen();
		
		getButton.addMouseListener(m);
		clearButton.addMouseListener(m);
		field1.addMouseListener(m);
		field2.addMouseListener(m);
		
	}
	
	public void fileFinder()
	{
		fileChooser = new JFileChooser();
	    FileNameExtensionFilter filter = new FileNameExtensionFilter("Java source files or plain text.", "java", "txt");
	    fileChooser.setFileFilter(filter);
	    fileChooser.showOpenDialog(fileChooser);
	    file = fileChooser.getSelectedFile();
	    fileReader(file);
	}

	public void fileReader(File file)
	{
		Scanner scan;
		try
		{
			scan = new Scanner(file);
			String input = "";
			while(scan.hasNext())
			{
				input += scan.nextLine();
			}
			field2.setText(input);
		}
		catch(FileNotFoundException e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		MouseThing m = new MouseThing();
		
	}

}
