package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MailSteam {

    public static void main(String[] args) throws IOException {
        long start = System.currentTimeMillis();
        long end = start + 60*1000;

        Runtime runtime = Runtime.getRuntime();
        Process process = runtime.exec("top -o uid -s 60"); // you might need the full path
        InputStream is = process.getInputStream();
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);
        String line;
        String[] games = { "Civ", "Terraria", "Kingdoms" };
        String concatenatedLine = "";



        while (((line = br.readLine()) != null) && System.currentTimeMillis() < end) {

            for (String x : games) {
                if (line.contains(x) | line.contains("Mail")){
                    concatenatedLine += line;}


                if (concatenatedLine.contains(x) && concatenatedLine.contains("Mail")) {
                    runtime.exec("killall Mail");
                    break;
                }

            }

        }

    }
}
