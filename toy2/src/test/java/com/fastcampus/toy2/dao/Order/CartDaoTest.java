package com.fastcampus.toy2.dao.Order;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class CartDaoTest extends TestCase {
    @Autowired
    CartDao cartDao;

    // 기본 count 테스트
    @Test
    public void testCount() throws Exception {
        cartDao.deleteAll();
        int cnt = cartDao.count();
        assertTrue(cnt == 0);
    }

    public void testDeleteAll() throws Exception {
    }

    public void testInsert() throws Exception {
    }

    public void testUpdate() throws Exception {
    }
}