class Solution {
    public String largestNumber(int[] arr) {
        String[] str = new String[arr.length];
        
        for(int i=0 ; i< arr.length ; i++){
            str[i] = String.valueOf(arr[i]);
        }
        
        Arrays.sort(str , (a,b) -> (b+a).compareTo(a+b));
        
        if(str[0].equals("0")){
            return "0";
        }
        
        StringBuilder sb = new StringBuilder();
        
        for(String num : str){
            sb.append(num);
        }
        
        return sb.toString();
    }
}