package estate.controller;

import estate.dao.NoticeDao;
import estate.entity.database.NoticeEntity;
import estate.entity.json.BasicJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;

/**
 * Created by kangbiao on 15-9-3.
 *
 */
@Controller
@RequestMapping("/notice")
public class NoticeController
{
    @Autowired
    private NoticeDao noticeDao;

    @RequestMapping(value = "/test" ,method = RequestMethod.GET)
    public ResponseEntity<BasicJson> test()
    {
        ArrayList<NoticeEntity> arrayList=new ArrayList<NoticeEntity>();
        arrayList.add(noticeDao.getNoticeByID("1"));
        arrayList.add(noticeDao.getNoticeByID("2"));

        BasicJson json=new BasicJson();
        json.setStatus(true);
        json.setErrorMsg(null);
        json.setJsonString(arrayList);
        return new ResponseEntity<BasicJson>(json, HttpStatus.OK);
    }

//    @RequestMapping(value = "/{noticeID}" ,method = RequestMethod.GET)
//    public ResponseEntity<BasicJson> getByID(@PathVariable String noticeID)
//    {
//
//    }
}
