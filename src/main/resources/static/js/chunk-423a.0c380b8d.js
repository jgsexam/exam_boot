(window.webpackJsonp=window.webpackJsonp||[]).push([["chunk-423a"],{"22oc":function(e,t,a){"use strict";var l=a("t3Un");t.a={save:function(e){return Object(l.a)({url:"/bankKnowledge/add",method:"post",data:e})},list:function(e){return Object(l.a)({url:"/bankKnowledge/list",method:"post",data:e})},get:function(e){return Object(l.a)({url:"/bankKnowledge/get/"+e,method:"get"})},allByBank:function(e){return Object(l.a)({url:"/bankKnowledge/all/"+e,method:"get"})},all:function(){return Object(l.a)({url:"/bankKnowledge/all",method:"get"})},update:function(e){return Object(l.a)({url:"/bankKnowledge/update",method:"put",data:e})},delete:function(e){return Object(l.a)({url:"/bankKnowledge/delete/"+e,method:"delete"})}}},"3HAv":function(e,t,a){"use strict";var l=a("t3Un");t.a={save:function(e){return Object(l.a)({url:"/bank/add",method:"post",data:e})},update:function(e){return Object(l.a)({url:"/bank/update",method:"put",data:e})},list:function(e){return Object(l.a)({url:"/bank/list",method:"post",data:e})},all:function(){return Object(l.a)({url:"/bank/all",method:"get"})},get:function(e){return Object(l.a)({url:"/bank/get/"+e,method:"get"})},delete:function(e){return Object(l.a)({url:"/bank/delete/"+e,method:"delete"})}}},HSso:function(e,t,a){"use strict";var l=a("mqIM");a.n(l).a},Ksg7:function(e,t,a){"use strict";var l=a("t3Un");t.a={save:function(e){return Object(l.a)({url:"/question/add",method:"post",data:e})},list:function(e){return Object(l.a)({url:"/question/list",method:"post",data:e})},delete:function(e){return Object(l.a)({url:"/question/delete/"+e,method:"delete"})},get:function(e){return Object(l.a)({url:"/question/get/"+e,method:"get"})},update:function(e){return Object(l.a)({url:"/question/update",method:"put",data:e})},search:function(e){return Object(l.a)({url:"/question/search",method:"post",data:e})}}},RCnU:function(e,t,a){"use strict";a.r(t);var l=a("twU4"),r=a("bEmV"),n=a("t3Un"),o=function(e){return Object(n.a)({url:"/paperConfig/addToPaper",method:"post",data:e})},i=function(e){return Object(n.a)({url:"/paperConfig/getQuestionNum/"+e,method:"get"})},s=a("3HAv"),p=a("oBwb"),c=a("22oc"),u=a("Ksg7"),d={data:function(){return{permission:this.$store.getters.auths,timeInterval:null,dialogFormVisible:!1,dialogHand:!1,dialogTypeNum:!1,dialogGa:!1,dialogTitle:"创建试卷",page:{currentPage:1,currentCount:10,totalCount:null,totalPage:null,sortName:"",sortOrder:"asc",params:{paperTitle:"",paperCollege:"",paperMajor:"",bankId:"",paperFlag:null,paperStyle:"",paperType:null,paperDifficulty:null,paperCreateTime:"",paperStartTear:""},list:[]},testPage:{currentPage:1,currentCount:10,totalCount:null,totalPage:null,sortName:"",sortOrder:"asc",params:{paperTitle:"",paperCollege:"",paperMajor:"",bankId:"",paperFlag:null,paperStyle:"",paperType:null,paperDifficulty:null,paperCreateTime:"",paperStartTear:""},list:[]},collegeList:[],majorList:[],bankList:[],paper:{paperId:""},knowList:[],typeList:[],config:{configPaper:"",configQuestionNum:0,configScore:0,configType:"",configKnow:"",questionList:[{questionConfig:"",questionId:""}]},questionNumConfig:[],gaPaper:{paperId:"",configList:[{totalScore:0,questionNum:0,difficulty:1,typeId:"",knowledgeIds:[]}]},typeNum:{columns:["typeName","configQuestionNum"],rows:[]},typeNumSetting:{labelMap:{typeName:"题型",configQuestionNum:"题量"}}}},methods:{handleSizeChange:function(e){this.page.currentCount=e,this.list()},handleCurrentChange:function(e){this.page.currentPage=e,this.list()},changeTestSize:function(e){this.page.currentCount=e,this.search()},changeTestCurrent:function(e){this.page.currentPage=e,this.search()},sortHandler:function(e){this.page.sortName=e.prop,this.page.sortOrder=e.order,this.list()},sortQuestion:function(e){console.log(e),this.testPage.sortName=e.prop,this.testPage.sortOrder=e.order,this.searchQuestion()},save:function(){var e=this;""==this.paper.paperId?r.a.save(this.paper).then(function(t){200==t.code&&(e.$message.success(t.msg),e.dialogFormVisible=!1,e.list())}):r.a.update(this.paper).then(function(t){200==t.code&&(e.$message.success(t.msg),e.dialogFormVisible=!1,e.list())})},list:function(){var e=this;null!=this.timeInterval?(this.page.params.startTime=this.timeInterval[0],this.page.params.endTime=this.timeInterval[1]):(this.page.params.startTime="",this.page.params.endTime=""),this.$store.commit("SET_LOADING",!0),r.a.list(this.page).then(function(t){200==t.code&&(e.page=t.data)})},toUpdate:function(e){var t=this;this.dialogTitle="创建试卷",r.a.get(e).then(function(e){200==e.code&&(t.paper=e.data,t.dialogFormVisible=!0)})},toAdd:function(){this.paper.paperId="",this.dialogTitle="创建试卷",this.dialogFormVisible=!0},deleteById:function(e){var t=this;this.$confirm("确定删除这条记录?","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"error"}).then(function(){r.a.delete(e).then(function(e){200==e.code&&(t.$message.success(e.msg),t.list())})})},search:function(){this.list()},getCollege:function(){var e=this;l.a.all({dictType:"college"}).then(function(t){e.collegeList=t.data})},getMajor:function(e){var t=this;""==e?l.a.all({dictType:"major"}).then(function(e){t.majorList=e.data}):l.a.getByFather(e).then(function(e){t.majorList=e.data})},getBank:function(){var e=this;s.a.all().then(function(t){e.bankList=t.data})},toHand:function(e){this.testPage.params.bankId=e.paperBank,this.config.configPaper=e.paperId,this.getKnowledge(e.paperBank),this.getQuestionNum(e.paperId),this.dialogHand=!0},searchQuestion:function(){var e=this;this.$store.commit("SET_LOADING",!0),u.a.search(this.testPage).then(function(t){e.testPage=t.data,e.config.configKnow=t.data.params.knowId,e.config.configType=t.data.params.typeId})},getKnowledge:function(e){var t=this;c.a.allByBank(e).then(function(e){t.knowList=e.data,t.knowList.length>0?t.testPage.params.knowId=t.knowList[0].knowId:t.testPage.params.knowId=""})},getType:function(e){var t=this;""==e?p.a.all().then(function(e){t.typeList=e.data,t.typeList.length>0?t.testPage.params.typeId=t.typeList[0].typeId:t.testPage.params.typeId=""}):p.a.allByKnow(e).then(function(e){t.typeList=e.data,t.typeList.length>0?t.testPage.params.typeId=t.typeList[0].typeId:t.testPage.params.typeId=""})},addToPaper:function(e){var t=this;this.$confirm("确定加入到本试卷中?","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"success"}).then(function(){t.$store.commit("SET_LOADING",!0),""!=e&&(t.config.questionList=[{questionId:e}]),o(t.config).then(function(e){200==e.code&&(t.$message.success(e.msg),t.getQuestionNum(t.config.configPaper))})})},selectQuestion:function(e){var t=e.map(function(e){return{questionId:e.id}});this.config.questionList=t},getQuestionNum:function(e){var t=this;i(e).then(function(e){t.questionNumConfig=e.data})},toUpdateQuestion:function(e){this.$router.push({name:"paperQuestion",params:{paperId:e.paperId}})},submitPaper:function(e){var t=this;this.$confirm("提交后不可修改，确定提交?","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"success"}).then(function(){t.$store.commit("SET_LOADING",!0),r.a.submitPaper(e.paperId).then(function(e){200==e.code&&(t.$message.success(e.msg),t.list())})})},downloadPaper:function(e){location.href=e.paperDownload},toRead:function(e){open("http://view.officeapps.live.com/op/view.aspx?src="+e.paperDownload)},toGa:function(e){this.gaPaper.paperId=e.paperId,this.getKnowledge(e.paperBank),this.dialogGa=!0},getGaType:function(e){var t=this;p.a.allByKnowIds(e).then(function(e){t.typeList=e.data})},removeConfig:function(e){var t=this.gaPaper.configList.indexOf(e);-1!==t&&this.gaPaper.configList.splice(t,1)},addConfig:function(){this.gaPaper.configList.push({totalScore:0,questionNum:0,difficulty:1,typeId:"",knowledgeIds:[]})},gaSubmit:function(){var e=this;this.$confirm("智能组卷提交后不可修改，确定提交?","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"success"}).then(function(){e.$store.commit("SET_LOADING",!0),r.a.submitPaperGa(e.gaPaper).then(function(t){200==t.code&&(e.$message.success(t.msg),e.dialogGa=!1,e.list())})})},getTypeNum:function(e){var t=this;r.a.typeNum(e.paperId).then(function(e){t.typeNum.rows=e.data,t.dialogTypeNum=!0})}},created:function(){this.list(),this.getCollege(),this.getBank(),this.getMajor(""),this.getType("")}},m=(a("HSso"),a("ZrdR")),f=Object(m.a)(d,function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",[a("div",{staticClass:"table-header"},[a("el-form",{staticClass:"demo-form-inline",attrs:{inline:!0,model:e.page,size:"mini"}},[a("el-form-item",{attrs:{label:"试卷标题"}},[a("el-input",{attrs:{placeholder:"试卷标题",clearable:""},model:{value:e.page.params.paperTitle,callback:function(t){e.$set(e.page.params,"paperTitle",t)},expression:"page.params.paperTitle"}})],1),e._v(" "),a("el-form-item",{attrs:{label:"学院"}},[a("el-select",{attrs:{filterable:"",placeholder:"请选择",clearable:""},on:{change:e.getMajor},model:{value:e.page.params.paperCollege,callback:function(t){e.$set(e.page.params,"paperCollege",t)},expression:"page.params.paperCollege"}},e._l(e.collegeList,function(e){return a("el-option",{key:e.dictId,attrs:{label:e.dictName,value:e.dictId}})}))],1),e._v(" "),a("el-form-item",{attrs:{label:"专业"}},[a("el-select",{attrs:{filterable:"",placeholder:"请选择",clearable:""},model:{value:e.page.params.paperMajor,callback:function(t){e.$set(e.page.params,"paperMajor",t)},expression:"page.params.paperMajor"}},e._l(e.majorList,function(e){return a("el-option",{key:e.dictId,attrs:{label:e.dictName,value:e.dictId}})}))],1),e._v(" "),a("el-form-item",{attrs:{label:"题库"}},[a("el-select",{attrs:{filterable:"",placeholder:"请选择",clearable:""},model:{value:e.page.params.bankId,callback:function(t){e.$set(e.page.params,"bankId",t)},expression:"page.params.bankId"}},e._l(e.bankList,function(e){return a("el-option",{key:e.bankId,attrs:{label:e.bankName,value:e.bankId}})}))],1),e._v(" "),a("el-form-item",{attrs:{label:"组卷"}},[a("el-select",{attrs:{filterable:"",placeholder:"请选择",clearable:""},model:{value:e.page.params.paperType,callback:function(t){e.$set(e.page.params,"paperType",t)},expression:"page.params.paperType"}},[a("el-option",{key:"0",attrs:{label:"未组卷",value:"0"}}),e._v(" "),a("el-option",{key:"1",attrs:{label:"手动组卷",value:"1"}}),e._v(" "),a("el-option",{key:"2",attrs:{label:"自动组卷",value:"2"}})],1)],1),e._v(" "),a("el-form-item",{attrs:{label:"试卷类型"}},[a("el-select",{attrs:{filterable:"",placeholder:"请选择",clearable:""},model:{value:e.page.params.paperStyle,callback:function(t){e.$set(e.page.params,"paperStyle",t)},expression:"page.params.paperStyle"}},[a("el-option",{key:"A",attrs:{label:"A卷",value:"A"}}),e._v(" "),a("el-option",{key:"B",attrs:{label:"B卷",value:"B"}}),e._v(" "),a("el-option",{key:"C",attrs:{label:"C卷",value:"C"}})],1)],1),e._v(" "),a("el-form-item",{attrs:{label:"难度系数"}},[a("el-select",{attrs:{clearable:"",filterable:"",placeholder:"请选择"},model:{value:e.page.params.paperDifficulty,callback:function(t){e.$set(e.page.params,"paperDifficulty",t)},expression:"page.params.paperDifficulty"}},e._l(5,function(e){return a("el-option",{key:e,attrs:{label:e,value:e}})}))],1),e._v(" "),a("el-form-item",{attrs:{label:"学年度"}},[a("el-date-picker",{attrs:{type:"year",placeholder:"起始年度","value-format":"yyyy"},model:{value:e.page.params.paperStartYear,callback:function(t){e.$set(e.page.params,"paperStartYear",t)},expression:"page.params.paperStartYear"}}),e._v("-\n        "),a("el-date-picker",{attrs:{type:"year",placeholder:"结束年度","value-format":"yyyy"},model:{value:e.page.params.paperEndYear,callback:function(t){e.$set(e.page.params,"paperEndYear",t)},expression:"page.params.paperEndYear"}})],1),e._v(" "),a("el-form-item",{attrs:{label:"学期"}},[a("el-select",{attrs:{filterable:"",placeholder:"请选择",clearable:""},model:{value:e.page.params.paperSeme,callback:function(t){e.$set(e.page.params,"paperSeme",t)},expression:"page.params.paperSeme"}},[a("el-option",{key:"1",attrs:{label:"第一学期",value:"1"}}),e._v(" "),a("el-option",{key:"2",attrs:{label:"第二学期",value:"2"}})],1)],1),e._v(" "),a("el-form-item",{attrs:{label:"创建时间"}},[a("div",{staticClass:"block"},[a("el-date-picker",{attrs:{type:"daterange","value-format":"yyyy-MM-dd","range-separator":"至","start-placeholder":"开始日期","end-placeholder":"结束日期"},model:{value:e.timeInterval,callback:function(t){e.timeInterval=t},expression:"timeInterval"}})],1)]),e._v(" "),a("el-form-item",[a("el-button",{attrs:{type:"primary"},on:{click:e.search}},[e._v("查询")])],1)],1),e._v(" "),a("el-divider"),e._v(" "),e.permission.indexOf("paper:add")>=0?a("el-button",{attrs:{type:"primary",size:"mini"},on:{click:e.toAdd}},[e._v("添加")]):e._e()],1),e._v(" "),a("el-table",{directives:[{name:"loading",rawName:"v-loading",value:this.$store.getters.loading,expression:"this.$store.getters.loading"}],staticStyle:{width:"100%"},attrs:{data:e.page.list,border:"",stripe:"",size:"mini"},on:{"sort-change":e.sortHandler}},[a("el-table-column",{attrs:{type:"index",width:"50"}}),e._v(" "),a("el-table-column",{attrs:{sortable:"custom",label:"试卷标题"},scopedSlots:e._u([{key:"default",fn:function(t){return[a("el-tooltip",{staticClass:"item",attrs:{effect:"dark",content:t.row.paperComment,placement:"top"}},[a("span",[e._v(e._s(t.row.paperTitle))])])]}}])}),e._v(" "),a("el-table-column",{attrs:{label:"学年度"},scopedSlots:e._u([{key:"default",fn:function(t){return[a("span",[e._v(e._s(t.row.paperStartYear+"-"+t.row.paperEndYear))])]}}])}),e._v(" "),a("el-table-column",{attrs:{label:"学期"},scopedSlots:e._u([{key:"default",fn:function(t){return[1==t.row.paperSeme?a("span",[e._v("第一学期")]):e._e(),e._v(" "),2==t.row.paperSeme?a("span",[e._v("第二学期")]):e._e()]}}])}),e._v(" "),a("el-table-column",{attrs:{prop:"college.dictName",sortable:"custom",label:"学院",width:"160px"}}),e._v(" "),a("el-table-column",{attrs:{prop:"major.dictName",sortable:"custom",label:"专业"}}),e._v(" "),a("el-table-column",{attrs:{prop:"bank.bankName",sortable:"custom",label:"题库",width:"120px"}}),e._v(" "),a("el-table-column",{attrs:{prop:"paperQuestionNum",sortable:"custom",label:"题量"}}),e._v(" "),a("el-table-column",{attrs:{sortable:"custom",label:"试卷类型"},scopedSlots:e._u([{key:"default",fn:function(t){return[a("span",[e._v(e._s(t.row.paperStyle+"卷"))])]}}])}),e._v(" "),a("el-table-column",{attrs:{sortable:"custom",label:"组卷",width:"85px"},scopedSlots:e._u([{key:"default",fn:function(t){return[0==t.row.paperType?a("el-tag",{attrs:{type:"info"}},[e._v("未组卷")]):e._e(),e._v(" "),1==t.row.paperType?a("el-tag",{attrs:{type:"warning"}},[e._v("手动组卷")]):e._e(),e._v(" "),2==t.row.paperType?a("el-tag",{attrs:{type:"success"}},[e._v("智能组卷")]):e._e()]}}])}),e._v(" "),a("el-table-column",{attrs:{sortable:"custom",label:"提交组卷"},scopedSlots:e._u([{key:"default",fn:function(t){return[0==t.row.paperSubmit?a("el-tag",{attrs:{type:"info"}},[e._v("未提交")]):e._e(),e._v(" "),1==t.row.paperSubmit?a("el-tag",{attrs:{type:"success"}},[e._v("已提交")]):e._e()]}}])}),e._v(" "),a("el-table-column",{attrs:{prop:"paperDifficulty",sortable:"custom",label:"难度系数"}}),e._v(" "),a("el-table-column",{attrs:{prop:"paperScore",sortable:"custom",label:"总分"}}),e._v(" "),a("el-table-column",{attrs:{prop:"teacher.teacherName",sortable:"custom",label:"创建人"}}),e._v(" "),a("el-table-column",{attrs:{prop:"paperCreateTime",sortable:"custom",label:"创建时间"}}),e._v(" "),a("el-table-column",{attrs:{prop:"paperUpdateTime",sortable:"custom",label:"修改时间"}}),e._v(" "),a("el-table-column",{attrs:{fixed:"right",label:"操作",width:"100px"},scopedSlots:e._u([{key:"default",fn:function(t){return[a("el-dropdown",[a("el-button",{attrs:{type:"primary",size:"mini"}},[e._v("\n            操作\n            "),a("i",{staticClass:"el-icon-arrow-down el-icon--right"})]),e._v(" "),a("el-dropdown-menu",{attrs:{slot:"dropdown"},slot:"dropdown"},[a("el-dropdown-item",[e.permission.indexOf("paper:update")>=0?a("el-button",{attrs:{size:"mini",type:"success"},on:{click:function(a){e.toUpdate(t.row.paperId)}}},[e._v("编辑")]):e._e()],1),e._v(" "),0==t.row.paperType?a("el-dropdown-item",[e.permission.indexOf("paper:submit")>=0?a("el-button",{attrs:{size:"mini",type:"success"},on:{click:function(a){e.toGa(t.row)}}},[e._v("智能组卷")]):e._e()],1):e._e(),e._v(" "),2!=t.row.paperType&&0==t.row.paperSubmit?a("el-dropdown-item",[e.permission.indexOf("paper:submit")>=0?a("el-button",{attrs:{size:"mini",type:"warning"},on:{click:function(a){e.toHand(t.row)}}},[e._v("手动组卷")]):e._e()],1):e._e(),e._v(" "),1==t.row.paperType&&0==t.row.paperSubmit?a("el-dropdown-item",[e.permission.indexOf("paper:submit")>=0?a("el-button",{attrs:{size:"mini",type:"primary"},on:{click:function(a){e.toUpdateQuestion(t.row)}}},[e._v("修改题目")]):e._e()],1):e._e(),e._v(" "),1==t.row.paperSubmit?a("el-dropdown-item",[e.permission.indexOf("paper:submit")>=0?a("el-button",{attrs:{size:"mini",type:"primary"},on:{click:function(a){e.toRead(t.row)}}},[e._v("预览试卷")]):e._e()],1):e._e(),e._v(" "),1==t.row.paperType&&0==t.row.paperSubmit?a("el-dropdown-item",[e.permission.indexOf("paper:submit")>=0?a("el-button",{attrs:{size:"mini",type:"primary"},on:{click:function(a){e.submitPaper(t.row)}}},[e._v("提交组卷")]):e._e()],1):e._e(),e._v(" "),1==t.row.paperSubmit?a("el-dropdown-item",[a("el-button",{attrs:{size:"mini",type:"primary"},on:{click:function(a){e.downloadPaper(t.row)}}},[e._v("下载试卷")])],1):e._e(),e._v(" "),0!=t.row.paperType&&e.permission.indexOf("paper:submit")>=0?a("el-dropdown-item",[a("el-button",{attrs:{size:"mini",type:"primary"},on:{click:function(a){e.getTypeNum(t.row)}}},[e._v("题型比例")])],1):e._e(),e._v(" "),a("el-dropdown-item",[e.permission.indexOf("paper:delete")>=0?a("el-button",{attrs:{size:"mini",type:"danger"},on:{click:function(a){e.deleteById(t.row.paperId)}}},[e._v("删除")]):e._e()],1)],1)],1)]}}])})],1),e._v(" "),a("div",{staticClass:"page-div"},[a("el-pagination",{attrs:{"current-page":e.page.currentPage,"page-sizes":[10,15,20,30],"page-size":e.page.currentCount,layout:"total, sizes, prev, pager, next, jumper",total:e.page.totalCount},on:{"size-change":e.handleSizeChange,"current-change":e.handleCurrentChange}})],1),e._v(" "),a("el-dialog",{directives:[{name:"loading",rawName:"v-loading",value:this.$store.getters.loading,expression:"this.$store.getters.loading"}],attrs:{title:e.dialogTitle,visible:e.dialogFormVisible},on:{"update:visible":function(t){e.dialogFormVisible=t}}},[a("el-form",{ref:"paper",attrs:{model:e.paper,"label-width":"80px",size:"mini"}},[a("el-form-item",{attrs:{label:"试卷名"}},[a("el-input",{attrs:{clearable:""},model:{value:e.paper.paperTitle,callback:function(t){e.$set(e.paper,"paperTitle",t)},expression:"paper.paperTitle"}})],1),e._v(" "),a("el-form-item",{attrs:{label:"学院"}},[a("el-select",{attrs:{filterable:"",placeholder:"请选择",clearable:""},on:{change:e.getMajor},model:{value:e.paper.paperCollege,callback:function(t){e.$set(e.paper,"paperCollege",t)},expression:"paper.paperCollege"}},e._l(e.collegeList,function(e){return a("el-option",{key:e.dictId,attrs:{label:e.dictName,value:e.dictId}})}))],1),e._v(" "),a("el-form-item",{attrs:{label:"专业"}},[a("el-select",{attrs:{filterable:"",placeholder:"请选择",clearable:""},model:{value:e.paper.paperMajor,callback:function(t){e.$set(e.paper,"paperMajor",t)},expression:"paper.paperMajor"}},e._l(e.majorList,function(e){return a("el-option",{key:e.dictId,attrs:{label:e.dictName,value:e.dictId}})}))],1),e._v(" "),a("el-form-item",{attrs:{label:"题库"}},[a("el-select",{attrs:{filterable:"",placeholder:"请选择",clearable:""},model:{value:e.paper.paperBank,callback:function(t){e.$set(e.paper,"paperBank",t)},expression:"paper.paperBank"}},e._l(e.bankList,function(e){return a("el-option",{key:e.bankId,attrs:{label:e.bankName,value:e.bankId}})}))],1),e._v(" "),a("el-form-item",{attrs:{label:"试卷类型"}},[a("el-select",{attrs:{filterable:"",placeholder:"请选择",clearable:""},model:{value:e.paper.paperStyle,callback:function(t){e.$set(e.paper,"paperStyle",t)},expression:"paper.paperStyle"}},[a("el-option",{key:"A",attrs:{label:"A卷",value:"A"}}),e._v(" "),a("el-option",{key:"B",attrs:{label:"B卷",value:"B"}}),e._v(" "),a("el-option",{key:"C",attrs:{label:"C卷",value:"C"}})],1)],1),e._v(" "),a("el-form-item",{attrs:{label:"学年度"}},[a("el-col",{attrs:{span:11}},[a("el-date-picker",{staticStyle:{width:"100%"},attrs:{type:"year",placeholder:"起始年度","value-format":"yyyy"},model:{value:e.paper.paperStartYear,callback:function(t){e.$set(e.paper,"paperStartYear",t)},expression:"paper.paperStartYear"}})],1),e._v(" "),a("el-col",{staticClass:"line",attrs:{span:1}},[e._v("-")]),e._v(" "),a("el-col",{attrs:{span:11}},[a("el-date-picker",{staticStyle:{width:"100%"},attrs:{type:"year",placeholder:"结束年度","value-format":"yyyy"},model:{value:e.paper.paperEndYear,callback:function(t){e.$set(e.paper,"paperEndYear",t)},expression:"paper.paperEndYear"}})],1)],1),e._v(" "),a("el-form-item",{attrs:{label:"学期"}},[a("el-select",{attrs:{filterable:"",placeholder:"请选择",clearable:""},model:{value:e.paper.paperSeme,callback:function(t){e.$set(e.paper,"paperSeme",t)},expression:"paper.paperSeme"}},[a("el-option",{key:"1",attrs:{label:"第一学期",value:"1"}}),e._v(" "),a("el-option",{key:"2",attrs:{label:"第二学期",value:"2"}})],1)],1),e._v(" "),a("el-form-item",{attrs:{label:"备注"}},[a("el-input",{attrs:{type:"textarea",clearable:""},model:{value:e.paper.paperComment,callback:function(t){e.$set(e.paper,"paperComment",t)},expression:"paper.paperComment"}})],1),e._v(" "),a("el-form-item",[a("el-button",{attrs:{type:"primary"},on:{click:e.save}},[e._v("提交")]),e._v(" "),a("el-button",{on:{click:function(t){e.dialogFormVisible=!1}}},[e._v("取消")])],1)],1)],1),e._v(" "),a("el-dialog",{directives:[{name:"loading",rawName:"v-loading",value:this.$store.getters.loading,expression:"this.$store.getters.loading"}],attrs:{title:"手动组卷",visible:e.dialogHand,width:"85%"},on:{"update:visible":function(t){e.dialogHand=t}}},[a("div",{staticClass:"table-header"},[a("el-form",{staticClass:"demo-form-inline",attrs:{inline:!0,model:e.page,size:"mini"}},[a("el-form-item",{attrs:{label:"题干"}},[a("el-input",{attrs:{placeholder:"题干",clearable:""},model:{value:e.testPage.params.title,callback:function(t){e.$set(e.testPage.params,"title",t)},expression:"testPage.params.title"}})],1),e._v(" "),a("el-form-item",{attrs:{label:"知识点"}},[a("el-select",{attrs:{filterable:"",placeholder:"请选择",clearable:""},on:{change:e.getType},model:{value:e.testPage.params.knowId,callback:function(t){e.$set(e.testPage.params,"knowId",t)},expression:"testPage.params.knowId"}},e._l(e.knowList,function(e){return a("el-option",{key:e.knowId,attrs:{label:e.knowName,value:e.knowId}})}))],1),e._v(" "),a("el-form-item",{attrs:{label:"题型"}},[a("el-select",{attrs:{filterable:"",placeholder:"请选择"},model:{value:e.testPage.params.typeId,callback:function(t){e.$set(e.testPage.params,"typeId",t)},expression:"testPage.params.typeId"}},e._l(e.typeList,function(e){return a("el-option",{key:e.typeId,attrs:{label:e.typeName,value:e.typeId}})}))],1),e._v(" "),a("el-form-item",{attrs:{label:"难度系数"}},[a("el-select",{attrs:{clearable:"",filterable:"",placeholder:"请选择"},model:{value:e.testPage.params.difficulty,callback:function(t){e.$set(e.testPage.params,"difficulty",t)},expression:"testPage.params.difficulty"}},e._l(5,function(e){return a("el-option",{key:e,attrs:{label:e,value:e}})}))],1),e._v(" "),a("el-form-item",[a("el-button",{attrs:{type:"primary"},on:{click:e.searchQuestion}},[e._v("查询")])],1)],1),e._v(" "),a("div",{staticClass:"paper-question-div"},[e.questionNumConfig.length>0?a("span",[e._v("当前已选择：")]):e._e(),e._v(" "),e._l(e.questionNumConfig,function(t){return a("span",{key:t.configType},[e._v(e._s(t.type.typeName+t.configQuestionNum+"道，总分为"+t.configScore+"分；"))])})],2),e._v(" "),a("el-divider"),e._v(" "),a("el-button",{attrs:{type:"primary",size:"mini"},on:{click:function(t){e.addToPaper("")}}},[e._v("批量添加")])],1),e._v(" "),a("el-table",{directives:[{name:"loading",rawName:"v-loading",value:this.$store.getters.loading,expression:"this.$store.getters.loading"}],staticStyle:{width:"100%"},attrs:{data:e.testPage.list,border:"",stripe:"",size:"mini"},on:{"sort-change":e.sortQuestion,"selection-change":e.selectQuestion}},[a("el-table-column",{attrs:{type:"selection",width:"55"}}),e._v(" "),a("el-table-column",{attrs:{type:"index",width:"50"}}),e._v(" "),a("el-table-column",{attrs:{sortable:"custom",label:"题干"},scopedSlots:e._u([{key:"default",fn:function(t){return[a("span",{domProps:{innerHTML:e._s(t.row.title)}})]}}])}),e._v(" "),a("el-table-column",{attrs:{prop:"score",sortable:"custom",label:"分值",width:"75px"}}),e._v(" "),a("el-table-column",{attrs:{prop:"difficulty",sortable:"custom",label:"难度系数",width:"125px"}}),e._v(" "),a("el-table-column",{attrs:{fixed:"right",label:"操作",width:"100px"},scopedSlots:e._u([{key:"default",fn:function(t){return[a("el-dropdown",[a("el-button",{attrs:{type:"primary",size:"mini"}},[e._v("\n              操作\n              "),a("i",{staticClass:"el-icon-arrow-down el-icon--right"})]),e._v(" "),a("el-dropdown-menu",{attrs:{slot:"dropdown"},slot:"dropdown"},[a("el-dropdown-item",[a("el-button",{attrs:{size:"mini",type:"success"},on:{click:function(a){e.addToPaper(t.row.id)}}},[e._v("加入试卷")])],1)],1)],1)]}}])})],1),e._v(" "),a("div",{staticClass:"page-div"},[a("el-pagination",{attrs:{"current-page":e.testPage.currentPage,"page-sizes":[10,15,20,30],"page-size":e.testPage.currentCount,layout:"total, sizes, prev, pager, next, jumper",total:e.testPage.totalCount},on:{"size-change":e.changeTestSize,"current-change":e.changeTestCurrent}})],1)],1),e._v(" "),a("el-dialog",{attrs:{title:"智能组卷",visible:e.dialogGa},on:{"update:visible":function(t){e.dialogGa=t}}},[a("el-form",{directives:[{name:"loading",rawName:"v-loading",value:this.$store.getters.loading,expression:"this.$store.getters.loading"}],attrs:{model:e.gaPaper,size:"mini"}},[e._l(e.gaPaper.configList,function(t,l){return a("el-form-item",{key:l,attrs:{inline:!0}},[a("div",{staticClass:"input-div"},[a("h2",{staticStyle:{"text-align":"center"}},[e._v("题型 "+e._s(l+1))]),e._v(" "),a("el-form-item",{attrs:{label:"难度系数","label-width":"80px"}},[a("el-rate",{attrs:{"show-score":"","text-color":"#ff9900","score-template":"{value}"},model:{value:t.difficulty,callback:function(a){e.$set(t,"difficulty",a)},expression:"config.difficulty"}})],1),e._v(" "),a("el-form-item",{attrs:{label:"分值","label-width":"80px"}},[a("el-input",{attrs:{clearable:"",placeholder:"请输入分值"},model:{value:t.totalScore,callback:function(a){e.$set(t,"totalScore",a)},expression:"config.totalScore"}})],1),e._v(" "),a("el-form-item",{attrs:{label:"题量","label-width":"80px"}},[a("el-input",{attrs:{clearable:"",placeholder:"请输入题目数"},model:{value:t.questionNum,callback:function(a){e.$set(t,"questionNum",a)},expression:"config.questionNum"}})],1),e._v(" "),a("el-form-item",{attrs:{label:"知识点","label-width":"80px"}},[a("el-select",{attrs:{filterable:"",placeholder:"请选择",clearable:"",multiple:""},on:{change:e.getGaType},model:{value:t.knowledgeIds,callback:function(a){e.$set(t,"knowledgeIds",a)},expression:"config.knowledgeIds"}},e._l(e.knowList,function(e){return a("el-option",{key:e.knowId,attrs:{label:e.knowName,value:e.knowId}})}))],1),e._v(" "),a("el-form-item",{attrs:{label:"题型","label-width":"80px"}},[a("el-select",{attrs:{filterable:"",placeholder:"请选择"},model:{value:t.typeId,callback:function(a){e.$set(t,"typeId",a)},expression:"config.typeId"}},e._l(e.typeList,function(e){return a("el-option",{key:e.typeId,attrs:{label:e.typeName,value:e.typeId}})}))],1),e._v(" "),a("div",{staticClass:"delete-div"},[a("el-button",{attrs:{type:"danger"},on:{click:function(a){a.preventDefault(),e.removeConfig(t)}}},[e._v("删除")])],1)],1)])}),e._v(" "),a("el-form-item",[a("el-button",{attrs:{type:"primary"},on:{click:e.gaSubmit}},[e._v("提交")]),e._v(" "),a("el-button",{on:{click:e.addConfig}},[e._v("添题型题")]),e._v(" "),a("el-button",{on:{click:function(t){e.dialogGa=!1}}},[e._v("取消")])],1)],2)],1),e._v(" "),a("el-dialog",{attrs:{title:"题型比例",visible:e.dialogTypeNum},on:{"update:visible":function(t){e.dialogTypeNum=t}}},[a("ve-ring",{attrs:{data:e.typeNum,settings:e.typeNumSetting}})],1)],1)},[],!1,null,"f75cb0a0",null);f.options.__file="PaperList.vue";t.default=f.exports},bEmV:function(e,t,a){"use strict";var l=a("t3Un");t.a={save:function(e){return Object(l.a)({url:"/paper/add",method:"post",data:e})},list:function(e){return Object(l.a)({url:"/paper/list",method:"post",data:e})},delete:function(e){return Object(l.a)({url:"/paper/delete/"+e,method:"delete"})},get:function(e){return Object(l.a)({url:"/paper/get/"+e,method:"get"})},update:function(e){return Object(l.a)({url:"/paper/update",method:"put",data:e})},questionList:function(e){return Object(l.a)({url:"/paper/questionList/"+e,method:"get"})},submitPaper:function(e){return Object(l.a)({url:"/paper/submit/"+e,method:"get"})},submitPaperGa:function(e){return Object(l.a)({url:"/paper/gaSubmit",method:"post",data:e})},typeNum:function(e){return Object(l.a)({url:"/paper/typeNum/"+e,method:"get"})},all:function(){return Object(l.a)({url:"/paper/all",method:"get"})}}},mqIM:function(e,t,a){},oBwb:function(e,t,a){"use strict";var l=a("t3Un");t.a={save:function(e){return""===e.typeId?Object(l.a)({url:"/type/add",method:"post",data:e}):Object(l.a)({url:"/type/update",method:"put",data:e})},list:function(e){return Object(l.a)({url:"/type/list",method:"post",data:e})},get:function(e){return Object(l.a)({url:"/type/get/"+e,method:"get"})},delete:function(e){return Object(l.a)({url:"/type/delete/"+e,method:"delete"})},update:function(e){return Object(l.a)({url:"/type/update",method:"put",data:e})},all:function(){return Object(l.a)({url:"/type/all",method:"get"})},allByKnowIds:function(e){return Object(l.a)({url:"/type/all",method:"post",data:e})},allByKnow:function(e){return Object(l.a)({url:"/type/all/"+e,method:"get"})}}},twU4:function(e,t,a){"use strict";var l=a("t3Un");t.a={save:function(e){return""===e.dictId?Object(l.a)({url:"/dict/add",method:"post",data:e}):Object(l.a)({url:"/dict/update",method:"put",data:e})},list:function(e){return Object(l.a)({url:"/dict/list",method:"post",data:e})},get:function(e){return Object(l.a)({url:"/dict/get/"+e,method:"get"})},delete:function(e){return Object(l.a)({url:"/dict/delete/"+e,method:"delete"})},all:function(e){return Object(l.a)({url:"/dict/all",method:"post",data:e})},getByFather:function(e){return Object(l.a)({url:"/dict/childList/"+e,method:"get"})}}}}]);