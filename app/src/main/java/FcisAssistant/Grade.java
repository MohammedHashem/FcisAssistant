package FcisAssistant;
public class Grade {
    protected float Assignment;
    protected float Midterm;
    protected float Final;
    protected float Attendance;
    protected float Bounce;
    protected float Quizzes;
    protected float Practical;
    protected float Weight;
    protected float TotalGrade;
    protected String GPA;
    protected GradeDistribution Max;
    public  Grade(){
        Assignment=0;
        Midterm=0;
        Final=0;
        Attendance=0;
        Bounce=0;
        Quizzes =0;
        Practical=0;

    }

    public float getAssignment() {
        return Assignment;
    }

    public void setAssignment(float assignment) {
        Assignment = assignment;
    }

    public float getMidterm() {
        return Midterm;
    }

    public void setMidterm(float midterm) {
        Midterm = midterm;
    }

    public float getFinal() {
        return Final;
    }

    public void setFinal(float aFinal) {
        Final = aFinal;
    }

    public float getAttendance() {
        return Attendance;
    }

    public void setAttendance(float attendance) {
        Attendance = attendance;
    }

    public float getBounce() {
        return Bounce;
    }

    public void setBounce(float bounce) {
        Bounce = bounce;
    }

    public float getQuizzes() {
        return Quizzes;
    }

    public void setQuizzes(float quizzes) {
        Quizzes = quizzes;
    }

    public float getPractical() {
        return Practical;
    }

    public void setPractical(float practical) {
        Practical = practical;
    }

    public float getWeight() {
        return Weight;
    }

    public void setWeight(float weight) {
        Weight = weight;
    }

    public float getTotalGrade() {
        return TotalGrade;
    }

    public void setTotalGrade(float totalGrade) {
        TotalGrade = totalGrade;
    }

    public GradeDistribution getMax() {
        return Max;
    }

    public void setMax(GradeDistribution max) {
        Max = max;
    }
    public void setGPA(){
        if (TotalGrade>=90)
            GPA="A";
        else if(TotalGrade>=85&&TotalGrade<90)
            GPA="A-";
        else if(TotalGrade>=80&&TotalGrade<85)
            GPA="B+";
        else if(TotalGrade>=75&&TotalGrade<80)
            GPA="B";
        else if(TotalGrade>=70&&TotalGrade<75)
            GPA="B-";
        else if(TotalGrade>=65&&TotalGrade<70)
            GPA="C+";
        else if(TotalGrade>=50&&TotalGrade<65)
            GPA="C";
        else if(TotalGrade>=40&&TotalGrade<50)
            GPA="C-";
        else if(TotalGrade>=30&&TotalGrade<40)
            GPA="D+";
        else if(TotalGrade>=0&&TotalGrade<30)
            GPA="F";
    }
    public void SetWieght(int credithour){
        Weight =Assignment+Midterm+Final+Attendance+Bounce+ Quizzes +Practical;
        Weight /=100;
        Weight *=4;
        Weight *=credithour;
    }


}
