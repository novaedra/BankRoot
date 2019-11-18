package com.utils.database;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Backup {
    public Backup() {
        {
            try {
                LocalDateTime myDateObj = LocalDateTime.now();
                DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy-HH-mm-ss");

                String formattedDate = myDateObj.format(myFormatObj);
                LocalTime myObj = LocalTime.now();
                String t1 = myObj.toString();
                System.out.println("t1 :" + t1.substring(0, 8));
                LocalTime bu1 = LocalTime.of(18, 29, 00);
                String t2 = bu1.toString();
                System.out.println("t2 :" + t2);
                if (t1.substring(0, 8).equals(t2)) {
                    System.out.println(t1.substring(0, 8));
                    System.out.println(t2);

                    // /K : Carries out command specified by string
                    Runtime.getRuntime().exec(new String[]{"cmd", "/K", "pg_dump.exe --host localhost --port 5432 --username   postgres --format tar --blobs --verbose --file \"C:\\Users\\MathD\\Documents\\Project\\db-backup" + formattedDate + ".tar\" bankroot"});
                }

            } catch (Exception e) {
                System.out.println("HEY Buddy ! U r Doing Something Wrong ");
                e.printStackTrace();
            }
        }
    }
}