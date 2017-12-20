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
public class execute extends Pipeline {
    instruction clone;
       void flush(int del){
           // cloning need to be done for running jump for more then one cycle, so that i don't encounter the NOP again.
        
        inst_list.remove(del);
        inst_list.add(del,new instruction (100,0,"NOP",false));
    }
    
    execute(){
 System.out.println("Execution :");
        
    }
    execute(int inst_count, int di, int src1,int src2){
        //inst_count =inst_count-Pipeline.stall_count_total;
       
       
         switch(inst_list.get(inst_count).inst){
            case "ADD":
                System.out.print("executing Instruction No."+(inst_count) +" in INTEGER FU Stage");
       System.out.print("    ");
       System.out.println(inst_list.get(inst_count).inst_line_address + " "+inst_list.get(inst_count).inst);
               result = R[src1] + R[src2];
                R_flag[di]=true;
                cr = new value (inst_list.get(inst_count).inst_line_address, result ,di);
               computed_result.add(cr);
                break;
                
            case "SUB":
                System.out.print("executing Instruction No."+(inst_count) +" in INTEGER FU Stage");
       System.out.print("    ");
       System.out.println(inst_list.get(inst_count).inst_line_address + " "+inst_list.get(inst_count).inst);
                result = R[src1] - R[src2];
                R_flag[di]=true;
                cr = new value (inst_list.get(inst_count).inst_line_address, result ,di);
               computed_result.add(cr);
                break;

            case "AND":
                System.out.print("executing Instruction No."+(inst_count) +" in INTEGER FU Stage");
       System.out.print("    ");
       System.out.println(inst_list.get(inst_count).inst_line_address + " "+inst_list.get(inst_count).inst);
                result = R[src1] & R[src2];
                R_flag[di]=true;
                cr = new value (inst_list.get(inst_count).inst_line_address, result ,di);
               computed_result.add(cr);
                break;
            case "OR":
                System.out.print("executing Instruction No."+(inst_count) +" in INTEGER FU Stage");
       System.out.print("    ");
       System.out.println(inst_list.get(inst_count).inst_line_address + " "+inst_list.get(inst_count).inst);
                result = R[src1] | R[src2];
                R_flag[di]=true;
                cr = new value (inst_list.get(inst_count).inst_line_address, result ,di);
               computed_result.add(cr);
                break;
            case "EXOR":
                System.out.print("executing Instruction No."+(inst_count) +" in INTEGER FU Stage");
       System.out.print("    ");
       System.out.println(inst_list.get(inst_count).inst_line_address + " "+inst_list.get(inst_count).inst);
                result = R[src1] ^ R[src2];
                R_flag[di]=true;
                cr = new value (inst_list.get(inst_count).inst_line_address, result ,di);
               computed_result.add(cr);
                break;
         }
    }
    execute(int inst_count, int di, int src1){
        //inst_count=inst_count-Pipeline.stall_count_total;
          /* System.out.print("executing Instruction No."+(inst_count) +" in INTEGER FU Stage");
           System.out.print("    ");
       System.out.println(inst_list.get(inst_count).inst_line_address + " "+inst_list.get(inst_count).inst);
       */
        switch(inst_list.get(inst_count).inst){
            case "ADD":
               result= R[src1] + (inst_list.get(inst_count).literal);
               R_flag[di] = true;
               cr = new value (inst_list.get(inst_count).inst_line_address, result ,di);
               computed_result.add(cr);
                break;
            case "SUB":
               result= R[src1] - (inst_list.get(inst_count).literal);
               R_flag[di] = true;
               cr = new value (inst_list.get(inst_count).inst_line_address, result ,di);
               computed_result.add(cr);
                break;
         /*   case "MUL":
               result= R[src1] * (inst_list.get(inst_count).literal);
               R_flag[di] = true;
               cr = new value (inst_list.get(inst_count).inst_line_address, result ,di);
               computed_result.add(cr);
                break; */
            case "LOAD":
                System.out.print("executing Instruction No."+(inst_count) +" in INTEGER FU Stage");
       System.out.print("    ");
       System.out.println(inst_list.get(inst_count).inst_line_address + " "+inst_list.get(inst_count).inst);
                result= R[src1] + (inst_list.get(inst_count).literal);
                R_flag[di]= true;
                cr = new value (inst_list.get(inst_count).inst_line_address, result ,di);
               computed_result.add(cr);
                break;
            case "STORE":
                System.out.print("executing Instruction No."+(inst_count) +" in INTEGER FU Stage");
       System.out.print("    ");
       System.out.println(inst_list.get(inst_count).inst_line_address + " "+inst_list.get(inst_count).inst);
               result= R[src1] + (inst_list.get(inst_count).literal);
               //System.out.println(result);
               cr = new value (inst_list.get(inst_count).inst_line_address, result ,di);
               computed_result.add(cr);
                break;
        }
    
    }

