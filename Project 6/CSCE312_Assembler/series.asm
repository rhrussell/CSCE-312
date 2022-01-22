//Name: Ryan Russell
//UIN: 227006614
//File: series.asm

@sum
M=0 //sum = 0
@N
M=0 //N = 0

@R0
D=M
@LESS_ZERO  //If R0 < 0; goto LESS_ZERO
D;JLT
@EQUAL_ZERO //If R0 = 0; goto EQUAL_ZERO
D;JEQ

@R0
D=M
@N
M=D //N=R0

@2
D=A
@R1
M=D //R1 = 2

(LOOP)
    @R1
    D=M //D=R1
    @sum
    M=D+M   //sum = sum + R1

    @R1
    D=M //D=R1
    @R1
    M=D+M   //R1 = R1 + R1

    @N
    M=M-1   //N=N-1

    @N
    D=M
    @RESULT //If N = 0; goto RESULT
    D;JEQ
    @LOOP   //If not then continue loop
    0;JMP

(LESS_ZERO)
    @1024
    M=0 //RAM[1024] = 0
    @END    //goto END
    0;JMP

(EQUAL_ZERO)
    @1024
    M=1 //RAM[1024] = 1
    @END    //goto END
    0;JMP

(RESULT)
    @sum
    D=M
    @1024
    M=D //RAM[1024] = sum

    @1024
    M=M+1   //RAM[1024] = RAM[1024] + 1 = RAM[1024] + 2^0
    @END    //goto END
    0;JMP

(END)
    @END
    0;JMP