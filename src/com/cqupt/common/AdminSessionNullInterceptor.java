package com.cqupt.common;

import com.cqupt.domain.Admin;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class AdminSessionNullInterceptor extends AbstractInterceptor {  
    
    /** 
     *  
     */  
    private static final long serialVersionUID = 1L;  
  
    @Override  
    public String intercept(ActionInvocation invocation) throws Exception {  
        Admin admin=(Admin) ActionContext.getContext().getSession().get("admin");  
        if(admin!=null){  
            return invocation.invoke();  
        }  
        return "sessionnull";  
    }  
  
}  
