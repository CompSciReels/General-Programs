import java.io.*;

import java.awt.*;
import java.awt.event.*;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Client extends JFrame implements ActionListener
{
	Label ques1 = new Label("Number Correct:");
	Label ques2 = new Label("The High Score:");
	
	TextField ans1 = new TextField(6);
	TextField ans2 = new TextField(25);
	TextField ans3 = new TextField(6);
	
	Button higher = new Button("Higher");
	Button lower = new Button("Lower");
	Button newGame = new Button("New Game");
	
	JLabel picLabel;
	Icon picIcon;
	
	Container containerName;

	int wins = 0;
	int highScore = 0;
	
	Deck deck = new Deck();
	Card card = new Card();
	Card temp;

	public Client()
	{
		setLayout(new FlowLayout());
		
		setSize(255, 300);
		
		setTitle("Visual High Low");

		setIconImage(new ImageIcon("file (5).png").getImage());
		
		picIcon = new ImageIcon("file (5).png");
		picLabel = new JLabel(picIcon);
		add(picLabel);
		
		containerName = getContentPane();
		
		containerName.setBackground(Color.GREEN); 
		
		add(higher);
		add(lower);
		
		add(ans2);
		
		add(ques2);
		add(ans3);
		ans3.setEditable(false);
		
		add(ques1);
		add(ans1);
		
		add(newGame);
		
		higher.setActionCommand("higher1");
		higher.addActionListener(this);
		
		lower.setActionCommand("lower1");
		lower.addActionListener(this);		
		
		newGame.setActionCommand("newGame1");
		newGame.addActionListener(this);
		
		higher.disable();
		lower.disable();
		
		  try (BufferedReader inFile = new BufferedReader(new FileReader("highScore.txt"))) 
		  {
	            String highScore1 = inFile.readLine();
	            
	            if (highScore1 != null) 
	            {
	                highScore = Integer.parseInt(highScore1);
	                ans3.setText("" + highScore);
	            }
	      } 
		  catch (IOException e1) 
		  {
			  System.out.println("Sorry! There was an error.");
	      } 
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if (e.getActionCommand().equals("newGame1"))
		{	
			wins = 0;
	
			ans2.setText("");
			
			newGame.disable();
			higher.enable();
			lower.enable();
			
			ans1.setText("0");	
			
			ans3.setText("" + highScore);
			
			deck.shuffle();
			card = deck.dealCard();
			
			picIcon = new ImageIcon(card.showValue() + " of " + card.getSuit() + ".gif");
			picLabel.setIcon(picIcon);
			
			System.out.print("\nThe first  card is the " + card.showValue() + " of " + card.getSuit() + ".");
		}
		else if (e.getActionCommand().equals("higher1"))
		{
			temp = card;//write this once!
			card = deck.dealCard();//write this once!
			
			picIcon = new ImageIcon(card.showValue() + " of " + card.getSuit() + ".gif");//write this once!
			picLabel.setIcon(picIcon);//write this once!
			
			System.out.print("\nThe next  card is the " + card.showValue() + " of " + card.getSuit() + "."); 
			
			if (card.getValue() > temp.getValue())
			{
				ans2.setText("Your prediction was correct!");
				wins+=1;
				
				ans1.setText("" + wins);
				
				if (wins > highScore)
				{
					highScore = wins;
				}
			}
			else if (card.getValue() < temp.getValue())
			{
				ans2.setText("Your prediction was incorrect.");
				
				newGame.enable();
				higher.disable();
				lower.disable();
				
				ans3.setText("" + highScore);

				try (PrintWriter outFile = new PrintWriter(new FileWriter("highScore.txt"))) 
				{
		            outFile.println(highScore);
		        } 
				catch (IOException e2) 
				{
					System.out.println("Sorry! There was an error.");
		        }
			}
			else 
			{
				ans2.setText("The card values are the same. Sorry, you lose!");
				
				newGame.enable();
				higher.disable();
				lower.disable();
				
				ans3.setText("" + highScore);

				try (PrintWriter outFile = new PrintWriter(new FileWriter("highScore.txt"))) 
				{
		            outFile.println(highScore);
		        } 
				catch (IOException e3) 
				{
		            System.out.println("Sorry! There was an error.");
		        }
			}
		}
		
		else 
		{
			temp = card;//write this once!
			card = deck.dealCard();//write this once!
			
			picIcon = new ImageIcon(card.showValue() + " of " + card.getSuit() + ".gif");//write this once! 
			picLabel.setIcon(picIcon);//write this once!
			
			System.out.print("\nThe next  card is the " + card.showValue() + " of " + card.getSuit() + "."); 
			
			if (temp.getValue() > card.getValue())
			{
				ans2.setText("Your prediction was correct!");
				wins+=1;
				
				ans1.setText("" + wins);
				
				if (wins > highScore)
				{
					highScore = wins;
				}
			}
			else if (card.getValue() > temp.getValue())
			{
				ans2.setText("Your prediction was incorrect.");
				
				newGame.enable();
				higher.disable();
				lower.disable();
				
				ans3.setText("" + highScore);
				
				try (PrintWriter outFile = new PrintWriter(new FileWriter("highScore.txt"))) 
				{
		            outFile.println(highScore);
		        } 
				catch (IOException e2) 
				{
		            System.out.println("Sorry! There was an error.");
		        }
			}
			else 
			{
				ans2.setText("The card values are the same. Sorry, you lose!");
				
				newGame.enable();
				higher.disable();
				lower.disable();
				
				ans3.setText("" + highScore);
				
				try (PrintWriter outFile = new PrintWriter(new FileWriter("highScore.txt"))) 
				{
		            outFile.println(highScore);
		        } 
				catch (IOException e2) 
				{
		            System.out.println("Sorry! There was an error.");
		        }
			}
		}
	}
	public static void main(String[] args) throws IOException
	{	
		Client window = new Client();
		window.show();		
	}
 }