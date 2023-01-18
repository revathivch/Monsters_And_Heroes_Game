package MonstersAndLegends;
import Games.BoardGames.Piece;
import MonstersAndLegends.Heroes.*;
import MonstersAndLegends.Items.*;
import MonstersAndLegends.Monsters.MonsterCreator;
import MonstersAndLegends.Monsters.Monsters;
import MonstersAndLegends.Spaces.MarketSpace;

import java.io.DataOutput;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

// This is the driver class that drives the game Monsters and Heroes from start till the end
public class Game {

    Scanner console = new Scanner(System.in);
    Map game_map;
    Player player;
    Move move;
    NavigateParty relocate;
    //Paladins paladins;
    ArrayList<Heroes> paladins;
    ArrayList<Heroes> warriors;
    ArrayList<Heroes> sorcerers;
    ArrayList<Heroes> heroes= new ArrayList<Heroes>();

    ArrayList<Monsters> exoskeletons;
    ArrayList<Monsters> dragons;
    ArrayList<Monsters> spirits;
    ArrayList<Monsters> monsters= new ArrayList<Monsters>();
    ArrayList<Party> parties = new ArrayList<Party>();
    Party p = new Party("Party of Heroes", 0, 0);

    DisplayItems d;


    public Game() throws FileNotFoundException {
        // initialize_data();

        move = new Move();
        DisplayItems d = new DisplayItems();
        //paladins = new Paladins("Parzival", 300, 750, 650, 700, 2500, 7, 0 );
        // p = new Party("Party of Heroes", 0, 0);
        //heroes.add(paladins);
        //p.set_pieces(heroes);
        //parties.add(p);
        //game_map = new Map(8,8, 0.3, 0.2, 0.5);
        //player.set_piece_collections(parties);

    }

    public void initialize_data() throws FileNotFoundException {
        TxtConverter converter = new TxtConverter();

        HeroCreator creator = new HeroCreator();
        paladins = converter.generate_heroes("src/Legends_Monsters_and_Heroes/Paladins.txt" , creator, "Paladins" );

        warriors = converter.generate_heroes("src/Legends_Monsters_and_Heroes/Warriors.txt" , creator, "Warriors" );

        sorcerers = converter.generate_heroes("src/Legends_Monsters_and_Heroes/Sorcerers.txt" , creator, "Sorcerers" );

        heroes.addAll(paladins);
        heroes.addAll(warriors);
        heroes.addAll(sorcerers);

        MonsterCreator monster_creator = new MonsterCreator();
        exoskeletons = converter.generate_monsters("src/Legends_Monsters_and_Heroes/Exoskeletons.txt" , monster_creator, "Exoskeletons" );

        dragons = converter.generate_monsters("src/Legends_Monsters_and_Heroes/Dragons.txt" , monster_creator, "Dragons" );

        spirits = converter.generate_monsters("src/Legends_Monsters_and_Heroes/Spirits.txt" , monster_creator, "Spirits" );

        monsters.addAll(exoskeletons);
        monsters.addAll(dragons);
        monsters.addAll(spirits);

    }

    public void display_heroes(ArrayList<Heroes> hero_list){

        for(int i=0; i<hero_list.size(); i++) {
            System.out.println("Name: " + hero_list.get(i).get_name() + " " + "(" + hero_list.get(i).get_type() + ") " + " Mana: " + hero_list.get(i).get_mana() + " Strength: " + hero_list.get(i).get_strength() + " Agility: " + hero_list.get(i).get_agility() + " Dexterity: " + hero_list.get(i).get_dexterity() + " Money: " + hero_list.get(i).get_money() +" Starting Experience: " + hero_list.get(i).get_exp());
        }

    }
    public void display_monsters(ArrayList<Monsters> monster_list){

        for(int i=0; i<monster_list.size(); i++) {
            System.out.println("Name: " + monster_list.get(i).get_name() + " " + "(" + monster_list.get(i).get_type() + ") " + " HP: " + monster_list.get(i).get_HP() + " Dodge Chance: " + monster_list.get(i).get_dodge_chance() + " Damage: " + monster_list.get(i).get_damage() + " Defense: " + monster_list.get(i).get_defense() + " Level: " + monster_list.get(i).get_level());
        }

    }


