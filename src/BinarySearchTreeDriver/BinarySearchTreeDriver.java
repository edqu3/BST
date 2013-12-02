package BinarySearchTreeDriver;

public class BinarySearchTreeDriver {

    public static void main(String[] args) {
        BST b = new BST();

        System.out.println("====================================");
        b.showLNR();
        System.out.println("====================================");

        System.out.println("====================================");        
        b.showRNL();
        System.out.println("====================================");
        
        System.out.println("====================================");
        b.showNLR();
        System.out.println("====================================");
                
        b.showArray();
    }
}
