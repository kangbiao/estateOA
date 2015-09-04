package estate.dao;

import estate.entity.database.UserEntity;

/**
 * Created by kangbiao on 15-9-4.
 * 用户访问接口
 */
public interface UserDao
{
    /**
     * 根据用户id获取用户信息
     * @param userID
     * @return
     */
    UserEntity getUserByID(String userID);



}
