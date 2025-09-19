class Spreadsheet {
    HashMap<String,Integer> map;
    public Spreadsheet(int rows) {
        map=new HashMap<>();

    }
    
    public void setCell(String cell, int value) {
        map.put(cell,value);
    }
    
    public void resetCell(String cell) {
        map.put(cell,0);
    }
    
    public int getValue(String formula) {
        formula=formula.substring(1);
        int plusIndex=formula.indexOf('+');
        String left=formula.substring(0,plusIndex);
        String right=formula.substring(plusIndex+1);

        int l=getValueHelper(left);
        int r=getValueHelper(right);
        return l+r;
    }
    public int getValueHelper(String s){
        if(containsChar(s)){
            return map.getOrDefault(s,0);
        }
        return Integer.parseInt(s);
    }
    public boolean containsChar(String s){
        if(Character.isLetter(s.charAt(0))) return true;
        return false; 
    }
}

/**
 * Your Spreadsheet object will be instantiated and called as such:
 * Spreadsheet obj = new Spreadsheet(rows);
 * obj.setCell(cell,value);
 * obj.resetCell(cell);
 * int param_3 = obj.getValue(formula);
 */
