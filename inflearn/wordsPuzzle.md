# :pushpin: 단어퍼즐

## 문제 설명
- 특정 문자열에서 뒤집기와 밀어내기 연산을 이용해서 원래 단어를 맞추는 게임을 구현한다.
- game 객체와 다른 객체들의 메소드와 속성을 이용해 코드를 깔끔하게 정리한다.
- 한 문제를 맞추면 다음 문제를 출제한다.
- 한 문제를 맞출 때마다 상단에 O를 하나씩 추가한다.
- 세 문제를 맞추면 Thank you for playing! 문구를 표시한다.


## 메소드 설명
1. **밀어내기 버튼** <br>
누를 경우 문자열이 오른쪽으로 한 칸씩 이동한다. 예를 들어 "HELLO" 상태에서 누르면 "OHELL"이 된다. 같은 방식으로 왼쪽 뒤집기도 구현한다.
2. **뒤집기 버튼** <br>
문자열이 뒤집힌다. 예를 들어 "HELLO" 상태에서 누르면 "OLLEH"가 된다.
3. **일치여부 확인**<br>
첫 줄의 문자열과 버튼의 문자열이 일치할 경우 화면에 "**일치합니다.**" 그렇지 않을 경우 "**일치하지 않습니다**" 를 표시한다.
4. **랜덤 단어 선택** <br>
10개 정도의 **임의의 단어에서 무작위로 고르는 기능**을 구현한다.
5. **단어 위치 섞기**
버튼으로 배열된 단어의 위치를 **무작위로 섞어 주는 기능**을 구현한다.

## 구현 코드
### HTML 파일
```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>퍼즐 구현  : 진행상황 처리</title>

    <style>
        button {
            padding : 5px 10px 5px 10px;
            margin : 3px;
        }
        #input {
            font-size: 30px;
        }
    </style>
</head>
<body>
    <p id = 'progress'></p>
    <div id = 'textbox'></div>
    <div id = 'btn1'></div>
    <div id = 'btn2'>
        <input type = "button" id = 'lshift' value="왼쪽으로 밀어내기" onclick="lshift()"></input>
        <input type = "button" id = 'rshift' value="오른쪽으로 밀어내기" onclick="rshift()"></input>
        <input type = "button" id = 'swap' value="뒤집기" onclick="swap()"></input>
    </div>
    <div id = 'result'><p id = 'answer'></p></div>

    <script src="puzzle4.js"></script>
</body>
</html>
```
### Javascript 파일
```jsx
// HTML 요소 변수 선언
let answer = document.getElementById('answer');
let btn1 = document.getElementById('btn1'); 
let textbox = document.getElementById('textbox');
let progress = document.getElementById('progress');

// game 객체 생성
let game = {};
// 10개의 단어를 배열에 할당
game.words = ['apple', 'banana', 'chrismas' , 'dinner' , 'example' , 'fish' , 'greenlight' , 'hotel' ,'information' , 'july']
// 선택된 단어 할당
game.word = '';
// word와 비교를 위한 배열
game.wordArr = [];

game.buttons = [];
// 최대 게임 수
game.maxPlay = 3;
// 현재 게임 수
game.currentPlay = 0;
// 단어 랜덤 설정 함수
game.randomWord = function() {
    // 0 ~ 9 까지의 정수 
    let index = Math.floor(Math.random() * 10);
    let text = this.words[index].toUpperCase();
    // game 객체 속성에 재할당
    this.word = text;
    this.wordArr = this.word.split('');
    // 페이지 화면에 표시
    textbox.innerHTML = text;
}

// 첫 버튼값을 만드는 함수
game.makeButtons = function(){ 
    for (let i=0; i < this.wordArr.length; i++){
        let button = document.createElement('button'); // button 태그 생성
        button.innerHTML = this.wordArr[i]; // button태그에 알파벳 text 추가
        btn1.appendChild(button); // 자녀태그로 추가
        this.buttons.push(button); // 각각의 버튼값을 buttons 배열에 순서대로 할당
    }
}

// 단어 일치시 기존 알파벳 버튼 초기화
game.removeButtons = function(){
    for (let i=0; i < this.buttons.length; i++){
        btn1.removeChild(this.buttons[i]);
        }
    this.buttons = [];
}
// 토글 활용 셔플 함수
game.suffleButtons = function() {
    for (let i=1; i <= 10; i++){ // 10번 반복
        let toggle = Math.floor(Math.random() * 3); // 0,1,2중에서 랜덤
        switch(toggle) { // 숫자에 맞는 함수 실행
            case 0:
            this.swap();
            break;
            case 1:
            this.rshift();
            break;
            case 2:
            this.lshift();
            break;
        }
    }
    this.correct();
}
// 일치/불일치 판별 함수
game.correct = function(){
    // 처음 받은 문자열과 재배치된 배열을 join 하여 만든 문자열이 일치하는가를 확인
    if (this.word === this.wordArr.join('')){
        answer.innerHTML = '일치합니다.'
    } else{
        answer.innerHTML = '불일치합니다.'
    }
}
// 게임 수와 답 일치 여부 확인
game.checkProgress = function() {
    console.log('check')
    if (answer.textContent === '일치합니다.'){
        this.currentPlay += 1;
        this.removeButtons();
        this.init();        
        let str = '';
        for (let i=0; i < this.currentPlay; i++){
            str += 'O';
        }
        progress.innerHTML = str;
    } 
    if (this.currentPlay === this.maxPlay){
        alert("Thank you for playing!");
        location.reload();
    }
}
// 문제 2 해결을 위한 함수 선언
let swap = function(){
    game.swap();
    game.correct();
    game.checkProgress();
}
let rshift = function(){
    game.rshift();
    game.correct();
    game.checkProgress();
}
let lshift = function(){
    game.lshift();
    game.correct();
    game.checkProgress();
}
// 뒤집기 함수
game.swap = function(){
    // swap 반복문 , 배열 길이의 반까지만 반복문 실행
    // 배열 길이-1 == 마지막 값의 index 
    // 마지막 값 index - i == i번째 값과 swap할 값의 위치
    for (let i=0; i<this.wordArr.length/2; i++){
        let x = this.wordArr[i];
        this.wordArr[i] = this.wordArr[this.wordArr.length - 1 - i];
        this.wordArr[this.wordArr.length - 1 - i] = x;
    }
    // buttons 배열 재할당 반복문
    for (let i=0; i<this.wordArr.length; i++){
        this.buttons[i].innerHTML = this.wordArr[i];
    }
}
// 오른쪽으로 밀어내기 함수
game.rshift = function(){
    let text = this.wordArr.pop(); // 마지막 순서 값 변수에 할당
    this.wordArr.unshift(text); // 할당된 마지막 순서 겂을 첫번째 순서로 unshift
    for(let i=0; i<this.wordArr.length; i++){
        // buttons[i]에 있는 HTML문자값을 바꿔줘야 하므로 innerHTML함수로 다시 입력해줘야 한다.
        this.buttons[i].innerHTML = this.wordArr[i];
    }
}
// 왼쪽으로 밀어내기 함수(원리는 위의 함수와 동일)
game.lshift = function(){
    let text = this.wordArr.shift();
    this.wordArr.push(text);
    for(let i=0; i<this.wordArr.length; i++){
        this.buttons[i].innerHTML = this.wordArr[i];
    }
}

game.init = function(){
    this.randomWord();
    this.makeButtons();
    this.suffleButtons();
}

// main 함수
// 페이지 로딩 시 버튼 생성1
game.main = function() {
    this.init();
}


// main 함수 실행
main();
```
<br>

