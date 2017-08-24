package com.ziytek.taozhu.base.util;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 类描述：
 */

public class Constant implements Serializable {

    private static final long serialVersionUID = -8606391175041072035L;
    private static Date MAX_DATE = null;
    static {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR,9999);
        calendar.set(Calendar.MONTH,11);
        calendar.set(Calendar.DATE,31);
        calendar.set(Calendar.HOUR_OF_DAY,0);
        calendar.set(Calendar.MINUTE,0);
        calendar.set(Calendar.SECOND,0);
        MAX_DATE = calendar.getTime();
    }

    public static final String SUCCESS_FLAG = "success";
    public static final String FAILED_FLAG = "failed";

    /**
     * 手机登录标识
     */
    public static final String APP_LOGIN_SUFFIX = "_APP";

    public static final String SUCCESSCODE_0000 = "0000";
    public static final String ERRCODE_V001 = "v001";
    public static final String ERRCODE_S001 = "s001";
    public static final String ERRCODE_I001 = "i001";
    public static final String ERRCODE_I002 = "i002";
    public static final String ERRCODE_U001 = "u001";
    public static final String ERRCODE_P001 = "p001";
    /**
     * 用户无权限访问
     */
    public static final String ERRCODE_R001 = "r001";
    /**
     * 查询失败
     */
    public static final String ERRCODE_Q001 = "q001";

    /**
     * 短信验证码后缀
     */
    public static final String SMSCODE_SUFFIX = "_SMSCODE";

    /**
     * 电子邮件验证码后缀
     */
    public static final String EMIALCODE_SUFFIX = "_EMAILCODE";

    /**
     * 校验验证码后缀
     */
    public static final String VERIFICATION_SUFFIX = "_VERIFICATIONCODE";

    public static final String ADD = "A";
    public static final String DELETED = "D";

    /**
     * 用户申请租户
     */
    public static final String APPLICATION = "UT";
    /**
     * 租户邀请用户
     */
    public static final String REQUEST = "TU";
    /**
     * 用户自己创建租户
     */
    public static final String SELFBUILT  = "ZC";
    /**
     * 租户用户状态：激活
     */
    public static final String ACTIVATE_USABLE = "A";
    /**
     * 租户用户状态：暂停
     */
    public static final String PAUSE_USABLE = "P";
    /**
     * 租户用户状态：停用
     */
    public static final String STOP_USABLE = "S";
    /**
     * 租户用户状态：邀请中
     */
    public static final String INVITATION_USABLE = "I";
    /**
     * 密码找回方式：邮箱
     */
    public static final String MAIL_CHANGEPWD = "M";
    /**
     * 密码找回方式：手机
     */
    public static final String SMS_CHANGEPWD = "T";
    /**
     * 密码找回方式：个人修改
     */
    public static final String SELF_CHANGEPWD = "S";
    /**
     * 人或组织：P:适用用户  O:适用组织  A:都适用
     */
    public static final String APPLY_P = "P";
    public static final String APPLY_A = "A";
    public static final String APPLY_O = "O";
    /**
     * 操作类型  operationtype:B 表示绑定  operationtype:R 表示注册
     */
    public static final String OPERATION_TYPE_R = "R";
    public static final String OPERATION_TYPE_B = "B";

    public static final String BINDEMAIL ="BINDEMAIL";
    /**
     * 获得最大日期
     * @return
     */
    public static Date getMaxDate() {
        return MAX_DATE;
    }

    /**
     *邮件链接操作类型：注册
     */
    public static final String OPRATIONTYPE_REDISTER = "R";
    /**
     * 邮件链接操作类型：绑定
     */
    public static final String OPRATIONTYPE_BOUND = "B";

    /********************************角色相关************************************/
    /**
     * 角色前缀
     */
    public static final String[] ROLE_TYPE_PREFIX = new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9",
            "a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z",
            "A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};

    /**
     * 租户管理员
     */
    public static final String ROLE_TENANT_ADMIN = "TENANT_ADMIN";

    /********************************角色相关************************************/
}
