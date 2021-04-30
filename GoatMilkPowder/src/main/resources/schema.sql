DROP TABLE IF EXISTS `羊奶粉产品检测_国产进口_样品`;
DROP TABLE IF EXISTS `羊奶粉产品检测_省内外_样品`;
DROP TABLE IF EXISTS `公司自检_生羊乳_样品`;
DROP TABLE IF EXISTS `羊奶粉dna含量`;
DROP TABLE IF EXISTS `用户`;
DROP TABLE IF EXISTS `图片`;


CREATE TABLE IF NOT EXISTS `羊奶粉产品检测_国产进口_样品` (
    `id` BIGINT UNSIGNED auto_increment NOT NULL PRIMARY KEY,
    `info` varchar(30) NULL COMMENT '来源',
    `品种` varchar(20) NULL COMMENT '国产羊奶粉样品品牌、进口羊奶粉品牌',
	`组织状态` varchar(200) NULL,
	`色泽` varchar(100) NULL,
	`水分` varchar(100) NULL,
	`蛋白质` varchar(100) NULL,
    `脂肪` varchar(100) NULL,
    `乳糖` varchar(100) NULL,
    `蔗糖` varchar(100) NULL,
    `维生素A` varchar(100) NULL,
    `维生素D` varchar(100) NULL,
    `维生素E` varchar(100) NULL,
    `维生素K1` varchar(100) NULL,
    `维生素B1` varchar(100) NULL,
    `维生素B2` varchar(100) NULL,
    `维生素B6` varchar(100) NULL,
    `维生素B12` varchar(100) NULL,
    `烟酸` varchar(100) NULL,
    `叶酸` varchar(100) NULL,
    `泛酸` varchar(100) NULL,
    `维生素C` varchar(100) NULL,
    `生物素` varchar(100) NULL,
    `胆碱` varchar(100) NULL,
    `铁` varchar(100) NULL,
    `钙` varchar(100) NULL,
    `锌` varchar(100) NULL,
    `磷` varchar(100) NULL,
    `钠` varchar(100) NULL,
    `钾` varchar(100) NULL,
    `镁` varchar(100) NULL,
    `铜` varchar(100) NULL,
    `锰` varchar(100) NULL,
    `硒` varchar(100) NULL,
    `碘` varchar(100) NULL,
    `铅` varchar(100) NULL,
    `铬` varchar(100) NULL,
    `镉` varchar(100) NULL,
    `总砷` varchar(100) NULL,
    `亚油酸` varchar(100) NULL,
    `α_亚麻酸` varchar(100) NULL,
    `亚油酸_α_亚麻酸` varchar(100) NULL,
    `DHA` varchar(100) NULL,
    `ARA` varchar(100) NULL,
    `月桂酸和肉豆蔻酸占总脂肪酸的比例` varchar(100) NULL,
    `反式脂肪酸与总脂肪酸的比值` varchar(100) NULL,
    `OPO` varchar(100) NULL,
    `氯` varchar(100) NULL,
    `酸度` varchar(100) NULL,
    `碳水化合物` varchar(100) NULL,
    `灰分` varchar(100) NULL,
    `Asp` varchar(100) NULL,
    `Thr` varchar(100) NULL,
    `Ser` varchar(100) NULL,
    `Glu` varchar(100) NULL,
    `Gly` varchar(100) NULL,
    `Ala` varchar(100) NULL,
    `Val` varchar(100) NULL,
    `Met` varchar(100) NULL,
    `Ile` varchar(100) NULL,
    `Leu` varchar(100) NULL,
    `Tyr` varchar(100) NULL,
    `Phe` varchar(100) NULL,
    `Lys` varchar(100) NULL,
    `His` varchar(100) NULL,
    `Arg` varchar(100) NULL,
    `Pro` varchar(100) NULL,
    `氨基酸总量` varchar(100) NULL
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_general_ci;


CREATE TABLE IF NOT EXISTS `羊奶粉产品检测_省内外_样品` (
    `id` varchar(20) NOT NULL PRIMARY KEY,
    `info` varchar(30) NULL COMMENT '品种',
    `区域` varchar(30) NULL COMMENT '陕西省外、陕西省内',
    `感官` varchar(100) NULL,
    `脂肪` varchar(100) NULL,
    `蛋白质` varchar(100) NULL,
    `水分` varchar(100) NULL,
    `抗生素` varchar(100) NULL,
    `β_内酰胺酶` varchar(100) NULL COMMENT 'β-内酰胺酶',
    `酸度` varchar(100) NULL,
    `DBP` varchar(100) NULL
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_general_ci;


CREATE TABLE IF NOT EXISTS `公司自检_生羊乳_样品` (
    `id` BIGINT UNSIGNED auto_increment NOT NULL PRIMARY KEY,
    `日期` varchar(20) NULL,
    `奶站` varchar(20) NULL,
    `感官` varchar(20) NULL,
    `脂肪` varchar(20) NULL,
    `蛋白质` varchar(20) NULL,
    `非脂乳固体` varchar(20) NULL,
    `冰点` varchar(20) NULL,
    `酸度` varchar(20) NULL,
    `抗生素` varchar(20) NULL,
    `β_内酰胺酶` varchar(20) NULL,
    `酒精试验` varchar(20) NULL,
    `煮沸试验` varchar(20) NULL,
    `DBP` varchar(20) NULL
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_general_ci;


CREATE TABLE IF NOT EXISTS `羊奶粉dna含量` (
    `id` BIGINT UNSIGNED auto_increment NOT NULL PRIMARY KEY,
    `Abs260` DOUBLE NULL DEFAULT 0,
    `Abs280` DOUBLE NULL DEFAULT 0,
    `Abs260_280` DOUBLE NULL DEFAULT 0,
    `DNA_content` DOUBLE NULL DEFAULT 0
)ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_general_ci;


CREATE TABLE IF NOT EXISTS `用户` (
    `username` varchar(100) NOT NULL PRIMARY KEY,
    `password` varchar(100) NOT NULL,
    `role` varchar(100) DEFAULT 'visitor'
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_general_ci;

CREATE TABLE IF NOT EXISTS `图片` (
    `url` varchar(100) NOT NULL PRIMARY KEY
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_general_ci;