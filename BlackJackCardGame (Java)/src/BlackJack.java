import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTextField;

public class BlackJack extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField texttotalmoney;
	public static int playermoney = 1000;
	public static int dealermoney = 1000;
	public int playerbet = 50;
	public int dealerbet = playerbet;
	public int gamemoney;
	int button = 0;
	public static int playervalue;                                           // We create our variables
	public static int dealervalue;
	public boolean endRound = false;
	Deck playerDeck = new Deck();
	Deck dealerDeck = new Deck();                                            // we called the Deck class
	Deck playingDeck = new Deck();
	Deck shuffledeck = null;
	int pcardValue;
	int dcardValue;
	public JButton btnplay;
	public JButton btnstay;
	public JButton btnhit;
	public JButton btnbet;
	ImageIcon PcardNumber;
	ImageIcon DcardNumber;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		// -------------------------------------------------------------------------------------------------
		// Method                                : void main(String[]args)
		// Method Parameters                     : args - The method permits String commands line parameters
		//                                         to be entered.
		// Method return                         : void
		// Synopsis                               : In this method we call all the functions.
		//
		//           Modifications :                         Author:                     Notes:
		//               Date: 
		//             2023/03/31                         C.Sebastian                 Initial Setup
		// -------------------------------------------------------------------------------------------------
		welcomemessage();

		try {
			BlackJack dialog = new BlackJack();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */

	public static void welcomemessage() {
		JOptionPane.showMessageDialog(null, "Welcome to blackjack");                                                // we create out welcome message
	}

	public BlackJack() {
		// -------------------------------------------------------------------------------------------------
		// Method                    : public
		// Method Parameters         : none
		// Method return             :
		// Synopsis                  : Here is where all our buttons and labels will appear
		//
		//           Modifications:           Author:                Notes:
		//                Date:                     
		//              2023/03/31           C.Sebastian           Initial Setup
		// -------------------------------------------------------------------------------------------------

		playingDeck.CreateFullDeck();                                                                          // we call the method createfulldeck

		getContentPane().setBackground(new Color(0, 255, 128));                                                      // we set the background.
		setBounds(100, 100, 1175, 587);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 1159, 20);
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(0, 538, 1159, 10);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane);
		}

		JLabel lbldeck = new JLabel(Card.Backcard);                                                             // we put a label where our deck is going to be
		lbldeck.setText("");
		lbldeck.setBounds(10, 160, 115, 169);
		getContentPane().add(lbldeck);

		JLabel lblPlayervalue = new JLabel("Hand Value: " + playervalue);                                      // we create a label where we are going to set
																			                                   // the Hand value for the player.
		lblPlayervalue.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPlayervalue.setBounds(852, 471, 169, 14);
		getContentPane().add(lblPlayervalue);

		JLabel lbldealervalue = new JLabel("Hand Value: " + dealervalue);                                      // we create a label where we are going to set
																			                                   // the Hand value for the dealer.
		lbldealervalue.setFont(new Font("Tahoma", Font.BOLD, 16));
		lbldealervalue.setBounds(852, 90, 154, 14);
		getContentPane().add(lbldealervalue);

		JLabel lblplayercard1 = new JLabel(Card.Backcard);
		lblplayercard1.setBounds(656, 358, 115, 169);                                                           // Here we set all our labels for the cards
		getContentPane().add(lblplayercard1);                                                                   //with the back card icon

		JLabel lblplayercard2 = new JLabel(Card.Backcard);
		lblplayercard2.setBounds(531, 358, 115, 169);
		getContentPane().add(lblplayercard2);

		JLabel lblplayercard3 = new JLabel(Card.Backcard);
		lblplayercard3.setBounds(406, 358, 115, 169);
		getContentPane().add(lblplayercard3);

		JLabel lblplayercard4 = new JLabel(Card.Backcard);
		lblplayercard4.setBounds(281, 358, 115, 169);
		getContentPane().add(lblplayercard4);

		JLabel lblplayercard5 = new JLabel(Card.Backcard);
		lblplayercard5.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblplayercard5.setBounds(156, 358, 115, 169);
		getContentPane().add(lblplayercard5);

		JLabel lblNewLabel_3 = new JLabel("Player's Wallet :");                                       // we set a label which is going to show the text
																                                      // "player's waller"
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_3.setBounds(852, 409, 140, 39);
		getContentPane().add(lblNewLabel_3);

		JLabel lbldealerwallet = new JLabel("Dealer's Wallet: ");                                      // we set a label which is going to show the text
																	                                   // "dealer's waller"
		lbldealerwallet.setFont(new Font("Tahoma", Font.BOLD, 16));
		lbldealerwallet.setBounds(852, 65, 140, 14);
		getContentPane().add(lbldealerwallet);

		JLabel lbldealercard1 = new JLabel(Card.Backcard);                                             // we create all the labels for the dealer's cards
		lbldealercard1.setBounds(156, 31, 115, 169);
		getContentPane().add(lbldealercard1);

		JLabel lbldealercard2 = new JLabel(Card.Backcard);
		lbldealercard2.setBounds(281, 31, 115, 169);
		getContentPane().add(lbldealercard2);

		JLabel lbldealercard3 = new JLabel(Card.Backcard);
		lbldealercard3.setBounds(406, 31, 115, 169);
		getContentPane().add(lbldealercard3);

		JLabel lbldealercard4 = new JLabel(Card.Backcard);
		lbldealercard4.setBounds(531, 31, 115, 169);
		getContentPane().add(lbldealercard4);

		JLabel lbldealercard5 = new JLabel(Card.Backcard);
		lbldealercard5.setBounds(656, 31, 115, 169);
		getContentPane().add(lbldealercard5);

		JLabel lblgamemoney = new JLabel("Game Money : ");                                          // we create a label which is going to show the text "Game
															                                        // money"
		lblgamemoney.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblgamemoney.setBounds(156, 277, 154, 14);
		getContentPane().add(lblgamemoney);

		JLabel lblplayermoney = new JLabel("$" + playermoney);                                      // we set a new label which is going to show the player's
																                                    // money

		lblplayermoney.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblplayermoney.setBounds(1002, 421, 65, 14);
		getContentPane().add(lblplayermoney);

		JLabel lbldealermoney = new JLabel("$" + dealermoney);                                      // we set a new label which is going to show the
																                                    // dealeer's money
		lbldealermoney.setFont(new Font("Tahoma", Font.BOLD, 16));
		lbldealermoney.setBounds(1002, 65, 65, 14);
		getContentPane().add(lbldealermoney);

		JLabel lbltotalmoney = new JLabel("$0");
		lbltotalmoney.setFont(new Font("Tahoma", Font.BOLD, 16));
		lbltotalmoney.setBounds(276, 276, 56, 20);
		getContentPane().add(lbltotalmoney);

		btnplay = new JButton("NewHand");                                                           //we create a new button called new hand 
		btnplay.setEnabled(false);                                                                  //which is going to draw cards
		btnplay.addActionListener(new ActionListener() {                                            // to the player and dealer
			public void actionPerformed(ActionEvent e) {
				btnhit.setEnabled(true);
				btnstay.setEnabled(true);
				btnplay.setEnabled(false);
				shuffledeck = playerDeck.shuffleArray(playerDeck);
				playervalue = 0;
				dealervalue = 0;
				button = 0;
				PcardNumber = shuffledeck.getCards()[0].getCardImage();                         //we set an image to the players cards and
				lblplayercard5.setIcon(PcardNumber);
				pcardValue = shuffledeck.Cards[0].getValue();                                  // we get the value of that card and add to the player
																
				playervalue += pcardValue; 

				PcardNumber = shuffledeck.getCards()[1].getCardImage();
				lblplayercard4.setIcon(PcardNumber);
				pcardValue = shuffledeck.Cards[1].getValue();
				playervalue += pcardValue;
				lblPlayervalue.setText(String.valueOf("Hand value: " + playervalue));

				lblplayercard3.setIcon(Card.Backcard);
				lblplayercard2.setIcon(Card.Backcard);
				lblplayercard1.setIcon(Card.Backcard);

				DcardNumber = shuffledeck.getCards()[5].getCardImage();
				lbldealercard1.setIcon(DcardNumber);
				dcardValue = shuffledeck.Cards[5].getValue();
				dealervalue += dcardValue;

				DcardNumber = shuffledeck.getCards()[6].getCardImage();
				lbldealercard2.setIcon(DcardNumber);
				dcardValue = shuffledeck.Cards[6].getValue();
				dealervalue += dcardValue;
				lbldealervalue.setText(String.valueOf("Hand value: " + dealervalue));

				lbldealercard3.setIcon(Card.Backcard);
				lbldealercard4.setIcon(Card.Backcard);
				lbldealercard5.setIcon(Card.Backcard);

			}
		});

		btnhit = new JButton("HIT");                                                 // we create a new button called "Hit" which is going to show one random card to
										                                             //to the player every time the "HIT" button is pushed.
		btnhit.setEnabled(false);
		btnhit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				button++;                                                           // we called a variable that will allow us to do a different
							                                                        // actions each time the button is pressed.
				switch (button) {
				case 1:                                                             //action 1
					PcardNumber = shuffledeck.getCards()[2].getCardImage();
					lblplayercard3.setIcon(PcardNumber);
					pcardValue = shuffledeck.Cards[2].getValue();
					playervalue += pcardValue;
					lblPlayervalue.setText(String.valueOf("Hand value: " + playervalue));

					if (playervalue > 21) {                                            //if the player value is more than 21 automatically the player loses the game
						JOptionPane.showMessageDialog(null, "You lose");
						lbldealermoney.setText("$" + String.valueOf(dealermoney += gamemoney));  
						lbltotalmoney.setText(String.valueOf(gamemoney = 0));
						lbltotalmoney.setText("");
						btnplay.setEnabled(true);                                       //we enable the new hand button to play a new hand
						btnhit.setEnabled(false);
						btnstay.setEnabled(false);
					}

					break;

				case 2:                                                                    //action 2 
					PcardNumber = shuffledeck.getCards()[3].getCardImage();
					lblplayercard2.setIcon(PcardNumber);
					pcardValue = shuffledeck.Cards[3].getValue();
					playervalue += pcardValue;
					lblPlayervalue.setText(String.valueOf("Hand value: " + playervalue));
					if (playervalue > 21) {
						JOptionPane.showMessageDialog(null, "You lose");
						lbldealermoney.setText("$" + String.valueOf(dealermoney += gamemoney));
						lbltotalmoney.setText(String.valueOf(gamemoney = 0));
						lbltotalmoney.setText("");
						btnplay.setEnabled(true);
						btnhit.setEnabled(false);
						btnstay.setEnabled(false);
					}

					break;

				case 3:                                                                     //action 3 
					PcardNumber = shuffledeck.getCards()[4].getCardImage();
					lblplayercard1.setIcon(PcardNumber);
					pcardValue = shuffledeck.Cards[4].getValue();
					playervalue += pcardValue;
					lblPlayervalue.setText(String.valueOf("Hand value: " + playervalue));
					if (playervalue > 21) {
						JOptionPane.showMessageDialog(null, "You lose");
						lbldealermoney.setText("$" + String.valueOf(dealermoney += gamemoney));
						lbltotalmoney.setText(String.valueOf(gamemoney = 0));
						lbltotalmoney.setText("");
						btnplay.setEnabled(true);
						btnhit.setEnabled(false);
						btnstay.setEnabled(false);
					}

					break;
				}

			}

		}

		);

		btnstay = new JButton("STAND");                                                        // we create a new button called stand
		btnstay.setEnabled(false);                                                             // Which will make the player unable to
		btnstay.addActionListener(new ActionListener() {                                       // receive cards until the dealer draws his cards.
			public void actionPerformed(ActionEvent e) {
				
				if (dealervalue > playervalue) {                                               //if the first 2 cards values are grater than the player value 
					JOptionPane.showMessageDialog(null, "The dealer has won");                // the dealer wins the game 
					lbldealermoney.setText("$" + String.valueOf(dealermoney += gamemoney));
					lbltotalmoney.setText(String.valueOf(gamemoney = 0));
					lbltotalmoney.setText("");
					return;
				}

				DcardNumber = shuffledeck.getCards()[7].getCardImage();                                   //we draw the cards for the dealer
				lbldealercard3.setIcon(DcardNumber);
				dcardValue = shuffledeck.Cards[7].getValue();
				dealervalue += dcardValue;
				lbldealervalue.setText(String.valueOf(dealervalue));
				JOptionPane.showMessageDialog(null, "The Dealer's hand's value is: " + dealervalue);
				if (dealervalue > 21) {                                                                  //if the dealer value is grater than 21 the dealer 
					JOptionPane.showMessageDialog(null, "You win");                                      // loses the game
					lblplayermoney.setText("$" + String.valueOf(playermoney += gamemoney));
					lbltotalmoney.setText("");
					btnplay.setEnabled(true);
					btnhit.setEnabled(false);
					btnstay.setEnabled(false);
					return;
				} else {
					if (dealervalue > playervalue) {                                                    //if the dealer value is grater than the player value 
						JOptionPane.showMessageDialog(null, "The dealer has won");                      // the dealer wins the game
						lbldealermoney.setText("$" + String.valueOf(dealermoney += gamemoney));
						lbltotalmoney.setText(String.valueOf(gamemoney = 0));
						lbltotalmoney.setText("");
						btnplay.setEnabled(true);
						btnhit.setEnabled(false);
						btnstay.setEnabled(false);
						return;
					}

					if (playervalue == dealervalue) {                                                  //if the dealer and player values are the same then it is a push 
						JOptionPane.showMessageDialog(null, "Push");
						lblplayermoney.setText("$" + String.valueOf(playermoney += gamemoney / 2));
						lbldealermoney.setText("$" + String.valueOf(dealermoney += gamemoney / 2));
						lbltotalmoney.setText(String.valueOf(gamemoney = 0));
						btnplay.setEnabled(true);
						btnhit.setEnabled(false);
						btnstay.setEnabled(false);
						return;
					}

				}

				DcardNumber = shuffledeck.getCards()[8].getCardImage();                                    //we do the same here
				lbldealercard4.setIcon(DcardNumber);
				dcardValue = shuffledeck.Cards[8].getValue();
				dealervalue += dcardValue;
				lbldealervalue.setText(String.valueOf(dealervalue));
				JOptionPane.showMessageDialog(null, "The Dealer's hand's value is: " + dealervalue);
				if (dealervalue > 21) {
					JOptionPane.showMessageDialog(null, "You win");
					lblplayermoney.setText("$" + String.valueOf(playermoney += gamemoney));
					lbltotalmoney.setText("");
					btnplay.setEnabled(true);
					btnhit.setEnabled(false);
					btnstay.setEnabled(false);
					return;
				} else {
					if (dealervalue > playervalue) {
						JOptionPane.showMessageDialog(null, "The dealer has won");
						lbldealermoney.setText("$" + String.valueOf(dealermoney += gamemoney));
						lbltotalmoney.setText(String.valueOf(gamemoney = 0));
						lbltotalmoney.setText("");
						btnplay.setEnabled(true);
						btnhit.setEnabled(false);
						btnstay.setEnabled(false);
						return;
					}

					if (playervalue == dealervalue) {
						JOptionPane.showMessageDialog(null, "Push");
						lblplayermoney.setText("$" + String.valueOf(playermoney += gamemoney / 2));
						lbldealermoney.setText("$" + String.valueOf(dealermoney += gamemoney / 2));
						lbltotalmoney.setText(String.valueOf(gamemoney = 0));
						btnplay.setEnabled(true);
						btnhit.setEnabled(false);
						btnstay.setEnabled(false);
						return;
					}

				}

				DcardNumber = shuffledeck.getCards()[9].getCardImage();                                        //we do the same here
				lbldealercard5.setIcon(DcardNumber);
				dcardValue = shuffledeck.Cards[9].getValue();
				dealervalue += dcardValue;
				lbldealervalue.setText(String.valueOf(dealervalue));
				JOptionPane.showMessageDialog(null, "The Dealer's hand's value is: " + dealervalue);
				if (dealervalue > 21) {
					JOptionPane.showMessageDialog(null, "You win");
					lblplayermoney.setText("$" + String.valueOf(playermoney += gamemoney));
					lbltotalmoney.setText("");
					btnplay.setEnabled(true);
					btnhit.setEnabled(false);
					btnstay.setEnabled(false);
					return;
				} else {
					if (dealervalue > playervalue) {
						JOptionPane.showMessageDialog(null, "The dealer has won");
						lbldealermoney.setText("$" + String.valueOf(dealermoney += gamemoney));
						lbltotalmoney.setText(String.valueOf(gamemoney = 0));
						lbltotalmoney.setText("");
						btnplay.setEnabled(true);
						btnhit.setEnabled(false);
						btnstay.setEnabled(false);
						return;
					}

					if (playervalue == dealervalue) {
						JOptionPane.showMessageDialog(null, "Push");
						lblplayermoney.setText("$" + String.valueOf(playermoney += gamemoney / 2));
						lbldealermoney.setText("$" + String.valueOf(dealermoney += gamemoney / 2));
						lbltotalmoney.setText(String.valueOf(gamemoney = 0));
						btnplay.setEnabled(true);
						btnhit.setEnabled(false);
						btnstay.setEnabled(false);
						return;
					}
					if (playervalue > dealervalue) {
						JOptionPane.showMessageDialog(null, "You win");
						lblplayermoney.setText("$" + String.valueOf(playermoney += gamemoney));
						lbltotalmoney.setText("");
						btnplay.setEnabled(true);
						btnhit.setEnabled(false);
						btnstay.setEnabled(false);
						return;
					}

				}

				btnstay.setEnabled(false);
			}
		});

		btnbet = new JButton("BET");                                                                            // we create a new button where each
		btnbet.addActionListener(new ActionListener() {                                                         // time the button is pressed the player
			public void actionPerformed(ActionEvent e) {
				btnplay.setEnabled(true);

				lblplayermoney.setText("$" + String.valueOf(playermoney -= playerbet));
				lbldealermoney.setText("$" + String.valueOf(dealermoney -= dealerbet));
				if (playermoney < playerbet) {
					JOptionPane.showMessageDialog(null, "You do not have enough money, please leave");                //if the player does not have more money, he leaves.
																										               //and the dealer wins the game.
																										 
				}
				if (dealermoney < dealerbet) {
					JOptionPane.showMessageDialog(null, "The Dealer has not more money, You Win!!, please leave");    //if the dealer  does not have more money,the player wins.
					btnbet.setEnabled(false);																								
				}

				lbltotalmoney.setText("$" + String.valueOf(gamemoney += playerbet + dealerbet));                       //here we add to the game money the bet form the player and 
                                                                                                                       //dealer
			}
		});
		btnstay.setBounds(1026, 327, 89, 23);
		getContentPane().add(btnstay);

		btnhit.setBounds(1026, 275, 89, 23);
		getContentPane().add(btnhit);

		btnbet.setBounds(1026, 228, 89, 23);
		getContentPane().add(btnbet);

		btnplay.setBounds(1026, 160, 89, 23);
		getContentPane().add(btnplay);

	}

}
