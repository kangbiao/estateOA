package estate.controller;

import estate.entity.json.TableData;
import estate.entity.json.TableFilter;
import estate.service.VillageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by kangbiao on 15-10-15.
 *
 */
@RestController
@RequestMapping("/web/village")
public class VillageController
{
    @Autowired
    private VillageService villageService;

    @RequestMapping(value = "/getList")
    public TableData getList(TableFilter tableFilter,HttpServletRequest request)
    {
        tableFilter.setSearchValue(request.getParameter("search[value]"));
        if (tableFilter.getSearchValue().equals(""))
            tableFilter.setSearchValue(null);
        try
        {
            return villageService.getList(tableFilter);
        }
        catch (Exception e)
        {
            return null;
        }
    }
}
