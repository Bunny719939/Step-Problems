import java.util.Arrays;

public class ProductOfArrayExceptSelfQ1 {

    static int[] productExceptSelf(int[] nums) {
        int[] answer = new int[nums.length];

        int prefix = 1;

        for (int i = 0; i < nums.length; i++) {
            answer[i] = prefix;
            prefix = prefix * nums[i];
        }

        int suffix = 1;

        for (int i = nums.length - 1; i >= 0; i--) {
            answer[i] = answer[i] * suffix;
            suffix = suffix * nums[i];
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};

        int[] result = productExceptSelf(nums);

        System.out.println(Arrays.toString(result));
    }
}
