//Name: Ryan Russell
//UIN: 227006614

// File name: gcd.asm

// This program calculates the greatest common divisor (gcd) of two given 
// non-negative integers, which are stored in RAM[0] (R0) and RAM[1] (R1). 
// The gcd is stored in RAM[2] (R2).



// Put your code below this line

//GCD(A,B) => GCD(B,R)
//GCD(A,B)
//A=B
//B=R
//GCD(B,R)

@R0
D=M
@a
M=D     //a = R0
@A_ZERO //If a = 0, goto A_ZERO
D;JEQ 
@R1
D=M
@b
M=D     //b = R1
@B_ZERO //if b = 0, goto B_ZERO
D;JEQ 

(LOOP)
    @a
    D=M     //D = R0
    @b
    D=D-M   //D = R0-R1
    @A_EQUAL_B 
    D;JEQ   //If R0-R1=0
    @A_GREAT_B 
    D;JGT   //If R0-R1>0
    @A_LESS_B 
    D;JLT   //If R0-R1<0

(A_GREAT_B)
    @b
    D=M
    @a
    M=M-D   // a = a - b
    @JUMP
    0;JMP //goto JUMP loop

(A_LESS_B)
    @a
    D=M
    @b
    M=M-D   // b = b - a

(JUMP)
    @LOOP
    0;JMP //goto LOOP

(A_ZERO)
    @R1
    D=M
    @R2
    M=D     //R2 = R1
    @END
    0;JMP 

(B_ZERO)
    @R0
    D=M
    @R2
    M=D     //R2 = R0
    @END
    0;JMP 

(A_EQUAL_B)
    @a
    D=M
    @R2
    M=D     //R2 = a

(END)
    @END
    0;JMP