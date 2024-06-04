package com.selfMyBatis.library.common;

public class PrintResult {

    public void showSuccessMessage(String result) {

        switch (result) {
            case "insert" :
                System.out.println("등록에 성공하였습니다.");
            case "rent" :
                System.out.println("대출이 완료되었습니다.");
        }
    }

    public void showErrorMessage(String result) {

        switch (result) {
            case "insert" :
                System.out.println("등록에 실패하였습니다. 다시 시도해 주세요.");
            case "rent" :
                System.out.println("대출이 정상적으로 진행되지 않았습니다. 다시 시도해 주세요.");
        }
    }
}
