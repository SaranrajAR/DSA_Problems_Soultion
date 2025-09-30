class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int n=numCourses;
        List<Integer>[] adj=new List[n];
        for(int i=0;i<n;i++){
            adj[i]=new ArrayList<>();
        }
        for(int[] edge:prerequisites){
            adj[edge[1]].add(edge[0]);
        }
        int[] indegree=new int[n];
        for(int i=0;i<n;i++){
            for(int adjNode:adj[i]){
                indegree[adjNode]++;
            }
        }
        Queue<Integer> queue=new LinkedList<>();
        List<Integer> topo=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(indegree[i]==0) queue.offer(i);
        }
        while(!queue.isEmpty()){
            int node=queue.poll();
            topo.add(node);
            for(int adjNode:adj[node]){
                indegree[adjNode]--;
                if(indegree[adjNode]==0) queue.offer(adjNode);
            }
        }
        if(topo.size()!=n) return new int[]{};
        int n1=topo.size();
        int[] ans=new int[n1];
        for(int i=0;i<n1;i++){
            ans[i]=topo.get(i);
        }
        return ans;
    }
}
