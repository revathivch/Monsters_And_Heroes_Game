package MonstersAndLegends.Items;

public class Armors extends ParentItem{

    int damage_reduction;

    public Armors(String name, int cost, int level_required, int damage_reduction) {
        super("Armors", name, cost, level_required);
        this.damage_reduction = damage_reduction;
    }


    public int get_damage_reduction(){
        return this.damage_reduction;
    }

    public void set_damage_reduction(int damage_reduction){
        this.damage_reduction = damage_reduction;
    }
}
