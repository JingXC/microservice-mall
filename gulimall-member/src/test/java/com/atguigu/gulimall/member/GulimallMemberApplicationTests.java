package com.atguigu.gulimall.member;

import com.atguigu.common.vo.MemberResponseVo;
import com.atguigu.gulimall.member.entity.MemberEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeanUtils;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GulimallMemberApplicationTests {

	@Test
	public void contextLoads() {

		MemberEntity memberEntity = new MemberEntity();
		memberEntity.setMobile("11111111");
		memberEntity.setNickname("jxc");
		MemberResponseVo memberResponseVo = new MemberResponseVo();
		BeanUtils.copyProperties(memberEntity,memberResponseVo);
		System.out.println(memberResponseVo);

	}

}
