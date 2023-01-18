package MonstersAndLegends.Items;

public class Potions extends ParentItem{

    int increase_in_attribute;
    String attribute_affected;

    public Potions(String name, int cost, int required_level, int increase_in_attribute, String attribute_affected) {
        super("Potions", name, cost, required_level);

        this.increase_in_attribute = increase_in_attribute;
        this.attribute_affected = attribute_affected;
    }

    public int get_increase_in_attribute(){
        return increase_in_attribute;
    }

    public void set_increase_in_attribute(int i){
        this.increase_in_attribute = i;
    }

    public String get_attribute_affected(){
        return attribute_affected;
    }

    public void set_attribute_affected(String a){
        this.attribute_affected = a;
    }


}
