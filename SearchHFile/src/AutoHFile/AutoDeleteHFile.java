package AutoHFile;

import java.io.IOException;
import java.util.Scanner;

public class AutoDeleteHFile {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.out.println("����ifile����·����");  //  D:\ii
		Scanner sc=new Scanner(System.in);
		String ifilepath=sc.next();
		
		System.out.println("����HFile����·����");
		Scanner scHFilePathfeature=new Scanner(System.in);
		String HFilepathfeature=scHFilePathfeature.next();  //  D:\GIT_ROOT\pld_0.2\source\PLD
		HFilepathfeature=HFilepathfeature.toLowerCase();
		
		String finaltxtpath=SearchHFile.iteratorTrans(ifilepath,SearchHFile.getHFilePathfeature(HFilepathfeature));
		System.out.println(HFilepathfeature);
		
		System.out.println("�õ���hfile�����б�Ϊ��"+finaltxtpath);
		
		
		System.out.println("����hfiles����·����");   //  D:\GIT_ROOT\pld_0.2\source\PLD
		Scanner sc2=new Scanner(System.in);
		String hfilePath=sc2.next(); 
		hfilePath=hfilePath.toLowerCase();
		
		String finaloutput=DeleteHFile.deleteHFile(finaltxtpath, hfilePath, HFilepathfeature);
		System.out.println("����ɾ���ļ����嵥·��Ϊ��"+finaloutput);
	}

}
