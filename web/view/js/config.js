/**
 * Created by kangbiao on 15-9-14.
 * 该文件为全局配置文件
 */

/************--------------接口配置----------********************/
var host="/oa/";
var urlConfig={};

//公告部分的url
urlConfig.noticeDelete=host+"notice/delete";
urlConfig.noticeList=host+"notice/list";
urlConfig.addNotice=host+"notice/add";

http://www.kangbiao.org/notice/getSome/3

//费用相关的URL
urlConfig.addFee=host+"fee/add/estate";
urlConfig.feeList=host+"fee/list/estate";
urlConfig.deleteFee=host+"fee/delete/";
urlConfig.addServiceFee=host+"fee/add/service";
urlConfig.serviceFeeList=host+"fee/list/service";
urlConfig.addParkingLotFee=host+"fee/add/parkingLot";
urlConfig.parkingLotFeeList=host+"fee/list/parkingLot";

//维修相关的URL
urlConfig.repairList=host+"repair/list";
urlConfig.setRepairMan=host+"repair/setRepairMan";

//投诉相关的URL
urlConfig.complainList=host+"complain/list";


//用户相关的URL
urlConfig.ownerList=host+"user/ownerList";
urlConfig.authenticatedUserList=host+"user/authenticatedUserList";
urlConfig.tenantList=host+"user/tenantList";
urlConfig.appUserList=host+"user/appUserList";
urlConfig.changeAppUserStatus=host+"user/appUserStatus";
urlConfig.getOwerInfoByID=host+"user/ownerInfo";

//密钥相关的url
urlConfig.addSecret=host+"secret/add";
urlConfig.secretList=host+"secret/list";

//物业信息相关的url
urlConfig.propertyList=host+"property/propertyList";
urlConfig.getOwnerInfoByPropertyID=host+"property/owner/";
urlConfig.getFeeInfoByPropertyID=host+"property/fee/";
urlConfig.addProperty=host+"property/add";

//搜索
urlConfig.search=host+"search/";

//配置kindeditor路径
urlConfig.uploadJson=host+"upload/kindeditor";

/**********----------------语言配置----------------**********/
var langConvert=[];
langConvert['squre']="按平米";
langConvert["per"]="按次";
langConvert["family"]="按户";
langConvert["month"]="按月";
langConvert["day"]="按日";


