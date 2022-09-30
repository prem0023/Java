// Reverse words in a given string

class Solution 
{
    //Function to reverse words in a given string.
    String reverseWords(String S)
    {
        // code here 
        String[] array = S.split("\\.");

        //System.out.println(Arrays.toString(array));

        int start =0;

        int end =array.length-1;

        while(start<=end){

            String temp =array[start];

            array[start] = array[end];

            array[end]=temp;

            start++;

            end--;

        }

        String s = String.join(".",array);

       

        return s;
    }
}