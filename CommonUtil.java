package com.ziytek.taozhu.base.util;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.URL;
import java.net.UnknownHostException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 工具类
 *
 * @author zhanggl
 * @version 1.0 2011-12-19
 */
public class CommonUtil {
    private static final Logger logger = LoggerFactory.getLogger(CommonUtil.class);

    private static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";

    private static final String  RANDOMCODE_SOURCE = "0123456789";

    /**
     * 判断对象是否为空
     *
     * @param obj
     * @return 是 == true，不是 == false
     */
    public static boolean isEmptyStr(Object obj) {
        return (obj == null || "null".equalsIgnoreCase((obj + "").trim()) || "".equals((obj + "").trim()));
    }

    /**
     * 判断集合是否为空
     *
     * @param coll
     * @return
     */
    public static boolean isEmpty(Collection<? extends Object> coll) {
        if (null == coll || coll.isEmpty()) {
            return true;
        }
        return false;
    }

    /**
     * 判断字符串是否符合指定格式的日期
     *
     * @param dateStr
     * @param format
     * @return
     * @see [类、类#方法、类#成员]
     */
    public static Date convert2Date(String dateStr, String format) {
        try {
            SimpleDateFormat df = new SimpleDateFormat(format);
            return df.parse(dateStr);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 转换默认格式(yyyy-MM-dd HH:mm:ss)的时间字符串为秒
     *
     * @param dateStr
     * @return
     */
    public static long convertTimeToLong(String dateStr) {
        long time = convertTimeToLong(dateStr, DATE_FORMAT);

        return time;
    }

    /**
     * 将字符型时间按照指定格式转换成秒
     *
     * @param dateStr    字符型时间，例如2009-01-09 10:12:10
     * @param dateFormat 日期格式，例如上面的时间格式是：yyyy-MM-dd HH:mm:ss
     * @return Long型时间
     */
    public static long convertTimeToLong(String dateStr, String dateFormat) {
        if (isEmptyStr(dateStr)) {
            return 0;
        } else {
            SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
            long date = 0;
            try {
                Date d = sdf.parse(dateStr);
                date = d.getTime() / 1000;
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            return date;
        }
    }

    /**
     * 将绝对秒数时间转换成字符串
     *
     * @param date
     * @return
     */
    public static String convertTimeToStr(Long date) {
        String time = convertTimeToStr(date, DATE_FORMAT);

        return time;
    }

    /**
     * 将绝对秒数时间转换成日期
     *
     * @param date
     * @return
     */
    public static Date convertTimeToDate(Long date) {
        String time = CommonUtil.convertTimeToStr(date);
        SimpleDateFormat format = new SimpleDateFormat(DATE_FORMAT);
        try {
            return format.parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 将绝对秒数时间转换成字符型时间
     *
     * @param date       long型时间（<b>秒</b>级的）
     * @param dateFormat 转换的时间格式，例如yyyy-MM-dd HH:mm:ss 具体转换成什么格式由开发者自己定制
     * @return 字符型时间样式
     */
    public static String convertTimeToStr(Long date, String dateFormat) {
        if (null == date) {
            return "";
        }
        Timestamp t = new Timestamp(date * 1000);
        SimpleDateFormat sDateFormat = new SimpleDateFormat(dateFormat);
        return sDateFormat.format(t);
    }

    /**
     * 日期转换成秒
     *
     * @param date
     * @return
     */
    public static long convertDate2Long(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        long s = c.getTimeInMillis() / 1000;
        return s;
    }

    /**
     * 日期转换成字符串
     *
     * @param date
     * @param format 格式
     * @return
     */
    public static String convertDate2Str(Date date, String format) {
        SimpleDateFormat sfg = new SimpleDateFormat(format);
        return sfg.format(date);
    }

    /**
     * 获取当前时间绝对秒数
     *
     * @return
     */
    public static long getCurrentSecondTime() {
        return (System.currentTimeMillis() / 1000L);
    }

    /**
     * 返回当前时间的小时
     *
     * @return
     * @see [类、类#方法、类#成员]
     */
    public static int getCurrentHour() {
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        return c.get(Calendar.HOUR_OF_DAY);
    }

    /**
     * 获取当前时间绝对毫秒数
     *
     * @return
     */
    public static long getCurrentMillSecTime() {
        return System.currentTimeMillis();
    }

    /**
     * 获取距离当前时间几天后的日期字符串
     *
     * @param day
     * @param pattern
     * @return
     */
    public static String getSepDayTimeFromNow(int day, String pattern) {
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.add(Calendar.DAY_OF_MONTH, day);
        Date date = c.getTime();
        return convertDate2Str(date, pattern);
    }

    /**
     * 获取某两个时间范围内的日期
     *
     * @param startTime 精确到秒的开始时间
     * @param endTime   精确到秒的结束时间
     * @param pattern   日期格式
     * @param type      1表示天，2表示小时,3表示分钟
     * @return
     * @see [类、类#方法、类#成员]
     */
    public static List<String> getBetweenDates(long startTime, long endTime, String pattern, int type) {
        List<String> dates = new ArrayList<String>();
        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(startTime);
        Date date = c.getTime();
        String dateStr = convertDate2Str(date, pattern);
        dates.add(dateStr);
        while (true) {
            if (type == 1) {
                c.add(Calendar.DAY_OF_MONTH, 1);
            } else if (type == 2) {
                c.add(Calendar.HOUR_OF_DAY, 1);
            } else if (type == 3) {
                c.add(Calendar.MINUTE, 1);
            }
            long time = c.getTimeInMillis();
            if (time <= endTime) {
                date = c.getTime();
                dateStr = convertDate2Str(date, pattern);
                dates.add(dateStr);
            } else {
                break;
            }
        }
        return dates;
    }

    /**
     * 获取当前时间字符串格式
     *
     * @return
     */
    public static String getCurrentTime() {
        return getCurrentTime(DATE_FORMAT);
    }

    /**
     * 按照指定格式获取当前时间字符串
     *
     * @param format
     * @return
     */
    public static String getCurrentTime(String format) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            return sdf.format(new Date());
        } catch (Exception e) {
            throw new RuntimeException("Can't format the time by format[" + format + "]!");
        }
    }

    /**
     * 将字符串中html特殊字符替换成转义字符
     *
     * @param str 需要处理的字符串
     * @return 替换后的字符串
     */
    public static String replaceHtmlChars(String str) {
        if (isEmptyStr(str)) {
            // 检查是否空字符串
            return "";
        } else {
            return str.replaceAll("\"", "&quot;")
                    .replaceAll("\'", "&#039;")
                    .replaceAll("<", "&lt;")
                    .replaceAll(">", "&gt;")
                    .replaceAll("&", "&amp;");
        }
    }

    /**
     * 还原html字符
     *
     * @param str
     * @return
     */
    public static String restoreHtmlChars(String str) {
        if (isEmptyStr(str)) {
            return "";
        }

        return str.replaceAll("&amp;", "&")
                .replaceAll("&quot;", "\"")
                .replaceAll("&#039;", "'")
                .replaceAll("&lt;", "<")
                .replaceAll("&gt;", ">");
    }

    /**
     * 指定长度截取字符串
     *
     * @param source
     * @param len
     * @return
     */
    public static String ellipsis(String source, int len) {
        if (null != source && len < source.length()) {
            return source.substring(0, len) + "...";
        }

        return source;
    }

    /**
     * 拷贝文件
     *
     * @param srcFile
     * @param targetFileDir
     * @param targetFileName
     */
    public static void copyFile(File srcFile, String targetFileDir, String targetFileName) {
        File targetFile = createFile(targetFileDir, targetFileName);
        FileInputStream in = null;
        FileOutputStream out = null;
        try {
            in = new FileInputStream(srcFile);
            out = new FileOutputStream(targetFile);
            int data;
            while ((data = in.read()) != -1) {
                out.write(data);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null != in) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (null != out) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 创建文件
     *
     * @param fileDirPath
     * @param fileName
     * @return
     */
    public static File createFile(String fileDirPath, String fileName) {
        File fileDir = new File(fileDirPath);
        if (!fileDir.exists()) {
            fileDir.mkdirs();
        }

        File file = new File(fileDirPath + File.separator + fileName);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return file;
    }

    /**
     * 删除某个目录下的某个文件
     *
     * @param fileDirPath
     * @param fileName
     */
    public static void delFile(String fileDirPath, String fileName) {
        File fileDir = new File(fileDirPath);
        if (!fileDir.exists()) {
            logger.error("删除文件错误：" + fileDirPath + "该目录不存在");
        } else {
            File file = new File(fileDirPath + File.separator + fileName);
            if (!file.exists()) {
                logger.error("删除文件错误：" + fileDirPath + File.separator + fileName + "该文件不存在");
            } else {
                file.delete();
            }
        }
    }

    /**
     * 删除某个文件
     *
     * @param fileDirPath
     * @param fileName
     */
    public static void delFile(String filePath) {
        File file = new File(filePath);
        if (!file.exists()) {
            logger.error("删除文件错误：" + filePath + "该文件不存在");
        } else {
            boolean deleted = file.delete();
            if (!deleted) {
                logger.warn("delete file:" + filePath + " fail!");
            }
        }
    }

    /**
     * 判断某个字符串是不是整型数字
     *
     * @return
     */
    public static boolean isInteger(String val) {
        try {
            Integer.parseInt(val);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    /**
     * 判断某个字符串是不是Long数字
     *
     * @return
     */
    public static boolean isLong(String val) {
        try {
            Long.parseLong(val);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    /**
     * 判断某个字符串是不是double数字
     *
     * @return
     */
    public static boolean isDouble(String val) {
        try {
            Double.parseDouble(val);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    /**
     * 连接字符串
     *
     * @param valueList 字符串列表
     * @param asStr     是否为字符串标志
     * @return
     */
    public static String join(List<? extends Object> valueList, boolean asStr) {
        if (null != valueList && !valueList.isEmpty()) {
            StringBuffer buff = new StringBuffer();
            for (Object value : valueList) {
                if (asStr) {
                    buff.append('\'').append(value).append('\'').append(',');
                } else {
                    buff.append(value).append(',');
                }
            }
            return buff.toString().substring(0, buff.toString().length() - 1);
        }
        return null;
    }

    /**
     * 连接字符串
     *
     * @param valueList 字符串列表
     * @param asStr     是否为字符串标志
     * @return
     */
    public static String join(List<? extends Object> valueList, String separator) {
        if (null != valueList && !valueList.isEmpty()) {
            StringBuffer buff = new StringBuffer();
            for (Object value : valueList) {
                buff.append(value).append(separator);
            }
            return buff.toString().substring(0, buff.toString().length() - 1);
        }
        return null;
    }

    /**
     * 随机数量.
     */
    private static final int RANDOM_NUM_16 = 16;


    /**
     * 将精确到分钟的秒数转换成字符串,例如05:30
     *
     * @param endTime
     * @return
     */
    public static String convertTime2HourMinStr(Long time) {
        int hour = (int) (time / 3600);
        int min = (int) ((time % 3600) / 60);
        String hourStr = hour < 10 ? ("0" + hour) : (hour + "");
        String minStr = min < 10 ? ("0" + min) : (min + "");
        return hourStr + ":" + minStr;
    }

    /**
     * 转换GPS经纬度为标准偏移的经纬度
     *
     * @param value
     * @return
     */
    public static double getSLonLat(double value) {
        String str = value + "";
        int i = Integer.parseInt(str.substring(0, str.indexOf(".")));
        double f = Double.parseDouble("0." + str.substring(str.indexOf(".") + 1)) * 100;
        return i + f / 60;
    }

    /**
     * 发送http请求返回结果字符串
     *
     * @param url
     * @return
     */
    public static String sendGetHttpRequest(String url) {
        CloseableHttpClient client = null;
        ByteArrayOutputStream bos = null;
        InputStream in = null;
        String result = null;
        try {
            HttpGet request = new HttpGet(url);
            request.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/53.0.2785.143 Safari/537.36");
            client = HttpClients.createDefault();

            // 发送get请求，并获取response
            HttpResponse response = client.execute(request);

            // 判断请求是否成功
            if (response.getStatusLine().getStatusCode() == 200) {
                in = response.getEntity().getContent();
                bos = new ByteArrayOutputStream();
                byte[] data = new byte[1024];
                int count = -1;
                while ((count = in.read(data, 0, 1024)) != -1) {
                    bos.write(data, 0, count);
                }
                result = new String(bos.toByteArray(), "UTF-8");
            } else {
                logger.error("HTTP url(" + url + ") response:" + response.getStatusLine());
            }
        } catch (Exception e) {
            logger.error("发送http请求：" + url + "异常");
        } finally {
            close(client, bos, in);
        }
        return result;
    }

    /**
     * 发送post请求
     *
     * @param url
     * @param contentType,1表示json
     * @param params
     * @return
     */
    public static String sendPostHttpRequest(String uri, Integer contentType, Map<String, String> params) {
        HttpURLConnection conn = null;
        try {
            // 创建连接
            URL url = new URL(uri);
            conn = (HttpURLConnection) url.openConnection();

            // 设置通用的请求属性
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");

            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setRequestMethod("POST");
            conn.setUseCaches(false);
            conn.setInstanceFollowRedirects(true);

            if (contentType == 1)// json格式参数
            {
                conn.setRequestProperty("Content-Type", "application/json");
                DataOutputStream out = new DataOutputStream(conn.getOutputStream());
                for (Entry<String, String> e : params.entrySet()) {
                    params.put(e.getKey(), java.net.URLEncoder.encode(e.getValue(), "UTF-8"));
                }
                String json = JSONObject.toJSONString(params);
                out.writeBytes(json);
                out.flush();
                out.close();
            } else {
                if (null != params && !params.isEmpty()) {
                    StringBuffer buff = new StringBuffer();
                    int size = params.size();
                    int i = 0;
                    for (Entry<String, String> e : params.entrySet()) {
                        buff.append(e.getKey());
                        buff.append("=");
                        buff.append(java.net.URLEncoder.encode(e.getValue(), "UTF-8"));
                        i++;
                        if (i < size - 1) {
                            buff.append("&");
                        }
                    }

                    // 获取URLConnection对象对应的输出流
                    PrintWriter out = new PrintWriter(conn.getOutputStream());
                    out.print(buff);
                    out.flush();
                    out.close();
                }
            }

            // 读取响应
            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            StringBuffer sb = new StringBuffer();
            while ((line = reader.readLine()) != null) {
                line = new String(line.getBytes(), "utf-8");
                sb.append(line);
            }
            reader.close();
            return sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 断开连接
            if (null != conn) {
                conn.disconnect();
            }
        }
        return null;
    }

    public static void close(CloseableHttpClient client, ByteArrayOutputStream bos, InputStream in) {
        try {
            if (client != null) {
                client.close();
            }
            if (bos != null) {
                bos.close();
            }
            if (in != null) {
                in.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getString(Object obj) {
        return null == obj ? "" : (obj + "").trim();
    }

    /**
     * 对象转Byte数组
     *
     * @param obj
     * @return
     * @throws Exception
     */
    public static byte[] object2Bytes(Object obj) {
        byte[] bytes = null;
        ByteArrayOutputStream byteOut = null;
        ObjectOutputStream out = null;
        try {
            byteOut = new ByteArrayOutputStream();
            out = new ObjectOutputStream(byteOut);
            out.writeObject(obj);
            out.flush();
            bytes = byteOut.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != byteOut) {
                    byteOut.close();
                }
                if (null != out) {
                    out.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return bytes;
    }

    /**
     * 获取本地IP
     *
     * @return
     * @see [类、类#方法、类#成员]
     */
    public static String getLocalIp() {
        String localIp = "";
        InetAddress addr;
        try {
            addr = InetAddress.getLocalHost();
            localIp = addr.getHostAddress().toString();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return localIp;
    }

    /**
     * 将文件转换成字节数组
     *
     * @param file
     * @return
     * @see [类、类#方法、类#成员]
     */
    public static byte[] convertFile2Bytes(File file) {
        byte[] bytes = null;
        FileInputStream in = null;
        ByteArrayOutputStream out = null;
        try {
            in = new FileInputStream(file);
            out = new ByteArrayOutputStream(1000);
            byte[] b = new byte[1000];
            int n;
            while ((n = in.read(b)) != -1) {
                out.write(b, 0, n);
            }
            bytes = out.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != in) {
                    in.close();
                }
                if (null != out) {
                    out.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return bytes;
    }


    /**
     * 字符串反转
     *
     * @param srcStr
     * @return
     * @see [类、类#方法、类#成员]
     */
    public static String reverseStr(String srcStr) {
        char[] charArr = srcStr.toCharArray();
        int n = charArr.length - 1;
        int halfLength = n / 2;
        for (int i = 0; i <= halfLength; i++) {
            char temp = charArr[i];
            charArr[i] = charArr[n - i];
            charArr[n - i] = temp;
        }
        return new String(charArr);
    }

    /**
     * 回去多少天后对应的日期
     *
     * @param date
     * @param i
     * @return
     * @see [类、类#方法、类#成员]
     */
    public static Date addDay(Date date, int i) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.DAY_OF_MONTH, i);
        return c.getTime();
    }

    /**
     * 获取客户端IP地址.<br>
     * 支持多级反向代理
     *
     * @param request HttpServletRequest
     * @return 客户端真实IP地址
     */
    public static String getRemoteAddr(final HttpServletRequest request) {
        try {
            String remoteAddr = request.getHeader("X-Forwarded-For");
            // 如果通过多级反向代理，X-Forwarded-For的值不止一个，而是一串用逗号分隔的IP值，此时取X-Forwarded-For中第一个非unknown的有效IP字符串
            if (isEffective(remoteAddr) && (remoteAddr.indexOf(",") > -1)) {
                String[] array = remoteAddr.split(",");
                for (String element : array) {
                    if (isEffective(element)) {
                        remoteAddr = element;
                        break;
                    }
                }
            }
            if (!isEffective(remoteAddr)) {
                remoteAddr = request.getHeader("X-Real-IP");
            }
            if (!isEffective(remoteAddr)) {
                remoteAddr = request.getRemoteAddr();
            }
            return remoteAddr;
        } catch (Exception e) {
            logger.error("get romote ip error,error message:" + e.getMessage());
            return "";
        }
    }

    /**
     * 获取客户端源端口
     *
     * @param request
     * @return
     */
    public static Integer getRemotePort(final HttpServletRequest request) {
        try {
            String port = request.getHeader("remote-port");
            if (!CommonUtil.isEmptyStr(port)) {
                try {
                    return Integer.parseInt(port);
                } catch (NumberFormatException ex) {
                    logger.error("convert port to long error , port: " + port);
                    return 0;
                }
            } else {
                return 0;
            }
        } catch (Exception e) {
            logger.error("get romote port error,error message:" + e.getMessage());
            return 0;
        }
    }

    /**
     * 远程地址是否有效.
     *
     * @param remoteAddr 远程地址
     * @return true代表远程地址有效，false代表远程地址无效
     */
    private static boolean isEffective(final String remoteAddr) {
        boolean isEffective = false;
        if (!CommonUtil.isEmptyStr(remoteAddr) && (!"unknown".equalsIgnoreCase(remoteAddr.trim()))) {
            isEffective = true;
        }
        return isEffective;
    }

    public static void closeIn(InputStream in) {
        if (null != in) {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void closeReader(Reader in) {
        if (null != in) {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void sleep(long time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 判断是否为基础类型
     *
     * @param obj
     * @return
     */
    public static boolean isBasic(Object obj) {
        if (obj.getClass().getSuperclass().equals(Number.class)) {
            return true;
        }
        if (obj.getClass().equals(String.class)) {
            return true;
        }
        if (obj.getClass().equals(Boolean.class)) {
            return true;
        }
        return false;
    }

    /**
     * 判断是否集合
     *
     * @param obj
     * @return
     */
    public static boolean isCollection(Object obj) {
        if (obj instanceof List) {
            return true;
        }
        if (obj instanceof Set) {
            return true;
        }
        return false;
    }

    public static String readFile(String path) {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(new FileInputStream(path), "UTF-8"));
            StringBuilder builder = new StringBuilder();
            String line;
            while (null != (line = reader.readLine())) {
                builder.append(line.trim());
            }
            return builder.toString();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null != reader) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    /**
     * 获取HTTP请求头
     *
     * @param request
     * @return
     */
    public static Map<String, String> getHttpHeader(HttpServletRequest request) {
        Map<String, String> headers = new HashMap<String, String>();
        Enumeration<String> names = request.getHeaderNames();
        while (names.hasMoreElements()) {
            String headerName = names.nextElement();
            String headerVal = request.getHeader(headerName);
            headers.put(headerName, headerVal);
        }
        return headers;
    }

    /**
     * 获取HTTP请求参数
     *
     * @param request
     * @return
     */
    public static Map<String, Object> getHttpParams(HttpServletRequest request) {
        Map<String, Object> params = new HashMap<String, Object>();
        Enumeration<String> names = request.getParameterNames();
        while (names.hasMoreElements()) {
            String name = names.nextElement();
            String[] vals = request.getParameterValues(name);
            if (null != vals) {
                params.put(name, vals);
            } else {
                String val = request.getParameter(name);
                params.put(name, val);
            }
        }
        return params;
    }

    public static int compareLong(long o1, long o2) {
        if (o1 < o2) {
            return -1;
        } else if (o1 == o2) {
            return 0;
        } else {
            return 1;
        }
    }

    public static String encodeBase64(String str) {
        return new BASE64Encoder().encode(str.getBytes());
    }

    public static String decodeBase64(String str) {
        try {
            return new String(new BASE64Decoder().decodeBuffer(str));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 递归获取某个目录下的所有文件
     *
     * @param file
     */
    public static void recursionFiles(File file, List<File> files) {
        if (file.isDirectory()) {
            File[] subFiles = file.listFiles();
            for (File subFile : subFiles) {
                recursionFiles(subFile, files);
            }
        } else {
            files.add(file);
        }
    }



    /**
     * 递归删除某个目录下的所有空目录
     *
     * @param file
     */
    public static void recursionDelEmptyDirs(File file) {
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            if (files.length == 0) {
                file.delete();
            } else {
                for (File sub : files) {
                    recursionDelEmptyDirs(sub);
                }
            }
        }
    }

    /**
     * 生成数字随机验证码
     * @param length 验证码长度
     * @return
     */
    public static String generateNumberRandomCode(int length)   {
        return RandomStringUtils.random(length,RANDOMCODE_SOURCE);
    }

    /**
     * 验证手机号码，11位数字，1开通，第二位数必须是3456789这些数字之一
     * @param mobileNumber
     * @return
     */
    public static boolean checkMobileNumber(String mobileNumber) {
        boolean flag = false;
        try {
            Pattern regex = Pattern.compile("^1[345789]\\d{9}$");
            Matcher matcher = regex.matcher(mobileNumber);
            flag = matcher.matches();
        } catch (Exception e) {
            e.printStackTrace();
            flag = false;
        }
        return flag;
    }

    /**
     * 验证邮箱
     * @param email
     * @return
     */

    public static boolean checkEmail(String email) {
        boolean flag = false;
        try {
            String check = "^([a-z0-9A-Z]+[-|_|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
            Pattern regex = Pattern.compile(check);
            Matcher matcher = regex.matcher(email);
            flag = matcher.matches();
        } catch (Exception e) {
            flag = false;
        }
        return flag;
    }

    /**
     * 验证非法字符
     * @param impropercharacter
     * @returnimproper
     */

    public static boolean checkmproperhICaracter(String  impropercharacter) {
        boolean flag = false;
        try {
            String check = "[^a-zA-Z0-9\\_\\u4e00-\\u9fa5]\",\"i";
            Pattern regex = Pattern.compile(check);
            Matcher matcher = regex.matcher(impropercharacter);
            flag = matcher.matches();
        } catch (Exception e) {
            flag = false;
        }
        return flag;
    }

}
