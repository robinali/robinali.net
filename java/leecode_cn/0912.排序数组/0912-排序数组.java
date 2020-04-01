class Solution {
    public int [] merge_sort(int [] input) {
      if (input.length <= 1) {
        return input;
      }
      int pivot = input.length / 2;
      int [] left_list = merge_sort(Arrays.copyOfRange(input, 0, pivot));
      int [] right_list = merge_sort(Arrays.copyOfRange(input, pivot, input.length));
      return merge(left_list, right_list);
    }
    
    public int [] merge(int [] left_list, int [] right_list) {
      int [] ret = new int[left_list.length + right_list.length];
      int left_cursor = 0, right_cursor = 0, ret_cursor = 0;

      while (left_cursor < left_list.length && 
             right_cursor < right_list.length) {
        if (left_list[left_cursor] < right_list[right_cursor]) {
          ret[ret_cursor++] = left_list[left_cursor++];
        } else {
          ret[ret_cursor++] = right_list[right_cursor++];
        }
      }
      // append what is remain the above lists
      while (left_cursor < left_list.length) {
        ret[ret_cursor++] = left_list[left_cursor++];
      }
      while (right_cursor < right_list.length) {
        ret[ret_cursor++] = right_list[right_cursor++];
      }  
      return ret;
    }
    
    private void quickSort(int[] nums, int left, int right) {
        if(left >= right) return;
        int partition = partition(nums, left, right);
        quickSort(nums, left, partition - 1);
        quickSort(nums, partition + 1, right);
    }
    
    private int partition(int[] nums, int left, int right) {
        int pivot = (left + right) >>> 1, partitionIdx = left;
        for(int i = left; i <= right; i++) {
            if(i == pivot) continue;
            if(nums[i] <= nums[pivot]) {
                swap(nums, i, partitionIdx);
                if(partitionIdx == pivot) {
                    pivot = i;
                }
                partitionIdx++;
            }
        }
        swap(nums, pivot, partitionIdx);
        return partitionIdx;
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    public int[] sortArray(int[] nums) {
        if (nums.length <= 1) {
            return nums;
        }
        // quickSort(nums, 0, nums.length - 1);
        // return nums;
        
        int pivot = nums.length / 2;
        int [] left_list = merge_sort(Arrays.copyOfRange(nums, 0, pivot));
        int [] right_list = merge_sort(Arrays.copyOfRange(nums, pivot, nums.length));
        return merge(left_list, right_list);
    }
}