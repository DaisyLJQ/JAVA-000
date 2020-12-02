package com.example.corestudy.jvm;

/**
 * 编译字节码示例文件
 *
 * @author jiaqian
 */
public class HelloWord {

    private int sum;
    private int num;


    public int add(int a) {
        num++;
        sum = sum + a;
        return sum;
    }

    public double average(int b) {
        num++;
        sum = b + sum;
        return (double) sum / num;
    }

    public double del(int b) {
        num++;
        return sum - b;
    }


    public double mul(int b) {
        num++;
        sum = sum * b;

        return sum;
    }


    public static void main(String[] args) {
        HelloWord helloWord = new HelloWord();
        helloWord.add(2);
        helloWord.del(1);
        helloWord.average(3);
        helloWord.mul(4);
        System.out.println("次数：" + helloWord.num + "---------" + "求和：" + helloWord.sum);


    }
}
