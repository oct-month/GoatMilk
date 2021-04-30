BASE_DIR = "data/v2"

sql = "INSERT INTO `公司自检-生羊乳-样品` (`日期`, `奶站`, `感官`, `脂肪`, `蛋白质`, `非脂乳固体`, `冰点`, `酸度`, `抗生素`, `β-内酰胺酶`, `酒精试验`, `煮沸试验`, `DBP`) VALUES (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s);"

if __name__ == "__main__":
    sql_list = []
    with open(BASE_DIR + "/data1.txt", "r", encoding="utf-8") as f1, open(BASE_DIR + "/data2.txt", "r", encoding="utf-8") as f2:
        date = ""
        for d1, d2 in zip(f1, f2):
            datali = []
            if d1.strip() != "":
                date = d1.strip()
            datali.append(f"\"{date}\"")
            datali.append("NULL")
            for t in d2.split("\t"):
                datali.append(f"\"{t.strip()}\"")
            sql_list.append(sql % tuple(datali) + "\n")
    with open(BASE_DIR + "/data5.sql", "w", encoding="utf-8") as f:
        f.writelines(sql_list)
