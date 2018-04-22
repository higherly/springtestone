package studyCollection.first.study.map;

import org.junit.Test;
import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.util.*;

/*
* map中数据是以键值对形式存在的，并且并且键值都可以为空，
*
* */
public class mapStudy {
    /*首先hashMap的排序功能*/
    @Test
    public void test1() {
        Map<Integer, User> map = new HashMap<Integer, User>();
        map.put(1, new User("杜兰特", "29"));
        map.put(2, new User("詹姆斯", "33"));
        map.put(3, new User("威少", "28"));
        map.put(4, new User("库里", "30"));
        System.out.println(map);
        Set<Map.Entry<Integer, User>> set = map.entrySet();
        List<Map.Entry<Integer, User>> list = new ArrayList<Map.Entry<Integer, User>>(set);
        /*Collections.sort()只能list集合进行排序，set和map不行，所以需要
         * 将set转换为list
         * */
        Collections.sort(list, new Comparator<Map.Entry<Integer, User>>() {
            public int compare(Map.Entry<Integer, User> o1, Map.Entry<Integer, User> o2) {
                return Integer.valueOf(o1.getValue().getAge()) - Integer.valueOf(o2.getValue().getAge());
            }
        });
        LinkedHashMap<Integer, User> linkedHashMap = new LinkedHashMap<Integer, User>();
        for (Map.Entry<Integer, User> e : list) {
            linkedHashMap.put(e.getKey(), e.getValue());
        }
        System.out.println(linkedHashMap);
    }

    /*Map接口中的方法
     * */
    @Test
    public void test2() {
        Map<Integer, String> map = new HashMap<Integer, String>();
        /*size() 集合内的对象数量
         *put(K,V) 像集合内添加单个对象
         *putAll(Map) 像集合内批量添加对象
         *get(K) 获取key对应得对象
         *remove(K) 删除key对应得对象
         *keySet() 返回key的set集合
         * values() 返回value的
         *entrySet() 返回key-value的EntrySet集合
         * containsKey/containValue 判断map中是否存在key/value
         c*/
        map.put(1, "2");map.put(2, "3");
        map.put(3, "4");map.put(4, "5");
        System.out.println(map.size());
        System.out.println(map.get(1));
        map.remove(1);
        System.out.println(map.size());
        Set<Integer> set = map.keySet();
        Collection<String> c =map.values();
        for(String i:c){
            System.out.println("value"+i);
        }
        for(int i :set){
            System.out.println("key"+i);
        }
        System.out.println(map.containsKey(1));
        System.out.println(map.containsValue("3"));
    }
    /*map的四种遍历方式，注对map接口遍历操作很少*/
    @Test
    public void test3(){
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i=0;i<10000;i++){
            map.put(i,i);
        }
        /*第一种通过entrySet()方法遍历*/
        long start1 = System.currentTimeMillis();
        Set<Map.Entry<Integer,Integer>> set = map.entrySet();
        for(Map.Entry<Integer,Integer> s:set){
            if(s.getKey()==9999){
                System.out.println(s.getKey()+","+s.getValue());
            }else{
                System.out.print(s.getKey()+","+s.getValue());
            }
        }
        System.out.println("花费时间1:"+(System.currentTimeMillis()-start1));
        /*第二种 通过keySet 和values()遍历 先遍历key，在遍历value比第一种方法要快10%左右*/
        long start2 = System.currentTimeMillis();
       /* for(Integer s:map.keySet()){
            System.out.print(s);
        }*/
        for(Integer s:map.values()){
            if(s==9999){
                System.out.println(s);
            }else{
                System.out.print(s);
            }
        }
        System.out.println("花费时间2:"+(System.currentTimeMillis()-start2));
        /*第三种方法：通过键找值，效率低，比一大概慢了20%-200%，主要引文get(K)耗费时间太久*/
        long start3 = System.currentTimeMillis();
        for(Integer s:map.keySet()){
            if(s==9999){
                System.out.println(s+","+map.get(s));
            }else{
                System.out.print(s+","+map.get(s));
            }
        }
        /*实际测试比1快，10000条数据*/
        System.out.println("花费时间3:"+(System.currentTimeMillis()-start3));
        /*第四种遍历方式通过Iterator遍历,和方式一效率差不多*/
        long start4 = System.currentTimeMillis();
        Iterator<Map.Entry<Integer,Integer>> it = map.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry<Integer,Integer> set1 = it.next();
            if(set1.getKey()==9999){
                System.out.println("Key = " + set1.getKey() + ", Value = " + set1.getValue());
            }else{
                System.out.print("Key = " + set1.getKey() + ", Value = " + set1.getValue());
            }
        }
        System.out.println("花费时间4:"+(System.currentTimeMillis()-start4));
    }
}