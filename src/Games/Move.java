package Games;

import java.util.ArrayList;
// The class that moves the piece or collection of pieces around
public interface Move<T> {

    public void move_up(T piece_collection);

    public void move_down(T piece_collection);

    public void move_left(T piece_collection);

    public void move_right(T piece_collection);
}
