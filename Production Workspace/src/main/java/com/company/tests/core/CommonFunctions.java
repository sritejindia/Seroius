package com.company.tests.core;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class CommonFunctions {
    /**
     *
     InputStream inputStream = SampleTest.class.getResourceAsStream("/"+value+".xml");
     BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
     StringBuilder stringBuilder = new StringBuilder();
     String line;

     while ((line=bufferedReader.readLine())!=null) {
     stringBuilder.append(line);
     }

     System.out.println(stringBuilder.toString());

     bufferedReader.close();
     */

    public static void log(String message) {
        String tempLog = LocalDateTime.now().toString()
                            .concat(": ")
                            .concat(message);
        String currentDate = LocalDate.now().toString();
        try {
            File file = new File("logs/Log-".concat(currentDate));
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file.getAbsolutePath(),true));
            bufferedWriter.newLine();
            bufferedWriter.write(tempLog);
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
