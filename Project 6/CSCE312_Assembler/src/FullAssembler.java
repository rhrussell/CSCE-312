import java.util.*;
import java.util.Map.Entry;
import java.io.*;

public class FullAssembler
{
    public static String result;
    public static int lineCount = -1;
    public static int variableCount = 16;
    public static HashMap<String, Integer> symbolTable = new HashMap<String, Integer>();
    
    public static void main(String[] args) throws FileNotFoundException
    {
        Scanner scan = new Scanner(System.in);
        ArrayList<String> file = new ArrayList<String>();	//arraylist that hold instructions
        String line = "";
        
        while(true)
        {
        	System.out.println("Enter:");
        	line = scan.nextLine();
        	if(generateHack(line) != null)
            {
                System.out.println(generateHack(line));
            }
        }
        
        /*while(scan.hasNext())	//For HackRank
        {
            //System.out.println("Enter: ");
            line = scan.nextLine();
            //System.out.println(line);
            if(generateHack(line) != null)
            {
                file.add(generateHack(line));
            }
            //System.out.println(generateHack(line));
        }
        
        for(int i = 0; i < file.size(); i++)
        {
            String test = file.get(i);
            if(test == null)
            {
                file.remove(i);
            }
        }
        
        Iterator<String> iter = file.iterator();
        
        while(iter.hasNext())
        {
            line = iter.next();
            if(line != null)
            {
                System.out.println(line);
            }
        }
        scan.close();*/
    }
    
