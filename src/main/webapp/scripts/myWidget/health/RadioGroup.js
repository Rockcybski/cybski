dojo.provide("myWidget.health.RadioGroup");
dojo.require("dijit._Widget");
dojo.require("dijit._Templated");
dojo.require("dijit.form.CheckBox");

dojo.declare("myWidget.health.RadioGroup", [dijit._Widget, dijit._Templated], {
	
	templateString: dojo.cache("myWidget/health", "templates/RadioGroup.html"),
	
	onChangeCallback : null,      // 当前 Widget 的成员变量
	id: null, 
	relativeChart: null, 
	relativeChartGroup: null,
	name: "testName",           // 在定义变量时可以进行赋值
	
	constructor: function(params){//构造函数
		this.relativeChartGroup = [];
	}, 
	
	postMixInProperites: function(){
		if(this.name == null){	//在此时可以获取到变量的值
			this.name = "testName";
		}
	},
	
	postCreate: function(arguments){
		console.debug("myRatioNode==",this.myRatioNode);
	},
	
	//添加radio选项函数
	addItem: function(value,lableText,checked){
	    if(checked == null){
	       checked = false;
	    }
	    console.debug("checked==",checked);
	    console.debug("value==",value);
	    console.debug("name==",this.name);
	    
	    var self = this;
	    var radioOne = new dijit.form.RadioButton({
	                                  checked: checked,
	                                  value: value,
	                                  name: self.id,
	                                  onChange: function(checked){
	                                     if(checked){
	                                         self.onChangeCallback( this.value);
	                                     }
	                                  }
	                            });
	    this.domNode.appendChild(radioOne.domNode);
	    var label  = document.createElement("label");
	    label.innerHTML = lableText;
	    this.domNode.appendChild(label);
	 },
	 
	uninitialize: function(arguments){
		if(this.relativeChart){
			this.relativeChart.destroy();
		}
	}
	
});