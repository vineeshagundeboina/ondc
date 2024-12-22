package com.splenta.hrms.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
// @PropertySource("classpath:messages.properties")
@ConfigurationProperties
public class GlobalProperties {

	private String messageproductcategory;
	private String messagecategoryspec;

	private String messagepcmandatory;

	private String messagerecordexistsearchkey;

	private String messagerecordexistsearchname;

	private String messagerecordexistid;

	private String messagerecordmismatch;

	private String messagevm;

	private String messagesm;

	private String messageinvalidtrantype;

	private String messageinvalidslotupdate;

	private String messagekioskinvaliduser;

	private String messagekioskinvalidcard;

	private String messagekioskfirsttimecard;

	private String messageslotinactive;

	private String messageinvalidrecordid;

	private String messageactionnotallowedoem;

	private String messageinvalidmobilenumber;

	private String messageapprovalrequired;

	private String messagesparevalidation;

	private String messagecostcenter;
	
	private String messageEmailHeader;
	
	private String messageEmailBody;
	
	public String getMessageEmailHeader() {
		return messageEmailHeader;
	}

	public void setMessageEmailHeader(String messageEmailHeader) {
		this.messageEmailHeader = messageEmailHeader;
	}

	public String getMessageEmailBody() {
		return messageEmailBody;
	}

	public void setMessageEmailBody(String messageEmailBody) {
		this.messageEmailBody = messageEmailBody;
	}

	

	public String getMessagekioskinvalidcard() {
		return messagekioskinvalidcard;
	}

	public void setMessagekioskinvalidcard(String messagekioskinvalidcard) {
		this.messagekioskinvalidcard = messagekioskinvalidcard;
	}

	public String getMessagekioskinvaliduser() {
		return messagekioskinvaliduser;
	}

	public void setMessagekioskinvaliduser(String messagekioskinvaliduser) {
		this.messagekioskinvaliduser = messagekioskinvaliduser;
	}

	public String getMessagecategoryspec() {
		return messagecategoryspec;
	}

	public void setMessagecategoryspec(String messagecategoryspec) {
		this.messagecategoryspec = messagecategoryspec;
	}

	public String getMessageinvalidslotupdate() {
		return messageinvalidslotupdate;
	}

	public void setMessageinvalidslotupdate(String messageinvalidslotupdate) {
		this.messageinvalidslotupdate = messageinvalidslotupdate;
	}

	public String getMessageproductcategory() {
		return messageproductcategory;
	}

	public void setMessageproductcategory(String messageproductcategory) {
		this.messageproductcategory = messageproductcategory;
	}

	public String getMessagepcmandatory() {
		return messagepcmandatory;
	}

	public void setMessagepcmandatory(String messagepcmandatory) {
		this.messagepcmandatory = messagepcmandatory;
	}

	public String getMessagerecordexistsearchkey() {
		return messagerecordexistsearchkey;
	}

	public void setMessagerecordexistsearchkey(String messagerecordexistsearchkey) {
		this.messagerecordexistsearchkey = messagerecordexistsearchkey;
	}

	public String getMessagerecordexistsearchname() {
		return messagerecordexistsearchname;
	}

	public void setMessagerecordexistsearchname(String messagerecordexistsearchname) {
		this.messagerecordexistsearchname = messagerecordexistsearchname;
	}

	public String getMessagerecordexistid() {
		return messagerecordexistid;
	}

	public void setMessagerecordexistid(String messagerecordexistid) {
		this.messagerecordexistid = messagerecordexistid;
	}

	public String getMessagerecordmismatch() {
		return messagerecordmismatch;
	}

	public void setMessagerecordmismatch(String messagerecordmismatch) {
		this.messagerecordmismatch = messagerecordmismatch;
	}

	public String getMessagevm() {
		return messagevm;
	}

	public void setMessagevm(String messagevm) {
		this.messagevm = messagevm;
	}

	public String getMessagesm() {
		return messagesm;
	}

	public void setMessagesm(String messagesm) {
		this.messagesm = messagesm;
	}

	public String getMessageinvalidtrantype() {
		return messageinvalidtrantype;
	}

	public void setMessageinvalidtrantype(String messageinvalidtrantype) {
		this.messageinvalidtrantype = messageinvalidtrantype;
	}

	public String getMessagekioskfirsttimecard() {
		return messagekioskfirsttimecard;
	}

	public void setMessagekioskfirsttimecard(String messagekioskfirsttimecard) {
		this.messagekioskfirsttimecard = messagekioskfirsttimecard;
	}

	public String getMessageslotinactive() {
		return messageslotinactive;
	}

	public void setMessageslotinactive(String messageslotinactive) {
		this.messageslotinactive = messageslotinactive;
	}

	public String getMessageinvalidrecordid() {
		return messageinvalidrecordid;
	}

	public void setMessageinvalidrecordid(String messageinvalidrecordid) {
		this.messageinvalidrecordid = messageinvalidrecordid;
	}

	public String getMessageactionnotallowedoem() {
		return messageactionnotallowedoem;
	}

	public void setMessageactionnotallowedoem(String messageactionnotallowedoem) {
		this.messageactionnotallowedoem = messageactionnotallowedoem;
	}

	public String getMessageinvalidmobilenumber() {
		return messageinvalidmobilenumber;
	}

	public void setMessageinvalidmobilenumber(String messageinvalidmobilenumber) {
		this.messageinvalidmobilenumber = messageinvalidmobilenumber;
	}

	public String getMessageapprovalrequired() {
		return messageapprovalrequired;
	}

	public void setMessageapprovalrequired(String messageapprovalrequired) {
		this.messageapprovalrequired = messageapprovalrequired;
	}

	public String getMessagesparevalidation() {
		return messagesparevalidation;
	}

	public void setMessagesparevalidation(String messagesparevalidation) {
		this.messagesparevalidation = messagesparevalidation;
	}

	public String getMessagecostcenter() {
		return messagecostcenter;
	}

	public void setMessagecostcenter(String messagecostcenter) {
		this.messagecostcenter = messagecostcenter;
	}



}
