package studyCollection.first.study.list;

import org.junit.Test;

import java.util.*;

/*List集合的特性:存储有序的可重复的元素
 * 1：ArrayList 底层数据结构是数组，查询快，增删改慢，
 *2：LinkedList 底层数据结构是双向链表,特点查询慢，增删改快，特有方法:addFirst()和addLast
 * 3：Vector 底层数据结构是数组，增删改查都慢
 * */
public class ListStduy {
    /*list集合遍历的四种方法*/
    @Test
    public void test1() {
        List<String> list= new ArrayList<String>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        /*第一种通过for循环遍历*/
        for (String s:list){
            System.out.println(s);
        }
        /*第二种通过size()和get()方法遍历*/
        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i));
        }
        /*第三种通过list集合特德方法listIterator遍历*/
        ListIterator<String> listIterator = list.listIterator();
        while (listIterator.hasNext()){
            System.out.println(listIterator.next());
        }
        /*第四种通过list集合和set集合都有的iterator()遍历*/
        Iterator it =list.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
     }
     /*把数组转换为List的三种方式*/
     @Test
     public void test2(){
         /*第一种遍历数组，循环添加，不推荐*/
         String []s = new String[]{"AAA","BBB","CCC"};
         List<String> list1 = new ArrayList<String>();
         for(String i:s){
             list1.add(i);
         }
         System.out.println(list1);
         /*第二种通过Collections工具类进行添加*/
         List<String> list2 = new ArrayList<String>();
         Collections.addAll(list2,s);
         list2.add("DDD");
         System.out.println(list2);
         /*第三种调用集合中asList()方法*/
         List<String> list3 = Arrays.asList(s);
         /*使用上面操作时，生成的列表大小是固定的，不支持add(),remove()等操作，否则会出现运行时异常UnsupportedOperationException，
            list3.add("DDD");
         * */
         System.out.println(list3);
         /*第三种方法的改进*/
         List<String> list4 = new ArrayList<String>(Arrays.asList(s));
         list4.add("DDD");
         System.out.println(list4);
     }
    /*List转换为数组的方式*/
    @Test
    public void test3(){
        /*第一种遍历list，循环添加*/
        List<String> list1 = new ArrayList<String>();
        list1.add("aaa");
        list1.add("baa");
        list1.add("caa");
        String []s = new String[list1.size()];
        for(int i=0;i<list1.size();i++){
            s[i] = list1.get(i);
        }
        System.out.println(s);
        /*第二种调用集合的toArray()方法*/
       String []s1 = list1.toArray(new String[0]);
        System.out.println(s1);
    }
}
