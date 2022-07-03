import java.util.*;

class Even_Odd {
    
		public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        evenOdd(num);

    }

		public static void evenOdd(int num) {
        if (num %2==0) {
            System.out.println("It is even.");
        } else {
            System.out.println("It is Odd.");
        }
    }

    
}