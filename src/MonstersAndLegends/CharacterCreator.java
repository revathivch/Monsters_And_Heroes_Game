package MonstersAndLegends;

// Interface that describes the basic behaviour of a factory that creates characters
public interface CharacterCreator {

    // Method Overloading as HeroesCreator and MonstersCreator have different signatures
    Character create(String type, String name, int mana, int strength, int agility, int dexterity, int money, int exp, int level);

    Character create(String type, String name, int level, int damage, int defense, int dodge_chance);
}
