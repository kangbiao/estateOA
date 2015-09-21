package estate.service;

import java.util.ArrayList;

/**
 * Created by kangbiao on 15-9-21.
 *
 */
public interface AuthorityService
{
    /**
     * 根据业主的电话返回该业主名下所有有权限进入的楼栋id
     * @param phone
     * @return
     */
    ArrayList<Integer> getAuthorityBuildingIDsByPhone(String phone);
}
