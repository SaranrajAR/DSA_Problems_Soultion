class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int n=numCourses;
        List<Integer>[] adj=new List[n];
        for(int i=0;i<n;i++){
            adj[i]=new ArrayList<>();
        }
        for(int[] edge:prerequisites){
            adj[edge[0]].add(edge[1]);
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
        return n==topo.size();
    }
}
