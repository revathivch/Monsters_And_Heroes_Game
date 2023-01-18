package Games.BoardGames;

// This is the cell class that forms the basic unit of a board. Inherited by the cells of a map

public abstract class Cell {
    int x; // y-co-ordinate of the cell
    int y; // x-co-ordinate of the cell

    public Cell(int x, int y){
        this.setx(x);
        this.sety(y);
    }

    public void setx(int x){
        this.x = x;
    }

    public void sety(int y){
        this.y = y;
    }

    public int getx(){
        return(x);
    }

    public int gety(){
        return(y);
    }
}

