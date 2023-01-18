package MonstersAndLegends;

import Games.BoardGames.PieceCollection;

import java.util.ArrayList;

// Represents the human players that contain pieces to them. This class extends the Player class from our BoardGames package
public class Player<T> extends Games.Player {

    public Player(String name, int initial_score, ArrayList<T> collection_of_pieces) {
        super(name, initial_score, collection_of_pieces);
    }

}
