import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import static org.junit.jupiter.api.Assertions.*;

class ATestJunit {

    @Test
    void dateGreaterThanAWeek() {

        assertThrows(IllegalArgumentException.class, () -> {

            MetodosExamen.dateGreaterThanAWeek(null);
        });

        assertThrows(IllegalArgumentException.class, () -> {

            MetodosExamen.dateGreaterThanAWeek(new Date("2001-09-24"));
        });

        assertFalse(MetodosExamen.dateGreaterThanAWeek(new Date(new Date().getTime())));

        Calendar calendar = new GregorianCalendar(2019, 2, 11);
        assertTrue(MetodosExamen.dateGreaterThanAWeek(calendar.getTime()));
    }

    @Test
    void ipAdressType() {

        assertThrows(RuntimeException.class, () -> {

            MetodosExamen.ipAdressType(null, null);
        });

        assertThrows(RuntimeException.class, () -> {

            MetodosExamen.ipAdressType("", "");
        });

        assertThrows(RuntimeException.class, () -> {

            MetodosExamen.ipAdressType("si", "funciona");
        });

        assertThrows(RuntimeException.class, () -> {

            MetodosExamen.ipAdressType(null, "255.255.0.0");
        });

        assertEquals("a", MetodosExamen.ipAdressType("10.0.100.23", "255.0.0.0"));
        assertEquals("a", MetodosExamen.ipAdressType("10.0.100.23", ""));
        assertEquals("a", MetodosExamen.ipAdressType("10.0.100.23", null));
        assertEquals("b", MetodosExamen.ipAdressType("10.0.100.23", "255.255.0.0"));
        assertEquals("c", MetodosExamen.ipAdressType("200.30.110.5", "255.255.255.0"));
        assertEquals("c", MetodosExamen.ipAdressType("200.30.110.5", ""));
        assertEquals("c", MetodosExamen.ipAdressType("200.30.110.5", null));
        assertEquals("c", MetodosExamen.ipAdressType("200.30.110.5/24", ""));

    }

    @Test
    void valueIsDivisibleByNumber() {

        assertThrows(NullPointerException.class, () -> {

            MetodosExamen.valueIsDivisibleByNumber(null, null);
        });

        assertThrows(NullPointerException.class, () -> {

            MetodosExamen.valueIsDivisibleByNumber(BigDecimal.valueOf(5), null);
        });

        assertThrows(NullPointerException.class, () -> {

            MetodosExamen.valueIsDivisibleByNumber(null, BigDecimal.valueOf(5));
        });

        assertThrows(ArithmeticException.class, () -> {

            MetodosExamen.valueIsDivisibleByNumber(BigDecimal.valueOf(0), BigDecimal.valueOf(0));
        });

        assertEquals(BigDecimal.valueOf(1), MetodosExamen.valueIsDivisibleByNumber(BigDecimal.valueOf(5), BigDecimal.valueOf(2)));
        assertEquals(BigDecimal.valueOf(10), MetodosExamen.valueIsDivisibleByNumber(BigDecimal.valueOf(10), BigDecimal.valueOf(14)));
        assertEquals(BigDecimal.valueOf(9), MetodosExamen.valueIsDivisibleByNumber(BigDecimal.valueOf(1500), BigDecimal.valueOf(21)));
    }

}
