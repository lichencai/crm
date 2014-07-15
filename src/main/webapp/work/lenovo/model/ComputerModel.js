Ext.define('WORK.lenovo.model.ComputerModel', {
    extend: 'Ext.data.Model',
    fields: [
        {name: 'logId',  		type: 'string'},    //日志标识
        {name: 'monTime',     	type: 'string',
        	convert:function(v,rec){                //监控时间
        		if (v)  {
        			      return Ext.util.Format.date(new Date(parseInt(v)), 'Y-m-d H:i:s');
        				}
        	}
        
        }, 
        {name: 'monObject', 	type: 'string'},   //监控对象
        {name: 'monType',   	type: 'string'},   //监控类型
        {name: 'recCount',    	type: 'string'}    //记录数             
    ]
});