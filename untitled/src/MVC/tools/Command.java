package MVC.tools;

public abstract class Command {
    private Model model;
    public Command(Model model) {
        this.model = model;
    }

    public abstract void execute();
}
