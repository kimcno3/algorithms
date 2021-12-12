 # :pushpin: 섹션 3 정리
> 문자열 탐색

## 목차
[1. 회문 문자열](#1-회문-문자열) <br>
[2. 유효한 팰린드롬](#2-유효한-팰린드롬) <br>
[3. 숫자만 추출](#3-숫자만-추출) <br>
[4. 가장 짧은 문자거리](#4-가장-짧은-문자거리) <br>
[5. 문자열 압축](#5-문자열-압축) <br>

 <br>

## 1. 회문 문자열
앞에서 읽을 때나 뒤에서 읽을 때나 같은 문자열을 회문 문자열이라고 합니다. 문자열이 입력되면 해당 문자열이 회문 문자열이면 "YES", 회문 문자열이 아니면 “NO"를 출력하는 프로그램을 작성하세요.
단 회문을 검사할 때 대소문자를 구분하지 않습니다.
### 입력설명
첫 줄에 정수 길이 100을 넘지 않는 공백이 없는 문자열이 주어집니다. 
### 출력설명
첫 번째 줄에 회문 문자열인지의 결과를 YES 또는 NO로 출력합니다.
### 입력예제 1 
gooG
### 출력예제 1
YES
### 작성코드 
```jsx
// 해설 코드
function solution(s){
    let answer="YES";
    s=s.toLowerCase();
    let len=s.length;
    // 반대되는 인덱스끼리 비교(구분)
    for(let i=0; i<Math.floor(len/2); i++){
        if(s[i]!=s[len-i-1]) return "NO";
    }
    return answer;
}

let str="goooG";
console.log(solution(str));

// 해설 코드 2
function solution(s){
    let answer="YES";
    s=s.toLowerCase();
    // 뒤집은 문자열 전체를 새로 만들어 비교(전체)
    if(s.split('').reverse().join('')!=s) return "NO";    
    return answer;
}

let str="gooG";
console.log(solution(str));

// 내가 작성한 코드
function solution(s){
    let answer="YES";
    let str = s.toUpperCase();
    let newStr = [];
    for (let i of str){
        newStr.unshift(i);
    }
    if(str !== newStr.join('')){
        answer = 'No';
    }
    return answer;
}

let str="goooG";
console.log(solution(str));
```
### 부족했던 점
#### **reverse() 메소드**
배열의 순서를 뒤집는 reverse() 메소드를 활용하지 않았다.


<br>

## 2. 유효한 팰린드롬
앞에서 읽을 때나 뒤에서 읽을 때나 같은 문자열을 팰린드롬이라고 합니다.
문자열이 입력되면 해당 문자열이 팰린드롬이면 "YES", 아니면 “NO"를 출력하는 프로그램을 작성하세요. 단 회문을 검사할 때 알파벳만 가지고 회문을 검사하며, 대소문자를 구분하지 않습니다. 알파벳 이외의 문자들의 무시합니다.
### 입력설명
첫 줄에 정수 길이 100을 넘지 않는 공백이 없는 문자열이 주어집니다. 
### 출력설명
첫 번째 줄에 팰린드롬인지의 결과를 YES 또는 NO로 출력합니다.
### 입력예제 1 
found7, time: study; Yduts; emit, 7Dnuof
### 출력예제 1
YES
### 작성코드 
```jsx
// 해설 코드
function solution(s){
    let answer="YES";
    s=s.toLowerCase().replace(/[^a-z]/g, '');
    if(s.split('').reverse().join('')!==s) return "NO";
    return answer;
}

let str="found7, time: study; Yduts; emit, 7Dnuof";
console.log(solution(str));

// 내가 작성한 코드
function solution(s){
    let answer="YES";
    // 알파벳 소문자가 아닌 모든 문자는 ''으로 교체한다는 뜻
    s = s.replace(/[^a-z]/g,'').toUpperCase();
    if(s !== s.split('').reverse().join('')){
        answer = 'NO'
    }
    return answer;
}

let str="found7, time: study; Yduts; emit, 7Dnuof";
console.log(solution(str));
```
### 부족했던 점
#### **replace()와 정규표현식 활용법 미숙**
추가 설명 내용 : [링크](https://github.com/kimcno3/TIL/blob/main/programming_language/javascript.md#replace)

<br>

## 3. 숫자만 추출
문자와 숫자가 섞여있는 문자열이 주어지면 그 중 숫자만 추출하여 그 순서대로 자연수를 만듭니다. 
만약 “tge0a1h205er”에서 숫자만 추출하면 0, 1, 2, 0, 5이고 이것을 자연수를 만들면 1205이 됩니다. 
추출하여 만들어지는 자연수는 100,000,000을 넘지 않습니다.
### 입력설명
첫 줄에 숫자가 썩인 문자열이 주어집니다. 문자열의 길이는 50을 넘지 않습니다.
### 출력설명
첫 줄에 자연수를 출력합니다.
### 입력예제 1 
g0en2T0s8eSoft
### 출력예제 1
208
### 작성코드 
```jsx
// 해설 코드
function solution(str){
    let answer="";
    for(let x of str){
        if(!isNaN(x)) answer+=x;
    }  
    return parseInt(answer);
}

let str="g0en2T0s8eSoft";
console.log(solution(str));

// 내가 작성한 코드
function solution(str){
    let answer="";
    str = str.replace(/[^0-9]/g,'');
    return Number(str);
}

let str="g0en2T0s8eSoft";
console.log(solution(str));
```
### 부족했던 점
#### **isNaN()함수 미사용**
정규 표현식을 사용하지 말라는 조건이 걸려있을 때, 활용가능한 메소드
#### **parseInt()함수 미사용**
`parseInt()` 와 `Number()`의 차이점<br> 
두 메소드는 같은 기능을 하지만 `parseInt()`은 문자열로 된 부분에서 숫자(정수)만 뽑아서 변환해주는것이 특징이고, `Number()`은 문자열 전체가 숫자일때 소수점까지 숫자타입으로 가져올 수 있다.

<br>

## 4. 가장 짧은 문자거리
한 개의 문자열 s와 문자 t가 주어지면 문자열 s의 각 문자가 문자 t와 떨어진 최소거리를 출력하는 프로그램을 작성하세요. 
### 입력설명
첫 번째 줄에 문자열 s와 문자 t가 주어진다. 문자열과 문자는 소문자로만 주어집니다.
문자열의 길이는 100을 넘지 않는다.
### 출력설명
첫 번째 줄에 각 문자열 s의 각 문자가 문자 t와 떨어진 거리를 순서대로 출력한다.
### 입력예제 1 
teachermode e
### 출력예제 1
1 0 1 2 1 0 1 2 2 1 0
### 작성코드 
```jsx
// 해설 코드
function solution(s, t){
    let answer=[];
    // 오름차순 for문
    let p=1000;
    for(let x of s){
        if(x===t){
            p=0;
            answer.push(p);
        }
        else{
            p++;
            answer.push(p);
        }
    }
    // 내림차순 for문
    p=1000;
    for(let i=s.length-1; i>=0; i--){
        if(s[i]===t) p=0;
        else{
            p++;
            answer[i]=Math.min(answer[i], p);
        }
    }
    return answer;
}
let str="teachermode";
console.log(solution(str, 'e'));

// 내가 작성한 코드
function solution(s, t){
    let answer = '';
    let count = 0;
    let str = '';
    // e를 기준으로 count수 체크한 배열 생성 = str
    for (let i=0; i<s.length; i++){
        if(s[i] === 'e'){
            count = 0;
            str += count;
        }else {
            count++;
            str += count;
        }
    }
    // 0을 기준으로 배열 나누기
    str = str.split(0);
    // 나눈 각 배열의 길이 절반 이상의 값만 변환
    for (let i=0; i<str.length; i++){
        for (let j=0; j<str[i].length; j++){
            if (Number(str[i][j]) > Math.ceil(str[i].length/2) && str[i].length > 2){
                str[i] = str[i].replace(str[i][j] , String(str[i].length - j))
            }
        }
    }
    // 배열 합치기
    answer = str.join('0').split('').join(' ');
    return answer;
}
let str="teachermode";
console.log(solution(str, 'e'));
```
### 부족했던 점
#### **for문의 방향을 오름차순만 활용**
`Math.min(value1, value2)` 를 활용했다면 더 간단하게 해결가능했다.

#### **추가 설명**
**해설코드 해석** <br>
같은 인덱스에 두 수 중 더 작은 수를 선택하고 answer에 추가 
```
answer = 1 0 1 2 3 0 1 2 3 4 0 오름차순 for문
answer = 1 0 3 2 1 0 4 3 2 1 0 내림차순 for문
```

<br>

**내가 작성한 코드 해석** <br>

나눠진 각 배열 중 배열의 중간 이상 넘어간 요소들만 뽑아내고(배열 길이가 1이라면 양쪽에 'e'가 존재함으로 길이가 2 이상인 경우만 적용) <br>
그 다음 `배열 길이 - 인덱스 값`을 `replace()`

```
str = 1 0 1 2 3 0 1 2 3 4 0 
    = ['1'],['123'],['1234'],[''] 
    = ['1'],['121(3-2)'],['122(4-2)1(4-3)'],[''] 
    = 10121012210 
    = 1 0 1 2 1 0 1 2 2 1 0 
```

<br>

## 5. 문자열 압축
알파벳 대문자로 이루어진 문자열을 입력받아 같은 문자가 연속으로 반복되는 경우 반복되는 문자 바로 오른쪽에 반복 횟수를 표기하는 방법으로 문자열을 압축하는 프로그램을 작성하시오. 단 반복횟수가 1인 경우 생략합니다.
### 입력설명
첫 줄에 문자열이 주어진다. 문자열의 길이는 100을 넘지 않는다.
### 출력설명
첫 줄에 압축된 문자열을 출력한다.
### 입력예제 1 
KKHSSSSSSSE
### 출력예제 1
K2HS7E
### 작성코드 
```jsx
// 해설 코드
function solution(s){
    let answer="";
    let cnt=1;
    s=s+" ";
    for(let i=0; i<s.length-1; i++){
        if(s[i]===s[i+1]) cnt++;
        else{
            answer+=s[i];
            if(cnt>1) answer+=String(cnt);
            cnt=1;
        }
    }
    return answer;
}

let str="KKHSSSSSSSE";
console.log(solution(str));

// 내가 작성한 코드
function solution(s){
    let answer = s[0];
    let count = 1;
    for(let i=1; i<s.length; i++){
        let current = s[i];
        let past = s[i-1];
        if(current === past){
            count++;
        } else {
            answer += String(count);
            answer += current;
            count = 1;
        }
    }
    answer += count;
    answer = answer.replace(/1/g,'')
    return answer;
}
let str="KKHSSSSSSSE";
console.log(solution(str));
```
### 부족했던 점
#### **문자열에 빈칸 추가 후 idnex=0부터 시작**
문자열 길이를 빈칸으로 하나 늘려주고 반복문을 0부터 시작했다면 반복문내에 조건문이 더 간단했을 것이다.
#### **1을 생략하는 조건문 미사용**
내가 작성한 코드는 정규표현식을 활용해 마지막에 answer에서 1이란 숫자를 없앴지만 이중 조건문을 활용해서 아얘 추가를 안할 수 있다.

<br>