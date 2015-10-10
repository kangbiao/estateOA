package estate.service.impl;

import estate.common.util.Convert;
import estate.dao.ComplainDao;
import estate.entity.database.ComplainEntity;
import estate.entity.display.Complain;
import estate.entity.json.TableData;
import estate.entity.json.TableFilter;
import estate.service.ComplainService;
import estate.service.ConsoleUserService;
import estate.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * Created by kangbiao on 15-9-16.
 */
@Service("complainService")
public class ComplainServiceImpl implements ComplainService
{
    @Autowired
    private ComplainDao complainDao;
    @Autowired
    private ConsoleUserService consoleUserService;
    @Autowired
    private PictureService pictureService;

    public TableData getList(TableFilter tableFilter)
    {
        TableData tableData=complainDao.getList(tableFilter);
        ArrayList<ComplainEntity> entities=(ArrayList<ComplainEntity>)tableData.getJsonString();
        ArrayList<Complain> complains=new ArrayList<Complain>();

        for (ComplainEntity complainEntity:entities)
        {
            Complain complain=new Complain();

            complain.setTitle(complainEntity.getTitle());
            complain.setContent(complainEntity.getContent());
            complain.setDescription(complainEntity.getDescription());
            complain.setResult(complainEntity.getResult());

            complain.setTime(Convert.num2time(complainEntity.getTime()));
            complain.setStatus(Convert.complainStatus2String(complainEntity.getStatus()));

//            complain.setImageList(pictureService.getPathByID(complainEntity.getImageIdList()));
//            complain.setConsoleUserEntity(consoleUserService.get(complainEntity.getAdminId()));


            complains.add(complain);
        }
        tableData.setJsonString(complains);

        return tableData;
    }

    public void dealComplain(ComplainEntity complainEntity)
    {

    }

    @Override
    public ArrayList<ComplainEntity> getComplainByPhone(String phone,Byte status)
    {
        return complainDao.getByPhone(phone,status);
    }
}
