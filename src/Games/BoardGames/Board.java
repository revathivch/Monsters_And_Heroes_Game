package Games.BoardGames;

import java.util.ArrayList;


// This is the parent board class which is inherited by Map. It has composition of Cell objects and other attributes. This class
// is abstract as its purpose is to be inherited and not instantiated. I ahve also used Generics to make the class more extendible such that it takes in a generic type that extends Cell class
// This class essentially creates the board or map
public abstract class Board<T extends Cell> {

    private int rows;
    private int columns;
    private ArrayList<ArrayList<T> > cells =
            new ArrayList<ArrayList<T> >(rows);

    public Board(int r, int c){
        this.set_rows(r);
        this.set_columns(c);
    }

    public abstract boolean add_cell(Cell c); // To add a cell into the board and returns true if the cell is added

    public abstract void initialize_board();

    public abstract void display_board();

    public void set_rows(int r){
        this.rows = r;
    }

    public ArrayList<ArrayList<T>> get_cells(){
        return(this.cells);
    }

    public void set_cells(ArrayList<ArrayList<T>> c){
        this.cells = c;
    }

    public int get_rows(){
        return(this.rows);
    }
    public void set_columns(int c){
        this.columns = c;
    }

    public int get_columns(){
        return(this.columns);
    }


}
