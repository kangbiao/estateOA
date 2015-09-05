package estate.controller;

import estate.common.util.Config;
import estate.common.util.LogUtil;
import estate.entity.database.NoticeEntity;
import estate.entity.json.BasicJson;
import estate.service.NoticeService;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
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
    private NoticeService noticeService;

    @RequestMapping(value = "/test" ,method = RequestMethod.GET)
    public ResponseEntity<BasicJson> test()
    {
        ArrayList<NoticeEntity> arrayList=new ArrayList<NoticeEntity>();
        arrayList.add(noticeService.getOne("1"));
        arrayList.add(noticeService.getOne("2"));

        BasicJson json=new BasicJson();
        json.setStatus(true);
        json.setErrorMsg(null);
        json.setJsonString(arrayList);
        return new ResponseEntity<BasicJson>(json, HttpStatus.OK);
    }

    //增加公告
    @RequestMapping(value = "/add" ,method = RequestMethod.POST)
    public ResponseEntity<BasicJson> add(NoticeEntity noticeEntity,HttpServletRequest request)
    {
        BasicJson basicJson=new BasicJson();
        String time=String.valueOf(System.currentTimeMillis());

        noticeEntity.setCreateTime(time);
        noticeEntity.setPicPath(null);
        try
        {
            MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
            MultipartFile file = multipartRequest.getFile("file");

            if (!file.isEmpty())
            {
                String filename = Config.picPath + String.valueOf(System.currentTimeMillis()) + file
                        .getOriginalFilename();
                try
                {
                    FileUtils.copyInputStreamToFile(file.getInputStream(), new File(filename));
                    noticeEntity.setPicPath(time + "-" + file.getOriginalFilename());
                }
                catch (IOException e)
                {
                    LogUtil.E("上传公告图片写入文件失败" + e.getMessage());
                    basicJson.setStatus(false);
                    basicJson.getErrorMsg().setCode("100102");
                    basicJson.getErrorMsg().setDescription("上传图片失败");
                    return new ResponseEntity<BasicJson>(basicJson, HttpStatus.OK);
                }
            }
        }
        catch (Exception ignored) {}
        if (!noticeService.add(noticeEntity))
        {
            LogUtil.E("上传公告图片写入数据库失败");
            basicJson.setStatus(false);
            basicJson.getErrorMsg().setCode("100103");
            basicJson.getErrorMsg().setDescription("上传图片失败");
            return new ResponseEntity<BasicJson>(basicJson, HttpStatus.OK);
        }
        basicJson.setStatus(true);
        basicJson.setErrorMsg(null);
        basicJson.setJsonString(noticeEntity);
        return new ResponseEntity<BasicJson>(basicJson, HttpStatus.OK);
    }

}
