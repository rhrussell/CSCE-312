import java.util.*;
import java.io.*;

public class BasicAssembler
{
	public static ArrayList<String> asm = new ArrayList<String>();
	
    public static void main(String[] args)
    {
    	Scanner scan = new Scanner(System.in);
    	ArrayList<String> file = new ArrayList<String>();
    	
    	String fileName = "";
    	String asmFileName = "";
    	String hackFileName = "";
    	String line = "";
    	
    	try
    	{
    		while(true)
    		{
    			System.out.println("Please put the name of the file (without the .asm) that you want to convert.");
    			fileName = scan.next();
    			asmFileName = fileName + ".asm";
    			
    			Scanner asmFile = new Scanner(new File(asmFileName));
    			
    			while(asmFile.hasNextLine())
    			{
    				line = asmFile.nextLine();
    				file.add(line);
    			}
    			
    			Iterator<String> iter = file.iterator();
    			
    			while(iter.hasNext())
    			{
    				line = iter.next();
    				generateHack(asm, line);
    			}
    			
    			hackFileName = fileName + ".hack";
    			FileWriter writer = new FileWriter(hackFileName);
    			
    			for(int i = 0; i < asm.size(); i++)
    			{
					line = asm.get(i);
					if(line != null)
					{
						writer.write(line + "\n");
					}
    			}
    			writer.close();
    			
    			//System.out.println("Success! " + hackFileName + " has been created!\n");
    		}
    	}
    	catch(FileNotFoundException e)
    	{
    		e.printStackTrace();
    	} 
    	catch (IOException e) 
    	{
			e.printStackTrace();
		}
    }
    
