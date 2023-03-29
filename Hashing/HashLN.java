// Separate Collision Hashing Using LinkedList
public class HashLN{
    int bucket,val;
    HashLN[] table;
    HashLN next,prev;

    public HashLN(int val, HashLN next, HashLN prev){
        this.val = val;
        this.next = next;
        this.prev = prev;
    }

    public HashLN(int bucket){
        this.bucket = bucket;
        this.table = new HashLN[bucket];
        for(int i=0;i<bucket;i++){
            table[i] = new HashLN(-1,null,null);
        }
    }

    public int hashFunction(int key){
        return key % bucket;
    }

    public void insertItem(int key){
        int index = hashFunction(key);

        if(table[index].next != null){
            HashLN head = table[index].next;
            while(head.next != null){
                head = head.next;
            }
            HashLN temp = new HashLN(key,null,null);
            temp.prev = head;
            head.next = temp;
        }else{
            HashLN temp = new HashLN(key,null,null);
            table[index].next = temp;
            temp.prev = table[index];
        }
    }

    public void deleteItem(int key){
        int index = hashFunction(key);

        if(table[index].next != null){
            HashLN temp = table[index].next;
            while(temp != null){
                if(temp.val == key){
                    break;
                }else{
                    temp = temp.next;
                }
            }
            if(temp != null){
                if(temp.next == null){
                    HashLN prev = temp.prev;
                    prev.next = temp.next;
                    temp.prev = null;
                }else if(table[index].next.val == key && table[index].next.next == null){
                    table[index].next = null;
                }else{
                    HashLN prev = temp.prev;
                    prev.next = temp.next;
                    temp.prev = null;
                    temp.next.prev = prev;
                    temp.next = null;
                }
            }else{
                return;
            }
        }
    }

    public void displayHash(){
        for(int i=0;i<bucket;i++){
            System.out.print(i);
            HashLN temp = table[i].next;
            while(temp != null){
                System.out.print(" --> "+temp.val);
                temp = temp.next;
            }
            System.out.println();
        }
    }



    public static void main(String args[]){
        // array that contains keys to be mapped
        int[] a = { 15, 11, 27, 8, 12,10,13,18,22,50 };
 
        // Create a empty has of BUCKET_SIZE
        HashLN h = new HashLN(7);
 
        // insert the keys into the hash table
        for (int x : a) {
            h.insertItem(x);
        }

        // Display the hash table
        h.displayHash();
 
        // delete 12 from the hash table
        h.deleteItem(50);
 
        // Display the hash table
        h.displayHash();
        // System.out.println(h.table[1].next.prev + " "+h.table[1].next.val);
    }
}