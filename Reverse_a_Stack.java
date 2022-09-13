// Reverse a Stack

class Solution
{ 
    static void reverse(Stack<Integer> s)
    {
        // add your code here
        if(s.isEmpty())
            return;
        
        int a = s.pop();
        
        reverse(s);
        
        s = pushAtBottom(s, a);
    }
    
    public static Stack<Integer> pushAtBottom(Stack <Integer> myStack, int x) 
    {
      if(myStack.isEmpty()){
          myStack.push(x);
          return myStack;
      }
      int a = myStack.pop();
      myStack = pushAtBottom(myStack, x);
      
      myStack.push(a);
      
      return myStack;
  }
}