    public static void generateHack(ArrayList<String> asm, String line)
    {
    	String stringDest = "";
    	String stringComp = "";
    	String stringJump = "";
    	String lineDest = "";
    	String lineComp = "";
    	String lineJump = "";
    	int equalPos = 0;
    	int semiColonPos = 0;
    	
    	if(line.contains("//"))
        {
            line = line.substring(0, line.indexOf("//"));
        }
  
        line.replaceAll("\\s", "");
        line = line.trim();
		
		if(line.length() > 0)
		{
			while(!line.isEmpty())
			{
				if(line.charAt(0) == '@')
				{
					line = line.substring(1);
					
					if(line.compareTo("R0") == 0)
					{
						asm.add("0000000000000000");
					}
					else if(line.compareTo("R1") == 0)
					{
						asm.add("0000000000000001");
					}
					else if(line.compareTo("R2") == 0)
					{
						asm.add("0000000000000010");
					}
					else if(line.compareTo("R3") == 0)
					{
						asm.add("0000000000000011");
					}
					else if(line.compareTo("R4") == 0)
					{
						asm.add("0000000000000100");
					}
					else if(line.compareTo("R5") == 0)
					{
						asm.add("0000000000000101");
					}
					else if(line.compareTo("R6") == 0)
					{
						asm.add("0000000000000110");
					}
					else if(line.compareTo("R7") == 0)
					{
						asm.add("0000000000000111");
					}
					else if(line.compareTo("R8") == 0)
					{
						asm.add("0000000000001000");
					}
					else if(line.compareTo("R9") == 0)
					{
						asm.add("0000000000001001");
					}
					else if(line.compareTo("R10") == 0)
					{
						asm.add("0000000000001010");
					}
					else if(line.compareTo("R11") == 0)
					{
						asm.add("0000000000001011");
					}
					else if(line.compareTo("R12") == 0)
					{
						asm.add("0000000000001100");
					}
					else if(line.compareTo("R13") == 0)
					{
						asm.add("0000000000001101");
					}
					else if(line.compareTo("R14") == 0)
					{
						asm.add("0000000000001110");
					}
					else if(line.compareTo("R15") == 0)
					{
						asm.add("0000000000001111");
					}
					else if(line.compareTo("SP") == 0)
					{
						asm.add("0000000000000000");
					}
					else if(line.compareTo("LCL") == 0)
					{
						asm.add("0000000000000001");
					}
					else if(line.compareTo("ARG") == 0)
					{
						asm.add("0000000000000010");
					}
					else if(line.compareTo("THIS") == 0)
					{
						asm.add("0000000000000011");
					}
					else if(line.compareTo("THAT") == 0)
					{
						asm.add("0000000000000100");
					}
					else if(line.compareTo("SCREEN") == 0)
					{
						asm.add("0100000000000000");
					}
					else if(line.compareTo("KBD") == 0)
					{
						asm.add("0110000000000000");
					}
					else
					{
						asm.add(convertToBinary(line));
					}
					return;
				}
				else
				{
					equalPos = line.indexOf("=");
					semiColonPos = line.indexOf(";");
					
					if(equalPos < 0)
					{
						stringDest = "000";
					}
					else
					{
						lineDest = line.substring(0, equalPos);
						
						if(lineDest.compareTo("M") == 0)
						{
							stringDest = "001";
						}
						else if(lineDest.compareTo("D") == 0)
						{
							stringDest = "010";
						}
						else if(lineDest.compareTo("MD") == 0)
						{
							stringDest = "011";
						}
						else if(lineDest.compareTo("A") == 0)
						{
							stringDest = "100";
						}
						else if(lineDest.compareTo("AM") == 0)
						{
							stringDest = "101";
						}
						else if(lineDest.compareTo("AD") == 0)
						{
							stringDest = "110";
						}
						else if(lineDest.compareTo("AMD") == 0)
						{
							stringDest = "111";
						}
					}
					
					if(semiColonPos < 0)
					{
						stringJump = "000";
					}
					else
					{
						lineJump = line.substring(semiColonPos + 1);
						
						if(lineJump.compareTo("JGT") == 0)
						{
							stringJump = "001";
						}
						else if(lineJump.compareTo("JEQ") == 0)
						{
							stringJump = "010";
						}
						else if(lineJump.compareTo("JGE") == 0)
						{
							stringJump = "011";
						}
						else if(lineJump.compareTo("JLT") == 0)
						{
							stringJump = "100";
						}
						else if(lineJump.compareTo("JNE") == 0)
						{
							stringJump = "101";
						}
						else if(lineJump.compareTo("JLE") == 0)
						{
							stringJump = "110";
						}
						else if(lineJump.compareTo("JMP") == 0)
						{
							stringJump = "111";
						}
					}
					
					if((semiColonPos < 0) && (equalPos < 0))
					{
						lineComp = line;
					}
					else if((equalPos < 0) && (semiColonPos <= line.length()))
					{
						lineComp = line.substring(0, semiColonPos);
					}
					else if((equalPos <= line.length()) && (semiColonPos < 0))
					{
						lineComp = line.substring(equalPos + 1);
					}
					else
					{
						lineComp = line.substring(equalPos + 1, line.length() - equalPos - 3);
					}
					
					if(lineComp.compareTo("0") == 0)
					{
						stringComp = "0101010";
					}
					else if(lineComp.compareTo("1") == 0)
					{
						stringComp = "0111111";
					}
					else if(lineComp.compareTo("-1") == 0)
					{
						stringComp = "0111010";
					}
					else if(lineComp.compareTo("D") == 0)
					{
						stringComp = "0001100";
					}
					else if(lineComp.compareTo("A") == 0)
					{
						stringComp = "0110000";
					}
					else if(lineComp.compareTo("!D") == 0)
					{
						stringComp = "00001101";
					}
					else if(lineComp.compareTo("!A") == 0)
					{
						stringComp = "0110001";
					}
					else if(lineComp.compareTo("-D") == 0)
					{
						stringComp = "0001111";
					}
					else if(lineComp.compareTo("-A") == 0)
					{
						stringComp = "0110011";
					}
					else if(lineComp.compareTo("D+1") == 0)
					{
						stringComp = "0011111";
					}
					else if(lineComp.compareTo("A+1") == 0)
					{
						stringComp = "0110111";
					}
					else if(lineComp.compareTo("D-1") == 0)
					{
						stringComp = "0001110";
					}
					else if(lineComp.compareTo("A-1") == 0)
					{
						stringComp = "0110010";
					}
					else if(lineComp.compareTo("D+A") == 0 || lineComp.compareTo("A+D") == 0)
					{
						stringComp = "0000010";
					}
					else if(lineComp.compareTo("D-A") == 0)
					{
						stringComp = "0010011";
					}
					else if(lineComp.compareTo("A-D") == 0)
					{
						stringComp = "0000111";
					}
					else if(lineComp.compareTo("D&A") == 0 || lineComp.compareTo("A&D") == 0)
					{
						stringComp = "0000000";
					}
					else if(lineComp.compareTo("D|A") == 0 || lineComp.compareTo("A|D") == 0)
					{
						stringComp = "0010101";
					}
					else if(lineComp.compareTo("M") == 0)
					{
						stringComp = "1110000";
					}
					else if(lineComp.compareTo("!M") == 0)
					{
						stringComp = "1110001";
					}
					else if(lineComp.compareTo("-M") == 0)
					{
						stringComp = "1110011";
					}
					else if(lineComp.compareTo("M+1") == 0)
					{
						stringComp = "1110111";
					}
					else if(lineComp.compareTo("M-1") == 0)
					{
						stringComp = "1110010";
					}
					else if(lineComp.compareTo("D+M") == 0 || lineComp.compareTo("M+D") == 0)
					{
						stringComp = "1000010";
					}
					else if(lineComp.compareTo("D-M") == 0)
					{
						stringComp = "1000010";
					}
					else if(lineComp.compareTo("M-D") == 0)
					{
						stringComp = "1000111";
					}
					else if(lineComp.compareTo("D&M") == 0 || lineComp.compareTo("M&D") == 0)
					{
						stringComp = "1000000";
					}
					else if(lineComp.compareTo("D|M") == 0 || lineComp.compareTo("M|D") == 0)
					{
						stringComp = "1010101";
					}
					
					line = "111" + stringComp + stringDest + stringJump;

					{
						asm.add(line);
						return;
					}
				}
			}
		}
    	return;
    }
    
    public static String convertToBinary(String instruction)
    {
        String str = "";
        String binary = "";
        int num = 0;

        num = Integer.parseInt(instruction);
        binary = Integer.toBinaryString(num);

        while(binary.length() < 16)
        {
            StringBuffer sb = new StringBuffer();
            str = "0";
            sb.append(str);
            sb.append(binary);
            binary = sb.toString();
        }

        return binary;
    }
}
