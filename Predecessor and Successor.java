class GfG
{
    public static Node predecessor(Node root,int key){
        Node pre = null;
        while(root!=null){
            //if any node's value is less than key,then it can be predecessor. 
            //but we have to find exact answer,so we traverse further
            if(root.data>=key){
                root = root.left;
            }
            else{
                pre = root;
                root = root.right;
            }
        }
        return pre;
    }
    public static Node successor(Node root,int key){
        Node succ = null;
        while(root!=null){
            if(root.data>key){
                succ = root;
                root = root.left;
            }
            //if any node's value is greater than key,then it can be suceessor.
            //but we have to find exact answer, so we traverse further
            else{
                root = root.right;
            }
        }
        return succ;
    }
    public static void findPreSuc(Node root, Res p, Res s, int key)
    {
       // add your code here
       p.pre = predecessor(root,key);
       s.succ = successor(root,key);
    }
}

// Link : https://practice.geeksforgeeks.org/problems/predecessor-and-successor/1
