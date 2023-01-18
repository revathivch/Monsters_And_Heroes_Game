package MonstersAndLegends;

import java.util.ArrayList;

// Moves the characters around the map
public class Move implements Games.Move {


    @Override
    public void move_up(Object piece_collection) {
        ((Party)piece_collection).set_x_cord(((Party)piece_collection).get_x_cord() - 1);
    }

    @Override
    public void move_down(Object piece_collection) {
        ((Party)piece_collection).set_x_cord(((Party)piece_collection).get_x_cord() + 1);
    }

    @Override
    public void move_left(Object piece_collection) {
        ((Party)piece_collection).set_y_cord(((Party)piece_collection).get_y_cord() - 1);
    }

    @Override
    public void move_right(Object piece_collection) {
        ((Party)piece_collection).set_y_cord(((Party)piece_collection).get_y_cord() + 1);
    }
}
