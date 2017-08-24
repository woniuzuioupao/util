-- 创建汉字拼音对照临时表d
CREATE TABLE
IF NOT EXISTS `t_base_pinyin` (
	`pin_yin_` VARCHAR (255) CHARACTER
	SET gbk NOT NULL,
	`code_` INT (11) NOT NULL,
	PRIMARY KEY (`code_`)
) ENGINE = INNODB DEFAULT CHARSET = latin1;

-- 插入数据
INSERT INTO t_base_pinyin (pin_yin_, code_)
VALUES
	("a", 20319),
	("ai", 20317),
	("an", 20304),
	("ang", 20295),
	("ao", 20292),
	("ba", 20283),
	("bai", 20265),
	("ban", 20257),
	("bang", 20242),
	("bao", 20230),
	("bei", 20051),
	("ben", 20036),
	("beng", 20032),
	("bi", 20026),
	("bian", 20002),
	("biao", 19990),
	("bie", 19986),
	("bin", 19982),
	("bing", 19976),
	("bo", 19805),
	("bu", 19784),
	("ca", 19775),
	("cai", 19774),
	("can", 19763),
	("cang", 19756),
	("cao", 19751),
	("ce", 19746),
	("ceng", 19741),
	("cha", 19739),
	("chai", 19728),
	("chan", 19725),
	("chang", 19715),
	("chao", 19540),
	("che", 19531),
	("chen", 19525),
	("cheng", 19515),
	("chi", 19500),
	("chong", 19484),
	("chou", 19479),
	("chu", 19467),
	("chuai", 19289),
	("chuan", 19288),
	("chuang", 19281),
	("chui", 19275),
	("chun", 19270),
	("chuo", 19263),
	("ci", 19261),
	("cong", 19249),
	("cou", 19243),
	("cu", 19242),
	("cuan", 19238),
	("cui", 19235),
	("cun", 19227),
	("cuo", 19224),
	("da", 19218),
	("dai", 19212),
	("dan", 19038),
	("dang", 19023),
	("dao", 19018),
	("de", 19006),
	("deng", 19003),
	("di", 18996),
	("dian", 18977),
	("diao", 18961),
	("die", 18952),
	("ding", 18783),
	("diu", 18774),
	("dong", 18773),
	("dou", 18763),
	("du", 18756),
	("duan", 18741),
	("dui", 18735),
	("dun", 18731),
	("duo", 18722),
	("e", 18710),
	("en", 18697),
	("er", 18696),
	("fa", 18526),
	("fan", 18518),
	("fang", 18501),
	("fei", 18490),
	("fen", 18478),
	("feng", 18463),
	("fo", 18448),
	("fou", 18447),
	("fu", 18446),
	("ga", 18239),
	("gai", 18237),
	("gan", 18231),
	("gang", 18220),
	("gao", 18211),
	("ge", 18201),
	("gei", 18184),
	("gen", 18183),
	("geng", 18181),
	("gong", 18012),
	("gou", 17997),
	("gu", 17988),
	("gua", 17970),
	("guai", 17964),
	("guan", 17961),
	("guang", 17950),
	("gui", 17947),
	("gun", 17931),
	("guo", 17928),
	("ha", 17922),
	("hai", 17759),
	("han", 17752),
	("hang", 17733),
	("hao", 17730),
	("he", 17721),
	("hei", 17703),
	("hen", 17701),
	("heng", 17697),
	("hong", 17692),
	("hou", 17683),
	("hu", 17676),
	("hua", 17496),
	("huai", 17487),
	("huan", 17482),
	("huang", 17468),
	("hui", 17454),
	("hun", 17433),
	("huo", 17427),
	("ji", 17417),
	("jia", 17202),
	("jian", 17185),
	("jiang", 16983),
	("jiao", 16970),
	("jie", 16942),
	("jin", 16915),
	("jing", 16733),
	("jiong", 16708),
	("jiu", 16706),
	("ju", 16689),
	("juan", 16664),
	("jue", 16657),
	("jun", 16647),
	("ka", 16474),
	("kai", 16470),
	("kan", 16465),
	("kang", 16459),
	("kao", 16452),
	("ke", 16448),
	("ken", 16433),
	("keng", 16429),
	("kong", 16427),
	("kou", 16423),
	("ku", 16419),
	("kua", 16412),
	("kuai", 16407),
	("kuan", 16403),
	("kuang", 16401),
	("kui", 16393),
	("kun", 16220),
	("kuo", 16216),
	("la", 16212),
	("lai", 16205),
	("lan", 16202),
	("lang", 16187),
	("lao", 16180),
	("le", 16171),
	("lei", 16169),
	("leng", 16158),
	("li", 16155),
	("lia", 15959),
	("lian", 15958),
	("liang", 15944),
	("liao", 15933),
	("lie", 15920),
	("lin", 15915),
	("ling", 15903),
	("liu", 15889),
	("long", 15878),
	("lou", 15707),
	("lu", 15701),
	("lv", 15681),
	("luan", 15667),
	("lue", 15661),
	("lun", 15659),
	("luo", 15652),
	("ma", 15640),
	("mai", 15631),
	("man", 15625),
	("mang", 15454),
	("mao", 15448),
	("me", 15436),
	("mei", 15435),
	("men", 15419),
	("meng", 15416),
	("mi", 15408),
	("mian", 15394),
	("miao", 15385),
	("mie", 15377),
	("min", 15375),
	("ming", 15369),
	("miu", 15363),
	("mo", 15362),
	("mou", 15183),
	("mu", 15180),
	("na", 15165),
	("nai", 15158),
	("nan", 15153),
	("nang", 15150),
	("nao", 15149),
	("ne", 15144),
	("nei", 15143),
	("nen", 15141),
	("neng", 15140),
	("ni", 15139),
	("nian", 15128),
	("niang", 15121),
	("niao", 15119),
	("nie", 15117),
	("nin", 15110),
	("ning", 15109),
	("niu", 14941),
	("nong", 14937),
	("nu", 14933),
	("nv", 14930),
	("nuan", 14929),
	("nue", 14928),
	("nuo", 14926),
	("o", 14922),
	("ou", 14921),
	("pa", 14914),
	("pai", 14908),
	("pan", 14902),
	("pang", 14894),
	("pao", 14889),
	("pei", 14882),
	("pen", 14873),
	("peng", 14871),
	("pi", 14857),
	("pian", 14678),
	("piao", 14674),
	("pie", 14670),
	("pin", 14668),
	("ping", 14663),
	("po", 14654),
	("pu", 14645),
	("qi", 14630),
	("qia", 14594),
	("qian", 14429),
	("qiang", 14407),
	("qiao", 14399),
	("qie", 14384),
	("qin", 14379),
	("qing", 14368),
	("qiong", 14355),
	("qiu", 14353),
	("qu", 14345),
	("quan", 14170),
	("que", 14159),
	("qun", 14151),
	("ran", 14149),
	("rang", 14145),
	("rao", 14140),
	("re", 14137),
	("ren", 14135),
	("reng", 14125),
	("ri", 14123),
	("rong", 14122),
	("rou", 14112),
	("ru", 14109),
	("ruan", 14099),
	("rui", 14097),
	("run", 14094),
	("ruo", 14092),
	("sa", 14090),
	("sai", 14087),
	("san", 14083),
	("sang", 13917),
	("sao", 13914),
	("se", 13910),
	("sen", 13907),
	("seng", 13906),
	("sha", 13905),
	("shai", 13896),
	("shan", 13894),
	("shang", 13878),
	("shao", 13870),
	("she", 13859),
	("shen", 13847),
	("sheng", 13831),
	("shi", 13658),
	("shou", 13611),
	("shu", 13601),
	("shua", 13406),
	("shuai", 13404),
	("shuan", 13400),
	("shuang", 13398),
	("shui", 13395),
	("shun", 13391),
	("shuo", 13387),
	("si", 13383),
	("song", 13367),
	("sou", 13359),
	("su", 13356),
	("suan", 13343),
	("sui", 13340),
	("sun", 13329),
	("suo", 13326),
	("ta", 13318),
	("tai", 13147),
	("tan", 13138),
	("tang", 13120),
	("tao", 13107),
	("te", 13096),
	("teng", 13095),
	("ti", 13091),
	("tian", 13076),
	("tiao", 13068),
	("tie", 13063),
	("ting", 13060),
	("tong", 12888),
	("tou", 12875),
	("tu", 12871),
	("tuan", 12860),
	("tui", 12858),
	("tun", 12852),
	("tuo", 12849),
	("wa", 12838),
	("wai", 12831),
	("wan", 12829),
	("wang", 12812),
	("wei", 12802),
	("wen", 12607),
	("weng", 12597),
	("wo", 12594),
	("wu", 12585),
	("xi", 12556),
	("xia", 12359),
	("xian", 12346),
	("xiang", 12320),
	("xiao", 12300),
	("xie", 12120),
	("xin", 12099),
	("xing", 12089),
	("xiong", 12074),
	("xiu", 12067),
	("xu", 12058),
	("xuan", 12039),
	("xue", 11867),
	("xun", 11861),
	("ya", 11847),
	("yan", 11831),
	("yang", 11798),
	("yao", 11781),
	("ye", 11604),
	("yi", 11589),
	("yin", 11536),
	("ying", 11358),
	("yo", 11340),
	("yong", 11339),
	("you", 11324),
	("yu", 11303),
	("yuan", 11097),
	("yue", 11077),
	("yun", 11067),
	("za", 11055),
	("zai", 11052),
	("zan", 11045),
	("zang", 11041),
	("zao", 11038),
	("ze", 11024),
	("zei", 11020),
	("zen", 11019),
	("zeng", 11018),
	("zha", 11014),
	("zhai", 10838),
	("zhan", 10832),
	("zhang", 10815),
	("zhao", 10800),
	("zhe", 10790),
	("zhen", 10780),
	("zheng", 10764),
	("zhi", 10587),
	("zhong", 10544),
	("zhou", 10533),
	("zhu", 10519),
	("zhua", 10331),
	("zhuai", 10329),
	("zhuan", 10328),
	("zhuang", 10322),
	("zhui", 10315),
	("zhun", 10309),
	("zhuo", 10307),
	("zi", 10296),
	("zong", 10281),
	("zou", 10274),
	("zu", 10270),
	("zuan", 10262),
	("zui", 10260),
	("zun", 10256),
	("zuo", 10254);

