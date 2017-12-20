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
public class Mul2 extends Pipeline {
    Mul2(){
        
    }
    Mul2(int inst_count_m2){
        System.out.print("executing Instruction No."+inst_count_m2 + " in MUL2 stage");
            System.out.print("    ");
            System.out.println(inst_list.get(inst_count_m2).inst_line_address + " "+inst_list.get(inst_count_m2).inst);
    }
}
