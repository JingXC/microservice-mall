package com.atguigu.gulimall.ware.dao;

import com.atguigu.gulimall.ware.entity.WareSkuEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 商品库存
 * 
 * @author Jing
 * @email 1210353674@qq.com
 * @date 2023-07-22 06:14:48
 */
@Mapper
public interface WareSkuDao extends BaseMapper<WareSkuEntity> {

    Long getSkuStock(Long item);

    /**
     * 添加入库信息
     * @param skuId
     * @param wareId
     * @param skuNum
     */
    void addStock(@Param("skuId") Long skuId, @Param("wareId") Long wareId, @Param("skuNum") Integer skuNum);

    List<Long> listWareIdHasSkuStock(@Param("skuId") Long skuId);

    /**
     * 锁定库存
     * @param skuId
     * @param wareId
     * @param num
     * @return
     */
    Long lockSkuStock(@Param("skuId") Long skuId, @Param("wareId") Long wareId, @Param("num") Integer num);

    /**
     * 解锁库存
     * @param skuId
     * @param wareId
     * @param num
     */
    void unLockStock(@Param("skuId") Long skuId, @Param("wareId") Long wareId, @Param("num") Integer num);
}
