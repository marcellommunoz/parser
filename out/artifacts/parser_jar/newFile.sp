*Grupo: Gabriel Soares, Henrique Kessler e  Marcello Mu�oz
.include ami_035u.mod
V0 GCC 0 DC 0V
V1 VCC 0 DC 3.3V
Vin IN 0 PULSE(0 3.3 0 1ps 1ps 1ns 2.002ns)
Vclock CLK 0 PULSE(0 3.3 0 2ps 2ps 2ns 4.004ns)
*FAZER ENTRADA E SAIDA MANUALMENTE

M1 GND D DNEGADO GCC CMOSN l=3e-007 w=2.9e-006  $ (12.25 21.15 12.55 24.05) 
M2 a2 D GND GCC CMOSN l=3e-007 w=1.5e-006  $ (15.3 17.2 15.6 18.7) 
M3 OUT CLOCK a2 GCC CMOSN l=3e-007 w=1.5e-006  $ (16.2 17.2 16.5 18.7) 
M4 a3 CLOCK GND GCC CMOSN l=3e-007 w=1.8e-006  $ (23.75 17.1 24.05 18.9) 
M5 OUTa2 DNEGADO a3 GCC CMOSN l=3e-007 w=1.8e-006  $ (24.65 17.1 24.95 18.9) 
M6 a4 OUT GND GCC CMOSN l=3e-007 w=1.8e-006  $ (31.05 17.1 31.35 18.9) 
M7 OUTa3 OUTa4 a4 GCC CMOSN l=3e-007 w=1.8e-006  $ (31.95 17.1 32.25 18.9) 
M8 a5 OUTa3 GND_ GCC CMOSN l=3e-007 w=1.8e-006  $ (38.3 17.05 38.6 18.85) 
M9 OUTa4 OUTa2 a5 GCC CMOSN l=3e-007 w=1.8e-006  $ (39.2 17.05 39.5 18.85) 
M10 DNEGADO D VCC VCC CMOSP l=3e-007 w=5.05e-006  $ (9.15 19 9.45 24.05) 
M11 OUT D VCC VCC CMOSP l=3e-007 w=2.7e-006  $ (15.3 21 15.6 23.7) 
M12 VCC CLOCK OUT VCC CMOSP l=3e-007 w=2.7e-006  $ (16.5 21 16.8 23.7) 
M13 OUTa2 CLOCK VCC VCC CMOSP l=3e-007 w=2.7e-006  $ (23.75 21.05 24.05 23.75) 
M14 VCC DNEGADO OUTa2 VCC CMOSP l=3e-007 w=2.7e-006  $ (24.95 21.05 25.25 23.75) 
M15 OUTa3 OUT VCC VCC CMOSP l=3e-007 w=2.7e-006  $ (31.05 21.05 31.35 23.75) 
M16 VCC OUTa4 OUTa3 VCC CMOSP l=3e-007 w=2.7e-006  $ (32.25 21.05 32.55 23.75) 
M17 OUTa4 OUTa3 VCC VCC CMOSP l=3e-007 w=2.7e-006  $ (38.3 21 38.6 23.7) 
M18 VCC OUTa2 OUTa4 VCC CMOSP l=3e-007 w=2.7e-006  $ (39.5 21 39.8 23.7) 
.tran 0.002ns 50ns
.probe
.end
