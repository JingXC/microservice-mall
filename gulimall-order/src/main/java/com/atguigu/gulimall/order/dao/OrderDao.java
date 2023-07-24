package com.atguigu.gulimall.order.dao;

import com.atguigu.gulimall.order.entity.OrderEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单
 * 
 * @author Jing
 * @email 1210353674@qq.com
 * @date 2023-07-22 06:09:10
 */
@Mapper
public interface OrderDao extends BaseMapper<OrderEntity> {
	
}
