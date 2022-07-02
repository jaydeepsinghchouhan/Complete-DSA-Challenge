import java.util.*;
class Min_Max {
		
		public static int max(int num1, int num2, int num3) {
				if(num1>=num2 && num1>=num3) {
						return num1;
				}
				else if(num2>=num3 && num2>=num1) {
						return num2;
				}
				else if(num3>=num1 && num3>=num2) {
						return num3;
				}
				return -1;	
		}

		public static int min(int num1, int num2, int num3) {
				if(num1<=num2 && num1<=num3) {
						return num1;
				}
				else if(num2<=num3 && num2<=num1) {
						return num2;
				}
				else if(num3<=num1 && num3<=num2) {
						return num3;
				}
				return -1;	
		}
		
		public static void main(String [] args) {
				Scanner sc = new Scanner(System.in);
				int num1,num2,num3;
				num1 = sc.nextInt();
				num2 = sc.nextInt();
				num3 = sc.nextInt();
				System.out.println("Minimum of three no. is : "+min(num1,num2,num3));
				System.out.println("Maximum of three no. is : "+max(num1,num2,num3));
				
		}
}