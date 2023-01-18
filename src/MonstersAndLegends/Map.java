package MonstersAndLegends;

import Games.BoardGames.Board;
import Games.BoardGames.Cell;
import MonstersAndLegends.Spaces.*;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

// The map that guides you along the game
public class Map<T extends Cell> extends Board {

    boolean space_assigned = false;
    double percentage_market;
    double percentage_inaccessible;
    double percentage_common;
    int count_market=0;
    int count_inaccessible=0;
    int count_common=0;
    public Map(int r, int c, double percent_market, double percent_inaccessible, double percent_common) throws FileNotFoundException {
        super(r, c);
        this.percentage_market = percent_market;
        this.percentage_inaccessible = percent_inaccessible;
        this.percentage_common = percent_common;

        this.initialize_board();
        this.assign_spaces();

    }

    @Override
    public boolean add_cell(Cell c) {
        ArrayList<ArrayList<T>> cells_array = this.get_cells();
        int flag = 0;
        for(int i=0; i<this.get_rows(); i++){
            if(!cells_array.get(i).isEmpty()){
                if(cells_array.get(i).size() != this.get_columns()){
                    cells_array.get(i).add((T) c);
                    this.set_cells(cells_array);
                    flag = 1;
                }
            }
            else{
                cells_array.get(i).add((T) c);
                this.set_cells(cells_array);
                flag = 1;
            }
        }
        return false;
    }

    @Override
    public void initialize_board() {
        ArrayList<ArrayList<T>> cells_array = this.get_cells();

        for(int i=0; i<this.get_rows(); i++){
            cells_array.add(new ArrayList<T>());

            for(int j=0; j<this.get_columns(); j++){
                // Space random = generate_random_spaces();
                // MapCell c = new MapCell(i, j, random);
                MapCell c = new MapCell(i, j);

                cells_array.get(i).add((T) c);
            }
        }
        this.set_cells(cells_array);
    }

    public void assign_spaces() throws FileNotFoundException {
        ArrayList<ArrayList<T>> cells_array = this.get_cells();
        for(int i=0; i<this.get_rows(); i++){
            for(int j=0; j<this.get_columns(); j++){
                Space random = generate_random_spaces();
                if(cells_array.get(i).get(j) instanceof MapCell){
                    ((MapCell)cells_array.get(i).get(j)).set_space(random);
                }
            }
        }
        Collections.shuffle(cells_array);
        this.set_cells(cells_array);
    }

    public Space generate_random_spaces() throws FileNotFoundException {

        String[] type_of_cells = {"Market", "Inaccessible", "Common"};

        SpaceFactory factory = new SpaceFactory();

        String random = (type_of_cells[new Random().nextInt(type_of_cells.length)]);

        int n = this.get_rows() * this.get_columns();

        Space s;

        while(true){
            if(random == "Market"){
                if(count_market <= (int) Math.round(percentage_market * n)) {
                    s = factory.create_space(random);
                    count_market++;
                    return s;
                }
            }
            if(random == "Inaccessible"){
                if(count_inaccessible <= (int) Math.round(percentage_inaccessible * n)) {
                    s = factory.create_space(random);
                    count_inaccessible++;
                    return s;
                }
            }
            if(random == "Common"){
                if(count_common <= (int) Math.round(percentage_common * n)) {
                    s = factory.create_space(random);
                    count_common++;
                    return s;
                }
            }
            random = (type_of_cells[new Random().nextInt(type_of_cells.length)]);
        }
    }

    @Override
    public void display_board() {

        ArrayList<ArrayList<Cell>> cells_array = this.get_cells();
        String horizontal_line = "";
        for(int i = 0; i<this.get_rows(); i++){
            horizontal_line = "";
            String row_content = "";
            for(int j=0; j<this.get_columns(); j++){

                horizontal_line = horizontal_line + "----";
                row_content = row_content + "| ";
                Cell c = cells_array.get(i).get(j);
                if(c instanceof MapCell){
                    if(((MapCell) cells_array.get(i).get(j)).check_party_assigned()){
                            row_content = row_content + "P" + " ";
                    }
                    else{
                        Space s = ((MapCell) c).get_space();
                        if(s instanceof CommonSpace){
                            row_content = row_content + "  ";
                        }
                        else{
                            row_content = row_content + s.get_space_type().charAt(0) + " ";
                        }
                    }

                }
            }
            row_content = row_content + "|";
            System.out.println(horizontal_line);
            System.out.println(row_content);
        }
        System.out.println(horizontal_line);
    }
}
