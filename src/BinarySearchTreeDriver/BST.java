package BinarySearchTreeDriver;

/**
 * This is an array based Binary Search Tree. No TreeNodeWrapper implementation
 */
public class BST {

    private StudentListing[] tna = new StudentListing[20];
    private static int result = -1;

    public BST() {
        //Level 0   root
        this.tna[0] = new StudentListing("m");
        //Level 1
        this.tna[1] = new StudentListing("f");
        this.tna[2] = new StudentListing("q");
        //Level 2        
        this.tna[3] = new StudentListing("c");
        this.tna[4] = new StudentListing("h");
        this.tna[5] = new StudentListing("o");
        this.tna[6] = new StudentListing("v");
        //Level 3
        this.tna[7] = new StudentListing("b");
        this.tna[8] = new StudentListing("d");
        this.tna[9] = new StudentListing("g");
        this.tna[10] = new StudentListing("k");
        this.tna[11] = new StudentListing("n");
        this.tna[12] = new StudentListing("t");
        this.tna[13] = new StudentListing("u");
        this.tna[14] = new StudentListing("z");
        /*
        this.tna[15] = new StudentListing("");
        this.tna[16] = new StudentListing("");
        this.tna[17] = new StudentListing("");
        this.tna[18] = new StudentListing("");
        this.tna[19] = new StudentListing("");
        */
    }

    public void showLNR(){
        outputLNR(0);
    }
    public void showRNL(){
        outputRNL(0);
    }
    public void showNLR(){
        outputNLR(0);
    }
    
    /**
     * Output in Ascending order a c d e f h j
     *
     * @param i
     */
    private void outputLNR(int i) {
        if (i > tna.length - 1 ) {
            return;
        }
        outputLNR(2 * i + 1);
        if ( tna[i]!=null ) System.out.println(tna[i].getKey());
        outputLNR(2 * i + 2);
    }

    /**
     * Output in Descending order
     *
     * @param i
     */
    private void outputRNL(int i) {
        if (i > tna.length - 1) {
            return;
        }
        outputRNL(2 * i + 2);
        if ( tna[i]!=null ) System.out.println(tna[i].getKey());
        outputRNL(2 * i + 1);
    }

    private void outputNLR(int i) {
        if (i > tna.length - 1) {
            return;
        }
        if ( tna[i]!=null ) System.out.println(tna[i].getKey());
        outputNLR(2 * i + 1);
        outputNLR(2 * i + 2);
    }

    /**
     * returns the child
     *
     * @param key
     * @return
     */
    public int findNode(String key) {
        int i = 0;
        int diff;
        do {
            diff = tna[i].compareTo(key);
            if (diff > 0) {         //Go left child
                i = 2 * i + 1;
            } else if (diff < 0) {  //Go right child
                i = 2 * i + 2;
            }
        } while (diff != 0);
        return i;
    }

    /**
     *
     * @param t
     * @return
     */
    public boolean insert(StudentListing t) {
        //Parent = 0  ->  Child = t
        if (tna[0] == null) {
            tna[0] = t;
            return true;
        } else {
            if (tna[0].compareTo(t.getKey()) > 0) {
                //insert at 2n+1
                tna[2 * 0 + 1] = t;
                return true;
            } else if (tna[0].compareTo(t.getKey()) < 0) {
                //insert at 2n+2
                tna[2 * 0 + 2] = t;
                return true;
            }
            return false;
        }
    }

    public boolean insert2(StudentListing t) {
        if (tna[0] == null) {
            tna[0] = t;
            return true;
        }
        //Find where to insert at
        int insertAtIndex = findIndex(t.getKey());
        tna[insertAtIndex] = t;

        return true;
    }

    public int findIndexRecursively(String key, int index){
        //optimization: AND to OR
        //Left Child 
        if (tna[2*index+1] != null && tna[2*index+2] == null) {
            return index;            
        }
        //Right Child
        if (tna[2*index+1] == null && tna[2*index+2] != null) {
            return index;            
        }
        //Base Case, found a leaf within the array's bounds
        if ( tna[2*index+1] == null && tna[2*index+2] == null) {
            return index;            
        }        
        int child = tna[index].compareTo(key) > 0 ? 2*index+1 : 2*index+2;
        int parent = findIndexRecursively(key, child);
        
        if ( result == -1 ) {
            result = tna[parent].compareTo(key) > 0 ? 2*parent+1 : 2*parent+2;
            return result;
        }else{
            return result;
        }
    }
    
    public int findIndex(String key) {
        int i = 0;
        while (tna[i] != null && i < (tna.length - 1)) {
            int diff = tna[i].compareTo(key);
            if (diff > 0) {         //Go Left
                i = 2*i + 1;
            } else if (diff < 0) {  //Go Right
                i = 2*i + 2;
            }
        }
        return i;
    }
    
    public void showArray(){
        for( int i = 0; i < tna.length; i++ ){
            System.out.format("\n===== Index [%d] ===== \n", i);
            System.out.format("%9s\n",
                    (tna[i] == null) ? "EMPTY" : tna[i].getKey());
            System.out.format("======================\n", i);
        }
    }

}
