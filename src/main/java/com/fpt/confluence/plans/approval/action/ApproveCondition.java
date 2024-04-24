//package com.fpt.confluence.plans.approval.action;
//
//import com.atlassian.confluence.core.ContentEntityObject;
//import com.atlassian.confluence.pages.PageManager;
//import com.atlassian.confluence.security.PermissionManager;
//import com.atlassian.confluence.user.AuthenticatedUserThreadLocal;
//import com.atlassian.confluence.user.UserAccessor;
//import com.atlassian.plugin.PluginParseException;
//import com.atlassian.plugin.web.Condition;
//import com.atlassian.sal.api.user.UserManager;
//
//import java.util.Map;
//import com.atlassian.confluence.plugin.descriptor.web.WebInterfaceContext;
//import com.atlassian.confluence.plugin.descriptor.web.conditions.BaseConfluenceCondition;
//import com.atlassian.plugin.PluginParseException;
//import com.atlassian.sal.api.user.UserManager;
//
//public class ApproveCondition extends BaseConfluenceCondition {
//	private String group;
//	private UserManager userManager;
//
//	public ApproveCondition(UserManager userManager) {
//		this.userManager = userManager;
//	}
//
//	@Override
//
//	public void init(Map params) throws PluginParseException {
//
//	this.group=(String)params.get("group");
//
//	super.init(params);
//
//	}
//	
//	@Override
//	public boolean shouldDisplay(WebInterfaceContext context) {
//		if(userManager.getRemoteUserKey()!=null && this.group!=null){
//				return userManager.isUserInGroup(userManager.getRemoteUserKey(), this.group);
//		}
//		return false;
//	}
//}
