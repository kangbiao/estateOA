package estate.service.impl;

import estate.entity.database.NoticeEntity;
import estate.service.NoticeService;

import java.util.ArrayList;

/**
 * Created by kangbiao on 15-9-4.
 *
 */
public class NoticeServiceImpl implements NoticeService
{
    /**
     * 根据filterEntity获取对应的公告
     */
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
        return false;
    }

    /**
     * 根据公告ID删除公告
     *
     * @param noticeID 公告ID
     * @return 返回true或false
     */
    public boolean delete(String noticeID)
    {
        return false;
    }

    /**
     * 根据公告ID获取对应的公告
     *
     * @param noticeID 公告ID
     * @return 返回公告
     */
    public NoticeEntity getOne(String noticeID)
    {
        return null;
    }

    /**
     * 获取指定数量的最新的公告
     *
     * @param num 公告数
     * @return 返回公告列表
     */
    public ArrayList<NoticeEntity> getNewestNotice(Integer num)
    {
        return null;
    }
}
