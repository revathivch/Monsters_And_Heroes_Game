package Games.BoardGames;

import java.util.ArrayList;

// Collection of pieces in order to enable groups of pieces on the board as is present in games like chess
public abstract class PieceCollection<T extends Piece> {
    ArrayList<T> pieces = new ArrayList<T>();    // Essentially an array list of Piece objects but declared generic to reduce dependency among classes


    public ArrayList<T> get_pieces(){
        return this.pieces;
    }

    public void set_pieces(ArrayList<T> pieces){
        this.pieces = pieces;
    }
}
