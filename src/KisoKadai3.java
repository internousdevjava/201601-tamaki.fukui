import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class KisoKadai3 {
	public static void main(String[] args) throws Exception {


		while(true){
		System.out.println();
		System.out.println("メニュー");
		System.out.println("1 ファイルを作成します。");
		System.out.println("2 ファイルに追記します。");
		System.out.println("3 ファイルに上書き保存します。");
		System.out.println("4 ファイルを読み取ります。");
		System.out.println("5 終了します。");
		System.out.println();
		System.out.println("入力してください：");

		String menu = new java.util.Scanner(System.in).nextLine();



		try{
			int menuInt = Integer.parseInt(menu);



		String filename = "newfile";
		FileWriter fw = null;

		switch (menuInt){






		case 1:

			System.out.println("ファイル名を入力してください：");
			System.out.println("例：c:\\\\xxx\\\\xxx");
			String 新規ファイル名 = new java.util.Scanner(System.in).nextLine();


			File newfile = new File( 新規ファイル名 + ".txt" );


		    try{
		      if (newfile.createNewFile()){
		        System.out.println("ファイルの作成に成功しました");
		      }else{
		        System.out.println("ファイルの作成に失敗しました");
		      }
		    }catch(IOException e){
		      System.out.println(e);
		    }
		continue;











		case 2:
			System.out.println("ファイル名を入力してファイルを指定してください。");
			System.out.println("例：c:\\\\xxx\\\\xxx.txt");


			String tuiki = new java.util.Scanner(System.in).nextLine();


			File file = new File(tuiki);
			if (file.exists()){



				System.out.println("ファイルは存在します" );

			}else{
				System.out.println("ファイルは存在しないため、");

				file.createNewFile();

				System.out.println(tuiki+"ファイルを新たに作成しました。");
			}





			 try{

				 System.out.println("編集内容を入力してください。");

				 File tuikafile = new File(tuiki);

			      if (checkBeforeWritefile(tuikafile)){

			        FileWriter filewriter = new FileWriter(tuikafile,true);

					String 書き込み内容 = new java.util.Scanner(System.in).nextLine();


			        filewriter.write( 書き込み内容 + "\n" );

			        filewriter.close();

			      }else{
			        System.out.println("ファイルに書き込めません。");
			      }
			    }catch(IOException e){
			      System.out.println(e);
			    }

			 System.out.println("上記の内容をファイルに追記します。");
			 continue;








		case 3:
			System.out.println("上書きするファイルを入力してください。");
			System.out.println("例：c:\\\\xxx\\\\xxx.txt");

			String uwagaki = new java.util.Scanner(System.in).nextLine();


			 try{
			      File 上書きファイル = new File(uwagaki);

			      if (checkBeforeWritefile(上書きファイル)){

			        FileWriter filewriter = new FileWriter(上書きファイル);

			        System.out.println("編集する内容を入力してください。");

			        String 編集内容 = new java.util.Scanner(System.in).nextLine();
			        filewriter.write(編集内容);

			        filewriter.close();

			      }else{

			        System.out.println("ファイルに書き込めませんでした。");
			      }
			    }catch(IOException e){
			      System.out.print(e);
			    }


			 System.out.println("ファイルを上書き保存しました。");
				continue;






		case 4:
			System.out.println("読み込みするファイルを入力してください。");
			System.out.println("例：c:\\\\xxx\\\\xxx.txt");

			String shitei = new java.util.Scanner(System.in).nextLine();


			 try{
			     file = new File(shitei);
			      FileReader filereader = new FileReader(file);

			      int ch;
			      while((ch = filereader.read()) != -1){
			        System.out.print((char)ch);
			      }


			      filereader.close();
			 }catch(FileNotFoundException e){
			      System.out.println(e);
			    }catch(IOException e){
			      System.out.println(e);
			    }

			 continue;

		case 5:

			System.out.println("終了しました。");
			break;

		default:
					System.out.println("入力できません。");
					continue;
				}break;
		}catch(NumberFormatException e){
			System.out.println("もう一度入力してください");
			continue;

		}

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

