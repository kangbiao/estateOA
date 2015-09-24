package estate.dao;

import estate.entity.database.AppUserEntity;
import estate.entity.json.TableData;
import estate.entity.json.TableFilter;

/**
 * Created by kangbiao on 15-9-4.
 * 用户访问接口
 */
public interface UserDao
{
    /**
     * 根据用户id获取用户信息
     * @param phone
     * @return
     */
    AppUserEntity getUserByPhone(String phone);



    TableData getOwnerList(TableFilter tableFilter);

    TableData getTenantList(TableFilter tableFilter);

    TableData getAuthenticatedUserList(TableFilter tableFilter);

    TableData getAppUserList(TableFilter tableFilter);

    /**
     * 通过用户类型和电话号码获取用户信息
     * @param phone
     * @param type
     * @return 返回对应的用户实体
     */
    Object getUserInfoBYPhone(String phone ,int type);

}
