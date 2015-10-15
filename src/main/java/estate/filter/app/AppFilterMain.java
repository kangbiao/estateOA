package estate.filter.app;

import estate.common.util.LogUtil;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

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
        HttpServletRequest reqeust = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;

        HttpSession session = reqeust.getSession();
        String phone=(String) session.getAttribute("phone");

        String path = ((HttpServletRequest) req).getServletPath();
        LogUtil.E("phone:" + phone + "    path:" + path);
        if (!("/api/uc/login".equals(path)||path.contains("/notice/")||path.contains("/uc/register/")||path.contains
                ("/query/")))
        {
            if (phone == null || phone.equals(""))
            {
                try
                {
                    response.setContentType("text/plain");
                    response.setCharacterEncoding("UTF-8");
                    response.getWriter().print("no hacked!");
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
            else
            {
                chain.doFilter(req, res);
            }
        }
        else
        {
            chain.doFilter(req, res);
        }
    }

    @Override
    public void destroy()
    {

    }
}
