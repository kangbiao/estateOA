package estate.controller;

import estate.common.util.Config;
import estate.common.util.LogUtil;
import estate.entity.database.NoticeEntity;
import estate.entity.json.BasicJson;
import estate.service.NoticeService;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kangbiao on 15-9-3.
 *
 */
@RestController
@RequestMapping("/notice")
public class NoticeController
{
    @Autowired
    private NoticeService noticeService;
    @RequestMapping(value = "/test" ,method = RequestMethod.GET)
    public BasicJson test()
    {
        ArrayList<NoticeEntity> arrayList=new ArrayList<NoticeEntity>();
        arrayList.add(noticeService.getOne("1"));
        arrayList.add(noticeService.getOne("2"));

        BasicJson json=new BasicJson();
        json.setStatus(true);
        json.setErrorMsg(null);
        json.setJsonString(arrayList);
        return json;
    }

    //增加公告
    @RequestMapping(value = "/add" ,method = RequestMethod.POST)
    public BasicJson add(@Valid NoticeEntity noticeEntity,BindingResult bindingResult,HttpServletRequest request)
    {
        BasicJson basicJson=new BasicJson(false);
        if (bindingResult.hasErrors())
        {
            List<FieldError> errors=bindingResult.getFieldErrors();
            for (FieldError fieldError:errors)
            {
                LogUtil.E(fieldError.getField()+fieldError.getDefaultMessage());
            }
            basicJson.setJsonString(errors);
            return basicJson;
        }
        String time=String.valueOf(System.currentTimeMillis());

        noticeEntity.setCreateTime(time);
        noticeEntity.setPicPath(null);
        try
        {
            MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
            MultipartFile file = multipartRequest.getFile("file");

            if (!file.isEmpty())
            {
                String filename = Config.PICPATH + String.valueOf(System.currentTimeMillis()) + file
                        .getOriginalFilename();
                try
                {
                    FileUtils.copyInputStreamToFile(file.getInputStream(), new File(filename));
                    noticeEntity.setPicPath(time + "-" + file.getOriginalFilename());
                }
                catch (IOException e)
                {
                    LogUtil.E("上传公告图片写入文件失败" + e.getMessage());
                    basicJson.getErrorMsg().setCode("100102");
                    basicJson.getErrorMsg().setDescription("上传图片失败");
                    return basicJson;
                }
            }
        }
        catch (Exception ignored) {}
        try
        {
            noticeService.add(noticeEntity);
        }
        catch (Exception e)
        {
            LogUtil.E("上传公告图片写入数据库失败");
            basicJson.getErrorMsg().setCode("100103");
            basicJson.getErrorMsg().setDescription("公告增加失败,请检查您的输入");
            return basicJson;
        }
        basicJson.setStatus(true);
        basicJson.setJsonString(noticeEntity);
        return basicJson;
    }


    @RequestMapping(value = "/get/{noticeID}")
    public BasicJson get(@PathVariable String noticeID)
    {
        BasicJson basicJson=new BasicJson(false);
        NoticeEntity noticeEntity=noticeService.getOne(noticeID);
        if (noticeEntity==null)
        {
            basicJson.getErrorMsg().setCode("1000010");
            basicJson.getErrorMsg().setDescription("该条公告不存在");
            return basicJson;
        }
        basicJson.setStatus(true);
        basicJson.setJsonString(noticeEntity);
        return basicJson;
    }


    @RequestMapping(value = "/delete/{noticeID}")
    public BasicJson delete(@PathVariable String noticeID)
    {
        BasicJson basicJson=new BasicJson(false);
        if (!noticeService.delete(noticeID))
        {
            basicJson.getErrorMsg().setCode("1001020");
            basicJson.getErrorMsg().setDescription("删除失败");
        }
        else
        {
            basicJson.setStatus(true);
            basicJson.setJsonString("删除成功");
        }
        return basicJson;
    }



}


















