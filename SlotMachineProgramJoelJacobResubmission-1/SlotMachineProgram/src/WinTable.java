//Authors: Jacob Wodziak and Joel Puca
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class WinTable extends JFrame
{
	private Container contents, gameOver ;
	private JLabel table, gameOverLabel, gOverAmount, gambleHotline;
	
	//window for displaying the pay table
	public WinTable()
	{
		//image sourced from https://www.888casino.com/blog/how-to-maximize-slot-payouts
		super("Pay Table");
		contents = getContentPane();
		contents.setLayout(new FlowLayout());
		table = new JLabel();
		table.setIcon(new ImageIcon("table.jpg"));
		contents.add(table);
		
		
		setSize(520,375);
		setVisible(true);
		
	}
	//window that is displayed when the user loses
	public WinTable(boolean vis)
		{
			super("Game Over");
			gameOver = getContentPane();
			gameOver.setLayout(new FlowLayout());
			Font font = new Font("TimesNewRoman", Font.BOLD, 40);
			Font smallFont = new Font("TimesNewRoman", Font.BOLD, 25);
			gameOverLabel = new JLabel("<HTML><U>Game Over</U></HTML>");
			gameOverLabel.setFont(font);
			gameOver.add(gameOverLabel);
			gOverAmount = new JLabel("");
			gOverAmount.setFont(smallFont);
			gameOver.add(gOverAmount);
			gambleHotline = new JLabel("If you have a gambling addiction you can call 1-800-GAMBLER for assistance");
			gambleHotline.setFont(smallFont);
			gameOver.add(gambleHotline);
					      				
			setSize(1050,250);
			setVisible(vis);
			
			
		}
	public JLabel getGameOverAmount()
	{
		return gOverAmount;
	}
	
}
