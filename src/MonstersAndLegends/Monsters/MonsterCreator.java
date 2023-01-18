package MonstersAndLegends.Monsters;

import MonstersAndLegends.Character;
import MonstersAndLegends.CharacterCreator;
import MonstersAndLegends.Heroes.Paladins;
import MonstersAndLegends.Heroes.Sorcerers;
import MonstersAndLegends.Heroes.Warriors;

// Factory class that is used to produce objects of type Monster
public class MonsterCreator implements CharacterCreator {

    @Override
    public Character create(String type, String name, int mana, int strength, int agility, int dexterity, int money, int exp, int level) {
        return null;
    }

    @Override
    public Character create(String type, String name, int level, int damage, int defense, int dodge_chance) {
        if (type == null || type.isEmpty())
            return null;
        switch (type) {
            case "Dragons":
                return new Dragons(type, name, level, damage, defense, dodge_chance);
            case "Exoskeletons":
                return new Exoskeletons(type, name, level, damage, defense, dodge_chance);
            case "Spirits":
                return new Spirits(type, name, level, damage, defense, dodge_chance);
            default:
                throw new IllegalArgumentException("Unknown type "+ type);
        }
    }
}
