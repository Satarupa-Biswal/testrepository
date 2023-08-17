package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class CreateZip {

	public static void createZip() throws IOException {
		String path = System.getProperty("user.dir") + "\\TestReport";

		File directoryToZip = new File(path);
		String filename = directoryToZip.getName() + " "
				+ new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date()) + ".zip";

		String screenshotpath = System.getProperty("user.dir") + "\\Screenshots";

		File Screenshotsdir = new File(screenshotpath);

		List<File> fileList = new ArrayList<File>();
		System.out.println("---Getting references to all files in: " + directoryToZip.getCanonicalPath());
		getAllFiles(directoryToZip, fileList);

		if (Screenshotsdir.exists())
			getAllFiles(Screenshotsdir, fileList);

		System.out.println("---Creating zip file");
		writeZipFile(directoryToZip, Screenshotsdir, fileList, filename);
		System.out.println("---Done");

		if (ifZipCreated(filename)) {
			deleteDirectory(new File(path));
			deleteDirectory(new File(screenshotpath));
		} else
			System.out.println("ZIP Creation failed");
	}

	public static void getAllFiles(File dir, List<File> fileList) {
		try {
			File[] files = dir.listFiles();
			for (File file : files) {
				fileList.add(file);
				if (file.isDirectory()) {
					System.out.println("directory:" + file.getCanonicalPath());
					getAllFiles(file, fileList);
				} else {
					System.out.println("     file:" + file.getCanonicalPath());
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void writeZipFile(File directoryToZip, File Screenshotsdir, List<File> fileList, String filename) {

		try {

			FileOutputStream fos = new FileOutputStream(filename);
			ZipOutputStream zos = new ZipOutputStream(fos);

			for (File file : fileList) {
				if (!file.isDirectory()) {
					// we only zip files, not directories
					addToZip(directoryToZip, Screenshotsdir, file, zos);
				}
			}

			zos.close();
			fos.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void addToZip(File directoryToZip, File Screenshotsdir, File file, ZipOutputStream zos)
			throws FileNotFoundException, IOException {

		FileInputStream fis = new FileInputStream(file);

		// we want the zipEntry's path to be a relative path that is relative
		// to the directory being zipped, so chop off the rest of the path
		String zipFilePath = file.getCanonicalPath().substring(directoryToZip.getCanonicalPath().length() + 1,
				file.getCanonicalPath().length());
		if (zipFilePath.contains("\\")) {
			zipFilePath = file.getCanonicalPath().substring(Screenshotsdir.getCanonicalPath().length() + 1,
					file.getCanonicalPath().length());
			System.out.println("Writing '" + zipFilePath + "' to zip file");
			ZipEntry zipEntry = new ZipEntry("Screenshots/" + zipFilePath);
			zos.putNextEntry(zipEntry);
		}

		else {
			ZipEntry zipEntry = new ZipEntry(zipFilePath);
			zos.putNextEntry(zipEntry);

		}

		byte[] bytes = new byte[1024];
		int length;
		while ((length = fis.read(bytes)) >= 0) {
			zos.write(bytes, 0, length);
		}

		zos.closeEntry();
		fis.close();
	}

	public static boolean deleteDirectory(File dir) {
		if (dir.isDirectory()) {
			File[] children = dir.listFiles();
			for (int i = 0; i < children.length; i++) {
				boolean success = deleteDirectory(children[i]);
				if (!success) {
					return false;
				}
			}
		} // either file or an empty directory
		System.out.println("removing file or directory : " + dir.getName());
		return dir.delete();
	}

	public static boolean ifZipCreated(String filename) {

		// Directory path here
		String path = ".";

		String files;
		File folder = new File(path);
		File[] listOfFiles = folder.listFiles();

		for (int i = 0; i < listOfFiles.length; i++) {

			if (listOfFiles[i].isFile()) {
				files = listOfFiles[i].getName();
				if (files.contentEquals(filename)) {
					System.out.println(files);
					return true;
				}
			}
		}
		return false;
	}

}
