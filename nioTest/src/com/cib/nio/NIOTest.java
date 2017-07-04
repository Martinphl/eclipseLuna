package com.cib.nio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.Channel;
import java.nio.channels.FileChannel;

public class NIOTest {
	static String path = "src//niodata.txt";

	/**
	 * clear()方法会清空整个缓冲区。compact()方法只会清除已经读过的数据。
	 * 
	 * @throws IOException
	 */
	public static void NIOReadFile() throws IOException {
		RandomAccessFile aFile = new RandomAccessFile(path, "rw");
		FileChannel inChannel = aFile.getChannel();

		// create buffer with capacity of 48 bytes
		ByteBuffer buf = ByteBuffer.allocate(48);

		int bytesRead = inChannel.read(buf); // read into buffer.
		while (bytesRead != -1) {
			buf.flip(); // make buffer ready for read
			while (buf.hasRemaining()) {
				System.out.print((char) buf.get()); // read 1 byte at a time
			}
			buf.clear(); // make buffer ready for writing
			bytesRead = inChannel.read(buf);
		}
		aFile.close();

	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		NIOReadFile();
	}

}
