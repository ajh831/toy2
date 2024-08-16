package com.fastcampus.toy2.Service.User;

import com.fastcampus.toy2.service.User.SignupService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class SignupServiceTest {

    @Autowired
    SignupService signupService;

//    @Test
//    public void 아이디로찾기테스트() throws Exception {
//        System.out.println(signupService.idCheck("asdf1"));
//    }
}
