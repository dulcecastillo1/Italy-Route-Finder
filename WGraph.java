public class WGraph<E>{
    private MyHashMap<E, MyHashMap<E, Integer>> graph;
    private MyHashMap<E, Pair<Integer, E>> table; 
    private MyHashSet<E> visited;
    private MyHashSet<E> unvisited;
    private DLList<E> finalList; 
    
    private int size;

    public WGraph(){
        graph = new MyHashMap<E, MyHashMap<E, Integer>>(); 
        table = new MyHashMap<E, Pair<Integer, E>>(); 
        visited = new MyHashSet<E>();
        unvisited = new MyHashSet<E>();
        finalList = new DLList<E>(); 
        size = 0;

    }

    public void add(E e){
        graph.put(e, new MyHashMap<E, Integer>());
        size++; 
    }

    public void addEdge(E a, E b, int weight){
        graph.get(a).put(b, weight);
        graph.get(b).put(a, weight);
    }

    public int findWeight(E a, E b){
        MyHashMap<E, Integer> temp = graph.get(a);
        if(temp.get(b) != null){
            return temp.get(b);
        }
        else{
            return -1;
        }
    }

    public void remove(E e){
        DLList<E> values = graph.get(e).keySet().DLList();
        for(int i = 0; i<values.size(); i++){
            graph.get(values.get(i)).remove(e);
        }
        graph.remove(e);
        
        size--;
    }

    public String toString(){
        String returnString = ""; 
        DLList<E> values = graph.keySet().DLList();
        for(int i = 0; i<values.size(); i++){
            returnString += values.get(i)+" : "+ graph.get(values.get(i)) + "\n";
        }
        return returnString; 
        
    }

    private void buildList(E search){
        DLList<E> keys = table.keySet().DLList();
        E prev2 = null; 
        for(int i = 0; i < keys.size(); i++){
            if(keys.get(i).equals(search)){
                finalList.add(keys.get(i)); 
                prev2 = table.get(keys.get(i)).getValue(); 
                buildList(prev2); 
                break; 
            }
        }

    }

    private void setTable(){
        unvisited.clear(); 
        visited.clear();
        table = new MyHashMap<E, Pair<Integer, E>>(); 
        DLList<E> myList = graph.keySet().DLList();
        for(int i = 0; i<myList.size(); i++){
            table.put(myList.get(i), new Pair<Integer, E>(-1, null));
        }
    }

    public DLList<E> finalList(E b){
        DLList<E> keys = table.keySet().DLList();
        E prev = null; 
        finalList.clear(); 

        for(int i = 0; i<keys.size(); i++){
            if(keys.get(i).equals(b)){
                finalList.add(keys.get(i)); 
                prev = table.get(keys.get(i)).getValue();
            }
        }

        buildList(prev); 

        return finalList; 
        
    }
    
    public DLList<E> shortestPath(E a, E b){
        setTable(); 
        E current = a;
        unvisited.add(current);
        table.put(current, new Pair<Integer, E>(0, null));

        while(unvisited.size() != 0){
            visited.add(current); 
            unvisited.remove(current); 

            MyHashMap<E, Integer> temp2 = graph.get(current);
            DLList<E> adjNodes = temp2.keySet().DLList();
            for(int i = 0; i<adjNodes.size(); i++){
                if(!visited.contains(adjNodes.get(i))){
                    unvisited.add(adjNodes.get(i));
                    int distanceFromStart = table.get(current).getKey();
                    int adjDistance = findWeight(current, adjNodes.get(i));
                    int total = distanceFromStart + adjDistance;
                    if(table.get(adjNodes.get(i)).getKey() == -1 || total<table.get(adjNodes.get(i)).getKey()){
                        table.put(adjNodes.get(i), new Pair<Integer, E>(total, current));
                    }


                }
            }
            DLList<E> keys = unvisited.DLList();
            int smallest = 100000;
            E smallestNode = null;
            for(int i = 0; i<keys.size(); i++){
                int distance = table.get(keys.get(i)).getKey();
                if(distance < smallest){
                    smallest = distance;
                    smallestNode = keys.get(i);
                }
                
                
            }
            current = smallestNode;


        }
        return finalList(b);

    }
    

   
    
}
