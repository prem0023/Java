class CustomStack {
    int[] arr = new int[1000];
    int i = 0;
    public CustomStack(int maxSize) {
        int[] arr = new int[maxSize];
        this.arr = arr;
        return;
    }
    
    public void push(int x) {
        if(i==arr.length){
            return;
        }
        arr[i] = x;
        i++;
        return;
    }
    
    public int pop() {
        i--;
        if(i<0){
            i=0;
            return -1;
        }
        return arr[i];
    }
    
    public void increment(int k, int val) {
        for(int i=0;i<(Math.min(arr.length,k));i++){
            arr[i] += val;
        }
        return;
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */