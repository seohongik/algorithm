package programus;

public class VideoPlayer {

    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {

        int start = timeToSec(pos);
        int video = timeToSec(video_len);
        int opingStart = timeToSec(op_start);
        int opingEnd = timeToSec(op_end);
        int posStart=checkOpening(start,opingStart,opingEnd);

        for (int i = 0; i < commands.length; i++) {

            if (commands[i].equals("next")) {
                posStart += 10;
                if (posStart > video) posStart = video;
            } else if (commands[i].equals("prev")) {
                posStart -= 10;
                if (posStart < 0) posStart = 0;
            }

            posStart=checkOpening(posStart,opingStart,opingEnd);

        }
        return secToTime(posStart);
    }

    private int timeToSec(String time) {
        String[] split = time.split(":");
        return Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
    }

    private String secToTime(int sec) {
        int m = sec / 60;
        int s = sec % 60;
        return String.format("%02d:%02d", m, s);
    }

    private int checkOpening(int current, int start, int end) {
        if (current >= start && current <= end) {
            return end;
        }
        return current;
    }

    public static void main(String[] args) {
        VideoPlayer sol = new VideoPlayer();

        System.out.println("--- 테스트 결과 ---");

        // 테스트 1: 일반적인 케이스
        System.out.println("Test 1: " + sol.solution("34:33", "13:00", "00:55", "02:55", new String[]{"next", "prev"}));
        // 예상 결과: "13:00"

        // 테스트 2: 오프닝 시작점에 걸린 경우 (데이터셋 1번)
        System.out.println("Test 2: " + sol.solution("05:20", "00:05", "00:05", "00:30", new String[]{"next"}));
        // 예상 결과: "00:40"

        // 테스트 3: 이동 후 오프닝 진입 (데이터셋 2번)
        System.out.println("Test 3: " + sol.solution("30:00", "01:55", "02:00", "03:00", new String[]{"next"}));
        // 예상 결과: "03:00"

        // 테스트 4: 0초 미만 처리 (데이터셋 3번)
        System.out.println("Test 4: " + sol.solution("10:00", "00:05", "05:00", "05:10", new String[]{"prev"}));
        // 예상 결과: "00:00"


        System.out.println(sol.solution("34:33",	"13:00",	"00:55",	"02:55"	,new String[]{"next", "prev"}));//"13:00"
        System.out.println(sol.solution("10:55",	"00:05",	"00:15"	,"06:55"	,new String[]{"prev", "next", "next"}));//"06:55"
        System.out.println(sol.solution("07:22"	,"04:05",	"00:15"	,"04:07",	new String[]{"next"}));//"04:17"


    }

}
