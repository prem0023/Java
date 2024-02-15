class Solution {
  public int[] rearrangeArray(int[] nums) {
    var res = new int[nums.length];
    var pos = 0;
    var neg = 1;

    for (var num : nums) {
      if (num > 0) {
        res[pos] = num;
        pos += 2;
      } else {
        res[neg] = num;
        neg += 2;
      }
    }
    return res;
  }
}