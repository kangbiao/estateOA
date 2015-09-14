package estate.controller;

import estate.common.util.LogUtil;
import estate.entity.database.NoticeEntity;
import estate.entity.json.BasicJson;
import estate.entity.json.TableData;
import estate.entity.json.TableFilter;
import estate.service.NoticeService;
import estate.service.PictureService;
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
    @Autowired
    private PictureService pictureService;


    /**
     * 增加一条公告信息
     * @param noticeEntity
     * @param bindingResult
     * @param request
     * @return
     */
    @RequestMapping(value = "/add" ,method = RequestMethod.POST)
    public BasicJson add(@Valid NoticeEntity noticeEntity,BindingResult bindingResult,HttpServletRequest request)
    {
        BasicJson basicJson=new BasicJson(false);

        //验证失败
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
        noticeEntity.setTime(time);
        noticeEntity.setCuId(2);
        try
        {
            MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
            MultipartFile file = multipartRequest.getFile("picture");

            if (!file.isEmpty())
            {
                // TODO 捕捉图片上传异常
                String id=pictureService.saveAndReturnID(file);
                if(id!=null)
                {
                    noticeEntity.setPictureIdList(id);
                }
                else
                {
                    basicJson.getErrorMsg().setCode("");
                    basicJson.getErrorMsg().setDescription("上传图片失败,请重试");
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
            LogUtil.E("公告写入数据库失败-"+e.getMessage());
            basicJson.getErrorMsg().setCode("100103");
            basicJson.getErrorMsg().setDescription("公告增加失败,请检查您的输入");
            return basicJson;
        }
        basicJson.setStatus(true);
        basicJson.setJsonString(noticeEntity);
        return basicJson;
    }

    /**
     * 根据公告id获取公告的详细信息
     * @param noticeID
     * @return
     */
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

    /**
     * 根据公告id删除指定的公告
     * @param noticeID
     * @return
     */
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

    /**
     * 根据datatable获取某一页的数据内容
     * @param tableFilter datatable的筛选条件
     * @return
     */
    @RequestMapping(value = "/list")
    public TableData pageList(TableFilter tableFilter) throws InterruptedException
    {
        TableData tableData=new TableData();
        tableData.setJsonString(noticeService.getList(tableFilter));
        tableData.setRecordsFiltered("21");
        tableData.setRecordsTotal("333");
        Thread.sleep(2000);
        return tableData;
    }

}


















