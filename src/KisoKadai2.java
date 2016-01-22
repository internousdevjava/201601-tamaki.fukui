import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;



public class KisoKadai2 {
	public static void main(String[] args) {

	System.out.println("数当てゲーム");

	Random rnd = new Random();
    int ans = rnd.nextInt(100)+1;
    System.out.println("整数を入力してください。");
    int num=new Scanner(System.in).nextInt();

    while(true){
    	try{
    	if(num<ans){
    		System.out.println(num+"よりも大きい数字です。");
    		num =  new Scanner(System.in).nextInt();
			continue;

    	}else if(num>ans){
    		System.out.println(num+"よりも小さい数字です。");
    		num =  new Scanner(System.in).nextInt();
			continue;

    	}else if(num==0){
    		System.out.println("0は入力できません。");
    		num =  new Scanner(System.in).nextInt();
			continue;

    	}else if(num>100){
    		System.out.println("100以上は入力できません。");
    		num =  new Scanner(System.in).nextInt();
			continue;

    	}else if(num==ans){
    		System.out.println("正解です！");
    		ans =  new Scanner(System.in).nextInt();

    		break;
    	}
    	}catch (

    			InputMismatchException e)

    			{
    				System.out.println("型が違います。最初から数字を入れてください。");
    				num = new Scanner(System.in).nextInt();
    			}
    	}
    }
}
