package buf;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class buf {

public static void main(String[] args)throws IOException {
		// TODO �Զ����ɵķ������

		// TODO �Զ����ɵķ������
		int i=0;
		System.out.println("1:��ѧ");
		System.out.println("2:����");
		System.out.println("3:Ӣ��");
		System.out.println("4:����");
		System.out.println("5:��ѧ");
		System.out.println("������ѡ��Ŀ���ţ�");		
		BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
	
	//	 i = reader.read();  //��ȡ�ַ��� 
			  try {  
	             i = reader.read();  //��ȡ�ַ��� 
	         } catch (IOException e) {  
	             e.printStackTrace();  
	         } /* */

		switch(i)
		{
			case 1:
			{
				System.out.println("��ѡ�������ѧ�γ�");
				break;
			}
			case 2:
			{
				System.out.println("��ѡ��������Ŀγ�");
				break;
			}
			case 3:
			{
				System.out.println("��ѡ�����Ӣ��γ�");
				break;
			}
			case 4:
			{
				System.out.println("��ѡ���������γ�");
				break;
			}
			case 5:
			{
				System.out.println("��ѡ����ǻ�ѧ�γ�");
				break;
			}
			
		}	
	
	}

}

