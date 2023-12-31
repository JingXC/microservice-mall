package com.atguigu.gulimall.product.service;

import com.atguigu.gulimall.product.vo.SpuSaveVo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.atguigu.common.utils.PageUtils;
import com.atguigu.gulimall.product.entity.SpuInfoEntity;

import java.util.Map;

/**
 * spu信息
 *
 * @author Jing
 * @email 1210353674@qq.com
 * @date 2023-07-22 04:31:44
 */
public interface SpuInfoService extends IService<SpuInfoEntity> {

    PageUtils queryPage(Map<String, Object> params);

    void savesupInfo(SpuSaveVo spuInfo);

    void saveBaseSpuInfo(SpuInfoEntity spuInfoEntity);

    PageUtils queryPageByCondtion(Map<String, Object> params);

    void up(Long spuId);

    SpuInfoEntity getSpuInfoBySkuId(Long skuId);
}

