class Solution {
    public int compareVersion(String version1, String version2) {
        int i=0;
        int j=0;
        version1=version1+".";
        version2=version2+".";
        int n1=version1.length();
        int n2=version2.length();
        while(i<n1 || j<n2){
            int V1=0;
            int V2=0;
            while(i<n1 && version1.charAt(i)!='.'){
                V1*=10;
                V1+=version1.charAt(i)-'0';
                i++;
            }
            i++;
            
            while(j<n2 && version2.charAt(j)!='.'){
                V2*=10;
                V2+=version2.charAt(j)-'0';
                
                
                j++;
            }
            j++;
            if(V1<V2) return -1;
            else if(V1>V2) return 1;
        }
        return 0;

        
    }
}
