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
public class User {
    private String username;
    private String password;
    private boolean trangThai;

    public User() {
    }

    public User(String username, String password, boolean trangThai) {
        this.username = username;
        this.password = password;
        this.trangThai = trangThai;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }
    
    @Override
    public String toString() {
        return "User{" + "username=" + username + ", password=" + password + ", trangThai=" + trangThai + '}';
    }
    
}
