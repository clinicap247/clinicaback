package com.kevin.gestionhistoriaclinica.util.time;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class TimeParser {

    private static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("HH:mm");

    /**
     * Convierte una cadena en formato "HH:mm" a un objeto LocalTime.
     *
     * @param timeString La cadena de tiempo en formato "HH:mm".
     * @return Un objeto LocalTime correspondiente.
     * @throws IllegalArgumentException si el formato es inválido.
     */
    public static LocalTime parseTime(String timeString) {
        try {
            return LocalTime.parse(timeString, TIME_FORMATTER);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("El tiempo debe estar en formato HH:mm. Valor recibido: " + timeString);
        }
    }

    /**
     * Convierte una duración en formato "HH:mm" a minutos totales.
     *
     * @param durationString La cadena de duración en formato "HH:mm".
     * @return La duración en minutos totales.
     * @throws IllegalArgumentException si el formato es inválido.
     */
    public static long parseDurationToMinutes(String durationString) {
        try {
            String[] parts = durationString.split(":");
            if (parts.length == 2) {
                int hours = Integer.parseInt(parts[0]);
                int minutes = Integer.parseInt(parts[1]);
                return hours * 60 + minutes;
            } else {
                throw new IllegalArgumentException("El formato de duración debe ser HH:mm.");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(
                    "El formato de duración debe ser HH:mm. Valor recibido: " + durationString);
        }
    }
}
