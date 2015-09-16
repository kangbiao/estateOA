package estate.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * Created by kangbiao on 15-9-13.
 */
public interface PictureService
{
    /**
     * 存储图片并且返回该图片的主键
     * @param file
     * @return
     */
    String saveAndReturnID(MultipartFile file);

    /**
     * 根据图片ID获取图片路径
     * @param id
     * @return
     */
    String getPathByID(Integer id);

}
