package estate.service.impl;

import estate.entity.json.TableData;
import estate.entity.json.TableFilter;
import estate.service.ServiceService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * Created by kangbiao on 15-9-7.
 * 服务实现类
 */
@Service("service")
public class ServiceServiceImpl implements ServiceService
{
    public ArrayList<TableData> getRepairList(TableFilter tableFilter)
    {
        return null;
    }
}
