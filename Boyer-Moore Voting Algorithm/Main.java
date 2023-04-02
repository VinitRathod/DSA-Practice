public class Main{
    public int majorityElement(int[] arr){
        int candidate=0;
        int vote=0;
        for(int i:arr){
            if(vote == 0){
                vote = 1;
                candidate = i;
            }else if(candidate==i){
                vote++;
            }else{
                vote--;
            }
        }
        return candidate;
    }
    public static void main(String[] args) {
        int[] nums = {2,2,1,1,1,2,2};
        Main obj = new Main();
        System.out.println("Majority Element is : "+obj.majorityElement(nums));
    }
}