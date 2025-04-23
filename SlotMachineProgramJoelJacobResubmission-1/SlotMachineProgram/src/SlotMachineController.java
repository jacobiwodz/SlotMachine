//Authors: Jacob Wodziak and Joel Puca
import java.awt.event.*;
import java.text.DecimalFormat;

import javax.swing.*;

import java.awt.*;

public class SlotMachineController {

	//variables and a decomal format object 
    SlotMachineView view;
    SlotMachineModel model;
    SlotMachineView startView;
    private boolean empty = true;
    private boolean secondSpin = false;
    private boolean valBet = false;
    private double startingBal, currentBet;
    boolean startBet = true;
    DecimalFormat df = new DecimalFormat("0.00");


//constructor that takes in a view, model, and starting window object
    public SlotMachineController(SlotMachineView view, SlotMachineView startView, SlotMachineModel model)
    {
        this.view = view;
        this.model = model;
        this.startView = startView;
        ImageIcon tempImage = new ImageIcon();
        //Buttons apply handlers
        view.getSpinButton().addActionListener(new ButtonHandler());
        startView.getBalEnter().addActionListener(new StartTextListener());
        view.getPayTableButton().addActionListener(new WinTableListener());
        //JTextfields apply handlers
    }

    //Handler for the spin button. User spins the wheel and the program checks to see if their bet is valid
    //then spins and calls validate wheel to see if they won
    class ButtonHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) 
        {
            //Timer
            view.getSpinButton().setEnabled(false);
            int interval1, interval2, interval3, interval4, interval5, interval6;
            interval1 = 20;
            interval2 = 30;
            interval3 = 40;
            interval4 = 43;
            interval5 = 46;
            interval6 = 49;
                Wheel wheel = new Wheel();
                Timer timer1 = new Timer(60, new ButtonHandler() {
                int count = 0;
                public void actionPerformed(ActionEvent e) { 
                //first column
                view.getLabelIndex(10).setIcon(view.getIconIndex(5));
                view.getLabelIndex(5).setIcon(view.getIconIndex(0));
                view.getLabelIndex(0).setIcon(new ImageIcon(wheel.SpinWheel()));
                count++;
                if (count > interval1)
                ((Timer)e.getSource()).setDelay(100);
                if (count > interval2)
                ((Timer)e.getSource()).setDelay(150);
                if (count > interval3)
                ((Timer)e.getSource()).setDelay(250);
                if (count > interval4)
                ((Timer)e.getSource()).setDelay(350);
                if (count > interval5)
                ((Timer)e.getSource()).setDelay(400);
                if (count > interval6)
                ((Timer)e.getSource()).stop();
            }
            });
                Timer timer2 = new Timer(60, new ButtonHandler() {
                int count = 0;
                public void actionPerformed(ActionEvent e) { 
                //second column
                view.getLabelIndex(11).setIcon(view.getIconIndex(6));
                view.getLabelIndex(6).setIcon(view.getIconIndex(1));
                view.getLabelIndex(1).setIcon(new ImageIcon(wheel.SpinWheel()));
                count++;
                if (count > interval1 + 5)
                ((Timer)e.getSource()).setDelay(100);
                if (count > interval2 + 5)
                ((Timer)e.getSource()).setDelay(150);
                if (count > interval3 + 5)
                ((Timer)e.getSource()).setDelay(250);
                if (count > interval4 + 5)
                ((Timer)e.getSource()).setDelay(350);
                if (count > interval5 + 5)
                ((Timer)e.getSource()).setDelay(400);
                if (count > interval6 + 6)
                ((Timer)e.getSource()).stop();
            }
            });
            Timer timer3 = new Timer(60, new ButtonHandler() {
                int count = 0;
                public void actionPerformed(ActionEvent e) { 
                //third column
                view.getLabelIndex(12).setIcon(view.getIconIndex(7));
                view.getLabelIndex(7).setIcon(view.getIconIndex(2));
                view.getLabelIndex(2).setIcon(new ImageIcon(wheel.SpinWheel()));
                count++;
                if (count > interval1 + 10)
                ((Timer)e.getSource()).setDelay(100);
                if (count > interval2 + 10)
                ((Timer)e.getSource()).setDelay(150);
                if (count > interval3 + 10)
                ((Timer)e.getSource()).setDelay(250);
                if (count > interval4 + 10)
                ((Timer)e.getSource()).setDelay(350);
                if (count > interval5 + 10)
                ((Timer)e.getSource()).setDelay(400);
                if (count > interval6 + 12)
                ((Timer)e.getSource()).stop();
            }
            });
            Timer timer4 = new Timer(60, new ButtonHandler() {
                int count = 0;
                public void actionPerformed(ActionEvent e) { 
                //fourth column
                view.getLabelIndex(13).setIcon(view.getIconIndex(8));
                view.getLabelIndex(8).setIcon(view.getIconIndex(3));
                view.getLabelIndex(3).setIcon(new ImageIcon(wheel.SpinWheel()));
                count++;
                if (count > interval1 + 15)
                ((Timer)e.getSource()).setDelay(100);
                if (count > interval2 + 15)
                ((Timer)e.getSource()).setDelay(150);
                if (count > interval3 + 15)
                ((Timer)e.getSource()).setDelay(250);
                if (count > interval4 + 15)
                ((Timer)e.getSource()).setDelay(350);
                if (count > interval5 + 15)
                ((Timer)e.getSource()).setDelay(400);
                if (count > interval6 + 18)
                ((Timer)e.getSource()).stop();
            }
            });
            Timer timer5 = new Timer(60, new ButtonHandler() {
                int count = 0;
                public void actionPerformed(ActionEvent e) { 
                //firth column
                view.getLabelIndex(14).setIcon(view.getIconIndex(9));
                view.getLabelIndex(9).setIcon(view.getIconIndex(4));
                view.getLabelIndex(4).setIcon(new ImageIcon(wheel.SpinWheel()));
                count++;
                if (count > interval1 + 20)
                ((Timer)e.getSource()).setDelay(100);
                if (count > interval2 + 20)
                ((Timer)e.getSource()).setDelay(150);
                if (count > interval3 + 20)
                ((Timer)e.getSource()).setDelay(250);
                if (count > interval4 + 20)
                ((Timer)e.getSource()).setDelay(350);
                if (count > interval5 + 20)
                ((Timer)e.getSource()).setDelay(400);
                if (count > interval6 + 24){
                ((Timer)e.getSource()).stop();

                //validaiton updates after the last "Wheel" has spun
                view.getSpinButton().setEnabled(true);
                balanceUpdate();
                view.getWinNum().setText("$" +String.valueOf(df.format(ValidateWheel())));
                }
            }
            });
            if (validateBet() == true){
            if(view.getBet().getText().isBlank() == false || empty == false)
            {
            empty = false;
            
            if(secondSpin == false)
            {
            view.getCurrentBet().setText(" Current bet: $" + df.format(Double.parseDouble(view.getBet().getText())));
            }
            if(secondSpin == true && view.getBet().getText().isEmpty() == false)
            {
            	betUpdate();
            }
            view.getBet().setText("");
            view.getBetText().setText("Enter a bet amount");

            //subtracts bet from balance
            betPreSpin();
            //spins wheels
            view.getWinNum().setText("");
            timer1.start();
            timer2.start();
            timer3.start();
            timer4.start();
            timer5.start();      
            }
            }
        }
    }
      
    //Listener for the starting window where users input their starting balance. Checks to make sure that the
    //input is a number, isn't blank, and is higher than the minimum bid of 25 cents
    public class StartTextListener implements ActionListener
    {
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			
			if (startView.getStartBal().getText().isBlank() || isNum(startView.getStartBal().getText()) == false)
			{
				startView.getStartErr().setText("Please enter a valid number");
			}
			
			if( isNum(startView.getStartBal().getText()) == true 
					&& validateBalance(Double.parseDouble(startView.getStartBal().getText())) == false)
			{
				startView.getStartErr().setText("Initial balance must be greater than 25 cents");
			}
			
              if(isNum(startView.getStartBal().getText()) == true 
            		  && validateBalance(Double.parseDouble(startView.getStartBal().getText())) == true)
                {
            	startingBal = Double.parseDouble(startView.getStartBal().getText());
				view.getBalanceAmount().setText(df.format(startingBal));
				
				view.getSpinButton().setEnabled(true);
                startView.setVisible(false);
                }
		}
		}
    
    //lister for the button that shows the pay table
    public class WinTableListener implements ActionListener
    {

		@Override
		public void actionPerformed(ActionEvent e) 
		{
			WinTable t = new WinTable();
			
		}
    	
    }
    	
    
    //method to see if a string is a number or not
    public boolean isNum(String num)
    {
    
    	try 
    	{
    		double d = Double.parseDouble(num);
    	}
    	catch(NumberFormatException nfe)
    	{
    		
    		return false;
    	}
    	
    	return true;
    	
    }

