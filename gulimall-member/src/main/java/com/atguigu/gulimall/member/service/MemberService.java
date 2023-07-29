package com.atguigu.gulimall.member.service;

import com.atguigu.common.utils.PageUtils;
import com.atguigu.common.vo.MemberResponseVo;
import com.atguigu.gulimall.member.entity.MemberEntity;
import com.atguigu.gulimall.member.exception.PhoneException;
import com.atguigu.gulimall.member.exception.UsernameException;
import com.atguigu.gulimall.member.vo.MemberUserLoginVo;
import com.atguigu.gulimall.member.vo.MemberUserRegisterVo;
import com.baomidou.mybatisplus.extension.service.IService;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * 会员
 *
 * @author Jing
 * @email 1210353674@qq.com
 * @date 2023-07-22 06:01:17
 */
public interface MemberService extends IService<MemberEntity> {

    PageUtils queryPage(Map<String, Object> params);

    void register(MemberUserRegisterVo vo);

    /**
     * 判断邮箱是否重复
     *
     * @param phone
     * @return
     */
    void checkPhoneUnique(String phone) throws PhoneException;

    /**
     * 判断用户名是否重复
     *
     * @param userName
     * @return
     */
    void checkUserNameUnique(String userName) throws UsernameException;

    MemberResponseVo login(MemberUserLoginVo vo);
}

