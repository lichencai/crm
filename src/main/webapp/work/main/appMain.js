//  设置路径命名空间, 不然会找不到该文件
Ext.Loader.setPath('WORK.common','./work/common');

Ext.application({
	name : 'WORK.main',
	appFolder : './work/main',
	//  值为true，在触发launch函数之前自动加载并实例化AppName.view。Viewport对象
	autoCreateViewport: true,
	controllers: [
	    'MainController'
	],
	launch: function() {
		console.log("appMain launch");
	}
});