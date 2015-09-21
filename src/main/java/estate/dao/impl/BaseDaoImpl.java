package estate.dao.impl;

import estate.dao.BaseDao;
import estate.entity.database.NoticeEntity;
import estate.entity.database.RuleEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;

/**
 * Created by kangbiao on 15-9-20.
 *
 */
@Repository("baseDao")
public class BaseDaoImpl implements BaseDao
{
    @Autowired
    private SessionFactory sessionFactory;

    private Session getSession()
    {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public Integer save(Object object)
    {
        getSession().saveOrUpdate(object);
        Class c=object.getClass();
        Method[] methods=c.getMethods();
        for (Method method:methods)
        {
            if (method.getName().matches("^getId$"))
            {
                try
                {
                    return (Integer)method.invoke(object);
                }
                catch (IllegalAccessException | InvocationTargetException e)
                {
                    e.printStackTrace();
                }
            }
        }

        return null;
    }

    @Test
    public void test()
    {
        NoticeEntity noticeEntity=new NoticeEntity();
        noticeEntity.setCuId(99);
        System.out.print(this.save(noticeEntity));
    }


    @Override
    public Object get(Integer id,Object object)
    {
        return getSession().get(object.getClass(),id);
    }

    public Object getByFields(Object object,HashMap<String,String> kv)
    {
//        Session session=getSession();
        String entity=object.getClass().getName().substring(object.getClass().getName().lastIndexOf(".") + 1);
        String hql="from "+entity;
        int i=0;
        String fileds="";
        for (String key:kv.keySet())
        {
            if (i==0)
            {
                fileds=" where "+key+"=:"+key;
            }
            else
            {
                fileds+=" and "+key+"=:"+key;
            }
            i++;
        }
        hql+=fileds;
        return hql;
    }

    @Test
    public void test1()
    {
        HashMap<String,String> kv=new HashMap<>();
        kv.put("id","1");
        kv.put("name", "kangbiao");
        RuleEntity ruleEntity=new RuleEntity();
        System.out.println(getByFields(ruleEntity,kv));
    }

    @Override
    public void delete(Object object)
    {

    }
}
