# 接口设计文档
---------------------
> 该文档为描述物业管理系统服务器端与APP端的数据交互。
> 文档里面的数据为举例数据。        —— [批注](mailto:kangbiao@kangbiao.org)

[toc]

代码定义:
不在下述标准代码内则以数据异常显示

证件类型:1:身份证;2军人证;
园区类型:1:商户;2:住宅;3:车位
园区状态:-1:出租;1:自用;

门禁状态:0:禁用;1可用
app用户状态:1:正常;-1:禁用;

app用户角色:1:家庭成员;2:租户;3:业主

报修状态:0:需要设置维修人员;1:已设置维修人员;2:维修完成

>***编码规范***<br/>

> 所有的保存操作默认都要返回保存后的主键
> 所有的保存操作如果提供了主键则执行更新操作


>*错误代码*:
>web端错误代码规范:采用7位数字作为错误代码
>最高两位为10,四五位为模块代码,二三位为错误详情,最后一位作为扩展<br/>
>app端错误代码规范:采用7位数字作为错误代码
>最高两位为11,四五位为模块代码,二三位为错误详情,最后一位作为扩展
>例:1000010:web端00模块的01方法发生错误.
>
>*数据格式*:
>数据格式基于json
>基本格式如下:
```json
{
    "status": true/false,
    "errorMsg": {
        "code": null/number,
        "description": null/string
    },
    "jsonString": array or object or null
}
```
>如果status为false,客户端需要根据errorMsg进行相应的业务处理,如果为true,则从jsonString里面取出业务数据处理,展示

**app端接口**
--------------

##用户中心 (00)
###登陆
>**客户端请求**<br/>
>*请求URL*:api/uc/login<br/>
>*请求方法*:POST<br/>
>*请求参数*:<br/>
>phone: 18144240528<br/>
>password: md5(123456)
>
>**服务器返回数据**
```json
{
	"status":false,
	"errorMsg":
	{
		"code":10001,
		"description":"请输入11位手机号"
	}
}
```
错误代码和错误描述对照表
<table>
<tr><td>序号</td><td>代码</td><td>描述</td></tr>
<tr><td>1</td><td>1000010</td><td>手机号码不合法 </td></tr>
<tr><td>2</td><td>1000020</td><td>用户不存在</td></tr>
<tr><td>3</td><td>1000030</td><td>密码错误</td></tr>
</table>
###密码找回
>**客户端请求**<br/>
>*请求URL*:api/uc/findPassword/{userPhone}<br/>
>*请求方式*:GET<br/>
>**服务器返回数据**
```json
{
   "status": true,
   "errorMsg": {
       "code": null,
       "description": null
   },
   "jsonString": null 
}
```
>**客户端请求**<br/>
>*请求URL*:api/uc/checkVerifyCode/{code}<br/>
>*请求方式*:GET<br/>
>**服务器返回数据**
```json
{
   "status": true,
   "errorMsg": {
       "code": null,
       "description": null
   },
   "jsonString": null 
}
```
>**客户端请求**<br/>
>*请求URL*:api/uc/resetPassword/{password}<br/>
>*请求方式*:GET<br/>
>**服务器返回数据**
```json
{
   "status": true,
   "errorMsg": {
       "code": null,
       "description": null
   },
   "jsonString": null 
}
```
##公告获取 (01)

###首页公告
>**客户端请求**<br/>
>*请求URL*:api/notice/getSome/{number}<br/>
>*请求方式*:GET
>
>**服务器返回数据**
```json
{
   "status": true,
   "errorMsg": {
       "code": null,
       "description": null
   },
   "jsonString": [
       {
           "niticeId": 0,
           "title": "yi",
           "description": "描述",
           "detail": null,
           "createTime": null,
           "expireTime": null,
           "picPath": "120.26.67.75/file/pic/14515121512-sdas.png",
           "creater": null
       },
       {
           "niticeId": 0,
           "title": "yi",
           "description": "描述",
           "detail": null,
         "createTime": null,
          "expireTime": null,
           "picPath": "120.26.67.75/file/pic/14515121512-sdas.png",
            "creater": null
        }
   ]
}
```

###查看公告详情
>**客户端请求**<br/>
>*请求URL*:api/notice/{noticeID}<br/>
>*请求方式*:GET
>
>**服务器返回**
```json
{
   "status": true,
   "errorMsg": {
       "code": null,
       "description": null
   },
   "jsonString": {
           "niticeId": 3,
           "title": "物业通知",
           "description": "描述",
           "detail": "detaildetaildetaildetaildetaildetail",
           "createTime": 2015-5-8,
           "expireTime": 8,
           "picPath": "120.26.67.75/file/pic/14515121512-sdas.png",
           "creater": null
     }
       
}
```

**web端接口**
------------------
##一. 公告模块 (01)
错误代码和错误描述对照表
<table>
<tr><td>序号</td><td>代码</td><td>描述</td></tr>
<tr><td>1</td><td>100100</td><td>用户参数错误</td></tr>
<tr><td>3</td><td>100101</td><td>文件大小超过限制</td></tr>
<tr><td>4</td><td>100102</td><td>图片写入文件失败</td></tr>
<tr><td>5</td><td>100103</td><td>图片写入数据库失败</td></tr>
<tr><td>6</td><td>100104</td><td>返回数据失败</td></tr>
<tr><td>7</td><td>100105</td><td>程序错误</td></tr>
<tr><td>8</td><td>100106</td><td>删除公告失败</td></tr>
<tr><td>9</td><td>100107</td><td></td></tr>
</table>
###1.增加公告
路径:notice/add   方法:POST
>客户端请求参数
>title: "公告标题"
>description:"公告描述"
>detail:"公告详情"
>expireTime:"有效时间"
>file:公告的图片(可选)
>
>服务器返回数据
>```json
>{ 
>"status": true,
> "errorMsg": null,
> "jsonString":"上传成功"
> }
> 
>{
> "status": false,
> "errorMsg": {"code": "100102", "description": "上传图片失败"},
> "jsonString": null
>}
>```
###2.删除公告
路径:/notice/delete/{noticeID}  方法:GET/POST
>客户端请求参数
>id: "公告id""
>
>服务器返回数据
>```json
>{ 
>"status": true,
> "errorMsg": null,
> "jsonString":"删除成功"
> }
> 
>{
> "status": false,
> "errorMsg": {"code": "100102", "description": "删除失败"},
> "jsonString": null
>}
>```
>###2.查看公告
路径:/notice/view/{noticeID}  方法:GET/POST
>客户端请求参数
>id: "公告id""
>
>服务器返回数据
>```json
>{ 
>"status": true,
> "errorMsg": null,
> "jsonString":"删除成功"
> }
> 
>{
> "status": false,
> "errorMsg": {"code": "100102", "description": "删除失败"},
> "jsonString": null
>}
>```

