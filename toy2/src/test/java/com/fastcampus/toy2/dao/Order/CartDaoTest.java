package com.fastcampus.toy2.dao.Order;

import com.fastcampus.toy2.domain.Order.CartDto;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class CartDaoTest extends TestCase {
    @Autowired
    CartDaoImpl cartDao;

    @Before
    public void setUp() throws Exception {
        cartDao.deleteAll();
        int cnt = cartDao.count();
        assertTrue(cnt == 0);
    }

    // 테이블 내용 전부 다 지우는 테스트
    @Test
    public void testDeleteAll() throws Exception {
        cartDao.deleteAll();
        int cnt = cartDao.count();
        assertTrue(cnt == 0);
    }

    @Test
    public void testInsert() throws Exception {
//        1. 주문을 장바구니에 담는다.
//        2. 장바구니 번호를 생성하기 위해서 오늘날짜의 장바구니명(CT) + 년월일 + 번호(번호는 해당하는 연원일에 순서대로)를 붙여준다.
//          - CT + 20240808 + 00001
        String crt_id = "CT2024080300001";
        String mbr_id = "asdf123";

        CartDto cartDto = new CartDto.Builder()
                .crt_id(crt_id)
                .mbr_id(mbr_id)
                .build();

        int cnt = cartDao.insert(cartDto);
        assertTrue(cnt == 1);

//      insert 한 값을 select해서 제대로 들어갔는지 확인
        CartDto cartDto2 = cartDao.selectCartId(crt_id);

        System.out.println(cartDto2);

        assertTrue(cartDto2.getCrt_id().equals(crt_id));

    }

//    insert되어 있는 id의 상태를 변경
    @Test
    public void testUpdate() throws Exception {
        testInsert();

        String crt_id = "CT2024080300001";

        CartDto cartDto = cartDao.selectCartId(crt_id);

//      장바구니가 삭제되었다고 할 때 update로 상태가 변경되는 경우
        int cnt = cartDao.update(crt_id);
        assertTrue(cnt == 1);

        CartDto cartDto2 = cartDao.selectCartId(crt_id);
        assertTrue(cartDto2.getCrt_st() == 'N');
    }

    @Test
    public void testMaxCartSeqNull() throws Exception {
        testInsert();

        // 현재 날짜 가져오기
        LocalDate currentDate = LocalDate.now();

        // 날짜를 "yyyyMMdd" 형식으로 포맷하기
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        String formattedDate = currentDate.format(formatter);
        System.out.println(formattedDate);

        // 현재 날짜에 존재하는 장바구니 최대 번호 구하기
        // null값을 반환하는 경우 해당 날짜에 장바구니가 존재하지 않는 것임
        String maxCartSeq = cartDao.maxCartSeq("CT" + formattedDate);
        System.out.println(maxCartSeq);
        assertNull(maxCartSeq);
    }

    @Test
    public void testMaxCartSeqNotNull() throws Exception {
        testInsert();

        // insert한 데이터로 확인
        String crt_id = "CT2024080300001";
        String datePart = crt_id.substring(0,10);
        System.out.println(datePart);

        // 존재하는 장바구니의 최대 번호 구하기
        String maxCartSeq = cartDao.maxCartSeq(datePart);
        System.out.println(maxCartSeq);
        assertNotNull(maxCartSeq);
    }


    // 고객의 활성상태 장바구니가 존재하는지 확인
    @Test
    public void testUserCartActive() throws Exception {
        testInsert();

        String mbr_id = "asdf123";

        CartDto cartDto = cartDao.selectUserCartActive(mbr_id);
        assertNotNull(cartDto);
        assertEquals(cartDto.getMbr_id(), mbr_id);
    }
}