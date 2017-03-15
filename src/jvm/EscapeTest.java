package jvm;

import java.io.IOException;

/**
 * @author Kevin
 * @description
 * @date 2017/3/15
 * VM:-Xmx3G -Xmn2G -server -XX:+DoEscapeAnalysis -XX:-TieredCompilation
 * 开启逃逸分析堆上User实例远远小于20W个,关闭后User对象在堆上分配数量为20W
 * 通过jps查看pid,再通过jmap -histo pid查看对于对象的数量
 * 关闭分层编译也可以有效减少User对象在堆上分配的数量
 * JDK1.7默认打开了逃逸分析,关闭了分层编译
 */
public class EscapeTest {

    public static void main(String[] args) throws InterruptedException, IOException {
        int sum = 0;
        int count = 1000000;
        for (int i = 0; i < count; i++) {
            sum += fn(i);
        }

        Thread.sleep(500);

        for (int i = 0; i < count; i++) {
            sum += fn(i);
        }

        System.out.println(sum);
        System.in.read();
    }

    private static int fn(int age) {
        User user = new User(age);
        int i = user.getAge();
        return i;
    }

    static class User {
        private final int age;

        public User(int age) {
            this.age = age;
        }

        public int getAge() {
            return age;
        }
    }
}