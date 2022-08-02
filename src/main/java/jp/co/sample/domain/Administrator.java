package jp.co.sample.domain;

/**
 * @author matsudachiho
 *管理者情報を表すドメインです。
 */
public class Administrator {

	private Integer id;
	private String name;
	private String mailAddress;
	private String pasword;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMailAddress() {
		return mailAddress;
	}
	public void setMailAddress(String mailAddress) {
		this.mailAddress = mailAddress;
	}
	public String getPasword() {
		return pasword;
	}
	public void setPasword(String pasword) {
		this.pasword = pasword;
	}
	@Override
	public String toString() {
		return "Administrator [id=" + id + ", name=" + name + ", mailAddress=" + mailAddress + ", pasword=" + pasword
				+ "]";
	}
	
	
	
	
	
	
	
	
}
