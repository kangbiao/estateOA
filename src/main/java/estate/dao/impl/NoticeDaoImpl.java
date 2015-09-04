package estate.dao.impl;

import estate.dao.NoticeDao;
import estate.entity.database.NoticeEntity;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by kangbiao on 15-9-4.
 *
 */
@Service("notice")
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
        String hql="SELECT n FROM NoticeEntity n WHERE n.niticeId=?";
        Query query= getSession().createQuery(hql).setString(0, noticeID);
        return (NoticeEntity)query.uniqueResult();
    }
}
