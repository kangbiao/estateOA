package estate.service;

import estate.entity.database.ComplainEntity;
import estate.entity.json.TableData;
import estate.entity.json.TableFilter;

import java.util.ArrayList;

/**
 * Created by kangbiao on 15-9-16.
 *
 */
public interface ComplainService
{
    /**
     * 返回投诉列表
     * @param tableFilter
     * @return
     */
    TableData getList(TableFilter tableFilter);

    /**
     *处理投诉
     * @param complainEntity
     */
    void dealComplain(ComplainEntity complainEntity);

    /**
     * 通过app用户的电话号码获取投诉信息
     * @param phone
     * @return
     */
    ArrayList<ComplainEntity> getComplainByPhone(String phone,Byte status);

}
