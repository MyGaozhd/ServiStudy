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

    public static String sscneedtable = "AE_META_DRIVER;" +
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
            "UFOB_NODE_USER;" + "md_enumvalue;bd_mode_selected;" +
            "bd_uniquerule;" +
            "bd_userdefitem;" +
            "bd_formatdoc;" +
            "sm_appbusi_btn;" +
            "pub_wf_def_org;" +
            "bd_busitype;" +
            "pub_user_template;" +
            "sm_individual_property;" +
            "iufo_timingshare_task;" +
            "bd_defdoclist;" +
            "bd_defdoc;" +
            "bd_crossrule;" +
            "bd_crossrulescope;" +
            "bd_crossbusimap;" +
            "org_accountingbook;" +
            "pub_wf_checknote;" +
            "pub_workflowperson;" +
            "sm_permission_res;" +
            "sm_rule;" +
            "pub_oid;" +
            "md_enumvalue;" +
            "md_enumvalue;" +
            "md_busiactivity;" +
            "md_busiop;" +
            "md_class;" +
            "md_component;" +
            "md_opinterface;" +
            "md_property;" +
            "md_refbusiop;" +
            "md_refoperation;" +
            "md_viewcolumn;" +
            "md_accessorpara;" +
            "md_attr_table;" +
            "md_bizitfmap;" +
            "md_db_relation;" +
            "md_indexcolumn;" +
            "md_module;" +
            "md_operation;" +
            "md_parameter;" +
            "md_view;" +
            "md_association;" +
            "md_attr_busilog;" +
            "md_attr_power;" +
            "md_bean_power;" +
            "md_column;" +
            "md_comp_busimodule;" +
            "md_dev_busi_module;" +
            "md_index;" +
            "md_ormap;" +
            "md_table;" +
            "md_tree_powertype;" +
            "sm_adm_rolegrporg;" +
            "sm_adm_usrgrporg;" +
            "sm_admin_app;" +
            "sm_admin_org;" +
            "sm_admin_resource;" +
            "sm_admin_rolegroup;" +
            "sm_admin_usergroup;" +
            "sm_app_group;" +
            "sm_appbutnregister;" +
            "sm_appmenuitem;" +
            "sm_appmenureg;" +
            "sm_apppage;" +
            "sm_appparam;" +
            "sm_appregister;" +
            "sm_auto_unloading;" +
            "sm_appbusiactivereg;" +
            "sm_bdchange_reg;" +
            "sm_busiactive_permncc;" +
            "sm_busiflow_nodes;" +
            "sm_busiworkflow;" +
            "sm_busiworkflow_cell;" +
            "sm_createcorp;" +
            "sm_ctpermdetail;" +
            "sm_dpprofile_reg;" +
            "sm_flowchart_icon;" +
            "sm_gm_app;" +
            "sm_log_attribute;" +
            "sm_log_busilogrule;" +
            "sm_log_operatelogrule;" +
            "sm_metadata_rule;" +
            "sm_msg_msgtype;" +
            "sm_msg_stypebase;" +
            "sm_msg_stypeprop;" +
            "sm_msgattac_stag;" +
            "sm_ncckeyfunc;" +
            "sm_op_busiop;" +
            "sm_pageregister;" +
            "sm_paramregister;" +
            "sm_patch_version;" +
            "sm_perm_data;" +
            "sm_perm_func;" +
            "sm_permission_data;" +
            "sm_permission_res;" +
            "sm_permission_rule;" +
            "sm_product_version;" +
            "sm_pub_filesystem;" +
            "sm_res_operation;" +
            "sm_resp_app;" +
            "sm_responsibility;" +
            "sm_role;" +
            "sm_role_exclude;" +
            "sm_role_group;" +
            "sm_rule;" +
            "sm_rule_ref;" +
            "sm_rule_type;" +
            "sm_specialpermission;" +
            "sm_subject_org;" +
            "sm_themecolor;" +
            "sm_user;" +
            "sm_user_group;" +
            "sm_user_role;" +
            "sm_user_share;" +
            "sm_usergroup;" +
            "sm_workbench;" +
            "pub_actionconstrict;" +
            "pub_alertquery;" +
            "pub_alertquery_dir;" +
            "pub_alertregistry;" +
            "pub_alertregistry_org;" +
            "pub_alerttype;" +
            "pub_alerttype_b;" +
            "pub_alerttypeconfig;" +
            "pub_alertruntime;" +
            "pub_alertsendconfig;" +
            "pub_app_systemplate;" +
            "pub_area;" +
            "pub_attr_plugin;" +
            "pub_bcr_candiattr;" +
            "pub_bcr_entity;" +
            "pub_bcr_nbcr;" +
            "pub_bcr_orgrela;" +
            "pub_bcr_precode;" +
            "pub_bcr_reflect;" +
            "pub_bcr_elem;" +
            "pub_bcr_rulebase;" +
            "pub_bcr_sngenerator;" +
            "pub_billaction;" +
            "pub_billactionconfig;" +
            "pub_billactiongroup;" +
            "pub_billbackmsg;" +
            "pub_billbusiness;" +
            "pub_billflow_partner;" +
            "pub_billitfdef;" +
            "pub_billsource;" +
            "pub_billtemplet;" +
            "pub_billtemplet_b;" +
            "pub_billtemplet_t;" +
            "pub_bsexpoint;" +
            "pub_bsplugins;" +
            "pub_busiclass;" +
            "pub_eventlistener;" +
            "pub_eventtype;" +
            "pub_form_property;" +
            "pub_formdata;" +
            "pub_funccodetocode;" +
            "pub_function;" +
            "pub_generalrule;" +
            "pub_guideline;" +
            "pub_guideline_f;" +
            "pub_importregister;" +
            "pub_itfextend;" +
            "pub_messagedrive;" +
            "pub_msgres_rcv;" +
            "pub_msgres_rcvconf;" +
            "pub_msgres_reg;" +
            "pub_msgres_sfdfrcv;" +
            "pub_msgres_tmpconf;" +
            "pub_msgtemp;" +
            "pub_msgtemp_type;" +
            "pub_msgtemp_var;" +
            "pub_multilang;" +
            "pub_ncc_queryscheme;" +
            "pub_oid;" +
            "pub_page_templet;" +
            "pub_pluginitem;" +
            "pub_print_cell;" +
            "pub_print_dataitem;" +
            "pub_print_datasource;" +
            "pub_print_line;" +
            "pub_print_region;" +
            "pub_print_template;" +
            "pub_print_variable;" +
            "pub_printlimit;" +
            "pub_printpara;" +
            "pub_psn_matrix;" +
            "pub_psn_reg;" +
            "pub_psn_resource;" +
            "pub_publishapp;" +
            "pub_query_condition;" +
            "pub_query_property;" +
            "pub_query_sysfunc;" +
            "pub_query_templet;" +
            "pub_queryscheme;" +
            "pub_refenum;" +
            "pub_report_group;" +
            "pub_report_model;" +
            "pub_report_templet;" +
            "pub_riafbaction;" +
            "pub_riawftxsetup;" +
            "pub_sign;" +
            "pub_sysinit;" +
            "pub_sysinit_power;" +
            "pub_sysinittemp;" +
            "pub_systemp_audit;" +
            "pub_systemplate;" +
            "pub_systemplate_base;" +
            "pub_template_assignment;" +
            "pub_timeconfig;" +
            "pub_ufgraph;" +
            "pub_vochange;" +
            "pub_vochange_b;" +
            "pub_vochange_s;" +
            "pub_vosplititem;" +
            "pub_wf_alertctrl;" +
            "pub_wf_def;" +
            "pub_wf_def_templte;" +
            "pub_wf_parameter;" +
            "pub_wf_participant;" +
            "pub_wf_participantex;" +
            "pub_wf_termsetting;" +
            "pub_wfdef_ref;" +
            "pub_wfgadget_b;" +
            "pub_wfgroup;" +
            "pub_wfgroup_b;" +
            "pub_workflowagent;" +
            "pub_workflowgadget;" +
            "pub_workitemconfig;" +
            "bd_cachetabversion;" +
            "dap_dapsystem;" +
            "bd_refinfo;" +
            "gw_tenantinfo;" +
            "bd_billtype2;" +
            "bd_billtype;" +
            "BD_FWDBILLTYPE;" +
            "BD_RELATEDAPP;" +
            "om_post;" +
            "ORG_ORGS_V;" +
            "ORG_FINANCEORG;" +
            "ORG_FINANCEORG_V;" +
            "ORG_SETOFBOOK;" +
            "bd_currtype;" +
            "ORG_CORP;" +
            "ORG_CORP_V;" +
            "bd_workcalendar;" +
            "bd_workcalendardate;" +
            "bd_workcalendyear;" +
            "ORG_GROUP;" +
            "ORG_ORGS;" +
            "ORG_ORGS_V;" +
            "ORG_ORGTYPE;" +
            "ORG_DEPT;" +
            "ORG_DEPT_V;" +
            "BD_SUPPLIER;" +
            "bd_cust_supplier;" +
            "bd_bankaccsub;" +
            "BD_CUSTOMER;" +
            "BD_MATERIAL;" +
            "BD_MATERIAL_V;" +
            "BD_PSNDOC;" +
            "BD_PSNjob;" +
            "bd_bankdoc;" +
            "bd_banktype;" +
            "bd_measdoc;" +
            "sm_user_ex;" +
            "org_sscbusiunitclientage;" +
            "bd_userdefruleref;" +
            "bd_userdefrule;" +
            "bd_sharebilltype;" +
            "bd_scanconvertor;" +
            "bd_scanbilltypeinfo;" +
            "bd_cr_resource;" +
            "bd_inoutbusiclass;" +
            "bd_psnjob;" +
            "bd_suporg;" +
            "bd_taxcode;" +
            "bd_taxrate;" +
            "org_orgmanager;" +
            "sm_busilog_default;" +
            "sm_log_operatelog;" +
            "sm_log_unloading;" +
            "sm_msg_approve;" +
            "sm_msg_attachment;" +
            "sm_msg_notice;" +
            "sm_msg_prealert;" +
            "sm_msg_todo;" +
            "sm_msg_user;" +
            "pub_alertmessage;" +
            "pub_async;" +
            "pub_async_result;" +
            "pub_bcr_return;" +
            "pub_bcr_sn;" +
            "pub_wf_actinstance;" +
            "pub_wf_actinstancesrc;" +
            "pub_wf_def_adjust;" +
            "pub_wf_instance;" +
            "pub_wf_instance_b;" +
            "pub_wf_instance_h;" +
            "pub_wf_messagemeta;" +
            "pub_wf_rejectreason;" +
            "pub_wf_task;" +
            "pub_wf_taskreceiver;" +
            "pub_wf_txmark;" +
            "pub_wfexptlog;" +
            "pub_workflownote;" +
            "pub_workflownote_att;" +
            "pub_workingtasklog;" +
            "pub_workitemappoint;" +
            "pub_printinfo;" +
            "pub_printlog;" +
            "pub_printnumber;" +
            "pub_nccfs_file;bd_ref_relation;bd_uniquerule_item;bd_custbank";

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
