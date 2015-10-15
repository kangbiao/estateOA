package estate.entity.display;

import estate.entity.database.FeeItemEntity;
import estate.entity.json.ParkLotExtra;

/**
 * Created by kangbiao on 15-10-16.
 */
public class ParkLotFeeInfo extends FeeItemEntity
{
    private ParkLotExtra parkLotExtra;

    public ParkLotExtra getParkLotExtra()
    {
        return parkLotExtra;
    }

    public void setParkLotExtra(ParkLotExtra parkLotExtra)
    {
        this.parkLotExtra = parkLotExtra;
    }
}
