public class Test01 {
    public static void main(String[] args) {
        // 斐波拉切数列
        int n = 10;
        int a = 0, b = 1, c;         // 初始化
        System.out.print(a + " " + b); // 输出 0 1
        for (int i = 2; i < n; i++) {
            c = a + b;
            System.out.print(" " + c); // 输出 1 1 2 3 5 8 13 21 34 55
            a = b;
            b = c;
        }
    }
}
