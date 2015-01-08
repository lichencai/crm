Ext.define('WORK.lenovo.AppLenovo', {
	extend:		'Ext.app.Application',
	name:		'WORK.lenovo',
	appFolder:	'./work/lenovo',
	
	autoCreateViewport:	false,
	
	controllers: [
        'LenoveController'
    ],

	views: [
	    'LenoveView'
	],
	
	config: {
		appView:	'lenovoview'
	},
	
	launch: function() {

	}	
});