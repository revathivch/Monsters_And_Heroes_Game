package MonstersAndLegends.Items;

public class Weapons extends ParentItem{

    int damage;
    int required_hands;

    public Weapons(String name, int cost, int level, int damage, int required_hands){
        super("Weapons", name, cost, level);

        this.damage = damage;
        this.required_hands = required_hands;
    }

    public int get_damage(){
        return this.damage;
    }

    public void set_damage(int damage){
        this.damage = damage;
    }

    public int get_required_hands(){
        return this.required_hands;
    }

    public void set_required_hands(int required_hands){
        this.required_hands = required_hands;
    }

}
