public class Main {
    public static void main(String[] args) {
        Tree tree = new Tree(); 
        tree.add("ALI"); 
        tree.add("AYSE");
        tree.add("IRFAN");
        tree.add("ALIHAN");
        tree.add("ALICAN"); 
        tree.print(); 
        System.out.println("_____________________________");    
        tree.update("ALIHAN", "VELI"); 
        tree.update("SEMANUR", "ASYA");
       
        tree.print();
    }
}
