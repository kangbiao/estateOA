package estate.controller;

import estate.entity.json.BasicJson;
import estate.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by kangbiao on 15-9-25.
 * 全局的搜索控制器
 */
@RestController
@RequestMapping("search")
public class SearchController
{
    @Autowired
    private SearchService searchService;
    /**
     * 按名称搜索园区
     * @param request
     * @return
     */
    @RequestMapping("/village")
    public BasicJson villageSearch(HttpServletRequest request)
    {
        BasicJson basicJson=new BasicJson(false);
        String q=request.getParameter("q");
        if (q==null)
        {
            return basicJson;
        }
        basicJson.setJsonString(searchService.villageByName(q));
        return basicJson;
    }
}
