/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author SA Nice
 */
public class Info {
    private String username;
    private String ten;
    private String soDT;
    private String diaChi;
    private String soCMND;
    private String ngaySinh;
    private String danToc;
    private boolean gioiTinh;
    private String maTinh;
    private int mucLuong;
    private boolean hinhThuc;
    private boolean trangThai;

    public Info() {
    }

    public Info(String username, String ten, String soDT, String diaChi, String soCMND, String ngaySinh, String danToc, boolean gioiTinh, String maTinh, int mucLuong, boolean hinhThuc, boolean trangThai) {
        this.username = username;
        this.ten = ten;
        this.soDT = soDT;
        this.diaChi = diaChi;
        this.soCMND = soCMND;
        this.ngaySinh = ngaySinh;
        this.danToc = danToc;
        this.gioiTinh = gioiTinh;
        this.maTinh = maTinh;
        this.mucLuong = mucLuong;
        this.hinhThuc = hinhThuc;
        this.trangThai = trangThai;
    }

    public Info(String username, String ten, String soCMND, String ngaySinh, String danToc, boolean gioiTinh) {
        this.username = username;
        this.ten = ten;
       
        this.soCMND = soCMND;
        this.ngaySinh = ngaySinh;
        this.danToc = danToc;
        
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getSoDT() {
        return soDT;
    }

    public void setSoDT(String soDT) {
        this.soDT = soDT;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSoCMND() {
        return soCMND;
    }

    public void setSoCMND(String soCMND) {
        this.soCMND = soCMND;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getDanToc() {
        return danToc;
    }

    public void setDanToc(String danToc) {
        this.danToc = danToc;
    }

    public boolean getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getMaTinh() {
        return maTinh;
    }

    public void setMaTinh(String maTinh) {
        this.maTinh = maTinh;
    }

    public int getMucLuong() {
        return mucLuong;
    }

    public void setMucLuong(int mucLuong) {
        this.mucLuong = mucLuong;
    }

    public boolean getHinhThuc() {
        return hinhThuc;
    }

    public void setHinhThuc(boolean hinhThuc) {
        this.hinhThuc = hinhThuc;
    }

    public boolean getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

    @Override
    public String toString() {
        return "Info{" + "username=" + username + ", ten=" + ten + ", soDT=" + soDT + ", diaChi=" + diaChi + ", soCMND=" + soCMND + ", ngaySinh=" + ngaySinh + ", danToc=" + danToc + ", gioiTinh=" + gioiTinh + ", maTinh=" + maTinh + ", mucLuong=" + mucLuong + ", hinhThuc=" + hinhThuc + '}';
    }
    
}
