package com.sample.choc2.common.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.sample.choc2.common.domain.CommonUtil;
import com.sample.choc2.common.domain.Const;
import com.sample.choc2.common.domain.Log;
import com.sample.choc2.common.service.LogService;
import com.sample.choc2.service.domain.Board;
import com.sample.choc2.service.domain.CosmeticVO;
import com.sample.choc2.service.domain.Product;
import com.sample.choc2.service.domain.UserVO;

class LogAspectJ {

	@Autowired
	@Qualifier("logServiceImpl")
	private LogService logService;

	public LogAspectJ() {
		System.out.println("Constructor :: " + getClass().getName());
	}

	public Object logWrite(ProceedingJoinPoint joinPoint) throws Throwable {

		String methodName = joinPoint.getSignature().getName();

		int categoryNo = parseCategoryToInt(methodName);
		int behavior = parseBehaviorToInt(methodName);
		int addBehavior = parseAddBehaviorToInt(methodName);

		Object obj = this.invoke(joinPoint);

		if (categoryNo == Const.NONE || behavior == Const.NONE ||behavior == Const.Behavior.LIST ||addBehavior == Const.AddBehavior.REPLY) {

			System.out.println("Log :: " + methodName + " 로그를 남기지 않는 method");

		} else if (!this.checkUserLogin(joinPoint) && behavior != Const.Behavior.GET) {

			System.out.println("Log :: 비회원 로그는 남기지 않음1");

		} else {

			UserVO user = null;
			
			if (behavior == Const.Behavior.GET) {
				
				if (!this.checkUserLogin(joinPoint)) {
					
					if (joinPoint.getArgs()[0] instanceof UserVO || joinPoint.getArgs()[0] == null) {
						
						System.out.println("joinpoint........." + joinPoint.getArgs()[0]);
						
						System.out.println(1);
						
						user = new UserVO();
						user.setEmail("anonymous");
						System.out.println("Log :: 비회원 게시물 조회");

					} else {
						System.out.println("Log :: 비회원 로그는 남기지 않음2");
						return obj;
					}
				} else if (this.checkAuthorUser(categoryNo, obj, joinPoint)) {

					System.out.println("Log :: 자신이 작성한 게시물 조회는 로그를 남기지 않음");
					return obj;
				}
			}

			System.out.println("Log :: 로그를 남기는 method");
			
			Object targetNo = getTargetNo(joinPoint.getArgs()[1], obj);
			

			if (user == null) {
				user = (UserVO) joinPoint.getArgs()[0];
			}
			
			
			System.out.println("\n"+"user.." + user+"\n");
			System.out.println("categoryNo.." +categoryNo +"\n");
			System.out.println("behavior.." + behavior+"\n");
			System.out.println("addBehavior.." + addBehavior+"\n");
			System.out.println("targetNo.." + targetNo+"\n");

			this.addLogModule(user, categoryNo, behavior, addBehavior, targetNo);

		}

		return obj;
	}
	
	public boolean checkAuthorUser(int categoryNo, Object returnObject, ProceedingJoinPoint joinPoint) {
		
		System.out.println("catNo : " + categoryNo +"\n"); // 3
		System.out.println("returnObject : " + returnObject +"\n"); // Product
		System.out.println("joinPoint : " + joinPoint +"\n"); //  getProduct(UserVO , int )
		
		
		UserVO author = new UserVO();
		
		
		
		switch (categoryNo) {
		
		case Const.Category.PRODUCT:
			
			author = ((Product) returnObject).getWriter();
			break;
			
		
		case Const.Category.BOARD:
			
			author = ((Board) returnObject).getWriter();
			break;
			
		default:
			author.setEmail("");
		}
		
		
		return author.getEmail().equals(((UserVO) joinPoint.getArgs()[0]).getEmail());
	}
	
	
	
	public boolean checkUserLogin(ProceedingJoinPoint joinPoint) throws Throwable {
		
		if (joinPoint.getArgs() == null) {
			return false;
		} else if (joinPoint.getArgs()[0] instanceof UserVO) {
			if (((UserVO) joinPoint.getArgs()[0]).getEmail() != null) {
				
				return true;
				
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
	
	
	

	public Object invoke(ProceedingJoinPoint joinPoint) throws Throwable {

		System.out.println("[Around before] " + joinPoint.getTarget().getClass().getName() + "."
				+ joinPoint.getSignature().getName() + "()");

		Object obj = joinPoint.proceed();

		System.out.println("[Around after] return value : " + obj);

		return obj;

	}

	public int parseCategoryToInt(String methodName) {

		String lowerCaseMethodName = methodName.toLowerCase();

		for (int i = 1; i <= 3; i++) {
			if (lowerCaseMethodName.contains(CommonUtil.getConstProp().getProperty("S_C" + i))) {
				return i;
			}
		}

		return Const.NONE;
	}

	public int parseBehaviorToInt(String methodName) {

		String lowerCaseMethodName = methodName.toLowerCase();

		for (int i = 0; i <= 6; i++) {
			if (lowerCaseMethodName.contains(CommonUtil.getConstProp().getProperty("S_B" + i))) {

				return i;
			}
		}

		return Const.NONE;
	}

	public int parseAddBehaviorToInt(String methodName) {

		String lowerCaseMethodName = methodName.toLowerCase();

		for (int i = 1; i <= 1; i++) {
			if (lowerCaseMethodName.contains(CommonUtil.getConstProp().getProperty("S_AB" + i))) {
				return i;
			}
		}

		return Const.NONE;
	}

	public Object getTargetNo(Object target, Object returnObject) {  //joinPoint.getArgs()[1], obj

		Object targetNo = null;

		if (target instanceof CosmeticVO) {
			targetNo = ((CosmeticVO) target).getCosmeticNo();
		}
		
		if (target instanceof Product) {
			targetNo = ((Product) target).getProductNo();
		}
		
		
		System.out.println("Log :: 로그를 남길 targetNo = " + targetNo);
		return targetNo;
	}


	public void addLogModule(UserVO user, int categoryNo, int behavior, int addBehavior, Object targetNo) {
		
		Log log = new Log();
		log.setUser(user);
		log.setCategoryNo(categoryNo);
		log.setBehavior(behavior);
		log.setAddBehavior(addBehavior);
		log.setTargetNo(targetNo);

		logService.addLog(log);
	}

	public void addLogModule(UserVO user, int categoryNo, int behavior, Object targetNo) {
		
		Log log = new Log();
		log.setUser(user);
		log.setCategoryNo(categoryNo);
		log.setBehavior(behavior);
		log.setTargetNo(targetNo);

		logService.addLog(log);
	}
}
