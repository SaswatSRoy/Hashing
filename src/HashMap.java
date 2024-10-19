import java.util.*;

public class HashMap {
    public static void main(String[]args){
        java.util.HashMap<String,Integer>cp=new java.util.HashMap<>();

        //Insert
        cp.put("India",150);
        cp.put("China",120);
        cp.put("US",70);

        //Print
        System.out.println(cp);
        cp.put("Spain",70);
        System.out.println(cp);
        //Contains
        if(cp.containsKey("Indonesia")){
            System.out.println("key exists");
        }else{
            System.out.println("key does not exists");
        }

        System.out.println(cp.get("China"));
        System.out.println(cp.get("Indonesia"));

        //Iteration

        //One way
        for(Map.Entry<String,Integer>e: cp.entrySet()){
            System.out.println(e.getKey());
            System.out.println(e.getValue());
        }
        System.out.println();

        //Another way

        Set<String>key=cp.keySet();
        for(String keys:key){
            System.out.println(key+" "+cp.get(keys));
        }

        //Remove
        cp.remove("China");
        System.out.println(cp);
    }
}
