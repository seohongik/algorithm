package inflearnBasic.iter;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        System.out.println("==============makeData Start==================");

        List<Integer> arrayList = List.of(1,2,3); // 불변 of 모두 불변
        //arrayList.add(1); // 가변
        //arrayList.add(2);
        //arrayList.add(3);

        List<Integer> linkedList = new LinkedList<>(arrayList); // 가변
        Set<Integer> hashSet =Set.of(1,3,2,4);

        //hashSet.add(1);
        //hashSet.add(2);
        //hashSet.add(3);
        //hashSet.add(4);
        Set<Integer> linkedHashSet = new HashSet<>(linkedList);
        Set<Integer> treeSet = new TreeSet<>(linkedHashSet);


        Map<Integer, Integer> hashMap = Map.of(1,2,3,3,2,2);
        //hashMap.put(1, 1);
        //hashMap.put(2, 2);
        //hashMap.put(3, 3);
        Map<Integer, Integer> linkedHashMap = new LinkedHashMap<>(hashMap);
        Map<Integer, Integer> treeMap = new TreeMap<>(linkedHashMap);



        System.out.println("==============forEach Start==================");
        foreach(arrayList);
        foreach(linkedList);
        foreach(hashSet);
        foreach(linkedHashSet);
        foreach(treeSet);
        foreach(hashMap.entrySet());
        foreach(linkedHashMap.entrySet());
        foreach(treeMap.entrySet());
        System.out.println("==============forEach END==================");

        System.out.println("==============iter start==================");

        iter(arrayList.iterator());
        iter(linkedList.iterator());
        iter(hashSet.iterator());
        iter(treeSet.iterator());
        iter(hashMap.entrySet().iterator());
        iter(linkedHashMap.entrySet().iterator());
        iter(treeMap.entrySet().iterator());
        System.out.println("==============iter end==================");


    }

    public static void foreach(Collection<?> collection) {
        System.out.println(collection.getClass().getName());
        for (Object o : collection) {
            if(o instanceof Map.Entry) {
                Object value=((Map.Entry<?, ?>) o).getValue();
                Object key =  ((Map.Entry<?, ?>) o).getKey();
                System.out.println("key :"+key +"  value :"+value);
            }else {
                System.out.println("element : "+o);
            }
        }
    }

    public static void iter(Iterator<?> iterator) {
        System.out.println(iterator.getClass().getName());
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
