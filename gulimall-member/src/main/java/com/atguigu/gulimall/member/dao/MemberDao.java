package com.atguigu.gulimall.member.dao;

import com.atguigu.gulimall.member.entity.MemberEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 会员
 * 
 * @author Jing
 * @email 1210353674@qq.com
 * @date 2023-07-22 06:01:17
 */
@Mapper
public interface MemberDao extends BaseMapper<MemberEntity> {
	
}
