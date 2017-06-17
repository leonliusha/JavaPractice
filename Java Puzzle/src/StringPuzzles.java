/**
 * Created by Administrator on 2015/5/29.
 */
public class StringPuzzles {
    private static final String[] words = {"I","recommend","polygene","lubricants"};
    public static void main(String args[]){
        int[] histogram = new int[5];
        for(String word1 : words){
            for(String word2 : words){
                String pair = word1 + word2;
                int bucket = Math.abs(pair.hashCode()) % histogram.length; // this can still produce negative result. Math.abs() does not guarantee nonnegative result.
                System.out.println("the hashcode is:"+pair.hashCode());    //Integer.MIN_VALUE ==  -Integer.MIN_VALUE and % operator is remainder,not mod; can be negative
                System.out.println("the bucket is:"+bucket);
                //histogram[bucket]++;
            }
        }
        int pairCount = 0;
        for(int freq : histogram)
            pairCount += freq;
        System.out.println('C'+pairCount);
    }

}
