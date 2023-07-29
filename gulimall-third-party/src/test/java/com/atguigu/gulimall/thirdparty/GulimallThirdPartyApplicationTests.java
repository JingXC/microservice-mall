package com.atguigu.gulimall.thirdparty;


import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.OSSException;
import com.aliyun.oss.model.PutObjectRequest;
import com.aliyun.oss.model.PutObjectResult;
import com.atguigu.gulimall.thirdparty.component.SmsComponent;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GulimallThirdPartyApplicationTests {

	@Resource
	private OSSClient ossClient;

	@Resource
	private SmsComponent smsComponent;

	@Test
	public void contextLoads() {
// Endpoint以华东1（杭州）为例，其它Region请按实际情况填写。
		String bucketName = "gulimall-jxc";
		// 填写Object完整路径，完整路径中不能包含Bucket名称，例如exampledir/exampleobject.txt。
		String objectName = "example.txt";

		String filePath= "D:\\aaa.txt";


		try {
			InputStream inputStream = new FileInputStream(filePath);
			// 创建PutObjectRequest对象。
			PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, objectName, inputStream);
			// 创建PutObject请求。
			PutObjectResult result = ossClient.putObject(putObjectRequest);
		} catch (OSSException oe) {
			System.out.println("Caught an OSSException, which means your request made it to OSS, "
					+ "but was rejected with an error response for some reason.");
			System.out.println("Error Message:" + oe.getErrorMessage());
			System.out.println("Error Code:" + oe.getErrorCode());
			System.out.println("Request ID:" + oe.getRequestId());
			System.out.println("Host ID:" + oe.getHostId());
		} catch (ClientException ce) {
			System.out.println("Caught an ClientException, which means the client encountered "
					+ "a serious internal problem while trying to communicate with OSS, "
					+ "such as not being able to access the network.");
			System.out.println("Error Message:" + ce.getMessage());
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		} finally {
			if (ossClient != null) {
				ossClient.shutdown();
			}
		}
	}

	@Test
	public void testSms(){
		smsComponent.sendCode("17611017300","66666");
	}

}
