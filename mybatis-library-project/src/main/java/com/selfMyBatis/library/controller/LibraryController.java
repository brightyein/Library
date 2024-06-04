package com.selfMyBatis.library.controller;

import com.selfMyBatis.library.common.PrintResult;
import com.selfMyBatis.library.dto.BookDto;
import com.selfMyBatis.library.dto.MemberDto;
import com.selfMyBatis.library.service.LibraryService;

import java.util.List;
import java.util.Map;

public class LibraryController {

    PrintResult printResult = new PrintResult();

    LibraryService libraryService = new LibraryService();

    // 전체 회원 조회
    public void selectAllMember() {
        List<MemberDto> memberList = libraryService.selectAllMember();

        for (MemberDto member : memberList) {
            System.out.println(member);
        }
    }

    // 이름과 번호로 회원 조회
    public void selectMemberByNameAndPhone(Map<String, String> parameter) {

        MemberDto member = libraryService.selectMemberByNameAndPhone(parameter);
        System.out.println(member);
    }

    // 모든 도서 목록 조회
    public void selectAllBook() {

        List<BookDto> booKList = libraryService.selectAllBook();

        for (BookDto book : booKList) {
            System.out.println(book);
        }
    }

    // 책 등록 메서드
    public void insertBook(Map<String, String> parameter) {

        boolean isSuccess = libraryService.insertBook(parameter);

        if (isSuccess) {
            printResult.showSuccessMessage("insert");
        } else printResult.showErrorMessage("insert");
    }

    public void insertMember(Map<String, String> parameter) {

        boolean isSuccess = libraryService.insertMember(parameter);

        if (isSuccess) {
            printResult.showSuccessMessage("insert");
        } else printResult.showErrorMessage("insert");
    }

    public void rentBook(Map<String, String> inputRentInfo) {

        boolean isSuccess = libraryService.rentBook(inputRentInfo);

        if (isSuccess) {
            printResult.showSuccessMessage("rent");
        } else printResult.showErrorMessage("rent");
    }
}
