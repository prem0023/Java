class AllOne {

    private Buckets buckets;
    private Map<String, Node> map;

    public AllOne() {
        buckets = new Buckets();
        map = new HashMap<>();
    }
    
    public void inc(String key) {
        Node next = null;
        if (map.containsKey(key)) {
            Node n = map.get(key);
            n.set.remove(key);
            next = buckets.insertOrGetAfter(n);
            if (n.set.size() == 0) buckets.remove(n);
        } else {
            next = buckets.insertOrGetAfter(buckets.min);
        }
        next.set.add(key);
        map.put(key, next);
    }
    
    public void dec(String key) {
        Node cur = map.get(key);
        Node pre = buckets.insertOrGetBefore(cur);
        if (pre.count != 0) {
            pre.set.add(key);
            map.put(key, pre);
        } else {
            map.remove(key);
        }
        cur.set.remove(key);
        if (cur.set.size() == 0) buckets.remove(cur);
    }
    
    public String getMaxKey() {
        Set<String> set = buckets.getMax().set;
        Iterator<String> iter = set.iterator();
        return iter.hasNext() ? iter.next() : "";
    }
    
    public String getMinKey() {
        Set<String> set = buckets.getMin().set;
        Iterator<String> iter = set.iterator();
        return iter.hasNext() ? iter.next() : "";
    }
}

class Buckets {
    Node max, min;

    Buckets() {
        min = new Node(0);
        max = new Node(Integer.MAX_VALUE);
        min.next = max;
        max.pre = min;
    }

    Node getMax() {
        return max.pre;
    }

    Node getMin() {
        return min.next;
    }

    Node insertOrGetAfter(Node n) {
        Node next = n.next;
        if (n.count == n.next.count - 1) return n.next;
        Node n1 = new Node(n.count + 1);
        insertAfter(n, n1);
        return n1;
    }

    Node insertOrGetBefore(Node n) {
        Node pre = n.pre;
        if (pre.count == n.count - 1) return n.pre;
        Node n1 = new Node(n.count - 1);
        insertBefore(n, n1);
        return n1;
    }

    void insertAfter(Node n1, Node n2) {
        Node next = n1.next;
        n1.next = n2;
        n2.pre = n1;
        next.pre = n2;
        n2.next = next;
    }

    void insertBefore(Node n2, Node n1) {
        Node pre = n2.pre;
        pre.next = n1;
        n1.pre = pre;
        n1.next = n2;
        n2.pre = n1;
    }

    void remove(Node n) {
        Node pre = n.pre, next = n.next;
        pre.next = next;
        next.pre = pre;
    }

    void print() {
        Node n = min;
        while (n != null) {
            System.out.print(n.count + " ");
            n = n.next;
        }
        System.out.println();
    }
}

class Node {
    int count = 0;
    Set<String> set = new HashSet<>();
    Node pre, next;
    
    Node(int count) {
        this.count = count;
    }
}

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */