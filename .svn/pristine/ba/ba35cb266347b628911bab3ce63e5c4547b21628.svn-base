package com.cqupt.common;

import com.cqupt.domain.Shop;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class ShopSessionNullInterceptor extends AbstractInterceptor {  
    
    /** 
     *  
     */  
    private static final long serialVersionUID = 1L;  
  
    @Override  
    public String intercept(ActionInvocation invocation) throws Exception {  
        Shop shop=(Shop) ActionContext.getContext().getSession().get("shop");  
        if(shop!=null){  
            return invocation.invoke();  
        }  
        return "sessionnull";  
    }  
  
}  
