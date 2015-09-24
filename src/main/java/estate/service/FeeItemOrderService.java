package estate.service;

import java.util.ArrayList;

/**
 * Created by kangbiao on 15-9-24.
 *
 */
public interface FeeItemOrderService
{
    /**
     * 通过物业id获取该物业绑定的所有的费用项目列表
     * @param id
     * @return
     */
    ArrayList<Object> getFeeItemsByPropertyID(Integer id);
}
