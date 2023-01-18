package MonstersAndLegends.Heroes;

import Games.BoardGames.Piece;
import MonstersAndLegends.Character;
import MonstersAndLegends.DisplayItems;
import MonstersAndLegends.Items.*;

import java.util.ArrayList;
import java.util.Scanner;


// Parent abstract class that brings together the three types of heroes
public abstract class Heroes extends Piece implements Character {

    private String type;
    private int mana;
    private int strength;
    private int agility;
    private int dexterity;
    private int money;
    private int exp;
    private int level;
    private int HP;

    private ParentItem equipped;

    ArrayList<ParentItem> inventory = new ArrayList<>();

    public Heroes(String type, String name, int mana, int strength, int agility, int dexterity, int money, int exp, int level){
        super(name);
        this.mana = mana;
        this.strength = strength;
        this.agility = agility;
        this.dexterity = dexterity;
        this.money = money;
        this.exp = exp;
        this.level = level;
        this.type = type;
        this.HP = 100*this.level;
    }
    public abstract void level_up(); // Level up on the power skills of the hero

    public String get_name(){
        return super.get_name();
    }
    public void set_name(String name){
        super.set_name(name);
    }

    public String get_type(){
        return this.type;
    }
    public void set_type(String type){
        this.type = type;
    }

    public int get_mana(){
        return this.mana;
    }

    public void set_mana(int mana){
        this.mana = mana;
    }

    public int get_strength(){
        return this.strength;
    }

    public void set_strength(int strength){
        this.strength = strength;
    }

    public int get_agility(){
        return this.agility;
    }

    public void set_agility(int agility){
        this.agility = agility;
    }

    public int get_dexterity(){
        return this.dexterity;
    }

    public void set_dexterity(int dexterity){
        this.dexterity = dexterity;
    }

    public int get_money(){
        return this.money;
    }

    public void set_money(int money){
        this.money = money;
    }

    public int get_exp(){
        return this.exp;
    }

    public void set_exp(int exp){
        this.exp = exp;
    }

    public int get_level(){
        return this.level;
    }

    public void set_level(int level){
        this.level = level;
    }

    public ArrayList<ParentItem> get_inventory(){
        return this.inventory;
    }

    public void set_inventory(ArrayList<ParentItem> inventory){
        this.inventory = inventory;
    }

    public int get_HP(){
        return this.HP;
    }

    public void set_HP(int HP){
        this.HP = level*100;
    }

    public boolean has_weapon_armor(){
        for(int i=0; i<inventory.size(); i++){
            if(inventory.get(i).get_type().equals("Armors") || inventory.get(i).get_type().equals("Weapons")){
                return true;
            }
        }
        return false;
    }


    public boolean equip(){
        DisplayItems d = new DisplayItems();
        Scanner console = new Scanner(System.in);

        if(has_weapon_armor()) {

            System.out.println("Please choose a weapon or armor from the hero's inventory as given below");
            d.display_items(inventory);
            System.out.println("Enter the name of the weapon or armor");

            String item_name = console.next();

            int flag = 0;
            for (int i = 0; i < inventory.size(); i++) {
                if (inventory.get(i).get_type().equals("Armors") || inventory.get(i).get_type().equals("Weapons")) {

                    if (inventory.get(i).get_name().equals(item_name)) {
                        equipped = inventory.get(i);
                        System.out.println("All set for the battle, " + get_name() + " is now equipped with " + this.equipped.get_name());
                        flag = 1;
                        break;
                    }
                }
            }
            if (flag == 0) {
                System.out.println("Invalid item name entered for equipping");
                return false;
            }
            else {
                return true;
            }
        }
        else{
            System.out.println("The heros inventory does not have a weapon or armor");
            return false;
        }
    }

    public boolean has_spell(){
        for(int i=0; i<inventory.size(); i++){
            if(inventory.get(i).get_type().equals("FireSpell") || inventory.get(i).get_type().equals("IceSpell") || inventory.get(i).get_type().equals("LighteningSpell")){
                return true;
            }
        }
        return false;
    }

    public Spells cast_a_spell(){
        DisplayItems d = new DisplayItems();
        Scanner console = new Scanner(System.in);
        Spells spell = null;

        if(has_spell()) {

            System.out.println("Please choose a weapon or armor from the hero's inventory");
            d.display_items(inventory);
            System.out.println("Enter the name of the weapon or armor");

            String item_name = console.next();

            int flag = 0;
            for (int i = 0; i < inventory.size(); i++) {
                if (inventory.get(i).get_type().equals("FireSpell") ) {
                    if (inventory.get(i).get_name().equals(item_name)) {
                        flag = 1;
                        spell =  (FireSpell) inventory.get(i);
                    }
                }
                if (inventory.get(i).get_type().equals("IceSpell") ) {
                    if (inventory.get(i).get_name().equals(item_name)) {
                        flag = 1;
                        spell =  (IceSpell) inventory.get(i);
                    }
                }
                if (inventory.get(i).get_type().equals("LighteningSpell")  ) {
                    if (inventory.get(i).get_name().equals(item_name)) {
                        flag = 1;
                        spell =  (LighteningSpell) inventory.get(i);
                    }
                }
            }
            if (flag == 0) {
                System.out.println("Invalid item name entered for equipping");
                return null;
            }
        }
        else{
            System.out.println("The hero's inventory does not have a spell");
            return null;
        }
        return spell;
    }

    public boolean has_potion(){
        for(int i=0; i<inventory.size(); i++){
            if(inventory.get(i).get_type().equals("Potions")){
                return true;
            }
        }
        return false;
    }

    public boolean use_potion(){
        DisplayItems d = new DisplayItems();
        Scanner console = new Scanner(System.in);
        if(has_potion()) {

            System.out.println("Please choose a potion from the hero's inventory");
            d.display_items(inventory);
            System.out.println("Enter the name of the potion");

            String item_name = console.next();

            int flag = 0;
            for (int i = 0; i < inventory.size(); i++) {
                if (inventory.get(i).get_type().equals("Potions")) {

                    if (inventory.get(i).get_name().equals(item_name)) {

                        if (inventory.get(i).get_level_required() <= this.level) {
                            flag = 1;
                            String[] attributes_affected = ((Potions) inventory.get(i)).get_attribute_affected().split("/");

                            for (int j = 0; j < attributes_affected.length; j++) {
                                if (attributes_affected[j].equals("Health")) {
                                    this.set_HP(this.get_HP() + ((Potions) inventory.get(i)).get_increase_in_attribute());
                                } else if (attributes_affected[j].equals("Strength")) {
                                    this.set_strength(this.get_strength() + ((Potions) inventory.get(i)).get_increase_in_attribute());
                                } else if (attributes_affected[j].equals("Mana")) {
                                    this.set_mana(this.get_mana() + ((Potions) inventory.get(i)).get_increase_in_attribute());
                                } else if (attributes_affected[j].equals("Agility")) {
                                    this.set_agility(this.get_agility() + ((Potions) inventory.get(i)).get_increase_in_attribute());
                                } else if (attributes_affected[j].equals("Dexterity")) {
                                    this.set_dexterity(this.get_dexterity() + ((Potions) inventory.get(i)).get_increase_in_attribute());
                                } else {
                                    continue;
                                }
                            }
                            System.out.println("The potion has been consumed");
                        }
                    }
                }
            }
            if (flag == 0) {
                System.out.println("Invalid item name entered for potion");
                return false;
            }
            return true;
        }
        else{
            System.out.println("The heros inventory does not have a potion");
            return false;
        }
    }

}




