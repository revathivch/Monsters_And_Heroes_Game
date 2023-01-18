package MonstersAndLegends;
import MonstersAndLegends.Heroes.HeroCreator;
import MonstersAndLegends.Heroes.Heroes;
import MonstersAndLegends.Items.*;
import MonstersAndLegends.Monsters.MonsterCreator;
import MonstersAndLegends.Monsters.Monsters;

import java.io.FileNotFoundException;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

// Used to read all the txt files and convert them into objects
public class TxtConverter {

    public ArrayList<Heroes> generate_heroes(String filepath, HeroCreator hero_creator, String type) throws FileNotFoundException {
        String header;
        File f = new File(filepath);
        Scanner sc = new Scanner(f);
        ArrayList<Heroes> heroes = new ArrayList<Heroes>();

        int i=0;
        while(sc.hasNextLine())
            if(i==0){
                header = sc.nextLine();
                i++;
            }
            else{
                String object_data = sc.nextLine();
                if(! object_data.isEmpty()){
                    String[] attribute_list = object_data.split("\\s+");
                    heroes.add((Heroes) hero_creator.create(type, attribute_list[0], Integer.parseInt(attribute_list[1]), Integer.parseInt(attribute_list[2]), Integer.parseInt(attribute_list[3]), Integer.parseInt(attribute_list[4]), Integer.parseInt(attribute_list[5]), Integer.parseInt(attribute_list[6]), 1));
                }

                // System.out.println(object_data);

            }

        return heroes;
    }

    public ArrayList<Monsters> generate_monsters(String filepath, MonsterCreator monster_creator, String type) throws FileNotFoundException {
        String header;
        File f = new File(filepath);
        Scanner sc = new Scanner(f);
        ArrayList<Monsters> monsters = new ArrayList<Monsters>();

        int i=0;
        while(sc.hasNextLine())
            if(i==0){
                header = sc.nextLine();
                i++;
            }
            else{
                String object_data = sc.nextLine();
                if(! object_data.isEmpty()) {
                    String[] attribute_list = object_data.split("\\s+");
                    monsters.add((Monsters) monster_creator.create(type, attribute_list[0], Integer.parseInt(attribute_list[1]), Integer.parseInt(attribute_list[2]), Integer.parseInt(attribute_list[3]), Integer.parseInt(attribute_list[4])));
                }
                //System.out.println(object_data);
            }

        return monsters;
    }

    public ArrayList<Potions> generate_potions(String filepath) throws FileNotFoundException {
        String header;
        File f = new File(filepath);
        Scanner sc = new Scanner(f);
        ArrayList<Potions> potions = new ArrayList<Potions>();

        int i=0;
        while(sc.hasNextLine())
            if(i==0){
                header = sc.nextLine();
                i++;
            }
            else{
                String object_data = sc.nextLine();
                if(! object_data.isEmpty()){
                    String[] attribute_list = object_data.split("\\s+");
                    Potions p = new Potions(attribute_list[0], Integer.parseInt(attribute_list[1]), Integer.parseInt(attribute_list[2]), Integer.parseInt(attribute_list[3]), attribute_list[4]);
                    potions.add(p);
                }
                //System.out.println(object_data);
            }
        return potions;
    }

    public ArrayList<Armors> generate_armors(String filepath) throws FileNotFoundException {
        String header;
        File f = new File(filepath);
        Scanner sc = new Scanner(f);
        ArrayList<Armors> armors = new ArrayList<Armors>();

        int i=0;
        while(sc.hasNextLine())
            if(i==0){
                header = sc.nextLine();
                i++;
            }
            else{
                String object_data = sc.nextLine();
                if(! object_data.isEmpty()){
                    String[] attribute_list = object_data.split("\\s+");
                    Armors a = new Armors(attribute_list[0], Integer.parseInt(attribute_list[1]), Integer.parseInt(attribute_list[2]), Integer.parseInt(attribute_list[3]));
                    armors.add(a);
                }
                //System.out.println(object_data);
            }

        return armors;
    }


    public ArrayList<Weapons> generate_weapons(String filepath) throws FileNotFoundException {
        String header;
        File f = new File(filepath);
        Scanner sc = new Scanner(f);
        ArrayList<Weapons> weapons = new ArrayList<Weapons>();

        int i=0;
        while(sc.hasNextLine())
            if(i==0){
                header = sc.nextLine();
                i++;
            }
            else{
                String object_data = sc.nextLine();
                if(! object_data.isEmpty()){
                    String[] attribute_list = object_data.split("\\s+");
                    Weapons w = new Weapons(attribute_list[0], Integer.parseInt(attribute_list[1]), Integer.parseInt(attribute_list[2]), Integer.parseInt(attribute_list[3]), Integer.parseInt(attribute_list[4]));
                    weapons.add(w);
                }
                //System.out.println(object_data);
            }

        return weapons;
    }


    public ArrayList<Spells> generate_spells(String filepath, SpellCreator spell_creator, String type) throws FileNotFoundException {
        String header;
        File f = new File(filepath);
        Scanner sc = new Scanner(f);
        ArrayList<Spells> spells = new ArrayList<Spells>();

        int i=0;
        while(sc.hasNextLine())
            if(i==0){
                header = sc.nextLine();
                i++;
            }
            else{
                String object_data = sc.nextLine();
                if(! object_data.isEmpty()){
                    String[] attribute_list = object_data.split("\\s+");
                    spells.add((Spells) spell_creator.create_spell(type, attribute_list[0], Integer.parseInt(attribute_list[1]), Integer.parseInt(attribute_list[2]), Integer.parseInt(attribute_list[3]), Integer.parseInt(attribute_list[4])));
                }

                //System.out.println(object_data);

            }
        return spells;
    }

}

