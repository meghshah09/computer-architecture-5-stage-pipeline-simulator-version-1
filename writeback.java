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
public class writeback extends Pipeline{
    int dest;
    public static int airthmetic_counter=0;
    public static boolean non_zero_flag = false;
    public static boolean zero_flag = false;
    public static int null_pointer_count;
    writeback(){
        
    }
    writeback(int inst_count){
        int new_index =inst_count;
       System.out.print("executing Instruction No."+(inst_count)+" in writeback stage");
       System.out.print("    ");
       System.out.println(inst_list.get(inst_count).inst_line_address + " "+inst_list.get(inst_count).inst);
       
    switch(inst_list.get(inst_count).inst){
           
           case "ADD":
               if(Pipeline.control_flag== true){
               while( inst_count > computed_result.size()){
                   computed_result.add(new value(0,0,0));
               }
               }
               for(int g =0 ; g<computed_result.size() ; g++){
                   if(inst_list.get(inst_count).inst_line_address == computed_result.get(g).inst_line_address)
                   {
                       new_index = g;
                       break;
                   }
                   
               }
              if(inst_list.get(inst_count).inst_line_address == computed_result.get(new_index).inst_line_address)
              {
                  R[computed_result.get(new_index).dest_index] = computed_result.get(new_index).dest_value;
                  
                  R_flag[computed_result.get(new_index).dest_index] =false;
                  
                  if(computed_result.get(new_index).dest_value == 0)
                      zero_flag = true;
                  else 
                     zero_flag = false;
              
              airthmetic_counter++;
              }
              
               break;
           case "MOVC":
               if(Pipeline.control_flag== true){
               while( inst_count > computed_result.size()){
                   computed_result.add(new value(0,0,0));
               }
               }
               for(int g =0 ; g<computed_result.size() ; g++){
                   if(inst_list.get(inst_count).inst_line_address == computed_result.get(g).inst_line_address)
                   {
                       new_index = g;
                       break;
                   }
                   
               }
              if(inst_list.get(inst_count).inst_line_address == computed_result.get(new_index).inst_line_address)
              {
                   R[computed_result.get(new_index).dest_index] = computed_result.get(new_index).dest_value;
                   R_flag[computed_result.get(new_index).dest_index]=false;
              }
               break;
           case "SUB":
               if(Pipeline.control_flag== true){
               while( inst_count > computed_result.size()){
                   computed_result.add(new value(0,0,0));
               }
               }
               for(int g =0 ; g<computed_result.size() ; g++){
                   if(inst_list.get(inst_count).inst_line_address == computed_result.get(g).inst_line_address)
                   {
                       new_index = g;
                       break;
                   }
                   
               }
               if(inst_list.get(inst_count).inst_line_address == computed_result.get(new_index).inst_line_address)
              {
                  R[computed_result.get(inst_count).dest_index] = computed_result.get(new_index).dest_value;
                  R_flag[computed_result.get(new_index).dest_index]=false;
                  
                  if(computed_result.get(new_index).dest_value == 0)
                      zero_flag = true;
                  else 
                     zero_flag = false;
                  
              airthmetic_counter++;
              }
               break;
           case "MUL":
               if(Pipeline.control_flag== true){
               while( inst_count > computed_result.size()){
                   computed_result.add(new value(0,0,0));
               }
               }
               for(int g =0 ; g<computed_result.size() ; g++){
                   if(inst_list.get(inst_count).inst_line_address == computed_result.get(g).inst_line_address)
                   {
                       new_index = g;
                       break;
                   }
                   
               }
              if(inst_list.get(inst_count).inst_line_address == computed_result.get(new_index).inst_line_address)
              {
                  R[computed_result.get(new_index).dest_index] = computed_result.get(new_index).dest_value;
                  R_flag[computed_result.get(new_index).dest_index]=false;
                  
                  if(computed_result.get(new_index).dest_value == 0)
                      zero_flag = true;
                  else 
                     zero_flag = false;
                  
              airthmetic_counter++;
              }
               break;
           case "LOAD":
               if(Pipeline.control_flag== true){
               while( inst_count > computed_result.size()){
                   computed_result.add(new value(0,0,0));
               }
               }
               for(int g =0 ; g<computed_result.size() ; g++){
                   if(inst_list.get(inst_count).inst_line_address == computed_result.get(g).inst_line_address)
                   {
                       new_index = g;
                       break;
                   }
                   
               }
               if(inst_list.get(inst_count).inst_line_address == computed_result.get(new_index).inst_line_address)
              {
                R[computed_result.get(new_index).dest_index]=memory[computed_result.get(new_index).dest_value];
                R_flag[computed_result.get(new_index).dest_index]=false;
              }
               break;
           case "STORE":
               //does nothing just the information is passed.
               break;
           case "JUMP":
               //does nothing
               break;
           case "BNZ":
               //will not do anything
               break;
           case "BZ":
               //will not do anything
               break;
           case "AND":
               if(Pipeline.control_flag== true){
               while( inst_count > computed_result.size()){
                   computed_result.add(new value(0,0,0));
               }
               }
               for(int g =0 ; g<computed_result.size() ; g++){
                   if(inst_list.get(inst_count).inst_line_address == computed_result.get(g).inst_line_address)
                   {
                       new_index = g;
                       break;
                   }
                   
               }
              if(inst_list.get(inst_count).inst_line_address == computed_result.get(new_index).inst_line_address)
              {
                  R[computed_result.get(new_index).dest_index] = computed_result.get(new_index).dest_value;
                  R_flag[computed_result.get(new_index).dest_index] =false;
              
                  if(computed_result.get(new_index).dest_value == 0)
                      zero_flag = true;
                  else 
                     zero_flag = false;
                  
              airthmetic_counter++;
                  
              }
              
               break;
           case "EXOR":
               if(Pipeline.control_flag== true){
               while( inst_count > computed_result.size()){
                   computed_result.add(new value(0,0,0));
               }
               }
               for(int g =0 ; g<computed_result.size() ; g++){
                   if(inst_list.get(inst_count).inst_line_address == computed_result.get(g).inst_line_address)
                   {
                       new_index = g;
                       break;
                   }
                   
               }
              if(inst_list.get(inst_count).inst_line_address == computed_result.get(new_index).inst_line_address)
              {
                  R[computed_result.get(new_index).dest_index] = computed_result.get(new_index).dest_value;
                  R_flag[computed_result.get(new_index).dest_index] =false;
              
                  if(computed_result.get(new_index).dest_value == 0)
                      zero_flag = true;
                  else 
                     zero_flag = false;
                  
              airthmetic_counter++;
              }
               break;
           case "OR":
               if(Pipeline.control_flag== true){
               while( inst_count > computed_result.size()){
                   computed_result.add(new value(0,0,0));
               }
               }
               for(int g =0 ; g<computed_result.size() ; g++){
                   if(inst_list.get(inst_count).inst_line_address == computed_result.get(g).inst_line_address)
                   {
                       new_index = g;
                       break;
                   }
                   
               }
              if(inst_list.get(inst_count).inst_line_address == computed_result.get(new_index).inst_line_address)
              {
                  R[computed_result.get(new_index).dest_index] = computed_result.get(new_index).dest_value;
                  R_flag[computed_result.get(new_index).dest_index] =false;
              
                  if(computed_result.get(new_index).dest_value == 0)
                      zero_flag = true;
                  else 
                     zero_flag = false;
                  
              airthmetic_counter++;
              
              }
               break;
           case "BUBBLE":
               System.out.println("Bubble in Writeback Stage");
              break;
           case "NULL":
               
               break;
       }
       //System.out.println(decode.PSW_counter);
       //System.out.println(airthmetic_counter);
       if(Pipeline.stall_flag == true){
           if(R_flag[decode.bubble_encountered_index1]== false && R_flag[decode.bubble_encountered_index2]== false){
               stall_flag=false;
               decode.stall_count_d=0;
           }
           
           if(Pipeline.PSW_counter == airthmetic_counter){
                  if(writeback.non_zero_flag== true){
                    stall_flag= false;
               }
               }
       }
       
        }
        
    }

