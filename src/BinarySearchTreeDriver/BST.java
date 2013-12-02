package BinarySearchTreeDriver;

/**
 * This is an array based Binary Search Tree. No TreeNodeWrapper implementation
 */
public class BST {

    public Data[] tna = new Data[20];
    private static int result = -1;

    public BST() {
        //Level 0
        this.tna[0] = new Data("e");
        //Level 1
        this.tna[1] = new Data("c");
        this.tna[2] = new Data("h");
        //Level 2        
        this.tna[3] = new Data("a");
        this.tna[4] = new Data("d");
        this.tna[5] = new Data("f");
        this.tna[6] = new Data("j");
        //Level 3

    }

    /**
     * Output in Ascending order a c d e f h j
     *
     * @param i
     */
    public void outputLNR(int i) {
        if (i > tna.length - 1) {
            return;
        }
        outputLNR(2 * i + 1);
        System.out.println(tna[i].getKey());
        outputLNR(2 * i + 2);
    }

    /**
     * Output in Descending order
     *
     * @param i
     */
    public void outputRNL(int i) {
        if (i > tna.length - 1) {
            return;
        }
        outputRNL(2 * i + 2);
        System.out.println(tna[i].getKey());
        outputRNL(2 * i + 1);
    }

    public void outputNLR(int i) {
        if (i > tna.length - 1) {
            return;
        }
        System.out.println(tna[i].getKey());
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
    public boolean insert(Data t) {
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

    public boolean insert2(Data t) {
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
