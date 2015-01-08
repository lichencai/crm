Ext.define('WORK.main.view.MainTabPanel',{
	extend:		'Ext.tab.Panel',
	alias:		'widget.maintabpanel',
	id:			'maincontentpanel',
	activeTab:   0,
	border:		 false,
	defaults: { // defaults are applied to items, not the container
	    autoScroll: true,
	    closable: true,         //  是否允许关闭改tab页
	},
	initComponent: function() {
		var me = this;
		me.items = [{
			
			xtype: 'panel',
			title: 'Results',
		    width: 600,
		    height: 400,
		    layout: {
		        type: 'vbox',       // Arrange child items vertically
		        align: 'stretch',    // Each takes up full width
		        padding: 5
		    },
		    items: [{               // Results grid specified as a config object with an xtype of 'grid'
		        xtype: 'grid',
		        columns: [{header: 'Column One'}],            // One header just for show. There's no data,
		        store: Ext.create('Ext.data.ArrayStore', {}), // A dummy empty data store
		        flex: 1                                       // Use 1/3 of Container's height (hint to Box layout)
		    }, {
		        xtype: 'splitter'   // A splitter between the two child items
		    }, {                    // Details Panel specified as a config object (no xtype defaults to 'panel').
		        title: 'Details',
		        bodyPadding: 5,
		        items: [{
		            fieldLabel: 'Data item',
		            xtype: 'textfield'
		        }], // An array of form fields
		        flex: 2             // Use 2/3 of Container's height (hint to Box layout)
		    }]
	        
	    }, {
	        title: 'Bar',
	        tabConfig: {
	            title: 'Custom Title',
	            tooltip: 'A button tooltip'
	        }
	    }];
		me.callParent();
	}
})