package estate.service;

/**
 * Created by kangbiao on 15-9-25.
 * 搜索服务
 */
public interface SearchService
{
    /**
     * 通过名称搜索园区
     * @param name
     * @return
     */
    Object villageByName(String name);
}
