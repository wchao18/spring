package com.imooc.demo.resource;

import org.springframework.core.io.FileSystemResource;

import java.io.*;

public class ResourceDemo {
	public static void main(String[] args) throws IOException {
		FileSystemResource fileSystemResource = new FileSystemResource(
				"D:\\IDEAProject\\springboot-source\\springframework5.2.0" +
                        ".release\\springdemo\\src\\main\\java\\com\\imooc\\demo\\resource\\test.txt"
		);
		File file = fileSystemResource.getFile();
		System.out.println(file.length());
		OutputStream outputStream =  fileSystemResource.getOutputStream();
		BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
		bufferedWriter.write("Hello World 哈哈");
		bufferedWriter.flush();
		outputStream.close();
		bufferedWriter.close();
	}
}
