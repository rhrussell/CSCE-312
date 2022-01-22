//Name: Ryan Russell
//UIN: 227006614

// File name: div.asm

// The program calculates the quotient from a division operation. 
// The values of dividend a and divisor b are stored in RAM[0] (R0) and RAM[1] (R1), respectively. 
// The dividend a is a non-negative integer, and the divisor b is a positive integer. 
// Store the quotient in RAM[2] (R2). Ignore the remainder.

@R2
M=0
@R0
D=M
@END
D;JEQ   //If R0 = 0, goto END

(LOOP)
    @R1
    D=D-M   //D = R0 - R1
    @END
    D;JLT   //If R0 - R1 < 0, goto END
    @R2
    M=M+1   //R2 = R2 + 1
    @LOOP
    0;JMP

(END)
    @END
    0;JMP
