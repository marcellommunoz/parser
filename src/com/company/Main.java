package com.company;

import java.io.*;
//import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // write your code here
        try {
            //Scanner sc = new Scanner(System.in);
            //String file = sc.nextLine();
            String file = "file";
            String fileOut = file +".sp";
            file = file+".spc";
            BufferedReader br = new BufferedReader(new FileReader(file));
            BufferedWriter bw = new BufferedWriter(new FileWriter(fileOut));
            fontes(bw);
            String line = br.readLine();
            while (line != null) {
                line(line, bw);
                line = br.readLine();
            }
            sim(bw);
            br.close();
            bw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void fontes(BufferedWriter bw) {
        try {
            bw.write("*Grupo: Gabriel Soares, Henrique Kessler e  Marcello Muñoz");
            bw.newLine();
            bw.write(".include ami_035u.mod");
            bw.newLine();
            bw.write("V0 GND 0 DC 0V");
            bw.newLine();
            bw.write("V1 VCC 0 DC 3.3V");
            bw.newLine();
            bw.write("V2 A 0 DC 0V");
            bw.newLine();
            bw.write("V3 B 0 DC 3.3V");
            bw.newLine();
            bw.write("V4 C 0 DC 3.3V");
            bw.newLine();
            bw.write("V2 D 0 DC 0V");
            bw.newLine();
            bw.write("V3 ScanIn 0 DC 3.3V");
            bw.newLine();
            bw.write("*Vin A 0 PULSE(0 3.3 0 1ps 1ps 1ns 2.002ns)");
            bw.newLine();
            bw.write("*Vin B 0 PULSE(0 3.3 0 1ps 1ps 1ns 2.002ns)");
            bw.newLine();
            bw.write("*Vin C 0 PULSE(0 3.3 0 1ps 1ps 1ns 2.002ns)");
            bw.newLine();
            bw.write("*Vin D 0 PULSE(0 3.3 0 1ps 1ps 1ns 2.002ns)");
            bw.newLine();
            bw.write("*Vin ScanIn 0 PULSE(0 3.3 0 1ps 1ps 1ns 2.002ns)");
            bw.newLine();
            bw.write("Vclock CLOCK 0 PULSE(0 3.3 0 2ps 2ps 2ns 4.004ns)");
            bw.newLine();
            bw.write("*FAZER ENTRADA E SAIDA MANUALMENTE");
            bw.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void sim(BufferedWriter bw) {
        try {
            bw.write(".tran 0.002ns 50ns");
            bw.newLine();
            bw.write(".probe");
            bw.newLine();
            bw.write(".end");
            bw.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void line(String line, BufferedWriter bw) {
        try {
            if (line.length() > 2 && line.startsWith("M")) {
                line = line.replaceAll("_", "");
                String[] parts = line.split(" ");
                for (int i = 1; i < 4; i++) {
                    parts[i] = parts[i].replace("1", "N1");
                    parts[i] = parts[i].replace("2", "N2");
                    parts[i] = parts[i].replace("3", "N3");
                    parts[i] = parts[i].replace("4", "N4");
                    parts[i] = parts[i].replace("5", "N5");
                    parts[i] = parts[i].replace("6", "N6");
                    parts[i] = parts[i].replace("7", "N7");
                    parts[i] = parts[i].replace("8", "N8");
                    parts[i] = parts[i].replace("9", "N9");
                    parts[i] = parts[i].replace("0", "N0");
                }
                if (parts[5].contains("NMOS")) {
                    parts[5] = "CMOSN";
                    parts[4] = "GND";
                } else {
                    parts[5] = "CMOSP";
                    parts[4] = "VCC";
                }
                for (int i = 0; i < parts.length; i++) {
                    bw.write(parts[i]);

                    bw.write(' ');
                }
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

