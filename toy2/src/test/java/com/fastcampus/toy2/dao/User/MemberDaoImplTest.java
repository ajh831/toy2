package com.fastcampus.toy2.dao.User;

import com.fastcampus.toy2.domain.User.MemberDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class MemberDaoImplTest {
    @Autowired
    MemberDao memberDao;

    // 성공 케이스
    // 실패 케이스

    @Test
    public void selectMemberIdTest() throws Exception {
        memberDao.deleteAll();
        assertTrue(memberDao.count()==0);
        MemberDto memberDto = getTestMemberDto();
        assertTrue(memberDao.memberSignup(memberDto)==1);
        assertTrue(memberDao.selectMemberId("aaaaa1").equals("aaaaa1"));
    }

    @Test
    public void selectMemberInfoTest() throws Exception {
        memberDao.deleteAll();
        assertTrue(memberDao.count()==0);

        List<MemberDto> list = new ArrayList<>();
        for(int i=1; i<=500; i++){
            list.add(getTestMemberDtoIndex(i));
            memberDao.memberSignup(list.get(i));
        }
        assertTrue(memberDao.count()==list.size());
        MemberDto test = memberDao.selectMemberInfo(list.get(0).getMbr_id());
        assertTrue((test.getName()).equals(list.get(0).getName()));
    }//리스트에 담아서 하기

    @Test
    public void selectAllMembersTest() throws Exception {
        memberDao.deleteAll();
        assertTrue(memberDao.count()==0);
        // (문제점) map을 파라미터타입으로 받을 때, 어떻게 값을 넘겨주어야 하는지 모르겠다.
        // 아래의 내용처럼 해봤지만, 'memberDao.selectAllMembers(sortBy)' 이 부분이 null로 들어가는 것 같다.
        // 원인을 모르겠어서 selectOneMemberTest까지 테스트 진행 못 함
        // (해결방법1) list로 반환하기 때문에 Dao에서 List 타입으로 받아야 함. MemberDto -> List<MemberDto>로 수정
        // (해결방법2) daoImpl에서 selectOne()이 아닌 selectList()로 실행해야 함. selectOne() -> selectList() 로 수정

        // 데이터가 없을 때 list.isEmpty() 이어야 함
        Map<String, Object> sortBy = new HashMap<>();
        sortBy.put("sortBy", "birth");
        List<MemberDto> list = (List<MemberDto>) memberDao.selectAllMembers(sortBy);
        assertTrue(list.isEmpty());

        for(int i=1; i<=9; i++){
            MemberDto memberDto = getTestMemberDtoIndex(i);
            memberDao.memberSignup(memberDto);
        }
        assertTrue(memberDao.count()==9);
        list = (List<MemberDto>) memberDao.selectAllMembers(sortBy);
        assertTrue(list.size()==9);

        MemberDto memberDto = getTestMemberDto();
        memberDao.memberSignup(memberDto);
        assertTrue(memberDao.count()==10);
        list = (List<MemberDto>) memberDao.selectAllMembers(sortBy);
        assertTrue(list.size()==10);
        // sortBy 기준대로 정렬됐는지 확인
        assertTrue(list.get(0).getName().equals("name1"));
        assertTrue(list.get(5).getName().equals("name6"));
        assertTrue(list.get(9).getName().equals("name10"));
    }

    @Test
    public void selectMembersTest() throws Exception {
        memberDao.deleteAll();
        assertTrue(memberDao.count()==0);
        Map<String, Object> sortBy = new HashMap<>();
        sortBy.put("sortBy", "name");
        sortBy.put("mbr_status_cd", "1");
        List<MemberDto> list = (List<MemberDto>) memberDao.selectAllMembers(sortBy);
        assertTrue(list.isEmpty());

        for(int i=9; i>=0; i--) {
            MemberDto memberDto = getTestMemberDtoIndex(i);
            memberDao.memberSignup(memberDto);
//            System.out.println(memberDto.getName());
        }
        assertTrue(memberDao.count()==10);
        list = (List<MemberDto>) memberDao.selectAllMembers(sortBy);
        assertTrue(list.size()==10);
        assertTrue(list.get(0).getName().equals("name0"));
        assertTrue(list.get(9).getName().equals("name9"));
        // (문제점) 현재 2가지 기준 중에서 1가지(정렬기준)만 적용됨
        // (해결하고 싶은 점) 기준 2가지(회원상태 기준과 정렬 기준)를 모두 적용하려면 어떻게 해야하는지?
        // (예측) 회원상태(mbr_status_cd)기준은 map에 담긴 내용으로 if문 실행 여부가 결정될 것이고,
        //       정렬 기준에 대한 내용도 map에 담긴 내용대로 정렬이 될 것이다!
        //       즉, 두 가지 기준 모두 map에 담으면 작동될 것이라고 예측해 봄.
        // (시도해야 하는 것) 회원 상태의 default 값이 1이므로, 일부 회원의 상태 코드를 바꿔준 뒤, 상태값에 따른 조회 시도
        //
    }

    @Test
    public void selectOneMemberTest() throws Exception {
        memberDao.deleteAll();
        assertTrue(memberDao.count()==0);

        for(int i=1; i<=9; i++){
            MemberDto memberDto = getTestMemberDtoIndex(i);
            memberDao.memberSignup(memberDto);
        }
        assertTrue(memberDao.count()==9);

        Map<String, Object> searchKeyword = new HashMap<>();
        searchKeyword.put("mbr_id", "aaaaa3");  //'a'를 검색한다면 a가 포함된 id도 조회되어야 함 (like)
        searchKeyword.put("name", null);
        searchKeyword.put("birth", null);
        MemberDto memberDto = memberDao.selectOneMember(searchKeyword);
        assertTrue(memberDto.getMbr_id().equals("aaaaa3")); //contain
    }

    @Test
    public void count() throws Exception {
        memberDao.deleteAll();
        assertTrue(memberDao.count()==0);

        MemberDto memberDto = new MemberDto("aaaaa1","123456a!","name","2024-08-15","F","01011111111","email");
        assertTrue(memberDao.memberSignup(memberDto)==1);
        assertTrue(memberDao.count()==1);

        memberDto = new MemberDto("aaaaa2","123456a!","name","2024-08-15","F","01011111111","email");
        assertTrue(memberDao.memberSignup(memberDto)==1);
        assertTrue(memberDao.count()==2);
    }

    @Test
    public void memberSignup() throws Exception {
        memberDao.deleteAll();
        assertTrue(memberDao.count()==0);
        // 1명 회원가입 했을 때
        MemberDto memberDto = getTestMemberDto();
        System.out.println(memberDto);
        assertTrue(memberDao.memberSignup(memberDto)==1);
        MemberDto testDto = memberDao.selectMemberInfo(memberDto.getMbr_id());
        assertEquals(testDto, memberDto);
        // birth말고 unique값인 pk값으로 비교하기

        memberDao.deleteAll();
        assertTrue(memberDao.count()==0);
        // n명 회원가입 했을 때
        for(int i=1; i<=9; i++){
            memberDto = getTestMemberDtoIndex(i);
            assertTrue(memberDao.memberSignup(memberDto)==1);
            testDto = memberDao.selectMemberInfo(memberDto.getMbr_id());
            assertEquals(testDto, memberDto);
        }
    }

    @Test
    public void updateMember() throws Exception {
        memberDao.deleteAll();
        assertTrue(memberDao.count()==0);
        // 회원 정보 생성
        MemberDto memberDto = new MemberDto("aaaaa1","123456a!","name","2024-08-15","F","01011111111","email");
        memberDao.memberSignup(memberDto);
        assertTrue(memberDao.count()==1);
        // 회원 정보 수정 ( update문 수정 필요 )
        memberDao.updateMember(memberDto);
        memberDto.setPhone_num("99999999999");
        memberDto.setBirth("2024-01-01");
        assertTrue(memberDao.updateMember(memberDto)==1);
        // 기존 내용과 다른지 확인
        assertTrue(!(memberDto.getBirth().equals("2024-08-15")));
        assertTrue(!(memberDto.getPhone_num().equals("01011111111")));
        // 변경된 내용과 같은지 확인
        assertTrue(memberDto.getBirth().equals("2024-01-01"));
        assertTrue(memberDto.getPhone_num().equals("99999999999"));
        assertTrue(memberDao.count()==1);
    }

    @Test
    public void updateAdmin() throws Exception {
        memberDao.deleteAll();
        assertTrue(memberDao.count()==0);
        // 회원 정보 생성
        MemberDto memberDto = new MemberDto("aaaaa1","123456a!","name","2024-08-15","F","01011111111","email");
        memberDao.memberSignup(memberDto);
        assertTrue(memberDao.count()==1);
        // 회원 정보 수정 ( update문으로 수정 필요 )
        memberDao.updateMember(memberDto);
        memberDto.setEmail("test");
        memberDto.setPhone_num("99999999999");
        memberDto.setUpdated_id("관리자");
        // 기존 내용과 다른지 확인
        assertTrue(!(memberDto.getEmail().equals("email")));
        assertTrue(!(memberDto.getPhone_num().equals("01011111111")));
        assertTrue(!(memberDto.getUpdated_id().equals("updator")));
        // 변경된 내용과 같은지 확인
        assertTrue(memberDto.getEmail().equals("test"));
        assertTrue(memberDto.getPhone_num().equals("99999999999"));
        assertTrue(memberDto.getUpdated_id().equals("관리자"));
        assertTrue(memberDao.count()==1);
    }

    @Test
    public void setMemberStatus() throws Exception {
        memberDao.deleteAll();
        assertTrue(memberDao.count()==0);

        MemberDto memberDto = getTestMemberDto();
        assertTrue(memberDao.memberSignup(memberDto)==1);
        assertTrue(memberDao.count()==1);

//        memberDao.setMemberStatus()
    }



    @Test
    public void delete() throws Exception {
        memberDao.deleteAll();
        assertTrue(memberDao.count()==0);

        MemberDto memberDto = getTestMemberDto();
        assertTrue(memberDao.memberSignup(memberDto)==1);
        assertTrue(memberDao.count()==1);

        assertTrue(memberDao.delete(memberDto.getMbr_id())==1);
        assertTrue(memberDao.count()==0);
    }

    @Test
    public void deleteAll() throws Exception {
        memberDao.deleteAll();
        assertTrue(memberDao.count()==0);

        for(int i=1; i<=9; i++) {
            MemberDto memberDto = getTestMemberDtoIndex(i);
            assertTrue(memberDao.memberSignup(memberDto)==1);
        }
        assertTrue(memberDao.count()==9);
        // 왜 1이 아닌 9로 들어가는지 의문? // (이유) 반환타입이 int라서 //list 사용. list.size()
        assertTrue(memberDao.deleteAll()==9);
        assertTrue(memberDao.count()==0);
    }


    // Dto 1개 생성
    MemberDto getTestMemberDto(){
        return new MemberDto("aaaaa1","123456a!","name","2024-08-15","F","01011111111","email");
    }
    // Dto n개 생성
    MemberDto getTestMemberDtoIndex(int i) {
        MemberDto memberDto = new MemberDto("aaaaa"+i,"111111a!","name"+i, "2024-01-0"+i,"F","01011111111","email");
        return memberDto;
    }

}