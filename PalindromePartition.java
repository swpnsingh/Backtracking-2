class Solution {
    List<List<String>> result;
    
    public List<List<String>> partition(String s) {
        result = new ArrayList<>();
        if(s == null || s.length() == 0 ) return result;
        backtrack(s,new ArrayList<>(),0);
        return result;
    }
    
    private void backtrack(String s,List<String> temp, int start){
        //base
        if(start == s.length()){ // for the palindrome length string
            result.add(new ArrayList<>(temp)); 
            return;
        }
        
        for(int i = start ; i < s.length(); i++){
            if(isPalindrome(s,start,i)){
                //action
                temp.add(s.substring(start,i+1));
                //recurse
                backtrack(s,temp,i+1); //from pivot access all and then terminate
                //backtrack
                temp.remove(temp.size() - 1);
            }
         }
    }
    
        private boolean isPalindrome(String s, int l , int r ){
            if(l == r) return true;
            while(l<r){
                if( s.charAt(l) != s.charAt(r) ) return false;
                   l++; r--;
            }
            return true;
        }
}

//Time : O(n*2^n)
//Space: O(n)