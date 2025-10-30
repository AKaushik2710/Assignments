let student = {
    name : "John Doe",
    rollNo : 23,
    course : "DAC",
    marks : [85, 90, 78, 92, 88]
}

const totalMarks = (obj)=>{
    let total = obj.marks.reduce((acc, curr)=> acc+curr, 0);
    console.log(`Total Marks: ${total}`);
    return total;
}

const calculateGrade = (obj) => {
    let percentage = (totalMarks(obj) / obj.marks.length*100)*100;

    let grade;

    if(percentage >= 90){
        grade = 'A';
    }
    else if(percentage >= 80){
        grade = 'B';
    }
    else if(percentage >= 70){
        grade = 'C';
    }
    else if(percentage >= 60){
        grade = 'D';
    }
    else{
        grade = 'F';
    }

    console.log(`Grade: ${grade}`);
    return grade;
}

calculateGrade(student);
for(let key in student){
    console.log(`${key} : ${student[key]}`);
}

let jsonString = JSON.stringify(student);
console.log(jsonString);

let parsedJSONString = JSON.parse(jsonString);
console.log(parsedJSONString);