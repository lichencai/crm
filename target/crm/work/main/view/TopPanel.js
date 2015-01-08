Ext.define('WORK.main.view.TopPanel',{
	extend:		'Ext.container.ButtonGroup',
	alias:		'widget.toppanel',
	initComponent: function() {
		var me = this;
		var objs = me.menu;  //  从调用其的xtype那边配置过来的信息
		me.addEvents('openModule');
		
		//  callParent要放到前面，因为下面要用到父类的方法，否则会报错
		me.callParent();
		
		for (var i=0, size=objs.length; i<size; i++) {	// 添加按钮
			var menus = objs[i].menus,
				name = objs[i].name,
				menu = Ext.create('Ext.menu.Menu');
			for (var j=0, jsize=menus.length; j<jsize; j++) {
				menu.add({
					text:		menus[j].text,
					funId:		menus[j].id,
					funUrl:		menus[j].funUrl,
					funApp:		menus[j].funApp,
					leaf:		menus[j].leaf,
					needAuth:	menus[j].needAuth,
					handler: function(item) {
						me.fireEvent('openModule', item.funUrl, item.funApp, item.funId, item.needAuth, item.text);
					}
				});
			}
			me.add({
				text: name,
				menu: menu
			});
		}
	}
});