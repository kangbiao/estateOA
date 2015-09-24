package estate.dao;

import java.util.ArrayList;

/**
 * Created by kangbiao on 15-9-24.
 */
public interface FeeItemOrderDao
{
    /**
     * 根据物业id返回该物业绑定的所有的费用信息实体,每一个实体包含一个费用详细信息实体
     * @param id
     * @return
     */
    ArrayList<Object> getFeeItemOrdersByPropertyID(Integer id);

}
