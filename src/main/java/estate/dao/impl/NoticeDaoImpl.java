package estate.dao.impl;

import estate.dao.NoticeDao;
import estate.entity.database.NoticeEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by kangbiao on 15-9-4.
 *
 */
@Repository
public class NoticeDaoImpl implements NoticeDao
{
    @Autowired
    private SessionFactory sessionFactory;

    private Session getSession()
    {
        return sessionFactory.getCurrentSession();
    }

    public NoticeEntity getNoticeByID(String noticeID)
    {
//        String hql="SELECT n FROM NoticeEntity n WHERE n.niticeId=?";
//        Query query= getSession().createQuery(hql).setString(0, noticeID);
//        getSession().get(NoticeEntity.class,noticeID);
        return (NoticeEntity)getSession().get(NoticeEntity.class, Integer.valueOf(noticeID));
    }

    public boolean sava(NoticeEntity noticeEntity)
    {
        try
        {
            getSession().save(noticeEntity);
            getSession().flush();
        }
        catch (Exception e)
        {
//            LogUtil.E(e.getMessage());
            return false;
        }
        return true;
    }

    public boolean delete(String noticeID)
    {
        return false;
    }
}
