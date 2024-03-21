package MVC;

public class LifeGrid extends Grid{
    public LifeGrid(int dim){

        super(dim);
    }
    @Override
    public Cell makeCell(boolean uniform) {
        Cell cell = new LifeCell(this);
        return cell;
    }
}
