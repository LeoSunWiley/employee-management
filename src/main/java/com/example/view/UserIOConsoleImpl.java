package com.example.view;

import java.math.BigDecimal;
import java.util.Scanner;

import org.springframework.stereotype.Component;

@Component
public class UserIOConsoleImpl implements UserIO {

    Scanner scanner = new Scanner(System.in);

    @Override
    public void print(String msg) {
        System.out.println(msg);
    }

    @Override
    public int readInt(String prompt) {
        System.out.println(prompt);
        int returnValue = Integer.parseInt(scanner.nextLine());
        return returnValue;
    }

    @Override
    public int readInt(String prompt, int min, int max) {
        do {
            System.out.println(prompt);
            int returnValue = Integer.parseInt(scanner.nextLine());
            if (returnValue >= min && returnValue <= max) {
                return returnValue;
            }
        } while (true);
    }

    @Override
    public BigDecimal readBigDecimal(String prompt) {
        System.out.println(prompt);
        BigDecimal returnValue = BigDecimal.valueOf(Double.parseDouble(scanner.nextLine()));
        return returnValue;
    }

    @Override
    public String readString(String prompt) {
        System.out.println(prompt);
        return scanner.nextLine();
    }

}
