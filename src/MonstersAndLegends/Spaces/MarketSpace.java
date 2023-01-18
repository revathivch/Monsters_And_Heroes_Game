package MonstersAndLegends.Spaces;

import MonstersAndLegends.Items.Armors;
import MonstersAndLegends.Items.FireSpell;
import MonstersAndLegends.Items.ParentItem;
import MonstersAndLegends.Market;
import MonstersAndLegends.MarketGenerator;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class MarketSpace implements Space{

    String space_type;
    Market market;

    public MarketSpace(String type) throws FileNotFoundException {
        this.space_type = type;
        MarketGenerator mg = new MarketGenerator();
        market = new Market(mg.initialize_market_space().get_items());

    }

    public Market get_market(){
        return this.market;
    }

    public void set_market(Market market){
        this.market = market;
    }


    public void set_space_type(String s){
        this.space_type = s;
    }

    public String get_space_type(){
        return this.space_type;
    }

    @Override
    public void perform_functionality() {

    }
}
