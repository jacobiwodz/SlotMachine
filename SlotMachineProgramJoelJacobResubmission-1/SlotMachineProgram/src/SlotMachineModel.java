//Authors: Jacob Wodziak and Joel Puca
import java.text.DecimalFormat;

public class SlotMachineModel {
    String[] images = {"cherry.jpg", "grape.jpg", "lemon.jpg", "bell.jpg", "bar.jpg", "seven.jpg"};
    DecimalFormat df = new DecimalFormat("0.00");
    
    
    public SlotMachineModel()
    {
        
    }
//returns the image from the array at the given index
    public String getImageIndex(int index)
    {
        return images[index];
    }
    //methods to subtract from and add to the balance respectively 
    public double minusBalance(double balance, double update)
    {
    	balance -= update;
    	return balance;
    }
    
    public double plusBalance(double balance, double update)
    {
    	balance += update;
    	return balance;
    }
}
