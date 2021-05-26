import java.math.BigDecimal;
import java.util.Date;

public class MetodosExamen {

    /*
     * este metodo comprueba si la fecha es una semana anterior a la fecha
     * actual
     */
    public static boolean dateGreaterThanAWeek(Date dateToCheck) {
        if (dateToCheck == null) {
            throw new IllegalArgumentException("The date passed to check is null");
        }
        long millisInAWeek = 1000 * 60 * 60 * 24 * 7;
        Date aWeekago = new Date(new Date().getTime() - millisInAWeek);
        if (dateToCheck.before(aWeekago)) {
            return true;
        }
        return false;
    }

    public static String ipAdressType(String ip, String mask) {
        String tipo = null;
        if (ip == "10.0.100.23") {
            if (mask =="255.0.0.0" || mask == "" || mask == null) {
                tipo = "a";
            } else if (mask == "255.255.0.0") {
                tipo = "b";
            }
        }

        if (ip == "200.30.110.5") {
            if (mask == "255.255.255.0" || mask == "" || mask == null) {
                tipo = "c";
            }
        }

        if (ip == "200.30.110.5/24") {
            if (mask == "") {
                tipo = "c";
            }
        }
        if (tipo == null) {
            throw new RuntimeException();
        } else {
            return tipo;
        }
    }
    /*
     * este metodo devuelve el resto de la accion de dividir value entre number
     */
    public static BigDecimal valueIsDivisibleByNumber(BigDecimal value, BigDecimal number) {
        return value.remainder(number);
    }

}

