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
import cn.sotou.web.biz.InvestItemDetailService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvestItemDetailImpl implements InvestItemDetailService {
    @Inject
    private ItemCommentDao itemCommentDao;

    @Override
    public String getItemComment(long id){
        String hql = generateHql(id);
        itemCommentDao.getCommentByHql(hql);
        return "this is just a comment haha~";  //To change body of implemented methods use File | Settings | File Templates.
    }

    private String generateHql(long id){
        StringBuffer buffer = new StringBuffer();
        buffer.append("from where =").append(id);
        return buffer.toString();

    }
}
