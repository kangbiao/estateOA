package estate.service.impl;

import estate.dao.AppUserDao;
import estate.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by kangbiao on 15-9-27.
 *
 */
@Service("appUserService")
public class AppUserServiceImpl implements AppUserService
{
    @Autowired
    private AppUserDao appUserDao;

    @Override
    public Object getByPhone(String phone)
    {
        return appUserDao.getByPhone(phone);
    }
}
