package estate.service;

import estate.entity.database.FeeItemEntity;
import estate.entity.json.TableFilter;

import java.util.ArrayList;

/**
 * Created by kangbiao on 15-9-15.
 * 费用接口,提供物业费,服务费和车位费的录入和查询功能
 */
public interface FeeService
{
    /**
     * 增加物业费项目
     * @param feeItemEntity 物业费的信息
     */
    void estateFeeAdd(FeeItemEntity feeItemEntity);

    /**
     * 根据datatable过滤条件返回datatable格式的项目列表
     * @param tableFilter
     * @return
     */
    ArrayList<FeeItemEntity> feeList(TableFilter tableFilter);

}
