package love.cq.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.RandomAccessFile;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;

/**
 * java 一个简单的io操作
 * 
 * @author ansj
 * 
 */
public class IOUtil {
	public static final String UTF8 = "utf-8";
	public static final String GBK = "gbk";

	private static InputStream is = null;
	private static FileOutputStream fos = null;

	public static InputStream getInputStream(String path) {
		try {
			return new FileInputStream(path);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static BufferedReader getReader(String path, String charEncoding) throws UnsupportedEncodingException {
		is = getInputStream(path);
		return new BufferedReader(new InputStreamReader(is, charEncoding));
	}

	public static RandomAccessFile getRandomAccessFile(String path, String charEncoding) throws FileNotFoundException {
		is = getInputStream(path);
		if (is != null) {
			return new RandomAccessFile(new File(path), "r");
		}
		return null;
	}

	public static void Writer(String path, String charEncoding, String content) {
		try {
			fos = new FileOutputStream(new File(path));
			fos.write(content.getBytes(charEncoding));
			fos.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void close() {
		if (is != null) {
			try {
				is.close();
			} catch (IOException e) {
				is = null;

				e.printStackTrace();
			}
			is = null;
		}
	}

	public static BufferedReader getReader(InputStream inputStream, String charEncoding) throws UnsupportedEncodingException {
		return new BufferedReader(new InputStreamReader(inputStream, charEncoding));
	}

	public static String getContent(String path, String charEncoding) {
		return getContent(new File(path), charEncoding);
	}

	public static String getContent(InputStream is, String charEncoding) {
		BufferedReader reader = null;
		try {
			reader = IOUtil.getReader(is, charEncoding);
			return getContent(reader);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return "";
	}

	public static String getContent(File file, String charEncoding) {
		InputStream is = null;
		try {
			is = new FileInputStream(file);
			return getContent(is, charEncoding);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				is.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return "";
	}

	public static String getContent(BufferedReader reader) throws IOException {
		StringBuilder sb = new StringBuilder();
		String temp = null;
		while ((temp = reader.readLine()) != null) {
			sb.append(temp);
			sb.append("\n");
		}
		return sb.toString();
	}

	/**
	 * 将一个对象序列化到硬盘中
	 * 
	 * @param string
	 * @param hm
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	public static void WriterObj(String path, Serializable hm) throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		ObjectOutputStream objectOutputStream = null;
		try {
			objectOutputStream = new ObjectOutputStream(new FileOutputStream(path));
			objectOutputStream.writeObject(hm);
		} finally {
			if (objectOutputStream != null) {
				objectOutputStream.close();
			}
		}
	}
}