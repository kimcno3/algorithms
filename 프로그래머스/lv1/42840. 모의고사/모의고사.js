function solution(answers) {
    let answer = [];

    let s1 = [1,2,3,4,5]
    let s2 = [2,1,2,3,2,4,2,5];
    let s3 = [3,3,1,1,2,2,4,4,5,5];

    // 1번 수포자 답안지 생성
    if(answers.length <= s1.length) s1=s1.splice(0,answers.length);
    else for(let i=0; i<answers.length; i++) if(i>s1.length-1) s1.push(s1[i%5]);
    // 2번 수포자 답안지 생성
    if(answers.length <= s2.length) s2=s2.splice(0,answers.length);
    else for(let i=0; i<answers.length; i++) if(i>s2.length-1) s2.push(s2[i%8]);
    // 3번 수포자 답안지 생성
    if(answers.length <= s3.length) s3=s3.splice(0,answers.length);
    else for(let i=0; i<answers.length; i++) if(i>s3.length-1) s3.push(s3[i%10]);
    // 채점
    let c1=0, c2=0, c3=0;
    for(let i=0; i<answers.length; i++){
        if(answers[i] === s1[i]) c1++;
        if(answers[i] === s2[i]) c2++;
        if(answers[i] === s3[i]) c3++;
    }
    // 가장 많이 맞춘 사람 찾기
    let max = Math.max(c1,c2,c3);
    if (max===c1) answer.push(1);
    if (max===c2) answer.push(2);
    if (max===c3) answer.push(3);

    return answer;
}