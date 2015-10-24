package estate.controller;

import estate.common.Config;
import estate.common.util.ExcelParse;
import estate.common.util.LogUtil;
import estate.entity.json.BasicJson;
import estate.entity.json.ExcelImportReport;
import estate.entity.json.KindEditor;
import estate.service.ExcelImportService;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by kangbiao on 15-9-22.
 *
 */
@RestController
@RequestMapping("/web/upload")
public class UploadController
{
    @Autowired
    private ExcelImportService excelImportService;

    @RequestMapping(value = "/kindeditor")
    public KindEditor kindEditorUploader(HttpServletRequest request)
    {
        //文件保存目录URL
        String saveUrl  = request.getContextPath() + "/file/kindeditor/";
        String savePath=Config.FILEPATH+"kindeditor/";
        long maxSize = 2100000;

        HashMap<String, String> extMap = new HashMap<>();
        extMap.put("image", "gif,jpg,jpeg,png,bmp");
        extMap.put("flash", "swf,flv");
        extMap.put("media", "swf,flv,mp3,wav,wma,wmv,mid,avi,mpg,asf,rm,rmvb");
        extMap.put("file", "doc,docx,xls,xlsx,ppt,htm,html,txt,zip,rar,gz,bz2");

        KindEditor kindEditor = new KindEditor(1);

        if (!ServletFileUpload.isMultipartContent(request))
        {
            kindEditor.setMessage("请选择文件");
            return kindEditor;
        }
        //检查目录
        File uploadDir = new File(savePath);
        if(!uploadDir.isDirectory()){
            kindEditor.setMessage("上传目录不存在。");
            return kindEditor;
        }
        //检查目录写权限
        if(!uploadDir.canWrite()){
            kindEditor.setMessage("上传目录没有写权限。");
            return kindEditor;
        }
        String dirName = request.getParameter("dir");
        if (dirName == null)
        {
            dirName = "image";
        }
        if (!extMap.containsKey(dirName))
        {
            kindEditor.setMessage("请检查目录名是否正确");
            return kindEditor;
        }

        savePath+=dirName+"/";
        saveUrl+=dirName+"/";
        File saveDirFile = new File(savePath);
        if (!saveDirFile.exists()) {
            saveDirFile.mkdirs();
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String ymd = sdf.format(new Date());
        savePath += ymd + "/";
        saveUrl += ymd + "/";
        File dirFile = new File(savePath);
        if (!dirFile.exists()) {
            dirFile.mkdirs();
        }

        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        Map<String,MultipartFile> map= multipartRequest.getFileMap();


        for (String key:map.keySet())
        {
            MultipartFile fileItem= map.get(key);
            String fileName = fileItem.getOriginalFilename();
            LogUtil.E("FILENAME:"+fileName);
            if (fileItem.getSize() > maxSize)
            {
                kindEditor.setMessage("文件最大不能超过2兆");
                return kindEditor;
            }
            String fileExt = fileName.substring(fileName.lastIndexOf(".") + 1).toLowerCase();
            LogUtil.E("houzui:"+fileExt);
            if (!Arrays.asList(extMap.get(dirName).split(",")).contains(fileExt))
            {
                kindEditor.setMessage("上传文件扩展名是不允许的扩展名。\n只允许" + extMap.get(dirName) + "格式。");
                return kindEditor;
            }

            SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
            String newFileName = df.format(new Date()) + "_" + new Random().nextInt(1000) + "." + fileExt;
            try
            {
                FileUtils.copyInputStreamToFile(fileItem.getInputStream(),new File(savePath,newFileName));
            }
            catch (Exception e)
            {
                kindEditor.setMessage("上传文件失败");
                return kindEditor;
            }

            kindEditor.setError(0);
            kindEditor.setMessage("testing...");
            kindEditor.setUrl(saveUrl + newFileName);
            return kindEditor;
        }

        kindEditor.setMessage("上传异常");
        return kindEditor;
    }


    /**
     * excel导入
     * @param type
     * @param request
     * @return
     */
    @RequestMapping(value = "/excel/{type}")
    public BasicJson uploadExcel(@PathVariable String type,HttpServletRequest request) throws IOException
    {
        BasicJson basicJson=new BasicJson(false);
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        Map<String,MultipartFile> map= multipartRequest.getFileMap();
        InputStream inputStream=null;
        for (String key:map.keySet())
        {
            String fileName=map.get(key).getOriginalFilename();
            String fileExt = fileName.substring(fileName.lastIndexOf(".") + 1).toLowerCase();
            if (!(fileExt.equals("xls")||fileExt.equals("xlsx")))
            {
                basicJson.getErrorMsg().setDescription("非法的文件格式");
                return basicJson;
            }
            inputStream=map.get(key).getInputStream();
        }

        ExcelParse excelParse=new ExcelParse();
        List<Map<String,String>> result;
        try
        {
            if (inputStream==null)
            {
                basicJson.getErrorMsg().setDescription("请选择文件");
                return basicJson;
            }
            result=excelParse.parseExcel(inputStream);
        }
        catch (Exception e)
        {
            basicJson.getErrorMsg().setDescription("解析文件出现错误,请检查文件是否合法");
            basicJson.getErrorMsg().setCode(e.getMessage());
            return basicJson;
        }

        //导入结果报告
        ExcelImportReport excelImportReport;
        switch (type)
        {
            case "property":
                try
                {
                    excelImportReport = excelImportService.importProperty(result);
//                    LogUtil.E(result.size());
                }
                catch (Exception e)
                {
                    basicJson.getErrorMsg().setDescription("excel文件内容不合法!");
                    basicJson.getErrorMsg().setCode(e.getMessage());
                    return basicJson;
                }
                break;
            case "bind":
                try
                {
                    excelImportReport = excelImportService.importBind(result);
                }
                catch (Exception e)
                {
                    basicJson.getErrorMsg().setDescription("excel文件内容不合法!");
                    basicJson.getErrorMsg().setCode(e.getMessage());
                    return basicJson;
                }
                break;
            case "secret":
                try
                {
                    excelImportReport = excelImportService.importSecret(result);
                }
                catch (Exception e)
                {
                    basicJson.getErrorMsg().setDescription("excel文件内容不合法!");
                    basicJson.getErrorMsg().setCode(e.getMessage());
                    return basicJson;
                }
                break;
            default:
                basicJson.getErrorMsg().setDescription("请求路径错误");
                return basicJson;
        }

        basicJson.setStatus(true);
        basicJson.setJsonString(excelImportReport);
        return basicJson;
    }

}