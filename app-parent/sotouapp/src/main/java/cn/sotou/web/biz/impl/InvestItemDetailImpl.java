package cn.sotou.web.biz.impl;

/**
 * Created with IntelliJ IDEA.
 * User: shuhzhang
 * Date: 14-2-20
 * Time: 上午11:52
 * To change this template use File | Settings | File Templates.
 */
import javax.inject.Inject;
import cn.sotou.web.biz.InvestItemDetailService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Service
public class InvestItemDetailImpl implements InvestItemDetailService {

    @Override
    public String getItemComment(long id) {
        return "this is just a comment haha~";  //To change body of implemented methods use File | Settings | File Templates.
    }
}
