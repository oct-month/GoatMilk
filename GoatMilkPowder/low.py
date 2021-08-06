
if __name__ == '__main__':
    with open('data.sql', 'r', encoding='UTF-8') as fp:
        t = fp.read()
        for i in range(ord('A'), ord('Z') + 1):
            t = t.replace(chr(i), chr(i + 32))
    with open('data.sql', 'w', encoding='UTF-8') as fp:
        fp.write(t)
