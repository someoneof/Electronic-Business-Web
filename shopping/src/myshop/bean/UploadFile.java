package myshop.bean;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UploadFile implements Serializable{

	private static final long serialVersionUID = 4804199550303598018L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer fileid;
	
	@Column(length=100,nullable=false)
	private String filepath;
	
	@Column(nullable=false)
	private Date uploadtime;

	
	public UploadFile()
	{
	}

	public UploadFile(String filepath, Date uploadtime)
	{
		this.filepath = filepath;
		this.uploadtime = uploadtime;
	}

	public Integer getFileid()
	{
		return fileid;
	}

	public void setFileid(Integer fileid)
	{
		this.fileid = fileid;
	}

	public String getFilepath()
	{
		return filepath;
	}

	public void setFilepath(String filepath)
	{
		this.filepath = filepath;
	}

	public Date getUploadtime()
	{
		return uploadtime;
	}

	public void setUploadtime(Date uploadtime)
	{
		this.uploadtime = uploadtime;
	}

	public static long getSerialversionuid()
	{
		return serialVersionUID;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fileid == null) ? 0 : fileid.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UploadFile other = (UploadFile) obj;
		if (fileid == null)
		{
			if (other.fileid != null)
				return false;
		} else if (!fileid.equals(other.fileid))
			return false;
		return true;
	}

	@Override
	public String toString()
	{
		return "UploadFile [fileid=" + fileid + "]";
	}
	
	
	
}
