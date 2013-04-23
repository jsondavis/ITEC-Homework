package edu.ggc.jdavis37;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


/**
 * Class CardTable
 * 
 * @author Jason Davis
 * @version 1.0 Course : ITEC 2150 Spring 2013 Written: March 25, 2013
 * 
 *          This class contains the primary logic for a desktop card game. The
 *          game deals 7 cards to each player (3 computer and 1 human). A card
 *          is selected by each player (randomly by the computer players) and
 *          placed into the middle of the table. The card values are compared
 *          and a winner is determined followed by asking the user to play
 *          again.
 * 
 *          The purpose of this class is to demonstrate the use of JComponents
 *          and the CardDeck class created for homework 2.
 */

public class CardTable
{

	/**
	 * frame is the frame container that all of the other components will be
	 * added to
	 * 
	 * pane , top , right, bottom, left, middle are all the JPanels used for the
	 * different hands and table center for the card game.
	 * 
	 * deck is the new CardDeck created for this game
	 * 
	 * players is an array of the Hand class 1 for each player
	 * 
	 * cards is an array of JButton's used to temporarily hold all of the
	 * buttons to be placed into a Hand
	 * 
	 * cardArray is an ArrayLIst used to store all of the buttons added to the
	 * different panes it is a static array so that the buttons can be
	 * referenced by the EventListeners below
	 * 
	 * handCount is an iterator used to determine the Layout necessary for each
	 * hand
	 */

	protected JFrame				frame;
	protected JPanel				pane, top, right, bottom, left, middle;
	protected CardDeck				deck;
	protected Hand[]				players		= new Hand[4];

	protected static JButton[]		cards;

	protected ArrayList<JButton>	cardArray	= new ArrayList<JButton>();

	private int						handCount	= 0;

	/**
	 * Method : makeHand
	 * 
	 * THe purpose of makeHand is to generate a JPanel which contains 7 randomly
	 * chosen cards from the deck object created above
	 * 
	 * @return JPanel containing 7 buttons whose text fields contain random
	 *         cards
	 */

	public JPanel makeHand()
	{
		handCount++;
		JPanel player = new JPanel();
		if (handCount % 2 == 0)
		{
			player.setLayout(new GridLayout(7, 1));
		}
		else
		{
			player.setLayout(new GridLayout(3, 3));
		}

		cards = new JButton[7];
		Hand playerHand = new Hand(7);

		for (int i = 0; i < playerHand.heldCards.length; i++)
		{
			playerHand.heldCards[i] = deck.deal();
			cards[i] = new JButton();
			cards[i].setText(playerHand.heldCards[i].getCard());
		}

		for (JButton button : cards)
		{
			player.add(button);
			cardArray.add(button);
		}

		return player;
	}

	/**
	 * Method : computerChoice
	 * 
	 * This method fills an array size 3 of integers with pseudo randomly
	 * generated numbers from 0 - 6 which are representative of the computer's
	 * choices on their turns.
	 * 
	 * @return an array of integers representing the computers' card choices
	 */

	private static int[] computerChoice()
	{
		int[] retArray = new int[3];
		for (int i = 0; i < retArray.length; i++)
		{
			int rand = (int) (Math.random() * 6);
			while (rand > 6)
			{
				rand = (int) (Math.random() * 6);
			}
			retArray[i] = rand + (i * 6);
		}
		retArray[2] += 6;
		return retArray;
	}

	/**
	 * Method : getWinner
	 * 
	 * This method compares the choices represented in playerChoice and picks to
	 * determine a winner for each game
	 * 
	 * @param playerChoice
	 *            this is the String containing the text from the players
	 *            selected card (button)
	 * @param picks
	 *            this integer array is assumed to be of length 3 (//TODO should
	 *            fix in a future version) of the computer's choices
	 */

	private void getWinner(String playerChoice, int[] picks)
	{

		String n = cardArray.get(picks[0]).getText();
		String e = cardArray.get(picks[1]).getText();
		String w = cardArray.get(picks[2]).getText();

		int playerCard = CardDeck.cardValue(new Card(playerChoice));
		int northComp = CardDeck.cardValue(new Card(n));
		int eastComp = CardDeck.cardValue(new Card(e));
		int westComp = CardDeck.cardValue(new Card(w));

		int max = Math.max(Math.max(northComp, playerCard),
				Math.max(eastComp, westComp));

		String message = "";

		if (playerCard == max)
		{
			message = "You Win! With the " + playerChoice;
		}
		else if (northComp == max)
		{
			message = "You Lost. Computer 1 won. With the " + n;
		}
		else if (eastComp == max)
		{
			message = "You Lost. Computer 2 won. With the " + e;
		}
		else
		{
			message = "You Lost. Computer 3 won. With the " + w;
		}

		winnerDisplay(message);
	}

