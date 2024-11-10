package com.kevin.gestionhistoriaclinica.util.date;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateParser {
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    public static LocalDate parseDate(String date) {
        try {
            return LocalDate.parse(date, DATE_FORMATTER);
        } catch (Exception e) {
            throw new IllegalArgumentException(
                    "La fecha debe estar en formato dd-MM-yyyy. Valor recibido: " + date);
        }
    }

    public static LocalDate parseDate(LocalDate date) {
        try {
            String formattedDate = date.format(DATE_FORMATTER);
            return LocalDate.parse(formattedDate, DATE_FORMATTER);
        } catch (Exception e) {
            throw new IllegalArgumentException(
                    "La fecha debe estar en formato dd-MM-yyyy. Valor recibido: " + date);
        }
    }
}
