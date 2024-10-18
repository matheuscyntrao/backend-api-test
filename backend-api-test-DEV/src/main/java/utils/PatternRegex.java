package utils;

import java.time.format.DateTimeFormatter;

public interface PatternRegex {
    String DATE_INSTANT = "\\d{4}-\\d{2}-\\d{2}T\\d{2}:\\d{2}:\\d{2}.\\d+";
    String DATE_YYYY_MM_DDTHH_MM_SS = "\\d{4}-\\d{2}-\\d{2}T\\d{2}:\\d{2}:\\d{2}";
    DateTimeFormatter FORMATTER_DD_MM_YYYY = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    String FAKER_EMAIL = "FakerTeste??????####@gmail.com";

}
