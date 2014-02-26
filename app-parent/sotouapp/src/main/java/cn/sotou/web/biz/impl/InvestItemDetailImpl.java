package cn.sotou.web.biz.impl;

/**
 * Created with IntelliJ IDEA.
 * User: shuhzhang
 * Date: 14-2-20
 * Time: 上午11:52
 * To change this template use File | Settings | File Templates.
 */
import javax.inject.Inject;

import cn.sotou.dao.ItemCommentDao;
import cn.sotou.dao.model.Comment;
import cn.sotou.dao.model.InvestItem;
import cn.sotou.dao.model.User;
import cn.sotou.web.biz.InvestItemDetailService;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;

@Service
public class InvestItemDetailImpl implements InvestItemDetailService {
	
    @Inject
    private ItemCommentDao itemCommentDao;

    @Override
    public String getItemComment(long id){
        String hql = generateHql(id);
        List<Comment> allComments = itemCommentDao.getCommentByHql(hql);
        StringBuffer buffer = new StringBuffer();
        for(Comment eachComment : allComments)
        {
            buffer.append("<div >");
            buffer.append("用户名：" + eachComment.getUser().getUsername());
            buffer.append("评论内容："+eachComment.getContent());
            buffer.append("时间："+eachComment.getTime());
            buffer.append("</div>");
        }
        return "this is just a comment haha~";  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void insertComment(String content, long id) {
        Comment comment = new Comment();
        comment.setContent(content);
        comment.setTime(new Date());
        InvestItem product = new InvestItem();
        product.setId(id);
        comment.setInvestItem(product);
        User user = new User();
        user.setUid(1);
        comment.setUser(user);
        itemCommentDao.insertComment(comment);
    }

    private String generateHql(long id){
        StringBuffer buffer = new StringBuffer();
        buffer.append("from comment where productsId=").append(id);
        return buffer.toString();

    }
}