    public void buy_item_for_hero(Market m){
        System.out.println("Please enter the full name of the item you would like to buy. ");
        String item_name = console.next();
        ParentItem chosen_item = null;
        // Getting the item from the list of items in market
        int flag = 0;
        int item_location_in_market = 0;
        for (int i = 0; i < m.get_items().size(); i++) {
            if (m.get_items().get(i).get_name().equals(item_name)) {
                System.out.println("Item found");
                chosen_item = m.get_items().get(i);
                item_location_in_market = i;
                flag = 1;
                break;
            }
        }

        if(flag == 0){
            System.out.println("Item name invalid");
        }
        else {

            // Getting the hero that requires the item and assigning the item to the inventory of the hero
            System.out.println("Which hero would you like to purchase this item for? ");

            ArrayList<Heroes> party_heroes = ((Party) player.get_piece_collections().get(0)).get_pieces();

            display_heroes(party_heroes);
            String hero_name = console.next();

            int flag1 = 0;
            for (int i = 0; i < party_heroes.size(); i++) {
                if (party_heroes.get(i).get_name().equals(hero_name)) {
                    flag1 = 1;
                    if(party_heroes.get(i).get_money()>= chosen_item.get_cost()) {

                        // Adding the item to hero's inventory
                        ArrayList<ParentItem> inventory = new ArrayList<>();
                        inventory = party_heroes.get(i).get_inventory();
                        inventory.add(chosen_item);
                        //d.display_items(inventory);
                        party_heroes.get(i).set_inventory(inventory);

                        System.out.println("Hero Inventory ");
                        //d.display_items(party_heroes.get(i).get_inventory());


                        // Reducing the hero's money
                        int hero_wealth = party_heroes.get(i).get_money() - chosen_item.get_cost();
                        party_heroes.get(i).set_money(hero_wealth);

                        // Removing the item from the market
                        ArrayList<ParentItem> it = m.get_items();
                        it.remove(item_location_in_market);
                        m.set_items(it);


                        break;
                    }
                    else{
                        System.out.println("Sorry, the hero doesn't have enough money to buy the item");
                        break;
                    }
                }
            }
            if(flag1 == 0){
                System.out.println("Hero name invalid");
            }
        }
    }

    public void sell_item_for_hero(Market m){

        // Getting the item from hero inventory and assigning it to the market
        System.out.println("Which hero would you like to sell an item for? ");
        String hero_name = console.next();

        ArrayList<Heroes> party_heroes = ((Party) player.get_piece_collections().get(0)).get_pieces();

        int flag = 0;
        for (int i = 0; i < party_heroes.size(); i++) {
            if (party_heroes.get(i).get_name().equals(hero_name)) {
                flag = 1;

                ArrayList<ParentItem> inventory = party_heroes.get(i).get_inventory();
                if (inventory.isEmpty()) {
                    System.out.println("Sorry, the hero doesn't have any items in the inventory to sell");
                } else {
                    System.out.println("Below is the list of items in the hero's inventory:");
                    d.display_items(inventory);

                    System.out.println("Enter the name of the item you would like to sell");
                    String item_name = console.next();
                    ParentItem chosen_item = null;

                    int flag1 = 0;
                    for (int k = 0; k < inventory.size(); k++) {
                        if (inventory.get(k).get_name().equals(item_name)) {
                            flag1= 1;
                            chosen_item = inventory.get(k);
                            inventory.remove(k);
                            //Adding half the original cost of the item to the hero as it he is selling a second hand item
                            int new_hero_wealth = party_heroes.get(i).get_money() + chosen_item.get_cost() / 2;
                            party_heroes.get(i).set_money(new_hero_wealth);

                            // Adding the item to the market after reducing its resale value
                            ArrayList items = m.get_items();
                            items.add(chosen_item);
                            m.set_items(items);
                        }
                    }
                    if(flag1==0){
                        System.out.println("Invalid Item name");
                    }
                }
            }
        }
        if(flag == 0){
            System.out.println("Hero name invalid");
        }

    }

