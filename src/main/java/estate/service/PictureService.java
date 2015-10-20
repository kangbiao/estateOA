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
     * 保存图片,并且返回保存后的图片id组成的字符串,逗号分隔
     * @param fileMap
     * @return
     */
    String saveAndReturnID(Map<String,MultipartFile> fileMap) throws PictureUploadException;

}
