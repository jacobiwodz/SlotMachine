//Authors: Jacob Wodziak and Joel Puca
public class SlotMachineMain {

	public static void main(String[] args) {
		SlotMachineView view = new SlotMachineView();
		SlotMachineView startView = new SlotMachineView(true);
		SlotMachineModel model = new SlotMachineModel();
		SlotMachineController main = new SlotMachineController(view, startView, model);
	}

}
