package com.atguigu.gulimall.coupon.dao;

import com.atguigu.gulimall.coupon.entity.CouponEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 优惠券信息
 * 
 * @author Jing
 * @email 1210353674@qq.com
 * @date 2023-07-22 05:53:11
 */
@Mapper
public interface CouponDao extends BaseMapper<CouponEntity> {
	
}
