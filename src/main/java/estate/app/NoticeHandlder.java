package estate.app;

import estate.common.util.LogUtil;
import estate.entity.database.NoticeEntity;
import estate.entity.json.BasicJson;
import estate.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

/**
 * Created by kangbiao on 15-9-5.
 * 提供公告推送的API
 */
@RestController
@RequestMapping("/notice")
public class NoticeHandlder
{
    @Autowired
    private NoticeService noticeService;

    @RequestMapping(value = "/getSome/{number}",method = RequestMethod.GET)
    public BasicJson getSome(@PathVariable Integer number)
    {
        BasicJson basicJson=new BasicJson(false);
        ArrayList<NoticeEntity> noticeEntities=noticeService.getNewestNotice(number);
        if (noticeEntities==null)
        {
            basicJson.getErrorMsg().setCode("100123");
            basicJson.getErrorMsg().setDescription("为获取到相应公告");
            return basicJson;
        }
        basicJson.setStatus(true);
        basicJson.setJsonString(noticeEntities);
        LogUtil.E(String.valueOf(number));
        return basicJson;
    }
}
