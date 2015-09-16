package estate.dao;

import estate.entity.database.PictureEntity;

/**
 * Created by kangbiao on 15-9-13.
 *
 */
public interface PictureDao
{
    String savePictureReturnID(PictureEntity pictureEntity);

    PictureEntity get(Integer id);
}
