package cn.lijuntao.boot.entity;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;

import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;

/**
 * 护理诊断
 */
@Document(indexName = "myboot", type="diagnosis")
public class Diagnosis implements Serializable{

    private static final long serialVersionUID = 1L;
    @Id
	private Long id;
    @Field
    private String code;
    @Field
    private String name;
    @Field
    private String nameEn;
    @Field
    private String type;
    @Field
    private String definition;
    @Field
    private String remark;
    @Field
    private String createUser;
    @Field
    private Date createTime;
    
	public Long getId() {
    	return id;
	}
    
    public void setId(Long id) {
		this.id = id;
	}
    
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameEn() {
        return nameEn;
    }

    public void setNameEn(String nameEn) {
        this.nameEn = nameEn;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    @Column(name = "REMARK", nullable = true, length = 1000)
    public String getRemark() {
        return remark;
    }
    
    public void setRemark(String remark) {
        this.remark = remark;
    }
    
	public String getCreateUser() {
		return createUser;
	}
    
	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}
	
	public Date getCreateTime() {
		return createTime;
	}
	
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Diagnosis [id=");
		builder.append(id);
		builder.append(", code=");
		builder.append(code);
		builder.append(", name=");
		builder.append(name);
		builder.append(", nameEn=");
		builder.append(nameEn);
		builder.append(", type=");
		builder.append(type);
		builder.append(", definition=");
		builder.append(definition);
		builder.append(", remark=");
		builder.append(remark);
		builder.append(", createUser=");
		builder.append(createUser);
		builder.append(", createTime=");
		builder.append(createTime);
		builder.append("]");
		return builder.toString();
	}
    
}
