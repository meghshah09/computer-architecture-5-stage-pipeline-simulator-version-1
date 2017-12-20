/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pipeline;

/**
 *
 * @author skdc
 */
import java.util.*;
import java.io.*;

public class fetch extends Pipeline{
    
    
   //public static ArrayList<instruction> inst_list = new ArrayList<instruction>();
    fetch(){
        
    }
    fetch(int inst_count){
 inst_count=inst_count;
            System.out.print("executing Instruction No."+inst_count + " in fetch stage");
            System.out.print("    ");
            System.out.println(inst_list.get(inst_count).inst_line_address + " "+inst_list.get(inst_count).inst);

//return false;
    }
    
}
