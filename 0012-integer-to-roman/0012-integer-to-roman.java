class Solution {
    public String intToRoman(int num) {
        
                StringBuilder builder = new StringBuilder();
                int numCopy = num;
                int iterations;
                int cipher = 1000;

                if(numCopy >= 1000) {
                    iterations = numCopy/1000;
                    while (iterations > 0) {
                        builder.append('M');
                        iterations--;
                    }
                    numCopy = numCopy % 1000;
                }

                if(numCopy >= 900) {
                    builder.append('C');
                    builder.append('M');
                    numCopy = numCopy % 900;
                }

                if(numCopy >= 500) {
                    builder.append('D');
                    numCopy = numCopy % 500;
                }
                if(numCopy >= 400) {
                    builder.append('C');
                    builder.append('D');
                    numCopy = numCopy % 400;
                }
                if(numCopy >= 100) {
                    iterations = numCopy/100;
                    while (iterations > 0) {
                        builder.append('C');
                        iterations--;
                    }
                    numCopy = numCopy % 100;
                }
                if(numCopy >= 90) {
                    builder.append('X');
                    builder.append('C');
                    numCopy = numCopy % 90;
                }
                if(numCopy >= 50) {
                    builder.append('L');
                    numCopy = numCopy % 50;
                }
                if(numCopy >= 40) {
                    builder.append('X');
                    builder.append('L');
                    numCopy = numCopy % 40;
                }
                if(numCopy >= 10) {
                    iterations = numCopy/10;
                    while (iterations > 0) {
                        builder.append('X');
                        iterations--;
                    }
                    numCopy = numCopy % 10;
                }
                if(numCopy >= 9) {
                    builder.append('I');
                    builder.append('X');
                    numCopy = numCopy % 9;
                }
                if(numCopy >= 5) {
                    builder.append('V');
                    numCopy = numCopy % 5;
                }
                if(numCopy >= 4) {
                    builder.append('I');
                    builder.append('V');
                    numCopy = numCopy % 4;
                }
                if(numCopy >= 1) {

                    iterations = numCopy;
                    while (iterations > 0) {
                        builder.append('I');
                        iterations--;
                    }
                }
                return builder.toString();
    }
}


/*
class Solution {

    public static String intToRoman(int num) {
        String M[] = {"", "M", "MM", "MMM"};
        String C[] = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String X[] = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String I[] = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        return M[num/1000] + C[(num%1000)/100] + X[(num%100)/10] + I[num%10];
    }
}
*/