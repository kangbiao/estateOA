package estate.dao.impl;

import estate.dao.NoticeDao;
import estate.entity.database.NoticeEntity;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

/**
 * Created by kangbiao on 15-9-4.
 *
 */
@Repository(value = "NoticeDao")
public class NoticeDaoImpl implements NoticeDao
{
    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private Session getSession()
    {
        return sessionFactory.getCurrentSession();
    }

    public NoticeEntity getNoticeByID(String noticeID)
    {
        return (NoticeEntity)getSession().get(NoticeEntity.class, Integer.valueOf(noticeID));
    }


    public void sava(NoticeEntity noticeEntity)
    {
        Session session=getSession();
        session.save(noticeEntity);
    }

    public boolean delete(String noticeID)
    {
        return false;
    }

    public ArrayList<NoticeEntity> getSome(Integer num)
    {
        ArrayList<NoticeEntity> entities;
        Session session=getSession();
        String hql="from NoticeEntity n order by n.time desc ";
        Query query=session.createQuery(hql).setFirstResult(0).setMaxResults(num);
        entities= (ArrayList<NoticeEntity>) query.list();
        return entities;
    }
}
