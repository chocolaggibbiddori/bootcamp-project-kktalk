package com.kokoa.console;

import java.util.Scanner;

import static com.kokoa.console.Print.printInputId;
import static com.kokoa.console.Print.printInputPassword;

public class Scan {

    private static final Scanner SCANNER = new Scanner(System.in);

    private Scan() {
    }

    public static String getId() {
        printInputId();
        return SCANNER.next();
    }

    public static String getPassword() {
        printInputPassword();
        return SCANNER.next();
    }
}
