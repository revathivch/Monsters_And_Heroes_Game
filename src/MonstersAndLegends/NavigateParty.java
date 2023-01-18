package MonstersAndLegends;


import java.util.ArrayList;

// Used to navigate the party along map using the move class
public class NavigateParty { // Each player will have a move piece object

    Map map;
    Player<Party> player;
    Move move;
    int party_id = 0;

    public NavigateParty(Map map, Player player, Move move, int party_id){ // The entire party is considered as one piece
        this.map = map;
        this.player = player;
        this.move = move;
        this.party_id = party_id;
    }

    public void move_party(String control){ // This is to make sure that the code is extensible to multiple players having multiple parties of characters

        ArrayList<ArrayList<MapCell>> cells_array = map.get_cells();
        Party p = (Party) player.get_piece_collections().get(party_id);

        cells_array.get(p.x_cord).get(p.y_cord).party = null;

        if(control.equals("w") || control.equals("W")){

            if(p.x_cord-1<0){
                System.out.println("Please stay within the map !");
            }
            else if(cells_array.get(p.x_cord-1).get(p.y_cord).get_space().get_space_type() != "Inaccessible"){
                System.out.println(move);
                this.move.move_up(p);
            }
            else{
                System.out.println("Danger! Tread carefully, do not access the inaccessible zone");
            }

        }
        if(control.equals("a") || control.equals("A")){
            if(p.y_cord-1<0){
                System.out.println("Please stay within the map !");
            }
            else if(cells_array.get(p.x_cord).get(p.y_cord-1).get_space().get_space_type() != "Inaccessible"){
                this.move.move_left(p);
            }
            else{
                System.out.println("Danger! Tread carefully, do not access the inaccessible zone");
            }
        }
        if(control.equals("s") || control.equals("S")){
            if(p.x_cord+1>=map.get_rows()){
                System.out.println("Please stay within the map !");
            }
            else if(cells_array.get(p.x_cord+1).get(p.y_cord).get_space().get_space_type() != "Inaccessible") {
                this.move.move_down(p);
            }
            else{
                System.out.println("Danger! Tread carefully, do not access the inaccessible zone");
            }
        }
        if(control.equals("d") || control.equals("D")){
            if(p.y_cord+1>=map.get_columns()){
                System.out.println("Please stay within the map !");
            }
            else if(cells_array.get(p.x_cord).get(p.y_cord+1).get_space().get_space_type() != "Inaccessible"){
                this.move.move_right(p);
            }
            else{
                System.out.println("Danger! Tread carefully, do not access the inaccessible zone");
            }
        }

        cells_array.get(p.x_cord).get(p.y_cord).party = p;
        map.set_cells(cells_array);
    }

    public void initialize_party_location(){

        ArrayList<ArrayList<MapCell>> cells_array = map.get_cells();
        Party p = (Party) player.get_piece_collections().get(party_id);

        int flag = 0;
        for(int i=map.get_rows()-1; i>=0; i++){
            for(int j=0; j<map.get_columns(); j++){
                if(cells_array.get(i).get(j).get_space().get_space_type()=="Common"){
                    p.set_x_cord(i);
                    p.set_y_cord(j);
                    player.get_piece_collections().set(party_id, p);
                    flag = 1;
                    break;
                }
            }
            if(flag ==1){
                break;
            }
        }
        cells_array.get(p.x_cord).get(p.y_cord).party = p;
        map.set_cells(cells_array);
    }
}

