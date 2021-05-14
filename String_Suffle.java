class String_Suffle {


    static boolean shuffleCheck(String first, String second, String result) {

    
    if(first.length() + second.length() != result.length()) {
      return false;
    }
    int i = 0, j = 0, k = 0;
    while (k != result.length()) {
		
      if (i < first.length() && first.charAt(i) == result.charAt(k))
        i++;

      else if (j < second.length() && second.charAt(j) == result.charAt(k))
        j++;

      else {
        return false;
      }
	  
      k++;
    }
  
    if(i < first.length() || j < second.length()) {
      return false;
    }

    return true;
  }
  public static void main(String[] args) {

    String first = "XY";
    String second = "12";
    String[] results = {"1XY2", "Y12X"};

    
    for (String result : results) {
      if (shuffleCheck(first, second, result) == true) {
        System.out.println(result + " is a valid shuffle of " + first + " and " + second);
      }
      else {
        System.out.println(result + " is not a valid shuffle of " + first + " and " + second);
      }
    }
  }
}