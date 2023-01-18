package MonstersAndLegends.Items;

public abstract class ParentItem implements Item{
    String type;
    String name;
    int cost;
    int level_required;

    public ParentItem(String type, String name, int cost, int level_required ){
        this.name = name;
        this.type = type;
        this. cost = cost;
        this. level_required = level_required;
    }

    public String get_name(){
        return this.name;
    }

    public void set_name(String name){
        this.name = name;
    }

    public int get_cost(){
        return this.cost;
    }

    public void set_cost(int cost){
        this.cost = cost;
    }

    public int get_level_required(){
        return this.level_required;
    }

    public void set_level_required(int level_required){
        this.level_required = level_required;
    }

    public String get_type(){
        return this.type;
    }

    public void set_type(String type){
        this.type = type;
    }
}
