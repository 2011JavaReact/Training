package com.revature.fileio;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Driver {

	// When making canstants (Final fields) convention suggests using upper snake
	// casing
	private final String FILE_NAME = "files/myfile.csv";
	private FileOutputStream fos = null;
	private FileInputStream fis = null;
	private FileWriter fw = null;
	private FileReader fr = null;
	private BufferedReader br = null;
	private BufferedWriter bw = null;

	public static void main(String[] args) {
		System.out.println("=====APP START====");
		Driver driver = new Driver();
		try {
//			driver.fosExample();
//			driver.fisExample();
//			driver.fileReaderAndWriterExample();
			driver.bufferedExample();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("=====APP END====");

	}

	public void fosExample() throws IOException {
		/*
		 * FileInput/OutputStreams -these streams are able to write/read data ONE BYTE
		 * at a time
		 */

		try {
			fos = new FileOutputStream(FILE_NAME);
			char rand;

			for (int i = 0; i < 10; i++) {
				for (int j = 0; j < 15; j++) {
					rand = (char) ((Math.random() * 26) + 'A');
					fos.write((byte) rand);// write is the method that will write to the file
					if (j < 14) {
						fos.write(',');
					}
				}
				fos.write('\n');
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fos != null) {
				fos.close();
			}
		}
		/*
		 * Though Java is good at it, it is not perfect at closing all of its resources.
		 * In the interest of preventing memory leaks, we should always close our
		 * streams if we open them.
		 */
	}

	public void fisExample() throws IOException {
		try {
			fis = new FileInputStream(FILE_NAME);
			byte in;
			// When reading in bytes, if you ever get -1, that means that you have
			// reached the end of the file

			while ((in = (byte) fis.read()) != -1) {
				System.out.print((char) in);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fis != null) {
				fis.close();
			}
		}

	}
	
	public void fileReaderAndWriterExample() throws IOException {
		/*
		 * File Reader/Writer
		 * -The underlying difference between a file reader and a file writer is that
		 * reader reads from a file writer writes to a file. FW and FR are dfferent from
		 * fos and fis in the following way: the reader and writer read or write one
		 * character at a time as opposed to their counterparts (fos and fis) that
		 * will go one byte at a time. (now we can read two bytes at a time)
		 */
		
		try {
			fr = new FileReader(FILE_NAME);
			fw = new FileWriter(FILE_NAME.split("\\.")[0] +
								"_lowercase." +
								FILE_NAME.split("\\.")[1]);
			
			int in;
			
			while((in = fr.read()) != -1) {
				if (in == 10 || in == 44) { //checking for \n or ,
					fw.write((char)in);
				}else {
					fw.write((char)(in+32)); //change from uppercase to lowercase
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(fr!=null) {
				fr.close();
			}
			if(fw!=null) {
				fw.close();
			}
		}
	}
	
	/*
	 * BufferedReaders/Writers are a wrapping class that makes interpreting streams
	 * significantly easier (sort of like the Scanner class.... but in my opinion scanner
	 * is easier to use)
	 * they have the option to parse streams on per line basis or even on a custom buffer
	 * basis.
	 */
	
	public void bufferedExample() throws IOException {
		try {
			br = new BufferedReader(new FileReader(FILE_NAME));
			bw = new BufferedWriter(new FileWriter("files/myfile_chaos.csv"));
			
			String input = "";
			
			while((input = br.readLine()) != null) { //when we get to the end of a line
				//with buffered reader, we get a null value instead of -1
				input = input.replaceAll("A", "REDACTED");
				input += '\n';
				bw.write(input);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(br!=null) {
				br.close();
			}
			if(bw!=null) {
				bw.close();
			}
		}
	}

}
