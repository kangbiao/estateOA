# VerPass接口设计文档
---------------------

> 该文档为描述物业管理系统服务器端与APP端的数据交互。

> 文档里面参数的值为全大写的地方,值的范围只能是状态码对照表规定变量的范围之内,如:USER_ROLE只能为1,2或者3中的一个,否则服务器会返回参数异常错误.

> 文档里面的数据为举例数据。

> —— [批注](mailto:kangbiao@kangbiao.org)(康彪)


>***编码规范***
>*错误代码*:
>web端错误代码规范:采用6位数字作为错误代码
>最高位为0,四五位为模块代码,二三位为错误详情,最后一位作为扩展,模块位全为0为程序异常

>app端错误代码规范:采用6位数字作为错误代码
>最高两位为1,四五位为模块代码,二三位为错误详情,最后一位作为扩展
>例:000030:web端00模块的03方法发生错误.

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

**状态码对照表**:

| 数据项 |变量|||||
|-------|--------|------|--|---|
|app用户状态|USER_STATUS|-1(禁用|1(正常)|0(待审核)||
|app用户角色|USER_ROLE|1(家庭成员)|2(租户)|3(业主)||
|性别|SEX|0(男)|1(女)|||
|证件类型|CARD_TYPE|0(身份证)|1(军官证)|||
|门禁权限是否可用|DOOR_AUTHORITY|0(不可用)|1(可用)|||
|维修状态|REPAIR_STATUS|0(待处理)|1(处理中)|2(处理完成为评价)|3(已评价)|
|费用收费单位|FEE_UNIT|family(按户)|square(按平米)|per(按次)||
|账单状态|BILL_STATUS|0(未缴费)|1(已缴费)|||
|投诉状态|COMPLAIN_STATUS|0(待处理)|1(已处理待评价)|2(已评价)|||

**错误代码对照表**

| code | 描述 |错误级别|
|--------|--------|--|
|  100000  |  客户端参数错误  |  高  |
|  100001  |  服务器未知异常  |  高  |

[toc]

**app端接口**
--------------

## 一.用户中心 (01)
### 1.登陆
**客户端请求**
>*请求URL*:api/uc/login
>*请求方法*:GET
>*请求参数*:
>phone: 18144240528
>password: md5(123456)

**服务器返回数据**
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

### 2.退出登陆
**客户端请求**
>*请求URL*:api/uc/loginOut
>*请求方式*:GET

**服务器返回数据**
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

### 3.密码找回
**客户端请求**
>*请求URL*:api/uc/findPassword/{userPhone}
>*请求方式*:GET

**服务器返回数据**
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
**客户端请求**
>*请求URL*:api/uc/findPassword/checkVerifyCode/{code}
>*请求方式*:GET

**服务器返回数据**
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
**客户端请求**
>*请求URL*:api/uc/findPassword/reset/{newPassword}
>*请求方式*:GET

**服务器返回数据**
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

### 4.注册
**客户端请求**
>*请求URL*:api/uc/register/getVerifyCode/{phone}
>*请求方式*:GET

**服务器返回数据**
```json
{
   "status": false,
   "errorMsg": {
       "code": "100200/100210",
       "description": "电话号码已经注册/请输入正确的手机号"
   },
   "jsonString": null
}
```

**客户端请求**
>*请求URL*:api/uc/register/checkVerifyCode/{verifyCode}
>*请求方式*:GET

**服务器返回数据**
```json
{
   "status": false,
   "errorMsg": {
       "code": "100220",
       "description": "验证码错误"
   },
   "jsonString": null
}
```

**客户端请求**
>*请求URL*:api/uc/register/doRegister
>*请求方式*:GET
> 参数:
> nickname:kangbiao
> password:md5(123456)

**服务器返回数据**
```json
{
   "status": true,
   "errorMsg": {
       "code": "100000(已经是业主)/100001(没有任何绑定)",
       "description": "如果已经是业主的话,后端会自动绑定所有物业,如果不是业主且没有任何绑定,则需要进入绑定物业界面,至于用户想要绑定其他物业,则可以在进入app后再绑定"
   },
   "jsonString": null
}
```
**客户端请求**
>*请求URL*:api/uc/register/bind
>*请求方式*:POST
> 参数:
> role:USER_ROLE
> villageID:1
> buildingID:2
> propertyID:2

**服务器返回数据**
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

## 二.推送(02)
**客户端请求**
>*请求URL*:api/push
>*请求方式*:GET
>*参数*:
>type:
>info:

**服务器返回数据**
``` json
{
   "status": true,
   "errorMsg": {
       "code": null,
       "description": null
   },
   "jsonString": null
}
```

## 三.投诉(03)
### 1.增加投诉
**客户端请求**
>*请求URL*:api/complain/add
>*请求方式*:POST
>*参数*:

**服务器返回数据**
``` json
{
   "status": true,
   "errorMsg": {
       "code": null,
       "description": null
   },
   "jsonString": null
}
```

### 2.投诉评价
**客户端请求**
>*请求URL*:api/complain/remark
>*请求方式*:POST
>*参数*:
>complainID:3

**服务器返回数据**
``` json
{
   "status": true,
   "errorMsg": {
       "code": null,
       "description": null
   },
   "jsonString": null
}
```

## 四.报修(04)
### 1.增加报修
**客户端请求**
>*请求URL*:api/repair/add
>*请求方式*:POST
>*参数*:

**服务器返回数据**
``` json
{
   "status": true,
   "errorMsg": {
       "code": null,
       "description": null
   },
   "jsonString": null
}
```

### 2.评价报修
**客户端请求**
>*请求URL*:api/repair/remark/
>*请求方式*:POST
>*参数*:
>repairID:1

**服务器返回数据**
``` json
{
   "status": true,
   "errorMsg": {
       "code": null,
       "description": null
   },
   "jsonString": null
}
```

## 五.费用相关(05)
### 1.获取账单
>*请求URL*:api/fee/getBill
>*请求方式*:GET
>*参数*:
>status:0(未缴费)/1(已缴费)(不加则返回所有状态的账单)

**服务器返回数据**
``` json
{
    "status": true,
    "errorMsg": {
        "code": null,
        "description": null
    },
    "jsonString": [
        {
            "id": 1,
            "total": "400.0",
            "items": [
                {
                    "id": "水电费",
                    "text": "100"
                },
                {
                    "id": "停车费",
                    "text": "100"
                },
                {
                    "id": "煤气费",
                    "text": "200"
                }
            ],
            "status": 0,
            "billTime": "1976-03"
        }
    ]
}
```


### 2.物业费查询
**客户端请求**
>*请求URL*:api/fee
>*请求方式*:POST
>*参数*:

**服务器返回数据**
``` json
{
   "status": true,
   "errorMsg": {
       "code": null,
       "description": null
   },
   "jsonString": null
}
```

### 3.物业费缴纳
**客户端请求**
>*请求URL*:api/fee
>*请求方式*:POST
>*参数*:

**服务器返回数据**
``` json
{
   "status": true,
   "errorMsg": {
       "code": null,
       "description": null
   },
   "jsonString": null
}
```

## 六.门禁权限(06)
**客户端请求**
>*请求URL*:api/authority/query
>*请求方式*:GET
>*参数*:

**服务器返回数据**
``` json
{
   "status": true,
   "errorMsg": {
       "code": null,
       "description": null
   },
   "jsonString": {
   	"verify":"jfhdsfiysfjdskfhaifkja"
   }
}
```

## 七.物业查询(07)
### 1.获取所有园区
**客户端请求**
>*请求URL*:api/query/getAllVillage
>*请求方式*:GET

**服务器返回数据**
``` json
{
   "status": true,
   "errorMsg": {
       "code": null,
       "description": null
   },
   "jsonString": [{"id":1,"text":"园区一"},{"id":2,"text":"园区二"}]
}
```

### 2.根据园区id获取所有的楼栋
**客户端请求**
>*请求URL*:api/query/getBuilding/{villageID}
>*请求方式*:GET

**服务器返回数据**
``` json
{
   "status": true,
   "errorMsg": {
       "code": null,
       "description": null
   },
   "jsonString": [{"id":1,"text":"楼栋一"},{"id":2,"text":"楼栋二"}]
}
```

### 3.根据园区id和楼栋id获取所有的物业
**客户端请求**
>*请求URL*:api/query/getProperty
>*请求方式*:GET
>*参数*:
>villageID:2
>buildingID:3

**服务器返回数据**
``` json
{
   "status": true,
   "errorMsg": {
       "code": null,
       "description": null
   },
   "jsonString": [{"id":1,"text":"物业一"},{"id":2,"text":"二"}]
}
```


## 八.公告 (08)
### 1.首页公告
**客户端请求**
>*请求URL*:api/notice/getSome/{number}
>*请求方式*:GET

**服务器返回数据**
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

### 2.查看公告详情
**客户端请求**
>*请求URL*:api/notice/{noticeID}
>*请求方式*:GET

**服务器返回**
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
           "detail": "URL(api/notice/getContent/{noticeID}),后端渲染,用webview显示",
           "createTime": 2015-5-8,
           "expireTime": 8,
           "creater": null
     }
}
```

