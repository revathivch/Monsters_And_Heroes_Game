package MonstersAndLegends.Items;

import MonstersAndLegends.Spaces.CommonSpace;
import MonstersAndLegends.Spaces.InaccessibleSpace;
import MonstersAndLegends.Spaces.MarketSpace;


public class SpellCreator {

    public Spells create_spell(String type, String name, int cost, int required_level, int damage, int mana_cost){
        if (type == null || type.isEmpty())
            return null;
        switch (type) {
            case "FireSpell":
                return new FireSpell(name, cost, required_level, damage, mana_cost);
            case "IceSpell":
                return new IceSpell(name, cost, required_level, damage, mana_cost);
            case "LighteningSpell":
                return new LighteningSpell(name, cost, required_level, damage, mana_cost);
            default:
                throw new IllegalArgumentException("Unknown type "+ type);
        }
    }
}
