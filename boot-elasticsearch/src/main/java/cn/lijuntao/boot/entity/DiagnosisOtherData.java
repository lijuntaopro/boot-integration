package cn.lijuntao.boot.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Table(name="DIAGNOSIS_OTHER_DATA")
@Entity
public class DiagnosisOtherData implements Serializable{
	
	private static final long serialVersionUID = -8117390560142305165L;
	
	private Long diagnosisId;
	
	private String basis;
	
	private String element;
	
	private String target;
	
	private String measure;
	
	@Id
	public Long getDiagnosisId() {
		return diagnosisId;
	}
	
	public void setDiagnosisId(Long diagnosisId) {
		this.diagnosisId = diagnosisId;
	}
	
	@Column(name="BASIS", length=4000)
	public String getBasis() {
		return basis;
	}

	public void setBasis(String basis) {
		this.basis = basis;
	}

	@Column(name="ELEMENT", columnDefinition="CLOB")
	public String getElement() {
		return element;
	}

	public void setElement(String element) {
		this.element = element;
	}

	@Column(name="TARGET", length=4000)
	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	@Column(name="MEASURE", columnDefinition="CLOB")
	public String getMeasure() {
		return measure;
	}

	public void setMeasure(String measure) {
		this.measure = measure;
	}
	
}
