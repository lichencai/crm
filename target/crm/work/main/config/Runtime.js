Ext.define('WORK.main.config.Runtime', {
	singleton:	true,
    operator : 0,
    
    menuData: [{
		name:		"手机",
		menus: [{
			"id":		1,
			"text":		"三星",
			"funUrl":	"/openaccount",
			"funApp":	"MVNOCRM.openaccount.AppOpenAccount",
			"leaf":		true,
			"needAuth":	false
		}]
	}, {
		name:		"电脑",
		menus: [{
			"id":		1,
			"text":		"联想",
			"funUrl":	"/lenovo",
			"funApp":	"WORK.lenovo.AppLenovo",
			"leaf":		true,
			"needAuth":	false
		}, {
			"id":		2,
			"text":		"惠普",
			"funUrl":	"/pay",
			"funApp":	"MVNOCRM.pay.AppPay",
			"leaf":		true,
			"needAuth":	true
		}]
	}]
});