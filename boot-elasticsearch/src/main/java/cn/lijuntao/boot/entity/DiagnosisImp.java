package cn.lijuntao.boot.entity;

import java.io.Serializable;

public class DiagnosisImp implements Serializable{
	
	private static final long serialVersionUID = 2378102068812178726L;

	private Diagnosis diagnosis;
	
	private DiagnosisOtherData otherData;

	public Diagnosis getDiagnosis() {
		return diagnosis;
	}

	public void setDiagnosis(Diagnosis diagnosis) {
		this.diagnosis = diagnosis;
	}

	public DiagnosisOtherData getOtherData() {
		return otherData;
	}

	public void setOtherData(DiagnosisOtherData otherData) {
		this.otherData = otherData;
	}
	
}

