package estate.service.impl;

import estate.dao.PropertyDao;
import estate.dao.PropertyOwnerInfoDao;
import estate.entity.json.ExcelImportReport;
import estate.service.ExcelImportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    @Override
    public ExcelImportReport importProperty(List<Map<String, String>> result)
    {
        ExcelImportReport excelImportReport=new ExcelImportReport();

        return excelImportReport;
    }

    @Override
    public ExcelImportReport importBind(List<Map<String, String>> result)
    {
        ExcelImportReport excelImportReport=new ExcelImportReport();

        return excelImportReport;
    }
}
