package com.splenta.gstreturns.pojo.gst;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InvGSTR2 {
	@JsonProperty("chksum") 
    
    String chksum;
    @JsonProperty("inum") 
   
    String inum;
    @JsonProperty("idt") 
    
    String idt;
    @JsonProperty("val") 
   
    double val;
    @JsonProperty("pos") 
   
    String pos;
    @JsonProperty("rchrg") 
   
    String rchrg;
    @JsonProperty("inv_typ") 
  
    String inv_typ;
    @JsonProperty("diff_percent") 
    
    double diff_percent;
    @JsonProperty("aspd") 
    
    String aspd;
    @JsonProperty("atyp") 
   
    String atyp;
    @JsonProperty("srctyp") 
   
    String srctyp;
    @JsonProperty("irn") 
   
    String irn;
    @JsonProperty("irngendate") 
  
    String irngendate;
    @JsonProperty("itms") 
    ArrayList<ItmGSTR2> itms;
}
