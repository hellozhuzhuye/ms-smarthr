(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-0ecaa49e"],{"5a4a":function(e,t,a){"use strict";a.r(t);var i=function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",[a("div",[a("el-input",{staticStyle:{width:"350px","margin-right":"10px"},attrs:{placeholder:"请输入员工名进行搜索，可以直接回车搜索...","prefix-icon":"el-icon-search",clearable:""},on:{clear:e.initAdjustSalary},nativeOn:{keydown:function(t){return!t.type.indexOf("key")&&e._k(t.keyCode,"enter",13,t.key,"Enter")?null:e.initAdjustSalary(t)}},model:{value:e.ename,callback:function(t){e.ename=t},expression:"ename"}}),a("el-button",{attrs:{icon:"el-icon-search",type:"primary"},on:{click:e.initAdjustSalary}},[e._v("\n      搜索\n    ")]),a("el-date-picker",{staticStyle:{"margin-left":"20px"},attrs:{type:"daterange",size:"mini","unlink-panels":"","value-format":"yyyy-MM-dd","range-separator":"至","start-placeholder":"开始日期","end-placeholder":"结束日期"},model:{value:e.beginDateScope,callback:function(t){e.beginDateScope=t},expression:"beginDateScope"}})],1),a("div",{staticStyle:{"margin-top":"10px"}},[a("el-table",{staticStyle:{width:"100%"},attrs:{data:e.logData,stripe:"",border:"","element-loading-text":"正在加载...","element-loading-spinner":"el-icon-loading","element-loading-background":"rgba(0, 0, 0, 0.8)"}},[a("el-table-column",{attrs:{prop:"id",label:"序号",align:"left",width:"60"}}),a("el-table-column",{attrs:{prop:"ename",align:"left",label:"姓名",width:"100"}}),a("el-table-column",{attrs:{prop:"beforeSalary",width:"120",align:"left",label:"调前薪资倍数"}}),a("el-table-column",{attrs:{prop:"afterSalary",width:"200",align:"left",label:"调后薪资倍数"}}),a("el-table-column",{attrs:{prop:"reason",width:"200",align:"left",label:"调薪原因"}}),a("el-table-column",{attrs:{prop:"asDate",width:"200",align:"left",label:"调薪日期"}}),a("el-table-column",{attrs:{prop:"remark",width:"200",align:"left",label:"备注"}})],1),a("div",{staticStyle:{display:"flex","justify-content":"flex-end"}},[a("el-pagination",{attrs:{background:"",layout:"sizes, prev, pager, next, jumper, ->, total, slot",total:e.total},on:{"current-change":e.currentChange,"size-change":e.sizeChange}})],1)],1)])},l=[],n={name:"PerSalary",data:function(){return{logData:[],ename:"",page:1,size:10,total:0,beginDateScope:null}},methods:{sizeChange:function(e){this.size=e,this.initAdjustSalary()},currentChange:function(e){this.page=e,this.initAdjustSalary()},initAdjustSalary:function(){var e=this,t="/personnel/salary/?pageNum="+this.page+"&pageSize="+this.size;this.ename&&(t+="&ename="+this.ename),this.beginDateScope&&(t+="&startTime="+this.beginDateScope[0]+" 00:00:00",t+="&endTime="+this.beginDateScope[1]+" 23:59:59"),this.getRequest(t).then((function(t){t&&(e.logData=t.obj.list,e.total=t.obj.total)}))}},mounted:function(){this.initAdjustSalary()}},o=n,s=a("5d22"),r=Object(s["a"])(o,i,l,!1,null,"431c42ba",null);t["default"]=r.exports},"7fe5":function(e,t,a){"use strict";a.r(t);var i=function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",[a("div",{staticStyle:{"margin-top":"20px"}},[a("el-input",{staticStyle:{width:"350px","margin-right":"10px"},attrs:{placeholder:"请输入员工名进行搜索，可以直接回车搜索...","prefix-icon":"el-icon-search",clearable:""},on:{clear:e.initEmpEval},nativeOn:{keydown:function(t){return!t.type.indexOf("key")&&e._k(t.keyCode,"enter",13,t.key,"Enter")?null:e.initEmpEval(t)}},model:{value:e.outname,callback:function(t){e.outname=t},expression:"outname"}}),a("el-button",{attrs:{icon:"el-icon-search",type:"primary"},on:{click:e.initEmpEval}},[e._v("\n      搜索\n    ")]),a("el-button",{attrs:{icon:"el-icon-plus",type:"primary"},on:{click:function(t){e.dialogVisible=!0}}},[e._v("\n      添加考评记录\n    ")])],1),a("div",{staticStyle:{"margin-top":"10px"}},[a("el-table",{directives:[{name:"loading",rawName:"v-loading",value:e.outloading,expression:"outloading"}],staticStyle:{width:"80%"},attrs:{data:e.empEval,border:"","element-loading-text":"正在加载...","element-loading-spinner":"el-icon-loading","element-loading-background":"rgba(0, 0, 0, 0.8)",size:"small"}},[a("el-table-column",{attrs:{type:"selection",width:"55"}}),a("el-table-column",{attrs:{prop:"id",label:"编号",width:"55"}}),a("el-table-column",{attrs:{prop:"workID",label:"工号",width:"120"}}),a("el-table-column",{attrs:{prop:"name",label:"姓名",width:"120"}}),a("el-table-column",{attrs:{prop:"content",label:"考评内容",width:"240"}}),a("el-table-column",{attrs:{label:"考评结果"},scopedSlots:e._u([{key:"default",fn:function(t){return[1===t.row.result?a("el-tag",{attrs:{size:"small",type:"success"}},[e._v("通过")]):a("el-tag",{attrs:{size:"small",type:"danger"}},[e._v("未通过")])]}}])}),a("el-table-column",{attrs:{prop:"date",label:"考评日期",width:"150"}}),a("el-table-column",{attrs:{prop:"remark",label:"备注",width:"200"}}),a("el-table-column",{attrs:{label:"操作"},scopedSlots:e._u([{key:"default",fn:function(t){return[a("el-button",{attrs:{size:"small"},on:{click:function(a){return e.showEditView(t.row)}}},[e._v("编辑")]),a("el-button",{attrs:{size:"small",type:"danger"},on:{click:function(a){return e.deleteHandler(t.row)}}},[e._v("删除")])]}}])})],1),a("div",{staticStyle:{display:"flex","justify-content":"flex-start","margin-top":"10px"}},[a("el-pagination",{attrs:{background:"",layout:"sizes, prev, pager, next, jumper, ->, total, slot",total:e.outtotal},on:{"current-change":e.outcurrentChange,"size-change":e.outsizeChange}})],1)],1),a("el-dialog",{attrs:{title:"添加员工考评记录",visible:e.dialogVisible,width:"30%"},on:{"update:visible":function(t){e.dialogVisible=t}}},[a("el-input",{staticStyle:{width:"300px","margin-top":"10px"},attrs:{placeholder:"请选择员工"},model:{value:e.empSelection.name,callback:function(t){e.$set(e.empSelection,"name",t)},expression:"empSelection.name"}},[a("el-button",{attrs:{slot:"prepend",icon:"el-icon-search"},on:{click:e.getAllEmps},slot:"prepend"})],1),a("el-input",{staticStyle:{"margin-top":"10px"},attrs:{type:"textarea",rows:2,autosize:"",placeholder:"请输入考评内容"},model:{value:e.textarea,callback:function(t){e.textarea=t},expression:"textarea"}}),a("div",{staticStyle:{"margin-top":"10px"}},[a("el-select",{attrs:{placeholder:"请选择考评结果"},model:{value:e.addEmpEval.result,callback:function(t){e.$set(e.addEmpEval,"result",t)},expression:"addEmpEval.result"}},[a("el-option",{attrs:{label:"通过",value:"1"}}),a("el-option",{attrs:{label:"未通过",value:"0"}})],1)],1),a("el-date-picker",{staticStyle:{"margin-top":"10px"},attrs:{align:"right",type:"date",placeholder:"请选择考评日期","picker-options":e.pickerOptions},model:{value:e.pickDate,callback:function(t){e.pickDate=t},expression:"pickDate"}}),a("el-input",{staticStyle:{"margin-top":"10px"},attrs:{placeholder:"请输入备注内容"},model:{value:e.remark,callback:function(t){e.remark=t},expression:"remark"}},[a("template",{slot:"prepend"},[e._v("备注")])],2),a("span",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[a("el-button",{on:{click:e.addDialogCancel}},[e._v("取 消")]),a("el-button",{attrs:{type:"primary"},on:{click:e.addDialogOk}},[e._v("确 定")])],1)],1),a("el-dialog",{attrs:{title:"修改员工考评记录",visible:e.editdialogVisible,width:"30%"},on:{"update:visible":function(t){e.editdialogVisible=t}}},[a("el-input",{staticStyle:{width:"300px","margin-top":"10px"},attrs:{placeholder:"请选择员工"},model:{value:e.updateEval.name,callback:function(t){e.$set(e.updateEval,"name",t)},expression:"updateEval.name"}},[a("el-button",{attrs:{slot:"prepend",icon:"el-icon-search"},on:{click:e.getAllEmps},slot:"prepend"})],1),a("el-input",{staticStyle:{"margin-top":"10px"},attrs:{type:"textarea",rows:2,autosize:"",placeholder:"请输入考评内容"},model:{value:e.updateEval.content,callback:function(t){e.$set(e.updateEval,"content",t)},expression:"updateEval.content"}}),a("div",{staticStyle:{"margin-top":"10px"}},[a("el-select",{attrs:{placeholder:"请选择考评结果"},model:{value:e.updateEval.result,callback:function(t){e.$set(e.updateEval,"result",t)},expression:"updateEval.result"}},[a("el-option",{attrs:{label:"通过",value:"1"}}),a("el-option",{attrs:{label:"未通过",value:"0"}})],1)],1),a("el-date-picker",{staticStyle:{"margin-top":"10px"},attrs:{align:"right",type:"date",placeholder:"请选择考评日期","picker-options":e.pickerOptions},model:{value:e.updateEval.date,callback:function(t){e.$set(e.updateEval,"date",t)},expression:"updateEval.date"}}),a("el-input",{staticStyle:{"margin-top":"10px"},attrs:{placeholder:"请输入备注内容"},model:{value:e.updateEval.remark,callback:function(t){e.$set(e.updateEval,"remark",t)},expression:"updateEval.remark"}},[a("template",{slot:"prepend"},[e._v("备注")])],2),a("span",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[a("el-button",{on:{click:e.updateDialogCancel}},[e._v("取 消")]),a("el-button",{attrs:{type:"primary"},on:{click:e.updateDialogOk}},[e._v("确 定")])],1)],1),a("el-dialog",{attrs:{title:"选择员工",visible:e.selectEmpsVisible,width:"40%"},on:{"update:visible":function(t){e.selectEmpsVisible=t}}},[a("div",[a("el-input",{staticStyle:{width:"350px","margin-right":"10px"},attrs:{placeholder:"请输入员工名进行搜索，可以直接回车搜索...","prefix-icon":"el-icon-search",clearable:""},on:{clear:e.getAllEmps},nativeOn:{keydown:function(t){return!t.type.indexOf("key")&&e._k(t.keyCode,"enter",13,t.key,"Enter")?null:e.getAllEmps(t)}},model:{value:e.name,callback:function(t){e.name=t},expression:"name"}}),a("el-button",{attrs:{icon:"el-icon-search",type:"primary"},on:{click:e.getAllEmps}},[e._v("\n            搜索\n          ")])],1),a("el-table",{directives:[{name:"loading",rawName:"v-loading",value:e.loading,expression:"loading"}],staticStyle:{width:"80%","margin-top":"10px"},attrs:{data:e.emps,"highlight-current-row":"",border:"","element-loading-text":"正在加载...","element-loading-spinner":"el-icon-loading","element-loading-background":"rgba(0, 0, 0, 0.8)",size:"small"},on:{"current-change":e.handleEmpSelectionChange}},[a("el-table-column",{attrs:{prop:"id",label:"编号",width:"75"}}),a("el-table-column",{attrs:{prop:"workID",label:"工号",width:"200"}}),a("el-table-column",{attrs:{prop:"name",label:"姓名",width:"147"}}),a("el-table-column",{attrs:{prop:"department.name",label:"部门",width:"147"}})],1),a("div",{staticStyle:{display:"flex","justify-content":"flex-end","margin-top":"10px"}},[a("el-pagination",{attrs:{background:"",layout:"sizes, prev, pager, next, jumper, ->, total, slot",total:e.total},on:{"current-change":e.currentChange,"size-change":e.sizeChange}})],1),a("span",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[a("el-button",{on:{click:function(t){e.selectEmpsVisible=!1}}},[e._v("取 消")]),a("el-button",{attrs:{type:"primary"},on:{click:e.selectEmp}},[e._v("确 定")])],1)],1)],1)},l=[],n=(a("a450"),{name:"PerEval",data:function(){return{outname:"",name:"",empEval:[],loading:!1,outloading:!1,page:1,size:10,total:0,outpage:1,outsize:10,outtotal:0,dialogVisible:!1,editdialogVisible:!1,selectEmpsVisible:!1,updateselectEmpsVisible:!1,emps:[],empSelection:{},textarea:"",remark:"",pickDate:"",multipleSelection:[],updateEval:{id:"",eid:"",date:"",content:"",result:"",remark:""},addEmpEval:{eid:"",date:"",content:"",result:"",remark:""},pickerOptions:{disabledDate:function(e){return e.getTime()>Date.now()},shortcuts:[{text:"今天",onClick:function(e){e.$emit("pick",new Date)}},{text:"昨天",onClick:function(e){var t=new Date;t.setTime(t.getTime()-864e5),e.$emit("pick",t)}},{text:"一周前",onClick:function(e){var t=new Date;t.setTime(t.getTime()-6048e5),e.$emit("pick",t)}}]}}},mounted:function(){this.initEmpEval()},methods:{doAddEmpEval:function(){var e=this;this.empSelection.id&&this.textarea&&this.pickDate?(this.addEmpEval.eid=this.empSelection.id,this.addEmpEval.content=this.textarea,this.addEmpEval.date=this.pickDate,this.addEmpEval.remark=this.remark,this.postRequest("/personnel/eval/",this.addEmpEval).then((function(t){t&&(e.initEmpEval(),e.addEmpEval={eid:"",date:"",content:"",result:"",remark:""},e.dialogVisible=!1)}))):this.$message.error("字段不能为空")},doUpdateEmpEval:function(){var e=this;console.log("dobefore:"+this.updateEval.result),"通过"==this.updateEval.result||"1"==this.updateEval.result?this.updateEval.result="1":this.updateEval.result="0",console.log("do:"+this.updateEval.result),this.updateEval.id&&this.updateEval.eid&&this.updateEval.content&&this.updateEval.date?this.putRequest("/personnel/eval/",this.updateEval).then((function(t){t&&(e.initEmpEval(),e.updateEval={id:"",eid:"",date:"",content:"",result:"",remark:""},e.editdialogVisible=!1)})):this.$message.error("更新字段不能为空")},addDialogOk:function(){this.doAddEmpEval(),this.dialogCloseHandle()},addDialogCancel:function(){this.dialogCloseHandle(),this.dialogVisible=!1},updateDialogOk:function(){this.doUpdateEmpEval(),this.updateEval={id:"",eid:"",date:"",content:"",result:"",remark:""},this.editdialogVisible=!1},updateDialogCancel:function(){this.dialogCloseHandle(),this.updateEval={id:"",eid:"",trainDate:"",trainContent:"",remark:""},this.editdialogVisible=!1},dialogCloseHandle:function(){this.empSelection={},this.textarea="",this.remark="",this.pickDate="",this.addEmpEval.result=""},showEditView:function(e){Object.assign(this.updateEval,e),"1"==this.updateEval.result?this.updateEval.result="通过":this.updateEval.result="未通过",console.log("show:"+this.updateEval.result),this.editdialogVisible=!0},deleteHandler:function(e){var t=this;this.$confirm("此操作将永久删除此条考评记录, 是否继续?","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then((function(){t.deleteRequest("/personnel/eval/"+e.id).then((function(e){e&&t.initEmpEval()}))})).catch((function(){t.$message({type:"info",message:"已取消删除"})}))},handleEmpSelectionChange:function(e){console.log(e),this.empSelection=e,this.updateEval.name=e.name,this.updateEval.eid=e.id},selectEmp:function(){this.selectEmpsVisible=!1},getAllEmps:function(){var e=this;this.selectEmpsVisible=!0;var t="/employee/basic/?page="+this.page+"&size="+this.size;this.name&&(t+="&name="+this.name),this.getRequest(t).then((function(t){e.loading=!1,t&&(console.log(t.data),e.emps=t.data,e.total=t.total)}))},sizeChange:function(e){this.size=e,this.getAllEmps()},currentChange:function(e){this.page=e,this.getAllEmps()},outsizeChange:function(e){this.outsize=e,this.initEmpEval()},outcurrentChange:function(e){this.outpage=e,this.initEmpEval()},initEmpEval:function(){var e=this;this.outloading=!0;var t="/personnel/eval/?page="+this.outpage+"&size="+this.outsize;this.outname&&(t+="&name="+this.outname),this.getRequest(t).then((function(t){e.outloading=!1,t&&(e.empEval=t.list,e.total=t.total)}))}}}),o=n,s=a("5d22"),r=Object(s["a"])(o,i,l,!1,null,"4f529740",null);t["default"]=r.exports},"83ed":function(e,t,a){"use strict";a.r(t);var i=function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",[a("div",{staticStyle:{"margin-top":"20px"}},[a("el-input",{staticStyle:{width:"350px","margin-right":"10px"},attrs:{placeholder:"请输入员工名进行搜索，可以直接回车搜索...","prefix-icon":"el-icon-search",clearable:""},on:{clear:e.initEmpTrain},nativeOn:{keydown:function(t){return!t.type.indexOf("key")&&e._k(t.keyCode,"enter",13,t.key,"Enter")?null:e.initEmpTrain(t)}},model:{value:e.outname,callback:function(t){e.outname=t},expression:"outname"}}),a("el-button",{attrs:{icon:"el-icon-search",type:"primary"},on:{click:e.initEmpTrain}},[e._v("\n      搜索\n    ")]),a("el-button",{attrs:{icon:"el-icon-plus",type:"primary"},on:{click:function(t){e.dialogVisible=!0}}},[e._v("\n      添加培训记录\n    ")])],1),a("div",{staticStyle:{"margin-top":"10px"}},[a("el-table",{directives:[{name:"loading",rawName:"v-loading",value:e.outloading,expression:"outloading"}],staticStyle:{width:"80%"},attrs:{data:e.empTrain,border:"","element-loading-text":"正在加载...","element-loading-spinner":"el-icon-loading","element-loading-background":"rgba(0, 0, 0, 0.8)",size:"small"}},[a("el-table-column",{attrs:{type:"selection",width:"55"}}),a("el-table-column",{attrs:{prop:"id",label:"编号",width:"55"}}),a("el-table-column",{attrs:{prop:"workID",label:"工号",width:"120"}}),a("el-table-column",{attrs:{prop:"name",label:"姓名",width:"120"}}),a("el-table-column",{attrs:{prop:"trainContent",label:"培训内容",width:"440"}}),a("el-table-column",{attrs:{prop:"trainDate",label:"培训日期",width:"150"}}),a("el-table-column",{attrs:{prop:"remark",label:"备注",width:"200"}}),a("el-table-column",{attrs:{label:"操作"},scopedSlots:e._u([{key:"default",fn:function(t){return[a("el-button",{attrs:{size:"small"},on:{click:function(a){return e.showEditView(t.row)}}},[e._v("编辑")]),a("el-button",{attrs:{size:"small",type:"danger"},on:{click:function(a){return e.deleteHandler(t.row)}}},[e._v("删除")])]}}])})],1),a("div",{staticStyle:{display:"flex","justify-content":"flex-start","margin-top":"10px"}},[a("el-pagination",{attrs:{background:"",layout:"sizes, prev, pager, next, jumper, ->, total, slot",total:e.outtotal},on:{"current-change":e.outcurrentChange,"size-change":e.outsizeChange}})],1)],1),a("el-dialog",{attrs:{title:"添加员工培训记录",visible:e.dialogVisible,width:"30%"},on:{"update:visible":function(t){e.dialogVisible=t}}},[a("el-input",{staticStyle:{width:"300px","margin-top":"10px"},attrs:{placeholder:"请选择员工"},model:{value:e.empSelection.name,callback:function(t){e.$set(e.empSelection,"name",t)},expression:"empSelection.name"}},[a("el-button",{attrs:{slot:"prepend",icon:"el-icon-search"},on:{click:e.getAllEmps},slot:"prepend"})],1),a("el-input",{staticStyle:{"margin-top":"10px"},attrs:{type:"textarea",rows:2,autosize:"",placeholder:"请输入培训内容"},model:{value:e.textarea,callback:function(t){e.textarea=t},expression:"textarea"}}),a("el-date-picker",{staticStyle:{"margin-top":"10px"},attrs:{align:"right",type:"date",placeholder:"请选择培训日期","picker-options":e.pickerOptions},model:{value:e.pickDate,callback:function(t){e.pickDate=t},expression:"pickDate"}}),a("el-input",{staticStyle:{"margin-top":"10px"},attrs:{placeholder:"请输入备注内容"},model:{value:e.remark,callback:function(t){e.remark=t},expression:"remark"}},[a("template",{slot:"prepend"},[e._v("备注")])],2),a("span",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[a("el-button",{on:{click:e.addDialogCancel}},[e._v("取 消")]),a("el-button",{attrs:{type:"primary"},on:{click:e.addDialogOk}},[e._v("确 定")])],1)],1),a("el-dialog",{attrs:{title:"修改员工培训记录",visible:e.editdialogVisible,width:"30%"},on:{"update:visible":function(t){e.editdialogVisible=t}}},[a("el-input",{staticStyle:{width:"300px","margin-top":"10px"},attrs:{placeholder:"请选择员工"},model:{value:e.updateTrain.name,callback:function(t){e.$set(e.updateTrain,"name",t)},expression:"updateTrain.name"}},[a("el-button",{attrs:{slot:"prepend",icon:"el-icon-search"},on:{click:e.getAllEmps},slot:"prepend"})],1),a("el-input",{staticStyle:{"margin-top":"10px"},attrs:{type:"textarea",rows:2,autosize:"",placeholder:"请输入培训内容"},model:{value:e.updateTrain.trainContent,callback:function(t){e.$set(e.updateTrain,"trainContent",t)},expression:"updateTrain.trainContent"}}),a("el-date-picker",{staticStyle:{"margin-top":"10px"},attrs:{align:"right",type:"date",placeholder:"请选择培训日期","picker-options":e.pickerOptions},model:{value:e.updateTrain.trainDate,callback:function(t){e.$set(e.updateTrain,"trainDate",t)},expression:"updateTrain.trainDate"}}),a("el-input",{staticStyle:{"margin-top":"10px"},attrs:{placeholder:"请输入备注内容"},model:{value:e.updateTrain.remark,callback:function(t){e.$set(e.updateTrain,"remark",t)},expression:"updateTrain.remark"}},[a("template",{slot:"prepend"},[e._v("备注")])],2),a("span",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[a("el-button",{on:{click:e.updateDialogCancel}},[e._v("取 消")]),a("el-button",{attrs:{type:"primary"},on:{click:e.updateDialogOk}},[e._v("确 定")])],1)],1),a("el-dialog",{attrs:{title:"选择员工",visible:e.selectEmpsVisible,width:"40%"},on:{"update:visible":function(t){e.selectEmpsVisible=t}}},[a("div",[a("el-input",{staticStyle:{width:"350px","margin-right":"10px"},attrs:{placeholder:"请输入员工名进行搜索，可以直接回车搜索...","prefix-icon":"el-icon-search",clearable:""},on:{clear:e.getAllEmps},nativeOn:{keydown:function(t){return!t.type.indexOf("key")&&e._k(t.keyCode,"enter",13,t.key,"Enter")?null:e.getAllEmps(t)}},model:{value:e.name,callback:function(t){e.name=t},expression:"name"}}),a("el-button",{attrs:{icon:"el-icon-search",type:"primary"},on:{click:e.getAllEmps}},[e._v("\n        搜索\n      ")])],1),a("el-table",{directives:[{name:"loading",rawName:"v-loading",value:e.loading,expression:"loading"}],staticStyle:{width:"80%","margin-top":"10px"},attrs:{data:e.emps,"highlight-current-row":"",border:"","element-loading-text":"正在加载...","element-loading-spinner":"el-icon-loading","element-loading-background":"rgba(0, 0, 0, 0.8)",size:"small"},on:{"current-change":e.handleEmpSelectionChange}},[a("el-table-column",{attrs:{prop:"id",label:"编号",width:"75"}}),a("el-table-column",{attrs:{prop:"workID",label:"工号",width:"200"}}),a("el-table-column",{attrs:{prop:"name",label:"姓名",width:"147"}}),a("el-table-column",{attrs:{prop:"department.name",label:"部门",width:"147"}})],1),a("div",{staticStyle:{display:"flex","justify-content":"flex-end","margin-top":"10px"}},[a("el-pagination",{attrs:{background:"",layout:"sizes, prev, pager, next, jumper, ->, total, slot",total:e.total},on:{"current-change":e.currentChange,"size-change":e.sizeChange}})],1),a("span",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[a("el-button",{on:{click:function(t){e.selectEmpsVisible=!1}}},[e._v("取 消")]),a("el-button",{attrs:{type:"primary"},on:{click:e.selectEmp}},[e._v("确 定")])],1)],1)],1)},l=[],n=(a("a450"),{name:"PerTrain",data:function(){return{outname:"",name:"",empTrain:[],loading:!1,outloading:!1,page:1,size:10,total:0,outpage:1,outsize:10,outtotal:0,dialogVisible:!1,editdialogVisible:!1,selectEmpsVisible:!1,updateselectEmpsVisible:!1,emps:[],empSelection:{},textarea:"",remark:"",pickDate:"",multipleSelection:[],updateTrain:{id:"",eid:"",trainDate:"",trainContent:"",remark:""},addEmpTrain:{eid:"",trainDate:"",trainContent:"",remark:""},pickerOptions:{disabledDate:function(e){return e.getTime()>Date.now()},shortcuts:[{text:"今天",onClick:function(e){e.$emit("pick",new Date)}},{text:"昨天",onClick:function(e){var t=new Date;t.setTime(t.getTime()-864e5),e.$emit("pick",t)}},{text:"一周前",onClick:function(e){var t=new Date;t.setTime(t.getTime()-6048e5),e.$emit("pick",t)}}]}}},mounted:function(){this.initEmpTrain()},methods:{doAddEmpTrain:function(){var e=this;this.empSelection.id&&this.textarea&&this.pickDate?(this.addEmpTrain.eid=this.empSelection.id,this.addEmpTrain.trainContent=this.textarea,this.addEmpTrain.trainDate=this.pickDate,this.addEmpTrain.remark=this.remark,this.postRequest("/personnel/train/",this.addEmpTrain).then((function(t){t&&(e.initEmpTrain(),e.addEmpTrain={eid:"",trainDate:"",trainContent:"",remark:""},e.dialogVisible=!1)}))):this.$message.error("字段不能为空")},doUpdateEmpTrain:function(){var e=this;this.updateTrain.id&&this.updateTrain.eid&&this.updateTrain.trainContent&&this.updateTrain.trainDate?this.putRequest("/personnel/train/",this.updateTrain).then((function(t){t&&(e.initEmpTrain(),e.updateTrain={id:"",eid:"",trainDate:"",trainContent:"",remark:""},e.editdialogVisible=!1)})):this.$message.error("更新字段不能为空")},addDialogOk:function(){this.doAddEmpTrain(),this.dialogCloseHandle()},addDialogCancel:function(){this.dialogCloseHandle(),this.dialogVisible=!1},updateDialogOk:function(){this.doUpdateEmpTrain(),this.updateTrain={id:"",eid:"",trainDate:"",trainContent:"",remark:""},this.editdialogVisible=!1},updateDialogCancel:function(){this.dialogCloseHandle(),this.updateTrain={id:"",eid:"",trainDate:"",trainContent:"",remark:""},this.editdialogVisible=!1},dialogCloseHandle:function(){this.empSelection={},this.textarea="",this.remark="",this.pickDate=""},showEditView:function(e){Object.assign(this.updateTrain,e),this.editdialogVisible=!0},deleteHandler:function(e){var t=this;this.$confirm("此操作将永久删除此条培训记录, 是否继续?","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then((function(){t.deleteRequest("/personnel/train/"+e.id).then((function(e){e&&t.initEmpTrain()}))})).catch((function(){t.$message({type:"info",message:"已取消删除"})}))},handleEmpSelectionChange:function(e){console.log(e),this.empSelection=e,this.updateTrain.name=e.name,this.updateTrain.eid=e.id},selectEmp:function(){this.selectEmpsVisible=!1},getAllEmps:function(){var e=this;this.selectEmpsVisible=!0;var t="/employee/basic/?page="+this.page+"&size="+this.size;this.name&&(t+="&name="+this.name),this.getRequest(t).then((function(t){e.loading=!1,t&&(console.log(t.data),e.emps=t.data,e.total=t.total)}))},sizeChange:function(e){this.size=e,this.getAllEmps()},currentChange:function(e){this.page=e,this.getAllEmps()},outsizeChange:function(e){this.outsize=e,this.initEmpTrain()},outcurrentChange:function(e){this.outpage=e,this.initEmpTrain()},initEmpTrain:function(){var e=this;this.outloading=!0;var t="/personnel/train/?page="+this.outpage+"&size="+this.outsize;this.outname&&(t+="&name="+this.outname),this.getRequest(t).then((function(t){e.outloading=!1,t&&(e.empTrain=t.list,e.total=t.total)}))}}}),o=n,s=a("5d22"),r=Object(s["a"])(o,i,l,!1,null,"42446cc8",null);t["default"]=r.exports},cfbb:function(e,t,a){"use strict";a.r(t);var i=function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",[a("div",{staticStyle:{"margin-top":"20px"}},[a("el-input",{staticStyle:{width:"350px","margin-right":"10px"},attrs:{placeholder:"请输入员工名进行搜索，可以直接回车搜索...","prefix-icon":"el-icon-search",clearable:""},on:{clear:e.initEmpRemove},nativeOn:{keydown:function(t){return!t.type.indexOf("key")&&e._k(t.keyCode,"enter",13,t.key,"Enter")?null:e.initEmpRemove(t)}},model:{value:e.name,callback:function(t){e.name=t},expression:"name"}}),a("el-button",{attrs:{icon:"el-icon-search",type:"primary"},on:{click:e.initEmpRemove}},[e._v("\n      搜索\n    ")])],1),a("div",{staticStyle:{"margin-top":"10px"}},[a("el-table",{directives:[{name:"loading",rawName:"v-loading",value:e.loading,expression:"loading"}],staticStyle:{width:"80%"},attrs:{data:e.empRemove,border:"","element-loading-text":"正在加载...","element-loading-spinner":"el-icon-loading","element-loading-background":"rgba(0, 0, 0, 0.8)",size:"small"}},[a("el-table-column",{attrs:{type:"selection",width:"55"}}),a("el-table-column",{attrs:{prop:"id",label:"编号",width:"55"}}),a("el-table-column",{attrs:{prop:"workID",label:"工号",width:"120"}}),a("el-table-column",{attrs:{prop:"ename",label:"姓名",width:"120"}}),a("el-table-column",{attrs:{prop:"dbeforename",label:"调动前部门",width:"120"}}),a("el-table-column",{attrs:{prop:"pbeforename",label:"调动前职位",width:"120"}}),a("el-table-column",{attrs:{prop:"daftername",label:"调动后部门",width:"120"}}),a("el-table-column",{attrs:{prop:"paftername",label:"调动后部门",width:"120"}}),a("el-table-column",{attrs:{prop:"reason",label:"调动原因",width:"150"}}),a("el-table-column",{attrs:{prop:"removeDate",label:"调动时间",width:"120"}}),a("el-table-column",{attrs:{prop:"remark",label:"备注",width:"140"}}),a("el-table-column",{attrs:{label:"操作",width:"100"},scopedSlots:e._u([{key:"default",fn:function(t){return[a("el-button",{attrs:{size:"small"},on:{click:function(a){return e.showEditView(t.row)}}},[e._v("编辑")])]}}])})],1),a("div",{staticStyle:{display:"flex","justify-content":"flex-start","margin-top":"10px"}},[a("el-pagination",{attrs:{background:"",layout:"sizes, prev, pager, next, jumper, ->, total, slot",total:e.total},on:{"current-change":e.currentChange,"size-change":e.sizeChange}})],1)],1),a("el-dialog",{attrs:{title:"修改员工调动记录备注及原因",visible:e.editdialogVisible,width:"30%"},on:{"update:visible":function(t){e.editdialogVisible=t}}},[a("el-input",{staticStyle:{"margin-top":"10px"},attrs:{type:"textarea",rows:2,autosize:"",placeholder:"请输入调动原因"},model:{value:e.updateRemove.reason,callback:function(t){e.$set(e.updateRemove,"reason",t)},expression:"updateRemove.reason"}}),a("el-input",{staticStyle:{"margin-top":"10px"},attrs:{placeholder:"请输入备注内容"},model:{value:e.updateRemove.remark,callback:function(t){e.$set(e.updateRemove,"remark",t)},expression:"updateRemove.remark"}},[a("template",{slot:"prepend"},[e._v("备注")])],2),a("span",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[a("el-button",{on:{click:e.updateDialogCancel}},[e._v("取 消")]),a("el-button",{attrs:{type:"primary"},on:{click:e.updateDialogOk}},[e._v("确 定")])],1)],1)],1)},l=[],n=(a("a450"),{name:"PerMv",data:function(){return{name:"",empRemove:[],loading:!1,page:1,size:10,total:0,updateRemove:{reason:"",remark:""},editdialogVisible:!1}},mounted:function(){this.initEmpRemove()},methods:{updateDialogOk:function(){this.doUpdateEmpRemove(),this.updateTrain={},this.editdialogVisible=!1},updateDialogCancel:function(){this.updateTrain={},this.editdialogVisible=!1},showEditView:function(e){Object.assign(this.updateRemove,e),this.editdialogVisible=!0},doUpdateEmpRemove:function(){var e=this;this.putRequest("/personnel/remove/",this.updateRemove).then((function(t){t&&(e.initEmpRemove(),e.updateRemove={reason:"",remark:""},e.editdialogVisible=!1)}))},sizeChange:function(e){this.size=e,this.initEmpRemove()},currentChange:function(e){this.page=e,this.initEmpRemove()},initEmpRemove:function(){var e=this;this.loading=!0;var t="/personnel/remove/?page="+this.page+"&size="+this.size;this.name&&(t+="&name="+this.name),this.getRequest(t).then((function(t){e.loading=!1,t&&(e.empRemove=t.list,e.total=t.total)}))}}}),o=n,s=a("5d22"),r=Object(s["a"])(o,i,l,!1,null,"186a2860",null);t["default"]=r.exports},d9ac:function(e,t,a){"use strict";a.r(t);var i=function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",[a("div",[a("el-input",{staticStyle:{width:"300px"},attrs:{placeholder:"请选择奖惩规则"},model:{value:e.empEcRuleMultipleSelection.ecReason,callback:function(t){e.$set(e.empEcRuleMultipleSelection,"ecReason",t)},expression:"empEcRuleMultipleSelection.ecReason"}},[a("el-button",{attrs:{slot:"prepend",icon:"el-icon-search"},on:{click:e.getAllEcRules},slot:"prepend"})],1),a("el-input",{staticStyle:{width:"300px"},attrs:{placeholder:"请选择员工"},model:{value:e.empSelection.name,callback:function(t){e.$set(e.empSelection,"name",t)},expression:"empSelection.name"}},[a("el-button",{attrs:{slot:"prepend",icon:"el-icon-search"},on:{click:e.getAllEmps},slot:"prepend"})],1),a("el-input",{staticStyle:{width:"300px"},attrs:{size:"small","prefix-icon":"el-icon-plus",placeholder:"请输入备注"},model:{value:e.addEmpEc.remark,callback:function(t){e.$set(e.addEmpEc,"remark",t)},expression:"addEmpEc.remark"}}),a("el-button",{attrs:{icon:"el-icon-plus",type:"primary",size:"small"},on:{click:e.doAddEmpEc}},[e._v("添加奖惩记录")]),a("div",{staticStyle:{"margin-top":"20px"}},[a("el-input",{staticStyle:{width:"350px","margin-right":"10px"},attrs:{placeholder:"请输入员工名进行搜索，可以直接回车搜索...","prefix-icon":"el-icon-search",clearable:""},on:{clear:e.initEmpEcs},nativeOn:{keydown:function(t){return!t.type.indexOf("key")&&e._k(t.keyCode,"enter",13,t.key,"Enter")?null:e.initEmpEcs(t)}},model:{value:e.name,callback:function(t){e.name=t},expression:"name"}}),a("el-button",{attrs:{icon:"el-icon-search",type:"primary"},on:{click:e.initEmpEcs}},[e._v("\n      搜索\n    ")])],1)],1),a("div",{staticStyle:{"margin-top":"10px"}},[a("el-table",{directives:[{name:"loading",rawName:"v-loading",value:e.loading,expression:"loading"}],staticStyle:{width:"80%"},attrs:{data:e.EmpEcs,border:"","element-loading-text":"正在加载...","element-loading-spinner":"el-icon-loading","element-loading-background":"rgba(0, 0, 0, 0.8)",size:"small"},on:{"selection-change":e.handleSelectionChange}},[a("el-table-column",{attrs:{type:"selection",width:"55"}}),a("el-table-column",{attrs:{prop:"id",label:"编号",width:"55"}}),a("el-table-column",{attrs:{prop:"workID",label:"工号",width:"100"}}),a("el-table-column",{attrs:{prop:"name",label:"姓名",width:"100"}}),a("el-table-column",{attrs:{label:"奖惩类型",width:"100"},scopedSlots:e._u([{key:"default",fn:function(t){return[0===t.row.ecType?a("el-tag",{attrs:{type:"success"}},[e._v("奖励")]):a("el-tag",{attrs:{type:"danger"}},[e._v("惩罚")])]}}])}),a("el-table-column",{attrs:{prop:"ecPoint",label:"奖惩积分",width:"100"}}),a("el-table-column",{attrs:{prop:"ecReason",label:"奖惩原因",width:"150"}}),a("el-table-column",{attrs:{prop:"beforePoint",label:"奖惩前积分",width:"100"}}),a("el-table-column",{attrs:{prop:"afterPoint",label:"奖惩后积分",width:"100"}}),a("el-table-column",{attrs:{prop:"ecDate",label:"奖惩日期",width:"150"}}),a("el-table-column",{attrs:{prop:"remark",label:"备注",width:"200"}}),a("el-table-column",{attrs:{label:"操作",width:"200"},scopedSlots:e._u([{key:"default",fn:function(t){return[a("el-button",{attrs:{size:"small",type:"danger"},on:{click:function(a){return e.deleteHandler(t.row)}}},[e._v("删除")])]}}])})],1),a("el-button",{staticStyle:{"margin-top":"10px"},attrs:{type:"danger",size:"small",disabled:0==e.multipleSelection.length},on:{click:e.deleteMany}},[e._v("批量删除\n    ")])],1),a("el-dialog",{attrs:{title:"选择奖惩规则",visible:e.selectRulesVisible,width:"30%"},on:{"update:visible":function(t){e.selectRulesVisible=t}}},[a("el-table",{directives:[{name:"loading",rawName:"v-loading",value:e.loading,expression:"loading"}],staticStyle:{width:"80%"},attrs:{data:e.rules,"highlight-current-row":"",border:"","element-loading-text":"正在加载...","element-loading-spinner":"el-icon-loading","element-loading-background":"rgba(0, 0, 0, 0.8)",size:"small"},on:{"current-change":e.handleEmpRuleSelectionChange}},[a("el-table-column",{attrs:{prop:"id",label:"编号",width:"55"}}),a("el-table-column",{attrs:{label:"奖惩类型",width:"150"},scopedSlots:e._u([{key:"default",fn:function(t){return[0===t.row.ecType?a("el-tag",{attrs:{type:"success"}},[e._v("奖励")]):a("el-tag",{attrs:{type:"danger"}},[e._v("惩罚")])]}}])}),a("el-table-column",{attrs:{prop:"ecPoint",label:"奖惩积分"}}),a("el-table-column",{attrs:{prop:"ecReason",label:"奖惩原因"}})],1),a("span",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[a("el-button",{on:{click:function(t){e.selectRulesVisible=!1}}},[e._v("取 消")]),a("el-button",{attrs:{type:"primary"},on:{click:e.selectEmpEc}},[e._v("确 定")])],1)],1),a("el-dialog",{attrs:{title:"选择员工",visible:e.selectEmpsVisible,width:"40%"},on:{"update:visible":function(t){e.selectEmpsVisible=t}}},[a("div",[a("el-input",{staticStyle:{width:"350px","margin-right":"10px"},attrs:{placeholder:"请输入员工名进行搜索，可以直接回车搜索...","prefix-icon":"el-icon-search",clearable:""},on:{clear:e.getAllEmps},nativeOn:{keydown:function(t){return!t.type.indexOf("key")&&e._k(t.keyCode,"enter",13,t.key,"Enter")?null:e.getAllEmps(t)}},model:{value:e.keyword,callback:function(t){e.keyword=t},expression:"keyword"}}),a("el-button",{attrs:{icon:"el-icon-search",type:"primary"},on:{click:e.getAllEmps}},[e._v("\n        搜索\n      ")])],1),a("el-table",{directives:[{name:"loading",rawName:"v-loading",value:e.loading,expression:"loading"}],staticStyle:{width:"80%","margin-top":"10px"},attrs:{data:e.emps,"highlight-current-row":"",border:"","element-loading-text":"正在加载...","element-loading-spinner":"el-icon-loading","element-loading-background":"rgba(0, 0, 0, 0.8)",size:"small"},on:{"current-change":e.handleEmpSelectionChange}},[a("el-table-column",{attrs:{prop:"id",label:"编号",width:"75"}}),a("el-table-column",{attrs:{prop:"workID",label:"工号",width:"200"}}),a("el-table-column",{attrs:{prop:"name",label:"姓名",width:"147"}}),a("el-table-column",{attrs:{prop:"department.name",label:"部门",width:"147"}})],1),a("div",{staticStyle:{display:"flex","justify-content":"flex-end","margin-top":"10px"}},[a("el-pagination",{attrs:{background:"",layout:"sizes, prev, pager, next, jumper, ->, total, slot",total:e.total},on:{"current-change":e.currentChange,"size-change":e.sizeChange}})],1),a("span",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[a("el-button",{on:{click:function(t){e.selectEmpsVisible=!1}}},[e._v("取 消")]),a("el-button",{attrs:{type:"primary"},on:{click:e.selectEmp}},[e._v("确 定")])],1)],1)],1)},l=[],n=(a("a450"),a("1bc7"),{name:"PerEc",data:function(){return{name:"",selectRulesVisible:!1,addEmpEc:{eid:"",ecid:"",remark:""},loading:!1,multipleSelection:[],empEcRuleMultipleSelection:{},empSelection:{},updateRule:{ecType:"",ecReason:"",ecPoint:0},page:1,size:10,keyword:"",emps:[],total:0,rules:[],selectEmpsVisible:!1,ecRule:{ecType:"",ecReason:"",ecPoint:""},EmpEcs:[],ecTypes:[{value:"0",label:"奖励"},{value:"1",label:"惩罚"}]}},mounted:function(){this.initEmpEcs()},methods:{currentChange:function(e){console.log(e),this.page=e,this.getAllEmps()},sizeChange:function(e){this.size=e,this.getAllEmps()},selectEmpEc:function(){this.selectRulesVisible=!1},selectEmp:function(){this.selectEmpsVisible=!1},getAllEmps:function(){var e=this;this.selectEmpsVisible=!0;var t="/employee/basic/?page="+this.page+"&size="+this.size;this.keyword&&(t+="&name="+this.keyword),this.getRequest(t).then((function(t){e.loading=!1,t&&(console.log(t.data),e.emps=t.data,e.total=t.total)}))},getAllEcRules:function(){var e=this;this.selectRulesVisible=!0,this.getRequest("/system/basic/ecrule/").then((function(t){e.loading=!1,t&&(e.rules=t,e.ecRule={ecType:"",ecReason:"",ecPoint:""})}))},deleteMany:function(){var e=this;this.$confirm("此操作将永久删除【"+this.multipleSelection.length+"】条记录, 是否继续?","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then((function(){var t="?";e.multipleSelection.forEach((function(e){t+="ids="+e.id+"&"})),e.deleteRequest("/system/basic/ecrule/"+t).then((function(t){t&&e.initEmpEcs()}))})).catch((function(){e.$message({type:"info",message:"已取消删除"})}))},updateCancel:function(){this.dialogVisible=!1,this.value=""},doUpdate:function(){},handleEmpSelectionChange:function(e){this.empSelection=e},handleEmpRuleSelectionChange:function(e){this.empEcRuleMultipleSelection=e},handleSelectionChange:function(e){this.multipleSelection=e},deleteHandler:function(e){var t=this;this.$confirm("此操作将永久删除此奖惩记录, 是否继续?","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then((function(){t.deleteRequest("/personnel/ec/"+e.id).then((function(e){e&&t.initEmpEcs()}))})).catch((function(){t.$message({type:"info",message:"已取消删除"})}))},doAddEmpEc:function(){var e=this;this.empSelection.id&&this.empEcRuleMultipleSelection.id?(this.addEmpEc.eid=this.empSelection.id,this.addEmpEc.ecid=this.empEcRuleMultipleSelection.id,this.postRequest("/personnel/ec/",this.addEmpEc).then((function(t){t&&(e.initEmpEcs(),e.addEmpEc.remark="")}))):this.$message.error("字段不能为空")},initEmpEcs:function(){var e=this;this.loading=!0;var t="/personnel/ec/";this.name&&(t+="?name="+this.name),this.getRequest(t).then((function(t){e.loading=!1,t&&(e.EmpEcs=t,e.ecRule={ecType:"",ecReason:"",ecPoint:""})}))}}}),o=n,s=a("5d22"),r=Object(s["a"])(o,i,l,!1,null,"5b43cf70",null);t["default"]=r.exports}}]);
//# sourceMappingURL=chunk-0ecaa49e.24ee2239.js.map