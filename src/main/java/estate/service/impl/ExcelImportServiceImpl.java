package estate.service.impl;

import com.google.gson.Gson;
import estate.common.Config;
import estate.common.config.PropertyStatus;
import estate.common.config.PropertyType;
import estate.common.excelDefine.PropertyHead;
import estate.common.excelDefine.SecretHead;
import estate.dao.BaseDao;
import estate.dao.BuildingDao;
import estate.dao.PropertyDao;
import estate.dao.PropertyOwnerInfoDao;
import estate.entity.database.BuildingEntity;
import estate.entity.database.PropertyEntity;
import estate.entity.database.SsidSecretEntity;
import estate.entity.json.ExcelImportReport;
import estate.service.ExcelImportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by kangbiao on 15-10-24.
 *
 */
@Service("excelImportService")
public class ExcelImportServiceImpl implements ExcelImportService
{

    @Autowired
    private PropertyDao propertyDao;
    @Autowired
    private PropertyOwnerInfoDao propertyOwnerInfoDao;
    @Autowired
    private BaseDao baseDao;
    @Autowired
    private BuildingDao buildingDao;

    @Override
    public ExcelImportReport importProperty(List<Map<String, String>> result)
    {
        ExcelImportReport excelImportReport=new ExcelImportReport();
        Integer errorNum=0;
        Integer succNum=0;
        boolean check;
        Gson gson=new Gson();
        List<String> errorDescription=new ArrayList<>();
        for (Map<String, String> map : result)
        {
            check=true;
            PropertyEntity propertyEntity=new PropertyEntity();

            //设置状态
            if (check)
            {
                String status=map.get(PropertyHead.STATUS);
                switch (status)
                {
                    case "出租":
                        propertyEntity.setStatus(PropertyStatus.CHUZU);
                        break;
                    case "自用":
                        propertyEntity.setStatus(PropertyStatus.SELF);
                        break;
                    default:
                        errorNum += 1;
                        errorDescription.add("物业状态不合法: " + gson.toJson(map));
                        check = false;
                        break;
                }
            }

            //设置编号
            if (check)
            {
                PropertyEntity propertyEntity1=propertyDao.getByCode(map.get(PropertyHead.CODE));
                if (propertyEntity1!=null)
                {
                    errorNum+=1;
                    errorDescription.add("该物业编号已存在: "+gson.toJson(map));
                    check=false;
                }
                else
                {
                    propertyEntity.setCode(map.get(PropertyHead.CODE));
                }
            }

            //设置地址信息
            if (check)
            {
                String location=map.get(PropertyHead.ADDRESS);
                if (!location.equals(""))
                    propertyEntity.setLocation(location);
                else
                {
                    errorNum+=1;
                    errorDescription.add("地址信息不能为空: "+gson.toJson(map));
                    check=false;
                }
            }

            //设置面积
            if (check)
            {
                try
                {
                    String squre=map.get(PropertyHead.SQURE);
                    BigDecimal bigDecimal=new BigDecimal(squre).setScale(2,BigDecimal.ROUND_HALF_UP);
                    propertyEntity.setPropertySquare(bigDecimal);
                }
                catch (Exception e)
                {
                    errorNum+=1;
                    errorDescription.add("房屋面积信息不合法: "+gson.toJson(map));
                    check=false;
                }
            }

            // 设置楼栋和楼栋关联
            if (check)
            {
                BuildingEntity buildingEntity = buildingDao.getByCode(map.get(PropertyHead.BUILDINGCODE));
                if (buildingEntity == null)
                {
                    errorNum += 1;
                    errorDescription.add("该楼栋编号不存在: " + gson.toJson(map));
                    check = false;
                }
                else
                {
                    propertyEntity.setVillageId(buildingEntity.getVillageId());
                    propertyEntity.setBuildingId(buildingEntity.getId());
                }
            }

            //设置物业类型
            if (check)
            {
                if (map.get(PropertyHead.TYPE).equals("商户"))
                    propertyEntity.setType(PropertyType.SHOP);
                else if (map.get(PropertyHead.TYPE).equals("住宅"))
                    propertyEntity.setType(PropertyType.APPARTEMENT);
                else
                {
                    errorNum += 1;
                    errorDescription.add("物业类型错误: " + gson.toJson(map));
                    check = false;
                }
            }

            //通过校验后的保存操作
            if (check)
            {
                try
                {
                    propertyEntity.setOpenDoorStatus(Config.TRUE);
                    propertyEntity.setModifyTime(System.currentTimeMillis());
                    baseDao.save(propertyEntity);
                    succNum+=1;
                }
                catch (Exception e)
                {
                    errorNum+=1;
                    errorDescription.add("插入数据库失败: "+gson.toJson(map));
                }
            }
        }
        excelImportReport.setErrorNum(errorNum);
        excelImportReport.setErrorDescription(errorDescription);
        excelImportReport.setSuccNum(succNum);
        return excelImportReport;
    }

    @Override
    public ExcelImportReport importBind(List<Map<String, String>> result)
    {
        ExcelImportReport excelImportReport=new ExcelImportReport();

        return excelImportReport;
    }

    @Override
    public ExcelImportReport importSecret(List<Map<String, String>> result)
    {
        ExcelImportReport excelImportReport=new ExcelImportReport();
        Integer errorNum=0;
        Integer succNum=0;
        boolean check;
        Gson gson=new Gson();
        List<String> errorDescription=new ArrayList<>();
        for (Map<String, String> map : result)
        {
            check=true;
            SsidSecretEntity ssidSecretEntity=new SsidSecretEntity();

            //设置锁的编码
            if (check)
            {
                String code=map.get(SecretHead.CODE);
                if (code.equals(""))
                {
                    errorNum+=1;
                    errorDescription.add("锁的编号不能为空: "+gson.toJson(map));
                    check=false;
                }
                else
                    ssidSecretEntity.setSymbol(code);
            }

            //设置锁的控制对象类型
            if (check)
            {
                Byte controlType= Byte.valueOf(map.get(SecretHead.CONTROLTYPE));
                ssidSecretEntity.setControlType(controlType);
            }

            //设置锁的控制对象id

            //设置

        }
        return excelImportReport;
    }
}
