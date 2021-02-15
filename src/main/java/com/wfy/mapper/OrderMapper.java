package com.wfy.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface OrderMapper {

     List<Map<String,Object>> queryOrderByLimit(int limit);

     int orderCount();

     void deleteOrder(int orderId);

     int ChangeOrderState(Map<String,Object> map);

     List<Map<String,Object>> queryOrderHistoryByLimit(int limit);

     int orderHistoryCount();

     Map<String,Object> findOrderById(int orderId);

     int updateOrderInfo(Map<String,Object> map);

}
