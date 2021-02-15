package com.wfy.controller;

import com.wfy.mapper.OrderMapper;
import com.wfy.service.OrderService;
import com.wfy.utils.ToolsUtil;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/Order")
public class OrderController {

    @Resource
    private OrderService orderService;

    @Resource
    private OrderMapper orderMapper;

    @Resource
    private ToolsUtil toolsUtil;

    /**
     * @Author wfy
     * @Description: 分页查询订单数据
     * @param map
     * @return List<Map<String,Object>>
     * @Date 20:45 2021/02/14
     **/
    @RequestMapping("/queryOrderByLimit")
    public List<Map<String, Object>> queryOrderByLimit(@RequestBody Map<String, Integer> map) {
        int limit = map.get("limit");
        if (limit < 1) {
            limit = 0;
        } else {
            limit = (limit - 1) * 10;
        }
        return orderService.queryOrderByLimit(limit);
    }

    /**
     * @Author wfy
     * @Description: 获取订单总数及分页后页数
     * @param
     * @return Map<String,Integer>
     * @Date 20:49 2021/02/14
     **/
    @RequestMapping("/getOrderPages")
    public Map<String, Integer> getOrderPages() {
        int orderCount = orderService.orderCount();
        int pages = toolsUtil.dataPages(orderCount);
        Map<String, Integer> map = new HashMap<>();
        map.put("pages", pages);
        map.put("logTotal", orderCount);
        return map;
    }

    /**
     * @Author wfy
     * @Description: 更新订单状态
     * @param map
     * @return void
     * @Date 21:28 2021/02/14
     **/
    @RequestMapping("/orderDone")
    public void orderDone(@RequestBody Map<String, Object> map) {
        orderService.ChangeOrderState(map);
    }

    @RequestMapping("/deleteOrder")
    public void deleteOrder(@RequestBody Map<String, Integer> map) {
        orderMapper.deleteOrder(map.get("orderId"));
    }

    /*
     * @Author wfy
     * @Description: 分页查询历史订单
     * @param map
     * @return List<Map<String,Object>>
     * @Date 21:59 2021/02/14
     **/
    @RequestMapping("/queryOrderHistoryByLimit")
    public List<Map<String, Object>> queryOrderByHistoryLimit(@RequestBody Map<String, Integer> map) {
        int limit = map.get("limit");
        if (limit < 1) {
            limit = 0;
        } else {
            limit = (limit - 1) * 10;
        }
        return orderService.queryOrderHistoryByLimit(limit);
    }

    /**
     * @Author wfy
     * @Description: 获取历史订单总数及分页后页数
     * @param
     * @return Map<String,Integer>
     * @Date 21:59 2021/02/14
     **/
    @RequestMapping("/getOrderHistoryPages")
    public Map<String, Integer> getOrderHistoryPages() {
        int orderCount = orderService.orderHistoryCount();
        int pages = toolsUtil.dataPages(orderCount);
        Map<String, Integer> map = new HashMap<>();
        map.put("pages", pages);
        map.put("logTotal", orderCount);
        return map;
    }

    @RequestMapping("/deleteOrderHistory")
    public void deleteOrderHistory(@RequestBody Map<String, Integer> map) {
        orderMapper.deleteOrder(map.get("orderId"));
    }

    @RequestMapping("/findOrderById")
    public Map<String, Object> findOrderById(@RequestBody Map<String, Integer> map) {
        return orderMapper.findOrderById(map.get("orderId"));
    }

    /**
     * @Author wfy
     * @Description: 更新订单信息
     * @param map
     * @return boolean
     * @Date 16:18 2021/02/15
     **/
    @RequestMapping("/updateOrder")
    public boolean updateOrder(@RequestBody Map<String, Object> map) {
        orderService.updateOrderInfo(map);
        return true;
    }
}
