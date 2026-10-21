class Node {
    int key;
    int val;
    Node prev;
    Node next;

    public Node(int key,int val){
        this.key = key;
        this.val = val;
        this.prev = null;
        this.next = null;
    }
}

class LRUCache {
    private int capacity;
    private HashMap<Integer,Node> cache;
    private Node left;
    private Node right;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.left = new Node(0,0);
        this.right = new Node(0,0);
        this.right.prev = this.left;
        this.left.next = this.right;

        
    }

    //put in right

    public void insert(Node node){
        Node prev = right.prev;
        prev.next = node;
        node.prev = prev;
        node.next = right;
        right.prev = node;
    }

    public void remove(Node node){
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
    }
    
    public int get(int key) {
        if(cache.containsKey(key)){
            Node node = cache.get(key);
            remove(node);
            insert(node);
            return node.val;
        }
        
        return -1;
        
        
    }
    
    public void put(int key, int value) {
         if (cache.containsKey(key)) {
            remove(cache.get(key));
        }
        Node node = new Node(key,value);
        cache.put(key, node);
        insert(node);
        if(cache.size()>capacity){
            Node lRU = left.next;
            remove(lRU);
            cache.remove(lRU.key);
        }
    }
}
