package com.company;

import java.io.*;

public class Main {

    public static void main(String[] args)  {
	// write your code here
        try {
            BufferedReader br = new BufferedReader(new FileReader("file.txt"));
            BufferedWriter bw = new BufferedWriter(new FileWriter("newFile.sp"));
            String line = br.readLine();
            bw.write("*Grupo: Gabriel Soares, Henrique Kessler e  Marcello Muñoz");
            bw.newLine();
            bw.write(".include ami_035u.mod");
            bw.newLine();
            bw.write("V0 GCC 0 DC 0V");
            bw.newLine();
            bw.write("V1 VCC 0 DC 3.3V");
            bw.newLine();
            bw.write("Vin IN 0 PULSE(0 3.3 0 1ps 1ps 1ns 2.002ns)");
            bw.newLine();
            bw.write("Vclock CLK 0 PULSE(0 3.3 0 2ps 2ps 2ns 4.004ns)");
            bw.newLine();
            bw.write("*FAZER ENTRADA E SAIDA MANUALMENTE");
            bw.write(".SUBCKT nome entradas saida vdd gnd");

            bw.newLine();
            bw.newLine();
            while (line != null) {
                String[] parts = line.split(" ");
                for(int i = 1; i < 4; i++){
                    parts[i] = parts[i].replace("1", "a1");
                    parts[i] = parts[i].replace("2", "a2");
                    parts[i] = parts[i].replace("3", "a3");
                    parts[i] = parts[i].replace("4", "a4");
                    parts[i] = parts[i].replace("5", "a5");
                    parts[i] = parts[i].replace("6", "a6");
                    parts[i] = parts[i].replace("7", "a7");
                    parts[i] = parts[i].replace("8", "a8");
                    parts[i] = parts[i].replace("9", "a9");
                    parts[i] = parts[i].replace("0", "a0");
                }
                if(parts[5].contains("NMOS")){
                    parts[5] = "CMOSN";
                    parts[4] = "GCC";
                }
                else{
                    parts[5] = "CMOSP";
                    parts[4] = "VCC";
                }
                for(int i = 0; i< parts.length; i++){
                    bw.write(parts[i]);
                    bw.write(' ');
                }
                bw.newLine();
                line = br.readLine();
            }
            bw.write(".tran 0.002ns 50ns");
            bw.newLine();
            bw.write(".probe");
            bw.newLine();
            bw.write(".end");
            bw.newLine();
            br.close();
            bw.close();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
