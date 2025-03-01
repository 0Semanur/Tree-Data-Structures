class Node {
    char letter; 
    int count; 
    Node[] children; 
    boolean end; 

    public Node(char letter) {
        this.letter = letter;
        this.count = 0;
        this.children = new Node[26];
        this.end = false;
    }
}