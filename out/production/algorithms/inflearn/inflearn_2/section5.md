 # :pushpin: 섹션 5 정리
 > 투포인트 알고리즘, 슬라이딩윈도우, 해쉬

## 목차
[1. 두 배열 합치기](#1-두-배열-합치기) <br>
[2. 공통원소 구하기](#2-공통원소-구하기) <br>
[3. 연속 부분수열 1](#3-연속-부분수열-1) <br>
[4. 연속 부분수열 2](#4-연속-부분수열-2) <br>
[5. 최대 매출](#5-최대-매출) <br>
[6. 학급 회장(해쉬)](#6-학급-회장해쉬) <br>
[7. 아나그램(해쉬)](#7-아나그램해쉬) <br>
[8. 모든 아나그램 찾기(해쉬, 투포인터, 슬라이딩 윈도우)](#8-모든-아나그램-찾기해쉬-투포인터-슬라이딩-윈도우) <br>


 <br>

## 1. 두 배열 합치기
오름차순으로 정렬이 된 두 배열이 주어지면 두 배열을 오름차순으로 합쳐 출력하는 프로그램을 작성하세요.
### 입력설명
첫 번째 줄에 첫 번째 배열의 크기 N(1<=N<=100)이 주어집니다. <br>
두 번째 줄에 N개의 배열 원소가 오름차순으로 주어집니다. <br> 
세 번째 줄에 두 번째 배열의 크기 M(1<=M<=100)이 주어집니다. <br>
네 번째 줄에 M개의 배열 원소가 오름차순으로 주어집니다. <br> 
각 리스트의 원소는 int형 변수의 크기를 넘지 않습니다. <br>
### 출력설명
오름차순으로 정렬된 배열을 출력합니다.
### 입력예제 1 
3 <br> 
1 3 5 <br>
5 <br>
2 3 6 7 9 <br>
### 출력예제 1
1 2 3 3 5 6 7 9 
### 작성코드 
```jsx
// 해설 코드
function solution(arr1, arr2){
    let answer=[];
    let n=arr1.length;
    let m=arr2.length;
    let p1=p2=0;
    // 두 포인터 모두 끝까지 가지 않았을 경우 loop
    // 하나라도 끝까지 갔다면 loop 종료
    while(p1<n && p2<m){
        if(arr1[p1]<=arr2[p2]) answer.push(arr1[p1++]);
        else answer.push(arr2[p2++]);
    }
    // 하나라도 끝까지 간 경우, 
    // 아직 끝까지 가지 못한 배열은 남은 요소 전부 push
    while(p1<n) answer.push(arr1[p1++]);
    while(p2<m) answer.push(arr2[p2++]); 
    return answer;
}

let a=[1, 3, 5];
let b=[2, 3, 6, 7, 9];
console.log(solution(a, b));

// 내가 작성한 코드
function solution(arr1, arr2){
    let answer=[];
    let n1 = arr1.length , n2 = arr2.length;
    let cnt1 = 0;
    let cnt2 = 0;
    while(cnt1 < n1 || cnt2 < n2){
        if(arr1[cnt1] <= arr2[cnt2] || cnt2 === n2) {
            answer.push(arr1[cnt1]);
            cnt1++;
        }
        if(arr1[cnt1] >= arr2[cnt2] || cnt1 === n1) {
            answer.push(arr2[cnt2]);
            cnt2++;
        }
    }
    // 투포인터 미사용 코드
    // answer = arr1.concat(arr2);
    // answer.sort((a,b) => a-b);
    return answer;
}
let a=[1, 3, 5];
let b=[2, 3, 6, 7, 9];
console.log(solution(a, b));
```
### 부족했던 점
#### **두 배열을 다른 반복문으로 돌렸다.**
앞에 나오는 while문에서 활용되는 배열의 길이가 길면 `undefined`값이 추가되는 오류 발생 <br>
1. 하나의 while문에서 오름차순으로 `answer` 배열에 할당 
2. 두 배열 중 하나라도 끝까지 탐색을 완료한다면 그때 다른 while문을 통해 끝까지 탐색하지 못한 배열의 남은 요소를 `answer`배열에 할당한다.
#### **answer.push(arr[`value++`]) 코드**
`value++` 은 value값이 사용된 이후 +1이 된다는 점을 활용하지 못했다.

<br>

## 2. 공통원소 구하기
A, B 두 개의 집합이 주어지면 두 집합의 공통 원소를 추출하여 오름차순으로 출력하는 프로그램을 작성하세요.
### 입력설명
첫 번째 줄에 집합 A의 크기 N(1<=N<=30,000)이 주어집니다. <br>
두 번째 줄에 N개의 원소가 주어집니다. 원소가 중복되어 주어지지 않습니다. <br>
세 번째 줄에 집합 B의 크기 M(1<=M<=30,000)이 주어집니다. <br>
네 번째 줄에 M개의 원소가 주어집니다. 원소가 중복되어 주어지지 않습니다. <br>
각 집합의 원소는 1,000,000,000이하의 자연수입니다. <br>
### 출력설명
두 집합의 공통원소를 오름차순 정렬하여 출력합니다.
### 입력예제 1 
5 <br>
1 3 9 5 2 <br>
5 <br>
3 2 5 7 8 <br>
### 출력예제 1
2 3 5 
### 작성코드 
```jsx
// 해설 코드
function solution(arr1, arr2){
    let answer=[];
    arr1.sort((a, b)=>a-b);
    arr2.sort((a, b)=>a-b);
    let p1=p2=0;
    while(p1<arr1.length && p2<arr2.length){
        if(arr1[p1]==arr2[p2]){
            answer.push(arr1[p1++]);
            p2++;
        }
        else if(arr1[p1]<arr2[p2]) p1++;
        else p2++;
    }              
    return answer;
}

let a=[1, 3, 9, 5, 2];
let b=[3, 2, 5, 7, 8];
console.log(solution(a, b));

// 내가 작성한 코드
function solution(arr1, arr2){
    let answer=[];
    let n=arr1.length;
    let m=arr2.length;
    arr1.sort((a,b) => a-b);
    arr2.sort((a,b) => a-b);
    let p1=p2=0;
    while(p1<n && p2<m){
        if (arr1[p1] > arr2[p2]) p2++; // 배운 점에서 추가 설명
        else if(arr1[p1] === arr2[p2]) answer.push(arr2[p2++]);
        else p1++;
    }
    return answer;
}

let a=[1, 3, 9, 5, 2];
let b=[3, 2, 5, 7, 8];
console.log(solution(a, b));
```
### 배운 점
#### **작은 값일 경우에 그 배열을 다음으로 넘긴다.**
- `arr1` : 기준이 되는 배열, 숫자가 같다면 이 배열의 요소를 push
- `arr2` : `arr1`의 비교대상이 되는 배열
- 만약 `arr1`의 요소가 `arr2`의 요소보다 값이 크면 , `arr2`에선 `arr1`과 같은 숫자가 있을 수 없다. (오름차순 정렬 때문)
- 그러므로 arr2의 요소를 다음으로 넘어가야 한다.
> 다른 말로 **작은 요소**를 가르키고 있는 배열이 다음으로 넘어가야 한다!!

#### **같은 값이 나왔을 경우 두 배열을 동시에 다음으로 넘긴다.**
- 내가 작성한 코드보다 더 논리적이고 효율적인 코드라고 생각된다.

<br>

## 3. 연속 부분수열 1
N개의 수로 이루어진 수열이 주어집니다. 이 수열에서 연속부분수열의 합이 특정숫자 M이 되는 경우가 몇 번 있는지 구하는 프로그램을 작성하세요. <br>
만약 N=8, M=6이고 수열이 다음과 같다면 <br>
1 2 1 3 1 1 1 2 <br>
합이 6이 되는 연속부분수열은 {2, 1, 3}, {1, 3, 1, 1}, {3, 1, 1, 1}로 총 3가지입니다.
### 입력설명
첫째 줄에 N(1≤N≤100,000), M(1≤M≤100,000,000)이 주어진다.  <br>
수열의 원소값은 1,000을 넘지 않는 자연수이다.
### 출력설명
첫째 줄에 경우의 수를 출력한다.
### 입력예제 1 
8 6 <br>
1 2 1 3 1 1 1 2
### 출력예제 1
3 
### 작성코드 
```jsx
// 해설 코드
function solution(m, arr){
    let answer=0, lt=0, sum=0;
    for(let rt=0; rt<arr.length; rt++){
        sum+=arr[rt];
        if(sum===m) answer++;
        while(sum>=m){
            sum-=arr[lt++];
            if(sum===m) answer++;       
        }
    }        
    return answer;
}

let a=[1, 2, 1, 3, 1, 1, 1, 2];
console.log(solution(6, a));

// 내가 작성한 코드
function solution(m, arr){
    let answer = 0; p = 0; sum = 0; n = arr.length; 
    for (let i=0;i<n;i++){
        p=i+1;
        sum = arr[i];
        while(p < n){
            // 합계가 6보다 작을 경우, 계속 ++
            if (sum < m){
                sum += arr[p]
                p++;
            }
            // 합계가 6일때 answer++
            else if (sum === m){
                answer++;
                break;
            }
            // 합계가 6보다 커지면 계산 종료
            else break;
        }
    }
    return answer;
}
let a=[1, 2, 1, 3, 1, 1, 1, 2];
console.log(solution(6, a));
```
### 부족했던 점
#### **투포인터 활용한 코드가 아니다.**
틀린 코드는 아니지만 포인터를 하나만 활용하여 for문이 한번이 아니라 n번 만큼 도는 코드다.<br>
해설코드는 
1. 합계가 6보다 작으면 `rt`가 전진하면서 `sum`를 늘인다.
2. 합계가 6을 넘으면 `lt`가 전진하면서 `sum`을 줄인다. 
3. 이 과정속에서 6이 되는 경우에 `answer++`
<br>

## 4. 연속 부분수열 2
N개의 수로 이루어진 수열이 주어집니다. 이 수열에서 연속부분수열의 합이 특정숫자 M이하가 되는 경우가 몇 번 있는지 구하는 프로그램을 작성하세요. <br>
만약 N=5, M=5이고 수열이 다음과 같다면
1 3 1 2 3 <br>
합이 5이하가 되는 연속부분수열은 {1}, {3}, {1}, {2}, {3}, {1, 3}, {3, 1}, {1, 2}, {2, 3}, {1, 3, 1}로 총 10가지입니다.
### 입력설명
첫째 줄에 N(1≤N≤100,000), M(1≤M≤100,000,000)이 주어진다. <br>
수열의 원소값은 1,000을 넘지 않는 자연수이다.
### 출력설명
첫째 줄에 경우의 수를 출력한다.
### 입력예제 1 
5 5 <br>
1 3 1 2 3
### 출력예제 1
10 
### 작성코드 
```jsx
// 해설 코드
function solution(m, arr){
    let answer=0, sum=0, lt=0;
    for(let rt=0; rt<arr.length; rt++){
        sum+=arr[rt];
        while(sum>m){
            sum-=arr[lt++];
        }
        answer+=(rt-lt+1);
    }               
    return answer;
}

let a=[1, 3, 1, 2, 3];
console.log(solution(5, a));

// 내가 작성한 코드
function solution(m, arr){
    let answer=0 , lt=0, sum=0;
    for (let rt=0; rt<arr.length; rt++){
        if (arr[rt] < m) answer++;
        if (sum <= m) {
            sum += arr[rt];
            answer++;
        }
        while(sum > m){
            sum -= arr[lt++];
        }
    }
    return answer;
}

let a=[1, 3, 1, 2, 3];
console.log(solution(5, a));
```
### 부족했던 점
#### **해설 코드와 다른 방식의 조건문**
해설코드 설명
1. `rt`와 `lt`의 위치가 같다면 나올 수 있는 경우의 수 1개
2. `rt`와 `lt`의 위치가 1만큼 차이 난다면, `rt`를 포함한 경우의 수 2개
3. `rt`와 `lt`의 위치가 2만큼 차이 난다면, `rt`를 포함한 경우의 수 3개
4. sum이 5이상 나오면 `lt`가 `rt`와 가까워 지면서 5 이하로 내려간다.

    |lt|rt|sum|경우의 수|
    |--|--|--|--|
    |0|0|1|[1]|
    |0|1|1+3|[3], [1,3]|
    |0|2|1+3+1|[1], [3,1], [1,3,1]|
    |0|3|1+3+1+2||
    |1|3|3+1+2||
    |2|3|1+2|[2], [1,2]|
    |2|4|1+2+3||
    |3|4|2+3|[3], [2,3]|

- 즉 , `sum`이 5 이하일 때, `rt-lt+1`개씩 `answer++`
- 이와 다르게 나는 `arr[rt]`가 5보다 작으면 `answer++`를 했지만, `rt`가 다음으로 넘어갔을 때 `lt`가 안와도 된다면 당연히 5보다 작은 수인 점을 생각하지 못했다.


<br>

## 5. 최대 매출
현수의 아빠는 제과점을 운영합니다. 현수 아빠는 현수에게 N일 동안의 매출기록을 주고 연속된 K일 동안의 최대 매출액이 얼마인지 구하라고 했습니다. <br>
만약 N=10이고 10일 간의 매출기록이 아래와 같습니다. 이때 K=3이면 <br> 
12 15 11 20 25 10 20 19 13 15 <br>
연속된 3일간의 최대 매출액은 11+20+25=56만원입니다. <br>
여러분이 현수를 도와주세요.
### 입력설명
첫 줄에 N(5<=N<=100,000)과 K(2<=K<=N)가 주어집니다. <br>
두 번째 줄에 N개의 숫자열이 주어집니다. 각 숫자는 500이하의 음이 아닌 정수입니다.
### 출력설명
첫 줄에 최대 매출액을 출력합니다.
### 입력예제 1 
10 3 <br>
12 15 11 20 25 10 20 19 13 15
### 출력예제 1
56 
### 작성코드 
```jsx
// 해설 코드
function solution(k, arr){
    let answer, sum=0;
    for(let i=0; i<k; i++) sum+=arr[i];
    answer=sum;
    for(let i=k; i<arr.length; i++){
        sum+=(arr[i]-arr[i-k]);
        answer=Math.max(answer, sum);
    }                    
    return answer;
}

let a=[12, 15, 11, 20, 25, 10, 20, 19, 13, 15];
console.log(solution(3, a));

// 내가 작성한 코드
function solution(k, arr){
    let answer = sum = lt = 0;
    for (let rt=0; rt<arr.length; rt++){
        sum += arr[rt];
        while(rt-lt === k){
            sum -= arr[lt++];
        }
        if (rt >= 2) answer = Math.max(answer, sum);
    }
    return answer;
}

let a=[12, 15, 11, 20, 25, 10, 20, 19, 13, 15];
console.log(solution(3, a));
```
### 부족했던 점
#### **투포인터와 슬라이딩 윈도우의 차이**
- 슬라이딩 윈도우 : 창문을 밀고 나가는 것처럼 한번의 loop로 원하는 값을 찾아내는 기법
- `k`가 창문의 크기같은 존재

#### 슬라이딩 윈도우 진행 과정
|arr|sum|
|--|--|
|[**12, 15, 11**, 20, 25, 10, 20, 19, 13, 15]|12+15+11|
|[12, **15, 11, 20**, 25, 10, 20, 19, 13, 15]|(12+15+11) + (20-12)|
|[12, 15, **11, 20, 25**, 10, 20, 19, 13, 15]|(15+11+20) + (25-15)|
|[12, 15, 11, **20, 25, 10**, 20, 19, 13, 15]|(11+20+25) + (10-11)|
|[12, 15, 11, 20, **25, 10, 20**, 19, 13, 15]|...|
|[12, 15, 11, 20, 25, **10, 20, 19**, 13, 15]|...|
|[12, 15, 11, 20, 25, 10, **20, 19, 13**, 15]|...|
|[12, 15, 11, 20, 25, 10, 20, **19, 13, 15**]|...|

- 이번 예제의 경우, 투포인터를 활용하는 것보다 더 빠른 계산이 가능하다.

<br>

## 6. 학급 회장(해쉬)
학급 회장을 뽑는데 후보로 기호 A, B, C, D, E 후보가 등록을 했습니다. 투표용지에는 반 학생들이 자기가 선택한 후보의 기호(알파벳)가 쓰여져 있으며 선생님은 그 기호를 발표하고 있습니다. 선생님의 발표가 끝난 후 어떤 기호의 후보가 학급 회장이 되었는지 출력하는 프로그램을 작성하세요. 반드시 한 명의 학급회장이 선출되도록 투표결과가 나왔다고 가정합니다.
### 입력설명
첫 줄에는 반 학생수 N(5<=N<=50)이 주어집니다. <br>
두 번째 줄에 N개의 투표용지에 쓰여져 있던 각 후보의 기호가 선생님이 발표한 순서대로 
문자열로 입력됩니다.
### 출력설명
학급 회장으로 선택된 기호를 출력합니다. 
### 입력예제 1 
15 <br>
BACBACCACCBDEDE
### 출력예제 1
C 
### 작성코드 
```jsx
// 해설 코드
function solution(s){  
    let answer;
    let sH = new Map();
    for(let x of s){
        if(sH.has(x)) sH.set(x, sH.get(x)+1);
        else sH.set(x, 1);
    }
    let max=Number.MIN_SAFE_INTEGER;
    for(let [key, val] of sH){
        if(val>max){
            max=val;
            answer=key;
        }
    }
    return answer;
}

let str="BACBACCACCBDEDE";
console.log(solution(str));

// 내가 작성한 코드
function solution(s){  
    let answer;
    let st = new Map();
    st.set('A',0);
    st.set('B',0);
    st.set('C',0);
    st.set('D',0);
    st.set('E',0);
    for (let i of s){
        if (i==='A') st.set('A', st.get('A')+1);
        if (i==='B') st.set('B', st.get('B')+1);
        if (i==='C') st.set('C', st.get('C')+1);
        if (i==='D') st.set('D', st.get('D')+1);
        if (i==='E') st.set('E', st.get('E')+1);
    }
    let max = Math.max(...Array.from(st.values()));
    if (max === st.get('A')) answer = 'A'; 
    if (max === st.get('B')) answer = 'B'; 
    if (max === st.get('C')) answer = 'C'; 
    if (max === st.get('D')) answer = 'D'; 
    if (max === st.get('E')) answer = 'E'; 
    return answer;
}

let str="BACBACCACCBDEDE";
console.log(solution(str));

// 내가 작성한 코드 2(강의 수강 후)
function solution(s){  
    let answer;
    let st = new Map();
    for(let i of s){
        if (st.has(i)) st.set(i,st.get(i)+1);
        else st.set(i,1);
    }
    let max = Number.MIN_SAFE_INTEGER
    for (let [key,value] of st){
        if (value > max) {
            max = value;
            answer = key;
        } 
    }
    return answer;
}

let str="BACBACCACCBDEDE";
console.log(solution(str));
```
### 부족했던 점
#### **Map()활용법 미숙지**
[Map()객체 활용법](https://github.com/kimcno3/TIL/blob/main/programming_language/javascript.md#Map)

<br>

## 7. 아나그램(해쉬)
Anagram이란 두 문자열이 알파벳의 나열 순서를 다르지만 그 구성이 일치하면 두 단어는 아
나그램이라고 합니다. <br> 
예를 들면 AbaAeCe 와 baeeACA 는 알파벳을 나열 순서는 다르지만 그 구성을 살펴보면 
A(2), a(1), b(1), C(1), e(2)로 알파벳과 그 개수가 모두 일치합니다. 즉 어느 한 단어를 재배열하면 상대편 단어가 될 수 있는 것을 아나그램이라 합니다.
길이가 같은 두 개의 단어가 주어지면 두 단어가 아나그램인지 판별하는 프로그램을 작성하세요. 아나그램 판별시 대소문자가 구분됩니다.
### 입력설명
첫 줄에 첫 번째 단어가 입력되고, 두 번째 줄에 두 번째 단어가 입력됩니다. <br> 
단어의 길이는 100을 넘지 않습니다. 
### 출력설명
두 단어가 아나그램이면 “YES"를 출력하고, 아니면 ”NO"를 출력합니다.
### 입력예제 1 
AbaAeCe <br>
baeeACA
### 출력예제 1
YES
### 입력예제 2 
abaCC <br>
Caaab
### 출력예제 2
NO 
### 작성코드 
```jsx
// 해설 코드
function solution(str1, str2){
    let answer="YES"; 
    let sH = new Map();
    for(let x of str1){
        if(sH.has(x)) sH.set(x, sH.get(x)+1);
        else sH.set(x, 1);
    }
    for(let x of str2){
        if(!sH.has(x) || sH.get(x)==0) return "NO";
        sH.set(x, sH.get(x)-1);
    }
    return answer;
}

let a="AbaAeCe";
let b="baeeACA";
console.log(solution(a, b));

// 내가 작성한 코드
function solution(str1, str2){
    let answer = "YES";
    let a = new Map(), b = new Map();
    for (let i of str1){
        if (a.has(i)) a.set(i,a.get(i)+1)
        else a.set(i,0);
    }
    for (let j of str2){
        if (b.has(j)) b.set(j,b.get(j)+1)
        else b.set(j,0);
    }
    if (a != b) answer = "No"; 
    return answer;
}

let a="AbaAeCe";
let b="baeeACA";
console.log(solution(a, b));
```
### 부족했던 점
#### **같은 원리의 반복문 중복**
- `str1`만 해시테이블로 만들고 , `str2`의 문자열을 비교하면서 답을 찾을 수 있었지만, 결국 `str2`도 해시테이블로 만들어 전체비교를 했다.
- `!a.has(val) === false` 라는 점을 생각하지 못했다.

<br>

## 8. 모든 아나그램 찾기(해쉬, 투포인터, 슬라이딩 윈도우)
S문자열에서 T문자열과 아나그램이 되는 S의 부분문자열의 개수를 구하는 프로그램을 작성하
세요. 아나그램 판별시 대소문자가 구분됩니다. 부분문자열은 연속된 문자열이어야 합니다.
### 입력설명
첫 줄에 첫 번째 S문자열이 입력되고, 두 번째 줄에 T문자열이 입력됩니다.  <br>
S문자열의 길이는 10,000을 넘지 않으며, T문자열은 S문자열보다 길이가 작거나 같습니다.
### 출력설명
S단어에 T문자열과 아나그램이 되는 부분문자열의 개수를 출력합니다.
### 입력예제 1 
bacaAacba <br>
abc
### 출력예제 1
3 <br>
출력설명: {bac}, {acb}, {cba} 3개의 부분문자열이 "abc"문자열과 아나그램입니다
### 작성코드 
```jsx
// 해설 코드
function compareMaps(map1, map2){
    if(map1.size!==map2.size) return false;
    for(let [key, val] of map1){
        if(!map2.has(key) || map2.get(key)!==val) return false;
    }
    return true;
}
function solution(s, t){
    let answer=0;
    let tH = new Map();
    let sH = new Map();
    // th 객체 생성
    for(let x of t){
        if(tH.has(x)) tH.set(x, tH.get(x)+1);
        else tH.set(x, 1);
    }
    // sh 객체 2번째 문자까지만 추가
    let len=t.length-1;
    for(let i=0; i<len; i++){
        if(sH.has(s[i])) sH.set(s[i], sH.get(s[i])+1);
        else sH.set(s[i], 1);
    }
    let lt=0;
    // 3번째 문자 추가 => 비교 => 첫번째 문자 삭제 => 4번째 문자 추가 ... 반복
    for(let rt=len; rt<s.length; rt++){
        // 문자 추가
        if(sH.has(s[rt])) sH.set(s[rt], sH.get(s[rt])+1);
        else sH.set(s[rt], 1);
        // 비교
        if(compareMaps(sH, tH)) answer++;
        // 문자 삭제
        sH.set(s[lt], sH.get(s[lt])-1);
        if(sH.get(s[lt])===0) sH.delete(s[lt]);
        // 포인터 이동
        lt++;
    }
    return answer;
}

let a="bacaAacba";
let b="abc";
console.log(solution(a, b));

// 내가 작성한 코드
function compareMaps(map1, map2){
    let m = new Map() , same = true;
    for (let i of map1){
        if (m.has(i)) m.set(i , m.get(i)+1);
        else m.set(i,1);
    }
    for (let j of map2){
        if (!m.has(j) || m.get(j) === 0) same = false;
        else m.set(j, m.get(j)-1);
    }
        return same;
}
function solution(s,t){
    let answer=0, temp = '', n = t.length;
    for (let j=0; j<s.length-n+1; j++){
        temp = s.substr(j,n);
        if (compareMaps(t,temp)) answer++;
    }
    return answer;
}
let a="bacaAacba";
let b="abc";
console.log(solution(a, b));
```
### 부족했던 점
#### **map객체를 계속 선언하는 코드**
`m`객체를 생성하는 코드를 `solution()` 함수에 내리는 것이 더 좋을 듯 하다.
#### **`map2` 는 map객체로 만들지 않았다.**
문제의 의도와는 다르게 map2는 문자열로 활용한 것이 아쉽다.
#### **map.size 활용하지 않았다.**
map객체 와 map객체로 비교했다면 충분히 활용할 수 있는 조건이다. (map 객체의 장점)
<br>
