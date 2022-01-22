//Name: Ryan Russell
//UIN: 227006614
//File: palindrome.asm

@R0
M=0
@result_one
M=0
@result_two
M=0
@result
M=0
@1024
D=M //D = RAM[1024]
@A
M=D //A = R1024
@1025
D=M //D = RAM[1025]
@B
M=D //B = R1025
@1026
D=M //D = RAM[1026]
@C
M=D //C = R1026
@1027
D=M //D = RAM[1027]
@D
M=D //D = R1027
@1028
D=M //D = RAM[1028]
@E
M=D //E = R1028
@A
D=M
@E
D=D-M
@result_one
M=D //result_one = A - E
@B
D=M
@D
D=D-M
@result_two
M=D //result_two = B - D
@result_one
D=M;
@result_two
D=D+M;
@IS_PALINDROME
D;JEQ
@NOT_PALINDROME
D;JNE

(IS_PALINDROME)
    @R0
    M=1
    //@result
    //D=M
    //D;JGT
    @END
    0;JMP

(NOT_PALINDROME)
    @R0
    M=0
    //@result
    //D=M
    //D;JEQ
    @END
    0;JMP

(END)
    @END
    0;JMP