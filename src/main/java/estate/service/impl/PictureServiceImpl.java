package estate.service.impl;

import estate.common.Config;
import estate.common.util.LogUtil;
import estate.dao.BaseDao;
import estate.entity.database.PictureEntity;
import estate.exception.PictureUploadException;
import estate.service.PictureService;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;
import java.util.Random;

/**
 * Created by kangbiao on 15-9-13.
 *
 */
@Service("picture")
public class PictureServiceImpl implements PictureService
{
    @Autowired
    private BaseDao baseDao;

    public String saveAndReturnID( Map<String,MultipartFile> fileMap) throws PictureUploadException
    {
        StringBuilder idString=new StringBuilder("");

        //图片上传约束定义
        long maxSize = 2100000;
        String allowExts="jpg,png,gif";
        String basePath=Config.PICPATH;

        int temp=0;
        for (String key:fileMap.keySet())
        {
            MultipartFile fileItem= fileMap.get(key);
            String fileName = fileItem.getOriginalFilename();
            LogUtil.E("FILENAME:" + fileName);
            if (fileItem.getSize() > maxSize)
                throw new PictureUploadException("图片大小不能超过2兆");

            String fileExt = fileName.substring(fileName.lastIndexOf(".") + 1).toLowerCase();
            LogUtil.E("图片后缀名:"+fileExt);
            if (!Arrays.asList(allowExts.split(",")).contains(fileExt))
                throw new PictureUploadException("不允许的文件类型");

            SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
            String newFileName = df.format(new Date()) + "_" + new Random().nextInt(1000) + "." + fileExt;
            try
            {
                FileUtils.copyInputStreamToFile(fileItem.getInputStream(), new File(basePath, newFileName));
            }
            catch (Exception e)
            {
                throw new PictureUploadException("图片写入失败!");
            }
            PictureEntity pictureEntity=new PictureEntity();
            pictureEntity.setName(newFileName);
            pictureEntity.setUploadTime(System.currentTimeMillis());
            baseDao.save(pictureEntity);
            if (temp==0)
                idString.append(pictureEntity.getId());
            else
                idString.append(",").append(pictureEntity.getId());
            temp++;
        }
        return idString.toString();
    }

}
