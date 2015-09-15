package estate.controller;

import estate.entity.json.TableData;
import estate.entity.json.TableFilter;
import estate.service.RepairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by kangbiao on 15-9-15.
 *
 */
@RestController
@RequestMapping("/repair")
public class RepairController
{
    @Autowired
    private RepairService repairService;

    @RequestMapping(value = "/list")
    public TableData getPage(TableFilter tableFilter,HttpServletRequest request)
    {
        if (request.getParameter("search[value]")!=null)
            tableFilter.setSearchValue(request.getParameter("search[value]"));
        else
            tableFilter.setSearchValue("");

        return repairService.getList(tableFilter);
    }
}
