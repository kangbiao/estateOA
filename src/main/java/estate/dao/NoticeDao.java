package estate.dao;

import estate.entity.database.NoticeEntity;

/**
 * Created by kangbiao on 15-9-4.
 * 公告数据访问接口
 */
public interface NoticeDao
{
    NoticeEntity getNoticeByID(String noticeID);
}
