package Nodes.Decl;

import Nodes.Type;

import javax.swing.tree.DefaultMutableTreeNode;
import java.util.ArrayList;

public class ParDeclOp extends DefaultMutableTreeNode {
    ArrayList<PVarOp> pvarOps;
    Type type;

    public ParDeclOp(ArrayList<PVarOp> pvarOps, Type type){
        super("ParDeclOp");
        pvarOps.forEach(super::add);
        super.add(type);

        this.pvarOps = pvarOps;
        this.type = type;
    }

    public ArrayList<PVarOp> getPvarOps() {
        return pvarOps;
    }

    public void setPvarOps(ArrayList<PVarOp> pvarOps) {
        this.pvarOps = pvarOps;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}
