package MVC;

import MVC.tools.*;

public class RunCommand extends Command {
    private int times;
    public RunCommand(Model model, int times){
        super(model);
        this.times = times;
    }
    @Override
    public void execute() {
        for(int i = 0; i < times; i++){

        }
    }
}
