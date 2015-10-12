package estate.filter.web;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by kangbiao on 15-10-6.
 *
 */
public class WebFilterMain implements Filter
{
    @Override
    public void init(FilterConfig filterConfig) throws ServletException
    {

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException,
            ServletException
    {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;

        HttpSession session=request.getSession();

//        String path=request.getServletPath();
//        ArrayList<String> passUrl=new ArrayList<>();
//        passUrl.add("/view/403.html");
//        passUrl.add("/view/login.html");
//        LogUtil.E(GsonUtil.getGson().toJson(session.getAttribute("user")));
//        if (!(passUrl.contains(path)||path.contains(".css")||path.contains(".js")||path.contains(".png")))
//        {
//            if (session.getAttribute("user")==null)
//            {
//                response.sendRedirect(request.getContextPath() + "/view/login.html");
//                return;
//            }
//        }
        chain.doFilter(req,res);
    }

    @Override
    public void destroy()
    {

    }
}
