package programus;

import java.util.PriorityQueue;

public class EntryScreening {
    public long solution(int n, int[] times) {
        if (times == null || times.length == 0) return 0L;

        PriorityQueue<Entry> pq = new PriorityQueue<>();
        for (int i = 0; i < times.length; i++) {
            pq.offer(new Entry(times[i], i));
        }

        long processed = 0;   // 처리한 사람 수
        long lastEnd = 0L;

        while (processed < n) {
            Entry cur = pq.poll();
            lastEnd = cur.endTime;
            processed++;

            if (processed == n) break;

            pq.offer(new Entry(cur.endTime + (long) times[cur.id], cur.id));
        }

        return lastEnd;
    }

    public static void main(String[] args) {
        EntryScreening entryScreening = new EntryScreening();
        System.out.println(entryScreening.solution(6, new int[]{7,10}));
    }

    static class Entry implements Comparable<Entry> {
        long endTime;
        int id;

        Entry(long endTime, int id) {
            this.endTime = endTime;
            this.id = id;
        }

        @Override
        public int compareTo(Entry o) {
            if (this.endTime == o.endTime) {
                return Integer.compare(this.id, o.id);
            }

            return Long.compare(this.endTime, o.endTime);
        }

        @Override
        public String toString() {
            return "Entry{" +
                    "endTime=" + endTime +
                    ", id=" + id +
                    '}';
        }
    }
}