import java.util.*;
import java.util.HashMap;

public class HashMapImplementation {
    static class HashMap<K,V>{
        private class Node{
            K key;
            V value;

            public Node(K key,V value){
                this.value=value;
                this.key=key;
            }

        }

        private int n; //Number of nodes
        private int N; //Number of buckets
        private LinkedList<Node>[]buckets;

        public HashMap(){
            this.N=4;
            this.buckets=new LinkedList[N];
            for(int i=0;i<=N;i++){
                this.buckets[i]=new LinkedList<>();
            }
        }
        private int hashFunction(K key){
            int bi=key.hashCode();
            return Math.abs(bi) %N; //From 0 to N-1
        }

        private int searchInLl(K key,int bi){
            LinkedList<Node>ll=buckets[bi];
            for(int i=0;i<ll.size();i++){
                if(ll.get(i).key==key){
                    return i;
                }
            }
            return -1;
        }
        private void rehash(){
            LinkedList<Node>[]oldBucket=buckets;
            buckets=new LinkedList[N*2];

            for(int i=0;i<N*2;i++){
                buckets[i]=new LinkedList<>();
            }

            for(int i=0;i< oldBucket.length;i++){
                LinkedList<Node>ll=oldBucket[i];
                    for (int j=0;j<ll.size();j++){
                        Node node=ll.get(j);
                        put(node.key, node.value);
                    }
            }
        }


        public void put(K key,V value){
            int bi=hashFunction(key);
            int di=searchInLl(key,bi);

            if(di==-1){ //key does not exist
                buckets[bi].add(new Node(key, value));
                n++;
            }else{
                Node data=buckets[bi].get(di);
                data.value=value;
            }

            double lambda=(double) n/N;
            if(lambda>2.0){
                rehash();
            }
        }

    }
}
