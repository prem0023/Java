// Insert An Element At Its Bottom In A Given Stack without using amy data structure

import java.util.Stack;

public class Solution 
{
  public static Stack<Integer> pushAtBottom(Stack <Integer> myStack, int x) 
  {
    // Write your code here
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
