package cn.sotou.dao;

import cn.sotou.dao.model.Comment;
import org.hibernate.Transaction;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: shuhzhang
 * Date: 14-2-21
 * Time: 上午10:51
 * To change this template use File | Settings | File Templates.
 */
public class ItemCommentDao extends DaoSupport {
    public void insertComment(Comment c){
        Transaction tran=session.beginTransaction();
        session.save(c);
        tran.commit();
    }

    public List<Comment> getCommentByHql(String hql){
        return session.createQuery(hql).list();
    }

}
