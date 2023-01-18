package MonstersAndLegends.Items;

public abstract class Spells extends ParentItem{
    int damage;
    int mana_cost;

    public Spells(String type, String name, int cost, int required_level, int damage, int mana_cost){
        super(type, name, cost, required_level);
        this.damage = damage;
        this.mana_cost = mana_cost;
    }


    public int get_damage(){
        return this.damage;
    }

    public void set_damage(int damage){
        this.damage = damage;
    }

    public int get_mana_cost(){
        return this.mana_cost;
    }

    public void set_mana_cost(int mana_cost){
        this.mana_cost = mana_cost;
    }
}
