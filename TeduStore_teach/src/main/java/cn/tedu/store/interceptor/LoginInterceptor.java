package cn.tedu.store.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginInterceptor implements
					     HandlerInterceptor{
	//鍦ㄦ墽琛屾帶鍒跺櫒鏂规硶涔嬪墠鎵ц
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		//1.鑾峰彇鍒皊ession瀵硅薄锛�
			//浠巗ession瀵硅薄涓彇鍑簎ser
		HttpSession session = 
				request.getSession();
		//2.Object obj == null;璇存槑娌＄櫥褰曡繃
		Object obj = session.getAttribute("user");
		if(obj==null){
			//閭ｄ箞璺宠浆鍒扮櫥褰曢〉闈紙閲嶅畾鍚戯級
			String path = 
				request.getContextPath()+
				"/user"+"/showLogin.do";
			response.sendRedirect(path);
			return false;
		}else{
		//3.鏀捐 return true;
			return true;
		}
		
	}
	//鎺у埗鏂规硶鎵ц涔嬪悗锛屼絾鏄搷搴旈〉闈箣鍓�
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		
	}
	//鐩稿簲椤甸潰涔嬪悗
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

}