	/**
	 * Method : winnerDisplay
	 * 
	 * This method takes the message String parameter and display's it as a
	 * message dialog
	 * 
	 * @param message
	 *            the String to be displayed in the message dialog
	 */

	private static void winnerDisplay(String message)
	{
		JOptionPane.showMessageDialog(null, message);
	}

	/**
	 * Method : addButton
	 * 
	 * This method adds the button parameter to the JPanel panel at the
	 * specified location in the String
	 * 
	 * @param panel
	 *            the panel to add the button to
	 * @param button
	 *            the button to add to the panel
	 * @param location
	 *            the location of the layout to add the button to
	 */

	private void addButton(JPanel panel, JButton button, String location)
	{
		panel.add(button, location);
		panel.revalidate();
		panel.repaint();
	}

	/**
	 * Method : removeButton
	 * 
	 * This method removes the button at the specific index from the JPanel
	 * specified
	 * 
	 * @param panel
	 *            the panel to remove a button from
	 * @param location
	 *            the index in cardArray referencing the button to remove
	 */

	private void removeButton(JPanel panel, int location)
	{
		panel.remove(cardArray.get(location));
		panel.revalidate();
		panel.repaint();
	}

	/**
	 * Method : replayCheck
	 * 
	 * This method asks the user if they would like to play the game again using
	 * an Option Dialog
	 */

	private void replayCheck()
	{
		Object[] options =
			{ "Yes, please", "No way!" };
		int n = JOptionPane.showOptionDialog(frame,
				"Would you like to play again?", "One More Time",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,
				null, // do not use a custom Icon
				options, // the titles of buttons
				options[0]); // default button title

		if (n == 0)
		{
			frame.dispose();
			CardTable c = new CardTable();
		}
		frame.dispose();
	}

	/**
	 * Method : Constructor
	 * 
	 * This method constructs a deck and JFrame and uses the above methods to
	 * create a card game
	 */

	public CardTable()
	{
		deck = new CardDeck();

		deck.shuffle();

		frame = new JFrame();
		frame.setSize(700, 700);
		frame.setTitle("Card Table");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		middle = new JPanel();
		middle.setLayout(new BorderLayout());

		pane = new JPanel();
		pane.setLayout(new BorderLayout());

		top = makeHand();
		right = makeHand();
		bottom = makeHand();
		left = makeHand();

		pane.add(top, BorderLayout.NORTH);
		pane.add(right, BorderLayout.EAST);
		pane.add(bottom, BorderLayout.SOUTH);
		pane.add(left, BorderLayout.WEST);
		pane.add(middle, BorderLayout.CENTER);

		/**
		 * class : myMouseEvent
		 * 
		 * This subclass is an implementation of MouseListener used to watch for
		 * clicks on the cards in the user's hand only
		 * 
		 */

		class myMouseEvent implements MouseListener
		{

			/**
			 * Method : mouseClicked
			 * 
			 * This method accepts the mClick event and determines which of the
			 * user's button's was selected. THis selection is passed to
			 * getWinner to determine the winner of the round and then
			 * replayCheck is called to determine if another round is to be
			 * played
			 * 
			 */
			@Override
			public void mouseClicked(MouseEvent mClick)
			{
				for (int i = 14; i < 21; i++)
				{
					if (mClick.getSource() == cardArray.get(i))
					{
						JButton button = new JButton();
						button.setText(cardArray.get(i).getText());
						addButton(middle, button, BorderLayout.SOUTH);
						removeButton(bottom, i);

						int[] picks = computerChoice();

						addButton(middle, cardArray.get(picks[0]),
								BorderLayout.NORTH);
						removeButton(top, picks[0]);

						addButton(middle, cardArray.get(picks[1]),
								BorderLayout.EAST);
						removeButton(right, picks[1] - 6);

						addButton(middle, cardArray.get(picks[2]),
								BorderLayout.WEST);
						removeButton(left, picks[2] - 18);

						getWinner(cardArray.get(i).getText(), picks);

						replayCheck();
					}
				}

			}

			@Override
			public void mouseEntered(MouseEvent arg0)
			{
				// TODO Auto-generated method stub
				// System.out.println("Mouse Entered");
			}

			@Override
			public void mouseExited(MouseEvent arg0)
			{
				// TODO Auto-generated method stub
				// System.out.println("Mouse Exit");
			}

			@Override
			public void mousePressed(MouseEvent arg0)
			{
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseReleased(MouseEvent arg0)
			{
				// TODO Auto-generated method stub

			}

		}

		MouseListener m = new myMouseEvent();

		for (int i = 14; i < 21; i++)
		{
			cardArray.get(i).addMouseListener(m);
		}

		frame.add(pane);

		frame.setVisible(true);

	}
}
