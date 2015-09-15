package estate.service;

import estate.entity.database.NoticeEntity;
import estate.entity.json.TableData;
import estate.entity.json.TableFilter;

import java.util.ArrayList;

/**
 * Created by kangbiao on 15-9-4.
 *公告服务接口
 */
public interface NoticeService
{
    /**
     * 根据filterEntity获取对应的公告
     */
    TableData getList(TableFilter filter);

    /**
     * 添加公告信息
     * @param noticeEntity 公告实体
     * @return 返回true或false
     */
    void add(NoticeEntity noticeEntity);

    /**
     * 根据公告ID删除公告
     * @param noticeID 公告ID
     * @return 返回true或false
     */
    boolean delete(String noticeID);

    /**
     * 根据公告ID获取对应的公告
     * @param noticeID 公告ID
     * @return 返回公告
     */
    NoticeEntity getOne(String noticeID);

    /**
     * 获取指定数量的最新的公告
     * @param num 公告数
     * @return 返回公告列表
     */
    ArrayList<NoticeEntity> getNewestNotice(Integer num);

}
