
# 1. CAT

  > 0 = 0b00111110

  **V=62，十进制**

---

# 2. LEN

  > 1 = 0b00000000
    2 = 0b01011010

  **V=90，十进制**
    
---

<!--more-->

# 3. FSPEC
  > 3 = 0b10111111
      
  | F1   | F2   | F3   | F4   | F5   | F6   | F7   | FX   |
  |:----:|:----:|:----:|:----:|:----:|:----:|:----:|:----:|
  |1     | 0    | 1    | 1    | 1    | 1    | 1    | 1    |

  > 4 = 0b01001101

  | F8   | F9   | F10  | F11  | F12  | F13  | F14  | FX   |
  |:----:|:----:|:----:|:----:|:----:|:----:|:----:|:----:|
  |0     | 1    | 0    | 0    | 1    | 1    | 0    | 1    |

  > 5 = 0b00100110

  | F15  | F16  | F17  | F18  | F19  | F20  | F21  | FX   |
  |:----:|:----:|:----:|:----:|:----:|:----:|:----:|:----:|
  |0     | 0    | 1    | 0    | 0    | 1    | 1    | 0    |

---
# 4. Data Fields

## 4.1 F1 Data Source Identifier

  > 6 = 0b10010000
  > 7 = 0b10010000
    
  **V=Turkmenistan, 由于是欧洲标准，所以没有亚洲国家，选择土库曼斯坦，SAC SIC 查询地址为：https://www.eurocontrol.int/services/system-area-code-list**
  
  
## 4.2 F3 Service Identification

  > 8 = 0b00000001

  **The service identification is allocated by the system**
    
    
## 4.3 F4 Time Of Track Information

  > 9 = 0b00101110
    10 = 0b10011000
    11 = 0b01011001
    
  **V=063736, UTC时间为063736，北京时间为143736，十进制的值乘以1/128s**
    
  
  
## 4.4 F5 Calculated Track Position (WGS-84)

  > 12 = 0b00000000
    13 = 0b01001111
    14 = 0b01011000
    15 = 0b01110000
    16 = 0b00000001
    17 = 0b00100111
    18 = 0b11101111
    19 = 0b11101110
   
  **LAT=27.8948879241943, LON=104.040431, 十进制的值乘以180/2exp(25),12-15是纬度，16-19是经度**

## 4.5 F6 Calculated Track Position (Cartesian)

  > 20 = 0b00000000
    21 = 0b01000110
    22 = 0b11011111
    23 = 0b11110110
    24 = 0b11101100
    25 = 0b01011000
  
  
## 4.7 F7 Calculated Track Velocity (Cartesian)
  
  > 26 = 0b00000001
    27 = 0b11010011
    28 = 0b00000011
    29 = 0b01101111

## 4.8 F9 Track Mode 3/A Code
  
  > 30 = 0b00000111
    31 = 0b01010011
  
  **(V)=0, (G)=0, (CH)**
  **code1=011=3, code2=101=5, code3=010=2, code4=011=3**

## 4.9 F12 Track Number
  
  > 32 = 0b00000000
    33 = 0b01000110

  **V=70**

## 4.10 F13 Track Status

  > 34 = 0b00000001
    
  | MON  | SPI  | MRH  | SRC  | SRC  | SRC  | CNF  | FX   |
  |:----:|:----:|:----:|:----:|:----:|:----:|:----:|:----:|
  |0     | 0    | 0    | 0    | 0    | 0    | 0    | 1    |
  
  > 35 = 0b00010001
    
  | SIM  | TSE  | TSB  | FPC  | AFF  | STP  | KOS  | FX   |
  |:----:|:----:|:----:|:----:|:----:|:----:|:----:|:----:|
  |0     | 0    | 0    | 1    | 0    | 0    | 0    | 1    |

  > 36 = 0b00000001

  | AMA  | MD4  | MD4  | ME   | MI   | MD5  | MD5  | FX   |
  |:----:|:----:|:----:|:----:|:----:|:----:|:----:|:----:|
  |0     | 0    | 0    | 0    | 0    | 0    | 0    | 1    |

  > 37 = 0b00000000
  
  | CST  | PSR  | SSR  | MDS  | ADS  | SUC  | AAC  | FX   |
  |:----:|:----:|:----:|:----:|:----:|:----:|:----:|:----:|
  |0     | 0    | 0    | 0    | 0    | 0    | 0    | 0    |

  

## 4.11 F17 Measured Flight Level
  > 38 = 0b00000001
    39 = 0b00100011
  
  **V=0000000100100011=291*1/4FL=72.75FL**
  

## 4.12 F20 Calculated Rate Of Climb/Descent

  > 40 = 0b00000000
    41 = 0b00000000
  
  **V=0*6.25feet/minute**
  

## 4.13 F21 Flight Plan Related Data

