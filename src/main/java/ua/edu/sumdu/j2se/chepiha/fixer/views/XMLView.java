package ua.edu.sumdu.j2se.chepiha.fixer.views;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class XMLView {

    String loadedString;

    public XMLView() {
    }

    public void loadString(String msg){
        boolean flag = false;
        while(!flag){
            flag = queryString(msg);
        }
    }


    private boolean queryString(String msg){
        loadedString = "";
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print(msg);
        try {
            loadedString = reader.readLine();
            return loadedString.length()>0;
        } catch (IOException e) {
            return false;
        }
    }

    public String getLoadedString() {
        return loadedString;
    }
}
