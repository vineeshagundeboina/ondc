package com.splenta.gstreturns.pojo.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class DecryptSekRequest {
	private String encryptedSek;
	private String originalAppKey;

}
