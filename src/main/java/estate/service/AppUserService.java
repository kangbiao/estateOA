package estate.service;

/**
 * Created by kangbiao on 15-9-27.
 *
 */
public interface AppUserService
{
    /**
     * 通过app用户的手机号码获取appuser信息
     * @param phone
     * @return
     */
    Object getByPhone(String phone);
}
