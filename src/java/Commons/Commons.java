/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Commons;

/**
 *
 * @author SA Nice
 */
public class Commons {
    public static boolean checkUsername(String user_name){
        byte[] user_name_custom = user_name.getBytes();
        for(int i = 0; i < user_name_custom.length; i++){
            if((user_name_custom[i] >= 48 && 
               user_name_custom[i] <= 57) || 
               (user_name_custom[i] >= 65 &&
               user_name_custom[i] <= 90) ||
               (user_name_custom[i] >= 97 &&
               user_name_custom[i] <= 122)){
            }
            else{
                return false;
            }
        }
        return true;
    }
    
    public static boolean checkPassword(String password)
    {
        String regularExpression="^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";
        if(password.matches(regularExpression))
        {
            return false;
        }
        else
        {
            return true;
        } 
    }
    
    public static String fixName(String name)
    {
        name = name.trim();
        if(name.length() == 0) return "";
        name = name.toLowerCase();
        String[] nameArr = name.split(" ");
        String nameFinal = "";
        for(int i = 0; i < nameArr.length; i++){
            if(nameArr[i].length() > 0){
                byte[] byteArr = nameArr[i].getBytes();
                nameFinal += (char)(byteArr[0] - 32);
                for(int j = 1; j < byteArr.length; j++){
                    nameFinal += (char)byteArr[j];
                }
                nameFinal += ' ';
            }
        }
        return nameFinal.trim();
    }   
    
    public static boolean checkSoDT(String soDT){
        if(soDT.length() != 10) return false;
        try{
            int x = Integer.parseInt(soDT);
            return true;
        }
        catch(NumberFormatException ex){
            return false;
        }
    }
    
    public static boolean checkSoCMND(String soCMND){
        if(soCMND.length() != 9 &&  soCMND.length() != 12) return false;
        try{
             long  x = Long.parseUnsignedLong(soCMND);
            return true;
        }
        catch(NumberFormatException ex){
            return false;
        }
    }
    
    public static boolean checkSo(String so){
        try{
            int x = Integer.parseInt(so);
            return true;
        }
        catch(NumberFormatException ex){
            return false;
        }
    }
    
    public static String numberToString(int so){
        byte[] byteArr = ("" + so).getBytes();
        String string = "";
        int dem = 0;
        for(int i = byteArr.length - 1; i >= 0; i--){
            if((dem + 1) % 3 == 0){
                string += (char)byteArr[i];
                if(i != 0){
                    string += ".";
                }
                dem++;
            }
            else{
                string += (char)byteArr[i]; 
                dem++;
            }
        }
        byte[] byteArr2 = string.getBytes();
        String stringFinal = "";
        for(int i = byteArr2.length - 1; i >= 0; i--){
            stringFinal += (char) byteArr2[i];
        }
        return stringFinal;
    }
}