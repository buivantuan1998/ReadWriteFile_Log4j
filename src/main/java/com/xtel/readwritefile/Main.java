/**
 * 
 */
package com.xtel.readwritefile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

/**
 * @author admin
 *
 */
public class Main {

	static final Logger logger = Logger.getLogger(Main.class);
	
	ArrayList<SinhVien> listSinhVien = new ArrayList<>();
	
	//Nhap thong tin cho n sinh vien
	public void inputData() {
		Scanner sc = new Scanner(System.in);
		logger.info("Inserting data...");
		System.out.println("Nhap vao so luong sinh vien ban muon them: ");
		int n =Integer.parseInt(sc.nextLine());
		for(int i=0; i< n; i++) {
			System.out.println("Sinh vien thu "+(i+1));
			SinhVien sv = new SinhVien();
			sv.inputInfoStudent();
			listSinhVien.add(sv);
		}
		logger.info("Insert data successful.!");
	}
	
	//Hien thi thong tin sinh vien
	public void outputData() {
		logger.info("Getting data...");
		System.out.println("Danh sach thong tin sinh vien");
		for(int i=0; i< listSinhVien.size(); i++) {
			SinhVien sv = listSinhVien.get(i);
			sv.outputInfoStudent();
		}
		logger.info("Get data successful.!");
	}
	
	//Ghi file
	public void writeFile() {
		File file = new File("C:\\log\\sinhvien.txt");
//		File file = new File("sinhvien.txt");
		if(file.exists()) {
			logger.info("Create file successful.Vi tri file: !"+file.getPath());
			try {
				FileOutputStream fos = new FileOutputStream(file);
				ObjectOutputStream oos = new ObjectOutputStream(fos);
				//List<SinhVien> listSinhVien = new ArrayList<SinhVien>();
				oos.writeObject(listSinhVien);
				logger.info(listSinhVien);
				//Day du lieu tu stream -> file
				oos.flush();
				//Dong
				fos.close();
				oos.close();
			} catch (Exception e) {
				e.printStackTrace();
				logger.error("Error while write file. Message: "+e.getMessage());
			}
		}
		else {
			logger.error("Create file failure");
		}
	}
	
	//Doc file
	public void readFile() {
		File file = new File("C:\\log\\sinhvien.txt");
		if(file.exists()) {
			logger.info("Vi tri file: "+file.getPath());
			try {
				FileInputStream fis = new FileInputStream(file);
				ObjectInputStream ois = new ObjectInputStream(fis);
				List<SinhVien>listSV = (List<SinhVien>) ois.readObject();
				if(listSV == null) {
					logger.warn("File not data");
				}
				else {
					logger.info(listSV);
					for (SinhVien sv : listSV) {
						System.out.println("Ma sinh vien: "+sv.getMaSV());
						System.out.println("Ten sinh vien: "+sv.getTenSV());
						System.out.println("Gioi tinh: "+sv.getGioiTinh());
						System.out.println("Dia chi: "+sv.getDiaChi());
						System.out.println("Diem toan: "+sv.getDiemToan());
						System.out.println("Diem ly: "+sv.getDiemLy());
						System.out.println("Diem hoa: "+sv.getDiemHoa());
						System.out.println("Diem trung binh: "+sv.diemTB());
					}
				}				
				fis.close();
				ois.close();
			} catch (Exception e) {
				e.printStackTrace();
				logger.error("Error while read file. Message: "+e.getMessage());
			}
		}
		else {
			logger.error("File not exists");
		}	
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Main m = new Main();
		do {
			System.out.println("1.Nhap thong tin sinh vien.");
			System.out.println("2.Hien thi thong tin sinh vien");
			System.out.println("3.Ghi vao file.");
			System.out.println("4.Doc file.");
			System.out.println("5.Thoat");
			System.out.println("**********************************");
			System.out.println("Nhap vao lua chon cua ban:");
			int luaChon= Integer.parseInt(sc.nextLine());
			switch (luaChon) {
			case 1:
				logger.warn("Adding data...");
				m.inputData();
				break;
			case 2:
				logger.warn("Getting data...");
				m.outputData();
				break;
			case 3:
				logger.warn("Writing file...");
				m.writeFile();
				break;
			case 4:
				logger.warn("Reading file...");
				m.readFile();
				break;

			default:
				System.exit(0);
				break;
			}
		} while (true);
	}

}
