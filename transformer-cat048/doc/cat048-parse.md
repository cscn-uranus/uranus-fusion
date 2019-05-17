CAT48译码
=======

# CAT
0 = 0b00110000
- CAT = 48

# LEN
1 = 0b00000000
2 = 0b00111011
- LEN = 59

# FSPEC
3 = 0b11111111
4 = 0b11110111
5 = 0b00000010
- FSPEC =F1,F2,F3,F4,F5,F6,F7,F8,F9,F10,F11,F13,F14,F21

# DATA
## F1=Data Source Identifier
6 = 0b01000110
7 = 0b00001100
- SAC = 01000110
- SIC = 00001100

## F2 = Time-of-Day
8 = 0b01110000
9 = 0b01111111
10 = 0b11111011
- UTC TIME = ‭3702779‬ * 1/128 = 8.03554H

## F3 = Target Report Descriptor
11 = 0b10100000
- TYP = 101 = Single ModeS Roll-Call
- SIM = Actual target report
- RDP = Report from RDP Chain 1
- SPI = Absence of SPI
- RAB = Report from aircraft transponder

## F4 = Measured Position in Slant Polar Coordinates
12 = 0b00011111
13 = 0b00001101
14 = 0b11100001
15 = 0b00101011
- RHO = 7949*1/256=31.05NM
- THETA = 57643*360/2EXP(16)=317.0365

## F5 = Mode-3/A Code in Octal Representation
16 = 0b00100100
17 = 0b01000111
- V = 0=Code validated
- G = 0 = Default
- L = 0 = Mode-3/A code derived from the reply of the transponder
- CODE=010 001 000 111 = 2 1 0 7


## F6 = Flight Level in Binary Representation
18 = 0b00000011
19 = 0b00110111
- V = Code validated
- G = Default
- FLIGHT LEVEL = 823 * 1/4 =206 FL

## F7 = Radar Plot Characteristics
### PRIMARY SUBFIELD
20 = 0b11100000
- SRL = Presence
- SRR = Presence
- SAM = Presence

### SRL
21 = 0b00010011
- VALUE = 19 * 360/2EXP13 = 19 * 0.044 = 0.836DG

### SRR
22 = 0b00000011
- VALUE = 3 * 1 = 3

### SAM
23 = 0b10111000
- VALUE = 184 DBM

24 = 0b01111000
25 = 0b00001110
26 = 0b10110110
F8=XXX

## F9 = Aircraft Identification
27 = 0b01010100
28 = 0b01010000
29 = 0b01110010
30 = 0b11001011
31 = 0b00101101
32 = 0b00100000
- CHARACTER1 = 010101
- CHARACTER2 = 000101
- CHARACTER3 = 000001
- CHARACTER4 = 110010
- CHARACTER5 = 110010
- CHARACTER6 = 110010
- CHARACTER7 = 110100
- CHARACTER8 = 100000

## F10 = Mode S MB Data
33 = 0b00000010
- REP = 2

### DATA1
34 = 0b10010111
35 = 0b00010000
36 = 0b00000000
37 = 0b00110000
38 = 0b10100100
39 = 0b00000000
40 = 0b00000000
41 = 0b01000000
- DATA = X
- BDS1 = 0100
- BDS2 = 0000

### DATA2
42 = 0b10000000
43 = 0b00010000
44 = 0b01011011
45 = 0b00101111
46 = 0b11100000
47 = 0b00001100
48 = 0b10111001
49 = 0b01010000
- DATA = X
- BDS1 = 0101
- BDS2 = 0000

## F11 = Track Number
50 = 0b00000000
51 = 0b00100110
- VALUE = 38

## F13 = Calculated Track Velocity in Polar Representation
52 = 0b00000111
53 = 0b10000100
54 = 0b00000110
55 = 0b00011011
- SPEED = 1924 * 0.22 = 423.28
- HEADING = 1563 * 0.0055 = 8.5965

## F14 = Track Status
56 = 0b01000110
- CNF = 0 = Tentative Track
- RAD = 10 = SSR/Mode S Track
- DOU = 0 = Normal confidence
- MAH = 0 = No horizontal man.sensed
- CDM = 11 = Unknown
- FX = NO EXTENSION

## F21 = Communications / ACAS Capability and Flight Status
57 = 0b00100000
58 = 0b11110101
- COM = 001 = Comm. A and Comm. B capability
- STAT = 000 = No alert, no SPI, aircraft airborne
- SI = 0 = SI-Code Capable
- MSSC = 1 = YES
- ARC = 1 = 25 ft resolution
- AIC = 1 = Yes
- B1A = 1
- B1B = 0101


# UAP REF

| FRN | Data Item    | Data Item Description                              | Length in Octets |
|:----|:-------------|:---------------------------------------------------|:-----------------|
| 1   | I048/010     | Data Source Identifier                             | 2                |
| 2   | I048/140     | Time-of-Day                                        | 3                |
| 3   | I048/020     | Target Report Descriptor                           | 1+               |
| 4   | I048/040     | Measured Position in Slant Polar Coordinates       | 4                |
| 5   | I048/070     | Mode-3/A Code in Octal Representation              | 2                |
| 6   | I048/090     | Flight Level in Binary Representation              | 2                |
| 7   | I048/130     | Radar Plot Characteristics                         | 1+1+             |
| FX  |              | Field Extension Indicator                          |                  |
| 8   | I048/220     | Aircraft Address                                   | 3                |
| 9   | I048/240     | Aircraft Identification                            | 6                |
| 10  | I048/250     | Mode S MB Data                                     | 1+8*n            |
| 11  | I048/161     | Track Number                                       | 2                |
| 12  | I048/042     | Calculated Position in Cartesian Coordinates       | 4                |
| 13  | I048/200     | Calculated Track Velocity in Polar Representation  | 4                |
| 14  | I048/170     | Track Status                                       | 1+               |
| FX  | n.a.         | Field Extension Indicator                          | n.a.             |
| 15  | I048/210     | Track Quality                                      | 4                |
| 16  | I048/030     | Warning/Error Conditions/Target Classification     | 1+               |
| 17  | I048/080     | Mode-3/A Code Confidence Indicator                 | 2                |
| 18  | I048/100     | Mode-C Code and Confidence Indicator               | 4                |
| 19  | I048/110     | Height Measured by 3D Radar                        | 2                |
| 20  | I048/120     | Radial Doppler Speed                               | 1+               |
| 21  | I048/230     | Communications / ACAS Capability and Flight Status | 2                |
| FX  | n.a.         | Field Extension Indicator                          | n.a.             |
| 22  | I048/260     | ACAS Resolution Advisory Report                    | 7                |
| 23  | I048/055     | Mode-1 Code in Octal Representation                | 1                |
| 24  | I048/050     | Mode-2 Code in Octal Representation                | 2                |
| 25  | I048/065     | Mode-1 Code Confidence Indicator                   | 1                |
| 26  | I048/060     | Mode-2 Code Confidence Indicator                   | 2                |
| 27  | SP-Data Item | Special Purpose Field                              | 1+1+             |
| 28  | RE-Data Item | Reserved Expansion Field                           | 1+1+             |
| FX  | n.a.         | Field Extension Indicator                          | n.a.             |


