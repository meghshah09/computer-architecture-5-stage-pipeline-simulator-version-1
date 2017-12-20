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
public class memory extends Pipeline{
    
    memory(){
        
    }
    memory(int inst_count){
        
       System.out.print("executing Instruction No."+(inst_count)+" in memory stage");
System.out.print("    ");
       System.out.println(inst_list.get(inst_count).inst_line_address + " "+inst_list.get(inst_count).inst);
       
       switch(inst_list.get(inst_count).inst){
           
           case "LOAD":
               //just passes the information
               break;
           case "STORE":
                memory[computed_result.get(inst_count).dest_value]=R[computed_result.get(inst_count).dest_index];
               break;
           case "BUBBLE":
               System.out.println("Bubble in Memory Stage");
              break;
       
       
      }
    }
}
