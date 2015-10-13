package estate.service;

/**
 * Created by kangbiao on 15-10-13.
 */
public interface PropertyOwnerService
{
    /**
     * 通过业主的电话和物业ID删除对应的业主物业绑定关系<br/>
     * 同时会查询该业主是否还绑定有其他物业,如果没有,则会从app用户中将该业主的账号删除<br/>
     *
     * @param phone
     * @param propertyID
     */
    void deleteOwnerPropertyBind(String phone,Integer propertyID);
}
