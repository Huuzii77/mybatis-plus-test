package com.example.demo;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * @author chendesheng
 * @create 2019/9/18 19:25
 */
public class Sort {

    public static void main(String[] args) {

        int[] numbers = new int[]{1, 7, 4, 6, 9, 10, 2};

        int[] sortNum = sortNumbers(numbers);

        /*for (int z = 0; z < sortNum.length; z++) {
            System.out.print(sortNum[z] + "\t");
        }*/


        List<Integer> nums = Arrays.asList(1, 8, 2, 6, 5);
        Iterator<Integer> iterator = nums.iterator();
        while (iterator.hasNext()){
            Integer num = iterator.next();
            System.out.println(num);
        }




    }


    public static List<Integer> sort(List<Integer> list){
        for (int i=0;i<list.size();i++){
            for (int j=i+1;j<list.size();j++){
                if (list.get(i)<list.get(j)){
                    list.set(i,list.get(j));
                    list.set(j,list.get(i));
                }
                System.out.println(list);
            }
        }
        return list;
    }


    public static int[] sortNumbers(int[] numbers) {

        for (int i = 0; i < numbers.length; i++) {

            for (int j = i + 1; j < numbers.length; j++) {

                if (numbers[i] < numbers[j]) {
                    int temp = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = temp;
                }

            }
        }

        return numbers;
    }
}
