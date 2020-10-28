package com.servi.study.ora._02_renametable;

import com.servi.study.json.IJsonUtil;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author servi
 * @date 2020/8/22
 */
public class TablesDefine {

    public static String sscneedtable = "MD_ENUMVALUE;" +
            "MD_BUSIACTIVITY;" +
            "MD_BUSIOP;" +
            "MD_CLASS;" +
            "MD_COMPONENT;" +
            "MD_OPINTERFACE;" +
            "MD_PROPERTY;" +
            "MD_REFBUSIOP;" +
            "MD_REFOPERATION;" +
            "MD_VIEWCOLUMN;" +
            "MD_ACCESSORPARA;" +
            "MD_ATTR_TABLE;" +
            "MD_BIZITFMAP;" +
            "MD_DB_RELATION;" +
            "MD_INDEXCOLUMN;" +
            "MD_MODULE;" +
            "MD_OPERATION;" +
            "MD_PARAMETER;" +
            "MD_VIEW;" +
            "MD_ASSOCIATION;" +
            "MD_ATTR_BUSILOG;" +
            "MD_ATTR_POWER;" +
            "MD_BEAN_POWER;" +
            "MD_COLUMN;" +
            "MD_COMP_BUSIMODULE;" +
            "MD_DEV_BUSI_MODULE;" +
            "MD_INDEX;" +
            "MD_ORMAP;" +
            "MD_TABLE;" +
            "MD_TREE_POWERTYPE;" +
            "SM_ADM_ROLEGRPORG;" +
            "SM_ADM_USRGRPORG;" +
            "SM_ADMIN_APP;" +
            "SM_ADMIN_ORG;" +
            "SM_ADMIN_RESOURCE;" +
            "SM_ADMIN_ROLEGROUP;" +
            "SM_ADMIN_USERGROUP;" +
            "SM_APP_GROUP;" +
            "SM_APPBUTNREGISTER;" +
            "SM_APPMENUITEM;" +
            "SM_APPMENUREG;" +
            "SM_APPPAGE;" +
            "SM_APPPARAM;" +
            "SM_APPREGISTER;" +
            "SM_AUTO_UNLOADING;" +
            "SM_APPBUSIACTIVEREG;" +
            "SM_BDCHANGE_REG;" +
            "SM_BUSIACTIVE_PERMNCC;" +
            "SM_BUSIFLOW_NODES;" +
            "SM_BUSIWORKFLOW;" +
            "SM_BUSIWORKFLOW_CELL;" +
            "SM_CREATECORP;" +
            "SM_CTPERMDETAIL;" +
            "SM_DPPROFILE_REG;" +
            "SM_FLOWCHART_ICON;" +
            "SM_GM_APP;" +
            "SM_LOG_ATTRIBUTE;" +
            "SM_LOG_BUSILOGRULE;" +
            "SM_LOG_OPERATELOGRULE;" +
            "SM_METADATA_RULE;" +
            "SM_MSG_MSGTYPE;" +
            "SM_MSG_STYPEBASE;" +
            "SM_MSG_STYPEPROP;" +
            "SM_MSGATTAC_STAG;" +
            "SM_NCCKEYFUNC;" +
            "SM_OP_BUSIOP;" +
            "SM_PAGEREGISTER;" +
            "SM_PARAMREGISTER;" +
            "SM_PATCH_VERSION;" +
            "SM_PERM_DATA;" +
            "SM_PERM_FUNC;" +
            "SM_PERMISSION_DATA;" +
            "SM_PERMISSION_RES;" +
            "SM_PERMISSION_RULE;" +
            "SM_PRODUCT_VERSION;" +
            "SM_PUB_FILESYSTEM;" +
            "SM_RES_OPERATION;" +
            "SM_RESP_APP;" +
            "SM_RESPONSIBILITY;" +
            "SM_ROLE;" +
            "SM_ROLE_EXCLUDE;" +
            "SM_ROLE_GROUP;" +
            "SM_RULE;" +
            "SM_RULE_REF;" +
            "SM_RULE_TYPE;" +
            "SM_SPECIALPERMISSION;" +
            "SM_SUBJECT_ORG;" +
            "SM_THEMECOLOR;" +
            "SM_USER;" +
            "SM_USER_GROUP;" +
            "SM_USER_ROLE;" +
            "SM_USER_SHARE;" +
            "SM_USERGROUP;" +
            "SM_WORKBENCH;" +
            "PUB_ACTIONCONSTRICT;" +
            "PUB_ALERTQUERY;" +
            "PUB_ALERTQUERY_DIR;" +
            "PUB_ALERTREGISTRY;" +
            "PUB_ALERTREGISTRY_ORG;" +
            "PUB_ALERTTYPE;" +
            "PUB_ALERTTYPE_B;" +
            "PUB_ALERTTYPECONFIG;" +
            "PUB_ALERTRUNTIME;" +
            "PUB_ALERTSENDCONFIG;" +
            "PUB_APP_SYSTEMPLATE;" +
            "PUB_AREA;" +
            "PUB_ATTR_PLUGIN;" +
            "PUB_BCR_CANDIATTR;" +
            "PUB_BCR_ENTITY;" +
            "PUB_BCR_NBCR;" +
            "PUB_BCR_ORGRELA;" +
            "PUB_BCR_PRECODE;" +
            "PUB_BCR_REFLECT;" +
            "PUB_BCR_ELEM;" +
            "PUB_BCR_RULEBASE;" +
            "PUB_BCR_SNGENERATOR;" +
            "PUB_BILLACTION;" +
            "PUB_BILLACTIONCONFIG;" +
            "PUB_BILLACTIONGROUP;" +
            "PUB_BILLBACKMSG;" +
            "PUB_BILLBUSINESS;" +
            "PUB_BILLFLOW_PARTNER;" +
            "PUB_BILLITFDEF;" +
            "PUB_BILLSOURCE;" +
            "PUB_BILLTEMPLET;" +
            "PUB_BILLTEMPLET_B;" +
            "PUB_BILLTEMPLET_T;" +
            "PUB_BSEXPOINT;" +
            "PUB_BSPLUGINS;" +
            "PUB_BUSICLASS;" +
            "PUB_EVENTLISTENER;" +
            "PUB_EVENTTYPE;" +
            "PUB_FORM_PROPERTY;" +
            "PUB_FORMDATA;" +
            "PUB_FUNCCODETOCODE;" +
            "PUB_FUNCTION;" +
            "PUB_GENERALRULE;" +
            "PUB_GUIDELINE;" +
            "PUB_GUIDELINE_F;" +
            "PUB_IMPORTREGISTER;" +
            "PUB_ITFEXTEND;" +
            "PUB_MESSAGEDRIVE;" +
            "PUB_MSGRES_RCV;" +
            "PUB_MSGRES_RCVCONF;" +
            "PUB_MSGRES_REG;" +
            "PUB_MSGRES_SFDFRCV;" +
            "PUB_MSGRES_TMPCONF;" +
            "PUB_MSGTEMP;" +
            "PUB_MSGTEMP_TYPE;" +
            "PUB_MSGTEMP_VAR;" +
            "PUB_MULTILANG;" +
            "PUB_NCC_QUERYSCHEME;" +
            "PUB_PAGE_TEMPLET;" +
            "PUB_PLUGINITEM;" +
            "PUB_PRINT_CELL;" +
            "PUB_PRINT_DATAITEM;" +
            "PUB_PRINT_DATASOURCE;" +
            "PUB_PRINT_LINE;" +
            "PUB_PRINT_REGION;" +
            "PUB_PRINT_TEMPLATE;" +
            "PUB_PRINT_VARIABLE;" +
            "PUB_PRINTLIMIT;" +
            "PUB_PRINTPARA;" +
            "PUB_PSN_MATRIX;" +
            "PUB_PSN_REG;" +
            "PUB_PSN_RESOURCE;" +
            "PUB_PUBLISHAPP;" +
            "PUB_QUERY_CONDITION;" +
            "PUB_QUERY_PROPERTY;" +
            "PUB_QUERY_SYSFUNC;" +
            "PUB_QUERY_TEMPLET;" +
            "PUB_QUERYSCHEME;" +
            "PUB_REFENUM;" +
            "PUB_REPORT_GROUP;" +
            "PUB_REPORT_MODEL;" +
            "PUB_REPORT_TEMPLET;" +
            "PUB_RIAFBACTION;" +
            "PUB_RIAWFTXSETUP;" +
            "PUB_SIGN;" +
            "PUB_SYSINIT;" +
            "PUB_SYSINIT_POWER;" +
            "PUB_SYSINITTEMP;" +
            "PUB_SYSTEMP_AUDIT;" +
            "PUB_SYSTEMPLATE;" +
            "PUB_SYSTEMPLATE_BASE;" +
            "PUB_TEMPLATE_ASSIGNMENT;" +
            "PUB_TIMECONFIG;" +
            "PUB_UFGRAPH;" +
            "PUB_VOCHANGE;" +
            "PUB_VOCHANGE_B;" +
            "PUB_VOCHANGE_S;" +
            "PUB_VOSPLITITEM;" +
            "PUB_WF_ALERTCTRL;" +
            "PUB_WF_DEF;" +
            "PUB_WF_DEF_TEMPLTE;" +
            "PUB_WF_PARAMETER;" +
            "PUB_WF_PARTICIPANT;" +
            "PUB_WF_PARTICIPANTEX;" +
            "PUB_WF_TERMSETTING;" +
            "PUB_WFDEF_REF;" +
            "PUB_WFGADGET_B;" +
            "PUB_WFGROUP;" +
            "PUB_WFGROUP_B;" +
            "PUB_WORKFLOWAGENT;" +
            "PUB_WORKFLOWGADGET;" +
            "PUB_WORKITEMCONFIG;" +
            "BD_CACHETABVERSION;" +
            "DAP_DAPSYSTEM;" +
            "BD_REFINFO;" +
            "GW_TENANTINFO;" +
            "BD_MODE_SELECTED;" +
            "BD_UNIQUERULE;" +
            "BD_USERDEFITEM;" +
            "BD_FORMATDOC;" +
            "SM_APPBUSI_BTN;" +
            "PUB_WF_DEF_ORG;" +
            "BD_BUSITYPE;" +
            "PUB_USER_TEMPLATE;" +
            "SM_INDIVIDUAL_PROPERTY;" +
            "IUFO_TIMINGSHARE_TASK;" +
            "BD_DEFDOCLIST;" +
            "BD_DEFDOC;" +
            "AE_META_DRIVER;" +
            "AE_OLAP_CUBE;" +
            "AE_OLAP_DIM;" +
            "AE_OLAP_FLT;" +
            "AE_OLAP_HCY;" +
            "AE_OLAP_LVL;" +
            "AE_OLAP_LVLP;" +
            "AE_OLAP_MEA;" +
            "AE_OLAP_MEAP;" +
            "AE_OLAP_PARAM;" +
            "AE_OLAP_RLN;" +
            "AE_QUALITYCHECK;" +
            "AE_RELATION;" +
            "AE_RELATION_DI;" +
            "AE_RELATION_DIM;" +
            "AE_RELATION_SMT;" +
            "BI_BQTHIRDPARTYPLUGIN_DEF;" +
            "BI_BQTHIRDPARTYPLUGIN_FILE;" +
            "BI_CALC_DEF;" +
            "BI_CALC_DIR;" +
            "BI_CUBE_DEF;" +
            "BI_CUBE_DIR;" +
            "BI_DASHBOARD_DEF;" +
            "BI_DASHBOARD_DEF_BAK;" +
            "BI_DASHBOARD_DIR;" +
            "BI_LINK_DEF;" +
            "BI_LINK_DIR;" +
            "BI_LINK_MODEL;" +
            "BI_MD_COLUMN;" +
            "BI_MD_DIR;" +
            "BI_MD_TABLE;" +
            "BI_MOBILE_PUBLISH_DEF;" +
            "BI_MOBILE_PUBLISH_DIR;" +
            "BI_MOBILE_PUBLISH_HOMEPAGE_DEF;" +
            "BI_MOBILE_SHOW_HOMEPAGE_DEF;" +
            "BI_OPENBQ_MONITOR;" +
            "BI_OPENBQ_SERVERINFO;" +
            "BI_PIVOT_DEF;" +
            "BI_PIVOT_DIR;" +
            "BI_PIVOT_SEARCH;" +
            "BI_REPORT_MANAGE;" +
            "BI_SCHD_HOST;" +
            "BI_SCHD_JOBQUEUE;" +
            "BI_SCHD_MODULE;" +
            "BI_SCHD_PARAMETER;" +
            "BI_SCHD_PERFLOG;" +
            "BI_SCHD_TASKQUEUE;" +
            "BI_SCHD_TEMPTABLE;" +
            "BI_SCHD_TIMER;" +
            "BI_SCHEMA_ENV;" +
            "BI_SMART_DEF;" +
            "BI_SMART_DIR;" +
            "BI_SMART_FILTER;" +
            "BI_SMART_MACRO;" +
            "BI_SUBSCRIBE_DEF;" +
            "BI_SUBSCRIBE_DIR;" +
            "BQ_PERMISSION;" +
            "FIBA_DATAMODELCLASS;" +
            "FIBA_MODELDESIGN;" +
            "IUFO_FREEREPORT;" +
            "IUFO_FREEREP_DIR;" +
            "IUFO_FREE_USERINDIV;" +
            "IUFO_FUNC_DEMO;" +
            "IUFO_GRAPHIC_DIRECTORY;" +
            "IUFO_GRAPHIC_EXTREGISTER;" +
            "IUFO_GRAPHIC_GRAPH;" +
            "IUFO_GRAPHIC_GRAPHPROPERTY;" +
            "IUFO_GRAPHIC_NCCTOKEN;" +
            "IUFO_GRAPHIC_QUERYEXTREGISTER;" +
            "IUFO_GRAPHIC_STORYBOARD;" +
            "IUFO_GRAPHIC_STORYBOARDLINK;" +
            "IUFO_GRAPHIC_STORYBOARDMEMBER;" +
            "IUFO_GRAPHIC_STORYBOARDMULLINK;" +
            "IUFO_LIGHTSUBSCIBE_TASK;" +
            "IUFO_LIGHT_JOB;" +
            "IUFO_LIGHT_SUBTASK_INSTANCE;" +
            "IUFO_MY_REPORT;" +
            "IUFO_PUBCASEDEFINE;" +
            "IUFO_QUERYCASEDEFINE;" +
            "IUFO_REPCONDS_CONFIG;" +
            "IUFO_REPLIB_DETAIL;" +
            "IUFO_REPLIB_LIST;" +
            "IUFO_REPLIB_SORT;" +
            "IUFO_REPPUBLISH;" +
            "IUFO_SUBSCIBE_EMBRACER;" +
            "IUFO_SUBSCIBE_TASK;" +
            "IUFO_SUBSCIBE_TASK_DATA;" +
            "IUFO_TASK_DATA_INSTANCE;" +
            "IUFO_TIMINGSHARE_TASK;" +
            "IUFO_TRACEDATADISPATCH;" +
            "IUFO_TRACEDATAREGISTER;" +
            "REPORT_COLLECTION;" +
            "REPORT_DATAMODEL;" +
            "REPORT_DEFDIM;" +
            "REPORT_MODELFIELD;" +
            "REPORT_QUERYCONDITION;" +
            "REPORT_RECUSE;" +
            "REPORT_REPORTCLASS;" +
            "REPORT_REPORTDETAIL;" +
            "REPORT_REPORTLINK;" +
            "REPORT_REPORTOBJECT;" +
            "REPORT_REPORTPUBLISH;" +
            "REPORT_REPORTSTYLE;" +
            "SMARTBA_DIRRELATION;" +
            "SMARTBA_PRESETDATA;" +
            "UFOB_NODE_ORDER;" +
            "UFOB_NODE_SCHEMA;" +
            "UFOB_NODE_USER;" +
            "BD_BILLTYPE2;" +
            "BD_BILLTYPE;" +
            "BD_FWDBILLTYPE;" +
            "BD_RELATEDAPP;" +
            "OM_POST;" +
            "ORG_ORGS_V;" +
            "ORG_FINANCEORG;" +
            "ORG_FINANCEORG_V;" +
            "ORG_SETOFBOOK;" +
            "BD_CURRTYPE;" +
            "ORG_CORP;" +
            "ORG_CORP_V;" +
            "BD_WORKCALENDAR;" +
            "BD_WORKCALENDARDATE;" +
            "BD_WORKCALENDYEAR;" +
            "ORG_GROUP;" +
            "ORG_ORGS;" +
            "ORG_ORGS_V;" +
            "ORG_ORGTYPE;" +
            "ORG_DEPT;" +
            "ORG_DEPT_V;" +
            "BD_SUPPLIER;" +
            "BD_CUST_SUPPLIER;" +
            "BD_BANKACCSUB;" +
            "BD_CUSTOMER;" +
            "BD_MATERIAL;" +
            "BD_MATERIAL_V;" +
            "BD_PSNDOC;" +
            "BD_BANKDOC;" +
            "BD_BANKTYPE;" +
            "BD_MEASDOC;" +
            "SM_USER_EX;" +
            "ORG_SSCBUSIUNITCLIENTAGE;" +
            "BD_USERDEFRULEREF;" +
            "BD_USERDEFRULE;" +
            "BD_SHAREBILLTYPE;" +
            "BD_SCANCONVERTOR;" +
            "BD_SCANBILLTYPEINFO;" +
            "BD_IMAGESCANTYPE;" +
            "BD_CR_RESOURCE;" +
            "BD_INOUTBUSICLASS;" +
            "BD_PSNJOB;" +
            "BD_SUPORG;" +
            "BD_TAXCODE;" +
            "BD_TAXRATE;" +
            "ORG_ORGMANAGER;" +
            "BD_CROSSRULE;" +
            "BD_CROSSRULESCOPE;" +
            "BD_CROSSBUSIMAP;" +
            "ORG_ACCOUNTINGBOOK;" +
            "PUB_WF_CHECKNOTE;" +
            "PUB_WORKFLOWPERSON;" +
            "BD_COUNTRYZONE;" +
            "BD_ADDRESS;" +
            "BD_REGION;" +
            "BD_BALATYPE ;" +
            "BD_BILLTYPE2_CROSSSERVICE;" +
            "BD_REF_RELATION;" +
            "BD_UNIQUERULE_ITEM;" +
            "BD_CUSTBANK;" +
            "SM_USER_DEFAULTPWD;" +
            "WFM_ACCEPTNCTYPE;" +
            "PUB_INSTANCE_DEF;" +
            "ORG_UAGROUP;"+"PUB_OID;PUB_BCR_SN";

