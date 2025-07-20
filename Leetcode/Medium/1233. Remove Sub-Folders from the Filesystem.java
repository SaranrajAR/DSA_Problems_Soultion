class Solution {
    public List<String> removeSubfolders(String[] folders) {
        Arrays.sort(folders);
        List<String> res=new ArrayList<>();
        for(String folder:folders){
            if(res.isEmpty() || !folder.startsWith(res.get(res.size()-1)+"/")) res.add(folder);
        }
        return res;
    }
}
