package estate.service;

import estate.exception.PictureUploadException;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

/**
 * Created by kangbiao on 15-9-13.
 *
 */
public interface PictureService
{
    /**
     * 存储图片并且返回该图片的主键
     * @param fileMap
     * @return
     */
    String saveAndReturnID(Map<String,MultipartFile> fileMap) throws PictureUploadException;

    /**
     * 根据图片ID获取图片路径
     * @param id
     * @return
     */
    String getPathByID(Integer id);

}
