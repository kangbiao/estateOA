package estate.service;

import estate.entity.display.Family;

import java.util.Set;

/**
 * Created by kangbiao on 15-9-17.
 *
 */
public interface FamilyService
{
    /**
     * 通过业主的ID获取所有的家庭成员
     * @param id
     * @return
     */
    Set<Family> getFamiliesByOwnerID(Integer id);

}
