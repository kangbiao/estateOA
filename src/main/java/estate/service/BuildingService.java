package estate.service;

/**
 * Created by kangbiao on 15-9-22.
 */
public interface BuildingService
{
    /**
     * 通过楼栋代码获取楼栋id获取,不存在则返回null;
     * @param code
     * @return
     */
    Integer getIDByCode(String code);
}
