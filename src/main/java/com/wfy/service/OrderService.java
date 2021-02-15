package com.wfy.service;

import java.util.List;
import java.util.Map;

public interface OrderService {

    List<Map<String,Object>> queryOrderByLimit(int limit);

    int orderCount();

    void ChangeOrderState(Map<String,Object> map);

    List<Map<String,Object>> queryOrderHistoryByLimit(int limit);

    int orderHistoryCount();

    void updateOrderInfo(Map<String,Object> map);

}