## 트러블 슈팅
### 1. 동적으로 다음 문제 출제 기능 구현 실패
main() 함수에서 동작을 구현해보려 했지만 실패
### 해결방안
- 버튼을 클릭할 때 마다 일치여부를 확인하고 맞으면 새 문제를 내는 방식
- init() 메소드로 초기 문제를 구성하는 메소드만 모으고 , 클릭 시 작동하는 함수에 checkProgress 함수 설정

<br>

### 2. suffle() 메소드에 밀어내기, 뒤집기 메소드가 사용되면서 불필요한 단어 일치여부와 진행상황 판별 메소드 작동
- `game.suffle()`의 경우, 동일한 확률로 `game.rshift()` , `game.lshift()` , `game.swap()` 메소드를 총 10번 실행하여 단어의 순서를 섞는 기능
- 이 과정에서 단어 `game.correct()` , `game.checkProgress()` 메소드도 함께 작동하여 사용자 입장에서 게임 시작도 전에 정답횟수가 늘어나 있는 오류 발생

### 해결방안
- 객체 메소드가 아닌 일반 함수로 3개의 버튼 기능을 추가로 구현
    - `rshift()` , `lshift()` , `swap()` 로 구분
- 일반 함수와 HTML 버튼태그를 연결하여 버튼이 클릭될 경우에만 단어 일치여부와 진행상황을 판별하도록 코드 수정

### 3. HTML내 알파벳 버튼 중복 생성
- 문제를 맞출 때마다 다음 문제와 이전 문제의 알파벳버튼이 함께 섞이는 오류 발생 
### 해결 방안
- `removeChild()` 활용하여 다음 문제 시작 전, `id = btn1`인 `<div>`태그 안에 있는 자녀 태그 모두 삭제
- 위 기능을 `game.removeButtons()` 메소드 구현 