### 4.13.1 Primary Subfield

  > 42 = 0b11011111
    
  | TAG  | CSN  | IFI  | FCT  | TAC  | WTC  | DEP  | FX   |
  |:----:|:----:|:----:|:----:|:----:|:----:|:----:|:----:|
  |1     | 1    | 0    | 1    | 1    | 1    | 1    | 1    |

  > 43 = 0b10101000
    
  | DST  | RDS  | CFL  | CTL  | TOD  | AST  | STS  | FX   |
  |:----:|:----:|:----:|:----:|:----:|:----:|:----:|:----:|
  |1     | 0    | 1    | 0    | 1    | 0    | 0    | 0    |


  > over, next table is deprecated

   | STD  | STA  | PEM  | PEC  | 0    | 0    | 0    | FX   |
  |:----:|:----:|:----:|:----:|:----:|:----:|:----:|:----:|
  |0     | 0    | 0    | 0    | 0    | 0    | 0    | 0    |


### 4.13.2 Subfield
#### 4.13.2.1 TAG
  > 44 = 0b00000000
    45 = 0b00000000
  
  **V=0**
      
#### 4.13.2.2 CSN
  > 46 = 0b01000011
    47 = 0b01000100
    48 = 0b01000111
    49 = 0b00110100
    50 = 0b00111000
    51 = 0b00110111
    52 = 0b00110100
  
  **V=CDG4874, ASCII转码**
    
#### 4.13.2.3 FCT
  > 53 = 0b01101000 

  | GAT/OAT  | FR1/FR2 | RVSM | HPR  | 0    |
  |:--------:|:-------:|:----:|:----:|:----:|
  | 01       | 10      | 10   | 0    | 0    |

#### 4.13.2.4 TAC
  > 54 = 0b01000010
    55 = 0b00110111
    56 = 0b00110011
    57 = 0b00110111
  
  **V=B737, ASCII转码**

#### 4.13.2.5 WTC
  > 58 = 0b01001101
  
  **V=M, ASCII转码**

#### 4.13.2.6 DEP
  > 59 = 0b01011010
    60 = 0b01010000
    61 = 0b01010000
    62 = 0b01010000
  
  **V=ZPPP, ASCII转码**

#### 4.13.2.7 DST
  > 63 = 0b01011010
    64 = 0b01010011
    65 = 0b01001010
    66 = 0b01001110
  
  **V=ZSJN, ASCII转码**

#### 4.13.2.8 CFL
  > 67 = 0b00000000
    68 = 0b00000000
  
  **V=0*1/4FL**

#### 4.13.2.9 TOD
  > 69 = 0b00000101
  
  REP=5, 重复5次

##### 4.13.2.9.1 第1次
  > 70 = 0b00001000
    71 = 0b00000000
    72 = 0b00000000
    73 = 0b10000000
  
  **TYP=1=EOBT**
  **DAY=0=TODAY**
  **HOR=0**
  **MIN=0**
  **AVS=1**
  **SEC=16**
    
##### 4.13.2.9.2 第2次
  > 74 = 0b00010000
    75 = 0b00000000
    76 = 0b00000000
    77 = 0b10000000

  **TYP=2=ETD**
  **DAY=0=TODAY**
  **HOR=0**
  **MIN=0**
  **AVS=1**
  **SEC=0**
    
##### 4.13.2.9.3 第3次
  > 78 = 0b00111000
    79 = 0b00000000
    80 = 0b00000000
    81 = 0b10000000
  
  **TYP=7=ATOT**
  **DAY=0=TODAY**
  **HOR=0**
  **MIN=0**
  **AVS=1**
  **SEC=0**
    
##### 4.13.2.9.4 第4次
  > 82 = 0b01000000
    83 = 0b00000000
    84 = 0b00000000
    85 = 0b10000000
  
  **TYP=8=ETA**
  **DAY=0=TODAY**
  **HOR=0**
  **MIN=0**
  **AVS=1**
  **SEC=0**
    
##### 4.13.2.9.5 第5次
  > 86 = 0b01010000
    87 = 0b00000000
    88 = 0b00000000
    89 = 0b10000000
  
  **TYP=10=ALDT**
  **DAY=0=TODAY**
  **HOR=0**
  **MIN=0**
  **AVS=1**
  **SEC=0**

# 5. FRN列表

