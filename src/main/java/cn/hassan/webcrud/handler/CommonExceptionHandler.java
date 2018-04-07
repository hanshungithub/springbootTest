package cn.hassan.webcrud.handler;

import cn.hassan.webcrud.exception.UserNotExistException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class CommonExceptionHandler {

    /**
     * 客户端和浏览器收到的都是同样的json信息
     * @param e
     * @return
     */
/*    @ResponseBody
    @ExceptionHandler(UserNotExistException.class)
    public Map<String, Object> hanleUserNotExistException(Exception e) {
        Map<String, Object> map = new HashMap<>();
        map.put("code", 400);
        map.put("message", e.getMessage());
        return map;
    }*/

    /**
     * 兼容客户端和浏览器
     * @param e
     * @return
     */
    @ExceptionHandler(UserNotExistException.class)
    public String hanleUserNotExistException(Exception e,HttpServletRequest request) {
        request.setAttribute("javax.servlet.error.status_error", 400);
        Map<String, Object> map = new HashMap<>();
        map.put("code", 400);
        map.put("message", e.getMessage());
        request.setAttribute("ext",map);
        return "redirect:/error";
    }
}
