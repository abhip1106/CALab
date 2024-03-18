package MVC;

public class LifeGrid extends Grid{

    @Override
    public Cell makeCell(boolean uniform) {
        Cell cell = new LifeCell();

        return cell;
    }
}