-- 建立汉字转换拼音函数
DROP FUNCTION IF EXISTS to_pinyin;
DELIMITER $
CREATE FUNCTION to_pinyin(NAME VARCHAR(255) CHARSET gbk)
RETURNS VARCHAR(255) CHARSET gbk
BEGIN
    DECLARE mycode INT;
    DECLARE tmp_lcode VARCHAR(2) CHARSET gbk;
    DECLARE lcode INT;
    DECLARE tmp_rcode VARCHAR(2) CHARSET gbk;
    DECLARE rcode INT;
    DECLARE mypy VARCHAR(255) CHARSET gbk DEFAULT '';
    DECLARE lp INT;
    SET mycode = 0;
    SET lp = 1;
    SET NAME = HEX(NAME);
    WHILE lp < LENGTH(NAME) DO
        SET tmp_lcode = SUBSTRING(NAME, lp, 2);
        SET lcode = CAST(ASCII(UNHEX(tmp_lcode)) AS UNSIGNED); 
        SET tmp_rcode = SUBSTRING(NAME, lp + 2, 2);
        SET rcode = CAST(ASCII(UNHEX(tmp_rcode)) AS UNSIGNED); 
        IF lcode > 128 THEN
            SET mycode =65536 - lcode * 256 - rcode ;
            SELECT CONCAT(mypy,pin_yin_) INTO mypy FROM t_base_pinyin WHERE CODE_ >= ABS(mycode) ORDER BY CODE_ ASC LIMIT 1;
            SET lp = lp + 4;
        ELSE
            SET mypy = CONCAT(mypy,CHAR(CAST(ASCII(UNHEX(SUBSTRING(NAME, lp, 2))) AS UNSIGNED)));
            SET lp = lp + 2;
        END IF;
    END WHILE;
    RETURN LOWER(mypy);
