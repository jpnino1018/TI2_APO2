package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;


public class Reader {

    public static void main(String [] arg) {
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        String file = "";

        try {

            archivo = new File (file);
            fr = new FileReader (archivo);
            br = new BufferedReader(fr);


            String linea;
            while((linea=br.readLine())!=null)
                System.out.println(linea);

        }
        catch(Exception e){
            e.printStackTrace();
        }finally{

            try{
                if( null != fr ){
                    fr.close();
                }
            }catch (Exception e2){
                e2.printStackTrace();
            }
        }
    }
    public void fileSelector(String file){
        //HAY QUE TERMINARLO
    }
}

