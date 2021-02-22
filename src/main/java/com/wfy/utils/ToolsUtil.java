package com.wfy.utils;

import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author wfy
 * @Description: 自定义工具集
 * @Date 15:29 2021/01/29
 **/
@Component
public class ToolsUtil {

    private static final String pattern = "^Mozilla/\\d\\.\\d\\s+\\(+.+?\\)";
    private static final String pattern2 = "\\(+.+?\\)";
    private static final Pattern r = Pattern.compile(pattern);
    private static final Pattern r2 = Pattern.compile(pattern2);

    /**
     * @Author wfy
     * @Description: 计算数据的总页数（10条为一页，将int数据对10取整，有余数+1）
     * @param count
     * @return int
     * @Date 21:12 2021/01/29
     **/
    public int dataPages(int count) {
        int i = count / 10;
        if (count % 10 != 0 || i==0) {
            i++;
        }
        return i;
    }

    /**
     * @Author wfy
     * @Description: 获取登录用户的IP地址
     * @param
     * @return String
     * @Date 17:48 2021/02/06
     **/
    public String getIpAddr(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        if ("0:0:0:0:0:0:0:1".equals(ip)) {
            ip = "127.0.0.1";
        }
        if (ip.split(",").length > 1) {
            ip = ip.split(",")[0];
        }
        return ip;
    }

    /**
     * @Author wfy
     * @Description: 角色代码转换
     * @param roleCode
     * @return String
     * @Date 21:54 2021/02/06
     **/
    public static final Map<Integer, String> ROLE_MAP = new HashMap<>();
    static{
        ROLE_MAP.put(101, "主管理员");
        ROLE_MAP.put(102, "顾客管理员");
        ROLE_MAP.put(103, "商品管理员");
    }


    /**
     * @Author wfy
     * @Description: 获取登录设备信息
     * @param request
     * @return String
     * @Date 17:36 2021/02/19
     **/
    public String getDeviceInfo(HttpServletRequest request) {
        String userAgent = request.getHeader("User-Agent");
        Matcher m = r.matcher(userAgent);
        String result = null;
        if (m.find()) {
            result = m.group(0);
        }

        Matcher m2 = r2.matcher(result);
        if (m2.find()) {
            result = m2.group(0);
        }
        result = result.replace("(", "");
        result = result.replace(")", "");
        if (StringUtils.isBlank(result)) {
            return null;
        }
        result = result.replace(" U;", "");
        result = result.replace(" zh-cn;", "");
        return result;
    }

}
