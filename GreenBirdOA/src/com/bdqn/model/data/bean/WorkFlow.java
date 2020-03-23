package com.bdqn.model.data.bean;

public class WorkFlow {
	public static String tablename="workflow";
	private Integer id;
	private String message;
	private User fk_user_initiator;
	private User fk_user_receiver;
	private FLowStatus fk_flowstatus;
	public WorkFlow() {
		super();
		// TODO Auto-generated constructor stub
	}
	public WorkFlow(Integer id, String message, User fk_user_initiator, User fk_user_receiver,
			FLowStatus fk_flowstatus) {
		super();
		this.id = id;
		this.message = message;
		this.fk_user_initiator = fk_user_initiator;
		this.fk_user_receiver = fk_user_receiver;
		this.fk_flowstatus = fk_flowstatus;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public User getFk_user_initiator() {
		return fk_user_initiator;
	}
	public void setFk_user_initiator(User fk_user_initiator) {
		this.fk_user_initiator = fk_user_initiator;
	}
	public User getFk_user_receiver() {
		return fk_user_receiver;
	}
	public void setFk_user_receiver(User fk_user_receiver) {
		this.fk_user_receiver = fk_user_receiver;
	}
	public FLowStatus getFk_flowstatus() {
		return fk_flowstatus;
	}
	public void setFk_flowstatus(FLowStatus fk_flowstatus) {
		this.fk_flowstatus = fk_flowstatus;
	}
	@Override
	public String toString() {
		return "WorkFlow [id=" + id + ", message=" + message + ", fk_user_initiator=" + fk_user_initiator
				+ ", fk_user_receiver=" + fk_user_receiver + ", fk_flowstatus=" + fk_flowstatus + ", hashCode()="
				+ hashCode() + "]";
	}
	
}
