import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {


        NoElaborateKeyMap noElaborateKeyMap = new NoElaborateKeyMap();

        noElaborateKeyMap.solution(new String[]{"ABACD", "BCEFD"} , new String[]{"ABCD","AZB","AABB"} );

    }

}
