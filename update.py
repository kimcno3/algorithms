#!/usr/bin/env python

import os
from urllib import parse

HEADER="""# 
# 백준 & 프로그래머스 문제 풀이 목록

> 유형별 문제를 확인하고 싶다면 [여기](./category)를 클릭하세요!

"""

def main():
    content = ""
    content += HEADER
    
    directories = [];
    solveds = [];

    for root, dirs, files in os.walk("."):
        dirs.sort()
        if root == '.':
            for dir in ('.git', '.github'):
                try:
                    dirs.remove(dir)
                except ValueError:
                    pass
            continue

        category = os.path.basename(root)
        
        if category == 'images':
            continue

        dirname = os.path.dirname(root)

        # 테이블에 포함하고자 하는 디렉토리 이름 외 다른 이름들은 제외
        if not dirname.startswith("./프로그래머스") and not dirname.startswith("./백준") :
            continue

        directory = os.path.basename(dirname)

        if directory == '.':
            continue
            
        if directory not in directories:
            if directory in ["백준", "프로그래머스"]:
                content += "## 📚 {}\n".format(directory)
                content += "| 문제번호 | 링크 | 난이도 |\n"
                content += "| ----- | ----- | ----- |\n"
            directories.append(directory)
        for file in files:
            if category not in solveds:
                content += "|{}|[링크]({})|{}|\n".format(category, parse.quote(os.path.join(root)), directory)
                solveds.append(category)

    with open("README.md", "w") as fd:
        fd.write(content)
        
if __name__ == "__main__":
    main()
