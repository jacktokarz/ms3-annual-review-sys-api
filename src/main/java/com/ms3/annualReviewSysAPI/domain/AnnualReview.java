package com.ms3.annualReviewSysAPI.domain;

import java.util.Date;


/**
 * 
 * @author ZTej
 *
 */
public class AnnualReview {
	private int annual_review_id;
	private int employee_id;
	private int supervisor_id;
	private double self_assessment_avg;
	private double mgr_assessment_avg;
	private Date completed_dt;
	private String status;
	private Date start_dt;
	
	public AnnualReview(){
		
	}
	/**
	 * 
	 * @param annual_review_id
	 * @param employee_id
	 * @param supervisor_id
	 * @param self_assessment_avg
	 * @param mgr_assessment_avg
	 * @param completed_dt
	 * @param status
	 * @param start_dt
	 */
	public AnnualReview(int annual_review_id, int employee_id, int supervisor_id, double self_assessment_avg,
			double mgr_assessment_avg, Date completed_dt, String status, Date start_dt) {
		super();
		this.annual_review_id = annual_review_id;
		this.employee_id = employee_id;
		this.supervisor_id=supervisor_id;
		this.self_assessment_avg = self_assessment_avg;
		this.mgr_assessment_avg = mgr_assessment_avg;
		this.completed_dt = completed_dt;
		this.status = status;
		this.start_dt=start_dt;
	}
	/**
	 * @return the annual_review_id
	 */
	public int getAnnual_review_id() {
		return annual_review_id;
	}
	/**
	 * @param annual_review_id the annual_review_id to set
	 */
	public void setAnnual_review_id(int annual_review_id) {
		this.annual_review_id = annual_review_id;
	}
	/**
	 * @return the employee_id
	 */
	public int getEmployee_id() {
		return employee_id;
	}
	/**
	 * @param employee_id the employee_id to set
	 */
	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}
	/**
	 * @return the supervisor_id
	 */
	public int getSupervisor_id() {
		return supervisor_id;
	}
	/**
	 * @param supervisor_id the supervisor_id to set
	 */
	public void setSupervisor_id(int supervisor_id) {
		this.supervisor_id = supervisor_id;
	}
	/**
	 * @return the self_assessment_avg
	 */
	public double getSelf_assessment_avg() {
		return self_assessment_avg;
	}
	/**
	 * @param self_assessment_avg the self_assessment_avg to set
	 */
	public void setSelf_assessment_avg(double self_assessment_avg) {
		this.self_assessment_avg = self_assessment_avg;
	}
	/**
	 * @return the mgr_assessment_avg
	 */
	public double getMgr_assessment_avg() {
		return mgr_assessment_avg;
	}
	/**
	 * @param mgr_assessment_avg the mgr_assessment_avg to set
	 */
	public void setMgr_assessment_avg(double mgr_assessment_avg) {
		this.mgr_assessment_avg = mgr_assessment_avg;
	}
	/**
	 * @return the completed_dt
	 */
	public Date getCompleted_dt() {
		return completed_dt;
	}
	/**
	 * @param completed_dt the completed_dt to set
	 */
	public void setCompleted_dt(Date completed_dt) {
		this.completed_dt = completed_dt;
	}
	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * @return the start_dt
	 */
	public Date getStart_dt() {
		return start_dt;
	}
	/**
	 * @param start_dt the start_dt to set
	 */
	public void setStart_dt(Date start_dt) {
		this.start_dt = start_dt;
	}
	
}
