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
	 * 读取文件到allset集合中
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
	 * 给定一个输入目录，返回该文件下所有的.h结尾的文件
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
			System.out.println("文件不存在!");
		}
		return setDad;
	}

	// 首先读取final.txt文件的所有内容到setSon集合中，
	// 统计给定路径下的所有.h文件的路径，保存到setDad集合中
	// 删除集合setDad中包含的所有setSon的记录
	// 循环删除setDad中剩下的记录

	/**
	 * 删除指定路径下的文件
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
	 * 删除多余的H文件 // 首先读取final.txt文件的所有内容到setSon集合中， //
	 * 统计给定路径下的所有.h文件的路径，保存到setDad集合中 // 删除集合setDad中包含的所有setSon的记录 //
	 * 循环删除setDad中剩下的记录
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
		String finaltxtPath = "C:\\Users\\martin\\Desktop\\download\\预编译结果\\finaloutput\\final.txt";
		String inputPath = "d:\\git_root\\ldw_daily\\source\\ldw";
		String HFilepathfeature="d:\\git_root\\ldw_daily\\source\\ldw";
		deleteHFile(finaltxtPath, inputPath,HFilepathfeature);
	}
}