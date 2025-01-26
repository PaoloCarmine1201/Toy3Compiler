package SymbolTable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;

public class SymbolTable extends HashMap<String, ArrayList<SymbolRow>> {
    SymbolTable father;
    String name;
    ArrayList<SymbolRow> symbolRows = new ArrayList<>();

    public SymbolTable(SymbolTable father, String name, ArrayList<SymbolRow> symbolRows) {
        super.put(name, symbolRows);

        this.father = father;
        this.name = name;
        this.symbolRows = symbolRows;
    }

    public String getName() {
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public ArrayList<SymbolRow> getSymbolRows() {
        return symbolRows;
    }

    public void setSymbolRows(ArrayList<SymbolRow> symbolRows) {
        this.symbolRows = symbolRows;
    }

    public SymbolTable getFather() {
        return father;
    }

    public void setFather(SymbolTable father) {
        this.father = father;
    }

    //Controlla che la variabile non sia già stata dichiarata all'interno dello scope corrente
    public boolean probe(String name) {
        return this.symbolRows.stream().anyMatch(symbolRow -> symbolRow.getName().equals(name));
    }

    public void addID (SymbolRow symbolRow) throws Exception {
        if(!probe(symbolRow.getName())){
            this.symbolRows.add(symbolRow);
        } else {
            throw new Error("Variable already declared");
        }
    }

    //Controlla che la variabile non sia stata già dichiarata all'interno di tutte le tabelle del programma
    public SymbolRow lookUp(String name) throws Exception {
        if(!probe(name)){
            if(this.father != null){
                return this.father.lookUp(name);
            } else {
                throw new Error("Variable not declared");
            }
        } else {
            return this.symbolRows.stream().filter(symbolRow -> symbolRow.getName().equals(name)).findFirst().get();
        }
    }

    //restituisce true se la variabile è stata dichiarata, false altrimenti
    public boolean lookUpBoolean(String name){
        if(!probe(name)){
            if(this.father != null){
                return this.father.lookUpBoolean(name);
            } else {
                return false;
            }
        } else {
            return true;
        }
    }

    //Restituisce il tipo di un dato id
    public SymbolType returnTypeOfId(String name) {
        Optional<SymbolRow> symbolRowOptional = this.getSymbolRows().stream().filter(symbolRow -> symbolRow.getName().equals(name)).findFirst();
        if (symbolRowOptional.isPresent())
            return symbolRowOptional.get().getType();
        else if (this.father != null)
            return this.father.returnTypeOfId(name);
        throw new RuntimeException("L'id " + name + " non è stato dichiarato");
    }

}