//this method looks at the wheel that was spun, and sees if there's any matches. distributes the winnings based on its results
    public double ValidateWheel()
    {
        double winnings = 0.0;
        int [] matches = new int[6];
        double [] matchBetMult = {3, 3.5, 5, 8, 11, 21};
        double betMult = 0;

        for (int i= 0; i <= 4; i++)
        {
            for(int j = 0; j <=5; j++){
            if (String.valueOf(view.getLabelIndex(i + 5).getIcon()).equalsIgnoreCase(model.getImageIndex(j)))
            {
            matches[j]++;
            }
            
            }
        }

        for (int i= 0; i < 4; i++)
        {
            if(matches[i] == 5)
            {
                winnings = Double.parseDouble(view.getCurrentBet().getText().replaceAll("[\\D]", "")) * matchBetMult[i];
                betMult = 2;
            }
            else if (matches[i] == 4)
            {
                winnings = Double.parseDouble(view.getCurrentBet().getText().replaceAll("[\\D]", "")) * matchBetMult[i];
                betMult = 1.5;
            }
            else if (matches[i] == 3)
            {
                winnings = Double.parseDouble(view.getCurrentBet().getText().replaceAll("[\\D]", "")) * matchBetMult[i];
                betMult = 1;
            }
        }
    //error  
    double finalWinnings = (winnings * betMult) / 100;
   
    return finalWinnings;
    }

    //takes the users bet and checks if it meets the same scrutiny as before
    public boolean validateBet()
    {
        valBet = true;
       
        boolean letter = false;
    	//checks if its actually numbers
        if(view.getBet().getText().isEmpty() == false && isNum(view.getBet().getText()) == false)
        {
        	view.getBetText().setText("Please enter a valid bet");
        	view.getSpinButton().setEnabled(true);
            valBet = false;
            letter = true;
        }
        
        
            //checks if the textfield is empty
            if((view.getBet().getText().isEmpty() && empty == true))
            {
            	
            	view.getBetText().setText("Please enter a valid bet");
            	view.getSpinButton().setEnabled(true);
                valBet = false;

            }
            //checks if the bet is higher than 25 cents
        if ((letter == false && secondSpin == false && view.getBet().getText().isEmpty() == false) ) 
        {
        	if(Double.parseDouble(view.getBet().getText()) < .25)
        	{
        view.getBetText().setText("Minimum bet: $.25");
        valBet = false;
        view.getSpinButton().setEnabled(true);
        secondSpin = false;
        	}
        
        }

        if(view.getBet().getText().isEmpty() == false && letter == false)
        {
        	if(Double.parseDouble(view.getBet().getText()) < .25)
        	{
        		view.getBetText().setText("Minimum bet: $.25");
                valBet = false;
                view.getSpinButton().setEnabled(true);
                secondSpin = false;
        	}
        }
        //checks if the bet is higher than the user's remaining money
        if(view.getBet().getText().isEmpty() == false && letter == false &&
        		Double.parseDouble(view.getBet().getText()) > Double.parseDouble(view.getBalanceAmount().getText()))
        {
        	view.getBetText().setText("Bet exceeds balance");
        	view.getSpinButton().setEnabled(true);
        	valBet = false;
        }

        
        if(currentBet > Double.parseDouble(view.getBalanceAmount().getText()))
        {
        	if(view.getBet().getText().isBlank() == false 
        			&& Double.parseDouble(view.getBet().getText()) <= Double.parseDouble(view.getBalanceAmount().getText())) 
        	{
        		valBet = true;
        	}
        	else {
        	view.getBetText().setText("Bet exceeds balance");
        	view.getSpinButton().setEnabled(true);
        	valBet = false;
        	}
        }
        //tells the user they can no longer play since they've ran out of funds. Shows game over screen
        if(view.getBet().getText().isEmpty() == false && letter == false &&
        		Double.parseDouble(view.getBalanceAmount().getText()) < .25)
        {
        	view.getCurrentBet().setText("insufficient funds");
        	view.getBalanceAmount().setText("");
        	view.getSpinButton().setEnabled(false);
        	view.getBalance().setText("insufficient funds");
        	WinTable gameOver = new WinTable(true);
        	gameOver.getGameOverAmount().setText("Congrats! You managed to lose your "
        			+ "starting balance of $" + df.format(startingBal) + " dollars. ");
        	valBet = false;
        }

            secondSpin = true;
            startBet = false;
        return valBet;
    }
//updates balance with the results from validate wheel
    public void balanceUpdate()
    {
    	
        double updatedBalance = 0;
        updatedBalance = model.plusBalance(Double.parseDouble(view.getBalanceAmount().getText()), ValidateWheel());
        
        
        view.getBalanceAmount().setText(df.format(Double.parseDouble(String.valueOf(updatedBalance))));
    }
//takes away the users bet from their balance while the wheel is spinning
    public void betPreSpin()
    {
    	double preSpinUpdate = model.minusBalance(Double.parseDouble(view.getBalanceAmount().getText()), 
        		Double.parseDouble((view.getCurrentBet().getText().replaceAll("[\\D]", "" )))/100);
        view.getBalanceAmount().setText(String.valueOf(df.format(preSpinUpdate)));
        
        
    }
//updates the current amount the user is betting 
    public void betUpdate()
    {
    	currentBet = Double.parseDouble(view.getBet().getText());
        view.getCurrentBet().setText("Current Bet: $" + df.format(currentBet));
    }
//checks if the number is higher than the minimum bid
    public boolean validateBalance(double num)
    {
    	if(num < .25)
    	{
    		return false;
    	}
    	else
    	{
    		return true;
    	}
    }

}


    


