//package MVC;
//
//import MVC.*;
//
//import java.util.Objects;
//
//public class GridFactory implements AppFactory {
//
//    public Model makeModel() {
//        return new GridView();
//    }
//
//    public View makeView(Model m) { return new GridView((Grid)m); }
//
//    public String getTitle() { return "CA Lab Simulator"; }
//
//    public String[] getHelp() { return new String[] {"click Change to cycle through colors"};}
//
//    public String about() { return "CA Lab Simulator version 1.0. Copyright 2020 by Cyberdellic Designs"; }
//
//    public String[] getEditCommands() { return new String[0]; }
//
//    public Command makeEditCommand(Model model, String type, Object source) {
//        if (Objects.equals(type, "Run1"))
//            return new RunCommand(model);
//
//        return null;
//    }
//}
