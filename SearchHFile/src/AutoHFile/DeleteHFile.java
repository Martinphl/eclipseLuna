package AutoHFile;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class DeleteHFile {
	static Set<String> setDad = new HashSet<String>();
	/**
	 * ��ȡ�ļ���allset������
	 * 
	 * @param readPath
	 * @throws IOException
	 */
	public static Set<String> readFileToset(String readPath, Set<String> set,String HFilepath)
			throws IOException {
		StringBuffer sb = new StringBuffer("");
		FileReader reader = new FileReader(readPath);
		BufferedReader br = new BufferedReader(reader);
		String str = null;
		while ((str = br.readLine()) != null) {
			if (str.contains(HFilepath)
					&& str.contains(".h")) {
				set.add(str);

			}
		}
		br.close();
		reader.close();
		return set;
	}

	/**
	 * write string to file
	 * 
	 * @param writePath
	 * @param writeContent
	 * @throws IOException
	 */
	public static void writeFile(String writePath, String writeContent)
			throws IOException {
		FileWriter writer = new FileWriter(writePath);
		BufferedWriter bw = new BufferedWriter(writer);
		bw.write(writeContent);
		bw.flush();
		bw.close();
		writer.close();
	}

	/**
	 * ����һ������Ŀ¼�����ظ��ļ������е�.h��β���ļ�
	 * 
	 * @param path
	 */
	public static Set<String> searchAllHFile(String inputPath) {
		File file = new File(inputPath);
		if (file.exists()) {
			File[] files = file.listFiles();
			if (files.length == 0) {
				return setDad = null;
			} else {
				for (File file2 : files) {
					if (file2.isDirectory()) {
						searchAllHFile(file2.getAbsolutePath());
					} else {
						String tempName = file2.getName();
						if (tempName.trim().toLowerCase().endsWith(".h")) {
							setDad.add(file2.getAbsolutePath().toString());
						}
					}
				}
			}
		} else {
			System.out.println("�ļ�������!");
		}
		return setDad;
	}

	// ���ȶ�ȡfinal.txt�ļ����������ݵ�setSon�����У�
	// ͳ�Ƹ���·���µ�����.h�ļ���·�������浽setDad������
	// ɾ������setDad�а���������setSon�ļ�¼
	// ѭ��ɾ��setDad��ʣ�µļ�¼

	/**
	 * ɾ��ָ��·���µ��ļ�
	 * 
	 * @param deletePath
	 */
	static void deleteFile(String deletePath) {
		File file = new File(deletePath);
		if (file.exists()) {
			file.delete();
		}
	}

	/**
	 * ɾ�������H�ļ� // ���ȶ�ȡfinal.txt�ļ����������ݵ�setSon�����У� //
	 * ͳ�Ƹ���·���µ�����.h�ļ���·�������浽setDad������ // ɾ������setDad�а���������setSon�ļ�¼ //
	 * ѭ��ɾ��setDad��ʣ�µļ�¼
	 * 
	 * @param finaltxtPath
	 * @param inputPath
	 * @throws IOException
	 */
	static String deleteHFile(String finaltxtPath, String inputPath,String HFilepathfeature)
			throws IOException {
		Set<String> setSon = new HashSet<String>();
		Set<String> setDad = new HashSet<String>();
		setSon = readFileToset(finaltxtPath, setSon,HFilepathfeature);
		setDad = searchAllHFile(inputPath);

		Set<String> setDad2 = new HashSet<String>();
		for(String each:setDad){
			if(setSon.contains(each.toLowerCase()))
				setDad2.add(each);
		}
		setDad.removeAll(setDad2);

		StringBuffer sb = new StringBuffer("");
		for (String each : setDad) {
			sb.append(each + "\n");
		}
		
		String content = sb.toString();
		writeFile(inputPath + "\\" + "finaloutput.txt", content);
		for (String each : setDad) {
			deleteFile(each);
		}
		return inputPath + "\\" + "finaloutput.txt";
	}

	public static void main(String[] args) throws IOException {
		String finaltxtPath = "C:\\Users\\martin\\Desktop\\download\\Ԥ������\\finaloutput\\final.txt";
		String inputPath = "d:\\git_root\\ldw_daily\\source\\ldw";
		String HFilepathfeature="d:\\git_root\\ldw_daily\\source\\ldw";
		deleteHFile(finaltxtPath, inputPath,HFilepathfeature);
	}
}