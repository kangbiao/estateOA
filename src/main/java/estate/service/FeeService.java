package estate.service;

import estate.entity.database.FeeItemEntity;
import estate.entity.json.TableData;
import estate.entity.json.TableFilter;

/**
 * Created by kangbiao on 15-9-15.
 * 费用接口,提供物业费,服务费和车位费的录入和查询功能
 */
public interface FeeService
{

    /**
     * 增加费用项目
     * @param feeItemEntity
     */
    void estateFeeAdd(FeeItemEntity feeItemEntity);

    /**
     * 根据datatable过滤条件返回datatable格式的项目列表
     * @param tableFilter
     * @return
     */
    TableData feeList(TableFilter tableFilter,int feeType);

    /**
     * 会同时删除与之相关的规则
     * @param id
     */
    void deleteFee(Integer id);

}
