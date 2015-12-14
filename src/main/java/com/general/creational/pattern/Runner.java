package com.general.creational.pattern;

import java.io.IOException;

public class Runner {

    public static void main(String[] args) {

        final Reader reader = new Cli(args).parse();
        if (reader != null) {
            try {
                reader.process();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
