(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-e10cf8ac"],{"03eb":function(t,e,i){t.exports=i.p+"img/chuchai.e09a026d.jpg"},"1b5a":function(t,e,i){t.exports=i.p+"img/lizhi.40a4ff00.jpg"},"1e9b":function(t,e,i){t.exports=i.p+"img/qingjia.f8753fad.jpg"},3730:function(t,e,i){"use strict";i.r(e);var l=function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("div",[i("div",{staticStyle:{"margin-top":"10px"}},[i("el-table",{directives:[{name:"loading",rawName:"v-loading",value:t.loading,expression:"loading"}],staticStyle:{width:"80%"},attrs:{data:t.myApplys,border:"","element-loading-text":"正在加载...","element-loading-spinner":"el-icon-loading","element-loading-background":"rgba(0, 0, 0, 0.8)",size:"small"},on:{"selection-change":t.handleSelectionChange}},[i("el-table-column",{attrs:{type:"selection",width:"55"}}),i("el-table-column",{attrs:{prop:"id",label:"编号",width:"55"}}),i("el-table-column",{attrs:{prop:"applyTypeName",label:"申请类型",width:"100"}}),i("el-table-column",{attrs:{prop:"content",label:"申请内容",width:"200"}}),i("el-table-column",{attrs:{prop:"hrNames",label:"审核人",width:"200"}}),i("el-table-column",{attrs:{prop:"createTime",label:"申请时间",width:"200"}}),i("el-table-column",{attrs:{label:"操作"},scopedSlots:t._u([{key:"default",fn:function(e){return[i("el-button",{attrs:{type:"primary",size:"small"},on:{click:function(i){return t.showDetailView(e.row)}}},[t._v("详细")]),i("el-button",{attrs:{size:"small",type:"danger"},on:{click:function(i){return t.deleteHandler(e.row)}}},[t._v("删除")])]}}])})],1)],1),i("el-dialog",{attrs:{title:"申请详情",visible:t.dialogVisible,width:"60%"},on:{"update:visible":function(e){t.dialogVisible=e}}},[i("el-table",{directives:[{name:"loading",rawName:"v-loading",value:t.loading,expression:"loading"}],staticStyle:{width:"80%"},attrs:{data:t.detailApply,border:"","element-loading-text":"正在加载...","element-loading-spinner":"el-icon-loading","element-loading-background":"rgba(0, 0, 0, 0.8)",size:"small"},on:{"selection-change":t.handleSelectionChange}},[i("el-table-column",{attrs:{type:"selection",width:"55"}}),i("el-table-column",{attrs:{prop:"id",label:"编号",width:"55"}}),i("el-table-column",{attrs:{prop:"hrName",label:"审核人",width:"100"}}),i("el-table-column",{attrs:{label:"审核状态",width:"200"},scopedSlots:t._u([{key:"default",fn:function(e){return[0===e.row.status?i("el-tag",[t._v("未审核")]):1===e.row.status?i("el-tag",{attrs:{type:"success"}},[t._v("批准")]):2===e.row.status?i("el-tag",{attrs:{type:"danger"}},[t._v("未批准")]):t._e()]}}])}),i("el-table-column",{attrs:{prop:"content",label:"附注",width:"200"}}),i("el-table-column",{attrs:{prop:"approveTime",label:"审核时间",width:"200"}})],1),i("span",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[i("el-button",{attrs:{size:"small"},on:{click:t.updateCancel}},[t._v("取 消")]),i("el-button",{attrs:{size:"small",type:"primary"},on:{click:t.doUpdate}},[t._v("确 定")])],1)],1)],1)},a=[],s=(i("1bc7"),{name:"WorkFlowMy",data:function(){return{myApplys:[],dialogVisible:!1,loading:!1,multipleSelection:[],wfid:0,detailApply:[],ecRule:{ecType:"",ecReason:"",ecPoint:""},rules:[],ecTypes:[{value:"0",label:"奖励"},{value:"1",label:"惩罚"}],value:""}},mounted:function(){this.initMyApplys()},methods:{deleteMany:function(){var t=this;this.$confirm("此操作将永久删除【"+this.multipleSelection.length+"】条记录, 是否继续?","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then((function(){var e="?";t.multipleSelection.forEach((function(t){e+="ids="+t.id+"&"})),t.deleteRequest("/system/basic/ecrule/"+e).then((function(e){e&&t.initMyApplys()}))})).catch((function(){t.$message({type:"info",message:"已取消删除"})}))},updateCancel:function(){this.dialogVisible=!1,this.value=""},doUpdate:function(){var t=this;this.updateRule.ecType=this.value,0==this.updateRule.ecType&&parseInt(this.updateRule.ecPoint)>0||1==this.updateRule.ecType&&parseInt(this.updateRule.ecPoint)<0?this.putRequest("/system/basic/ecrule/",this.updateRule).then((function(e){e&&(t.initMyApplys(),t.dialogVisible=!1)})):this.$message.error("奖励的积分必须为正数,惩罚的积分必须为负数，请重试")},handleSelectionChange:function(t){this.multipleSelection=t},showDetailView:function(t){var e=this;Object.assign(this.wfid,t.id),this.getRequest("/workflow/detail/"+t.id).then((function(t){t&&(e.detailApply=t,console.log("detailApply:"+e.detailApply))})),this.dialogVisible=!0},deleteHandler:function(t){var e=this;this.$confirm("此操作将永久删除【"+t.ecReason+"】奖惩规则, 是否继续?","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then((function(){e.deleteRequest("/system/basic/ecrule/"+t.id).then((function(t){t&&e.initMyApplys()}))})).catch((function(){e.$message({type:"info",message:"已取消删除"})}))},addEcRule:function(){var t=this;this.ecRule.ecType&&this.ecRule.ecPoint&&this.ecRule.ecReason?(console.log(this.ecRule.ecType),"奖励"==this.ecRule.ecType&&this.ecRule.ecPoint>0||"惩罚"==this.ecRule.ecType&&this.ecRule.ecPoint<0?("奖励"==this.ecRule.ecType?this.ecRule.ecType=0:this.ecRule.ecType=1,this.postRequest("/system/basic/ecrule/",this.ecRule).then((function(e){e&&t.initMyApplys()}))):this.$message.error("奖励的积分必须为正数,惩罚的积分必须为负数，请重试")):this.$message.error("添加字段不可以为空!")},initMyApplys:function(){var t=this;this.loading=!0,this.getRequest("/workflow/my/").then((function(e){t.loading=!1,e&&(t.myApplys=e,t.ecRule={ecType:"",ecReason:"",ecPoint:""})}))}}}),n=s,o=i("5d22"),r=Object(o["a"])(n,l,a,!1,null,"6ff5e9b6",null);e["default"]=r.exports},"5d39":function(t,e,i){"use strict";i.r(e);var l=function(){var t=this,e=t.$createElement,l=t._self._c||e;return l("div",[l("div",{staticStyle:{"margin-top":"10px",display:"flex","flex-wrap":"wrap","justify-content":"space-around"}},[l("el-card",[l("div",{staticClass:"img-container"},[l("img",{staticClass:"image",attrs:{src:i("5e1c")}})]),l("div",{staticStyle:{"margin-top":"20px",display:"flex","justify-content":"center"}},[l("el-button",{staticClass:"button",attrs:{type:"text",size:"medium"},on:{click:function(e){return t.clickHandler(1)}}},[t._v("报销申请")]),l("el-button",{staticClass:"button",attrs:{type:"text",size:"medium"}},[t._v("模板下载")])],1)]),l("el-card",[l("div",{staticClass:"img-container"},[l("img",{staticClass:"image",attrs:{src:i("03eb")}})]),l("div",{staticStyle:{"margin-top":"20px",display:"flex","justify-content":"center"}},[l("el-button",{staticClass:"button",attrs:{type:"text",size:"medium"},on:{click:function(e){return t.clickHandler(2)}}},[t._v("出差申请")]),l("el-button",{staticClass:"button",attrs:{type:"text",size:"medium"}},[t._v("模板下载")])],1)]),l("el-card",[l("div",{staticClass:"img-container"},[l("img",{staticClass:"image",attrs:{src:i("1e9b")}})]),l("div",{staticStyle:{"margin-top":"20px",display:"flex","justify-content":"center"}},[l("el-button",{staticClass:"button",attrs:{type:"text",size:"medium"},on:{click:function(e){return t.clickHandler(3)}}},[t._v("请假申请")]),l("el-button",{staticClass:"button",attrs:{type:"text",size:"medium"}},[t._v("模板下载")])],1)])],1),l("div",{staticStyle:{"margin-top":"30px",display:"flex","flex-wrap":"wrap","justify-content":"space-around"}},[l("el-card",[l("div",{staticClass:"img-container"},[l("img",{staticClass:"image",attrs:{src:i("9410")}})]),l("div",{staticStyle:{"margin-top":"20px",display:"flex","justify-content":"center"}},[l("el-button",{staticClass:"button",attrs:{type:"text",size:"medium"},on:{click:function(e){return t.clickHandler(4)}}},[t._v("加班申请")]),l("el-button",{staticClass:"button",attrs:{type:"text",size:"medium"}},[t._v("模板下载")])],1)]),l("el-card",[l("div",{staticClass:"img-container"},[l("img",{staticClass:"image",attrs:{src:i("a7b8")}})]),l("div",{staticStyle:{"margin-top":"20px",display:"flex","justify-content":"center"}},[l("el-button",{staticClass:"button",attrs:{type:"text",size:"medium"},on:{click:function(e){return t.clickHandler(5)}}},[t._v("转正申请")]),l("el-button",{staticClass:"button",attrs:{type:"text",size:"medium"}},[t._v("模板下载")])],1)]),l("el-card",[l("div",{staticClass:"img-container"},[l("img",{staticClass:"image",attrs:{src:i("1b5a")}})]),l("div",{staticStyle:{"margin-top":"20px",display:"flex","justify-content":"center"}},[l("el-button",{staticClass:"button",attrs:{type:"text",size:"medium"},on:{click:function(e){return t.clickHandler(6)}}},[t._v("离职申请")]),l("el-button",{staticClass:"button",attrs:{type:"text",size:"medium"}},[t._v("模板下载")])],1)])],1),l("el-dialog",{attrs:{title:"流程申请",visible:t.dialogVisible,width:"30%"},on:{"update:visible":function(e){t.dialogVisible=e}}},[l("el-input",{staticStyle:{"margin-top":"10px"},attrs:{type:"textarea",rows:2,autosize:"",placeholder:"请输入申请附注"},model:{value:t.textarea,callback:function(e){t.textarea=e},expression:"textarea"}}),l("el-date-picker",{staticStyle:{"margin-top":"10px"},attrs:{align:"right",type:"date",placeholder:"请选择日期","picker-options":t.pickerOptions},model:{value:t.pickDate,callback:function(e){t.pickDate=e},expression:"pickDate"}}),l("el-input",{staticStyle:{width:"300px","margin-top":"10px"},attrs:{placeholder:"请选择审核人"},model:{value:t.hrNames,callback:function(e){t.hrNames=e},expression:"hrNames"}},[l("el-button",{attrs:{slot:"prepend",icon:"el-icon-search"},on:{click:t.getAllHrs},slot:"prepend"})],1),l("div",{staticStyle:{"margin-top":"10px",display:"flex","justify-content":"left"}},[l("el-upload",{staticClass:"upload-demo",attrs:{drag:"",action:"https://jsonplaceholder.typicode.com/posts/",multiple:""}},[l("i",{staticClass:"el-icon-upload"}),l("div",{staticClass:"el-upload__text"},[t._v("将文件拖到此处，或"),l("em",[t._v("点击上传")])]),l("div",{staticClass:"el-upload__tip",attrs:{slot:"tip"},slot:"tip"},[t._v("请上传填写完毕的申请文档")])])],1),l("span",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[l("el-button",{on:{click:t.dialogCancel}},[t._v("取 消")]),l("el-button",{attrs:{type:"primary"},on:{click:t.addDialogOk}},[t._v("确 定")])],1)],1),l("el-dialog",{attrs:{title:"流程申请",visible:t.advDialogVisible,width:"30%"},on:{"update:visible":function(e){t.advDialogVisible=e}}},[l("el-input",{staticStyle:{"margin-top":"10px"},attrs:{type:"textarea",rows:2,autosize:"",placeholder:"请输入申请附注"},model:{value:t.textarea,callback:function(e){t.textarea=e},expression:"textarea"}}),l("div",{staticClass:"block",staticStyle:{"margin-top":"10px"}},[l("el-date-picker",{attrs:{type:"datetimerange","range-separator":"至","start-placeholder":"开始日期","end-placeholder":"结束日期"},model:{value:t.dateTime,callback:function(e){t.dateTime=e},expression:"dateTime"}})],1),l("el-input",{staticStyle:{width:"300px","margin-top":"10px"},attrs:{placeholder:"请选择审核人"},model:{value:t.hrids,callback:function(e){t.hrids=e},expression:"hrids"}},[l("el-button",{attrs:{slot:"prepend",icon:"el-icon-search"},on:{click:t.getAllHrs},slot:"prepend"})],1),l("div",{staticStyle:{"margin-top":"10px",display:"flex","justify-content":"left"}},[l("el-upload",{staticClass:"upload-demo",attrs:{drag:"",action:"https://jsonplaceholder.typicode.com/posts/",multiple:""}},[l("i",{staticClass:"el-icon-upload"}),l("div",{staticClass:"el-upload__text"},[t._v("将文件拖到此处，或"),l("em",[t._v("点击上传")])]),l("div",{staticClass:"el-upload__tip",attrs:{slot:"tip"},slot:"tip"},[t._v("请上传填写完毕的申请文档")])])],1),l("span",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[l("el-button",{on:{click:t.dialogCancel}},[t._v("取 消")]),l("el-button",{attrs:{type:"primary"},on:{click:t.advAddDialogOk}},[t._v("确 定")])],1)],1),l("el-dialog",{attrs:{title:"选择审核人",visible:t.selectHrsVisible,width:"40%"},on:{"update:visible":function(e){t.selectHrsVisible=e}}},[l("div",[l("el-input",{staticStyle:{width:"350px","margin-right":"10px"},attrs:{placeholder:"请输入姓名进行搜索，可以直接回车搜索...","prefix-icon":"el-icon-search",clearable:""},on:{clear:t.getAllHrs},nativeOn:{keydown:function(e){return!e.type.indexOf("key")&&t._k(e.keyCode,"enter",13,e.key,"Enter")?null:t.getAllHrs(e)}},model:{value:t.name,callback:function(e){t.name=e},expression:"name"}}),l("el-button",{attrs:{icon:"el-icon-search",type:"primary"},on:{click:t.getAllHrs}},[t._v("\n        搜索\n      ")])],1),l("el-table",{directives:[{name:"loading",rawName:"v-loading",value:t.loading,expression:"loading"}],staticStyle:{width:"80%","margin-top":"10px"},attrs:{data:t.hrs,"highlight-current-row":"",border:"","element-loading-text":"正在加载...","element-loading-spinner":"el-icon-loading","element-loading-background":"rgba(0, 0, 0, 0.8)",size:"small"},on:{"selection-change":t.handleSelectionChange}},[l("el-table-column",{attrs:{type:"selection",width:"55"}}),l("el-table-column",{attrs:{prop:"id",label:"编号",width:"75"}}),l("el-table-column",{attrs:{prop:"name",label:"姓名",width:"100"}}),l("el-table-column",{attrs:{prop:"roles[0].nameZh",label:"职位",width:"200"}}),l("el-table-column",{attrs:{prop:"phone",label:"电话",width:"150"}})],1),l("span",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[l("el-button",{on:{click:t.selectHrsCancel}},[t._v("取 消")]),l("el-button",{attrs:{type:"primary"},on:{click:t.selectHrs}},[t._v("确 定")])],1)],1)],1)},a=[],s=(i("4057"),i("a450"),i("1bc7"),{name:"WorkFlowApply",data:function(){return{multipleSelection:[],name:"",loading:!1,addWorkFlowApply:{workFlowTypeId:1,hrid:"10,11,12",content:"",selectDateTime:"",url:"http://smartsoftware.top"},selectHrsVisible:!1,hrids:[],hrNames:[],hrs:[],clickType:0,dialogVisible:!1,textarea:"",dateTime:[],pickDate:"",advDialogVisible:!1,pickerOptions:{disabledDate:function(t){return t.getTime()>Date.now()},shortcuts:[{text:"今天",onClick:function(t){t.$emit("pick",new Date)}},{text:"昨天",onClick:function(t){var e=new Date;e.setTime(e.getTime()-864e5),t.$emit("pick",e)}},{text:"一周前",onClick:function(t){var e=new Date;e.setTime(e.getTime()-6048e5),t.$emit("pick",e)}}]}}},methods:{selectHrsCancel:function(){this.hrids=[],this.hrNames=[],this.selectHrsVisible=!1},selectHrs:function(){var t=this;this.hrids=[],this.hrNames=[],this.multipleSelection.forEach((function(e){t.hrids.push(e.id),t.hrNames.push(e.name)})),this.selectHrsVisible=!1},handleSelectionChange:function(t){this.multipleSelection=t},addDialogCancel:function(){this.hrids=[],this.hrNames=[],this.multipleSelection=[]},addDialogOk:function(){var t=this;this.textarea&&this.pickDate?(this.addWorkFlowApply.content=this.textarea,this.addWorkFlowApply.hrid=this.hrids.toString(),this.addWorkFlowApply.selectDateTime=this.pickDate,this.postRequest("/workflow/apply/",this.addWorkFlowApply).then((function(e){e&&(t.addWorkFlowApply={workFlowTypeId:1,hrid:"",content:"",selectDateTime:"",url:"http://smartsoftware.top"},t.dialogVisible=!1)}))):this.$message.error("字段不能为空")},advAddDialogOk:function(){var t=this;this.textarea&&this.dateTime?(this.addWorkFlowApply.content=this.textarea,this.addWorkFlowApply.selectDateTime=this.dateTime.toString(),this.postRequest("/workflow/apply/",this.addWorkFlowApply).then((function(e){e&&(t.addWorkFlowApply={workFlowTypeId:1,hrid:"10,11,12",content:"",selectDateTime:"",url:"http://smartsoftware.top"},t.dialogVisible=!1)}))):this.$message.error("字段不能为空")},getAllHrs:function(){var t=this;this.selectHrsVisible=!0;var e="/system/hr/";this.name&&(e+="?name="+this.name),this.getRequest(e).then((function(e){t.loading=!1,e&&(t.hrs=e)}))},clickHandler:function(t){1==t||5==t||6==t?this.dialogVisible=!0:this.advDialogVisible=!0,this.addWorkFlowApply.workFlowTypeId=t},dialogCancel:function(){this.advDialogVisible=!1,this.dialogVisible=!1}}}),n=s,o=(i("8ceb"),i("5d22")),r=Object(o["a"])(n,l,a,!1,null,null,null);e["default"]=r.exports},"5e1c":function(t,e,i){t.exports=i.p+"img/baoxiao.e345ebf0.jpg"},7e3:function(t,e,i){},"78ad":function(t,e,i){"use strict";i.r(e);var l=function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("div",[i("div",{staticStyle:{"margin-top":"10px"}},[i("el-table",{directives:[{name:"loading",rawName:"v-loading",value:t.loading,expression:"loading"}],staticStyle:{width:"80%"},attrs:{data:t.approves,border:"","element-loading-text":"正在加载...","element-loading-spinner":"el-icon-loading","element-loading-background":"rgba(0, 0, 0, 0.8)",size:"small"},on:{"selection-change":t.handleSelectionChange}},[i("el-table-column",{attrs:{type:"selection",width:"55"}}),i("el-table-column",{attrs:{prop:"id",label:"编号",width:"55"}}),i("el-table-column",{attrs:{prop:"name",label:"申请人",width:"100"}}),i("el-table-column",{attrs:{prop:"typeName",label:"申请类型",width:"120"}}),i("el-table-column",{attrs:{prop:"selectDateTime",label:"选择时间",width:"145"}}),i("el-table-column",{attrs:{prop:"content",label:"申请内容",width:"200"}}),i("el-table-column",{attrs:{label:"申请文件",width:"200"},scopedSlots:t._u([{key:"default",fn:function(e){return[i("el-link",{attrs:{type:"primary"},on:{click:function(i){return t.urlClick(e.row.url)}}},[t._v("点此下载")])]}}])}),i("el-table-column",{attrs:{prop:"createTime",label:"申请时间",width:"200"}}),i("el-table-column",{attrs:{label:"申请状态",width:"200"},scopedSlots:t._u([{key:"default",fn:function(e){return[0===e.row.status?i("el-tag",[t._v("未审核")]):1===e.row.status?i("el-tag",{attrs:{type:"success"}},[t._v("批准")]):2===e.row.status?i("el-tag",{attrs:{type:"danger"}},[t._v("未批准")]):t._e()]}}])}),i("el-table-column",{attrs:{prop:"approveContent",label:"审核回复",width:"200"}}),i("el-table-column",{attrs:{prop:"approveTime",label:"审核时间",width:"200"}}),i("el-table-column",{attrs:{fixed:"right",label:"操作",width:"150"},scopedSlots:t._u([{key:"default",fn:function(e){return[i("el-button",{attrs:{size:"small",type:"primary"},on:{click:function(i){return t.showApprove(e.row.id,1)}}},[t._v("批准")]),i("el-button",{attrs:{size:"small",type:"danger"},on:{click:function(i){return t.showApprove(e.row.id,2)}}},[t._v("拒绝")])]}}])})],1)],1),i("el-dialog",{attrs:{title:"流程审批",visible:t.dialogVisible,width:"30%"},on:{"update:visible":function(e){t.dialogVisible=e}}},[i("div",[i("table",[i("tr",[i("td",[i("el-tag",[t._v("审核回复")])],1),i("td",[i("el-input",{attrs:{size:"small"},model:{value:t.content,callback:function(e){t.content=e},expression:"content"}})],1)])])]),i("span",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[i("el-button",{attrs:{size:"small"},on:{click:t.approveCancel}},[t._v("取 消")]),i("el-button",{attrs:{size:"small",type:"primary"},on:{click:t.doApprove}},[t._v("确 定")])],1)])],1)},a=[],s={name:"WorkFlowApprove",data:function(){return{dialogVisible:!1,loading:!1,multipleSelection:[],content:"",status:0,id:0,approves:[],ecTypes:[{value:"0",label:"奖励"},{value:"1",label:"惩罚"}],value:""}},mounted:function(){this.initApprove()},methods:{urlClick:function(t){window.open(t)},showApprove:function(t,e){this.id=t,this.status=e,this.content=1==e?"予以批准":"不予批准",this.dialogVisible=!0},approveCancel:function(){this.content="",this.id=0,this.status=0,this.dialogVisible=!1},doApprove:function(){var t=this;this.getRequest("/workflow/processApproval",{id:this.id,status:this.status,content:this.content}).then((function(e){e&&(t.dialogVisible=!1,t.initApprove())}))},initApprove:function(){var t=this;this.loading=!0,this.getRequest("/workflow/approve/").then((function(e){t.loading=!1,e&&(t.approves=e)}))}}},n=s,o=i("5d22"),r=Object(o["a"])(n,l,a,!1,null,"498159c8",null);e["default"]=r.exports},"8ceb":function(t,e,i){"use strict";i("7000")},9410:function(t,e,i){t.exports=i.p+"img/jiaban.3d7569ba.jpg"},a7b8:function(t,e,i){t.exports=i.p+"img/zhuanzheng.3fd306fc.jpg"}}]);
//# sourceMappingURL=chunk-e10cf8ac.0f3de9b3.js.map