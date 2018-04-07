package cn.hassan.webcrud.component;

import org.springframework.boot.autoconfigure.web.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;

import java.util.Map;

/**
 * 容器中加入自己定义的错误的属性
 */
@Component
public class CommonErrorAttributes extends DefaultErrorAttributes {

    @Override
    public Map<String, Object> getErrorAttributes(RequestAttributes requestAttributes, boolean includeStackTrace) {
        Map<String, Object> map = super.getErrorAttributes(requestAttributes, includeStackTrace);
        Map<String, Object> result = (Map<String, Object>) requestAttributes.getAttribute("ext", 0);
        map.put("ext", result);
        return map;
    }
}
