package com.sample.choc2.common.domain;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import com.sample.choc2.service.domain.UserVO;

public class Log {
	
	private UserVO user;
	private String logRegDate;
	private String logTimeAgo;
	private String targetName;
	private int categoryNo;
	private Object targetNo;
	private int behavior;
	private int addBehavior;


	public Log() {}
	


	public UserVO getUser() {
		return user;
	}

	public void setUser(UserVO user) {
		this.user = user;
	}



	public String getLogRegDate() {
		return logRegDate;
	}

	public void setLogRegDate(String logRegDate) throws Exception {
		this.logRegDate = logRegDate;
		setLogTimeAgo(logRegDate);
	}

	public String getLogTimeAgo() {
		return logTimeAgo;
	}

	private void setLogTimeAgo(String logRegDate) throws Exception {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+0900"));
		Date logDate = simpleDateFormat.parse(logRegDate);
		Calendar now = Calendar.getInstance(TimeZone.getTimeZone("GMT+0900"));
		long diff = now.getTimeInMillis() - logDate.getTime();
		StringBuffer timeAgo = new StringBuffer("약 ");
		if(diff / (1000 * 60 * 60 * 24 * 365) > 0) {
			timeAgo.append(diff / (1000 * 60 * 60 * 24 * 365))
					.append("년 ");
		}else if(diff / (1000 * 60 * 60 * 24 * 30) > 0) {
			timeAgo.append(diff / (1000 * 60 * 60 * 24))
					.append("달 ");
		}else if(diff / (1000 * 60 * 60 * 24) > 0) {
			timeAgo.append(diff / (1000 * 60 * 60 * 24))
					.append("일 ");
		}else if(diff / (1000 * 60 * 60) > 0) {
			timeAgo.append(diff / (1000 * 60 * 60))
					.append("시간 ");
		}else if(diff / (1000 * 60) > 0) {
			timeAgo.append(diff / (1000 * 60))
					.append("분 ");
		}else {
			timeAgo = new StringBuffer("방금 ");
		}
		timeAgo.append("전");
		this.logTimeAgo = timeAgo.toString();
	}


	public String getTargetName() {
		return targetName;
	}

	public void setTargetName(String targetName) {
		this.targetName = targetName;
	}
	
	public int getCategoryNo() {
		return categoryNo;
	}

	public void setCategoryNo(int categoryNo) {
		this.categoryNo = categoryNo;
	}

	public Object getTargetNo() {
		return targetNo;
	}

	public void setTargetNo(Object targetNo) {
		this.targetNo = targetNo;
	}

	public int getBehavior() {
		return behavior;
	}

	public void setBehavior(int behavior) {
		this.behavior = behavior;
	}

	public int getAddBehavior() {
		return addBehavior;
	}

	public void setAddBehavior(int addBehavior) {
		this.addBehavior = addBehavior;
	}
	
	public String getLink() {
		StringBuffer link = new StringBuffer();
		link.append("../");
		switch (this.categoryNo) {
			case Const.Category.BOARD:
				link.append(" 상대경로 path 줘야함..");
				break;
				
			case Const.Category.COSMETIC:
				link.append("상대경로 path 줘야함..");
				break;
				
		}
		link.append(this.targetNo);
		return link.toString();
	}

	public String getLogString() {
		try {
			StringBuffer log = new StringBuffer();
			log.append(CommonUtil.getConstProp().getProperty("C"+categoryNo)+" ")
				.append("'")
				.append(targetName+"'을(를) ");
				if(addBehavior != 0) {
					log.append(CommonUtil.getConstProp().getProperty("AB"+addBehavior)+"을(를) ");
				}
				log.append(CommonUtil.getConstProp().getProperty("B"+behavior)+"하였습니다.");
	
			return log.toString();
		}catch(Exception e) {
			return "Log [user=" + user + ", logRegDate=" + logRegDate + ", targetName=" + targetName + ", categoryNo="
					+ categoryNo + ", targetNo=" + targetNo + ", behavior=" + behavior + ", addBehavior=" + addBehavior
					+ "]";
		}
	}


	@Override
	public String toString() {
		try {
			StringBuffer log = new StringBuffer();
			log.append(CommonUtil.getConstProp().getProperty("C"+categoryNo)+" ")
				.append("'")
				.append(targetName+"'을(를) ");
			if(addBehavior != 0) {
				log.append(CommonUtil.getConstProp().getProperty("AB"+addBehavior)+"을(를) ");
			}
			log.append(CommonUtil.getConstProp().getProperty("B"+behavior)+"하였습니다.");
	
			return log.toString();
		}catch(Exception e) {
			return "Log [user=" + user + ", logRegDate=" + logRegDate + ", targetName=" + targetName + ", categoryNo="
					+ categoryNo + ", targetNo=" + targetNo + ", behavior=" + behavior + ", addBehavior=" + addBehavior
					+ "]";
		}
	}

	
}
