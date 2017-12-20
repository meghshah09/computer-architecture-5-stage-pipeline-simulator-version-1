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
public class mapping {
     public int line_no;
    public int inst_line_address;
    public String inst;
    public String dest;
    public String src1;
    public String src2;
    public int literal;
    public boolean status;
    
    public mapping(){
        
    }
    
    mapping(int no,int add, String i, String d, String s1, String s2, boolean st){
        line_no = no; 
        inst_line_address=add;
        inst=i;
        dest=d;
        src1=s1;
        if(s2.startsWith("#")){
                    StringBuffer sb = new StringBuffer(s2);
                    sb.deleteCharAt(0);
                    literal=Integer.parseInt(sb.toString());
                    src2=null;
        }
        else{src2=s2;
        literal= 10000;}
        status=st;
    }

mapping(int no,int add, String i, String d, String l, boolean st){
    line_no = no;     
    inst_line_address=add;
        inst=i;
        dest=d;
        //src1=s1;
       // src2=s2;
        if(l.startsWith("#")){
                    StringBuffer sb = new StringBuffer(l);
                    sb.deleteCharAt(0);
                    literal=Integer.parseInt(sb.toString());
        }
        status=st;
    }
mapping(int no,int add, String i, String l, boolean st){
    line_no = no;     
    inst_line_address=add;
        inst=i;
        //dest=d;
        //src1=s1;
       // src2=s2;
        if(l.startsWith("#")){
                    StringBuffer sb = new StringBuffer(l);
                    sb.deleteCharAt(0);
                    literal=Integer.parseInt(sb.toString());
        }
        status=st;
    }
mapping(int no,int add, String i, boolean st){
    line_no = no;    
    inst_line_address=add;
        inst=i;
        //dest=d;
        //src1=s1;
       // src2=s2;
        //literal=l;
        status=st;
    }

    
}
