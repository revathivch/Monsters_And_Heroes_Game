package MonstersAndLegends.Spaces;

public class CommonSpace implements Space{
    String space_type;
    public CommonSpace(String type) {
        this.space_type = type;
    }

    @Override
    public void set_space_type(String s){
        this.space_type = s;
    }
    @Override
    public String get_space_type(){
        return this.space_type;
    }

    @Override
    public void perform_functionality() {

    }
}
