//package com.sample.choc2;
//
//import org.junit.Assert;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//import com.sample.choc2.service.domain.User;
//import com.sample.choc2.service.user.UserService;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//
//@ContextConfiguration	(locations = {	"classpath:config/context-common.xml",
//											"classpath:config/context-mybatis.xml",
//												"classpath:config/context-mybatis.xml"	})
//public class UserServiceTest {
//
//	@Autowired
//	@Qualifier("userServiceImpl")
//	private UserService userService;
//
//	@Test
//	public void testGetUser() throws Exception {
//		
//		User user = new User();
//			user.setUserId("user");
//			user.setPassword("4321");
//		
//		user = userService.getUser(user.getUserId());
//		
//		Assert.assertEquals("user", user.getUserId());
//		Assert.assertEquals("4321", user.getPassword());
//
//		Assert.assertNotNull(userService.getUser("user"));
//	}
//	 
//	 
//}       