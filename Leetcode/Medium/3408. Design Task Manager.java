class Pair{
    int userId;
    int taskId;
    int priority;
    Pair(int userId,int taskId,int priority){
        this.userId=userId;
        this.taskId=taskId;
        this.priority=priority;
    }
}
class TaskManager {

    HashMap<Integer,Pair> map;
    PriorityQueue<Pair> pq;

    public TaskManager(List<List<Integer>> tasks) {
        map=new HashMap<>();
        pq=new PriorityQueue<>((a,b)->{
            if(b.priority!=a.priority){
                 return b.priority-a.priority;
            }
            return b.taskId-a.taskId;
           
        });
        for(List<Integer> task:tasks){
            int userId=task.get(0);
            int taskId=task.get(1);
            int priority=task.get(2);
            Pair temp=new Pair(userId,taskId,priority);
            map.put(taskId,temp);
            pq.add(temp);
        }
    }
    
    public void add(int userId, int taskId, int priority) {
            Pair temp=new Pair(userId,taskId,priority);
            map.put(taskId,temp);
            pq.add(temp);
    }
    
    public void edit(int taskId, int newPriority) {
        Pair temp=map.get(taskId);
        Pair latest=new Pair(temp.userId,taskId,newPriority);
        map.put(taskId,latest);
        pq.add(latest);
        
    }
    
    public void rmv(int taskId) {
        //   Pair temp=map.get(taskId);
        //   pq.remove(temp);
          map.remove(taskId);
    }
    
    public int execTop() {
        // Pair temp=pq.poll();
        // if(temp==null) return -1;
        // map.remove(temp.taskId);
        // return temp.userId;
        while(!pq.isEmpty()){
            Pair temp=pq.poll();
            Pair latest=map.get(temp.taskId);
            if(latest == null || latest!=temp){
                continue;
            }
            map.remove(temp.taskId);
            return temp.userId;

        }
        return -1;
    }
}

/**
 * Your TaskManager object will be instantiated and called as such:
 * TaskManager obj = new TaskManager(tasks);
 * obj.add(userId,taskId,priority);
 * obj.edit(taskId,newPriority);
 * obj.rmv(taskId);
 * int param_4 = obj.execTop();
 */
