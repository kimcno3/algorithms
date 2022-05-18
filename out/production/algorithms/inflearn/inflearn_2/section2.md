 # :pushpin: 섹션 2 정리
> 1, 2차원 배열 탐색

## 목차
[1. 큰 수 출력하기](#1-큰-수-출력하기) <br>
[2. 보이는 학생](#2-보이는-학생) <br>
[3. 가위 바위 보](#3-가위-바위-보) <br>
[4. 점수계산](#4-점수계산) <br>
[5. 등수구하기](#5-등수구하기) <br>
[6. 격자판 최대합](#6-격자판-최대합) <br>
[7. 봉우리](#7-봉우리) <br>

 <br>

## 1. 큰 수 출력하기
N(1<=N<=100)개의 정수를 입력받아, 자신의 바로 앞 수보다 큰 수만 출력하는 프로그램을 작 성하세요.(첫 번째 수는 무조건 출력한다)
### 입력설명
첫 줄에 자연수 N이 주어지고, 그 다음 줄에 N개의 정수가 입력된다.
### 출력설명
자신의 바로 앞 수보다 큰 수만 한 줄로 출력한다.
###  입력예제 1
6 <br>
7 3 9  5 6  12
###  출력예제 1
7 9 6 12
### 작성코드 
```jsx
// 해설 코드
function solution(arr){         
    let answer=[];
    answer.push(arr[0]);
    for(let i=1; i<arr.length; i++){
        if(arr[i]>arr[i-1]) answer.push(arr[i]);
    }
    return answer;
}

let arr=[7, 3, 9, 5, 6, 12];
console.log(solution(arr))
// 내가 작성한 코드
function solution(arr){         
    let answer = [arr[0]];
    for (let i=1; i<arr.length; i++){
        if (arr[i-1] < arr[i]) answer.push(arr[i]);
    }
    return answer;
}

let arr=[7, 3, 9, 5, 6, 12];
console.log(solution(arr));
```

<br>


## 2. 보이는 학생
선생님이 N(1<=N<=1000)명의 학생을 일렬로 세웠습니다. 일렬로 서 있는 학생의 키가  앞에 서부터 순서대로 주어질 때, 맨 앞에 서 있는 선생님이 볼  수  있는 학생의  수를  구하는 프로그 램을 작성하세요. (앞에 서 있는 사람들보다 크면 보이고, 작거나 같으면 보이지 않습니다.)
### 입력설명
첫 줄에 정수 N이 입력된다. 그 다음줄에 N명의 학생의 키가 앞에서부터 순서대로 주어진다.
### 출력설명
선생님이 볼 수 있는 최대학생수를 출력한다.
### 입력예제 1
8<br>
130 135 148 140 145 150 150 153
### 출력예제 1
5
### 작성코드 
```jsx
// 해설 코드
function solution(arr){         
    let answer=1, max=arr[0];
    for(let i=1; i<arr.length; i++){
        if(arr[i]>max){
            answer++;
            max=arr[i];
        }
    }
    return answer;
}

let arr=[130, 135, 148, 140, 145, 150, 150, 153];
console.log(solution(arr));
// 내가 작성한 코드
function solution(arr){         
    let answer = 0; maxHeight = arr[0]; x=[];
    for(let i=1; i<arr.length; i++){
        if(arr[i] > maxHeight){
            maxHeight = arr[i];
            answer++;
        }
    }
    return answer;
}

let arr=[130, 135, 148, 140, 145, 150, 150, 153];
console.log(solution(arr));
```

<br>

## 3. 가위 바위 보
A,  B 두 사람이 가위바위보 게임을 합니다. 총  N번의 게임을 하여 A가 이기면 A를 출력하고, B가 이기면 B를 출력합니다. 비길 경우에는 D를 출력합니다.
가위, 바위, 보의 정보는 1:가위, 2:바위, 3:보로 정하겠습니다. <br>
예를 들어 N=5이면

|회수|1|2|3|4|5|
|:--:|:--:|:--:|:--:|:--:|:--:|
|A의 정보|2|3|3|1|3|
|B의 정보|1|1|2|2|3|
|승자|A|B|A|B|D|

두 사람의 각 회의 가위,  바위,  보 정보가 주어지면  각 회를 누가 이겼는지 출력하는 프로그램을 작성하세요.

### 입력설명
첫 번째 줄에 게임 횟수인 자연수  N(1<=N<=100)이  주어집니다. 두 번째 줄에는  A가  낸  가위, 바위, 보  정보가 N개  주어집니다. 세 번째 줄에는 B가 낸 가위, 바위, 보 정보가 N개 주어집니다.
### 출력설명
각 줄에 각 회의 승자를 출력합니다. 비겼을 경우는 D를 출력합니다.
### 입력예제 1
5 <br>
2 3 3  1  3 <br>
1 1 2  2  3 
### 출력예제 1 
A <br>
B <br>
A <br>
B <br>
D <br>
### 작성코드 
```jsx
// 해설 코드
function solution(a, b){         
    let answer="";
    for(let i=0; i<a.length; i++){
        if(a[i]===b[i]) answer+="D ";
        else if(a[i]===1 && b[i]===3) answer+="A ";
        else if(a[i]===2 && b[i]===1) answer+="A ";
        else if(a[i]===3 && b[i]===2) answer+="A ";
        else answer+="B ";
    }
    
    return answer;
}

let a=[2, 3, 3, 1, 3];
let b=[1, 1, 2, 2, 3];
console.log(solution(a, b));
// 내가 작성한 코드
function solution(a, b){         
    let answer="";
    for(let i=0; i<a.length; i++){
        if (b[i] < a[i] || (b[i] === 3 && a[i] === 1)) answer += 'A ';
        else if (a[i] < b[i] || (a[i] === 3 && b[i] === 1)) answer += 'B ';
        else if (a[i] === b[i]) answer += 'D ';
    }
    return answer;
}

let a=[2, 3, 3, 1, 3];
let b=[1, 1, 2, 2, 3];
console.log(solution(a, b));
```
### 부족했던 점
#### **불필요한 조건문 미활용**
`A가 이기는 경우`와 `비기는 경우` 외의 모든 경우의 수는 `B가 이기는 경우`인 걸 생각하지 못했다. 이로 인해 불필요하게 `B가 이기는 경우`에 대한 조건문을 작성했다. 

<br>

## 4. 점수계산
OX 문제는 맞거나 틀린 두 경우의 답을 가지는 문제를 말한다. 여러 개의 OX 문제로 만들어진 시험에서 연속적으로 답을 맞히는 경우에는 가산점을 주기 위해서  다음과 같이 점수 계산을 하기  로 하였다. 1번 문제가 맞는 경우에는 1점으로 계산한다. 앞의 문제에 대해서는  답을  틀리다가 답이 맞는 처음 문제는 1점으로 계산한다. 또한, 연속으로 문제의 답이 맞는 경우에서 두 번째 문제는 2점, 세 번째 문제는 3점, ..., K번째 문제는 K점으로 계산한다. 틀린 문제는 0점으로 계산한다. <br>
예를 들어, 아래와 같이 10 개의 OX 문제에서 답이 맞은 문제의 경우에는 1로 표시하고, 틀린 경우에는 0으로 표시하였을 때, 점수 계산은 아래 표와 같이 계산되어, 총 점수는 1+1+2+3+1+2=10 점이다.

`1 0 1 1 1 0 0 1 1 0`

|채점|1|0|1|1|1|0|0|1|1|0|
|:--:|:--:|:--:|:--:|:--:|:--:|:--:|:--:|:--:|:--:|:--:|
|점수|1|0|1|2|3|0|0|1|2|0|

시험문제의 채점 결과가 주어졌을 때, 총 점수를 계산하는 프로그램을 작성하시오.

### 입력설명
첫째 줄에 문제의 개수 N (1 ≤ N ≤ 100)이 주어진다. 둘째 줄에는 N개 문제의 채점 결과를 나 타내는 0 혹은 1이 빈 칸을 사이에 두고 주어진다. 0은 문제의 답이 틀린 경우이고,  1은 문제의  답이 맞는 경우이다.
### 출력설명
첫째 줄에 입력에서 주어진 채점 결과에 대하여 가산점을 고려한 총 점수를 출력한다.
### 입력예제 1
10 <br>
1 0 1 1 1 0 0 1 1 0
### 출력예제 1
10
### 작성코드 
```jsx
// 해설 코드
function solution(arr){         
    let answer=0, cnt=0;
    for(let x of arr){
        if(x===1){
            cnt++;
            answer+=cnt;
        }
        else cnt=0;
    }       
    return answer;
}
let arr=[1, 0, 1, 1, 1, 0, 0, 1, 1, 0];
console.log(solution(arr));

// 내가 작성한 코드
function solution(arr){         
    let answer=0; count=0;      
    for(let i of arr){
        if(i===1) count++;
        else count=0;
        answer += count;
    }
    return answer;
}
let arr=[1, 0, 1, 1, 1, 0, 0, 1, 1, 0];
console.log(solution(arr));
```

<br>

## 5. 등수구하기

N(1<=N<=100)명의 학생의 국어점수가 입력되면 각 학생의 등수를 입력된 순서대로 출력하는 프로그램을 작성하세요.

### 입력설명
첫 줄에 N(3<=N<=1000)이 입력되고, 두 번째 줄에 국어점수를 의미하는  N개의  정수가  입력 된다. 같은 점수가 입력될 경우 높은 등수로 동일 처리한다. 즉  가장  높은  점수가  92점인데 92점이 3명 존재하면 1등이 3명이고 그 다음 학생은 4등이 된다.

### 출력설명
입력된 순서대로 등수를 출력한다.

### 입력예제 1
5 <br>
87 89 92 100 76

### 출력예제 1
4 3 2 1 5
### 작성코드 
```jsx
// 해설 코드
function solution(arr){  
    let n=arr.length;
    // Array.from({배열 길이} (map콜백 함수) => 1) 
    let answer=Array.from({length:n}, ()=>1);
    for(let i=0; i<n; i++){
        for(let j=0; j<n; j++){
            if(arr[j]>arr[i]) answer[i]++;
        }
    }             
    return answer;
}

let arr=[87, 89, 92, 100, 76];
console.log(solution(arr));

// 내가 작성한 코드
function solution(arr){  
    let answer = '';
    for(let i=0; i<arr.length; i++){
        let lank = 1;
        for(let j=0; j<arr.length; j++){
            if (arr[i] < arr[j]) lank++; 
        }
        answer += lank + ' ';
    }
    return answer;
}
let arr=[87, 89, 92, 100, 76];
console.log(solution(arr));
```
### 부족했던 점
#### **`from()` 메소드 미사용** 

<br>

## 6. 격자판 최대합

5*5 격자판에 아래롸 같이 숫자가 적혀있습니다.

N*N의 격자판이 주어지면 각 행의 합, 각 열의 합, 두 대각선의 합 중  가장 큰 합을 출력합니다.

||||||
|:--:|:--:|:--:|:--:|:--:|
|10|13|10|12|15|
|12|39|30|23|11|
|11|25|50|53|15|
|19|27|29|37|27|
|19|13|30|13|19|

### 입력설명
첫 줄에 자연수 N이 주어진다.(1<=N<=50)
두 번째 줄부터 N줄에 걸쳐 각 줄에 N개의 자연수가 주어진다. 각 자연수는 100을 넘지 않는다.

### 출력설명 최대합을 출력합니다.

###  입력예제 1
5 <br>
10 13 10 12 15 <br>
12 39 30 23 11 <br>
11 25 50 53 15 <br>
19 27 29 37 27 <br>
19 13 30 13 19 <br>

###  출력예제 1
155
### 작성코드 
```jsx
// 해설 코드
function solution(arr){  
    let answer=Number.MIN_SAFE_INTEGER;
    let n=arr.length;
    let sum1=sum2=0;
    for(let i=0; i<n; i++){
        sum1=sum2=0;
        for(let j=0; j<n; j++){
            sum1+=arr[i][j];
            sum2+=arr[j][i];
        }
        answer=Math.max(answer, sum1, sum2);
    }
    sum1=sum2=0;
    for(let i=0; i<n; i++){
        sum1+=arr[i][i];
        sum2+=arr[i][n-i-1];
    }  
    answer=Math.max(answer, sum1, sum2); 
    return answer;
}

let arr=[[10, 13, 10, 12, 15], 
         [12, 39, 30, 23, 11],
         [11, 25, 50, 53, 15],
         [19, 27, 29, 37, 27],
         [19, 13, 30, 13, 19]];
console.log(solution(arr));

// 내가 작성한 코드
function solution(arr){  
    let answer = 0;                  

    for(let i=0; i<arr.length; i++){
        let sum = 0; 
        for(let j=0; j<arr.length; j++){
            sum += arr[i][j];
        }
        if(sum > answer) answer = sum; 
    }

    for(let i=0; i<arr.length; i++){
        let sum = 0; 
        for(let j=0; j<arr.length; j++){
            sum += arr[j][i];
        }
        if(sum > answer) answer = sum; 
    }
    let sum1 = 0, sum2 = 0; 
    for(let i=0; i<arr.length; i++){
        for(let j=0; j<arr.length; j++){
            if(i===j){
                sum1 += arr[i][j];
                sum2 += arr[i][4-j];
            }
        }
    }
    if (sum1 > answer) answer = sum1;
    if (sum2 > answer) answer = sum2;

    return answer;
}

let arr=[[10, 13, 10, 12, 15], 
         [12, 39, 30, 23, 11],
         [11, 25, 50, 53, 15],
         [19, 27, 29, 37, 27],
         [19, 13, 30, 13, 19]];
console.log(solution(arr));
```
### 부족했던 점
#### **너무 많은 중복코드** 
규칙을 이해하기 쉽게 하기 위해 단계별로(행별 합계 비교, 열별 합계 비교, 대각현 합계 비교) for문을 일부러 분리했지만 이로 인해 생각보다 많은 중복코드가 만들어졌다. 
#### **Math.max() 메소드 미사용** 
합계가 구해지는대로 최대값과 비교하려고 했다. (answer와 sum을 비교) <br>
하지만 행&열에서의 최대값(sum1, sum2) / 대각선에서의 최대값(sum1, sum2)으로 국면을 나누고 최대값을 골라내주는 Math.max() 메소드를 활용했다면 코드를 효율적으로 적었을텐데 그 점이 아쉽다.

<br>

## 7. 봉우리

지도 정보가 N*N 격자판에 주어집니다. 각 격자에는 그 지역의 높이가 쓰여있습니다.  각 격자판의 숫자 중 자신의 상하좌우 숫자보다 큰 숫자는 봉우리 지역입니다. 봉우리 지역이 몇 개있는 지 알아내는 프로그램을 작성하세요.<br>
격자의 가장자리는 0으로 초기화 되었다고 가정한다.<br>
만약 N=5 이고, 격자판의 숫자가 다음과 같다면 봉우리의 개수는 10개입니다.

||||||||
|:--:|:--:|:--:|:--:|:--:|:--:|:--:|
|0|0|0|0|0|0|0|
|0|**5**|3|**7**|2|**3**|0|
|0|3|**7**|1|**6**|1|0|
|0|**7**|2|5|3|**4**|0|
|0|4|3|**6**|4|1|0|
|0|**8**|7|3|**5**|2|0|
|0|0|0|0|0|0|0|

### 입력설명
첫 줄에 자연수 N이 주어진다.(1<=N<=50)<br>
두 번째 줄부터 N줄에 걸쳐 각 줄에 N개의 자연수가 주어진다. 각 자연수는 100을 넘지 않는다.
### 출력설명
봉우리의 개수를 출력하세요.

###  입력예제 1
5 <br>
5 3 7 2 3 <br>
3 7 1 6 1 <br>
7 2 5 3 4 <br>
4 3 6 4 1 <br>
8 7 3 5 2 <br>

###  출력예제 1
10
### 작성코드 
```jsx
// 해설 코드
function solution(arr){  
    let answer=0;
    let n=arr.length;
    let dx=[-1, 0, 1, 0];
    let dy=[0, 1, 0, -1];
    for(let i=0; i<n; i++){
        for(let j=0; j<n; j++){
            let flag=1;
            for(let k=0; k<4; k++){
                let nx=i+dx[k];
                let ny=j+dy[k];
                if(nx>=0 && nx<n && ny>=0 && ny<n && arr[nx][ny]>=arr[i][j]){
                    flag=0;
                    break;
                }
            }
            if(flag) answer++;
        }
    }  
        
    return answer;
}

let arr=[[5, 3, 7, 2, 3], 
         [3, 7, 1, 6, 1],
         [7, 2, 5, 3, 4],
         [4, 3, 6, 4, 1],
         [8, 7, 3, 5, 2]];
console.log(solution(arr));

// 내가 작성한 코드
function solution(arr){  
    let answer = 0;
    // 격자판 테두리 0 추가
    let zero = [0,0,0,0,0];
    arr.push(zero);
    arr.unshift(zero)
    for(let i of arr){
        i.push(0);
        i.unshift(0);
    }
    // 봉우리 구분
    for(let i=1; i<arr.length-1; i++){
        for(let j=1; j<arr.length-1; j++){
            // 상하좌우 봉우리 변수 생성
            let x = arr[i][j]
            let up = arr[i-1][j]
            let down = arr[i+1][j]
            let left = arr[i][j-1]
            let right = arr[i][j+1]
            // 높이 비교
            if(x > up && x > down && x > left && x > right) answer++;
            else continue;
        }
    }
    return answer;
}

let arr=[[5, 3, 7, 2, 3], 
         [3, 7, 1, 6, 1],
         [7, 2, 5, 3, 4],
         [4, 3, 6, 4, 1],
         [8, 7, 3, 5, 2]];
console.log(solution(arr));
```
### 부족했던 점
#### **인덱스가 -1 또는 배열 길이 이상으로 가는 경우**
인덱스가 -1이 되는 경우에 for문에서 오류가 발생하는 것을 제어하지 못했다. <br>
```jsx
let x = arr[i][j]
let up = arr[i-1][j] 
// uncaught TypeError: Cannot read properties of undefined(reading '0')
// i가 -1인데 j가 0인 인덱스를 읽을 수 없다는 뜻
let down = arr[i+1][j]
// 위와 반대로 i+1이 5가 될 경우도 같은 에러가 발생(배열의 최대 index==4)
let left = arr[i][j-1]
let right = arr[i][j+1]
```
봉우리 주변 4개의 배열요소를 변수에 할당하는 것이 아니라 해설코드처럼 인덱스를 통해 구분했다면 if문 조건으로 제어하여 효율적인 코드 작성이 가능했을 것이다.<br>
