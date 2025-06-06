package RA1_2_3;

import RA1_2_3.examen.modelo.Airport;

import java.util.List;

public class Helper {
    public static boolean checkEmail (String email) {
        return email.matches(".+@.+\\..+");
    }
    public static boolean checkIP (String ip){
        if (! ip.matches("[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}"))
            return false;
        String[] tokens = ip.split("\\.");
        for (String token : tokens) {
            int value = Integer.parseInt(token);
            if (value > 255 || value < 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(checkIP("211"));
        System.out.println(checkIP("211.211.211"));
        System.out.println(checkIP("300.200.200.200"));
        System.out.println(checkIP("200.200.200.200"));
    }


}
