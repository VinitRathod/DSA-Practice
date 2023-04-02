public class HashLP {
    int bucket;
    int[] table;
    public HashLP(int bucket){
        this.bucket = bucket;
        this.table = new int[bucket];
        for(int i=0;i<bucket;i++){
            table[i] = -1;
        }
    }

    public void insertItem(int data){
        int key = data % bucket;
        if(table[key] != -1){
            while(table[key] != -1){
                key = (key+1) % bucket;
            }
            table[key] = data;
        }else{
            table[key] = data;
        }
    }

    public void displayHash(){
        for(int i=0;i<bucket;i++){
            System.out.println(table[i]);
        }
    }

    public static void main(String[] args) {
        int[] a = {35,34,43,23,65,23,21};
        HashLP h = new HashLP(7);
                // insert the keys into the hash table
                for (int x : a) {
                    h.insertItem(x);
                }
        
                // Display the hash table
                h.displayHash();
    }
}
