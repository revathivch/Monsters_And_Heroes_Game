package MonstersAndLegends;

import MonstersAndLegends.Items.*;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;


// Generates and initializes a market
public class MarketGenerator {

    ArrayList<Armors> armors;
    ArrayList<Spells> fire_spells;
    ArrayList<Spells> ice_spells;
    ArrayList<Spells> lightening_spells;
    ArrayList<Potions> potions;
    ArrayList<Weapons> weapons;

    TxtConverter converter = new TxtConverter();

    ArrayList<ParentItem> complete_item_list = new ArrayList<ParentItem>();

    public MarketGenerator() throws FileNotFoundException {
        armors = converter.generate_armors("Legends_Monsters_and_Heroes/Armory.txt");
        SpellCreator spell_creator = new SpellCreator();
        fire_spells = converter.generate_spells("Legends_Monsters_and_Heroes/FireSpells.txt", spell_creator,"FireSpell");
        ice_spells = converter.generate_spells("Legends_Monsters_and_Heroes/IceSpells.txt",spell_creator,"IceSpell");
        lightening_spells = converter.generate_spells("src/Legends_Monsters_and_Heroes/LightningSpells.txt",spell_creator,"LighteningSpell");

        potions = converter.generate_potions("Legends_Monsters_and_Heroes/Potions.txt");
        weapons = converter.generate_weapons("Legends_Monsters_and_Heroes/Weaponry.txt");
    }

    public Market initialize_market_space() {
        complete_item_list.addAll(armors);
        complete_item_list.addAll(fire_spells);
        complete_item_list.addAll(ice_spells);
        complete_item_list.addAll(lightening_spells);
        complete_item_list.addAll(potions);
        complete_item_list.addAll(weapons);

        Collections.shuffle(complete_item_list);

        ArrayList<ParentItem> random_subset = new ArrayList<ParentItem>();

        Random rand = new Random();
        for (int i = 0; i < 10; i++) {
            int random_index = rand.nextInt(complete_item_list.size());
            random_subset.add(complete_item_list.get(random_index));
        }
        Market market = new Market(random_subset);
        return market;

    }
}
