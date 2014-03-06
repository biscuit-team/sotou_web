package cn.sotou.web.biz;

import cn.sotou.dao.model.Comment;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: shuhzhang
 * Date: 14-2-20
 * Time: 上午11:49
 * To change this template use File | Settings | File Templates.
 */
public interface InvestItemDetailService {
    public List getItemComment(long id);
    public void insertComment(String content,long id);

}
