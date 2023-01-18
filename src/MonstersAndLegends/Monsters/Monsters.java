package MonstersAndLegends.Monsters;

import Games.BoardGames.Piece;
import MonstersAndLegends.Character;

// Parent abstract class that brings together the three types of monsters
public abstract class Monsters extends Piece implements Character {

    String type;
    int level;
    int damage;
    int defense;
    int dodge_chance;
    int HP;


    public Monsters(String type, String name, int level, int damage, int defense, int dodge_chance){
        super(name);
        this.level = level;
        this.damage = damage;
        this.defense = defense;
        this.dodge_chance = (int) (dodge_chance*0.1);
        this.type = type;
        this.HP = this.level*100;

    }

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

    public int get_level(){
        return this.level;
    }

    public void set_level(int level){
        this.level = level;
    }

    public int get_damage(){
        return this.damage;
    }

    public void set_damage(int damage){
        this.damage = damage;
    }

    public int get_defense(){
        return this.defense;
    }

    public void set_defense(int defense){
        this.defense = defense;
    }

    public int get_dodge_chance(){
        return this.dodge_chance;
    }

    public void set_dodge_chance(int dodge_chance){
        this.dodge_chance = dodge_chance;
    }

    public int get_HP(){
        return this.HP;
    }

    public void set_HP(int hp){
        this.HP = hp;
    }

}
