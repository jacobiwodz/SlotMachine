//Authors: Jacob Wodziak and Joel Puca
import javax.swing.border.Border;

import java.awt.*;
import java.io.FileInputStream;
import java.io.IOException;

import javax.swing.*;


import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class SlotMachineView extends JFrame
{
	private JLabel title, enterBal, startErr;
	private JButton spin, glossary, startEnter;
	private JTextField bet, startBal;
	private JPanel center;
	private Container contents, balContent;
	private JTable winTable;
	private JLabel s1,s2,s3,s4,s5,s6,s7,s8,s9,s10,s11,s12,s13,s14,s15, winAmt, balanceAmount, winNum, currentBet,text;
	private JLabel[] slotPics;
	private JTextArea balance;
	private boolean vis = true;
	//window that appears first to take in the user input
	public SlotMachineView(boolean setOff)
	{
		super("Enter your starting balance");
		
		balContent = getContentPane();
		balContent.setLayout(new FlowLayout());
		startBal = new JTextField();
		startBal.setColumns(10);
		balContent.add(startBal);
		enterBal = new JLabel("Enter your starting balance");
		balContent.add(enterBal);
		startEnter = new JButton("Enter");
		balContent.add(startEnter);
		startErr = new JLabel("");
		balContent.add(startErr);

		
		//vis = setOff;
		setSize(300,200);
		setVisible(vis);
		
	}
	//main window that contains the slot and various information about the ongoing game
	public SlotMachineView()
	{
		
		super("Slot Machine");
		
		contents = getContentPane();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contents.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		GridLayout grid = new GridLayout(3,5);
		Border slotBorder = BorderFactory.createLineBorder(Color.BLACK, 3);
		Border redBorder = BorderFactory.createLineBorder(Color.RED,5);
		gbc.weightx = 1;
		gbc.weighty = 1;
		gbc.anchor = GridBagConstraints.NORTHWEST;
		
		gbc.insets =  new Insets(10,10,10,10);
		
		
		center =  new JPanel();
		center.setLayout(grid);;
		
		balance = new JTextArea("Balance: $");
		balance.setEditable(false);
		balance.setBackground(getForeground());
		gbc.gridx = 0;
		gbc.gridy = 0;
		contents.add(balance, gbc);
		
		balanceAmount = new JLabel("");
		gbc.insets = new Insets(10,70,0,0);
		gbc.gridx = 0;
		gbc.gridy = 0;
		contents.add(balanceAmount,gbc);
		
		//Jlabels
		s1 = new JLabel(); s2 = new JLabel(); s3 = new JLabel(); s4 = new JLabel();
		s5 = new JLabel(); s6 = new JLabel(); s8 = new JLabel(); s7 = new JLabel();
		s9 = new JLabel(); s10 = new JLabel(); s11 = new JLabel();s12 = new JLabel();
		s13 = new JLabel();s14 = new JLabel();s15 = new JLabel();
		
		
		slotPics = new JLabel[] {s1,s2,s3,s4,s5,s6,s7,s8,s9,s10,s11,s12,s13,s14,s15};
		

		Wheel wheel = new Wheel();
		for(int i = 0; i < 15; i++)
		{
			slotPics[i].setIcon(new ImageIcon(wheel.SpinWheel()));
			slotPics[i].setBorder(slotBorder);
		}
		for(int i = 5; i < 10; i++)
		{
			slotPics[i].setBorder(redBorder);
		}
		
		slotPics[1].setBackground(Color.WHITE);
		slotPics[1].setForeground(Color.WHITE);

		for(int i = 0; i < 15; i++)
		{
			center.add(slotPics[i]);
		}

		
		
		center.setPreferredSize(new Dimension(1000,500));
		gbc.insets = new Insets(0,0,5,0);
		gbc.gridx = 5;
		gbc.gridy = 3;
		contents.add(center, gbc);
		
		spin = new JButton("Spin Wheel");
		//spin.setBounds(2,2,2,2); 
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.gridx = 5;
		gbc.gridy = 10;
		contents.add(spin,gbc);
		spin.setEnabled(false);
		
		gbc.anchor = GridBagConstraints.SOUTHEAST;
		winAmt = new JLabel("<HTML><U>Winnings</U></HTML>");
		
		gbc.gridx = 10;
		gbc.gridy = 10;
		contents.add(winAmt, gbc);
		
		gbc.insets = new Insets(0,0,10,0);
		winNum = new JLabel("");
		gbc.gridx = 10;
		gbc.gridy = 11;
		contents.add(winNum, gbc);
		
		//South west
		gbc.anchor = GridBagConstraints.SOUTHWEST;
		gbc.insets = new Insets(0,10,0,0);
		bet = new JTextField();
		bet.setColumns(13);
		gbc.gridx = 0;
		gbc.gridy = 10;
		contents.add(bet, gbc);
		
		//JtextField for bets
		gbc.insets = new Insets(0,10,10,0);
		text = new JLabel("Enter a bet amount");
		gbc.gridx = 0;
		gbc.gridy = 11;
		contents.add(text, gbc);
		
		gbc.insets = new Insets(0,10,0,0);
		currentBet = new JLabel("Current bet: $");
		gbc.gridx = 0;
		gbc.gridy = 9;
		contents.add(currentBet, gbc);
		
		//Payout table
		glossary = new JButton("Pay Table");
		gbc.anchor = GridBagConstraints.NORTHEAST;
		gbc.gridx = 10;
		gbc.gridy = 0;
		contents.add(glossary,gbc);
		
		
		
		//setMinimumSize(new Dimension(1300, 800));
		pack();
		setVisible(true);

		
	}
	

	

	
	

	//Getters
	public JLabel[] getSlots()
	{
		return slotPics;
	}

	public JLabel getSlotIndex(int index)
	{
		return slotPics[index];
	}

	public JButton getSpinButton()
	{
		return spin;
	}
	
	public JTextField getStartBal()
	{
		return startBal;
	}
	public JLabel getStartErr()
	{
		return startErr;
	}
	public JTextArea getBalance()
	{
		return balance;
	}
	public Container getStartWind()
	{
		return balContent;
	}
	public JButton getBalEnter()
	{
		return startEnter;
	}
	
	
	public void setVis(boolean off)
	{
		this.vis = off;
	}

	public JLabel getLabelIndex(int index)
	{
		return slotPics[index];
	}

	public Icon getIconIndex(int index)
	{
		return slotPics[index].getIcon();
	}
	public JLabel getBalanceAmount()
	{
		return balanceAmount;
	}

	public JTextField getBet() {
		return bet;
	}
	
	public JButton getPayTableButton()
	{
		return glossary;
	}

	public JLabel getCurrentBet()
	{
		return currentBet;
	}
	
	public JLabel getWinNum()
	{
		return winNum;
	}
	
	public JLabel getBetText()
	{
		return text;
	}
	
	
}