    execute(int inst_count, int di){// to begin from here
       //inst_count=inst_count-Pipeline.stall_count_total;
         /*  System.out.print("executing Instruction No."+(inst_count) +" in INTEGER FU Stage");
           System.out.print("    ");
       System.out.println(inst_list.get(inst_count).inst_line_address + " "+inst_list.get(inst_count).inst); */
       
       switch(inst_list.get(inst_count).inst){
           
           case "ADD":
               
               break;
           case "MOVC":
               System.out.print("executing Instruction No."+(inst_count) +" in INTEGER FU Stage");
           System.out.print("    ");
       System.out.println(inst_list.get(inst_count).inst_line_address + " "+inst_list.get(inst_count).inst);
               result= 0 + (inst_list.get(inst_count).literal);
               R_flag[di] = true;
               cr = new value (inst_list.get(inst_count).inst_line_address, result ,di);
               computed_result.add(cr);
               //System.out.println(computed_result);
               break;
           case "SUB":
               break;

           case "LOAD":
               break;
           case "STORE":
               break;

           case "JUMP":
System.out.print("executing Instruction No."+(inst_count) +" in INTEGER FU Stage");
           System.out.print("    ");
       System.out.println(inst_list.get(inst_count).inst_line_address + " "+inst_list.get(inst_count).inst);
                   result = R[di]+ (inst_list.get(inst_count).literal);
                   flush(inst_count+1);
                   flush(inst_count+2);
                  // System.out.println(number);
                   for(int g =0 ; g < inst_list.size() ; g++)
                       if(result == inst_list.get(g).inst_line_address)
                       {
                           Pipeline.jump_no= (inst_list.get(g).line_no + Pipeline.bubble- 1);
                           break;
                       }
                   if(result > inst_list.get(inst_count).inst_line_address)Pipeline.control_flag = true;
               
               
               break;
           case "BNZ":
               System.out.print("executing Instruction No."+(inst_count) +" in INTEGER FU Stage");
           System.out.print("    ");
       System.out.println(inst_list.get(inst_count).inst_line_address + " "+inst_list.get(inst_count).inst);
               result = (inst_list.get(inst_count).inst_line_address)+(inst_list.get(inst_count).literal);
               flush(inst_count+1);
               flush(inst_count+2);
               for(int g =0 ; g < inst_list.size() ; g++)
                       if(result == inst_list.get(g).inst_line_address)
                       {
                           Pipeline.jump_no= (inst_list.get(g).line_no + Pipeline.bubble - 1);
                           break;
                       }
               
               if(result > inst_list.get(inst_count).inst_line_address)Pipeline.control_flag = true;
               break;
           case "BZ":
               System.out.print("executing Instruction No."+(inst_count) +" in INTEGER FU Stage");
           System.out.print("    ");
       System.out.println(inst_list.get(inst_count).inst_line_address + " "+inst_list.get(inst_count).inst);
               result = (inst_list.get(inst_count).inst_line_address)+(inst_list.get(inst_count).literal);
               flush(inst_count+1);
               flush(inst_count+2);
               for(int g =0 ; g < inst_list.size() ; g++)
                       if(result == inst_list.get(g).inst_line_address)
                       {
                           Pipeline.jump_no= (inst_list.get(g).line_no + Pipeline.bubble - 1);
                           break;
                       }
               
               
               cr = new value (inst_list.get(inst_count).inst_line_address, result ,0);
               computed_result.add(cr);
               break;
           
           case "BUBBLE":
               result =0;
               cr = new value (inst_list.get(inst_count).inst_line_address, result ,di);
               computed_result.add(cr);
               System.out.println("NOP Due to bubble execution stage");
               break;
       }
       
       
       
       
       
       
       
       }

           
   }
    

