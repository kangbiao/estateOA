package estate.dao;

import estate.entity.database.PropertyEntity;
import estate.entity.json.TableData;
import estate.entity.json.TableFilter;

import java.util.ArrayList;

/**
 * Created by kangbiao on 15-9-16.
 *
 */
public interface PropertyDao
{

    /**
     * 根据ID获取某个对象
     * @param id
     * @return
     */
    PropertyEntity get(Integer id);

    /**
     * 根据对象信息删除某个对象
     * @param object
     */
    void delete(PropertyEntity object);


    TableData getList(TableFilter tableFilter);

    /**
     * 根据楼栋的id获取物业
     * @param id
     * @return
     */
    ArrayList<PropertyEntity> getPropertyByBuildingID(Integer id);

    /**
     * 根据用户的电话和类型获取绑定的所有物业
     * @param phone
     * @param role
     * @return
     */
    ArrayList<PropertyEntity> getPropertiesByPhoneRole(String phone,Byte role);


    /**
     * 获取所有的物业
     * @return
     */
    ArrayList<PropertyEntity> getAllProperty();

}
