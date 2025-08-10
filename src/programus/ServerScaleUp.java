package programus;
import java.util.*;

class Server implements Comparable<Server> {
    int endTime;
    Server(int startTime, int k) {
        this.endTime = startTime + k;
    }
    @Override
    public int compareTo(Server o) {
        return Integer.compare(this.endTime, o.endTime);
    }

    @Override
    public String toString() {
        return "Server{" +
                "endTime=" + endTime +
                '}';
    }
}

class ServerManager {
    private final PriorityQueue<Server> pq = new PriorityQueue<>();
    private final int m;
    private final int k;
    private int totalExpansions = 0;
    private final List<Integer> firstInstallTimes = new ArrayList<>();
    public ServerManager(int m, int k) {
        this.m = m;
        this.k = k;
    }

    public void process(int time, int players) {
        // 1. 만료된 서버 제거
        while (!pq.isEmpty() && pq.peek().endTime <= time) {
            pq.poll();
        }

        // 2. 필요한 서버 수 계산
        int need = players / m;

        // 3. 부족하면 증설
        while (pq.size() < need) {
            pq.add(new Server(time, k));
            totalExpansions++;
            firstInstallTimes.add(time);
        }
    }

    public List<Integer> getFirstInstallTimes() {
        return firstInstallTimes;
    }

    public int getTotalExpansions() {
        return totalExpansions;
    }

    @Override
    public String toString() {
        return "ServerManager{" +
                "pq=" + pq +
                ", m=" + m +
                ", k=" + k +
                ", totalExpansions=" + totalExpansions +
                ", firstInstallTimes=" + firstInstallTimes +
                '}';
    }
}

public class ServerScaleUp {
    public int solution(int[] players, int m, int k) {
        ServerManager manager = new ServerManager(m, k);
        for (int i = 0; i < players.length; i++) {
            manager.process(i, players[i]);
        }
        System.out.println( manager.getFirstInstallTimes());
        return manager.getTotalExpansions();
    }
}