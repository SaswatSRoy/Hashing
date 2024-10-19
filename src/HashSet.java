import java.util.Iterator;
public class HashSet {
    public static void main(String []args){
        //Creation
        java.util.HashSet<Integer> set=new java.util.HashSet<>();

        //Insert
        set.add(1);
        set.add(3);

        set.add(4);
        set.add(2);
        //Contains
        if(set.contains(3)){
            System.out.println("yes");
        }
        if(!set.contains(5)){
            System.out.println("nope");
        }
        //Printing
        System.out.println(set);
        //Delete
        set.remove(1);
        System.out.println(set);

        //Iterator
        Iterator<Integer> it=set.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }

    }
}
