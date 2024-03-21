package CALab;

import MVC.*;
import MVC.tools.*;

import javax.swing.*;
public class ClearCommand extends Command {
    Model model;
    public ClearCommand(Model model){
        super(model);
    }
    public void execute() {
        Grid grid = (Grid)model;
        //
    }
}
