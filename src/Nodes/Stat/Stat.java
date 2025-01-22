package Nodes.Stat;

import javax.swing.tree.DefaultMutableTreeNode;

public class Stat extends DefaultMutableTreeNode {
    String name;

    public Stat(String name) {
        super(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