    public static String ssctable = "imag_basefactory;" +
            "imag_billmapping;" +
            "imag_lookupclass;" +
            "image_rescan;" +
            "bd_imagescansetup;" +
            "image_state;" +
            "IMAGETEMPTABLE;" +
            "imag_receiver;" +
            "imag_task;" +
            "imag_ocr_record;" +
            "bd_scanbilltypeinfo;" +
            "bd_scanconvertor;" +
            "imag_verify_record;" +
            "ssc_mqerrorinfo;" +
            "ssc_mqkeytransfer;" +
            "ssc_mqreq;" +
            "sscivm_billfield;" +
            "sscivm_billtype;" +
            "sscivm_inv_ina_relation;" +
            "sscivm_invoice;" +
            "sscivm_invoicedetail;" +
            "sscivm_invoice_air;" +
            "sscivm_invoice_airdetail;" +
            "sscivm_invoice_bus;" +
            "sscivm_invoice_quota;" +
            "sscivm_invoice_relation;" +
            "sscivm_invoice_roadtoll;" +
            "sscivm_invoice_status_task;" +
            "sscivm_invoice_task_log;" +
            "sscivm_invoice_taxi;" +
            "sscivm_invoice_train;" +
            "sscivm_invoice_voucher_bill;" +
            "sscivm_invoicetype;" +
            "sscivm_ivappdetail;" +
            "sscivm_ivapplication;" +
            "sscivm_ivapplog;" +
            "sscrp_billtransmit_log;" +
            "sscrp_invoice;" +
            "sscrp_invoicedetail;" +
            "sscrp_invoice_relation;" +
            "sscrp_invoice_status_task;" +
            "sscrp_invoice_task_log;" +
            "sscrp_refreshaction;" +
            "sscrp_detail;" +
            "sscrp_bill;" +
            "sscrp_busiclass;" +
            "sscrp_busiclass_b;" +
            "sscrp_detail_done;" +
            "sscrp_bill_done;" +
            "sscrp_detail_temp;" +
            "sscrp_bill_temp;" +
            "sscrp_fieldmap;" +
            "sscrp_fieldmap_b;" +
            "sscrp_publicfield;" +
            "sscrp_usermenu;" +
            "ssc_activetask;" +
            "ssc_billapprovestatus;" +
            "ssc_billitemmap;" +
            "ssc_billlandmarkstatevo;" +
            "ssc_busiactivity;" +
            "ssc_busi_act_op;" +
            "org_sscbusinessunittype;" +
            "org_sscbusiunitclientage;" +
            "ssc_busioperation;" +
            "bd_imagescantype;" +
            "ssc_jumpconfiguration;" +
            "ssc_laderule;" +
            "ssc_laderule_b;" +
            "ssc_managelevel;" +
            "ssc_persontask;" +
            "ssc_exclusion;" +
            "ssc_posttask;" +
            "org_sscorg;" +
            "org_sscorg_v;" +
            "ssc_billorg;" +
            "ssc_allotrule_b;" +
            "ssc_allotrule;" +
            "sscbd_apply_scope;" +
            "sscbd_point;" +
            "sscbd_point_item;" +
            "sscbd_point_class;" +
            "sscbd_point_rule;" +
            "sscbd_problem_class;" +
            "sscbd_problem_matter;" +
            "ssc_busigroup;" +
            "ssc_dailyreport;" +
            "org_ssclientage;" +
            "ssc_monthreport;" +
            "ssc_ssctask;" +
            "ssc_ssctasklog;" +
            "org_ssctype;" +
            "ssc_taskstate;" +
            "ssc_busiinfo;" +
            "ssc_wfbusioperator;" +
            "ssc_wflandmarkstate;" +
            "ssckm_authority;" +
            "ssckm_classify;" +
            "ssckm_knowledge;" +
            "ssckm_menutip;" +
            "ssckm_relation;" +
            "sscpfm_bgimage;" +
            "sscpfm_billtype;" +
            "sscpfm_center_config;" +
            "sscpfm_datatransform_conf;" +
            "sscpfm_datatransform_log;" +
            "sscpfm_datetable;" +
            "sscpfm_flowpath;" +
            "sscpfm_kpi_group;" +
            "sscpfm_kpi_template;" +
            "sscpfm_kpi_view;" +
            "sscpfm_now_num;" +
            "sscpfm_org_billtype_num;" +
            "sscpfm_orgarea;" +
            "sscpfm_other_charts_login;" +
            "sscpfm_post;" +
            "sscpfm_postallot;" +
            "sscpfm_register;" +
            "sscpfm_task;" +
            "sscpfm_theme;" +
            "sscpfm_timetable;" +
            "sscpfm_unit;" +
            "sscpfm_user;" +
            "sscpfm_user_num;" +
            "sscqm_ag_article;" +
            "sscqm_ag_template;" +
            "sscqm_check_bill;" +
            "sscqm_check_bill_operation;" +
            "sscqm_check_bill_point;" +
            "sscqm_check_bill_problem;" +
            "sscqm_check_report;" +
            "sscqm_check_report_problem;" +
            "sscqm_check_task;" +
            "sscqm_check_task_condition;" +
            "sscqm_check_task_condition_sub;" +
            "sscqm_check_task_content;" +
            "sscsfm_evaluated_detail;" +
            "sscsfm_evaluated;" +
            "sscsfm_evaluation_dimension;" +
            "sscsfm_evaluation_rule;" +
            "sscsfm_evaluation_rule_detail;" +
            "sscsfm_unevaluate;" +
            "sscsfm_unsatisfied_reason;" +
            "ssctp_comparison_result;" +
            "ssctp_points_result;" +
            "ssctp_problem_result;" +
            "ssctp_accessoryshow;" +
            "ssctp_allotrule_b;" +
            "ssctp_allotrule;" +
            "ssctp_approve_log;" +
            "ssctp_approvemonitor;" +
            "ssctp_approverule;" +
            "ssctp_approverule_b;" +
            "ssctp_clientage;" +
            "ssctp_detailopen;" +
            "ssctp_dutystatelog;" +
            "ssctp_eventlistener;" +
            "ssctp_taskmap;" +
            "ssctp_idispatchusers;" +
            "ssctp_imagshow;" +
            "ssctp_intellidispatchlog;" +
            "ssctp_intellidispatchrule;" +
            "ssctp_intellidispatchrule_b;" +
            "ssctp_ots;" +
            "ssctp_printrule_head;" +
            "ssctp_printrule_body;" +
            "ssctp_priority;" +
            "ssctp_ranking;" +
            "ssctp_laderule_b;" +
            "ssctp_laderule;" +
            "ssctp_node;" +
            "ssctp_currenttask;" +
            "ssctp_taskextendinfo;" +
            "ssctp_task;" +
            "ssctp_flowpath;" +
            "ssctp_unit;" +
            "ssctp_tasktype;" +
            "ssctp_voucheropen;" +
            "ssctp_workflowuser;" +
            "ssctp_workinggroup;" +
            "ssctp_workinggroup_user;" +
            "ssc_fbannexpermissions;" +
            "ssc_fbbusiaction;" +
            "pub_ncwebpubbsplugin;" +
            "ssc_fbtransconfig;" +
            "ssc_fbtranslog;" +
            "LFW_ZDYDJ;" +
            "LFW_ZDYDJ_B;" +
            "pub_riafbaction;" +
            "pub_riawftxsetup;" +
            "cp_menuitem;" +
            "cp_faq;" +
            "cp_gz_condition;" +
            "cp_resource;" +
            "cp_doc_sysattrtype;" +
            "cp_orgaccredit;" +
            "cp_print_template;" +
            "cp_res;" +
            "cp_print_condition;" +
            "cp_templatedept;" +
            "cp_psndoc;" +
            "cp_rolegroup;" +
            "cp_datacopy;" +
            "cp_filelock;" +
            "cp_doc_objrel;" +
            "cp_queryscheme;" +
            "cp_sysinittemp;" +
            "cp_role;" +
            "cp_doc;" +
            "cp_roleorg;" +
            "cp_templateorg;" +
            "cp_appsnode;" +
            "cp_eventlistener;" +
            "cp_doc_attr;" +
            "cp_templateuser;" +
            "cp_psnjob;" +
            "cp_datacopyconfig;" +
            "cp_orgs;" +
            "cp_scancfg;" +
            "cp_dsconfig;" +
            "cp_resaccredit;" +
            "cp_device;" +
            "cp_ldapimportcfg;" +
            "cp_subfunc;" +
            "cp_rulescheme;" +
            "cp_appscategory;" +
            "cp_doc_effect;" +
            "cp_user;" +
            "cp_usergrouprole;" +
            "cp_doc_sysattr;" +
            "cp_module;" +
            "cp_doc_list;" +
            "cp_resp_func;" +
            "cp_doc_type;" +
            "cp_freenode;" +
            "cp_menucategory;" +
            "cp_sysinit;" +
            "cp_query_template;" +
            "cp_gz_template;" +
            "cp_relappsnode;" +
            "cp_roleres;" +
            "cp_templaterole;" +
            "cp_resp_res;" +
            "cp_responsibility;" +
            "cp_usergroup;" +
            "cp_usergroupuser;" +
            "cp_userrole;" +
            "cp_eventtype;" +
            "cp_rolefunnode;" +
            "cp_query_condition;" +
            "cp_roleresp;";

    public static void main(String[] args) {
        String stable[] = TablesDefine.ssctable.split(";");
        for (String t : stable) {
            t = t.toLowerCase();
            System.out.println("alter table " + t + " rename to " + t + "_s_" + ";");
        }

//        String s = Test.get();
//        Map<String, String> map = IJsonUtil.fromJson(Map.class, s);
//
//        System.out.println(IJsonUtil.toJson(map));
    }
}
