package com.twh.door.study.algorithm_suanfa;

import java.util.Scanner;

public class Stack {
        int [] data; //保存数据
        int size;	//栈中元素个数
        int maxSize;//栈的最大容量
        int top=0;  //栈顶指针

        public Stack(int maxSize){
            this.maxSize=maxSize;
            this.data=new int[maxSize];
        }

        public void push(int val){
            if(this.size==this.maxSize){
                System.out.println("error");
            }else{
                data[top++]=val;
                this.size++;
            }
        }

        public void top(){
            if(this.size==0){
                System.out.print("error");
            }else{
                System.out.println(data[top-1]);
                this.size--;
            }
        }

        public void pop(){
            if(this.size==0){
                System.out.println("error");
            }else{
                System.out.println(data[--top]);
                this.size--;
            }
        }
}

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.valueOf(scanner.nextLine());

        Stack stack = new Stack(n);
        while (scanner.hasNextLine()) {
            String string = scanner.nextLine();
            String arr[] = string.split(" ");
            if (arr[0].equals("push")) {
                stack.push(Integer.valueOf(arr[1]));
            } else if (arr[0].equals("pop")) {
                stack.pop();
            } else {
                stack.top();
            }
        }
    }
}
