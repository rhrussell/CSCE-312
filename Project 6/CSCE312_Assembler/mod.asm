//Name: Ryan Russell
//UIN: 227006614

// File name: mod.asm

// This program calculates the modulo of two given numbers a and b, which is a%b in math. 
// The value of a is stored in RAM[0] (R0), and the value of b is stored in RAM[1] (R1). 
// The value a is non-negative integer and b is positive integer. 
// The modulo value is stored in RAM[2] (R2).



// Put your code below this line
@R2
M=0
@R0
D=M
@END
D;JEQ   //If R0 = 0, goto END

(LOOP)
    @R1
    D=D-M   //D = R0 - R1
    @REMAINDER
    D;JLT   //If R0 - R1 < 0, goto REMAINDER
    @LOOP
    0;JMP

(REMAINDER)
    @R1
    D=D+M   //D = R0 - R1 + R1 = R0
    @R2
    M=D     //R2 = R0

(END)
    @END
    0;JMP
