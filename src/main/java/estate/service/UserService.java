package estate.service;

import estate.entity.database.AppUserEntity;
import estate.entity.display.Owner;
import estate.entity.json.TableData;
import estate.entity.json.TableFilter;

/**
 * Created by kangbiao on 15-9-4.
 * 用户服务
 */
public interface UserService
{

    TableData getOwnerList(TableFilter tableFilter);

    TableData getTenantList(TableFilter tableFilter);

    TableData getAuthenticatedUserList(TableFilter tableFilter);

    /**
     * 获取app用户列表,同时返回每个用户绑定的房产id(1,2,3)
     * @param tableFilter
     * @return
     */
    TableData getAppUserList(TableFilter tableFilter);

    TableData getList(TableFilter tableFilter,Object object);

    Owner getOnerInfoByID(Integer id);

    void changeAppUserStatus(AppUserEntity appUserEntity);

    Object getUserInfoBYPhone(String phone,int type);

    /**
     * 通过业主的电话获取该业主绑定的所有物业实体信息
     * @param phone
     * @return
     */
    Object getPropertiesByPhone(String phone);
}
