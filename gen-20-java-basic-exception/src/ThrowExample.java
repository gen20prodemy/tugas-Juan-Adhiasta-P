public class ThrowExample {
    public static int contoh(int a) throws ArithmeticException{
        int x = a-1;
        int y = 0;
        a = x/y;
//        if (x >0){
//            a = x/y;
//        } else {
//            a = 1/y;
//        }
        return a;
    }
}
