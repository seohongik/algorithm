package easyspub.priorChapter;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

class Edge{
    int endNo;
    int value;
    public Edge(int endNo, int value) {
        this.endNo = endNo;
        this.value = value;
    }

    @Override
    public String toString() {
        return "Edge{" +
                "endNo=" + endNo +
                ", value=" + value +
                '}';
    }
}

public class GraphPriorChapter {

    public static void main(String[] args) throws IOException {
        ArrayList<Edge> list[]=new ArrayList[10];
        for(int i=0;i<10;i++){
            list[i]=new ArrayList<Edge>();
        }

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        long E = Long.parseLong(bufferedReader.readLine());

        for (int i=0;i<E;i++){
            StringTokenizer st=new StringTokenizer(bufferedReader.readLine());
            int s=Integer.parseInt(st.nextToken());
            int e=Integer.parseInt(st.nextToken());
            int v=Integer.parseInt(st.nextToken());
            list[s].add(new Edge(e,v));
        }
        System.out.println(Arrays.toString(list));

        for (int i = 0; i < list.length; i++) {
            for (int j = 0; j < list[i].size(); j++) {
                Edge temp=list[i].get(j);
                int next = temp.endNo;
                int value = temp.value;
                System.out.println(next+","+value);
            }
        }
    }
}
