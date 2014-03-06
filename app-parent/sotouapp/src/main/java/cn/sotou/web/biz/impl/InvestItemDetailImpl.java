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

import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class InvestItemDetailImpl implements InvestItemDetailService {
	
    @Inject
    private ItemCommentDao itemCommentDao;

    @Override
    public List getItemComment(long id){
        String hql = generateHql(id);
        InvestItem investItem = itemCommentDao.getInvestItemByHql(hql);
        System.out.println(investItem.getId());
        ArrayList<Comment> allComments = new ArrayList<Comment>(investItem.getComments());
        Collections.sort(allComments,new Comparator(){

            @Override
            public int compare(Object o1, Object o2) {
                Comment c1 = (Comment)o1;
                Comment c2 = (Comment)o2;
                return c2.getTime().compareTo(c1.getTime());  //To change body of implemented methods use File | Settings | File Templates.
            }
        });
        StringBuffer buffer = new StringBuffer();
        List<Map> result = new LinkedList<Map>();
        for(Comment eachComment : allComments)
        {
            Map<String,String> tmp= new HashMap<String,String>();
            tmp.put("userName",eachComment.getUser().getUsername());
            tmp.put("content",eachComment.getContent());
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String time = format.format(eachComment.getTime());
            tmp.put("time",time);
            result.add(tmp);
            /*buffer.append("<div >");
            buffer.append("用户名：" + eachComment.getUser().getUsername());
            buffer.append("评论内容："+eachComment.getContent());
            buffer.append("时间："+eachComment.getTime());
            buffer.append("</div>");*/
        }
       return result;
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
        System.out.println(content+" 字数："+content.length());
        itemCommentDao.insertComment(comment);
    }

    private String generateHql(long id){
        StringBuffer buffer = new StringBuffer();
        buffer.append("from InvestItem where id=").append(id);
        return buffer.toString();

    }
}
