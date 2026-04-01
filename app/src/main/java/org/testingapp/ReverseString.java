package org.testingapp;

import java.util.Arrays;

public class ReverseString {

    
  public String reverse(String orgString){

    if(orgString.length()==0){
        return orgString;
    }

    char charArray[] = orgString.toCharArray();

    int start = 0;
    int end = orgString.length() -1;


    while(start <= end){
        char temp = charArray[start];
        charArray[start] = charArray[end];
        charArray[end] = temp;
        start++;
        end--;
    }
    return new String(charArray);
  }



  public String throwsExample(int x){
    if(x==0){
        throw new IllegalArgumentException();
    }
    return "Working";
  }



  public int[] arraysExample(int arr[]){
    Arrays.sort(arr);
    return arr;
  }

}