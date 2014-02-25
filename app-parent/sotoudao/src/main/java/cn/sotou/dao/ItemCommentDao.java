package cn.sotou.dao;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: shuhzhang
 * Date: 14-2-21
 * Time: 上午10:51
 * To change this template use File | Settings | File Templates.
 */
public class ItemCommentDao extends DaoSupport {
    public void insertComment(Object o){

    }

    public List getCommentByHql(String hql){
        return session.createQuery(hql).list();
    }
}
