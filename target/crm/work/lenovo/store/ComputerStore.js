Ext.define('WORK.lenovo.store.ComputerStore', {
	extend  : 'Ext.data.Store',
	model   : 'WORK.lenovo.model.ComputerModel',
    autoLoad: false,
    autoSync: false,
    pageSize: 8,  
    proxy   : {
		type  : 'ajax',
		url	  :'./web/lenovo/getlist',
		reader: {
					type		 : 'json',
					totalProperty: 'total',
					root         : 'rows'
				}
    }
});