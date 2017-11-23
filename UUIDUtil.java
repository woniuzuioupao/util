package com.ziytek.taozhu.base.util;

import org.apache.commons.lang.StringUtils;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * 类描述：
 *
 */
public class Numbers implements Serializable {

    @org.junit.Test
    public void testBin1() {
        // 变量i是2进制数据!!!
        int i = 50;
        // 输出i的实际上2进制数据
        System.out.println(Integer.toBinaryString(i));
        // 输出方法调用了 Integer.toString()将2
        // 进制转换为10进制, 然后再输出
        System.out.println(i);// "50"
    }

    @org.junit.Test
    public void testBin2() {
        // 输出int类型 0~63全部2进制存储情况
        for (int i = 0; i <= 63; i++) {
            System.out.println(StringUtils.leftPad(Integer.toBinaryString(i), 32, '0'));
        }
    }

    @org.junit.Test
    public void testLeftPad() {
        // 左填充函数:
        // 将str左面补充到指定的长度
        // leftPad("6", 8, "0") -> 00000006
        // leftPad("123", 8, "0") -> 00000123

        String str = StringUtils.leftPad("101", 32, '0');
        System.out.println(str);
    }

    @org.junit.Test
    public void testHex() {
        int i = 0x7532a2fa;
        System.out.println(Integer.toBinaryString(i));
    }

    @org.junit.Test
    public void testBin3() {
        int i = -3;
        System.out.println(Integer.toBinaryString(i));
    }

    @org.junit.Test
    public void testBin4() {
        int i = -1;
        System.out.println(Integer.toBinaryString(i));
    }

    @org.junit.Test
    public void testBin5() {
        long i = -1L;
        System.out.println(Long.toBinaryString(i));
    }

    @org.junit.Test
    public void testBin6() {
        for (int i = -10; i <= -1; i++) {
            System.out.println(Integer.toBinaryString(i));
        }
    }

    @org.junit.Test
    public void testBin7() {
        // 01111111 11111111 11111111 11111111
        // 7 f f f f f f f
        int max = 0x7fffffff;
        System.out.println(max);
        System.out.println(Integer.toBinaryString(max));
        long m = 0x7fffffffffffffffL;
        System.out.println(m);
        System.out.println(Long.toBinaryString(m));

        // 10000000 00000000 00000000 00000000
        // 8 0 0 0 0 0 0 0
        int min = 0x80000000;
        System.out.println(min);
        System.out.println(Integer.toBinaryString(min));

        int n = Integer.MAX_VALUE;
        int k = Integer.MIN_VALUE;
        int x = k - n;
        System.out.println(x);

    }

    @org.junit.Test
    public void testBin10(){
        System.out.println(
                Integer.toBinaryString(8));
        System.out.println(
                Integer.toBinaryString(~8));
        System.out.println(~8);
    }

    @org.junit.Test
    public void testBin11(){
        int c = '中';
        System.out.println(
                Integer.toBinaryString(c));
    }
    @org.junit.Test
    public void testBin12() throws UnsupportedEncodingException {
        int c = '中';
        int m = 0x3f;
        int b3 = (c & m)|0x80;
        System.out.println(
                Integer.toBinaryString(c));
        System.out.println(
                Integer.toBinaryString(m));
        System.out.println(
                Integer.toBinaryString(b3));
        int b2 = ((c>>>6) & m)|0x80;
        System.out.println(
                Integer.toBinaryString(b2));

        int b1 = (c>>>12) | 0xe0;
        System.out.println(
                Integer.toBinaryString(b1));

        //JDK 提供了 utf-8 到char的解码
        byte[] bytes={(byte)b1,(byte)b2,(byte)b3};
        String s = new String(bytes, "utf-8");
        System.out.println(s);//"中"

        //将utf-8 b1 b2 b3 解码为 unicode字符
        int ch =(b3&0x3f) |
                ((b2&0x3f)<<6) |
                ((b1&0xf)<<12);

        System.out.println((char)ch);
    }


