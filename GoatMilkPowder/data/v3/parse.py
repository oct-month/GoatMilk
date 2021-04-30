

if __name__ == '__main__':
    with open('data.txt', 'r', encoding='utf-8') as f:
        with open('data.sql', 'w', encoding='utf-8') as f2:
            for line in f.readlines()[1:]:
                Id, abs260, abs280, ab68, dna = line.split('\t')
                sql = f'INSERT INTO `羊奶粉dna含量` (`id`, `Abs260`, `Abs280`, `Abs260_280`, `DNA_content`) VALUES ({Id}, {abs260}, {abs280}, {ab68}, {dna.strip()});\n'
                f2.write(sql)
