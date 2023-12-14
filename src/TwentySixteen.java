import java.time.LocalDate;

public class TwentySixteen {

    public String solution(int a, int b) {
        LocalDate localDate = LocalDate.of(2016, a, b);
        return String.valueOf(localDate.getDayOfWeek()).substring(0,3);
    }

}
