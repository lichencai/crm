Ext.define('WORK.main.view.Viewport', {
	extend:		'Ext.container.Viewport',     //  继承viewport用于在页面是显示
	alias:		'widget.viewport',            //  别名      跟xtype有关
	border:	     true,
	layout:	    'border',
	
	requires:    [
	    'WORK.main.config.Runtime'
	],
	
	initComponent: function() {
		console.log("Viewport initComponent");
		
		var me = this;

		me.items = [{
			region:		'north',
			xtype:		'toppanel',
			menu: WORK.main.config.Runtime.menuData,
			margin:		'5 5 0 5'
		},{
			region:		'center',
			xtype:		'maintabpanel',
			margin:		'0 5 0 5'
		}];
		
		me.callParent();
	}
});