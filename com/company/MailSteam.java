package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MailSteam {

    public static void main(String[] args) throws IOException {
        Runtime runtime = Runtime.getRuntime();
        Process process = runtime.exec("top -o uid -s 60"); // you might need the full path
        InputStream is = process.getInputStream();
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);
        String line;
        String concatenatedLine = "";
        int count = 0;

        while ((line = br.readLine()) != null) {

            if(line.contains("Steam") | line.contains("Mail"))concatenatedLine += line;

            if (concatenatedLine.contains("Steam") && concatenatedLine.contains("Mail")) {
                runtime.exec("killall Mail");
                String[] bob = new String[0];
                MailSteam.main(bob);
            }

        }
    }

}
