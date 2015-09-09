package estate.service.impl;

import estate.dao.NoticeDao;
import estate.entity.database.NoticeEntity;
import estate.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

/**
 * Created by kangbiao on 15-9-4.
 *
 */
@Service("notice")
public class NoticeServiceImpl implements NoticeService
{
    /**
     * 根据filterEntity获取对应的公告
     */
    @Autowired
    private NoticeDao noticeDao;

    public ArrayList<NoticeEntity> getAll()
    {
        return null;
    }

    /**
     * 添加公告信息
     *
     * @param noticeEntity 公告实体
     * @return 返回true或false
     */
    public boolean add(NoticeEntity noticeEntity)
    {
        noticeDao.sava(noticeEntity);
        return true;
    }

    /**
     * 根据公告ID删除公告
     *
     * @param noticeID 公告ID
     * @return 返回true或false
     */
    @Transactional
    public boolean delete(String noticeID)
    {
        return noticeDao.delete(noticeID);
    }

    /**
     * 根据公告ID获取对应的公告
     *
     * @param noticeID 公告ID
     * @return 返回公告
     */
    public NoticeEntity getOne(String noticeID)
    {
        return noticeDao.getNoticeByID(noticeID);
    }

    /**
     * 获取指定数量的最新的公告
     *
     * @param num 公告数
     * @return 返回公告列表
     */
    public ArrayList<NoticeEntity> getNewestNotice(Integer num)
    {
        ArrayList<NoticeEntity> entities=new ArrayList<NoticeEntity>();
        NoticeEntity entity=new NoticeEntity();
        entity.setTitle("yi");
        entity.setDescription("描述");
        entities.add(entity);
        entities.add(entity);
        return entities;
    }
}
