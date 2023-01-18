package MonstersAndLegends;

import Games.BoardGames.Piece;
import Games.BoardGames.PieceCollection;
import MonstersAndLegends.Heroes.Heroes;

import java.util.ArrayList;

//Represents a collection of characters or pieces that belogn to a player
public class Party extends PieceCollection {

    String name;
    int x_cord;
    int y_cord;

    // ArrayList<Character> characters_list = new ArrayList<Character>();

    public Party(String name, int x, int y){

        this.name = name;
        this.x_cord = x;
        this.y_cord = y;
    }

    public ArrayList<Heroes> get_pieces(){
        return super.get_pieces();
    }

    public void set_pieces(ArrayList pieces){
        super.set_pieces(pieces);
    }

//    public ArrayList get_characters_list(){
//        return this.characters_list;
//    }
//
//    public void set_characters_list(ArrayList p){
//        this.characters_list = p;
//    }
//
//    public void add_to_party(Character c){
//        this.characters_list.add(c);
//    }

    public String get_name(){
        return this.name;
    }

    public void set_name(String name){
        this.name = name;
    }
    public int get_x_cord(){
        return this.x_cord;
    }

    public void set_x_cord(int x){
        this.x_cord = x;
    }

    public int get_y_cord(){
        return this.y_cord;
    }

    public void set_y_cord(int y){
        this.y_cord = y;
    }

    public void inc_x(){
        this.set_x_cord(this.get_x_cord() + 1);
    }

    public void inc_y(){
        this.set_y_cord(this.get_y_cord() + 1);
    }
}
