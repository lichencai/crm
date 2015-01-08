Ext.define('WORK.lenovo.controller.LenoveController', {
    extend: 'Ext.app.Controller',
    refs: [{
    	ref	 : 'lenovoview',
        selector: 'lenovoview'
    }],
    models: [
        'ComputerModel'
    ],
    stores: [
        'ComputerStore'
    ],
    init: function() {
    	var me = this;
    	this.control({
    		'lenovoview' : {
    			boxready:	me.onViewPortReady
    		}
    	});
    },
    onViewPortReady : function(){
    	this.getComputerStoreStore().loadPage(1);
    }
});