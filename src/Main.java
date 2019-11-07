import sun.awt.windows.WPrinterJob;
import sun.security.jca.GetInstance;

import java.io.Console;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.print("Digite o local do arquivo a ser digerido (eg:'C:\\users\\arquivo.txt'): ");

        try {
            Scanner in = new Scanner(System.in);
            String path = in.nextLine();
            String tipo = getType();
            byte[] dados = Files.readAllBytes(Paths.get(path));
            MessageDigest messageDigest = MessageDigest.getInstance(tipo);
            messageDigest.update(dados);
            byte[] digerido = messageDigest.digest();
            for (int i=0; i<digerido.length;i++){
               System.out.format("%02X", digerido[i]);
            }
            System.out.println();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static String getType(){
        System.out.print("Para cifrar usando digite MD5(1), SHA-1(2) ou SHA-256(3): ");
        Scanner scanner = new Scanner(System.in);
        String tipo = scanner.nextLine();
        while(true){
            if(tipo.equals("1")){
                return "MD5";
            }
            else if(tipo.equals("2")){
                return "SHA-1";
            }
            else if(tipo.equals("3")){
                return "SHA-256";
            }
            else if(tipo.equals("MD5")){
                return tipo;
            }else if(tipo.equals("SHA-1")){
                return tipo;
            }else if(tipo.equals("SHA-256")){
                return tipo;
            }else{
                System.out.print("Valor inserido inválido, MD5(1), SHA-1(2), SHA-256(3): ");
                tipo = scanner.nextLine();
            }
        }
    }
}
