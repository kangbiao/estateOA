package estate.dao.impl;

import estate.common.util.LogUtil;
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
@Repository(value = "NoticeDao")
public class NoticeDaoImpl implements NoticeDao
{
    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public NoticeEntity getNoticeByID(String noticeID)
    {
        //        String hql="SELECT n FROM NoticeEntity n WHERE n.niticeId=?";
        //        Query query= getSession().createQuery(hql).setString(0, noticeID);
        //        getSession().get(NoticeEntity.class,noticeID);
        return (NoticeEntity)getSession().get(NoticeEntity.class, Integer.valueOf(noticeID));
    }

    private Session getSession()
    {
        return sessionFactory.getCurrentSession();
    }

    public void sava(NoticeEntity noticeEntity)
    {
//      Session session=this.sessionFactory.openSession();
        Session session=getSession();
//      Transaction transaction=session.beginTransaction();
            session.save(noticeEntity);
            NoticeEntity noticeEntity1=new NoticeEntity();
            noticeEntity1.setNiticeId(90);
            noticeEntity1.setTitle("1233");
            session.save(noticeEntity1);

//      transaction.commit();
//        session.flush();
//      getSession().clear();
    }

    public boolean delete(String noticeID)
    {
//        String hql="DELETE FROM NoticeEntity n WHERE n.niticeId=?";
//        Query query= getSession().createQuery(hql).setString(0, noticeID);
        NoticeEntity noticeEntity=new NoticeEntity();
        noticeEntity.setNiticeId(Integer.valueOf(noticeID));
        try
        {
            getSession().clear();
            getSession().delete(noticeEntity);
            getSession().flush();
        }
        catch (Exception e)
        {
            LogUtil.E(e.getMessage());
        }
        return false;
    }
}
