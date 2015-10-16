package estate.filter.app;

import estate.common.util.LogUtil;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by kangbiao on 15-10-6.
 *
 */
public class AppFilterMain implements Filter
{

    @Override
    public void init(FilterConfig filterConfig) throws ServletException
    {

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException,
            ServletException
    {
        HttpServletRequest requst = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;

        HttpSession session = requst.getSession();
        String phone=(String) session.getAttribute("phone");
        ArrayList<String> passUrl=new ArrayList<>();
        passUrl.add("/uc/login");
        passUrl.add("/notice/");
        passUrl.add("/uc/register/");
        passUrl.add("/query/");
        passUrl.add("/findPassword/");

        String path = requst.getServletPath();
        LogUtil.E("phone:" + phone + "    path:" + path);
        if (isDoFilter(passUrl,path))
        {
            if (phone == null || phone.equals(""))
            {
                response.setContentType("text/plain");
                response.setCharacterEncoding("UTF-8");
                response.getWriter().print("no hacked!");
                return;
            }
        }
        chain.doFilter(req, res);
    }

    @Override
    public void destroy()
    {

    }

    public boolean isDoFilter(ArrayList<String> paths,String path)
    {
        for (String context:paths)
        {
            if (path.contains(context))
                return false;
        }
        return true;
    }
}
