# :pushpin: 섹션 1 정리
> 기본 문제 풀이

## 목차
[1. 세 수 중 최솟값](#1-세-수-중-최솟값) <br>
[2. 삼각형 판별하기](#2-삼각형-판별하기) <br>
[3. 연필 개수](#3-연필-개수) <br>
[4. 1부터 N까지 합 출력하기](#4-1부터-N까지-합-출력하기) <br>
[5. 최솟값 구하기](#5-최솟값-구하기) <br>
[6. 홀수](#6-홀수) <br>
[7. 10부제](#7-10부제) <br>
[8. 일곱 난쟁이](#8-일곱-난쟁이) <br>
[9. A를 #으로](#9-A를-으로) <br>
[10. 문자 찾기](#10-문자-찾기) <br>
[11. 대문자 찾기](#11-대문자-찾기) <br>
[12. 대문자로 통일](#12-대문자로-통일) <br>
[13. 대소문자 변환](#13-대소문자-변환) <br>
[14. 가장 긴 문자열](#14-가장-긴-문자열) <br>
[15. 가운데 문자 출력](#15-가운데-문자-출력) <br>
[16. 중복문자제거](#16-중복문자제거) <br>
[17. 중복단어제거](#17-중복단어제거) <br>

<br>

## 1. 세 수 중 최솟값
100이하의 자연수 A, B, C를 입력받아 세 수 중 가장 작은 값을 출력하는 프로그램을 작성하세요.(정렬을 사용하면 안됩니다)
### 입력설명
첫 번째 줄에 100이하의 세 자연수가 입력된다.
### 출력설명
첫 번째 줄에 가장 작은 수를 출력한다.
### 입력예제 1 
6 5 11
### 출력예제 1
5
### 작성코드 
```jsx
// 해설 코드
function solution(a, b, c){
    let answer;
    if(a<b) answer=a;
    else answer=b;
    if(c<answer) answer=c; 
    return answer;
}

console.log(solution(2, 5, 1));

// 내가 작성한 코드
function solution(a, b, c){
    let answer = 0;
    let maxNum = a;
    if (a < b){
        maxNum = b;
        if (b < c){
            maxNum = c;
        }
    }
    answer = maxNum;
    return answer;
}
console.log(solution(17, 6, 10));
```
### 부족했던 점
#### **{}를 쓰지 않고 간략하게 조건문 작성이 가능하다는 점을 몰랐다.** 
적어도 알고리즘 연습시엔 코드 길이를 줄일 수 있는 팁이라고 생각된다.

<br>

## 2. 삼각형 판별하기
길이가 서로 다른 A, B, C 세 개의 막대 길이가 주어지면 이 세 막대로 삼각형을 만들 수 있으면 “YES"를 출력하고, 만들 수 없으면 ”NO"를 출력한다.
### 입력설명
첫 번째 줄에 100이하의 서로 다른 A, B, C 막대의 길이가 주어진다.
### 출력설명
첫 번째 줄에 “YES", "NO"를 출력한다.
### 입력예제 1 
6 7 11
### 출력예제 1
YES
### 입력예제 2
13 33 17
### 출력예제 2
NO

### 작성코드 
```jsx
// 해설 코드
function solution(a, b, c){
    let answer="YES", max;
    let tot=a+b+c;
    if(a>b) max=a;
    else max=b;
    if(c>max) max=c;
    if(tot-max<=max) answer="NO"; 
    return answer;
}

console.log(solution(13, 33, 17));

// 내가 작성한 코드
function solution(a, b, c){
    let answer="YES", max;
        if (a >= b+c) answer = 'NO';
        if (b >= a+c) answer = 'NO';
        if (c >= a+b) answer = 'NO';
                            
    return answer;
}

console.log(solution(13, 22, 17));
```
### 부족했던 점
#### **max 변수를 활용하지 않았다.** 
이유는 (a+b+c)-max = 가장 긴 변을 제외한 두 변의 길이라는 생각을 못했다.<br>
결과는 같지만 이해도가 부족했다.

<br>

## 3. 연필 개수
연필 1 다스는 12자루입니다. 학생 1인당 연필을 1자루씩 나누어 준다고 할 때 N명이 학생 수를 입력하면 필요한 연필의 다스 수를 계산하는 프로그램을 작성하세요.
### 입력설명
첫 번째 줄에 1000 이하의 자연수 N이 입력된다.
### 출력설명
첫 번째 줄에 필요한 다스 수를 출력합니다.
### 입력예제 1 
25
### 출력예제 1
3
### 입력예제 2 
178
### 출력예제 2
15

### 작성코드 
```jsx
// 해설 코드
function solution(n){
    let answer;
    answer=Math.ceil(n/12);
    return answer;
}

console.log(solution(178));

// 내가 작성한 코드
function solution(n){
    let answer = Math.ceil(n/12); // Math객체 활용
    return answer;
}

console.log(solution(25));
```

<br>

## 4. 1부터 N까지 합 출력하기
자연수 N이 입력되면 1부터 N까지의 합을 출력하는 프로그램을 작성하세요. 
### 입력설명
첫 번째 줄에 20이하의 자연수 N이 입력된다..
### 출력설명
첫 번째 줄에 1부터 N까지의 합을 출력한다.
### 입력예제 1 
6 
### 출력예제 1
21
### 입력예제 2 
10
### 출력예제 2
55

### 작성코드 
```jsx
// 해설 코드
function solution(n){
    let answer=0;
    for(let i=1; i<=n; i++){
        answer=answer+i;
    }
    return answer;
}

console.log(solution(10));

// 내가 작성한 코드
function solution(n){
    let answer=0;
        for(let i=1; i<=n; i++){
            answer += i;
    }
    return answer;
}
console.log(solution(5));
```
<br>

## 5. 최솟값 구하기
7개의 수가 주어지면 그 숫자 중 가장 작은 수를 출력하는 프로그램을 작성하세요.
### 입력설명
첫 번째 줄에 7개의 수가 주어진다.
### 출력설명
첫 번째 줄에 가장 작은 값을 출력한다.
### 입력예제 1 
5 3 7 11 2 15 17
### 출력예제 1
2

### 작성코드 
```jsx
// 해설 코드
function solution(arr){         
    let answer, min=Number.MAX_SAFE_INTEGER; // 가장 큰 정수를 선언, Number 객체의 메소드
    for(let i=0; i<arr.length; i++){
        if(arr[i]<min) min=arr[i];
    }
    answer=min;
    return answer;
}
let arr=[5, 7, 1, 3, 2, 9, 11];
console.log(solution(arr));

// 내가 작성한 코드
function solution(arr){
    let answer, min, num;
    min = arr[0];
    for(let i=1; i<arr.length; i++){
        num = arr[i]
        if(min > num) min = num;
    }
    answer = min;
    return answer;
}
let arr=[5, 7, 4, 3, 15, 9, 11];

// 추가설명 : Math.min() 객체 활용 최소값 구하기
function solution(arr){         
    let answer = Math.min(...arr)
    return answer;
}
let arr=[5, 7, 1, 3, 2, 9, 11];
console.log(solution(arr));
```
<br>

## 6. 홀수
7개의 자연수가 주어질 때, 이들 중 홀수인 자연수들을 모두 골라 그 합을 구하고, 고른 홀수들 중 최소값을 찾는 프로그램을 작성하세요.<br>
예를 들어, 7개의 자연수 12, 77, 38, 41, 53, 92, 85가 주어지면 이들 중 홀수는 77, 41, 53, 85이므로 그 합은

```77 + 41 + 53 + 85 = 256```

이 되고, <br>

```41 < 53 < 77 < 85``` 

이므로 홀수들 중 최소값은 41이 된다.

### 입력설명
첫 번째 줄에 자연수 7개가 주어진다. 주어지는 자연수는 100보다 작다. 홀수가 한 개 이상 
반드시 존재한다.
### 출력설명
첫째 줄에 홀수들의 합을 출력하고, 둘째 줄에 홀수들 중 최소값을 출력한다.
### 입력예제 1 
12 77 38 41 53 92 85
### 출력예제 1
256
4

### 작성코드 
```jsx
// 해설 코드
function solution(arr){
    let answer=[];
    let sum=0, min=1000; // 같은 데이터타입은 한줄로 정의
    for(let x of arr){ // 변수 반복문 조건식, 변수 이름은 간단하게 해도 된다. 하지막 코딩면접 시에는 자세하게 
        if(x%2===1){ // == or === 은 하나로 통일해서 사용하는 것을 추천
            sum+=x;
            if(x<min) min=x;
        }
    }
    answer.push(sum); 
    answer.push(min);     
    return answer;
}
arr=[12, 77, 38, 41, 53, 92, 85];
console.log(solution(arr));

// 내가 작성한 코드
function solution(arr){
    let oddNumber = [];
    let sum = 0;
    let min = Number.MAX_SAFE_INTEGER;
    let answer;
    for (let i=0; i<arr.length; i++){ 
        if (arr[i]%2 === 1){ 
            sum += arr[i];
            oddNumber.push(arr[i]);
        }
    }
    for(let i=0; i<oddNumber.length; i++){
        if(oddNumber[i] < min){
            min = oddNumber[i];
        }
    }
    answer = sum + ',' + min
    return answer;
}

arr=[12, 77, 38, 41, 53, 92, 85];
console.log(solution(arr));
```
### 부족했던 점
#### **불필요하게 for문 한번 더 사용**
이중 조건문을 사용하기 싫어서 구분한 것이지만 오히려 for문을 한번 더 사용하여 비효율적인 코드를 작성했다.
#### **같은 자료형의 변수를 나눠서 선언**
같은 줄에 `,` 로 구분하여 연속으로 변수를 선언하는 것이 더 깔끔한 느낌이 든다.

<br>

## 7. 10부제
서울시는 6월 1일부터 교통 혼잡을 막기 위해서 자동차 10부제를 시행한다. 자동차 10부제는 자동차 번호의 일의 자리 숫자와 날짜의 일의 자리 숫자가 일치하면 해당 자동차의 운행을 금지하는 것이다. <br>

예를 들어, 자동차 번호의 일의 자리 숫자가 7이면 7일, 17일, 27일에 운행하지 못한다. 또한, 자동차 번호의 일의 자리 숫자가 0이면 10일, 20일, 30일에 운행하지 못한다. <br>

여러분들은 일일 경찰관이 되어 10부제를 위반하는 자동차의 대수를 세는 봉사활동을 하려고 한다. 날짜의 일의 자리 숫자가 주어지고 7대의 자동차 번호의 끝 두 자리 수가 주어졌을 때 위반하는 자동차의 대수를 출력하는 프로그램을 작성하세요.

### 입력설명
첫 줄에는 날짜의 일의 자리 숫자가 주어지고 두 번째 줄에는 7대의 자동차 번호의 끝 두 자
리 숫자가 주어진다. 
### 출력설명
주어진 날짜와 자동차의 일의 자리 숫자를 보고 10부제를 위반하는 차량의 대수를 출력합니
다.
### 입력예제 1 
3
25 23 11 47 53 17 33
### 출력예제 1
3
### 입력예제 2 
0
12 20 54 30 87 91 30
### 출력예제 2
3
### 작성코드 
```jsx
// 해설 코드
function solution(day, arr){
    let answer=0;
    for(let x of arr){
        if(x%10==day) answer++; 
    }
    
    return answer;
}

arr=[25, 23, 11, 47, 53, 17, 33];
console.log(solution(3, arr));

// 내가 작성한 코드
function solution(day, arr){
    let answer=0;
    for (let i of arr){
        if(i%10 === day) answer += 1;
    }
    return answer;
}
arr=[25, 23, 11, 47, 53, 17, 33];
console.log(solution(3, arr));
```
### 부족했던 점
#### **1씩 증가하는 변수에는 ++로도 사용 가능**
`answer += 1` 과 `answer++` 는 같은 기능을 수행한다.

<br>

## 8. 일곱 난쟁이
왕비를 피해 일곱 난쟁이들과 함께 평화롭게 생활하고 있던 백설공주에게 위기가 찾아왔다. 
일과를 마치고 돌아온 난쟁이가 일곱 명이 아닌 아홉 명이었던 것이다.
아홉 명의 난쟁이는 모두 자신이 "백설 공주와 일곱 난쟁이"의 주인공이라고 주장했다. 뛰어난 수학적 직관력을 가지고 있던 백설공주는, 다행스럽게도 일곱 난쟁이의 **키의 합이 100**이 됨을 기억해 냈다. <br>

아홉 난쟁이의 키가 주어졌을 때, 백설공주를 도와 일곱 난쟁이를 찾는 프로그램을 작성하시
오.

### 입력설명
아홉 개의 줄에 걸쳐 난쟁이들의 키가 주어진다. 주어지는 키는 100을 넘지 않는 자연수이며, 
아홉 난쟁이의 키는 모두 다르며, 가능한 정답이 여러 가지인 경우에는 아무거나 출력한다.
### 출력설명
입력된 순서대로 일곱 난쟁이의 키를 출력한다.
### 입력예제 1 
20 7 23 19 10 15 25 8 13
### 출력예제 1
20 7 23 19 10 8 13
### 작성코드 
```jsx
// 해설 코드
function solution(arr){
    let answer=arr;
    let sum=answer.reduce((a, b)=>a+b, 0); 
    for(let i=0; i<8; i++){
        for(let j=i+1; j<9; j++){
            if((sum-(answer[i]+answer[j]))==100){
                answer.splice(j, 1); // i번째보다 무조건 뒷 순서인 j 먼저 삭제
                answer.splice(i, 1);
            }
        }
    }
    return answer;
}
let arr=[20, 7, 23, 19, 10, 15, 25, 8, 13];
console.log(solution(arr));

// 내가 작성한 코드
function solution(arr){
    let answer = arr;
    let sum = arr.reduce(function (acc, v){
        return acc + v
    },0)
    for(let i=0; i< arr.length; i++){
        if(sum-(arr[i]+arr[i+1]) === 100){
            answer.splice(i,2);
        }
    }
    return answer;
}
let arr=[20, 7, 23, 19, 10, 15, 25, 8, 13];
console.log(solution(arr));
```
### 부족했던 점
#### **이중루프 미사용**
배열 내에서 뽑아낼 수 있는 모든 경우의 수를 구현하기 위해 이중 루프를 사용하면 됐지만 이를 활용하지 않았다.<br>
내가 작성한 코드는 두명의 가짜 난쟁이가 붙어있지 않다면 오류를 범하는 코드.
#### **reuce() 메소드 사용 미숙**
`=>`를 활용해 간단하게 메소드를 활용할 수 있다. 그리고 callback 함수에 이름은 굳이 필요하지 않는다. 함수의 매개변수가 중요하다.  

<br>

## 9. A를 #으로
대문자로 이루어진 영어단어가 입력되면 단어에 포함된 ‘A'를 모두 ’#‘으로 바꾸어 출력하는 프로그램을 작성하세요.
### 입력설명
첫 번째 줄에 문자열이 입력된다.
### 출력설명
첫 번째 줄에 바뀐 단어를 출력한다.
### 입력예제 1 
BANANA
### 출력예제 1
B#N#N#
### 작성코드 
```jsx
// 해설 코드 1
function solution(s){
    let answer="";
    for(let x of s){
        if(x=='A') answer+='#';
        else answer+=x;
    }
    return answer;
}

let str="BANANA";
console.log(solution(str));
 
// 해설 코드 2 (정규 표현식 활용)
function solution(s){
    let answer=s;
    answer=answer.replace(/A/g, "#");
    return answer;
}

let str="BANANA";
console.log(solution(str));

// 내가 작성한 코드
function solution(s){   
    let answer = '';
        for(let i of s){
        if(i === 'A') i = "#";
        answer += i;
    }
    return answer;
}
let str="ONANANA";
console.log(solution(str));
```
### 부족했던 점
#### **정규표현식을 활용한 replace()메소드 미사용**
설명 참고 : [링크](https://github.com/kimcno3/TIL/blob/main/programming_language/javascript.md#replace)

<br>

## 10. 문자 찾기
한 개의 문자열을 입력받고, 특정 문자를 입력받아 해당 특정문자가 입력받은 문자열에 몇 개 존재하는지 알아내는 프로그램을 작성하세요. 문자열의 길이는 100을 넘지 않습니다.
### 입력설명
첫 줄에 문자열이 주어지고, 두 번째 줄에 문자가 주어진다. 
### 출력설명
첫 줄에 해당 문자의 개수를 출력한다.
### 입력예제 1 
COMPUTERPROGRAMMING <br>
R
### 출력예제 1
3
### 작성코드 
```jsx
// 해설 코드 1
function solution(s, t){
    let answer=0;
    for(let x of s){
        if(x===t) answer++;
    }
    return answer;
}

let str="COMPUTERPROGRAMMING";
console.log(solution(str, 'R'));

// 해설코드 2 
    function solution(s, t){
        let answer=s.split(t).length;
        return answer-1;
    }
    
    let str="COMPUTERPROGRAMMING";
    console.log(solution(str, 'R'));

// 내가 작성한 코드
function solution(s, t){
    let answer = 0
    for(let i of s){
        if(i === t) answer += 1; 
    }
    return answer;
}

let str="";
console.log(solution(str, 'R'));
```
### 부족했던 점
#### **split()을 미활용**
'R'을 기준으로 문자열을 쪼개면 `R의 개수+1개` 의 길이로 배열이 생성한다.<br>
이를 활용해 전체 `배열의 전체 요소 개수-1개` 이 기존 문자열에 포함된 R의 개수가 된다.

<br>

## 11. 대문자 찾기
한 개의 문자열을 입력받아 해당 문자열에 알파벳 대문자가 몇 개 있는지 알아내는 프로그램
을 작성하세요.
### 입력설명
첫 줄에 문자열이 입력된다. 문자열의 길이는 100을 넘지 않습니다.
### 출력설명
첫 줄에 대문자의 개수를 출력한다.
### 입력예제 1 
KoreaTimeGood
### 출력예제 1
3
### 작성코드 
```jsx
// 해설 코드 1
function solution(s){         
    let answer=0;
    for(let x of s){
        //let num=x.charCodeAt();
        //if(num>=65 && num<=90) answer++;
        if(x===x.toUpperCase()) answer++; 
    }

    return answer;
}

let str="KoreaTimeGood";
console.log(solution(str));

// 해설 코드 2 (ASCII 코드 활용)
function solution(s){         
    let answer=0;
    for(let x of s){
        let num=x.charCodeAt();
        if(num>=65 && num<=90) answer++;
    }

    return answer;
}

let str="KoreaTimeGood";
console.log(solution(str));
// 내가 작성한 코드
function solution(s){         
    let answer=0;
    for(let i of s){
        if(i === i.toUpperCase()) answer++;
    }
    return answer;
}
let str="KoreaTimeGood";
console.log(solution(str));
```

### 부족했던 점
#### **ASCII 코드 활용 방법**
`.charCodeAt()` 메소드를 활용하면 해당 문자열의 ASCII 코드로 바꿔준다.
- 대문자 : 65 ~ 90
- 소문자 : 97 ~ 122

<br>

## 12. 대문자로 통일
대문자와 소문자가 같이 존재하는 문자열을 입력받아 대문자로 모두 통일하여 문자열을 출력
하는 프로그램을 작성하세요.
### 입력설명
첫 줄에 문자열이 입력된다. 문자열의 길이는 100을 넘지 않습니다.
### 출력설명
첫 줄에 대문자로 통일된 문자열이 출력된다.
### 입력예제 1 
ItisTimeToStudy
### 출력예제 1
ITISTIMETOSTUDY
### 작성코드 
```jsx
// 해설 코드 1
function solution(s){         
    let answer="";
    if(x===x.toLowerCase()) answer+=x.toUpperCase();
    else answer+=x;
    }

    return answer;

}

let str="ItisTimeToStudy";
console.log(solution(str));

// 해설 코드 2 (ASCII 코드 활용)
function solution(s){         
    let answer="";
    for(let x of s){
        let num=x.charCodeAt();
        if(num>=97 && num<=122) answer+=String.fromCharCode(num-32);
        else answer+=x;
    }

    return answer;

}

let str="ItisTimeToStudy";
console.log(solution(str));

// 내가 작성한 코드 1
function solution(s){         
    let answer = s.toUpperCase();
    return answer;
}
let str="ItisTimeToStudy";
console.log(solution(str));

// 작성 코드 2 (ASCII 코드 활용)
function solution(s){         
    let answer = '';
    for (let i of s){
        if(97 <= i.charCodeAt() <= 122) 
        answer += i.toUpperCase();
        else 
        answer += i; 
    }
    return answer;
}
let str="ItisTimeToStudy";
console.log(solution(str));
```

<br>

## 13. 대소문자 변환
대문자와 소문자가 같이 존재하는 문자열을 입력받아 대문자는 소문자로 소문자는 대문자로 변환하여 출력하는 프로그램을 작성하세요.
### 입력설명
첫 줄에 문자열이 입력된다. 문자열의 길이는 100을 넘지 않습니다.
### 출력설명
첫 줄에 대문자는 소문자로, 소문자는 대문자로 변환된 문자열을 출력합니다.
### 입력예제 1 
StuDY
### 출력예제 1
sTUdy
### 작성코드 
```jsx
// 해설 코드
function solution(s){  
    let answer="";
    for(let x of s){
        if(x===x.toUpperCase()) answer+=x.toLowerCase();
        else answer+=x.toUpperCase();
    }
    return answer;
}
console.log(solution("StuDY"));

// 내가 작성한 코드
function solution(s){  
    let answer="";
    for (let i of s){
        if(i === i.toUpperCase()) answer += i.toLowerCase();
        else if (i === i.toLowerCase()) answer += i.toUpperCase();
    }
    return answer;
}
console.log(solution("StuDY"));
```

<br>

## 14. 가장 긴 문자열
N개의 문자열이 입력되면 그 중 가장 긴 문자열을 출력하는 프로그램을 작성하세요.
### 입력설명
첫 줄에 자연수 N이 주어진다.(3<=N<=30)
두 번째 줄부터 N개의 문자열이 주어진다. 문자열의 길이는 100을 넘지 않습니다.
각 문자열의 길이는 서로 다릅니다.
### 출력설명
첫 줄에 가장 긴 문자열을 출력한다.
### 입력예제 1 
5 <br>
teacher<br>
time<br>
student<br>
beautiful<br>
good<br>
### 출력예제 1
beautiful
### 작성코드 
```jsx
// 해설 코드
function solution(s){  
    let answer="", max=Number.MIN_SAFE_INTEGER;
    for(let x of s){
        if(x.length>max){
            max=x.length;
            answer=x;
        }
    }
    return answer;
}
let str=["teacher", "time", "student", "beautiful", "good"];
console.log(solution(str));

// 내가 작성한 코드
function solution(s){  
    let answer = '' , num = 0;
    for(let i of s){
        if(i.length > num){
            num = i.length; 
            answer = i;
        } 
    }
    return answer;
}
let str=["teacher", "time", "student", "beautiful", "good"];
console.log(solution(str));
```

<br>

## 15. 가운데 문자 출력
소문자로 된 단어(문자열)가 입력되면 그 단어의 가운데 문자를 출력하는 프로그램을 작성하세
요. 단 단어의 길이가 짝수일 경우 가운데 2개의 문자를 출력합니다.
### 입력설명
첫 줄에 문자열이 입력된다. 문자열의 길이는 100을 넘지 않습니다.
### 출력설명
첫 줄에 가운데 문자를 출력합니다.
### 입력예제 1 
study
### 출력예제 1
u
### 입력예제 2 
good
### 출력예제 2
oo
### 작성코드 
```jsx
// 해설 코드
function solution(s){  
    let answer;
    let mid=Math.floor(s.length/2)
    if(s.length%2===1) answer=s.substring(mid, mid+1);
    else answer=s.substring(mid-1, mid+1);
    //if(s.length%2===1) answer=s.substr(mid, 1);
    //else answer=s.substr(mid-1, 2);
    return answer;
}
console.log(solution("study"));

// 내가 작성한 코드
function solution(s){  
    let answer = '';
    let c = s.length/2;
    if (s.length%2 === 0) answer = s[c-1] + s[c];
    else answer = s[Math.floor(c)];
    return answer;
}
console.log(solution("study"));

```
### 부족했던 점
#### **`substring()` , `substr()` 메소드 활용**
설명 참고 : [링크](https://github.com/kimcno3/TIL/blob/main/programming_language/javascript.md#substring--substr)

<br>
 
## 16. 중복문자제거
소문자로 된 한개의 문자열이 입력되면 중복된 문자를 제거하고 출력하는 프로그램을 작성하
세요.
제거된 문자열의 각 문자는 원래 문자열의 순서를 유지합니다.
### 입력설명
첫 줄에 문자열이 입력됩니다.
### 출력설명
첫 줄에 중복문자가 제거된 문자열을 출력합니다.
### 입력예제 1 
ksekkset
### 출력예제 1
kset
### 작성코드 
```jsx
// 해설 코드
function solution(s){  
    let answer="";
    //console.log(s.indexOf("K"));
    for(let i=0; i<s.length; i++){
        //console.log(s[i], i, s.indexOf(s[i]));
        if(s.indexOf(s[i])===i) answer+=s[i];
    }
    return answer;
}
console.log(solution("ksekkset"));
// 내가 작성한 코드
function solution(s){  
    let answer="";
    for (let i of s){
        if(answer.indexOf(i) === -1) answer += i;
    }
    return answer;
}
console.log(solution("ksekkset"));
```

<br>
 
## 17. 중복단어제거
N개의 문자열이 입력되면 중복된 문자열은 제거하고 출력하는 프로그램을 작성하세요.
출력하는 문자열은 원래의 입력순서를 유지합니다.
### 입력설명
첫 줄에 자연수 N이 주어진다.(3<=N<=30)<br>
두 번째 줄부터 N개의 문자열이 주어진다. 문자열의 길이는 100을 넘지 않습니다.
### 출력설명
첫 줄부터 중복이 제거된 문자열을 차례로 출력한다.
### 입력예제 1 
5 <br>
good <br>
time <br>
good <br>
time <br>
student <br>
### 출력예제 1
good <br>
time <br>
student <br>
### 작성코드 
```jsx
// 해설 코드
function solution(s){  
    let answer;
    answer=s.filter(function(v, i){
        return s.indexOf(v)===i;
    });
    return answer;

    // filter() 단순환
    // answer = s.filter((v,i) => s.indexOf(v) === i);
}
let str=["good", "time", "good", "time", "student"];
console.log(solution(str));

// 내가 작성한 코드 
function solution(s){  
    let answer = [];
    for(let i of s){
        if(answer.indexOf(i) === -1) answer.push(i); 
    }
    return answer;
}
let str=["good", "time", "good", "time", "student"];
console.log(solution(str));
```
### 부족했던 점
#### **filter() 메소드 미사용**
설명 참고 : [링크](https://github.com/kimcno3/TIL/blob/main/programming_language/javascript.md#filter--%EA%B8%B0%EC%A1%B4-%EB%B0%B0%EC%97%B4%EC%97%90%EC%84%9C-%ED%8A%B9%EC%A0%95-%EC%A1%B0%EA%B1%B4%EC%97%90-%ED%95%B4%EB%8B%B9%ED%95%98%EB%8A%94-%EC%9A%94%EC%86%8C%EB%A7%8C-%EA%B0%80%EC%A0%B8%EC%98%A4%EB%8A%94-%ED%95%A8%EC%88%98)