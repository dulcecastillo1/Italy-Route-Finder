public class MyHashSet<E> {
    private Object[] hashArray;
    private int size;

    public MyHashSet(){
        hashArray = new Object[100000];
        size = 0;
    }

    public boolean add(E obj){
        if(hashArray[obj.hashCode()] == null){
            hashArray[obj.hashCode()] = obj;
            size++;
            return true;
        }
        return false;
    }

    public void clear(){
        for(int i=0; i< hashArray.length; i++){
            hashArray[i] = null;
        }
        
        size = 0;
    }


    public boolean contains(Object data) {
        int hash = data.hashCode() % hashArray.length;
        if (hashArray[hash] != null && hashArray[hash].equals(data)) {
            return true;
        }
        return false;
    }
    
    public boolean remove(Object data) {
        int hash = data.hashCode() % hashArray.length;
        if (hashArray[hash] != null && hashArray[hash].equals(data)) {
            hashArray[hash] = null;
            size--;
            return true;
        }
        return false;
    }
    
    public int size(){
        
        return size;
    }
    
    @SuppressWarnings("unchecked")
    public DLList<E> DLList(){
        DLList<E> linkedList = new DLList<>();
        
        for (Object each : hashArray){
            if(each != null){
                linkedList.add((E) each);
            }
        }
        return linkedList;
    }

    public String toString(){
        String answer = "";
        for(int i=0; i<hashArray.length; i++){
            if(hashArray[i] != null){
                answer += hashArray[i].toString() + "\n";
            }
            
        }
        return answer;
    }
}

