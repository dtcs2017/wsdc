package com.cqupt.common;

import com.cqupt.domain.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class SessionNullInterceptor extends AbstractInterceptor {  
    
    /** 
     *  
     */  
    private static final long serialVersionUID = 1L;  
  
    @Override  
    public String intercept(ActionInvocation invocation) throws Exception {  
        User u=(User) ActionContext.getContext().getSession().get("user");  
        if(u!=null){  
            return invocation.invoke();  
        }  
        return "sessionnull";  
    }  
  
}  
