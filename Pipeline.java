/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pipeline;
import java.io.*;
import java.util.*;
/**
 *
 * @author skdc
 */
public class Pipeline {

    /**
     * @param args the command line arguments
     */
    public static ArrayList<instruction> inst_list = new ArrayList<instruction>();
    public static ArrayList<value> computed_result = new ArrayList<value>();
    public static ArrayList<mapping> transfer = new ArrayList<mapping>();
    public static int inst_addr = 4000;
    public static int literal=0;
    public static instruction inst;
    public static value cr;
    public static mapping map;
    public static int []memory= new int[4000];
    public static int []R = new int[16];
    public static boolean []R_flag = new boolean[17];
    public static boolean HALT_flag=false;
    //public static boolean d_flag=false;
    //public static boolean e_flag=false;
    //public static boolean m_flag=false;
    public static boolean stall_flag= false;
    public static int result;
    public static boolean control_flag=false;
    public static int PSW_counter=0;
    public static int bubble=0;
    public static int number=0;
    public static int jump_no=0;
    public static int mul_count=0;
    private static boolean mul_flag=false;
    
    
    public static void main(String[] args) {
        // TODO code application logic here
        String line;
        int number=0;
        
    Scanner scan= null;
    String cs1="R";
    String cs2="#";
    int clock_cycle=0;
    String ans=null;
    String array_index;
    String array_index_mul1;
    int inst_count=0;
    int dest_index, src1_index, src2_index;
    int dest_index_mul1, src1_index_mul1, src2_index_mul1;

    boolean jump_flag =false;
    
   
    int stall_count=0;
    
    do{
    System.out.println("Enter Your Option : \n 1.Initailze \n 2.Simulate \n 3.Display");
    Scanner sc = new Scanner(System.in);
    int op = sc.nextInt();
    String []inst_set = new String[100];
    switch(op){
        
        
        case 1:
          try{
            File f = new File("input.txt");
            scan = new Scanner(f);
            } 
          catch(FileNotFoundException e){
            System.out.println("File Not Found");    
          }
           int i1 =0;
          while(scan.hasNextLine()){
             
              line=scan.nextLine();
              inst_set=line.split(",");
/*
               if(inst_set[i].startsWith(cs1)){ /* for register 
                    StringBuilder sb = new StringBuilder(inst_set[i]);
                    inst_set[i]= sb.toString();
            }
            else /* for literal to convert in int 
                if(inst_set[i].startsWith("#")){
                    StringBuffer sb = new StringBuffer(inst_set[i]);
                    sb.deleteCharAt(0);
                    inst_set[i]=sb.toString();
                    literal=Integer.parseInt(inst_set[i]);    
                }
            else{
                    /* basically does nothing only inst name will come in this 
                inst_set[i]=inst_set[i];
               }
              //System.out.println(inst_set[i]); 
              //System.out.println("i is "+i);
              */
                switch(inst_set[0]){
                    case "ADD" : 
                        boolean st = true;
                            inst = new instruction(i1,inst_addr, inst_set[0],inst_set[1],inst_set[2],inst_set[3],st);
                        inst_list.add(inst);
                        map = new mapping(i1,inst_addr, inst_set[0],inst_set[1],inst_set[2],inst_set[3],st);
                        transfer.add(map);
                        break;
                    case "SUB" : 
                        st = true;
                            inst = new instruction(i1,inst_addr, inst_set[0],inst_set[1],inst_set[2],inst_set[3],st);
                        inst_list.add(inst);
                        map = new mapping(i1,inst_addr, inst_set[0],inst_set[1],inst_set[2],inst_set[3],st);
                        transfer.add(map);
                        break;
                    case "MUL" : 
                        st = true;
                       
                            inst = new instruction(i1,inst_addr, inst_set[0],inst_set[1],inst_set[2],inst_set[3],st);
                        
                        inst_list.add(inst);
                        map = new mapping(i1,inst_addr, inst_set[0],inst_set[1],inst_set[2],inst_set[3],st);
                        
                        transfer.add(map);
                        break;
                    case "MOVC" : 
                        st = false;
                        inst = new instruction(i1,inst_addr, inst_set[0],inst_set[1],inst_set[2],st);
                        inst_list.add(inst);
                        map = new mapping(i1,inst_addr, inst_set[0],inst_set[1],inst_set[2],st);
                        transfer.add(map);
                        break;
                    case "LOAD" : 
                        st = false;
                        inst = new instruction(i1,inst_addr, inst_set[0],inst_set[1],inst_set[2],inst_set[3],st);
                        inst_list.add(inst);
                        map = new mapping(i1,inst_addr, inst_set[0],inst_set[1],inst_set[2],inst_set[3],st);
                        transfer.add(map);
                        break;
                    case "STORE" : 
                        st = false;
                        inst = new instruction(i1,inst_addr, inst_set[0],inst_set[1],inst_set[2],inst_set[3],st);
                        inst_list.add(inst);
                        map = new mapping(i1,inst_addr, inst_set[0],inst_set[1],inst_set[2],inst_set[3],st);
                        transfer.add(map);
                        break;
                    case "JUMP" : 
                         st = false;
                        inst = new instruction(i1,inst_addr, inst_set[0],inst_set[1],inst_set[2],st);
                        inst_list.add(inst);
                        map = new mapping(i1,inst_addr, inst_set[0],inst_set[1],inst_set[2],st);
                        transfer.add(map);
                        break;
                    case "BNZ" : 
                        st = false;
                        inst = new instruction(i1,inst_addr, inst_set[0],inst_set[1],st);
                        inst_list.add(inst);
                        map = new mapping(i1,inst_addr, inst_set[0],inst_set[1],st);
                        transfer.add(map);
                        break;
                    case "BZ" : 
                        st = false;
                        inst = new instruction(i1,inst_addr, inst_set[0],inst_set[1],st);
                        inst_list.add(inst);
                        map = new mapping(i1,inst_addr, inst_set[0],inst_set[1],st);
                        transfer.add(map);
                        break;
                    case "HALT" : 
                        st = false;
                        inst = new instruction(i1,inst_addr, inst_set[0],st);
                        inst_list.add(inst);
                        map = new mapping(i1,inst_addr, inst_set[0],st);
                        transfer.add(map);
                        break;
                    case "AND":
                        inst = new instruction(i1,inst_addr, inst_set[0],inst_set[1],inst_set[2],inst_set[3],false);
                        inst_list.add(inst);
                        map = new mapping(i1,inst_addr, inst_set[0],inst_set[1],inst_set[2],inst_set[3],false);
                        transfer.add(map);
                        break;
                    case "EXOR":
                        inst = new instruction(i1,inst_addr, inst_set[0],inst_set[1],inst_set[2],inst_set[3],false);
                        inst_list.add(inst);
                        map = new mapping(i1,inst_addr, inst_set[0],inst_set[1],inst_set[2],inst_set[3],false);
                        transfer.add(map);
                        break;
                    case "OR":
                        inst = new instruction(i1,inst_addr, inst_set[0],inst_set[1],inst_set[2],inst_set[3],false);
                        inst_list.add(inst);
                        map = new mapping(i1,inst_addr, inst_set[0],inst_set[1],inst_set[2],inst_set[3],false);
                        transfer.add(map);
                        break;
              }
                  //System.out.println(inst.src1);
                  i1 = i1 + 1;
                  number++;
               inst_addr = inst_addr+4;
             
          }
          
             //for (int i =0;i<3; i++)
              
          
          for(int i = 0; i<4000; i++)
              memory[i]=0;
          
          for(int i = 0; i<16; i++)
              R[i]=0;
          for(int i = 0; i<17; i++)
              R_flag[i]=false;
          System.out.println("Intialized complete");
          break;
    // end of first case      
        case 2:
          
            System.out.println("Enter the no. of cycles you want to simulate : ");
            int n = sc.nextInt();
            int cnt_mem=0;
            int cnt_wb=0;
            int inst_count_mul1=0;
            int inst_count_mul2 =0;
            int inst_count_wb=0;
            int inst_count_mem=0;
            int inst_count_ex =0;
           int inst_count_d =0;
            
    for(int i =0; i<n;i++){ // start of loop
        
                clock_cycle++;
                System.out.println("------Cycle no. is "+ clock_cycle+"---------");
                
      if(true){  
System.out.println("FETCH STAGE : ");
          if(inst_count <inst_list.size()){
          if(i>=0){   
              
              if(jump_flag==true){
                  fetch f= new fetch(jump_no);
              }
              else if(inst_list.get(inst_count).inst == "NOP"){
                  System.out.println("NOP");
              }
              else{
          fetch f= new fetch(inst_count); }
                if(i==0){
                 inst_count++;
                }
          
          }
          }// end for checking size.
          else{
              System.out.println(" NO INSTRUCTIONS");
          }
          
          //for Decode stage
          System.out.println("DECODE STAGE : ");
     if(inst_count_d < inst_list.size()-1){     
        if(i>=1){
            
           inst_count_d  = inst_count-stall_count-1;
     
           if(inst_list.get(inst_count_d).inst == "NOP")
            {
                System.out.println("NOP");
            }
            
            else if(jump_flag==true){
                inst_count_d  = jump_no-1;
            decode d= new decode(inst_count_d);
           }
            else{
                
                decode d= new decode(inst_count_d);
                   // will do nothing if inst_count is 0.
            }
            
          if(i==1){
              inst_count++;
            
          }
        }
        }
        else{
        System.out.println("  NO INSTRUCTIONS");
        }
     
        System.out.println("INTEGER EXECUTION STAGE : ");
        if(inst_count_ex < inst_list.size()-1){ 
        if(i>=2){
            
            inst_count_ex =inst_count-2;
            String Str = inst_list.get(inst_count_ex).inst; //just for decoding
            
            if(Str=="NOP"){
                System.out.println("NOP");
            }
            else if(jump_flag== true){
                inst_count_ex = jump_no-2;
            }
      
          switch(inst_list.get(inst_count_ex).inst){
           
           case "MOVC":
               
               // for destination
               StringBuffer sb = new StringBuffer(inst_list.get(inst_count_ex).dest);
               array_index=sb.deleteCharAt(0).toString();
               dest_index = Integer.parseInt(array_index);
               
               new execute(inst_count_ex, dest_index);

               break;
           case "ADD":
              if((inst_list.get(inst_count_ex).src2) != null ){
                  
               sb = new StringBuffer(inst_list.get(inst_count_ex).dest);
               array_index=sb.deleteCharAt(0).toString();
               dest_index = Integer.parseInt(array_index);
               
               sb = new StringBuffer(inst_list.get(inst_count_ex).src1);
               array_index=sb.deleteCharAt(0).toString();
               src1_index = Integer.parseInt(array_index);
                                  
               sb = new StringBuffer(inst_list.get(inst_count_ex).src2);
               array_index=sb.deleteCharAt(0).toString();
               src2_index = Integer.parseInt(array_index);
               
               
                   new execute(inst_count_ex,dest_index, src1_index, src2_index);
               
               
              }// end of if for checking src2 is literal or register
              else {
                  sb = new StringBuffer(inst_list.get(inst_count_ex).dest);
               array_index=sb.deleteCharAt(0).toString();
               dest_index = Integer.parseInt(array_index);
               
               sb = new StringBuffer(inst_list.get(inst_count_ex).src1);
               array_index=sb.deleteCharAt(0).toString();
               src1_index = Integer.parseInt(array_index);
               
               if(R_flag[src1_index]==false){
                   new execute(inst_count_ex,dest_index, src1_index);
               }
               
              }// end of outer else.
              if(control_flag == false) // for control instruction BZ and BNZ
              PSW_counter++;
              break;
           case "SUB":
            if((inst_list.get(inst_count_ex).src2) != null ){
                  
               sb = new StringBuffer(inst_list.get(inst_count_ex).dest);
               array_index=sb.deleteCharAt(0).toString();
               dest_index = Integer.parseInt(array_index);
               
               sb = new StringBuffer(inst_list.get(inst_count_ex).src1);
               array_index=sb.deleteCharAt(0).toString();
               src1_index = Integer.parseInt(array_index);
                                  
               sb = new StringBuffer(inst_list.get(inst_count_ex).src2);
               array_index=sb.deleteCharAt(0).toString();
               src2_index = Integer.parseInt(array_index);
               
               
                   new execute(inst_count_ex,dest_index, src1_index, src2_index);
               
               
              }// end of if for checking src2 is literal or register
              else {
                  sb = new StringBuffer(inst_list.get(inst_count_ex).dest);
               array_index=sb.deleteCharAt(0).toString();
               dest_index = Integer.parseInt(array_index);
               
               sb = new StringBuffer(inst_list.get(inst_count_ex).src1);
               array_index=sb.deleteCharAt(0).toString();
               src1_index = Integer.parseInt(array_index);
               
               if(R_flag[src1_index]==false){
                   new execute(inst_count_ex,dest_index, src1_index);
               }

              }// end of outer else.
            if(control_flag == false) // for control instruction BZ and BNZ
              PSW_counter++;
              break;
           
           case "STORE":
               sb = new StringBuffer(inst_list.get(inst_count_ex).dest);
               array_index=sb.deleteCharAt(0).toString();
               dest_index = Integer.parseInt(array_index);
               
               sb = new StringBuffer(inst_list.get(inst_count_ex).src1);
               array_index=sb.deleteCharAt(0).toString();
               src1_index = Integer.parseInt(array_index);
               
               if(R_flag[src1_index]==false && R_flag[dest_index]==false){
                new execute(inst_count_ex,dest_index,src1_index);
               }

               break;
           case "LOAD":
               sb = new StringBuffer(inst_list.get(inst_count_ex).dest);
               array_index=sb.deleteCharAt(0).toString();
               dest_index = Integer.parseInt(array_index);
               
               sb = new StringBuffer(inst_list.get(inst_count_ex).src1);
               array_index=sb.deleteCharAt(0).toString();
               src1_index = Integer.parseInt(array_index);
               
               
                new execute(inst_count_ex,dest_index,src1_index);
               


               break;
           case "BZ":
               if(writeback.zero_flag ==true){
                     new execute(inst_count_ex,0); 
                     jump_flag =true;
                     cnt_mem=0;
                     cnt_wb=0;
               }
               else{ new execute ();
               }
               break;
           case "JUMP":
               sb = new StringBuffer(inst_list.get(inst_count_ex).dest);
               array_index=sb.deleteCharAt(0).toString();
               dest_index = Integer.parseInt(array_index);
              if(R_flag[dest_index] == false )
               {
               new execute(inst_count_ex, dest_index);
               jump_flag =true;
               //inst_count=jump_no;
                
                cnt_mem=0;
                cnt_wb=0;
               }

               break;
           case "BNZ":
              if(writeback.zero_flag == false){
                     new execute(inst_count_ex,0);
                     jump_flag =true;
                     cnt_mem=0;
                     cnt_wb=0;
          }
          else {new execute(); }
               break;
           case "HALT":
               new execute(inst_count_ex,0);
               break;
           case "AND":
               sb = new StringBuffer(inst_list.get(inst_count_ex).dest);
               array_index=sb.deleteCharAt(0).toString();
               dest_index = Integer.parseInt(array_index);
               
               sb = new StringBuffer(inst_list.get(inst_count_ex).src1);
               array_index=sb.deleteCharAt(0).toString();
               src1_index = Integer.parseInt(array_index);
                                  
               sb = new StringBuffer(inst_list.get(inst_count_ex).src2);
               array_index=sb.deleteCharAt(0).toString();
               src2_index = Integer.parseInt(array_index);
               
               if(R_flag[src1_index]==false && R_flag[src2_index]==false){
                  new execute(inst_count_ex,dest_index, src1_index, src2_index);
               }
               if(control_flag == false) // for control instruction BZ and BNZ
              PSW_counter++;
               break;
           case "EXOR":
               sb = new StringBuffer(inst_list.get(inst_count_ex).dest);
               array_index=sb.deleteCharAt(0).toString();
               dest_index = Integer.parseInt(array_index);
               
               sb = new StringBuffer(inst_list.get(inst_count_ex).src1);
               array_index=sb.deleteCharAt(0).toString();
               src1_index = Integer.parseInt(array_index);
                                  
               sb = new StringBuffer(inst_list.get(inst_count_ex).src2);
               array_index=sb.deleteCharAt(0).toString();
               src2_index = Integer.parseInt(array_index);
               
               if(R_flag[src1_index]==false && R_flag[src2_index]==false){
                  new execute(inst_count_ex,dest_index, src1_index, src2_index);
               }
               if(control_flag == false) // for control instruction BZ and BNZ
              PSW_counter++;
               break;
           case "OR":
               sb = new StringBuffer(inst_list.get(inst_count_ex).dest);
               array_index=sb.deleteCharAt(0).toString();
               dest_index = Integer.parseInt(array_index);
               
               sb = new StringBuffer(inst_list.get(inst_count_ex).src1);
               array_index=sb.deleteCharAt(0).toString();
               src1_index = Integer.parseInt(array_index);
                                  
               sb = new StringBuffer(inst_list.get(inst_count_ex).src2);
               array_index=sb.deleteCharAt(0).toString();
               src2_index = Integer.parseInt(array_index);
               
               if(R_flag[src1_index]==false && R_flag[src2_index]==false){
                  new execute(inst_count_ex,dest_index, src1_index, src2_index);
               }
               if(control_flag == false) // for control instruction BZ and BNZ
              PSW_counter++;
               break;
           case "BUBBLE":
               //System.out.println("Bubble in execution Stage");
               new execute(inst_count_ex,0);

               break;
    }
        
          if(i==2){
              inst_count++;
          }
          
        }// end if statement for ex stage
        }
        else{
            System.out.println(" NO INSTRUCTION");
        }
        
        
        //for MUL1
        System.out.println("MUL1 FU STAGE :");
        if(inst_count_mul1 <inst_list.size()-1){
        if(i>=2){
           
            inst_count_mul1 = inst_count -2;
       switch(inst_list.get(inst_count_mul1).inst){

               case "MUL":
                   
            if((inst_list.get(inst_count_mul1).src2) != null ){
                  
               StringBuffer sb = new StringBuffer(inst_list.get(inst_count_mul1).dest);
               array_index_mul1=sb.deleteCharAt(0).toString();
               dest_index_mul1 = Integer.parseInt(array_index_mul1);
               
               sb = new StringBuffer(inst_list.get(inst_count_mul1).src1);
               array_index_mul1=sb.deleteCharAt(0).toString();
               src1_index_mul1 = Integer.parseInt(array_index_mul1);
                                  
               sb = new StringBuffer(inst_list.get(inst_count_mul1).src2);
               array_index_mul1=sb.deleteCharAt(0).toString();
               src2_index_mul1 = Integer.parseInt(array_index_mul1);
               
               mul_flag=true;
                   new Mul1(inst_count_mul1,dest_index_mul1, src1_index_mul1, src2_index_mul1);
              }// end of if for checking src2 is literal or register
              
                if(control_flag == false) // for control instruction BZ and BNZ
              PSW_counter++;
              break;
              
       }   
        }// end of inner if
     }//checking if there are no instruction
        else{
            
        }   
        //for MUL2
        System.out.println("MUL2 FU STAGE :");
        if(inst_count_mul2 <inst_list.size()-1){
        if(i>=3){
            
           inst_count_mul2 = inst_count-3;
           
           switch(inst_list.get(inst_count_mul2).inst){
               case "MUL":
                  new Mul2(inst_count_mul2);
                  mul_count++;
                   break;
           }
        
        }// end of inner if
        }// checking if there are no instruction
        else{
            // print nothing
        }
        
    if(mul_count == 1)    
    {
        inst = new instruction (0,100,"NULL",false);
                inst_list.add(inst_count_mul2,inst);
                
    }
        
        //for memory
        System.out.println("MEMORY STAGE : ");
        
   if(inst_count_mem <inst_list.size()-1){
    if(i>=3){
       
        inst_count_mem= (inst_count- 3);
        
        String Str = inst_list.get(inst_count_mem).inst; //just for decoding
            if(Str=="NOP" && cnt_mem <2){
                System.out.println("NOP");
                if(jump_flag == true ){cnt_mem++; }
            }
           else if(cnt_mem >=2 && cnt_mem <3){
              inst_count_mem = jump_no-3;
              memory mem = new memory(inst_count_mem);   
            }
            else if(Str=="NOP"){
            System.out.println("NOP");
            }
            else{
        memory mem = new memory(inst_count_mem);
                
        if(i==3){
            inst_count++;
            
        }
                   
            }        
    }
   }// end if for memory stage
   
   else{
            System.out.println(" NO INSTRUCTION");
        }
   
   //for writeback
   System.out.println("WRITEBACK STAGE : ");
   if(inst_count_wb < inst_list.size()-1){
    if(i>=4){
        
       
        inst_count_wb= (inst_count - 4);

       String Str = inst_list.get(inst_count_wb).inst; //just for decoding
           if(Str=="NOP" && cnt_wb < 2){
                System.out.println("NOP");
                if(jump_flag == true){cnt_wb++; }
            }

            else if(cnt_wb >=2 &&cnt_wb <3){
                inst_count_wb = jump_no-4;
                writeback wb = new writeback(inst_count_wb);
                if(cnt_wb == 2){
                    inst_count=jump_no;
                    inst_count++;
                jump_flag = false;
                }
            else if(Str=="NOP"){
            System.out.println("NOP");
            //inst_count++;
            }
            }
        
          else          
        {   
            writeback wb = new writeback(inst_count_wb);
                    inst_count++;//successfull implementation of clock cycle 
        }
        jump_no++;
        
    }//end of if statement for writeback stage
   }
   else{
            System.out.println(" NO INSTRUCTION");
        }
  }// end of  if for checking stall
      
      
    //logic for stall will be here
    if(stall_flag==true){
        
        inst = new instruction (0,100,"BUBBLE",false);
                inst_list.add(decode.bubble_encountered,inst);
                bubble++;
    
    } // end of if for checking stall encountered or not
            }// end of for loop
            
          System.out.println("Simulatation Successfull !!");  
          break;
        
        case 3:
            for(int z =0 ; z<16; z++)
            {
                System.out.println("Register R["+z+"] ---> " + R[z]);
            }
            
            for(int z =0 ; z<400;)
            {
                System.out.println(" MEMORY["+z+"] ---> " + memory[z]);
                z=z+4;
            }
            System.out.println("Display Done");
            break;

    
    }
    //System.out.println("Do you want to continue ");
   // ans=scan.nextLine();
    }while(true);    
    }
    }