    public ArrayList<Monsters> get_monsters_list(){
        Random random = new Random();

        ArrayList<Monsters> mons = new ArrayList<Monsters>();

        for (int i = 0; i < ((Party)player.get_piece_collections().get(0)).get_pieces().size(); i++)
        {
            int index = random.nextInt(monsters.size());
            mons.add(monsters.get(index));
        }

        return mons;
    }

    public boolean check_hp_heroes(ArrayList<Heroes> legends){  // Returns false if all the members in the group have reached 0 hp
        for(int i=0; i<legends.size(); i++) {
            if(legends.get(i).get_HP() != 0){
                return true;
            }
        }
        return false;
    }

    public boolean check_hp_monsters(ArrayList<Monsters> legends){  // Returns true if all the members in the group have reached 0 hp
        for(int i=0; i<legends.size(); i++) {
            if(legends.get(i).get_HP() != 0){
                return true;
            }
        }
        return false;
    }

    public void battle_of_legends(){     // Return true if heroes win and false if monsters win

        ArrayList<Monsters> group_of_monsters;
        group_of_monsters = get_monsters_list(); // Get a random list of monsters for the players to fight with, where theh number of monsters is equal to the number of players
        ArrayList<Heroes> group_of_heroes = ((Party)player.get_piece_collections().get(0)).get_pieces();
        System.out.println("The battle begins ! ");

        while(check_hp_heroes(group_of_heroes) && check_hp_monsters(group_of_monsters) && group_of_monsters.size()!=0) {

            for (int i = 0; i < group_of_monsters.size(); i++) {

                boolean move_made = false;
                while(!move_made && group_of_monsters.size()!=0) {
                    System.out.println(group_of_heroes.get(i).get_name() + " is up against " + group_of_monsters.get(i).get_name());
                    System.out.println("\nChoose your move");
                    System.out.println("1. Equip [Armor/Weapon], 2. Attack an enemy monster, 3. Use Potion, 4. Cast Spell, I -> info on heroes, MI -> info on monsters");
                    String choice = console.next();

                    if (choice.equals("1")) {
                        if(group_of_heroes.get(i).equip()){
                            move_made = true;
                        }

                    }
                    else if (choice.equals("3")) {
                        if(group_of_heroes.get(i).use_potion()){
                            move_made = true;
                        }
                    }
                    else if (choice.equals("4")) {
                        Spells spell = group_of_heroes.get(i).cast_a_spell();
                        if (spell != null) {
                            if (spell.get_type().equals("IceSpell")) {    // IceSpell reduces damage of the monster
                                group_of_monsters.get(i).set_damage((int) (group_of_monsters.get(i).get_damage() * 0.1));
                            } else if (spell.get_type().equals("FireSpell")) {    // FireSpell reduces defense of the monster
                                group_of_monsters.get(i).set_defense((int) (group_of_monsters.get(i).get_defense() * 0.1));
                            } else if (spell.get_type().equals("LighteningSpell")) {    // FireSpell reduces defense of the monster
                                group_of_monsters.get(i).set_dodge_chance((int) (group_of_monsters.get(i).get_dodge_chance() * 0.1));
                            }
                        }
                    }
                    else if(choice.equals("2")){
                        if(group_of_monsters.get(i).get_dodge_chance()>0 ){
                            group_of_monsters.get(i).set_dodge_chance((int) (group_of_monsters.get(i).get_dodge_chance()*0.1));

                            System.out.println("Woah! " + group_of_heroes.get(i).get_name() + " just attacked " + group_of_monsters.get(i).get_name() + " but the attack was dodged !");
                        }
                        else{
                            group_of_monsters.get(i).set_HP(0);
                            System.out.println("Woah! " + group_of_heroes.get(i).get_name() + " just attacked " + group_of_monsters.get(i).get_name() + " to death !");
                            group_of_monsters.remove(i);
                        }
                    }
                    else if(choice.equals("I") || choice.equals("i")){
                        display_heroes(group_of_heroes);
                    }
                    else if(choice.equals("MI") || choice.equals("MI")){
                        display_monsters(group_of_monsters);
                    }
                }
            }
        }
        if(check_hp_heroes(group_of_heroes)){
            System.out.println("Yaaay the heroes won this battle.");
            for(int k=0; k<group_of_heroes.size(); k++){
                group_of_heroes.get(k).set_HP((int) (group_of_heroes.get(k).get_HP()*1.1));
                group_of_heroes.get(k).set_mana((int) (group_of_heroes.get(k).get_mana()*1.1));
            }
        }
        else{
            System.out.println("GAME OVER !");
        }
    }