END;
$
DELIMITER ;

-- 转换为拼音首字母
DROP FUNCTION IF EXISTS `getPY`; 
DELIMITER ;; 
CREATE FUNCTION `getPY`(in_string VARCHAR(65534)) RETURNS mediumtext CHARSET utf8 
BEGIN
DECLARE tmp_str VARCHAR(65534) charset gbk DEFAULT '' ; #截取字符串，每次做截取后的字符串存放在该变量中，初始为函数参数in_string值 
DECLARE tmp_len SMALLINT DEFAULT 0;#tmp_str的长度 
DECLARE tmp_char VARCHAR(2) charset gbk DEFAULT '';#截取字符，每次 left(tmp_str,1) 返回值存放在该变量中 
DECLARE tmp_rs VARCHAR(65534) charset gbk DEFAULT '';#结果字符串 
DECLARE tmp_cc VARCHAR(2) charset gbk DEFAULT '';#拼音字符，存放单个汉字对应的拼音首字符 
SET tmp_str = in_string;#初始化，将in_string赋给tmp_str 
SET tmp_len = LENGTH(tmp_str);#初始化长度 
WHILE tmp_len > 0 DO #如果被计算的tmp_str长度大于0则进入该while 
SET tmp_char = LEFT(tmp_str,1);#获取tmp_str最左端的首个字符，注意这里是获取首个字符，该字符可能是汉字，也可能不是。 
SET tmp_cc = tmp_char;#左端首个字符赋值给拼音字符 
IF LENGTH(tmp_char)>1 THEN#判断左端首个字符是多字节还是单字节字符，要是多字节则认为是汉字且作以下拼音获取，要是单字节则不处理。 
SELECT ELT(INTERVAL(CONV(HEX(tmp_char),16,10),0xB0A1,0xB0C5,0xB2C1,0xB4EE,0xB6EA,0xB7A2,0xB8C1,0xB9FE,0xBBF7,0xBFA6,0xC0AC 
,0xC2E8,0xC4C3,0xC5B6,0xC5BE,0xC6DA,0xC8BB,0xC8F6,0xCBFA,0xCDDA ,0xCEF4,0xD1B9,0xD4D1), 
'A','B','C','D','E','F','G','H','J','K','L','M','N','O','P','Q','R','S','T','W','X','Y','Z') INTO tmp_cc; #获得汉字拼音首字符 
END IF; 
SET tmp_rs = CONCAT(tmp_rs,tmp_cc);#将当前tmp_str左端首个字符拼音首字符与返回字符串拼接 
SET tmp_str = SUBSTRING(tmp_str,2);#将tmp_str左端首字符去除 
SET tmp_len = LENGTH(tmp_str);#计算当前字符串长度 
END WHILE; 
RETURN tmp_rs;#返回结果字符串 
END;; 
DELIMITER ;

