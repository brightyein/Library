package com.selfMyBatis.library;

import com.selfMyBatis.library.controller.LibraryController;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Application {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        LibraryController libraryController = new LibraryController();

        while (true) {
            System.out.println("========== 도서관 ==========");
            System.out.println("0. 회원 가입");
            System.out.println("1. 전체 회원 조회");
            System.out.println("2. 이름과 전화 번호로 회원 조회");
            System.out.println("3. 도서 목록 조회");
            System.out.println("4. 신규 도서 등록");
            System.out.println("5. 도서 대여 하기");
            int no = sc.nextInt();
            sc.nextLine();

            switch (no) {
                case 0 : libraryController.insertMember(inputNewMember()); break;
                case 1 : libraryController.selectAllMember(); break;
                case 2 : libraryController.selectMemberByNameAndPhone(inputNameAndPhone()); break;
                case 3 : libraryController.selectAllBook(); break;
                case 4 : libraryController.insertBook(inputNewBookInfo()); break;
                case 5 : libraryController.rentBook(inputRentInfo()); break;
                default : System.out.println("잘못된 번호를 선택하셨습니다."); break;
            }
        }
    }

    // 조회할 회원의 이름과 연락처 입력 받기
    public static Map<String, String> inputNameAndPhone() {
        Map<String, String> parameter = new HashMap<>();

        System.out.println("조회할 회원의 이름을 입력해 주세요. : ");
        String name = sc.nextLine();
        parameter.put("name", name);

        System.out.println("조회할 회원의 전화번호를 입력해 주세요. : ");
        String phone = sc.nextLine();
        parameter.put("phone", phone);

        return parameter;
    }

    // 신규 도서 정보 입력 받기
    public static Map<String, String> inputNewBookInfo() {
        Map<String, String> parameter = new HashMap<>();

        System.out.println("등록하실 책 제목을 입력해 주세요. : ");
        String title = sc.nextLine();
        parameter.put("title", title);

        System.out.println("등록하실 책의 작가 이름을 입력해 주세요. : ");
        String author = sc.nextLine();
        parameter.put("author", author);

        System.out.println("등록하실 책의 출판사를 입력해 주세요. : ");
        String publisher = sc.nextLine();
        parameter.put("publisher", publisher);

        int barcode = (int)((Math.random()*999999999)+1);
        parameter.put("barcode", "LIB" + barcode);

        return parameter;
    }

    // 회원가입 정보 받기
    public static Map<String, String> inputNewMember() {
        Map<String, String> parameter = new HashMap<>();

        System.out.println("가입을 시작합니다. \n이름을 입력해 주세요.");
        String name = sc.nextLine();
        parameter.put("name" , name);

        System.out.println("전화번호를 '-' 포함하여 입력해주세요. : ");
        String phone = sc.nextLine();
        parameter.put("phone", phone);

        return parameter;
    }

    // 회원 이름, 연락처와 책 바코드 정보 입력받기 (대여)
    public static Map<String, String> inputRentInfo() {
        Map<String, String> parameter = new HashMap<>();

        System.out.println("도서 대출을 시작합니다. \n회원님의 이름을 입력해 주세요. : ");
        String name = sc.nextLine();
        parameter.put("name" , name);

        System.out.println("회원님의 연락처를 입력해 주세요. : ");
        String phone = sc.nextLine();
        parameter.put("phone", phone);

        System.out.println("대출을 원하시는 도서의 바코드를 입력해 주세요. : ");
        String barcode = sc.nextLine();
        parameter.put("barcode" , barcode);

        return parameter;
    }
}
