Ext.define('WORK.common.ApplicationLoader', {
	
	/**
	 * 加载Application模块
	 * 
	 * @param className
	 * @param fn
	 * @param args
	 * @param scope
	 * @param moduleName
	 * @param modulePath
	 */
	loadApplication: function(className, fn, args, scope, moduleName, modulePath, appArgs){
		
		Ext.fly('maincontentpanel').mask("加载模块中...");
		
		if (typeof className != 'string') {
			throw new Error("ApplicationLoader load application error! The className is not a string.");
		} else if (className == ''){
			return ;
		}
		
		var me = this;
		
		var callback;
		
		if (fn) {
            if (fn.length > 0) {
                callback = function(args) {
                    return fn.apply(this, [args]);
                };
            }
            else {
                callback = fn;
            }
        } else {
            callback = Ext.emptyFn;
        }

        scope = scope || Ext.global;

        var app;
		var isClassCreated = Ext.ClassManager.isCreated(className);
		if(isClassCreated != true){
			
			moduleName = moduleName || '';
			modulePath = modulePath || '';
			
			if(moduleName == ''){
				moduleName = className.substring(0, className.lastIndexOf('.'));
			}
			if(modulePath == ''){
				modulePath = "./" + moduleName.replace(/\./g, "/");//全局替换
			}
			Ext.Loader.setPath(moduleName, modulePath.toLowerCase());
			Ext.require(className, function() {
	            app = Ext.create(className, appArgs);
	            
	            me.runCallback(app, callback, args, scope, appArgs);
	        });
		} else {
			app = Ext.ClassManager.get(className);
			if(app){
				this.runCallback(app.prototype, callback, args, scope, appArgs);
			}
		}

	},
	
	runCallback: function(app, callback, args, scope, appArgs) {
		if (app) {
			
			var appView = app.getAppView();
			if(appView && args){
	        	args.view = appView;
	        }
			
			args.appArgs = appArgs;
	        
	        callback.call(scope, args);
		}
		
		Ext.fly('maincontentpanel').unmask();
	}
	
	
});

var ApplicationLoader = Ext.create('WORK.common.ApplicationLoader');
