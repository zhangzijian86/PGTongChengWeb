package com.pg.bean;

public class Pg_order {
	private String OrderID;//订单ID
	private String Status;//订单状态(-2,删除 -1,作废 0,提交材料 1,价格反馈 2,接受订单 3,开始1 4,开始2 5,开始3 100,完成)
	private String OrderCode;//订单编码	
	private String Remark;//销售备注
	private String FlowRemark;//流程备注
	private String Price;//价格
	private String CreatedBy;//创建人
	private String CreatedDate;//创建时间
	private String ModifiedBy;//修改人
	private String ModifiedDate;//修改时间
	public String getOrderID() {
		return OrderID;
	}
	public void setOrderID(String orderID) {
		OrderID = orderID;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	public String getOrderCode() {
		return OrderCode;
	}
	public void setOrderCode(String orderCode) {
		OrderCode = orderCode;
	}
	public String getRemark() {
		return Remark;
	}
	public void setRemark(String remark) {
		Remark = remark;
	}
	public String getFlowRemark() {
		return FlowRemark;
	}
	public void setFlowRemark(String flowRemark) {
		FlowRemark = flowRemark;
	}
	public String getPrice() {
		return Price;
	}
	public void setPrice(String price) {
		Price = price;
	}
	public String getCreatedBy() {
		return CreatedBy;
	}
	public void setCreatedBy(String createdBy) {
		CreatedBy = createdBy;
	}
	public String getCreatedDate() {
		return CreatedDate;
	}
	public void setCreatedDate(String createdDate) {
		CreatedDate = createdDate;
	}
	public String getModifiedBy() {
		return ModifiedBy;
	}
	public void setModifiedBy(String modifiedBy) {
		ModifiedBy = modifiedBy;
	}
	public String getModifiedDate() {
		return ModifiedDate;
	}
	public void setModifiedDate(String modifiedDate) {
		ModifiedDate = modifiedDate;
	}
}
