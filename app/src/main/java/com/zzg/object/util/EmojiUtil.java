package com.zzg.object.util;

/**
 * Created by apple on 2017/3/21.
 */

public class EmojiUtil {

    /**
     * 1.杂项符号及图形,杂项符号及图形一共有768个字符，范围为： U+1F300 ～ U+1F5FF
     */
    public static final String EMOJI_1 = "[\\uD83C\\uDF00-\\uD83D\\uDDFF]";
    /**
     * 2. 增补符号及图形增补符号及图形中一共有82个字符，范围为： U+1F900 ～ U+1F9FF
     */
    public static final String EMOJI_2 = "[\\uD83E\\uDD00-\\uD83E\\uDDFF]";
    /**
     * 3. 表情符号,表情符号一共有80个字符，范围为： U+1F600 ～ U+1F64F
     */
    public static final String EMOJI_3 = "[\\uD83D\\uDE00-\\uD83D\\uDE4F]";
    /**
     * 4. 交通及地图符号,交通及地图符号一共有103个字符，范围为： U+1F680 ～ U+1F6FF
     */
    public static final String EMOJI_4 = "[\\uD83D\\uDE80-\\uD83D\\uDEFF]";
    /**
     * 5. 杂项符号,杂项符号一共有256个字符，范围为： U+2600 ～ U+26FF 或拼上 U+FE0F
     */
    public static final String EMOJI_5 = "[\\u2600-\\u26FF]\\FE0F?";
    /**
     * 6. 装饰符号,装饰符号一共有192个字符，范围为： U+2700 ～ U+27BF 或拼上 U+FE0F
     */
    public static final String EMOJI_6 = "[\\u2700-\\u27BF]\\FE0F?";
    /**
     * 7. 封闭式字母数字符号,封闭式字母数字符号中只有一个 emoji 字符，为： U+24C2 或拼上 U+FE0F
     */
    public static final String EMOJI_7 = "\\u24C2\\uFE0F?";
    /**
     * 8. 封闭式字母数字补充符号,封闭式字母数字补充符号包含41个 emoji 字符
     */
    public static final String EMOJI_8 = "[\\uD83C\\uDDE6-\\uD83C\\uDDFF]{1,2}";
    /**
     * 9. 键帽符号
     */
    public static final String EMOJI_9 = "[\\u0023\\u002A[\\u0030-\\u0039]]\\uFE0F?\\u20E3";
    /**
     * 10. 箭头符号
     */
    public static final String EMOJI_10 = "[\\u2194-\\u2199\\u21A9-\\u21AA]\\uFE0F?";
    /**
     * 11. 几何图形
     */
    public static final String EMOJI_11 = "[\\u25AA\\u25AB\\u25B6\\u25C0\\u25FB-\\u25FE]\\uFE0F?";
    /**
     * 12. 麻将牌
     */
    public static final String EMOJI_12 = "\\uD83C\\uDC04\\uFE0F?";
    /**
     * 13. 扑克牌
     */
    public static final String EMOJI_13 = "\\uD83C\\uDCCF\\uFE0F?";
    /**
     * 包含所有 emoji 的正则表达式
     */
    public static final String EMOJI_all = "(?:[\uD83C\uDF00-\uD83D\uDDFF]|[\uD83E\uDD00-\uD83E\uDDFF]|[\uD83D\uDE00-\uD83D\uDE4F]|[\uD83D\uDE80-\uD83D\uDEFF]|[\u2600-\u26FF]\uFE0F?|[\u2700-\u27BF]\uFE0F?|\u24C2\uFE0F?|[\uD83C\uDDE6-\uD83C\uDDFF]{1,2}|[\uD83C\uDD70\uD83C\uDD71\uD83C\uDD7E\uD83C\uDD7F\uD83C\uDD8E\uD83C\uDD91-\uD83C\uDD9A]\uFE0F?|[\u0023\u002A\u0030-\u0039]\uFE0F?\u20E3|[\u2194-\u2199\u21A9-\u21AA]\uFE0F?|[\u2B05-\u2B07\u2B1B\u2B1C\u2B50\u2B55]\uFE0F?|[\u2934\u2935]\uFE0F?|[\u3030\u303D]\uFE0F?|[\u3297\u3299]\uFE0F?|[\uD83C\uDE01\uD83C\uDE02\uD83C\uDE1A\uD83C\uDE2F\uD83C\uDE32-\uD83C\uDE3A\uD83C\uDE50\uD83C\uDE51]\uFE0F?|[\u203C\u2049]\uFE0F?|[\u25AA\u25AB\u25B6\u25C0\u25FB-\u25FE]\uFE0F?|[\u00A9\u00AE]\uFE0F?|[\u2122\u2139]\uFE0F?|\uD83C\uDC04\uFE0F?|\uD83C\uDCCF\uFE0F?|[\u231A\u231B\u2328\u23CF\u23E9-\u23F3\u23F8-\u23FA]\uFE0F?)";
}
