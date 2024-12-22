package com.splenta.gstreturns.pojo.request;

import java.util.List;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
@Data
@Getter
@Setter
public class RefDtls {
	
	private String invRm;
    private DocPerdDtls docPerdDtls;
    private List<PrecDocDtls> precDocDtls;
    private List<ContrDtls> contrDtls;

}
