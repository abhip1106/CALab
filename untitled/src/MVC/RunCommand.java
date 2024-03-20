package MVC;

import MVC.tools.Command;

public class RunCommand implements Command {
    private int times;
    public RunCommand(int times){
        this.times = times;
    }
    @Override
    public void execute() {
        for(int i = 0; i < times; i++){

        }
    }
}
