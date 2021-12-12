 # :pushpin: 섹션 6 정리
 > 스택, 큐

## 목차
[1. 올바른 괄호](#1-올바른-괄호) <br>
[2. 괄호문자제거](#2-괄호문자제거) <br>
[3. 크레인 인형뽑기(카카오 기출)](#3-크레인-인형뽑기카카오-기출) <br>
[4. 후위식 연산(postfix)](#4-후위식-연산postfix) <br>
[5. 쇠막대기](#5-쇠막대기) <br>
[6. 공주 구하기](#6-공주-구하기) <br>
[7. 교육과정 설계](#7-교육과정-설계) <br>

 <br>

## 1. 올바른 괄호
괄호가 입력되면 올바른 괄호이면 “YES", 올바르지 않으면 ”NO"를 출력합니다. 

`(())()` 이것은 괄호의 쌍이 올바르게 위치하는 거지만, 

`(()()))` 은 올바른 괄호가 아니다.

### 입력설명
첫 번째 줄에 괄호 문자열이 입력됩니다. 문자열의 최대 길이는 30이다. 
### 출력설명
첫 번째 줄에 YES, NO를 출력한다.
### 입력예제 1 
(()(()))(()
### 출력예제 1
NO
### 작성코드 
```jsx
// 해설 코드
function solution(s){
    let answer="YES";
    stack=[];
    for(let x of s){
        if(x==='(') stack.push(x);
        else{
            if(stack.length===0) return "NO";
            stack.pop();
        }
    }
    if(stack.length>0) return "NO";  
    return answer;
}

let a="(()(()))(()";
console.log(solution(a));

// 내가 작성한 코드
function solution(s){
    let answer="YES";
    let stack = [];

    if (s[0] === '(') stack.push(s[0]);
    else answer = 'No';

    for (let i=1; i<s.length;i++){
        if (stack[stack.length-1] === '(' && s[i] === ')') stack.pop();
        else stack.push(s[i]);
    }

    if (stack.length !== 0) answer = 'No';
    return answer;
}

let a="((()))(()";
console.log(solution(a));
```
### 부족했던 점
#### **일부 오류 통제 못하는 코드 작성**
비어있는 스택에 `)`가 들어갈 차례인 경우, 오류 제어하지 못한다.(첫 문자열 제외)
#### **불필요하게 많고 복잡한 조건문**
조금 더 단순하게 작성할 수 있었다.


<br>

## 2. 괄호문자제거
입력된 문자열에서 소괄호 ( ) 사이에 존재하는 모든 문자를 제거하고 남은 문자만 출력하는 
프로그램을 작성하세요.
### 입력설명
첫 줄에 문자열이 주어진다. 문자열의 길이는 100을 넘지 않는다.
### 출력설명
남은 문자만 출력한다.
### 입력예제 1 
(A(BC)D)EF(G(H)(IJ)K)LM(N)
### 출력예제 1
EFLM
### 작성코드 
```jsx
// 해설 코드
function solution(s){  
    let answer;
    let stack=[];
    for(let x of s){
        if(x===')'){
            while(stack.pop()!=='(');
        }
        else stack.push(x);
    }
    answer=stack.join('');
    return answer;
}

let str="(A(BC)D)EF(G(H)(IJ)K)LM(N)";
console.log(solution(str));

// 내가 작성한 코드
function solution(s){  
    let answer;
    let stack=[] , cnt = 0;
    for (let i of s){
        if (i !== ')') stack.push(i);
        else {
            cnt = stack.length - stack.lastIndexOf('(');
            while(cnt > 0) {
                stack.pop();
                cnt--;
            }
        }
    }
    answer = stack.join('');
    return answer;
}
let str="(A(BC)D)EF(G(H)(IJ)K)LM(N)";
console.log(solution(str));
```
### 부족했던 점
#### **while문 조건식이 복잡하다.**
스택 안에 '('가 나올 때 까지 pop해야 하는 건 생각했지만 조건문이 작동하지 않아 결국 cnt값을 따로 만들었는데
**`stack.pop()`이 마지막 인덱스의 요소와 같은 값을 가진다**는 점을 활용했다면 더 간단한 코드 작성이 가능했을 것이다.(+ 조건식에서 pop()메소드가 작동한다.) 

**<실패했던 조건문>**
``` 
while(stack.length > stack.lastIndexOf('(')) stack.pop();
```
스택을 pop 하면 배열 길이라 줄어드니 그 점을 이용하려 했지만 무한루프가 발생하는 문제가 있었다.

조건문이 false가 되기 전에 마지막 '(' 도 pop 되면서 `stack.lastIndexOf('(')` 가 `3 => 0 => -1`의 순서로 같이 줄어들고, <br>
결국 조건문이 계속 true로 유지되어 무한loop가 생성된다.

<br>

## 3. 크레인 인형뽑기(카카오 기출)
게임개발자인 죠르디는 크레인 인형뽑기 기계를 모바일 게임으로 만들려고 합니다.
죠르디는 게임의 재미를 높이기 위해 화면 구성과 규칙을 다음과 같이 게임 로직에 반영하려고 합니다.

![](https://grepp-programmers.s3.ap-northeast-2.amazonaws.com/files/production/69f1cd36-09f4-4435-8363-b71a650f7448/crane_game_101.png)

게임 화면은 1 x 1 크기의 칸들로 이루어진 N x N 크기의 정사각 격자이며 위쪽에는 크레인이 있고 오른쪽에는 바구니가 있습니다. (위 그림은 5 x 5 크기의 예시입니다). 각 격자 칸에는 다양한 인형이 들어 있으며 인형이 없는 칸은 빈칸입니다. 모든 인형은 1 x 1 크기의 격자 한 칸을 차지하며 격자의 가장 아래 칸부터 차곡차곡 쌓여 있습니다. 게임 사용자는 크레인을 좌우로 움직여서 멈춘 위치에서 가장 위에 있는 인형을 집어 올릴 수 있습니다. 집어 올린 인형은 바구니에 쌓이게 되는 데, 이때 바구니의 가장 아래 칸부터 인형이 순서대로 쌓이게 됩니다. 다음 그림은 [1번, 5번, 3번] 위치에서 순서대로 인형을 집어 올려 바구니에 담은 모습입니다.

![](https://grepp-programmers.s3.ap-northeast-2.amazonaws.com/files/production/638e2162-b1e4-4bbb-b0d7-62d31e97d75c/crane_game_102.png)

만약 같은 모양의 인형 두 개가 바구니에 연속해서 쌓이게 되면 두 인형은 터뜨려지면서 바구니에서 사라지게 됩니다. 위 상태에서 이어서 [5번] 위치에서 인형을 집어 바구니에 쌓으면 같은 모양 인형 두 개가 없어집니다.

![](https://grepp-programmers.s3.ap-northeast-2.amazonaws.com/files/production/8569d736-091e-4771-b2d3-7a6e95a20c22/crane_game_103.gif)

크레인 작동 시 인형이 집어지지 않는 경우는 없으나 만약 인형이 없는 곳에서 크레인을 작동시키는 경우에는 아무런 일도 일어나지 않습니다. 또한 바구니는 모든 인형이 들어갈 수 있을 만큼 충분히 크다고 가정합니다. (그림에서는 화면표시 제약으로 5칸만으로 표현하였음)

게임 화면의 격자의 상태가 담긴 2차원 배열 board와 인형을 집기 위해 크레인을 작동시킨 위치가 담긴 배열 moves가 매개변수로 주어질 때, 크레인을 모두 작동시킨 후 터트려져 사라진 인형의 개수를 return 하도록 solution 함수를 완성해주세요.

### 제한사항
- board 배열은 2차원 배열로 크기는 5 x 5 이상 30 x 30 이하입니다.
- board의 각 칸에는 0 이상 100 이하인 정수가 담겨있습니다.
- 0은 빈 칸을 나타냅니다.
- 1 ~ 100의 각 숫자는 각기 다른 인형의 모양을 의미하며 같은 숫자는 같은 모양의 - 인형을 나타냅니다.
- moves 배열의 크기는 1 이상 1,000 이하입니다.
- moves 배열 각 원소들의 값은 1 이상이며 board 배열의 가로 크기 이하인 자연수입니다.

### 입력예제 1
```jsx 
[[0,0,0,0,0],
 [0,0,1,0,3],
 [0,2,5,0,1],
 [4,2,4,4,2],
 [3,5,1,3,1]] //board 배열

[1,5,3,5,1,2,1,4] //moves 배열
```
### 출력예제 1
4
### 작성코드 
```jsx
// 해설 코드
function solution(board, moves){
    let answer=0;
    let stack=[];
    moves.forEach(pos => {
        for(let i=0; i<board.length; i++){
            if(board[i][pos-1]!==0){
                let tmp=board[i][pos-1];
                board[i][pos-1]=0;
                if(tmp===stack[stack.length-1]){
                    stack.pop();
                    answer+=2;
                }
                else stack.push(tmp);
                break;
            }
        }
    });
                    
    return answer;
}

let a=[[0,0,0,0,0],
        [0,0,1,0,3],
        [0,2,5,0,1],
        [4,2,4,4,2],
        [3,5,1,3,1]];

let b=[1, 5, 3, 5, 1, 2, 1, 4];
console.log(solution(a, b));

// 내가 작성한 코드
function solution(board, moves){
    let answer=0;
    let stack=[];
    moves.forEach(pos => {
        for (let i=0; i<board.length; i++){
            if (board[i][pos-1] !== 0) {
                if (stack.length > 0 && stack[stack.length-1] === board[i][pos-1]){
                    stack.pop();
                    answer += 2;
                }
                else {
                    stack.push(board[i][pos-1]);
                }
                board[i][pos-1] = 0;
                break;
            }
        }
    });
    return answer;
}

let a=[[0,0,0,0,0],
        [0,0,1,0,3],
        [0,2,5,0,1],
        [4,2,4,4,2],
        [3,5,1,3,1]];

let b=[1, 5, 3, 5, 1, 2, 1, 4];
console.log(solution(a, b));
```
### 부족했던 점
#### **배열 이해를 잘못했다.**
배열 구조를 잘못 이해해서 접근 자체를 다르게 해버렸고, 해설을 일부 본 다음 다시 짠 코드라 100% 스스로 짜낸 코드가 아니다.
#### **`forEach()`을 사용할 생각을 하지 못했다.**
`forEach()`를 사용할 때 가독성이 더 좋다.

<br>

## 4. 후위식 연산(postfix)
후위연산식이 주어지면 연산한 결과를 출력하는 프로그램을 작성하세요.
만약 3*(5+2)-9 을 후위연산식으로 표현하면 352+*9- 로 표현되며 그 결과는 12입니다.
### 입력설명
첫 줄에 후위연산식이 주어집니다. 연산식의 길이는 50을 넘지 않습니다.
식은 1~9의 숫자와 +, -, *, / 연산자로만 이루어진다.
### 출력설명
연산한 결과를 출력합니다.
### 입력예제 1 
352+*9-
### 출력예제 1
12
### 작성코드 
```jsx
// 해설 코드
function solution(s){  
    let answer;
    let stack=[];
    for(let x of s){
        if(!isNaN(x)) stack.push(Number(x));
        else{
            let rt=stack.pop();
            let lt=stack.pop();
            if(x==='+') stack.push(lt+rt);
            else if(x==='-') stack.push(lt-rt);
            else if(x==='*') stack.push(lt*rt);
            else if(x==='/') stack.push(lt/rt);
        }
    }
    answer=stack[0];
    return answer;
}

let str="352+*9-";
console.log(solution(str));

// 내가 작성한 코드
function solution(s){  
    let answer;
    let stack=[];
    let op = /[+-/*]/;
    let num1 = num2 = tmp = 0;
    for (let i of s){
        if (!op.test(i)) stack.push(Number(i));
        else{
            num2 = stack.pop();
            num1 = stack.pop();
            switch(i){
                case '+' : 
                tmp = num1 + num2;
                break;
                case '-' : 
                tmp = num1 - num2;
                break;
                case '/' : 
                tmp = num1 / num2;
                break;
                case '*' : 
                tmp = num1 * num2;
                break;
            }
            stack.push(tmp);
        }
        answer = stack[0];
    }
    return answer;
}

let str="352+*9-";
console.log(solution(str));
```
### 부족했던 점
#### **`isNaN` 메소드 미활용**
`op`변수에 정규표현식을 활용해서 문자열만 구분했지만 사실 더 간단하게 `isNaN` 메소드로 구분 가능했다.

#### **`switch`문을 사용하여 코드가 길어졌다.**
해설 코드와 같은 맥락으로 코드를 구성했지만 매개변수에 직접 계산을 했다면 코드 길이가 짧아졌을 것이다.

<br>

## 5. 쇠막대기
여러 개의 쇠막대기를 레이저로 절단하려고 한다. 효율적인 작업을 위해서 쇠막대기를 아래에서 위로 겹쳐 놓고, 레이저를 위에서 수직으로 발사하여 쇠막대기들을 자른다. 쇠막대기와 레이저의 배치는 다음 조건을 만족한다.

- 쇠막대기는 자신보다 긴 쇠막대기 위에만 놓일 수 있다. 
- 쇠막대기를 다른 쇠막대기 위에 놓는 경우 완전히 포함되도록 놓되, 끝점은 겹치지 않도록 놓는다.
- 각 쇠막대기를 자르는 레이저는 적어도 하나 존재한다.
- 레이저는 어떤 쇠막대기의 양 끝점과도 겹치지 않는다. 

아래 그림은 위 조건을 만족하는 예를 보여준다. 수평으로 그려진 굵은 실선은 쇠막대기이고, 점은 레이저의 위치, 수직으로 그려진 점선 화살표는 레이저의 발사 방향이다.

![](https://onlinejudgeimages.s3-ap-northeast-1.amazonaws.com/problem/10799/1.png)

이러한 레이저와 쇠막대기의 배치는 다음과 같이 괄호를 이용하여 왼쪽부터 순서대로 표현할 수 있다.

1. 레이저는 여는 괄호와 닫는 괄호의 인접한 쌍 ‘( ) ’ 으로 표현된다. 또한, 모든 ‘( ) ’는 반 
 드시 레이저를 표현한다.
2. 쇠막대기의 왼쪽 끝은 여는 괄호 ‘ ( ’ 로, 오른쪽 끝은 닫힌 괄호 ‘) ’ 로 표현된다. 

위 예의 괄호 표현은 그림 위에 주어져 있다.

쇠막대기는 레이저에 의해 몇 개의 조각으로 잘려지는데, 위 예에서 가장 위에 있는 두 개의 쇠막대기는 각각 3개와 2개의 조각으로 잘려지고, 이와 같은 방식으로 주어진 쇠막대기들은 총 17개의 조각으로 잘려진다. 

쇠막대기와 레이저의 배치를 나타내는 괄호 표현이 주어졌을 때, 잘려진 쇠막대기 조각의 총 개수를 구하는 프로그램을 작성하시오.

### 입력설명
한 줄에 쇠막대기와 레이저의 배치를 나타내는 괄호 표현이 공백없이 주어진다. 괄호 문자의 
개수는 최대 100,000이다. 
### 출력설명
잘려진 조각의 총 개수를 나타내는 정수를 한 줄에 출력한다.
### 입력예제 1 
()(((()())(())()))(())
### 출력예제 1
17
### 입력예제 2 
(((()(()()))(())()))(()())
### 출력예제 2
24
### 작성코드 
```jsx
// 해설 코드
function solution(s){
    let answer=0;
    let stack=[];
    for(let i=0; i<s.length; i++){
        if(s[i]==='(') stack.push('(');
        else{
            stack.pop(); 
            if(s[i-1]==='(') answer+=stack.length;
            else answer++;
            //stack.pop(); 이 위치에 하면 레이저까지 카운팅한다.
        }
    }                          
    return answer;
}

let a="()(((()())(())()))(())";
console.log(solution(a));

// 내가 작성한 코드
function solution(s){
    let answer=0;
    let stack=[];
    let parts=[];
    for (let i=0; i<s.length; i++){
        // 쇠막대기 시작
        if (s[i]==='(') {
            stack.push(s[i]);
            parts.push(1);
        }
        // 레이저일 경우
        else if (s[i]===')' && s[i-1]==='(') {
            stack.pop();
            parts.pop();
            parts = parts.map((a) => a+1);
        }
        // 쇠막대기 끝
        else {
            stack.pop();
            answer += parts.pop();
        }
        console.log(stack)
    }
    return answer;
}

let a="()(((()())(())()))(())";
console.log(solution(a));
```
### 부족했던 점
#### **막대기의 조각 수를 계산하는 방법이 비효율적이다.**
해설코드의 경우
- `(`로 시작하는 막대기의 수를 `stack`에 쌓고 레이저가 나오면 쌓여있는 막대기의 수만큼 짤려나온 막대기 조각 수를 `answer`에 더한다.
- 막대기가 끝나는 지점에선 끝난 막대기의 마지막 조각 하나를 `++`

내가 작성한 코드
- `(`로 새로운 막대기가 나올 때 마다 `parts` 배열에 `push`하여 각각의 막대기 조각 수를 저장(조각 수는 1로 시작)
- 레이저가 나오면 배열 요소에 각각 +1(레이저로 막대기가 조각나니까)
- 막대기가 끝나는 경우 , 배열 마지막 요소를 `pop`하여 `answer`에 합

설명에 제시된 그림을 보고 막대기 개수를 세로로 세면서 코드를 작성했다면 좀 더 쉽게 짤 수 있었을 듯 하다. 막대기 조각의 수를 따로 계산한 것이  아쉽다.

출처 : 한국정보올림피아드

<br>

## 6. 공주 구하기
정보 왕국의 이웃 나라 외동딸 공주가 숲속의 괴물에게 잡혀갔습니다. 
정보 왕국에는 왕자가 N명이 있는데 서로 공주를 구하러 가겠다고 합니다. 정보왕국의 왕은 다음과 같은 방법으로 공주를 구하러 갈 왕자를 결정하기로 했습니다.
왕은 왕자들을 나이 순으로 1번부터 N번까지 차례로 번호를 매긴다. 그리고 1번 왕자부터 N번 왕자까지 순서대로 시계 방향으로 돌아가며 동그랗게 앉게 한다. 그리고 1번 왕자부터 시계방향으로 돌아가며 1부터 시작하여 번호를 외치게 한다. 한 왕자가 K(특정숫자)를 외치면 그 왕자는 공주를 구하러 가는데서 제외되고 원 밖으로 나오게 된다. 그리고 다음 왕자부터 다시 1부터 시작하여 번호를 외친다.

이렇게 해서 마지막까지 남은 왕자가 공주를 구하러 갈 수 있다.

![](https://onlee3.github.io/assets/images/algorithm/Algo606-00001.png)

예를 들어 총 8명의 왕자가 있고, 3을 외친 왕자가 제외된다고 하자. 처음에는 3번 왕자가 3을 외쳐 제외된다. 이어 6, 1, 5, 2, 8, 4번 왕자가 차례대로 제외되고 마지막까지 남게 된 7번 왕자에게 공주를 구하러갑니다.

N과 K가 주어질 때 공주를 구하러 갈 왕자의 번호를 출력하는 프로그램을 작성하시오.
### 입력설명
첫 줄에 자연수 N(5<=N<=1,000)과 K(2<=K<=9)가 주어진다.
### 출력설명
첫 줄에 마지막 남은 왕자의 번호를 출력합니다.
### 입력예제 1 
8 3
### 출력예제 1
7
### 작성코드 
```jsx
// 해설 코드
function solution(n, k){
    let answer;
    let queue=Array.from({length:n}, (v, i)=>i+1); 
    while(queue.length){
        for(let i=1; i<k; i++) queue.push(queue.shift());
        queue.shift();
        if(queue.length===1) answer=queue.shift();
    }  
    return answer;
}

console.log(solution(8, 3));

// 내가 작성한 코드
function solution(n, k){
    let answer;
    let q = [];
    let front = rear = 0;
    for (let i=1; i<=n; i++){
        q.push(i);
    }
    for (let i=0; i<n; i++){
        for (let j=0; j<k; j++){
            front = q.shift();
            if (j===k-1) {
                answer = front;
            }
            else rear = q.push(front);
        }
    }
    return answer;
}

console.log(solution(8, 3));
```
### 부족했던 점
#### **Array.from() 미활용**
반복문을 사용하지 않고 배열 생성 가능하다. <br>
[Array객체 추가 설명](https://github.com/kimcno3/TIL/blob/main/programming_language/javascript.md#arrayfrom)

#### **while문의 조건으로 배열의 길이 미활용**
while문에 조건으로 .length만 적으면 그 길이가 0이 될 때까지 loop가 돈다.
```jsx
while(array.length > 0) // (X) 무한루프 에러
while(array.length)     // (O)
```

<br>

## 7. 교육과정 설계
현수는 1년 과정의 수업계획을 짜야 합니다.수업중에는 필수과목이 있습니다. 이 필수과목은 반드시 이수해야 하며, 그 순서도 정해져 있습니다.

만약 총 과목이 A, B, C, D, E, F, G가 있고, 여기서 필수과목이 CBA로 주어지면 필수과목은 C, B, A과목이며 이 순서대로 꼭 수업계획을 짜야 합니다.
여기서 순서란 B과목은 C과목을 이수한 후에 들어야 하고, A과목은 C와 B를 이수한 후에 들어야 한다는 것입니다. 

현수가 C, B, D, A, G, E로 수업계획을 짜면 제대로 된 설계이지만 C, G, E, A, D, B 순서로 짰다면 잘 못 설계된 수업계획이 됩니다.수업계획은 그 순서대로 앞에 수업이 이수되면 다음 수업을 시작하다는 것으로 해석합니다.

수업계획서상의 각 과목은 무조건 이수된다고 가정합니다.

필수과목순서가 주어지면 현수가 짠 N개의 수업설계가 잘된 것이면 “YES", 잘못된 것이면 ”NO“를 출력하는 프로그램을 작성하세요.

### 입력설명
첫 줄에 한 줄에 필수과목의 순서가 주어집니다. 모든 과목은 영문 대문자입니다.
두 번 째 줄부터 현수가 짠 수업설계가 주어집니다.(수업설계의 길이는 30이하이다)
### 출력설명
수업설계가 잘된 것이면 “YES", 잘못된 것이면 ”NO“를 출력합니다.
### 입력예제 1 
CBA
CBDAGE
### 출력예제 1
YES
### 작성코드 
```jsx
// 해설 코드
function solution(need, plan){
    let answer="YES";
    let queue=need.split('');
    for(let x of plan){
        // 필수과목인지 판단
        if(queue.includes(x)){
            // 가장 앞에 있는 필수과목과 전체 과목 중 필수과목에 해당하는 과목의 순서가 다르다면 No
            if(x!==queue.shift()) return "NO";
        }
    }
    // 큐에 과목이 남아있다는 것은 필수과목이 누락되어 있어 shift가 끝까지 되지 않았다는 뜻
    if(queue.length>0) return "NO";  
    return answer;
}

let a="CBA";
let b="CBDAGE";
console.log(solution(a, b));

// 내가 작성한 코드
function solution(need, plan){
    let answer="YES";
    let p = plan.split('');
    let n = need.split('');
    for(let i=0; i<n.length;i++){
        let c = n.shift();
        while(p.length) if(c === p.shift()) break;
        if (n.length !== 0 && p.length === 0) answer = 'No';
    }
    return answer;
}

let a="AGE";
let b="CBDAGE";
console.log(solution(a, b));
```
### 부족했던 점
#### **코드 흐름은 얼추 비슷했지만 효율적인 코드는 아니다.**
`includes()`메소드를 활용해서 순서대로 탐색하는 과목이 필수과목인지 아닌지를 먼저 파악했다면
- 필수과목일 경우, 큐의 맨 앞 과목과 현재 탐색 중인 과목이 같은지만 파악하면 되었다.
- 필수과목이 아닐 경우, 다음 과목으로 넘어가면 그만이다.

그 다음 전체 과목을 탐색했는데도 필수과목 큐에 과목이 남아있다면 해당 과목이 전체 과목에 포함되어 있지 않다는 경우임으로 그때도 No로 return한다.
#### **답에 'YES'가 나오는 경우**
|필수과목|전체과목|필수과목여부|동일여부|
|:--:|:--:|:--:|:--:|
|C|C|T|T|
|B|B|T|T|
|A|D|F|F|
|A|A|T|T|

필수과목이 맞을 때 순서도 모두 동일해야 YES

#### **답이 'NO'가 나오는 경우(다른 순서)**
|필수과목|전체과목|필수과목여부|동일여부|
|:--:|:--:|:--:|:--:|
|C|A|T|F| 

필수과목은 맞는데 순서가 달라서 NO

#### **답이 'NO'가 나오는 경우(필수과목 누락)**
|필수과목|전체과목|필수과목여부|동일여부|
|:--:|:--:|:--:|:--:|
|C|C|T|T|
|B|B|T|T|
|A|D|F|F|
|A|G|F|F|
|A|E|F|F|

A과목이 없어 큐에 남아있으면 No

<br>