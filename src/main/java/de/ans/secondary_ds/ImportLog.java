package de.ans.secondary_ds;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the IMPORT_LOG database table.
 * 
 */
@Entity
@Table(name="IMPORT_LOG")
@NamedQuery(name="ImportLog.findAll", query="SELECT i FROM ImportLog i")
public class ImportLog implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id @GeneratedValue
	@Column(name="Tabelle")
	private String tabelle;

	@Column(name="TimeSt")
	private Timestamp timeSt;

	public ImportLog() {
	}

	public String getTabelle() {
		return this.tabelle;
	}

	public void setTabelle(String tabelle) {
		this.tabelle = tabelle;
	}

	public Timestamp getTimeSt() {
		return this.timeSt;
	}

	public void setTimeSt(Timestamp timeSt) {
		this.timeSt = timeSt;
	}

}