package BinarySearchTreeDriver;

import javax.swing.JOptionPane;

class StudentListing implements Comparable<String> {

    private String name;
    private String gpa;
    private String idNumber;
    public StudentListing(String n) {
        this.name = n;    
    }

    public StudentListing(String n, String a, String num) {
        name = n;
        idNumber = a;
        gpa = num;
    }
    
    public void input(){
        
        this.name = JOptionPane.showInputDialog("Enter name: ");
        this.gpa = JOptionPane.showInputDialog("Enter gpa: ");
        this.idNumber = JOptionPane.showInputDialog("Enter id: ");
    
    }
    
    public StudentListing deepCopy( StudentListing sl ){
        return ( sl != null ) ? new StudentListing(name, idNumber, gpa) : null;
    }
        

    public String getKey(){
        return this.name;    
    }
    
    @Override
    public String toString() {
        return ("Name is " + name
                + "\nID Number is " + idNumber
                + "\nGPA is " + gpa);
    }
    
    /**
     * override
     * @param s String to compare against.
     * @return <code>negative</code> if local class String is lesser than <code>s</code><br/>
     * <code>positive</code> if local class String is greater than <code>s</code>
     */
    @Override
    public int compareTo(String s) {
        return name.compareTo(s);
    }
    
    
    
    
}
