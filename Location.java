public class Location{
    private String name; 
    private String abv; 

    public Location(String name, String abv){
        this.name = name; 
        this.abv = abv; 
    }

    public String getName(){
        return name; 
    }

    public String getAbv(){
        return abv;
    }

    public String toString(){
        return name + " : " + abv; 
    }

    
    public int hashCode(){
        char char1 = abv.charAt(0); 
        char char2 = abv.charAt(1); 
        char char3 = abv.charAt(2); 

        int value1 = ((int)char1-97) * (26^2); 
        int value2 = ((int)char2-97) * (26^1); 
        int value3 = ((int)char3-97) * (26^0); 

        int hashCode = value1 + value2 + value3; 
        return Math.abs(hashCode);
    }
    

}
