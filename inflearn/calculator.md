# :pushpin: 계산기

## 문제 설명
- 사용자가 입력한 문자열 값에 따라 사칙연산을 수행할 수 있는 계산기를 구현한다.
- 문자열 계산기는 사칙연산의 계산 우선순위가 아닌 입력 값에 따라 계산 순서가 결정된다. 
- 즉, 수학에서는 곱셈, 나눗셈이 덧셈, 뺄셈 보다 먼저 계산해야 하지만 이를 무시한다.
- 예를 들어 "2 + 3 * 4 / 2"와 같은 문자열을 입력할 경우 2 + 3 * 4 / 2 실행 결과인 10을 출력한다.
- 객체를 활용하여 구현한다.
## 구현 코드
```jsx
// Javascript

// 객체 선언
input = {
    "allText" : '',
    "n1" : 0,
    "n2" : 0,
    "op" : ''
};
output = {
    "result" : 0,
    "text" : ''
};
calculator = {
};
// 함수 선언
input.getAllText = function() {
    var input = prompt('계산입력')
    var split = input.split('').join(' ');
    this.allText = split;
}
input.getFirstNumber = function(){
    var n1 = Number(this.allText[0]);
    this.n1 = n1;
    output.result = n1;
}
input.getOperator = function(i){
    var op = this.allText[4*i+2];
    this.op = op;        
}
input.getSecondNumber = function(i){
    var n2 = Number(this.allText[4*i+4]);
    this.n2 = n2;
}
calculator.calculate = function(){
    switch(input.op) {
        case '+' : 
        output.result += input.n2;
        break;
        case '-' : 
        output.result -= input.n2;
        break;
        case '*' : 
        output.result *= input.n2;
        break;
        case '/' : 
        output.result /= input.n2;
        break;
    }
}
output.print = function() {
    this.text = output.result;
    console.log(this.text);
}
main = function(){
    input.getAllText();
    input.getFirstNumber();

    for(var i=0; i<(input.allText.length/4)-1; i++){
        input.getSecondNumber(i);
        input.getOperator(i);
        if (input.op === '+' || input.op === '-' || input.op === '*' || input.op === '/'){
            calculator.calculate();
        } else {
            alert("사칙연산자만 입력하세요.")
            return;
        }
    }
    output.print();
}
