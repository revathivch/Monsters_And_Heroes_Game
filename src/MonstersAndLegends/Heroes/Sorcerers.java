package MonstersAndLegends.Heroes;

public class Sorcerers extends Heroes{
    public Sorcerers(String type, String name, int mana, int strength, int agility, int dexterity, int money, int exp, int level) {
        super(type, name, mana, strength, agility, dexterity, money, exp, level);
    }

    @Override
    public void attack() {

    }

    @Override
    public void level_up() {
        this.set_level(this.get_level()+1);
    }
}
