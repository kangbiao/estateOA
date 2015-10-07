package estate.service;

import estate.entity.database.PropertyOwnerInfoEntity;
import estate.entity.display.Property;
import estate.entity.json.Select2;
import estate.entity.json.TableData;
import estate.entity.json.TableFilter;

import java.util.ArrayList;
import java.util.Set;

/**
 * Created by kangbiao on 15-9-16.
 *
 */
public interface PropertyService
{
    Integer save(PropertyOwnerInfoEntity object);

    Set<Property> getPropertiesByString(String string);

    TableData getList(TableFilter tableFilter);

    /**
     * 通过物业id获取该物业绑定的一个业主(后期可能需要返回多个业主)
     * @param id
     * @return
     */
    Object getByProperID(Integer id);

    /**
     * 获取所有的园区信息,以select2的数组返回
     * @return
     */
    Object getAllVillage ();

    /**
     * 通过园区的id获取该园区下所有的楼栋信息,以select2的数组返回
     * @param id
     * @return
     */
    Object getBuildingsByValliageId(Integer id);

    /**
     * 通过楼栋id获取该楼栋下面的所有物业,以select2的数组返回
     * @param buildingID
     * @return
     */
    Object getPropertyByBuildingId(Integer buildingID);

    /**
     * 根据APP用户的电话号码返回该app用户名下所有的物业
     * @param phone
     * @return
     */
    ArrayList<Object> getProperitiesByAppUserPhone(String phone) throws Exception;


    /**
     * 保证业主电话和物业id的组合为唯一
     * @param phone
     * @param id
     * @return
     */
    boolean checkOwnerPropertyExit(String phone,Integer id);

    //TODO 项目验收,待删除
    ArrayList<Select2> getAllProperty();


}
