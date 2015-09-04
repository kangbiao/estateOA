package estate.service;

import estate.entity.database.UserEntity;

/**
 * Created by kangbiao on 15-9-4.
 * 用户服务
 */
public interface UserService
{
    boolean login(String phone);

    boolean add(UserEntity userEntity);

    boolean delete(String userID);


}
