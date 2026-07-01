class Solution {
    public boolean isValid(String s) {
         Stack<Character> stack = new Stack<>();
         if(s.length()==0)
         {
            return true;
         }
         stack.push(s.charAt(0));
        for(int i=1;i<s.length();i++)
        {
            if(s.charAt(i)=='('||s.charAt(i)=='['||s.charAt(i)=='{')
            {
              stack.push(s.charAt(i));
            }
            else if(!stack.isEmpty()&&((s.charAt(i)==')'&&stack.peek()=='(')||(s.charAt(i)==']'&&stack.peek()=='[')||(s.charAt(i)=='}'&&stack.peek()=='{')))
            {
            stack.pop();
            }
            else
            {
                stack.push(s.charAt(i));
            }
        }

        if(stack.isEmpty())
        {
            return true;
        }
        return false;
        
    }
}
