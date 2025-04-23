//Authors: Jacob Wodziak and Joel Puca
import java.lang.runtime.SwitchBootstraps;
import java.util.*;


public class Wheel
{   
    //Objects
    Random rand = new Random();
    SlotMachineModel model = new SlotMachineModel();
    
    //default
    public Wheel(){}

    //Spins wheel
    public String SpinWheel()
    {
        
        String result = null;

        int intResult = rand.nextInt(99);
        
        if (intResult >= 0 && intResult <= 29)
            result = model.getImageIndex(0);
        else if (intResult >= 30 && intResult <=49)
            result = model.getImageIndex(1);
        else if (intResult >= 50 && intResult <=69)
            result = model.getImageIndex(2);
        else if (intResult >= 70 && intResult <=84)
            result = model.getImageIndex(3);
        else if(intResult >= 85 && intResult <= 94)
            result = model.getImageIndex(4);
        else if(intResult >= 95 && intResult <=99)
            result = model.getImageIndex(5);

        return result;
        
        
    }
}