    public static String generateHack(String line)
    {
        String stringDest = "";
        String stringComp = "";
        String stringJump = "";
        String lineDest = "";
        String lineComp = "";
        String lineJump = "";
        String variableValue = "";
        String result = "";
        int num = 0;
        int equalPos = 0;
        int semiColonPos = 0;
        
        if(line.contains("//"))
        {
            line = line.substring(0, line.indexOf("//"));	//looks for comments and gets rid of the comment part
            //System.out.println(line);
        }
  
        line = line.replaceAll("\\s+", "");	//replaces spaces
        line = line.trim();	//just to be safe
        
        if(!(line.length() > 0))
        {
            result = null;
            return result;
        }
        
        if(line.length() > 0)
        {
            while(!line.isEmpty())
            {
            	if(line.charAt(0) == '(' && line.contains(")") && isNumeric(line.substring(1)) == false)	//for labels
            	{
            		line = line.substring(1, line.indexOf(")"));
            		symbolTable.put(line, lineCount + 1);	//puts the label in the symbol table
            		result = null;
            		return result;
            	}
            	else if(line.charAt(0) == '@')	//A instruction
                {
                    line = line.substring(1);
                    
                    if(line.compareTo("R0") == 0)
                    {
                        result = "0000000000000000";
                        if(isVariableInTable(line) == false)
                        {
                        	symbolTable.put("R0", 0);
                        }
                    }
                    else if(line.compareTo("R1") == 0)
                    {
                        result = "0000000000000001";
                        if(isVariableInTable(line) == false)
                        {
                        	symbolTable.put("R1", 1);
                        }
                    }
                    else if(line.compareTo("R2") == 0)
                    {
                        result = "0000000000000010";
                        if(isVariableInTable(line) == false)
                        {
                        	symbolTable.put("R2", 2);
                        }
                    }
                    else if(line.compareTo("R3") == 0)
                    {
                        result = "0000000000000011";
                        if(isVariableInTable(line) == false)
                        {
                        	symbolTable.put("R3", 3);
                        }
                    }
                    else if(line.compareTo("R4") == 0)
                    {
                        result = "0000000000000100";
                        if(isVariableInTable(line) == false)
                        {
                        	symbolTable.put("R4", 4);
                        }
                    }
                    else if(line.compareTo("R5") == 0)
                    {
                        result = "0000000000000101";
                        if(isVariableInTable(line) == false)
                        {
                        	symbolTable.put("R5", 5);
                        }
                    }
                    else if(line.compareTo("R6") == 0)
                    {
                        result = "0000000000000110";
                        if(isVariableInTable(line) == false)
                        {
                        	symbolTable.put("R6", 6);
                        }
                    }
                    else if(line.compareTo("R7") == 0)
                    {
                        result = "0000000000000111";
                        if(isVariableInTable(line) == false)
                        {
                        	symbolTable.put("R7", 7);
                        }
                    }
                    else if(line.compareTo("R8") == 0)
                    {
                        result = "0000000000001000";
                        if(isVariableInTable(line) == false)
                        {
                        	symbolTable.put("R8", 8);
                        }
                    }
                    else if(line.compareTo("R9") == 0)
                    {
                        result = "0000000000001001";
                        if(isVariableInTable(line) == false)
                        {
                        	symbolTable.put("R9", 9);
                        }
                    }
                    else if(line.compareTo("R10") == 0)
                    {
                        result = "0000000000001010";
                        if(isVariableInTable(line) == false)
                        {
                        	symbolTable.put("R10", 10);
                        }
                    }
                    else if(line.compareTo("R11") == 0)
                    {
                        result = "0000000000001011";
                        if(isVariableInTable(line) == false)
                        {
                        	symbolTable.put("R11", 11);
                        }
                    }
                    else if(line.compareTo("R12") == 0)
                    {
                        result = "0000000000001100";
                        if(isVariableInTable(line) == false)
                        {
                        	symbolTable.put("R12", 12);
                        }
                    }
                    else if(line.compareTo("R13") == 0)
                    {
                        result = "0000000000001101";
                        if(isVariableInTable(line) == false)
                        {
                        	symbolTable.put("R13", 13);
                        }
                    }
                    else if(line.compareTo("R14") == 0)
                    {
                        result = "0000000000001110";
                        if(isVariableInTable(line) == false)
                        {
                        	symbolTable.put("R14", 14);
                        }
                    }
                    else if(line.compareTo("R15") == 0)
                    {
                        result = "0000000000001111";
                        symbolTable.put("R15", 15);
                    }
                    else if(line.compareTo("SP") == 0)
                    {
                        result = "0000000000000000";
                        symbolTable.put("SP", 0);
                    }
                    else if(line.compareTo("LCL") == 0)
                    {
                        result = "0000000000000001";
                        symbolTable.put("LCL", 1);
                    }
                    else if(line.compareTo("ARG") == 0)
                    {
                        result = "0000000000000010";
                        symbolTable.put("ARG", 2);
                    }
                    else if(line.compareTo("THIS") == 0)
                    {
                        result = "0000000000000011";
                        symbolTable.put("THIS", 3);
                    }
                    else if(line.compareTo("THAT") == 0)
                    {
                        result = "0000000000000100";
                        symbolTable.put("THAT", 4);
                    }
                    else if(line.compareTo("SCREEN") == 0)
                    {
                        result = "0100000000000000";
                        symbolTable.put("SCREEN", 16384);
                    }
                    else if(line.compareTo("KBD") == 0)
                    {
                        result = "0110000000000000";
                        symbolTable.put("KBD", 24576);
                    }
                    else
                    {
                    	if(isNumeric(line) == true)
                    	{
                    		result = convertToBinary(line);	//converts the line to binary if it is a number
                    	}
                    	else
                    	{	
                    		if(isVariableInTable(line) == true)	//goes through to see if the variable is in the table
                    		{	//if in table it will get its value along with it and convert it to binary
                    			Iterator<Entry<String, Integer>> tableIter = symbolTable.entrySet().iterator();
                    			while(tableIter.hasNext())
                    			{
                    				Map.Entry element = (Map.Entry)tableIter.next();
                    				String test = (String)element.getKey();
                    				if(line.compareTo(test) == 0)
                    				{
                    					num = (int)element.getValue();
                        				variableValue = Integer.toString(num);
                        				//System.out.println(variableValue);
                        				result = convertToBinary(variableValue);
                        				return result;
                    				}
                    			}
                    		}
                    		else
                    		{	//if not in table, then it will put it in table
                    			symbolTable.put(line, variableCount);
                    			variableValue = Integer.toString(variableCount);
                    			result = convertToBinary(variableValue);
                    			//System.out.println(variableValue + " " + result);
                				variableCount++;
                    		}
                    	}
                    }
                    
                    if(result != null)
                    {
                    	lineCount++;
                    }
                    return result;
                }
                else
                {	//C instruction
                    equalPos = line.indexOf("=");
                    semiColonPos = line.indexOf(";");
                    
                    if(equalPos < 0)
                    {
                        stringDest = "000";
                    }
                    else
                    {	//destination part
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
                    {	//jump part
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
                        lineComp = line.substring(equalPos + 1, line.length() - 4);
                    }
                    
                    //comp part
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
                        stringComp = "0001101";
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
                        stringComp = "1010011";
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
                    
                    result = "111" + stringComp + stringDest + stringJump;
                    return result;
                }
            }
        }
        else
        {
            result = null;
            return result;
        }
        
        return result;
    }
    
    public static boolean isNumeric(String line) //tests to see if the string is a number
    {	
    	if(line == null)
    	{
    		return false;
    	}
    	
    	try
    	{
    		int num = Integer.parseInt(line);
    	}
    	catch(NumberFormatException e)
    	{
    		return false;
    	}
    	return true;
    }
    
    public static String convertToBinary(String instruction)	//converts number(String version) to binary
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
    
    public static boolean isVariableInTable(String line)	//goes through and sees if the line is in the symbol table
    {
    	Iterator<Entry<String, Integer>> tableIter = symbolTable.entrySet().iterator();
		
		while(tableIter.hasNext())
		{
			Map.Entry element = (Map.Entry)tableIter.next();
			String test = (String)element.getKey();
			if(line.compareTo(test) == 0)
			{
				return true;
			}
		}
		return false;
    }
}