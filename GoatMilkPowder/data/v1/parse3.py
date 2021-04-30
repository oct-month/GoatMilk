schema_path = 'data/schema2.txt'
data_path = 'data/data3.txt'
out_path = 'data/data4.sql'

if __name__ == "__main__":
    schema_set = ['区域']
    result_set = []

    with open(schema_path, 'r', encoding='UTF-8') as f:
        for line in f:
            schema_set.append(line.strip())

    with open(data_path, 'r', encoding='UTF-8') as f:
        for i, line in enumerate(f):
            for j, v in enumerate(line.split('\t')):
                if i == 0:
                    result_set.append(['陕西省'])
                result_set[j].append(v.strip())

    #print(schema_set)
    #print(result_set)

    sql = "INSERT INTO `样本2` ("
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

    #print(sqls)

    with open(out_path, 'w', encoding='UTF-8') as f:
        f.writelines(sqls)
        f.write('\n')
