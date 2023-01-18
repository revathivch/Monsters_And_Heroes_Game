package MonstersAndLegends;
import MonstersAndLegends.Spaces.Space;

// Individual pieces of the board
public class MapCell extends Games.BoardGames.Cell{

    Space space;
    Party party;

    public MapCell(int x, int y, Space s) {
        super(x, y);
        this.space = s;
    }

    public MapCell(int x, int y){
        super(x,y);
    }

    public Space get_space(){
        return this.space;
    }

    public void set_space(Space s){
        this.space = s;
    }

    public Party get_party(){
        return this.party;
    }

    public void set_party(Party p){
        this.party = party;
    }

    public boolean check_party_assigned(){    // Checks if a party exists on the cell
        if(party != null){
            return true;
        }
        else{
            return false;
        }
    }
}
