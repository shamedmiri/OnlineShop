package ir.miri.shop.app.config.filters;

import ir.miri.shop.app.config.JwtTokenUtil;
import ir.miri.shop.app.helper.exception.JwtTokenException;
import ir.miri.shop.app.helper.ui.uimodels.people.UserVM;
import ir.miri.shop.app.services.people.UserService;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class JwtRequestFilter implements Filter {
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private UserService userService;

    private List<String> excludeUrls;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

        excludeUrls=new ArrayList<>();
        excludeUrls.add("/api/user/login");
        excludeUrls.add("/api/color/");
        excludeUrls.add("/api/utils/upload/files/");

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        try {
            String url=((HttpServletRequest) servletRequest).getRequestURI();
            if(excludeUrls.stream().anyMatch(x->url.startsWith(x))){
                filterChain.doFilter(servletRequest,servletResponse);
                return;
            }

            String requestTokenHeader=((HttpServletRequest) servletRequest).getHeader("Authorization");
            if(requestTokenHeader==null||!requestTokenHeader.startsWith("Bearer "))
                throw new JwtTokenException("request header dose not set");
            String token=requestTokenHeader.substring(7);
            String username=jwtTokenUtil.getUsernameFromToken(token);
            if(username==null)
                throw new JwtTokenException("user name csn not resolve");
            UserVM userVM=new UserVM(userService.getByUsername(username));
            if(!jwtTokenUtil.validateToken(token,userVM))
                throw new JwtTokenException("invalid token!!");
            filterChain.doFilter(servletRequest,servletResponse);

        }catch (JwtTokenException e){
            ((HttpServletResponse)servletResponse).sendError(HttpServletResponse.SC_UNAUTHORIZED,"unauhorized");
        }catch (Exception e){
            ((HttpServletResponse)servletResponse).sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR,"internal server error");
        }
    }
}
