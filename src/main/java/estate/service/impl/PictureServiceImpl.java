package estate.service.impl;

import estate.common.Config;
import estate.dao.PictureDao;
import estate.entity.database.PictureEntity;
import estate.service.PictureService;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * Created by kangbiao on 15-9-13.
 *
 */
@Service("picture")
public class PictureServiceImpl implements PictureService
{
    @Autowired
    private PictureDao pictureDao;

    public String saveAndReturnID(MultipartFile file)
    {
        String filename = String.valueOf(System.currentTimeMillis()) + file
                .getOriginalFilename();
        try
        {

            FileUtils.copyInputStreamToFile(file.getInputStream(), new File(Config.PICPATH + filename));
            PictureEntity pictureEntity=new PictureEntity();
            pictureEntity.setDir(filename);
            return pictureDao.savePictureReturnID(pictureEntity);
        }
        catch (IOException e)
        {
            return null;
        }
    }

    public String getPathByID(Integer id)
    {
        PictureEntity pictureEntity=pictureDao.get(id);
        return Config.PICWEBPATH+pictureEntity.getDir();
    }
}
