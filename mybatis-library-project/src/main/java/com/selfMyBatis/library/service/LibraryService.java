package com.selfMyBatis.library.service;

import com.selfMyBatis.library.common.PrintResult;
import com.selfMyBatis.library.dto.BookDto;
import com.selfMyBatis.library.dto.MemberDto;
import com.selfMyBatis.library.mapper.LibraryMapper;
import org.apache.ibatis.session.SqlSession;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.selfMyBatis.library.common.Template.getSqlSession;

public class LibraryService {

    private LibraryMapper libraryMapper;

    public boolean insertMember(Map<String, String> parameter) {

        SqlSession sqlSession = getSqlSession();

        libraryMapper = sqlSession.getMapper(LibraryMapper.class);

        int result = libraryMapper.insertMember(parameter);

        if (result>0) {
            sqlSession.commit();
        } else sqlSession.rollback();

        sqlSession.close();

        return result > 0? true:false;
    }

    // 전체 회원 조회
    public List<MemberDto> selectAllMember() {

        // sqlSession 생성
        SqlSession sqlSession = getSqlSession();

        // 사용할 매퍼 초기화
        libraryMapper = sqlSession.getMapper(LibraryMapper.class);

        // 매퍼를 통해 가져온 정보를 리스트에 담는다
        List<MemberDto> memberList = libraryMapper.selectAllMember();

        // 세션을 닫는다
        sqlSession.close();

        return memberList;
    }

    public MemberDto selectMemberByNameAndPhone(Map<String, String> parameter) {

        SqlSession sqlSession = getSqlSession();

        libraryMapper = sqlSession.getMapper(LibraryMapper.class);

        MemberDto member = libraryMapper.selectMemberByNameAndPhone(parameter);

        sqlSession.close();

        return member;
    }


    public List<BookDto> selectAllBook() {

        SqlSession sqlSession = getSqlSession();
        libraryMapper = sqlSession.getMapper(LibraryMapper.class);

        List<BookDto> bookList = libraryMapper.selectAllBook();

        sqlSession.close();

        return bookList;
    }

    public boolean insertBook(Map<String, String> parameter) {

        SqlSession sqlSession = getSqlSession();
        libraryMapper = sqlSession.getMapper(LibraryMapper.class);

        int result = libraryMapper.insertBook(parameter);

        if (result > 0) {
            sqlSession.commit();
        } else sqlSession.rollback();

        sqlSession.close();

        return result > 0? true:false;
    }

    public boolean rentBook(Map<String, String> inputRentInfo) {

        SqlSession sqlSession = getSqlSession();
        libraryMapper = sqlSession.getMapper(LibraryMapper.class);

        // 1. 회원정보(이름, 번호) 로 멤버 아이디 찾기
        MemberDto member = libraryMapper.selectMemberByNameAndPhone(inputRentInfo);
        int memberId = member.getCode();

        // 2. 바코드로 책 아이디 찾기
        BookDto book = libraryMapper.selectBook(inputRentInfo);
        int bookId = book.getBookId();

        Map<String, Integer> map = new HashMap<>();
        map.put("memberId", memberId);
        map.put("bookId", bookId);

        int result = libraryMapper.rentBook(map);

        if (result > 0) {
            sqlSession.commit();
        } else sqlSession.rollback();

        sqlSession.close();

        return result > 0? true:false;
    }
}
