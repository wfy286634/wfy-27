package com.wfy.service.Impl;

import com.wfy.mapper.OrderMapper;
import com.wfy.service.OrderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderMapper orderMapper;

    @Override
    public List<Map<String, Object>> queryOrderByLimit(int limit) {
        List<Map<String, Object>> list = orderMapper.queryOrderByLimit(limit);
        for (int i=0;i<list.size();i++){
            list.get(i).put("number", i+1);
        }
        return list;
    }

    @Override
    public int orderCount() {
        return orderMapper.orderCount();
    }

    @Override
    public void ChangeOrderState(Map<String,Object> map) {
        Date now = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        String endTime = dateFormat.format(now);
        map.put("endTime", endTime);
        map.put("orderState", "0");
        orderMapper.ChangeOrderState(map);
    }

    @Override
    public List<Map<String, Object>> queryOrderHistoryByLimit(int limit) {
        List<Map<String, Object>> list = orderMapper.queryOrderHistoryByLimit(limit);
        for (int i=0;i<list.size();i++){
            list.get(i).put("number", i+1);
        }
        return list;
    }

    @Override
    public int orderHistoryCount() {
        return orderMapper.orderHistoryCount();
    }
}
