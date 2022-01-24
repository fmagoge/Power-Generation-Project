package com.fmagoge.powergeneration.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "plant")
public class Plant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    private String SEQGEN19;
    
    private String YEAR;
    
    private String PSTATABB;
    
    private String PNAME;
    
    private String GENID;
    
    private String GENSTAT;
    
    private String GENNTAN;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getSEQGEN19() {
		return SEQGEN19;
	}

	public void setSEQGEN19(String sEQGEN19) {
		SEQGEN19 = sEQGEN19;
	}

	public String getYEAR() {
		return YEAR;
	}

	public void setYEAR(String yEAR) {
		YEAR = yEAR;
	}

	public String getPSTATABB() {
		return PSTATABB;
	}

	public void setPSTATABB(String pSTATABB) {
		PSTATABB = pSTATABB;
	}

	public String getPNAME() {
		return PNAME;
	}

	public void setPNAME(String pNAME) {
		PNAME = pNAME;
	}

	public String getGENID() {
		return GENID;
	}

	public void setGENID(String gENID) {
		GENID = gENID;
	}

	public String getGENSTAT() {
		return GENSTAT;
	}

	public void setGENSTAT(String gENSTAT) {
		GENSTAT = gENSTAT;
	}

	public String getGENNTAN() {
		return GENNTAN;
	}

	public void setGENNTAN(String gENNTAN) {
		GENNTAN = gENNTAN;
	}
    
}
