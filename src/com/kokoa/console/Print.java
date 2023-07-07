package com.kokoa.console;

import static java.lang.Thread.sleep;

public class Print {

    private Print() {
    }

    public static void printStartMessage() {
        System.out.println("==========로그인==========");
    }

    public static void printInputId() {
        System.out.print("ID : ");
    }

    public static void printInputPassword() {
        System.out.print("PW : ");
    }

    public static void printLoginFail() {
        System.out.println("아이디 혹은 비밀번호가 일치하지 않습니다.");
    }

    public static void printLoggingIn() {
        new Thread(() -> {
            try {
                System.out.print("로그인 중입니다.");
                sleep(1000L);
                System.out.print("\t.");
                sleep(1000L);
                System.out.println("\t.");
                sleep(1000L);
                System.out.println("로그인 성공!!!");
            } catch (InterruptedException e) {
                e.printStackTrace();
                throw new IllegalThreadStateException();
            }
        }).start();
    }
}
