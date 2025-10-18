public class Connections<E>{
    private MyHashMap<E, MyHashMap<E, Integer>> hashMap;

    public Connections(){
        hashMap = new MyHashMap<E, MyHashMap<E, Integer>> (); 
    }

    public void add(E e){
        hashMap.put(e, new MyHashMap<E, Integer>());
    }

    public void addConnection(E a, E b, int connectionNum){
        hashMap.get(a).put(b, connectionNum);
        hashMap.get(b).put(a, connectionNum);
    }

    public int connectionNum(E a, E b){
        MyHashMap<E, Integer> temp = hashMap.get(a);
        if(temp.get(b) != null){
            return temp.get(b);
        }
        else{
            return -1;
        }
    }


}
