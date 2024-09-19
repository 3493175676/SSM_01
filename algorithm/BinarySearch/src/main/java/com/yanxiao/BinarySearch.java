package com.yanxiao;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BinarySearch {


    public static int binarySearchBasic(int[] a, int target) {
        int i = 0, j = a.length - 1;  //设置指针和初值
        while (i <= j) {              //i~j 范围内有东西
            int m = (i + j) >>> 1   ;
            if(target < a[m]) {       //目标在左边
                j = m - 1;
            } else if (a[m] < target) {//目标在右边
                i = m + 1;
            }else {                   //找到了
                return m;
            }
        }
        return -1;
    }

    //二分查找改动版：
    public static int binarySearchAlternative(int[] a, int target) {
        int i = 0, j = a.length;  //第一处
        while (i < j) {              // 第二处
            int m = (i + j) >>> 1   ;
            if(target < a[m]) {
                j = m;
            } else if (a[m] < target) { // 第三处
                i = m + 1;
            }else {
                return m;
            }
        }
        return -1;
    }


    @Test
    @DisplayName("binarySearchBasic 找到")
    public void test1(){
        int[] a = {7,13,21,30,38,44,52,53};
        assertEquals(0,binarySearchBasic(a,7));
        assertEquals(1,binarySearchBasic(a,13));
        assertEquals(2,binarySearchBasic(a,21));
        assertEquals(3,binarySearchBasic(a,30));
        assertEquals(4,binarySearchBasic(a,38));
        assertEquals(5,binarySearchBasic(a,44));
        assertEquals(6,binarySearchBasic(a,52));
        assertEquals(7,binarySearchBasic(a,53));
    }

    @Test
    @DisplayName("binarySearchBasic 没找到")
    public void test2(){
        int[] a = {7,13,21,30,38,44,52,53};
        assertEquals(-1,binarySearchBasic(a,0));
        assertEquals(-1,binarySearchBasic(a,15));
        assertEquals(-1,binarySearchBasic(a,60));
    }
}
