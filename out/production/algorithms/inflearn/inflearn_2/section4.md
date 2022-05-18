 # :pushpin: 섹션 4 정리
 > **완전탐색(블루투포스)**

## 목차
[1. 자릿수의 합](#1-자릿수의-합) <br>
[2. 뒤집은 소수](#2-뒤집은-소수) <br>
[3. 멘토링](#3-멘토링) <br>
[4. 졸업 선물](#4-졸업-선물) <br>
[5. K번째 큰 수](#5-K번째-큰-수) <br>

 <br>

## 1. 자릿수의 합
N개의 자연수가 입력되면 각 자연수의 자릿수의 합을 구하고, 그 합이 최대인 자연수를 출력하는 프로그램을 작성하세요. 자릿수의 합이 같은 경우 원래 숫자가 큰 숫자를 답으로 합니다. 
만약 235 와 1234가 동시에 답이 될 수 있다면 1234를 답으로 출력해야 합니다.
### 입력설명
첫 줄에 자연수의 개수 N(3<=N<=100)이 주어지고, 그 다음 줄에 N개의 자연수가 주어진다.
각 자연수의 크기는 10,000,000를 넘지 않는다.
### 출력설명
자릿수의 합이 최대인 자연수를 출력한다.
### 입력예제 1 
7 <br>
128 460 603 40 521 137 123
### 출력예제 1
137
### 작성코드 
```jsx
// 해설 코드
function solution(n, arr){
    let answer, max=Number.MIN_SAFE_INTEGER;
    for(let x of arr){
        let sum=0, tmp=x;
        while(tmp){
            sum+=(tmp%10);
            tmp=Math.floor(tmp/10);
        }
        if(sum>max){
            max=sum;
            answer=x;
        }
        else if(sum===max){
            if(x>answer) answer=x;
        }
    }
    return answer;
}

let arr=[128, 460, 603, 40, 521, 137, 123];
console.log(solution(7, arr));

// 해설 코드2
function solution(n, arr){
    let answer, max=Number.MIN_SAFE_INTEGER;
    for(let x of arr){
        let sum=x.toString().split('').reduce((a, b)=>a+Number(b), 0);
        if(sum>max){
            max=sum;
            answer=x;
        }
        else if(sum===max){
            if(x>answer) answer=x;
        }
    }
    return answer;
}

let arr=[128, 460, 603, 40, 521, 137, 123];
console.log(solution(7, arr));

// 내가 작성한 코드
function solution(n, arr){
    let answer = 0; max = 0;
    for(let i=0; i< 7; i++){
        let current = arr[i];
        let sum = 0;
        let len = String(arr[i]).length;
        for (let j=len-1; j>=0; j--){
            let number = Math.floor(current/(10**j));
            sum += number;
            current -= number * (10**j);
        }
        if (sum >= max) {
            max = sum;
            answer = Math.max(answer, arr[i]);
        }
    }
    return answer;
}

let arr=[128, 460, 603, 40, 521, 137, 123];
console.log(solution(7, arr));
```
### 부족했던 점
#### **나머지값이 아닌 몫을 활용한 코드 작성**
각각의 숫자에 10을 나누고 나머지값은 합계에 더하고, 몫은 다시 10으로 나누는 작업을 반복하면 최종 합계를 구할 수 있다.

|current|몫|나머지|sum|
|:--:|:--:|:--:|:--:|
|128|12|8|8|
|12|1|2|8+2|
|1|0|1|8+2+1|

#### `reduce()` 미활용
`reduce()`는 보통 합계를 구하는데 활용하게 때문에 더 간단하게 합계를 계산할 수 있다.

<br>


## 2. 뒤집은 소수
N개의 자연수가 입력되면 각 자연수를 뒤집은 후 그 뒤집은 수가 소수이면 그 소수를 출력하는 프로그램을 작성하세요. 예를 들어 32를 뒤집으면 23이고, 23은 소수이다. 그러면 23을 출력한다. 단 910를 뒤집으면 19로 숫자화 해야한다. 첫 자리부터의 연속된 0은 무시한다.
### 입력설명
첫 줄에 자연수의 개수 N(3<=N<=100)이 주어지고, 그 다음 줄에 N개의 자연수가 주어진다. <br>
각 자연수의 크기는 100,000를 넘지 않는다.
### 출력설명
첫 줄에 뒤집은 소수를 출력합니다. 출력순서는 입력된 순서대로 출력합니다.
### 입력예제 1 
9 <br>
32 55 62 20 250 370 200 30 100
### 출력예제 1
23 2 73 2 3
### 작성코드 
```jsx
// 해설 코드
function isPrime(num){
    if(num===1) return false;
    for(let i=2; i<=parseInt(Math.sqrt(num)); i++){
        if(num%i===0) return false;
    }
    return true;
}
function solution(arr){
    let answer=[];
    for(let x of arr){
        let res=0;
        while(x){
            let t=x%10;
            res=res*10+t;
            x=parseInt(x/10);
        }
        if(isPrime(res)) answer.push(res);
    }
    return answer;
}

let arr=[32, 55, 62, 20, 250, 370, 200, 30, 100];
console.log(solution(arr));

// 해설 코드 2
function isPrime(num){
    if(num===1) return false;
    for(let i=2; i<=parseInt(Math.sqrt(num)); i++){
        if(num%i===0) return false;
    }
    return true;
}
function solution(arr){
    let answer=[];
    for(let x of arr){
        let res=Number(x.toString().split('').reverse().join(''));
        if(isPrime(res)) answer.push(res);
    }
    return answer;
}

let arr=[32, 55, 62, 20, 250, 370, 200, 30, 100];
console.log(solution(arr));

// 내가 작성한 코드
function solution(arr){
    let answer=[]; tmp = [];
    let isPrime = true;
    for(let i of arr){
        tmp.push(Number(String(i).split('').reverse().join('')))
    }

    for(let i of tmp){
        // let isPrime = true; => 정상적으로 소수 구별
        if (i===1) isPrime = false;
        else if (i===2) isPrime = true;
        for (let j=2; j<i; j++){
            if (i%j === 0) {
                isPrime = false;
                break;
            }
        }
        if (isPrime) answer.push(i);
    }
    return answer;
}
let arr=[32, 55, 62, 20, 250, 370, 200, 30, 100];
console.log(solution(arr));
```
### 부족했던 점
#### **소수찾기 문제는 boolean값을 활용하자**
`isPrime` 변수가 for문 밖에서 선언되니 오류가 발생(73만 소수가 아닌 것으로 구별) <br>
오류 발생 원인
1. 73 전에 52가 소수가 아니여서 `false`값으로 재할당
2. 그 다음 73의 소수여부 판별할 때, `true`값으로 초기화하지 않고 소수가 맞다면 `true`로 재할당하는 조건문이 없어 그대로 `false`가 유지된 것이다.

해결 방법 
1. 조건문 안에 `isPrime`이 `true`로 초기화 되도록 수정
2. 소수가 맞을 경우 `true`값을 재할당하는 조건문 추가




<br>

## 3. 멘토링
현수네 반 선생님은 반 학생들의 수학점수를 향상시키기 위해 멘토링 시스템을 만들려고 합니다. 멘토링은 멘토(도와주는 학생)와 멘티(도움을 받는 학생)가 한 짝이 되어 멘토가 멘티의 수학공부를 도와주는 것입니다. 
선생님은 M번의 수학테스트 등수를 가지고 멘토와 멘티를 정합니다. 
만약 A학생이 멘토이고, B학생이 멘티가 되는 짝이 되었다면, A학생은 M번의 수학테스트에서 모두 B학생보다 등수가 앞서야 합니다. 
M번의 수학성적이 주어지면 멘토와 멘티가 되는 짝을 만들 수 있는 경우가 총 몇 가지 인지 출력하는 프로그램을 작성하세요.
### 입력설명
첫 번째 줄에 반 학생 수 N(1<=N<=20)과 M(1<=M<=10)이 주어진다.
두 번째 줄부터 M개의 줄에 걸쳐 수학테스트 결과가 학생번호로 주어진다. 학생번호가 제일 앞에서부터 1등, 2등, ...N등 순으로 표현된다. 
만약 한 줄에 N=4이고, 테스트 결과가 3 4 1 2로 입력되었다면 3번 학생이 1등, 4번 학생이 2등, 1번 학생이 3등, 2번 학생이 4등을 의미합니다.
### 출력설명
첫 번째 줄에 짝을 만들 수 있는 총 경우를 출력합니다.
### 입력예제 1 
4 3 <br>
3 4 1 2 <br>
4 3 2 1 <br>
3 1 4 2 <br>
### 출력예제 1
3 <br>
(3, 1), (3, 2), (4, 2)와 같이 3가지 경우의 (멘토, 멘티) 짝을 만들 수 있다.
### 작성코드 
```jsx
// 해설 코드
function solution(test){
    let answer=0;
    m=test.length;
    n=test[0].length;
    for(let i=1; i<=n; i++){
        for(let j=1; j<=n; j++){
            let cnt=0;
            for(let k=0; k<m; k++){
                let pi=pj=0;
                for(let s=0; s<n; s++){
                    if(test[k][s]===i) pi=s;
                    if(test[k][s]===j) pj=s;
                }
                if(pi<pj) cnt++;
            }
            if(cnt===m) answer++;
        }
    }
    return answer;
}

let arr=[[3, 4, 1, 2], [4, 3, 2, 1], [3, 1, 4, 2]];
console.log(solution(arr));

// 내가 작성한 코드
function solution(test){
    let answer=0; m = test.length; n = test[0].length;
    // 학생별 등수를 정리하기 위해 새로운 배열 생성
    let s = [[],[],[],[]];
    // 학생별 등수로 배열 재할당 반복문
    for (let i of test){
        for (let j of i){
            if (j===1) s[0].push(i.indexOf(j));
            else if (j===2) s[1].push(i.indexOf(j));
            else if (j===3) s[2].push(i.indexOf(j));
            else s[3].push(i.indexOf(j));
        }
    }
    // 멘토, 멘티 지정 반복문
    // i=멘토후보 학생, j=멘티후보 학생, k=학생들의 시험별 점수
    for (let i=0; i<n; i++){
        for (let j=0; j<n; j++){
            let mento = true; // 비교 전 boolean 함수 초기화
            if (i===j) continue; // 같은 학생끼리의 비교는 제외
            for (let k=0; k<m; k++){
                // 멘토후보 학생의 등수가 멘티후보 학생의 등수보다 높다면 제외
                if (s[i][k] > s[j][k]) { 
                    mento = false;
                    break;
                }
            }
            if (mento) answer++; // 제외되지 않은 경우 answer++; 
        }
    }
    return answer;
}
let arr=[[3, 4, 1, 2], [4, 3, 2, 1], [3, 1, 4, 2]];
console.log(solution(arr));
```
### 부족했던 점
#### **배열을 재선언**
기존 `test` 배열로는 규칙을 찾고 반복문을 짜기 힘들어서 개인적으로 이해하기 쉽게 학생별 등수로 정리하여 비교를 하면서 코드수가 늘어났다.

<br>

## 4. 졸업 선물
선생님은 올해 졸업하는 반 학생들에게 졸업선물을 주려고 합니다. 
학생들에게 인터넷 쇼핑몰에서 각자 원하는 상품을 골라 그 상품의 가격과 배송비를 제출하라고 했습니다. 선생님이 가지고 있는 예산은 한정되어 있습니다. 
현재 예산으로 최대 몇 명의 학생에게 선물을 사줄 수 있는지 구하는 프로그램을 작성하세요.
선생님은 상품 하나를 50% 할인해서(반 가격) 살 수 있는 쿠폰을 가지고 있습니다. 배송비는 할인에 포함되지 않습니다.
### 입력설명
첫 번째 줄에 반 학생수 N(1<=N<=1000)과 예산 M(1<=M<=100,000,000)이 주어진다.
두 번째 줄부터 N줄에 걸쳐 각 학생들이 받고 싶은 상품의 가격과 배송비가 입력됩니다.
상품가격과 배송비는 각각 100,000을 넘지 않습니다. 상품가격은 짝수로만 입력됩니다.
### 출력설명
첫 번째 줄에 선생님이 현재 예산으로 선물할 수 있는 최대 학생수를 출력합니다.
선생님 최소한 1개 이상의 상품을 살 수 있는 예산을 가지고 있습니다.
### 입력예제 1 
5 28 <br>
6 6 <br>
2 2 <br>
4 3 <br>
4 5 <br>
10 3 <br>
### 출력예제 1
4 <br>
**출력설명** <br>
(2, 2), (4, 3), (4, 5)와 (10, 3)를 할인받아 (5, 3)에 사면 비용이 4+7+9+8=28입니다.
### 작성코드 
```jsx
// 해설 코드
function solution(m, product){
    let answer=0;
    let n=product.length;
    product.sort((a, b)=>(a[0]+a[1])-(b[0]+b[1]));
    for(let i=0; i<n; i++){
        let money=m-(product[i][0]/2+product[i][1]);
        let cnt=1;
        for(let j=0; j<n; j++){
            // 남은 돈이 부족할 경우 break
            if(j!==i && (product[j][0]+product[j][1])>money) break;
            // 할인하지 않는 물건 중 남은돈으로 구매가능할 경우
            if(j!==i && (product[j][0]+product[j][1])<=money){
                money-=(product[j][0]+product[j][1]);
                cnt++;
            }
        }
        // 가능한 경우의 수가 여러가지일 수 있으니 가장 많은 개수 선택
        answer=Math.max(answer, cnt);
    }  
    return answer;
}
let arr=[[6, 6], [2, 2], [4, 3], [4, 5], [10, 3]];
console.log(solution(28, arr));

// 내가 작성한 코드
function solution(m, product){
    let answer; let totalPrice; n = product.length;
    product = product.sort((a,b) => (a[0]+a[1]) - (b[0]+b[1]));
    for (let i=0; i<n; i++){
        answer = 0; totalPrice = 28;
        let salePrice = product[i][0]/2 + product[i][1];
        totalPrice -= salePrice;
        answer++;
        for (let j=0; j<n; j++){
            if (i===j) continue;
            let price = product[j][0] + product[j][1];
            totalPrice -= price;
            answer++;
            if (totalPrice ===0) break;
        }
    }
    return answer;
}
let arr=[[6, 6], [2, 2], [4, 3], [4, 5], [10, 3]];
console.log(solution(28, arr));
```
### 부족했던 점
#### **오름차순 정렬할 생각 전혀하지 못했다**
1. 전체 비용 기준으로 배열을 오름차순으로 정렬([`sort()` 함수 추가 설명](https://github.com/kimcno3/TIL/blob/main/programming_language/javascript.md#sort))
2. 값이 작은 순서대로 전체비용에서 차감한다면, 값이 딱 맞아떨어지지 않고서는 그 경우의 수는 답이 될 수 없다. 
#### **전체 비용이 매개변수로 주워졌지만 변수로 또 선언했다.**
1. 출제설명을 제대로 보지 않았다.
#### **`answer`를 초기화하면서 활용**
1. 구매 가능한 경우의 수가 여러개일 경우, 더 많은 수의 선물을 구매할 수 있음에도 그 전에 반복문이 끝나 오류가 발생할 수 있다.
2. 그러므로 각 경우의 수 마다 `count` 값을 받아 계산하고 마지막에 `answer`와 `count`값 중 더 큰 값으로 `answer`를 재할당하는 것이 맞다.

```jsx
// 아쉬움이 많아 강의본 후 다시 만들어 본 코드.....ㅠㅠ
function solution(m, product){
    let answer=0 , n = product.length;
    product.sort((a,b) => (a[0]+a[1]) - (b[0]+b[1]));
    for(let i=0; i<n; i++){
        let count = 0;
        let salePrice = product[i][0]/2 + product[i][1];
        let totalmoney = m-salePrice; 
        count++; 
        for(let j=0; j<n; j++){
            let price = product[j][0] + product[j][1];
            if (i != j && price > totalmoney) break;
            if (i != j && price <= totalmoney){
                totalmoney -= price;
                count++;
            }
        }
        answer = Math.max(answer, count);
    }
    return answer;
}
let arr=[[6, 6], [2, 2], [4, 3], [4, 5], [10, 3]];
console.log(solution(28, arr));
```

<br>

## 5. K번째 큰 수
현수는 1부터 100사이의 자연수가 적힌 N장의 카드를 가지고 있습니다. 같은 숫자의 카드가 여러장 있을 수 있습니다. 현수는 이 중 3장을 뽑아 각 카드에 적힌 수를 합한 값을 기록하려고 합니다. 3장을 뽑을 수 있는 모든 경우를 기록합니다. 기록한 값 중 K번째로 큰 수를 출력하는 프로그램을 작성하세요.
만약 큰 수부터 만들어진 수가 25 25 23 23 22 20 19......이고 K값이 3이라면 K번째 큰 값은 22입니다.
### 입력설명
첫 줄에 자연수 N(3<=N<=100)과 K(1<=K<=50) 입력되고, 그 다음 줄에 N개의 카드값이 입력된다.
### 출력설명
첫 줄에 K번째 수를 출력합니다. K번째 수는 반드시 존재합니다.
### 입력예제 1 
10 3 <br>
13 15 34 23 45 65 33 11 26 42
### 출력예제 1
143
### 작성코드 
```jsx
// 해설 코드
function solution(n, k, card){
    let answer;
    let tmp = new Set();
    for(let i=0; i<n; i++){
        for(let j=i+1; j<n; j++){
            for(let k=j+1; k<n; k++){
                tmp.add(card[i]+card[j]+card[k]);
            }
        }
    }
    let a=Array.from(tmp).sort((a, b)=>b-a);
    answer=a[k-1];
    return answer;
}

let arr=[13, 15, 34, 23, 45, 65, 33, 11, 26, 42];
console.log(solution(10, 3, arr));

// 내가 작성한 코드
function solution(n, k, card){
    let answer;
    let sum =[];
    let cnt =1;
    // 모든 경우의 수 계산
    for (let x=0; x<n-2; x++){
        for (let y=x+1; y<n-1; y++){
            for (let z=y+1; z<n; z++){
                sum.push(card[x]+card[y]+card[z]);
            }
        }
    }
    // 합계값 내림차순 정렬
    sum.sort((a,b) => b-a);
    // K번째 큰 수 계산
    for (let i=0; i<sum.length; i++){
        if (sum[i] > sum[i+1]) cnt++;
        if (cnt === 3) {
            answer = sum[i+1];
            break;
        }
    }
    return sum;
}
let arr=[13, 15, 34, 23, 45, 65, 33, 11, 26, 42];
console.log(solution(10, 3, arr));
```
### 부족했던 점
#### **Set , Array 객체 미활용**
> **Set객체** : 자료형의 관계없이 원시 값과 객체 참조 모두 유일한 값을 가지는 객체 <br>
> **add()** : Set객체 맨 뒤에 새로운 요소를 추가하는 함수 <br>
> **Array.from()** : 유사배열 객체를 새로운 배열로 바꿔주는 함수 <br>

1. Set객체로 중복없이 합계를 모두 받고, Array.from() 함수로 배열화 시킨다.
2. sort()함수 활용 내림차순 정렬
3. K번째 수는 인덱스가 k-1인 수

