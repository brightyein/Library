package com.selfMyBatis.library.mapper;

import com.selfMyBatis.library.dto.BookDto;
import com.selfMyBatis.library.dto.MemberDto;

import java.util.List;
import java.util.Map;

public interface LibraryMapper {
    List<MemberDto> selectAllMember();
    MemberDto selectMemberByNameAndPhone(Map<String, String> parameter);
    List<BookDto> selectAllBook();
    int insertBook(Map<String, String> parameter);
    int insertMember(Map<String, String> parameter);
    int rentBook(Map<String, Integer> inputRentInfo);
    BookDto selectBook(Map<String, String> parameter);
}
