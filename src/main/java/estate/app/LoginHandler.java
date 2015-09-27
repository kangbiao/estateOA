package estate.app;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by kangbiao on 15-9-27.
 *
 */
public class LoginHandler implements Filter
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
//        HttpSession session = reqeust.getSession();
//        LogUtil.E(reqeust.getParameter("phone"));
        // TODO 为适应验收而加的验证方法,以后都要改
        String phone = reqeust.getParameter("phone");
        String path = ((HttpServletRequest) req).getServletPath();
        if (!"/api/user/login".equals(path))
        {
            if (phone == null || phone.equals(""))
            {
                try
                {
                    response.setContentType("application/json");
                    response.setCharacterEncoding("UTF-8");
//                    LogUtil.E("没有登陆");
                    response.getWriter().print("no hack!");
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
