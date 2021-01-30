package com.wfy.utils;

import org.springframework.stereotype.Component;

@Component
public class ToolsUtil {

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
}
