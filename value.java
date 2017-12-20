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
public class value {
    
    public int inst_line_address;
    public int dest_value;
    public int dest_index;
    
    value(int address, int dv , int di){
        inst_line_address = address;
        dest_value = dv;
        dest_index = di;
        
    }
    
}
