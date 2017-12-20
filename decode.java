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
public class decode extends Pipeline{
   public boolean halt_flag = false;
    public static int bubble_encountered=0;
    public static int stall_count_d=0;
    public static int bubble_encountered_index1;
    public static int bubble_encountered_index2;
    
   
    decode(){
       
   }
   decode(int inst_count){
       int src1_index_d;
       int src2_index_d;
       int dest_index_d;
       String array_index_d;
           
       System.out.print("executing Instruction No."+(inst_count) +" in Decode Stage");
       System.out.print("    ");
       System.out.println(inst_list.get(inst_count).inst_line_address + " "+inst_list.get(inst_count).inst);
       
       switch(inst_list.get(inst_count).inst){
       
           case "HALT" :
               //it has to say to stop fetching
               for(int cancel = inst_count+1 ; cancel<inst_list.size();cancel++){
                  inst_list.remove(cancel);
                inst_list.add(cancel,new instruction (100,0,"NOP",false));
               }
               break;
           
               case "ADD":
                   //for destination
                   StringBuffer sb1 = new StringBuffer(inst_list.get(inst_count).dest);
               if(sb1.length() ==2){
                   Character c = sb1.charAt(1);
                   dest_index_d=Integer.parseInt(c.toString());
               }
               else {
                   Character c1 = sb1.charAt(1);
                   Character c2 = sb1.charAt(2);
                  dest_index_d = Integer.parseInt(c1.toString()+ c2.toString());
               }
                   //for source1
               sb1 = new StringBuffer(inst_list.get(inst_count).src1);
               if(sb1.length() ==2){
                   Character c = sb1.charAt(1);
                   src1_index_d=Integer.parseInt(c.toString());
               }
               else {
                   Character c1 = sb1.charAt(1);
                   Character c2 = sb1.charAt(2);
                  src1_index_d = Integer.parseInt(c1.toString()+ c2.toString());
               }
               
               // for source 2
               sb1 = new StringBuffer(inst_list.get(inst_count).src2);
               if(sb1.length() ==2){
                   Character c = sb1.charAt(1);
                   src2_index_d=Integer.parseInt(c.toString());
               }
               else {
                   Character c1 = sb1.charAt(1);
                   Character c2 = sb1.charAt(2);
                  src2_index_d = Integer.parseInt(c1.toString()+ c2.toString());
               }
               
               if(R_flag[src1_index_d]==false && R_flag[src2_index_d]==false){
               stall_flag=false;
               R_flag[dest_index_d]=true;
               }
               else{
                   stall_flag=true;
                   if(stall_count_d ==0){bubble_encountered = inst_count;
                   bubble_encountered_index1 = src1_index_d ;
                   bubble_encountered_index2 = src2_index_d;
                   }
                   stall_count_d++;
                   
               }
               
               break;
               
              
           case "SUB":
               //for destination
                   sb1 = new StringBuffer(inst_list.get(inst_count).dest);
               if(sb1.length() ==2){
                   Character c = sb1.charAt(1);
                   dest_index_d=Integer.parseInt(c.toString());
               }
               else {
                   Character c1 = sb1.charAt(1);
                   Character c2 = sb1.charAt(2);
                  dest_index_d = Integer.parseInt(c1.toString()+ c2.toString());
               }
               //for source 1
               sb1 = new StringBuffer(inst_list.get(inst_count).src1);
               if(sb1.length() ==2){
                   Character c = sb1.charAt(1);
                   src1_index_d=Integer.parseInt(c.toString());
               }
               else {
                   Character c1 = sb1.charAt(1);
                   Character c2 = sb1.charAt(2);
                  src1_index_d = Integer.parseInt(c1.toString()+ c2.toString());
               }
               
               // for source 2
               sb1 = new StringBuffer(inst_list.get(inst_count).src2);
               if(sb1.length() ==2){
                   Character c = sb1.charAt(1);
                   src2_index_d=Integer.parseInt(c.toString());
               }
               else {
                   Character c1 = sb1.charAt(1);
                   Character c2 = sb1.charAt(2);
                  src2_index_d = Integer.parseInt(c1.toString()+ c2.toString());
               }
               
               if(R_flag[src1_index_d]==false && R_flag[src2_index_d]==false){
               stall_flag=false;
               R_flag[dest_index_d]=true;
               }
               else{
                   stall_flag=true;
                   if(stall_count_d ==0){bubble_encountered = inst_count;
                   bubble_encountered_index1 = src1_index_d ;
                   bubble_encountered_index2 = src2_index_d;
                   }
                   stall_count_d++;
                   
               }
               
               break;
               
              
           case "MUL":
               //for destination
                   sb1 = new StringBuffer(inst_list.get(inst_count).dest);
               if(sb1.length() ==2){
                   Character c = sb1.charAt(1);
                   dest_index_d=Integer.parseInt(c.toString());
               }
               else {
                   Character c1 = sb1.charAt(1);
                   Character c2 = sb1.charAt(2);
                  dest_index_d = Integer.parseInt(c1.toString()+ c2.toString());
               }
               //for source 1
               sb1 = new StringBuffer(inst_list.get(inst_count).src1);
               if(sb1.length() ==2){
                   Character c = sb1.charAt(1);
                   src1_index_d=Integer.parseInt(c.toString());
               }
               else {
                   Character c1 = sb1.charAt(1);
                   Character c2 = sb1.charAt(2);
                  src1_index_d = Integer.parseInt(c1.toString()+ c2.toString());
               }
               
               // for source 2
               sb1 = new StringBuffer(inst_list.get(inst_count).src2);
               if(sb1.length() ==2){
                   Character c = sb1.charAt(1);
                   src2_index_d=Integer.parseInt(c.toString());
               }
               else {
                   Character c1 = sb1.charAt(1);
                   Character c2 = sb1.charAt(2);
                  src2_index_d = Integer.parseInt(c1.toString()+ c2.toString());
               }
               
               if(R_flag[src1_index_d]==false && R_flag[src2_index_d]==false){
               stall_flag=false;
               R_flag[dest_index_d]= true;
              
               }
               else{
                   stall_flag=true;
                   if(stall_count_d ==0){bubble_encountered = inst_count;
                   bubble_encountered_index1 = src1_index_d ;
                   bubble_encountered_index2 = src2_index_d;
                   }
                   stall_count_d++;
                   
               }
               
               break;
              
           case "LOAD":
               //for destination
            
                  sb1 = new StringBuffer(inst_list.get(inst_count).dest);
               if(sb1.length() ==2){
                   Character c = sb1.charAt(1);
                   dest_index_d=Integer.parseInt(c.toString());
               }
               else {
                   Character c1 = sb1.charAt(1);
                   Character c2 = sb1.charAt(2);
                  dest_index_d = Integer.parseInt(c1.toString()+ c2.toString());
               }
               //for source 1
               sb1 = new StringBuffer(inst_list.get(inst_count).src1);
               if(sb1.length() ==2){
                   Character c = sb1.charAt(1);
                   src1_index_d=Integer.parseInt(c.toString());
               }
               else {
                   Character c1 = sb1.charAt(1);
                   Character c2 = sb1.charAt(2);
                  src1_index_d = Integer.parseInt(c1.toString()+ c2.toString());
               }
               if(R_flag[src1_index_d]==false){
               stall_flag=false;
               R_flag[dest_index_d]=true;
               }
               else{
                   stall_flag=true;
                   if(stall_count_d ==0){bubble_encountered = inst_count;
                   bubble_encountered_index1 = src1_index_d ;
                   bubble_encountered_index2 = 16;
                   }
                   stall_count_d++;
                   
               }
               break;
           case "STORE":
               //for source 1
               sb1 = new StringBuffer(inst_list.get(inst_count).dest);
               if(sb1.length() ==2){
                   Character c = sb1.charAt(1);
                   src1_index_d=Integer.parseInt(c.toString());
               }
               else {
                   Character c1 = sb1.charAt(1);
                   Character c2 = sb1.charAt(2);
                  src1_index_d = Integer.parseInt(c1.toString()+ c2.toString());
               }
               
               // for source 2
               sb1 = new StringBuffer(inst_list.get(inst_count).src1);
               if(sb1.length() ==2){
                   Character c = sb1.charAt(1);
                   src2_index_d=Integer.parseInt(c.toString());
               }
               else {
                   Character c1 = sb1.charAt(1);
                   Character c2 = sb1.charAt(2);
                  src2_index_d = Integer.parseInt(c1.toString()+ c2.toString());
               }
               
               if(R_flag[src1_index_d]==false && R_flag[src2_index_d]==false){
               stall_flag=false;
               }
               else{
                   stall_flag=true;
                   if(stall_count_d ==0){bubble_encountered = inst_count;
                   bubble_encountered_index1 = src1_index_d ;
                   bubble_encountered_index2 = src2_index_d;
                   }
                   stall_count_d++;
                   
               }
               break;
           case "JUMP":
               //for destination
               sb1 = new StringBuffer(inst_list.get(inst_count).dest);
               if(sb1.length() ==2){
                   Character c = sb1.charAt(1);
                   src1_index_d=Integer.parseInt(c.toString());
               }
               else {
                   Character c1 = sb1.charAt(1);
                   Character c2 = sb1.charAt(2);
                  src1_index_d = Integer.parseInt(c1.toString()+ c2.toString());
               }
               if(R_flag[src1_index_d]==false){
                   stall_flag=false;
               }
               else{
               stall_flag = true;
               if(stall_count_d == 0){bubble_encountered = inst_count;
                   bubble_encountered_index1 = src1_index_d ;
                   bubble_encountered_index2 = 16;
               }
               stall_count_d++;
               }
               break;
               
           case "BNZ":
               if(PSW_counter == writeback.airthmetic_counter){
                 
                    stall_flag= false;
               
               }
               else{//wait
                   stall_flag=true;
                   if(stall_count_d == 0){bubble_encountered = inst_count;}
                   stall_count_d++;
               }
              break;
           case "BZ":
               if(PSW_counter == writeback.airthmetic_counter){
                  if(writeback.zero_flag== true){
                    stall_flag= false;
               }
               }
               else{//wait
                   stall_flag=true;
                   if(stall_count_d == 0){bubble_encountered = inst_count;}
                   stall_count_d++;
               }
               break;
               
       }
       
 }  
}
