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
public class Mul1 extends Pipeline {
    
    
Mul1(){
    
}    
    Mul1(int inst_count, int di, int src1,int src2){
        System.out.print("executing Instruction No."+(inst_count) +" in MUL1 Stage");
       System.out.print("    ");
       System.out.println(inst_list.get(inst_count).inst_line_address + " "+inst_list.get(inst_count).inst);
      switch(inst_list.get(inst_count).inst){ 
        case "MUL":
               result = R[src1] * R[src2];
                Pipeline.R_flag[di]=true;
                cr = new value (inst_list.get(inst_count).inst_line_address, result ,di);
               computed_result.add(cr);
                break;
    }
   }// end of switch case
}
