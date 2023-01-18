package Games.BoardGames;

// Essentially represents the piece on the board that may or may not be moved around
public abstract class Piece {

    String name;
    public Piece(String name) {
        this.set_name(name);
    }
    public void set_name(String name){
        this.name = name;
    }

    public String get_name(){
        return this.name;
    }
}
