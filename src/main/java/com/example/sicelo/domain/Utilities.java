package com.example.sicelo.domain;

import org.apache.commons.lang3.time.CalendarUtils;
import org.springframework.web.multipart.MultipartFile;

import org.apache.commons.lang3.time.DateUtils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDate;
import java.util.Calendar;
public class Utilities {


    public static final LocalDate TODAY = LocalDate.now();
    public static final LocalDate CURRENT_MONTH = LocalDate.from(TODAY.getMonth());
    public static final LocalDate CURRENT_WEEK = LocalDate.from(TODAY.getDayOfWeek());
    public static final int DAY_OF_YEAR = TODAY.getDayOfYear();

    public static final long FULL_REFUND = 1;
    public static final long HALF_REFUND = 1/2;
    public static final long NO_REFUND = 0;

    public static void saveFile(String uploadDir, String fileName, MultipartFile file) throws IOException {
        Path uploadPath = Paths.get(uploadDir);

        if(!Files.exists(uploadPath)){
            Files.createDirectories(uploadPath);
        }
        try(InputStream inputStream = file.getInputStream()){
            Path filePath = uploadPath.resolve(fileName);
            Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
        }catch (IOException ioe ){
            throw new IOException("Could Not Save File", ioe);
        }
    }

}
