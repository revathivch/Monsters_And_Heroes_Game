package Games;

import Games.BoardGames.PieceCollection;

import java.util.ArrayList;

// Represents the human player that has the collection of pieces that it represents. games, like ludo and chess are primary examples
public abstract class Player<T extends PieceCollection> {
    private String name;
    private int score = 0;
    private ArrayList<T> piece_collections = new ArrayList();  // Essentially an arraylist of PieceCollection objects


    public Player(String name, int initial_score, ArrayList collection_of_pieces){
        this.name = name;
        this.score = initial_score;
        this.piece_collections = piece_collections;
    }


    public String get_name(){
        return this.name;
    }

    public void set_name(String name){
        this.name = name;
    }

    public int get_score(){
        return score;
    }

    public void set_score(int s){
        this.score = s;
    }

    public void increment_score(){
        this.score = this.score + 1;
    }

    public ArrayList<T> get_piece_collections(){
        return piece_collections;
    }

    public void set_piece_collections(ArrayList<T> p){
        this.piece_collections = p;
    }

}