    public static void main(String[] args) {
        /*String uuid=UUID.randomUUID().toString().replace("-","");
        String s="0x"+uuid;
        System.out.println(uuid);
        System.out.println(s);
        int aLong=Integer.valueOf(s,16);
        //System.out.println(aLong);*/
        System.out.println(uuid());

    }


    final static char[] digits = { '0', '1', '2', '3', '4', '5', '6', '7', '8',
            '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l',
            'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y',
            'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L',
            'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y',
            'Z'};

    final static Map<Character, Integer> digitMap = new HashMap<Character, Integer>();




    static {
        for (int i = 0; i < digits.length; i++) {
            digitMap.put(digits[i], (int) i);
        }
    }

    /**
     * 支持的最大进制数
     */
    public static final int MAX_RADIX = digits.length;

    /**
     * 支持的最小进制数
     */
    public static final int MIN_RADIX = 2;

    /**
     * 将长整型数值转换为指定的进制数（最大支持62进制，字母数字已经用尽）
     *
     * @param i
     * @param radix
     * @return
     */
    public static String toString(long i, int radix) {
        if (radix < MIN_RADIX || radix > MAX_RADIX)
            radix = 10;
        if (radix == 10)
            return Long.toString(i);

        final int size = 65;
        int charPos = 64;

        char[] buf = new char[size];
        boolean negative = (i < 0);

        if (!negative) {
            i = -i;
        }

        while (i <= -radix) {
            buf[charPos--] = digits[(int) (-(i % radix))];
            i = i / radix;
        }
        buf[charPos] = digits[(int) (-i)];

        if (negative) {
            buf[--charPos] = '-';
        }

        return new String(buf, charPos, (size - charPos));
    }

    static NumberFormatException forInputString(String s) {
        return new NumberFormatException("For input string: \"" + s + "\"");
    }

    /**
     * 将字符串转换为长整型数字
     *
     * @param s
     *            数字字符串
     * @param radix
     *            进制数
     * @return
     */
    public static long toNumber(String s, int radix) {
        if (s == null) {
            throw new NumberFormatException("null");
        }

        if (radix < MIN_RADIX) {
            throw new NumberFormatException("radix " + radix
                    + " less than Numbers.MIN_RADIX");
        }
        if (radix > MAX_RADIX) {
            throw new NumberFormatException("radix " + radix
                    + " greater than Numbers.MAX_RADIX");
        }

        long result = 0;
        boolean negative = false;
        int i = 0, len = s.length();
        long limit = -Long.MAX_VALUE;
        long multmin;
        Integer digit;

        if (len > 0) {
            char firstChar = s.charAt(0);
            if (firstChar < '0') {
                if (firstChar == '-') {
                    negative = true;
                    limit = Long.MIN_VALUE;
                } else if (firstChar != '+')
                    throw forInputString(s);

                if (len == 1) {
                    throw forInputString(s);
                }
                i++;
            }
            multmin = limit / radix;
            while (i < len) {
                digit = digitMap.get(s.charAt(i++));
                if (digit == null) {
                    throw forInputString(s);
                }
                if (digit < 0) {
                    throw forInputString(s);
                }
                if (result < multmin) {
                    throw forInputString(s);
                }
                result *= radix;
                if (result < limit + digit) {
                    throw forInputString(s);
                }
                result -= digit;
            }
        } else {
            throw forInputString(s);
        }
        return negative ? result : -result;
    }


    private static String digits(long val, int digits) {
        long hi = 1L << (digits * 4);
        return Numbers.toString(hi | (val & (hi - 1)),Numbers.MAX_RADIX)
                .substring(1);
    }

    /**
     * 以62进制（字母加数字）生成19位UUID，最短的UUID
     *
     * @return
     */
    public static String uuid() {
        UUID uuid = UUID.randomUUID();
        StringBuilder sb = new StringBuilder();
        sb.append(digits(uuid.getMostSignificantBits() >> 32, 8));
        sb.append(digits(uuid.getMostSignificantBits() >> 16, 4));
        sb.append(digits(uuid.getMostSignificantBits(), 4));
        sb.append(digits(uuid.getLeastSignificantBits() >> 48, 4));
        sb.append(digits(uuid.getLeastSignificantBits(), 12));
        return sb.toString();
    } 

}
