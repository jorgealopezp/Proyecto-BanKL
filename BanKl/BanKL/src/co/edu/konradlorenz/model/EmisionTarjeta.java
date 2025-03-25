package co.edu.konradlorenz.model;

import java.security.SecureRandom;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class EmisionTarjeta {

    private SecureRandom secureRandom;
    private DateTimeFormatter dateTimeFormatter;

    public EmisionTarjeta() {
    }

    public EmisionTarjeta(SecureRandom secureRandom, DateTimeFormatter dateTimeFormatter) {
        this.secureRandom = secureRandom;
        this.dateTimeFormatter = dateTimeFormatter;
    }

    public SecureRandom getSecureRandom() {
        return secureRandom;
    } 

    public void setSecureRandom(SecureRandom secureRandom) {
        this.secureRandom = secureRandom;
    }

    public DateTimeFormatter getDateTimeFormatter() {
        return dateTimeFormatter;
    }

    public void setDateTimeFormatter(DateTimeFormatter dateTimeFormatter) {
        this.dateTimeFormatter = dateTimeFormatter;
    }

    public String generarNumeroTarjeta() {
        StringBuilder numero = new StringBuilder();
        for (int i = 0; i < 16; i++) {
            numero.append(secureRandom.nextInt(10));
        }
        return numero.toString();
    }

    public String asignarFechaExpiracion() {
        LocalDate fecha = LocalDate.now().plusYears(4);
        return fecha.format(dateTimeFormatter);
    }

    public int generarCVV() {
        return 100 + secureRandom.nextInt(900);
    }

}