    public void start() throws FileNotFoundException {
        System.out.println("Welcome to the game ! Prepare yourself for a journey filled with Heroes, Monsers and fun !");
        System.out.println("Please enter your name");
        String player_name = console.next();
        player = new Player(player_name, 0, parties);

        System.out.println("Let's put together a team of heroes for you");
        System.out.println("How many heroes would you like to have in your team? Choose 1, 2 or 3");
        int num_heroes = console.nextInt();
        while(num_heroes!=1 && num_heroes!=2 && num_heroes!=3){
            System.out.println("please enter a number within 1, 2 or 3");
            num_heroes = console.nextInt();
        }

        initialize_data();

        // Displaying all the heroes initial stats
        System.out.println("Paladins");
        display_heroes(paladins);

        System.out.println("\nWarriors");
        display_heroes(warriors);

        System.out.println("\nSorcerers");
        display_heroes(sorcerers);

        for(int i=0; i<num_heroes; i++){

            System.out.println("please enter the name of the hero you would like on your team");
            String hero_name = console.next();

            // Verify and assign hero to party
            int flag = 0;
            for(int j=0; j<heroes.size(); j++){
                if(heroes.get(j).get_name().equals(hero_name)){
                    ArrayList<Heroes> party_character_list = p.get_pieces();
                    party_character_list.add(heroes.get(j));
                    p.set_pieces(party_character_list);

                    System.out.println("Amazing choice, " + heroes.get(j).get_name() + "  has been added to your team");
                    flag = 1;
                    break;
                }
            }
            if(flag == 0){
                System.out.println("That doesn't seem to match any of our heroes, please try again.");
                i--;
            }
        }

        parties.add(p);  // Initializing the parties of player attribute with the chosen party
        player.set_piece_collections(parties);

        System.out.println("Below is your team: ");

        display_heroes(((Party)player.get_piece_collections().get(0)).get_pieces());
        System.out.println("\nYour team is complete ! Lets get started.");

        System.out.println("\nCan't go on a quest without a land to explore and a map to guide you along the way!");
        System.out.println("What size N*N of map would you like to play with? Please enter a number between 4 and 10");
        int map_size = console.nextInt();
        while(map_size<5 || map_size>9){
            System.out.println("Please enter a number between 4 and 10");
            map_size = console.nextInt();
        }
        game_map = new Map(map_size,map_size, 0.3, 0.2, 0.5); // The map is created and cells are initialized with spaces such as market space, common space and inaccessible space

        System.out.println("Here is your map:");

        relocate = new NavigateParty(game_map, player, move, 0);  // Creating object that aids in navigation through the map
        relocate.initialize_party_location(); // Initializing the location of the player

        game_map.display_board();

        System.out.println("P marks the spot where you are at any point of the game");
        System.out.println("M stands for Market, and that's where you can buy things such as Armor, Weaponry, potions and spells to add to your hero's inventory");
        System.out.println("I stands for Inaccessible parts of the map. They are danger zones, you do not wanna go there, and you can't");
        System.out.println("The empty tiles may seem safe, but be careful. There's a chance that you may encounter some Monsters at random");
        System.out.println("If you do run into the monsters, you must fight");
        System.out.println("If you win a battle, your hero's will have an improvement in their attributes");
        System.out.println("If you lose a battle, don't worry, all the heroes get revived at the end of the fight.... but at a cost");


        System.out.println("Here are your controls:" );
        System.out.println("To move around the map, use your W, A, S, D Keys");
        System.out.println("W-> North, A-> West, S-> South, D-> East");
        System.out.println("Enter I to view the stat's of your team. This command works in the midst of a battle too. When in battle, you may also enter MI to view monster stats.");
        System.out.println("Enter Q to exit the game");
        System.out.println(" Let's begin the playing, hope you enjoy the game");

        game_map.display_board();

        String control;
        do{

            System.out.println("\nWhere would you like your team of Heroes to explore? W: North, A: West, D: East, S: South, and I -> Show team stats, Q -> Exit Game");
            control = console.next();

            while((!control.equals("W") && !control.equals("w")) && (!control.equals("A") && !control.equals("a")) && (!control.equals("S") && !control.equals("s")) && (!control.equals("D") && !control.equals("d")) && (!control.equals("I") && !control.equals("i")) && (!control.equals("Q") && !control.equals("q"))){
                System.out.println("Please enter a valid control command");
                control = console.next();
            }
            if(control.equals("q") || control.equals("Q")){
                break;
            }
            else if(control.equals("i") || control.equals("I")){
                System.out.println("The stats of your hero's are: ");
                display_heroes(((Party)player.get_piece_collections().get(0)).get_pieces());
            }
            else{
                relocate.move_party(control);
                game_map.display_board();

                ArrayList<ArrayList<MapCell>> cells_array = game_map.get_cells();


                // Giving the user the option to use the market
                if(cells_array.get(p.x_cord).get(p.y_cord).get_space().get_space_type().equals("Market")){
                    // Display market of the cell
                    System.out.println("Oh you seem to have a market in the area ! Would you like to shop? (Y/N)");
                    String ans = console.next();

                    if(ans.equals("Y")){
                        // Displaying the market for user to browse
                        Market m = ((MarketSpace)cells_array.get(p.x_cord).get(p.y_cord).get_space()).get_market();
                        m.display_market();

                        do {

                            System.out.println("\nWould you like to Buy, Sell or Leave the market? (B/S/L)");
                            String market_choice = console.next();

                            if (market_choice.equals("B")) {

                                do {
                                    buy_item_for_hero(m);

                                    System.out.println("Would you like to buy another item? (B/N)");
                                    market_choice = console.next();

                                } while (market_choice.equals("B"));

                            } else if (market_choice.equals("S")) {
                                do {
                                    sell_item_for_hero(m);

                                    System.out.println("Would you like to sell another item? (S/N)");
                                    market_choice = console.next();

                                } while (market_choice.equals("S"));

                            } else {
                                continue;
                            }
                            System.out.println("Would you like to continue browsing the market? (Y/N)");
                            ans = console.next();
                        }while(ans.equals("Y"));
                    }

                }

                // Accessing common area
                else if(cells_array.get(p.x_cord).get(p.y_cord).get_space().get_space_type().equals("Common")){

                    Dice dice = new Dice();
                    if(dice.monsters_or_not()){ // Returns true if monsters are present after rolling the dice
                        battle_of_legends();
                    }
                }
            }
        }while(!control.equals("q") && !control.equals("Q"));

    }
}