| FRN | Data Item | Information                                | Length |
|:---:|:---------:|:-------------------------------------------|:------:|
|  1  | I062/010  | Data Source Identifier                     |   2    |
|  2  |     -     | Spare                                      |   -    |
|  3  | I062/015  | Service Identification                     |   1    |
|  4  | I062/070  | Time Of Track Information                  |   3    |
|  5  | I062/105  | Calculated Track Position (WGS-84)         |   8    |
|  6  | I062/100  | Calculated Track Position (Cartesian)      |   6    |
|  7  | I062/185  | Calculated Track Velocity (Cartesian)      |   4    |
| FX1 |     -     | Field extension indicator                  |   -    |
|  8  | I062/210  | Calculated Acceleration (Cartesian)        |   2    |
|  9  | I062/060  | Track Mode 3/A Code                        |   2    |
| 10  | I062/245  | Target Identification                      |   7    |
| 11  | I062/380  | Aircraft Derived Data                      |   1+   |
| 12  | I062/040  | Track Number                               |   2    |
| 13  | I062/080  | Track Status                               |   1+   |
| 14  | I062/290  | System Track Update Ages                   |   1+   |
| FX2 |     -     | Field extension indicator                  |   -    |
| 15  | I062/200  | Mode of Movement                           |   1    |
| 16  | I062/295  | Track Data Ages                            |   1+   |
| 17  | I062/136  | Measured Flight Level                      |   2    |
| 18  | I062/130  | Calculated Track Geometric Altitude        |   2    |
| 19  | I062/135  | Calculated Track Barometric Altitude       |   2    |
| 20  | I062/220  | Calculated Rate Of Climb/Descent           |   2    |
| 21  | I062/390  | Flight Plan Related Data                   |   1+   |
| FX3 |     -     | Field extension indicator                  |   -    |
| 22  | I062/270  | Target Size & Orientation                  |   1+   |
| 23  | I062/300  | Vehicle Fleet Identification               |   1    |
| 24  | I062/110  | Mode 5 Data reports & Extended Mode 1 Code |   1+   |
| 25  | I062/120  | Track Mode 2 Code                          |   2    |
| 26  | I062/510  | Composed Track Number                      |   3+   |
| 27  | I062/500  | Estimated Accuracies                       |   1+   |
| 28  | I062/340  | Measured Information                       |   1+   |
| FX4 |     -     | Field extension indicator                  |   -    |
| 29  |     -     | Spare                                      |   -    |
| 30  |     -     | Spare                                      |   -    |
| 31  |     -     | Spare                                      |   -    |
| 32  |     -     | Spare                                      |   -    |
| 33  |     -     | Spare                                      |   -    |
| 34  |    RE     | Reserved Expansion Field                   |   1+   |
| 35  |    SP     | Reserved For Special Purpose Indicator     |   1+   |
| FX5 |     -     | Field extension indicator                  |   -    |
|     |           |                                            |        |

# 6. Aircraft Derived Data 列表

| FRN | Data Item | Information                                                         | Length |
|:---:|:---------:|:--------------------------------------------------------------------|:------:|
|  1  |    ADR    | Target Address                                                      |   3    |
|  2  |    ID     | Target Identification                                               |   6    |
|  3  |    MHG    | Magnetic Heading                                                    |   2    |
|  4  |    IAS    | Indicated Airspeed / Mach No                                        |   2    |
|  5  |    TAS    | True Airspeed                                                       |   2    |
|  6  |    SAL    | Selected Altitude                                                   |   2    |
|  7  |    FSS    | Final State Selected Altitude                                       |   2    |
| FX1 |     -     | Field extension indicator                                           |   -    |
|  8  |    TIS    | Trajectory Intent Status                                            |   1+   |
|  9  |    TID    | Trajectory Intent Data                                              |   16   |
| 10  |    COM    | Communications/ACAS Capability and Flight Status reported by Mode-S |   2    |
| 11  |    SAB    | Status reported by ADS-B                                            |   2    |
| 12  |    ACS    | ACAS Resolution Advisory Report                                     |   7    |
| 13  |    BVR    | Barometric Vertical Rate                                            |   2    |
| 14  |    GVR    | Geometric Vertical Rate                                             |   2    |
| FX2 |     -     | Field extension indicator                                           |   -    |
| 15  |    RAN    | Roll Angle                                                          |   2    |
| 16  |    TAR    | Track Angle Rate                                                    |   2    |
| 17  |    TAN    | Track Angle                                                         |   2    |
| 18  |    GSP    | Ground Speed                                                        |   2    |
| 19  |    VUN    | Velocity Uncertainty                                                |   1    |
| 20  |    MET    | Met Data                                                            |   8    |
| 21  |    EMC    | Emitter Category                                                    |   1    |
| FX3 |     -     | Field extension indicator                                           |   -    |
| 22  |    POS    | Position                                                            |   6    |
| 23  |    GAL    | Geometric Altitude                                                  |   2    |
| 24  |    PUN    | Position Uncertainty                                                |   1    |
| 25  |    MB     | MODE S MB DATA                                                      |   9    |
| 26  |    IAR    | Indicated Airspeed                                                  |   2    |
| 27  |    MAC    | Mach Number                                                         |   2    |
| 28  |    BPS    | Barometric Pressure Setting (derived from Mode S BDS 4,0)           |   2    |
| FX4 |     -     | Field extension indicator                                           |   -    |
