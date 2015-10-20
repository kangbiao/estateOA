package estate.app;

import estate.common.RepairStatus;
import estate.entity.database.PictureEntity;
import estate.entity.database.RepairEntity;
import estate.entity.json.BasicJson;
import estate.exception.PictureUploadException;
import estate.service.BaseService;
import estate.service.PictureService;
import estate.service.RepairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

/**
 * Created by kangbiao on 15-10-10.
 *
 */
@RestController
@RequestMapping(value = "/api/repair")
public class RepairHandler
{

    @Autowired
    private RepairService repairService;
    @Autowired
    private BaseService baseService;
    @Autowired
    private PictureService pictureService;

    /**
     * APP用户获取我的投诉列表
     * @param request
     * @return
     */
    @RequestMapping(value = "/getMyRepair")
    public BasicJson getMyRepair(HttpServletRequest request)
    {
        String urlBase=request.getContextPath()+"/file/picture/";
        BasicJson basicJson=new BasicJson();
        HttpSession httpSession=request.getSession();
        String phone= (String) httpSession.getAttribute("phone");
        Byte status=null;
        if (request.getParameter("status")!=null)
        {
            try
            {
                status=Byte.valueOf(request.getParameter("status"));
                RepairStatus.checkType(status);
            }
            catch (Exception e)
            {
                basicJson.getErrorMsg().setCode("100000");
                basicJson.getErrorMsg().setDescription("客户端参数错误");
                return basicJson;
            }
        }

        try
        {
            ArrayList<RepairEntity> repairEntities= repairService.getRepairByPhone(phone, status);
            if (repairEntities!=null)
            {
                for (RepairEntity repairEntity : repairEntities)
                {
                    String imageIdList = repairEntity.getImageIdList();
                    if (!imageIdList.equals(""))
                    {
                        StringBuilder imagePathString = new StringBuilder();
                        int temp = 0;
                        for (String imageIdString : Arrays.asList(imageIdList.split(",")))
                        {
                            PictureEntity pictureEntity = (PictureEntity) baseService.
                                    get(Integer.valueOf(imageIdString), PictureEntity.class);
                            if (temp == 0)
                                imagePathString.append(urlBase).append(pictureEntity.getName());
                            else
                                imagePathString.append(",").append(urlBase).append(pictureEntity.getName());
                            temp++;
                        }
                        repairEntity.setImageIdList(imagePathString.toString());
                    }
                    repairEntity.setConsoleUserEntity(null);
                }
            }
            basicJson.setJsonString(repairEntities);
        }
        catch (Exception e)
        {
            basicJson.getErrorMsg().setDescription("获取报修信息失败");
            return basicJson;
        }

        basicJson.setStatus(true);
        return basicJson;
    }

    /**
     * 增加报修
     * @param request
     * @return
     */
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public BasicJson addRepair(RepairEntity repairEntity,HttpServletRequest request)
    {
        BasicJson basicJson=new BasicJson();
        HttpSession httpSession=request.getSession();
        repairEntity.setPhone((String) httpSession.getAttribute("phone"));
        repairEntity.setTime(System.currentTimeMillis());
        repairEntity.setStatus(RepairStatus.FORPROCESS);
        if (repairEntity.getContent().length()>25)
            repairEntity.setDescription(repairEntity.getContent().substring(0,25));
        else repairEntity.setDescription(repairEntity.getContent());

        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        Map<String,MultipartFile> map= multipartRequest.getFileMap();

        //上传图片
        try
        {
            repairEntity.setImageIdList(pictureService.saveAndReturnID(map));
        }
        catch (PictureUploadException e)
        {
            basicJson.getErrorMsg().setDescription(e.getMessage());
            return basicJson;
        }
        catch (Exception e)
        {
            basicJson.getErrorMsg().setDescription("图片上传失败,请重试");
            return basicJson;
        }

        try
        {
            baseService.save(repairEntity);
        }
        catch (Exception e)
        {
            basicJson.getErrorMsg().setDescription("提交报修失败");
            return basicJson;
        }

        basicJson.setStatus(true);
        return basicJson;
    }


    /**
     * 评论报修
     * @param request
     * @return
     */
    @RequestMapping(value = "/remark",method = RequestMethod.POST)
    public BasicJson remarkRepair(HttpServletRequest request)
    {
        BasicJson basicJson=new BasicJson();
        Integer repairID;
        String remark;
        String remarkText;
        try
        {
            repairID= Integer.valueOf(request.getParameter("id"));
            remark=request.getParameter("remark");
            remarkText=request.getParameter("comment");
        }
        catch (Exception e)
        {
            basicJson.getErrorMsg().setDescription("参数错误!");
            return basicJson;
        }

        try
        {
            RepairEntity repairEntity= (RepairEntity) baseService.get(repairID, RepairEntity.class);
            repairEntity.setRemark(remark);
            repairEntity.setRemarkText(remarkText);
            repairEntity.setStatus(RepairStatus.HADCOMMENT);
            baseService.save(repairEntity);
        }
        catch (Exception e)
        {
            basicJson.getErrorMsg().setDescription("评论失败,请重试");
            return basicJson;
        }

        basicJson.setStatus(true);
        return basicJson;
    }
}
