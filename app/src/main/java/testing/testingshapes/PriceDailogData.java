package testing.testingshapes;

import android.content.Context;

/**
 * Created by baymax on 9/2/16.
 */
public class PriceDailogData {


    Context context;
    int icon;
    String vechileName;
    String prices;
    String type;


    public void setData(PriceDailogData data){

        this.context = data.context;
        this.icon = data.icon;
        this.vechileName = data.vechileName;
        this.prices = data.prices;
        this.type = data.type;
    }
}
