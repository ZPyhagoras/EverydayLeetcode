public class Interview1608 {
    String[] digits = new String[] {"","Thousand","Million","Billion"};
    String[] ones = new String[] {"","One","Two","Three","Four","Five","Six","Seven","Eight","Nine"};
    String[] tens = new String[] {"","","Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"};
    String[] spec = new String[] {"Ten","Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"};
    public String numberToWords(int num) {
        if(num == 0) return "Zero";
        StringBuilder res = new StringBuilder();
        int[] nums = new int[4];
        boolean first = true;
        for(int i = 0; i < nums.length ; i++){
            nums[i] = num % 1000;
            num /= 1000;
        }
        for(int i = 3 ; i >= 0 ; i--){
            if(nums[i] == 0) continue;
            if(!first) res.append(" ");
            else first = false;
                res.append(number(nums[i]));
                if(i != 0)res.append(" ");
                res.append(digits[i]);
        }
        return res.toString();
    }
    public String number(int num){
        int[] nums = new int[3];
        StringBuilder res = new StringBuilder();
        boolean first = true;
        for(int i = 0 ; i < nums.length ; i++){
            nums[i] = num % 10;
            num /= 10;
        }
        if(nums[2] != 0){
            first = false;
            res.append(ones[nums[2]]);
            res.append(" Hundred");
        }
        if(nums[1] == 1){
            if(!first)res.append(" ");
            else first = false;
            res.append(spec[nums[0]]);
        }
        else if(nums[1] != 0){
            if(!first)res.append(" ");
            else first = false;
            res.append(tens[nums[1]]);
        }
        if(nums[0] != 0 && nums[1] != 1){
            if(!first)res.append(" ");
            res.append(ones[nums[0]]);
        }
        return res.toString();
    }
}