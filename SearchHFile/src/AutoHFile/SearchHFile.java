package AutoHFile;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class SearchHFile {
	String patternContent = "";
	static Queue<String> outputFilePath = new LinkedList<String>();

	/**
	 * ��ȡ�ļ����ַ���������
	 * 
	 * @param path
	 * @return
	 * @throws IOException
	 */
	public static String readFileToString(String readPath,String HFilepath) throws IOException {
		Set<String> set = new HashSet<String>();
		StringBuffer sb = new StringBuffer("");
		FileReader reader = new FileReader(readPath);
		BufferedReader br = new BufferedReader(reader);
		String str = null;
		while ((str = br.readLine()) != null) {
			if (str.contains("\""+HFilepath)  //"d:\\\\git_root\\\\ldw_daily\\\\source\\\\ldw\\\\"
					&& str.contains(".h\"")) {
				String[] strArr = str.split("\"");
				for (String each : strArr) {
					if (each.contains(HFilepath)
							&& str.contains(".h")) {
						set.add("\"" + each + "\"");
					}
				}
			}
		}
		br.close();
		reader.close();
		for (String each : set) {
			sb.append(each + "\n");
		}
		return sb.toString();
	}
	
	
	public static String readFileToString2(String readPath,String HFilepath) throws IOException {
		Set<String> set = new HashSet<String>();
		StringBuffer sb = new StringBuffer("");
		FileReader reader = new FileReader(readPath);
		BufferedReader br = new BufferedReader(reader);
		String str = null;

		while ((str = br.readLine()) != null) {
			if (str.contains("\""+HFilepath)  //"d:\\\\git_root\\\\ldw_daily\\\\source\\\\ldw\\\\"
					&& str.contains(".h\"")) {
				String[] strArr = str.split("\"");
				for (String each : strArr) {
					if (each.contains(HFilepath)
							&& str.contains(".h")) {
						String neweach= each.replaceAll("\\\\\\\\","\\\\");
						set.add(neweach);
					}
				}
			}
		}
		br.close();
		reader.close();
		for (String each : set) {
			sb.append(each + "\n");
		}
		return sb.toString();
	}

	/**
	 * ��ȡ�ļ���allset������
	 * @param readPath
	 * @throws IOException
	 */
	public static Set<String>  readFileToset(String readPath,Set<String> set,String HFilepath) throws IOException {
		StringBuffer sb = new StringBuffer("");
		FileReader reader = new FileReader(readPath);
		BufferedReader br = new BufferedReader(reader);
		String str = null;
		while ((str = br.readLine()) != null) {
			
			if (str.contains("\""+HFilepath)  //"d:\\\\git_root\\\\ldw_daily\\\\source\\\\ldw\\\\"
					&& str.contains(".h\"")) {
				String[] strArr = str.split("\"");
				for (String each : strArr) {
					if (each.contains(HFilepath)
							&& str.contains(".h")) {
						set.add("\"" + each + "\"");
					}
				}
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
	 * ����һ������Ŀ¼�����ظ��ļ������еġ�i��β���ļ�
	 * 
	 * @param path
	 */
	public static Queue<String> searchAllIFile(String inputPath) {
		Queue<String> inputFilePath = new LinkedList<String>();
		File file = new File(inputPath);
		if (file.exists()) {
			File[] files = file.listFiles();
			if (files.length == 0) {
				return inputFilePath = null;
			} else {
				for (File file2 : files) {
					if (file2.isDirectory()) {
						searchAllIFile(file2.getAbsolutePath());
					} else {
						String tempName = file2.getName();
						if (tempName.trim().toLowerCase().endsWith(".i")) {
							inputFilePath.add(file2.getAbsolutePath()
									.toString());
							outputFilePath.add(inputPath + "\\finaloutput\\"
									+ tempName);
						}
					}
				}
			}
		} else {
			System.out.println("�ļ�������!");
		}
		return inputFilePath;
	}

    static boolean deleteDir(File dir) {
        if (dir.isDirectory()) {
            String[] children = dir.list();//�ݹ�ɾ��Ŀ¼�е���Ŀ¼��
            for (int i=0; i<children.length; i++) {
                boolean success = deleteDir(new File(dir, children[i]));
                if (!success) {
                    return false;
                }
            }
        }
        // Ŀ¼��ʱΪ�գ�����ɾ��
        return dir.delete();
    }
	
	/**���ҳ���Ӧ��.i�ļ��е�ָ�������ݷ��ص���Ӧ������ļ��У�Ȼ��ϲ���������ļ����ݵ�final0.txt�ļ��У�ȥ���ظ����ݣ�,���ת���ļ�Ϊfinal.txt��ʽ��
	 * @param inputPath
	 * @throws IOException
	 */
	static String iteratorTrans(String inputPath,String HFilepath) throws IOException {
		Set<String> allset = new HashSet<String>();
		String outPath = inputPath + "\\finaloutput\\";
		File file = new File(outPath);
		boolean bool = false;
		if (file.exists()) 
			bool=deleteDir(file);
//		System.out.println(bool);
		file.mkdir();
		
		Queue<String> inputFilePath = searchAllIFile(inputPath);
		while (!inputFilePath.isEmpty()) {
			String content = readFileToString(inputFilePath.poll(),HFilepath);
			writeFile(outputFilePath.poll(), content);
		}
		
		//����i�ļ���һ���ļ���
		Queue<String> outputFilePath = searchAllIFile(outPath);
		
		String content;
		while (!outputFilePath.isEmpty())
			allset=readFileToset(outputFilePath.poll(),allset,HFilepath);
		
		StringBuffer sb = new StringBuffer("");
		for (String each : allset) {
			sb.append(each + "\n");
		}
		content=sb.toString();
		writeFile(outPath+"final0.txt", content);
		
		String contentx =readFileToString2(outPath+"final0.txt",HFilepath);
		writeFile(outPath+"final.txt", contentx);
		System.out.println("д��final.txt�ɹ�"); 
		new File(outPath+"final0.txt").delete();
		return outPath+"final.txt";
	}
	/**
	 * ����HFilePath�����HFile�����ַ���
	 * @param HFilepath
	 * @return
	 */
	public static String getHFilePathfeature(String HFilepath){
		return HFilepath.replaceAll("\\\\", "\\\\\\\\");
		
	}

	public static void main(String[] args) throws IOException {
		String path="D:\\ii" ; //sc.next();
		String HFilepath="D:\\GIT_ROOT\\pld_0.2\\source\\PLD";//scHFilePath.next();
		HFilepath=HFilepath.toLowerCase();
		
		iteratorTrans(path,getHFilePathfeature(HFilepath));
	}


}