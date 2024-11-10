package com.kevin.gestionhistoriaclinica.util.time;

import java.time.Duration;
import java.time.LocalTime;

public class TimeSlotCalculator {
    /**
     * Calcula la cantidad de cupos disponibles en un rango de tiempo.
     *
     * @param startTimeString    Hora de inicio en formato "HH:mm".
     * @param endTimeString      Hora de fin en formato "HH:mm".
     * @param slotDurationString Duración de cada cupo en formato "HH:mm".
     * @return La cantidad de cupos completos que caben en el rango de tiempo.
     * @throws IllegalArgumentException si los parámetros son inválidos.
     */
    public static long calculateSlots(String startTimeString, String endTimeString, Integer slotMinutes) {
        LocalTime startTime = TimeParser.parseTime(startTimeString);
        LocalTime endTime = TimeParser.parseTime(endTimeString);
        Duration duration = Duration.between(startTime, endTime);

        if (duration.isNegative() || duration.isZero()) {
            throw new IllegalArgumentException("El rango de tiempo debe ser válido y mayor a 0 minutos.");
        }

        long totalMinutes = duration.toMinutes();
        // long slotMinutes = TimeParser.parseDurationToMinutes(slotDurationString);

        if (slotMinutes <= 0) {
            throw new IllegalArgumentException("La duración del cupo debe ser mayor a 0.");
        }

        return totalMinutes / slotMinutes;
    }
}
