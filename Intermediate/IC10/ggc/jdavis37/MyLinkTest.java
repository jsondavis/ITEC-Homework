package edu.ggc.jdavis37;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class MyLinkTest
{
	private JPanel pane;
	private JLabel label;
	private String str = "";
	private JButton b;
	
	public MyLinkTest()
	{
		class MyMouseListener implements MouseListener
		{
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				if(arg0.getSource() == b)
				{
					getString();
				}
				
				pane.revalidate();
				pane.repaint();
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

		}

		
		
		pane = new JPanel();
		
		label = new JLabel();
		label.setText(str);
		
		pane.add(label);
		
		b = new JButton();
		b.setText("Get String");
		
		MyMouseListener m = new MyMouseListener();
		b.addMouseListener(m);
		
		pane.add(b);
		pane.setVisible(true);
		
	}
	
	
	public void getString()
	{
		String exitMsg = "";
		do
		{
			String message = "Please input the word you would like to add to the list. \nOr type 42 to stop entering words.";
			String input = JOptionPane.showInputDialog(pane, message);
			if(input.equals("42"))
			{
				exitMsg = "42";
			}
			else
			{
				str += " " + input;
			}
		}
		while(exitMsg.equals(""));
		
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		MyLinkList myLL = new MyLinkList();
		String s = "I can't believe it's not butter";
		String[] strArr = s.split(" ");
		for(int i = 0; i < strArr.length; i++)
		{
			myLL.add(strArr[i]);
		}
		System.out.println(myLL);
		myLL.addFirst("My");
		System.out.println(myLL);
		
		System.exit(0);
	}

}
