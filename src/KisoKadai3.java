import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class KisoKadai3 {
	public static void main(String[] args) throws Exception {

		System.out.println("メニュー");
		System.out.println("1 ファイルを作成します。");
		System.out.println("2 ファイルに追記します。");
		System.out.println("3 ファイルに上書き保存します。");
		System.out.println("4 終了します。");
		System.out.println();
		System.out.println("入力してください：");

		int menu = new java.util.Scanner(System.in).nextInt();
		String text = "C:\\tmp\\newfile.txt"; //後で入力できるように変更する。




		String filename = "newfile";
		FileWriter fw = null;

		switch (menu){
		case 1:
			File newfile = new File("C:\\tmp\\newfile.txt");

		    try{
		      if (newfile.createNewFile()){
		        System.out.println("ファイルの作成に成功しました");
		      }else{
		        System.out.println("ファイルの作成に失敗しました");
		      }
		    }catch(IOException e){
		      System.out.println(e);
		    }
		break;





		case 2:
			String kakikomi= new java.util.Scanner(System.in).nextLine();


			 try{
			      File file = new File("C:\\tmp\\newfile.txt");

			      if (checkBeforeWritefile(file)){
			        FileWriter filewriter = new FileWriter(file,true);

			        filewriter.write(kakikomi);

			        filewriter.close();
			      }else{
			        System.out.println("ファイルに書き込めません。");
			      }
			    }catch(IOException e){
			      System.out.println(e);
			    }

		System.out.println("ファイルに追記します。");
		break;




		case 3:
			String uwagaki= new java.util.Scanner(System.in).nextLine();


			 try{
			      File file = new File("C:\\tmp\\newfile.txt");

			      if (checkBeforeWritefile(file)){
			        FileWriter filewriter = new FileWriter(file);

			        filewriter.write(uwagaki);

			        filewriter.close();
			      }else{
			        System.out.println("ファイルに書き込めませんでした。");
			      }
			    }catch(IOException e){
			      System.out.print(e);

			    }


			 System.out.println("ファイルを上書き保存しました。");
				break;





		case 4://ファイルの読み込み＆場所移動






		default:
		System.out.println("終了します。");
		break;
		}
	}
	private static boolean checkBeforeWritefile(File file){
		if (file.exists()){
			if (file.isFile() && file.canWrite()){
				return true;
			}
		}
		return false;
	}

}