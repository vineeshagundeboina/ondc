package com.splenta.gstreturns.pojo.gst;

import java.util.List;

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
public class B2BAGSTR1 {

	private String ctin;

	private List<InvB2BAGSTR1> inv;

}
