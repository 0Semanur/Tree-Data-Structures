class Tree {
    Node root; 

    public Tree() {
        root = new Node(' '); 
    }

    public void add(String name) {
        Node current = root; 
        for (int i = 0; i < name.length(); i++) { 
            char letter = name.charAt(i); 
            int index = letter - 'A'; 
            if (current.children[index] == null) { 
                current.children[index] = new Node(letter); 
            }
            current.children[index].count++; 
            current = current.children[index]; 
        }
        current.end = true; 
    }

    public boolean search(String name) {
        Node current = root; 
        for (int i = 0; i < name.length(); i++) { 
            char letter = name.charAt(i); 
            int index = letter - 'A'; 
            if (current.children[index] == null) { 
                return false; 
            }
            current = current.children[index]; 
        }
        return current.end; 
    }


    public void update(String oldName, String newName) {
        if (search(oldName)) { 
            if (search(newName)) {
                System.out.println(newName + " already exists in the tree. Update failed.");
            } else {
                char oldFirstLetter = oldName.charAt(0);
                char newFirstLetter = newName.charAt(0);

                if (oldFirstLetter == newFirstLetter) { 
                    int index = oldFirstLetter - 'A'; 
                    root.children[index].count--; 
                }

                remove(oldName); 
                add(newName); 
                System.out.println(oldName + " updated to " + newName);
            }
        } else { 
            System.out.println(oldName + " not found in the tree. Update failed.");
        }
    }

    public void remove(String name) {
        Delete(root, name, 0); 
    }


    private boolean Delete(Node node, String name, int level) {
        if (node == null) { 
            return false; 
        }
        
        boolean removed = false; 

        if (level == name.length()) { 
            if (node.end) { 
                node.end = false; 
                removed = true; 
            }
            if (node.count == 0) { 
                return true; 
            }
            return removed; 
        } else { 
            char letter = name.charAt(level); 
            int index = letter - 'A'; 
            if (Delete(node.children[index], name, level + 1)) { 
                node.count--; 
                if (node.count == 0) { 
                    node.children[index] = null; 
                }
                removed = true;
            }
            return removed; 
        }
    }



    public void print() {
        print(root, ""); 
    }

  
    private void print(Node node, String name) {
        if (node == null) { 
            return; 
        }
        if (node.end || node.count > 0) { 
            System.out.println("(" + node.letter + ":" + node.count + ")");
            
        }
        for (int i = 0; i < 26; i++) { 
            if (node.children[i] != null) { 
                print(node.children[i], name + node.letter); 
            }
        }
    }
}