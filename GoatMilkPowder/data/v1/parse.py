schema_path = 'data/schema.txt'
data_path = 'data/data.txt'
out_path = 'data/data2.sql'

if __name__ == "__main__":
    schema_set = ['品种']
    result_set = []

    with open(schema_path, 'r', encoding='UTF-8') as f:
        for line in f:
            schema_set.append(line.strip())

    with open(data_path, 'r', encoding='UTF-8') as f:
        for i, line in enumerate(f):
            for j, v in enumerate(line.split('\t')):
                if i == 0:
                    p_id = int(v.strip())
                    if p_id <= 32:
                        p_pingpai = '国产羊奶粉'
                    else:
                        p_pingpai = '进口羊奶粉' 
                    result_set.append([p_pingpai])
                    result_set[j].append(p_id)
                else:
                    result_set[j].append(v.strip())

    sql = "INSERT INTO `样本` ("
    for sche in schema_set:
        sql = sql + '`' + sche + '`'
        if schema_set.index(sche) != len(schema_set) - 1:
            sql = sql + ', '
        else:
            sql = sql + ') '
    sql = sql + 'VALUES ('


    sqls = []
    for result in result_set:
        nsql = sql
        for res in result:
            if type(res) == int:
                nsql = nsql + str(res)
            else:
                nsql = nsql + '"' + res + '"'
            if result.index(res) != len(result) - 1:
                nsql = nsql + ', '
            else:
                nsql = nsql + ');\n'
        sqls.append(nsql)

    with open(out_path, 'w', encoding='UTF-8') as f:
        f.writelines(sqls)
        f.write('\n')
