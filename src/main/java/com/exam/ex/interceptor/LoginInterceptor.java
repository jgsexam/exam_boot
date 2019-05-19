package com.exam.ex.interceptor;

import com.exam.ex.constant.ResultEnum;
import com.exam.ex.exception.ExamException;
import com.exam.ex.pojo.TeacherDO;
import com.exam.ex.utils.ShiroUtils;
import com.exam.ex.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 跨域拦截器
 * @author 杨德石
 * @date
 */
public class LoginInterceptor implements HandlerInterceptor {

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 获取token
        String token = request.getHeader("Authorization");
        if(StringUtils.isNotBlank(token)) {
            // 不为空，说明不是登录，就判断是否挤下线
            TeacherDO loginTeacher = ShiroUtils.getLoginTeacher();
            if(loginTeacher == null) {
                // 未登录，放行
                return true;
            }
            String username = loginTeacher.getTeacherUsername();
            // 获取redis中的token
            String redisToken = redisTemplate.opsForValue().get(username) + "";
            if(!token.equals(redisToken)) {
                // 不相同，说明有人在别处登录，挤下线
                throw new ExamException(ResultEnum.LOGOUT.getCode(), "您已在别处登录，您被迫下线");
            }
        }

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
