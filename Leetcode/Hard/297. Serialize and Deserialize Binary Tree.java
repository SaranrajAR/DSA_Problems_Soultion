/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null) return "";
        StringBuilder sb=new StringBuilder();
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int n=queue.size();
            for(int i=0;i<n;i++){
                TreeNode temp=queue.poll();
                if(temp==null){
                    sb.append("#,");
                    continue;
                }
                sb.append(temp.val+",");
                queue.offer(temp.left);
                queue.offer(temp.right);
            }

        }
        return sb.toString();
        
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.equals("")) return null;
        Queue<TreeNode> queue=new LinkedList<>();
        String[] arr=data.split(",");
        int i=1;
        int n=arr.length;
        TreeNode root=new TreeNode(Integer.parseInt(arr[0]));
        queue.offer(root);
        
        while(i<n){
            TreeNode temp=queue.poll();
            if(!arr[i].equals("#")){
                TreeNode left=new TreeNode(Integer.parseInt(arr[i]));
                queue.offer(left);
                temp.left=left;
            }
            if(!arr[++i].equals("#")){
                TreeNode right=new TreeNode(Integer.parseInt(arr[i]));
                queue.offer(right);
                temp.right=right;
            }
            i++;
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
