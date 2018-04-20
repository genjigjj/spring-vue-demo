package com.gjj.springvuedemo;

import org.apache.shiro.crypto.hash.Md5Hash;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.io.UnsupportedEncodingException;

/*@RunWith(SpringRunner.class)*/
@SpringBootTest
public class SpringVueDemoApplicationTests {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

	@Test
	public void contextLoads() {
        Md5Hash md5Hash = new Md5Hash("000000","customer",2);
        System.out.println(md5Hash.toString());
	}

	@Test
    public void testRedis(){
        // 保存字符串
        stringRedisTemplate.opsForValue().set("aaa", "1121");
        Assert.assertEquals("111", stringRedisTemplate.opsForValue().get("aaa"));
    }

	@Test
    public void testCode(){
        // 保存字符串
        System.out.println("shiro_redis:admin".getBytes());
        try {
            System.out.println("shiro_redis:admin".getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

}
