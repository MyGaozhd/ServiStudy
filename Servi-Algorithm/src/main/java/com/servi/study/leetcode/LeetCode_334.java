package com.servi.study.leetcode;

/**
 * 
 * 334. ��������Ԫ������ ����һ���������� nums ���ж�����������Ƿ���ڳ���Ϊ 3 �ĵ��������С�
 * 
 * ���������������Ԫ���±� (i, j, k) ������ i < j < k ��ʹ�� nums[i] < nums[j] < nums[k] ������ true
 * �����򣬷��� false ��
 * 
 * 
 * 
 * ʾ�� 1��
 * 
 * ���룺nums = [1,2,3,4,5] �����true ���ͣ��κ� i < j < k ����Ԫ�鶼�������� ʾ�� 2��
 * 
 * ���룺nums = [5,4,3,2,1] �����false ���ͣ������������������Ԫ�� ʾ�� 3��
 * 
 * ���룺nums = [2,1,5,0,4,6] �����true ���ͣ���Ԫ�� (3, 4, 5) �������⣬��Ϊ nums[3] == 0 <
 * nums[4] == 4 < nums[5] == 6
 * 
 * 
 * ��ʾ��
 * 
 * 1 <= nums.length <= 105 -231 <= nums[i] <= 231 - 1
 * 
 * 
 * ���ף�����ʵ��ʱ�临�Ӷ�Ϊ O(n) ���ռ临�Ӷ�Ϊ O(1) �Ľ��������
 *
 */
public class LeetCode_334 {

	public static void main(String[] args) {

//		int[] a = new int[] { 3,2,1,2,3 };
		
		int[] a = new int[] { 10, 12, 5, 13 };
		System.out.print(new LeetCode_334().increasingTriplet(a));
	}

	public boolean increasingTriplet(int[] nums) {

//		int count = 0;
//
//		for (int i = 1; i < nums.length && count < 2; i++) {
//			if (nums[i] > nums[i - 1]) {
//				count++;
//			} else {
//				count = 0;
//			}
//		}
//
//		return count == 2;

		int one = Integer.MAX_VALUE, two = Integer.MAX_VALUE;
		for (int three : nums) {
			if (three > two)
				return true;
			else if (three <= one)
				one = three;
			else
				two = three;
			// if(three > one && three < two) two = three;
		}
		return false;

	}
}
