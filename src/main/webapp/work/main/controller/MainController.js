Ext.define('WORK.main.controller.MainController',{
	extend : 'Ext.app.Controller',
	
	
	requires: [
	    'WORK.main.config.Runtime',
	    'WORK.common.ApplicationLoader'
	],
	
	refs : [{
		ref:		'topPanel',
		selector:	'toppanel'
	},{
		ref:		'mainTabPanel',
		selector:	'maintabpanel'
	},{
		ref:		'viewPort',
		selector:	'viewport'
	}],
    //  视图通过controller进行控制，所以不需要在aplication中增加视图
	views : [
	    'Viewport',
	    'MainTabPanel',
	    'TopPanel'
	],
	//  Ext.app.Controller  本身所带的method
	init : function(){
		console.log("MainController init");
		
		var me = this;
		
		//  通过Ext.ComponentQuery在组件上添加监听器。 接受一个对象包含组件的路径映射到一个散列函数的侦听器。
		me.control({
			'viewport' : {
				boxready:	me.onViewPortReady
			},
			'toppanel': {
				openModule:  me.onOpenModule
			}
		});
	},
	
	onViewPortReady :  function(){
		console.log("MainController onViewPortReady");
	},
	
	onOpenModule: function(funUrl, funApp, funId, needAuth, funTitle, appArgs){
		console.log("MainController onOpenModule");
		var me = this;
		me.appendingLoadModule = {};	// 先开辟一个空对象保存点击菜单时的模块信息
		Ext.apply(me.appendingLoadModule, {
			funUrl:		funUrl,
			funApp:		funApp,
			funId:		funId,
			needAuth:	needAuth,
			funTitle:	funTitle,
			appArgs:    appArgs
		});

		//  有关鉴权的问题
		/*if (needAuth && !MVNOCRM.common.context.ApplicationContext.userVerifyContext.verified) {
			MVNOCRM.common.component.CustLoginView.show();
		} else {
			if(needAuth){
                MVNOCRM.common.context.ApplicationContext.userVerifyContext.authParams["backGroundFlag"] = "false";
				MVNOCRM.common.component.CustLoginView.doChkAuthPerson(MVNOCRM.common.context.ApplicationContext.userVerifyContext.authParams);
			}else{
				me.loadModule();
			}
		}*/
		
		me.loadModule();
		
	},
	
	loadModule: function() {
		var me = this,
			funApp = me.appendingLoadModule.funApp;
			args = {
				funTitle:	me.appendingLoadModule.funTitle,
				funId:		me.appendingLoadModule.id
			};
		ApplicationLoader.loadApplication(funApp, me.openSelectTab, args, me, null, null, me.appendingLoadModule.appArgs);
	},
	
	openSelectTab: function(thisArgs) {
		var me = this,
			mainContentTab = me.getMainTabPanel(),
			funTitle = null,
			funId = null,
			funView = null;

		if (thisArgs) {
			funTitle = thisArgs.funTitle;
			funId = thisArgs.funId;
			funView = thisArgs.view;
		}

		var tabId = funTitle + "_" + funView,
			tabSelected = Ext.getCmp(tabId);
			
		// 判断是否已经打开该面板
		if (!tabSelected) {
			tabSelected = mainContentTab.add({
				id:			tabId,
				title:		funTitle,
				closable:	true,
				xtype:		funView
			});
		}
		mainContentTab.setActiveTab(tabSelected);
	}
});