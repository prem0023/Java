// Height of Binary Tree

int Height(Node root){
	if(root == null)
		return 0;

	int l = Height(root.left);
	int r = Height(root.right);
	
	if(l>r)
		return l+1;
	return r+1;
}