package estate.service;

import estate.entity.database.AppUserEntity;
import estate.entity.json.TableData;
import estate.entity.json.TableFilter;

/**
 * Created by kangbiao on 15-9-4.
 * 用户服务
 */
public interface UserService
{
    boolean add(AppUserEntity userEntity);

    boolean delete(String userID);

    TableData getOwnerList(TableFilter tableFilter);

    TableData getTenantList(TableFilter tableFilter);

    TableData getAuthenticatedUserList(TableFilter tableFilter);



}
