package BinarySearchTreeDriver;

/**
 *
 * @author Veloz
 */
class Data implements Comparable<String> {

    private String info = "";
    
    public Data( String info ) {        
        this.info = info;
    }

    public String getKey(){
        return this.info;    
    }
    /**
     * override
     * @param s String to compare against.
     * @return <code>negative</code> if local class String is lesser than <code>s</code><br/>
     * <code>positive</code> if local class String is greater than <code>s</code>
     */
    @Override
    public int compareTo(String s) {
        return info.compareTo(s);
    }
    
    
    
    
}
