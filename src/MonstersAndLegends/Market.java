package MonstersAndLegends;

import MonstersAndLegends.Items.*;

import java.util.ArrayList;

// represents the market that is placed in market space in a cell
public class Market {

    ArrayList<ParentItem> items;

    public Market(ArrayList<ParentItem> random_subset) {
        this.items = random_subset;
    }

    public void display_market(){


        for(int i=0; i<items.size(); i++){
            if(items.get(i).get_type().equals("Armor")){
                Armors item = (Armors) items.get(i);
                System.out.println("Name: " + item.get_name() + "       Type:" + item.get_type() + " Cost: " + item.get_cost() + " Level Required: " + item.get_level_required() + " Damage Reduction: " + item.get_damage_reduction());
            }
            else if(items.get(i).get_type().equals("FireSpell") || items.get(i).get_type().equals("IceSpell") || items.get(i).get_type().equals("LighteningSpell") ){
                Spells item = (Spells) items.get(i);
                System.out.println("Name: " + item.get_name() + "       Type:" + item.get_type() + " Cost: " + item.get_cost() + " Level Required: " + item.get_level_required() + " Damage: " + item.get_damage() + " Mana Cost: " + item.get_mana_cost());
            }
            else if(items.get(i).get_type().equals("Potions")){
                Potions item = (Potions) items.get(i);
                System.out.println("Name: " + item.get_name() + "        Type:" + item.get_type() + " Cost: " + item.get_cost() + " Level Required: " + item.get_level_required() + " Increase In Attribute: " + item.get_increase_in_attribute() + " Attribute Affected: " +  item.get_attribute_affected());
            }
            else if(items.get(i).get_type().equals("Weapons")){
                Weapons item = (Weapons) items.get(i);
                System.out.println("Name: " + item.get_name() + "        Type:" + item.get_type() + " Cost: " + item.get_cost() + " Level Required: " + item.get_level_required() + " Damage: " + item.get_damage() +  " Required Hands: " + item.get_required_hands());
            }
        }
    }

    public ArrayList<ParentItem> get_items(){
        return items;
    }

    public void set_items(ArrayList<ParentItem> items){
        this.items = items;
    }
}
