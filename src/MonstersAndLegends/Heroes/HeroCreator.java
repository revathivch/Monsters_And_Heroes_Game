package MonstersAndLegends.Heroes;

import MonstersAndLegends.Character;
import MonstersAndLegends.CharacterCreator;
import MonstersAndLegends.Spaces.CommonSpace;
import MonstersAndLegends.Spaces.InaccessibleSpace;
import MonstersAndLegends.Spaces.MarketSpace;


// Factory class that is used to produce objects of type Hero
public class HeroCreator implements CharacterCreator {
    @Override
    public Character create(String type, String name, int mana, int strength, int agility, int dexterity, int money, int exp, int level) {
        if (type == null || type.isEmpty())
            return null;
        switch (type) {
            case "Paladins":
                return new Paladins(type, name, mana, strength, agility, dexterity, money, exp, level);
            case "Warriors":
                return new Warriors(type, name, mana, strength, agility, dexterity, money, exp, level);
            case "Sorcerers":
                return new Sorcerers(type, name, mana, strength, agility, dexterity, money, exp, level);
            default:
                throw new IllegalArgumentException("Unknown type "+ type);
        }
    }

    @Override
    public Character create(String type, String name, int level, int damage, int defense, int dodge_chance) {
        return null;
    }
}
