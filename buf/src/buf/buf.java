package buf;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class buf {

public static void main(String[] args)throws IOException {
		// TODO 自动生成的方法存根

		// TODO 自动生成的方法存根
		int i=0;
		System.out.println("1:数学");
		System.out.println("2:语文");
		System.out.println("3:英语");
		System.out.println("4:物理");
		System.out.println("5:化学");
		System.out.println("请输入选择的课题号：");		
		BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
	
	//	 i = reader.read();  //获取字符串 
			  try {  
	             i = reader.read();  //获取字符串 
	         } catch (IOException e) {  
	             e.printStackTrace();  
	         } /* */

		switch(i)
		{
			case 1:
			{
				System.out.println("您选择的是数学课程");
				break;
			}
			case 2:
			{
				System.out.println("您选择的是语文课程");
				break;
			}
			case 3:
			{
				System.out.println("您选择的是英语课程");
				break;
			}
			case 4:
			{
				System.out.println("您选择的是物理课程");
				break;
			}
			case 5:
			{
				System.out.println("您选择的是化学课程");
				break;
			}
			
		}	
	
	}

}

