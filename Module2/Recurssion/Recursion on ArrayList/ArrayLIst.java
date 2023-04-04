import java.util.*;
public class ArrayLIst
{
public static void main(String[] args) {
    ArrayList l1=new ArrayList(4);
    l1.add("Aniket");
    l1.add("Rahul");
    l1.add(56);
    l1.add(true);
    l1.add(1,"Romesh");
l1.add(4,'c');
l1.add("Love");
    Iterator it=l1.iterator();

    while(it.hasNext()){
        System.out.println(it.next());

    }
    int a=l1.size();
    System.out.println(a);
}
}