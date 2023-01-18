package MonstersAndLegends.Spaces;

public class InaccessibleSpace implements Space{

    String space_type;

    public InaccessibleSpace(String type) {
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
