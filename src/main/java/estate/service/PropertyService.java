package estate.service;

import estate.entity.database.PropertyOwnerInfoEntity;
import estate.entity.display.Property;
import estate.entity.json.TableData;
import estate.entity.json.TableFilter;

import java.util.Set;

/**
 * Created by kangbiao on 15-9-16.
 *
 */
public interface PropertyService
{
    Integer save(PropertyOwnerInfoEntity object);

    Property get(Integer id);

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
     * 通过园区的id获取该园区下所有的楼栋信息,已select2的数组返回
     * @param id
     * @return
     */
    Object getBuildingsByValliageId(Integer id);

}
