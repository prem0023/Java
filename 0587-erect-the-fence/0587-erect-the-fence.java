class Solution {
    private class Point{
        int x;
        int y;

        public Point(int x,int y){
            this.x=x;
            this.y=y;
        }
    }

public int crossProductSlope(Point a,Point b,Point c){
        int crossProduct=(b.x-a.x)*(c.y-a.y)-(b.y-a.y)*(c.x-a.x);
        if(crossProduct>0) return 1;
        else if (crossProduct<0) return -1;
        else  return 0;
}

public int[][] outerTrees(int[][] trees) {  
    ArrayList<Point> coordinates=new ArrayList<>();
    for(int []points:trees){
        coordinates.add(new Point(points[0],points[1]));
    }
    
    ArrayList<Point> res=new ArrayList<>();
    int n=coordinates.size();
    if(n==1) return trees;
    
    Collections.sort(coordinates,(a,b)-> (a.y==b.y) ? (a.x-b.x) : (a.y-b.y));
    
    HashSet<ArrayList<Integer>> dup=new HashSet();
    
    Stack<Point> hull=new Stack<>();
    hull.push(coordinates.get(0));
    hull.push(coordinates.get(1));
    
    //lower hull
    for(int i=2;i<n;i++){
        Point top=hull.pop();
        while(!hull.isEmpty() && crossProductSlope(hull.peek(),top,coordinates.get(i)) <0){
            top=hull.pop();
        }
        hull.push(top);
        hull.push(coordinates.get(i));
    }
    
    //upper hull
    for(int i=n-2;i>=0;i--){
        Point top=hull.pop();
        while(!hull.isEmpty() && crossProductSlope(hull.peek(),top,coordinates.get(i)) <0){
            top=hull.pop();
        }
        hull.push(top);
        hull.push(coordinates.get(i));
    }
    
    //removing all the duplicates in the hull stack
    for(Point p:hull){
        ArrayList<Integer> temp=new ArrayList<>();
        temp.add(p.x);
        temp.add(p.y);
        if(dup.contains(temp)) continue;
        dup.add(temp);
        res.add(p);
    }
    
    int ans[][]=new int[res.size()][2];
    int i=0;
    for(Point p1:res){
        ans[i][0]=p1.x;
        ans[i][1]=p1.y;
        i++;
    }
    return ans;
}
}