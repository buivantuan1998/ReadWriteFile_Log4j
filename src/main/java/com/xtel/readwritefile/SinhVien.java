/**
 * 
 */
package com.xtel.readwritefile;

import java.io.Serializable;
import java.util.Scanner;

import org.apache.log4j.Logger;

/**
 * @author admin
 *
 */
public class SinhVien implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	static final Logger logger = Logger.getLogger(SinhVien.class);
	
	private String maSV;
	private String tenSV;
	private int gioiTinh;
	private String diaChi;
	private float diemToan;
	private float diemLy;
	private float diemHoa;
	
	//Contructor
	public SinhVien() {
		super();
	}

	public SinhVien(String maSV, String tenSV, int gioiTinh, String diaChi, float diemToan, float diemLy,
			float diemHoa) {
		super();
		this.maSV = maSV;
		this.tenSV = tenSV;
		this.gioiTinh = gioiTinh;
		this.diaChi = diaChi;
		this.diemToan = diemToan;
		this.diemLy = diemLy;
		this.diemHoa = diemHoa;
	}

	public String getMaSV() {
		return maSV;
	}

	public void setMaSV(String maSV) {
		this.maSV = maSV;
	}

	public String getTenSV() {
		return tenSV;
	}

	public void setTenSV(String tenSV) {
		this.tenSV = tenSV;
	}

	public int getGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(int gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public float getDiemToan() {
		return diemToan;
	}

	public void setDiemToan(float diemToan) {
		this.diemToan = diemToan;
	}

	public float getDiemLy() {
		return diemLy;
	}

	public void setDiemLy(float diemLy) {
		this.diemLy = diemLy;
	}

	public float getDiemHoa() {
		return diemHoa;
	}

	public void setDiemHoa(float diemHoa) {
		this.diemHoa = diemHoa;
	}
	
	//Nhap thong tin sinh vien
	public void inputInfoStudent() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhap vao ma sinh vien: ");
		this.maSV=sc.nextLine();
		System.out.println("Nhap vao ten sinh vien: ");
		this.tenSV= sc.nextLine();
		System.out.println("Nhap vao gioi tinh sinh vien: ");
		this.gioiTinh = Integer.parseInt(sc.nextLine());
		System.out.println("Nhap vao dia chi cua sinh vien: ");
		this.diaChi = sc.nextLine();
		System.out.println("Nhap  vao diem toan cua sinh vien: ");
		this.diemToan = Float.parseFloat(sc.nextLine());
		System.out.println("Nhap vao diem ly cua sinh vien: ");
		this.diemLy = Float.parseFloat(sc.nextLine());
		System.out.println("Nhap vao diem hoa cua sinh vien: ");
		this.diemHoa = Float.parseFloat(sc.nextLine());
		
	}
	
	//Hien thi thong tin sinh vien
	public void outputInfoStudent() {
		System.out.println("Ma sinh vien: "+this.maSV);
		System.out.println("Ten sinh vien: "+this.tenSV);
		System.out.println("Gioi tinh (0-nam, 1-nu): "+this.gioiTinh);
		System.out.println("Dia chi: "+this.diaChi);
		System.out.println("Diem toan: "+this.diemToan);
		System.out.println("Diem ly: "+this.diemLy);
		System.out.println("Diem hoa: "+this.diemHoa);
		System.out.println("Diem trung binh: "+this.diemTB());
		logger.info("MaSV: "+this.maSV+" TenSV: "+this.tenSV+" GioiTinh: "+this.gioiTinh+" DiaChi: "+this.diaChi+
				" DiemToan: "+this.diemToan+" DiemLy: "+this.diemLy+" DiemHoa: "+this.diemHoa);
	}
	
	//Tinh diem trung binh
	public float diemTB() {
		float TB=(this.diemToan+this.diemLy+this.diemHoa)/3;
		logger.info("Diem trung binh: "+TB);
		return TB;	
	}
	
	

}
