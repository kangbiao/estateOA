package estate.service.impl;

import estate.service.AuthorityService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * Created by kangbiao on 15-9-21.
 *
 */
@Service("authorityService")
public class AuthorityServiceImpl implements AuthorityService
{
    @Override
    public ArrayList<Integer> getAuthorityBuildingIDsByPhone(String phone)
    {
        ArrayList<Integer> integers=new ArrayList<>();
        return integers;
    }
}
