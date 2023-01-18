package MonstersAndLegends;

import java.util.ArrayList;

// Class that represents the dice that is rolled to find out whether a common space conatins monsters or not
public class Dice {
    ArrayList<Integer> value_list = new ArrayList<Integer>();

    public Dice(){
        initialize_dice();
    }

    public Dice(ArrayList<Integer> value_list){
        this.value_list = value_list;
        initialize_dice();
    }

    public void initialize_dice(){
        value_list.add(1);
        value_list.add(2);
        value_list.add(3);
        value_list.add(4);
        value_list.add(5);
        value_list.add(6);
    }

    public int roll_dice(){
        int value_index = (int)(Math.random() * value_list.size());
        return value_list.get(value_index);
    }

    public boolean monsters_or_not(){  // Checks if the given common cell
        int number = roll_dice();
        if(number<value_list.size()/2){
            return true;      // Which means the cell will have monsters
        }
        else{
            return false;
        }
    }
}
