/**
 * Created by kangbiao on 15-9-14.
 * 该文件为web端接口全局配置文件
 */

/************--------------接口配置----------********************/
var host="/oa/";
var urlConfig={};

urlConfig.home=host+"view";

//用户登陆
urlConfig.login=host+"auth/login";


//公告部分的url
urlConfig.noticeDelete=host+"notice/delete";
urlConfig.noticeList=host+"notice/list";
urlConfig.addNotice=host+"notice/add";


//费用相关的URL
urlConfig.addFee=host+"fee/add/estate";
urlConfig.feeList=host+"fee/list/estate";
urlConfig.deleteFee=host+"fee/delete/";
urlConfig.addServiceFee=host+"fee/add/service";
urlConfig.serviceFeeList=host+"fee/list/service";
urlConfig.addParkingLotFee=host+"fee/add/parkingLot";
urlConfig.parkingLotFeeList=host+"fee/list/parkingLot";
urlConfig.relateFeeToBuilding=host+"fee/relateBuilding";
urlConfig.getBillList=host+"fee/getBillList";
urlConfig.generateAllBill=host+"fee/getnerateAllBill";

//维修相关的URL
urlConfig.repairList=host+"repair/list";
urlConfig.setRepairMan=host+"repair/setRepairMan";

//投诉相关的URL
urlConfig.complainList=host+"complain/list";


//用户相关的URL
urlConfig.ownerList=host+"user/ownerList";
urlConfig.addOwner=host+"user/addOwner";
urlConfig.authenticatedUserList=host+"user/authenticatedUserList";
urlConfig.tenantList=host+"user/tenantList";
urlConfig.appUserList=host+"user/appUserList";
urlConfig.changeAppUserStatus=host+"user/appUserStatus";
urlConfig.getPropertyInfo=host+"user/getPropertyInfo";
urlConfig.getPropertiesByPhone=host+"user/getPropertiesByPhone/";
urlConfig.deleteOwnerByPhone=host+"/user/owner/delete/";
urlConfig.deleteAppUserByPhone=host+"/user/appuser/delete/";

//密钥相关的url
urlConfig.addSecret=host+"secret/add";
urlConfig.secretList=host+"secret/list";

//物业信息相关的url
urlConfig.modifyProperty=host+"property/modify";
urlConfig.propertyList=host+"property/propertyList";
urlConfig.getOwnerInfoByPropertyID=host+"property/owner/";
urlConfig.getFeeInfoByPropertyID=host+"property/fee/";
urlConfig.addProperty=host+"property/add";
urlConfig.addVillage=host+"property/addVillage";
urlConfig.addBuilding=host+"property/addBuilding";
urlConfig.villageList=host+"property/villageList";
urlConfig.buildingList=host+"property/buildingList";
urlConfig.generateBill=host+"property/generateBill/";

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


