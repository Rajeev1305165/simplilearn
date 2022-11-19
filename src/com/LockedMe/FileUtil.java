package com.LockedMe;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileUtil {
	String filepath="D:\\LockedMe Files\\";
	/*public FileUtil() {
		
		File f=new File("D://java");
		String[] fs=f.list();
		for(String file:fs)
		{
			count++;
			files.add(new MyFile(count, file));
		}
	}*/
	public List<MyFile> getFiles()


	{	List<MyFile> files=new ArrayList<>();
	 int count=0;

		File f=new File(filepath);
		String[] fs=f.list();
		for(String file:fs)
		{
			count++;
			files.add(new MyFile(count, file));
		}
		return files;
	}
	public void addFile(String fileName) throws IOException {
		File f=new File(filepath+fileName+".txt");
		f.createNewFile();
	}
	public boolean deleteFile(String fileName)
	{
		List<MyFile> files=new ArrayList<>();

		boolean isDeleted=false;
		files=getFiles();
		for(MyFile file:files)
		{
			if(file.getFileName().startsWith(fileName))
			{
				File f=new File(filepath+file.getFileName());
				f.delete();
				isDeleted=true;
				break;
			}
		}
		return isDeleted;
	}
	public boolean search(String fileName)
	{
		List<MyFile> files=new ArrayList<>();

		boolean isIdentified=false;
		files=getFiles();
		for(MyFile file:files)
		{
			if(file.getFileName().startsWith(fileName))
			{
				isIdentified=true;
				break;
			}
		}
		return isIdentified;
	}
}
