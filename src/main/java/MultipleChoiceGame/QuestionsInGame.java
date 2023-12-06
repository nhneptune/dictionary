package MultipleChoiceGame;

public class QuestionsInGame {
    private String answer_A;
    private String answer_B;
    private String answer_C;
    private String answer_D;
    private String correctedAnswer;
    private String questions;
    private boolean isSelectedAnswer;

    public QuestionsInGame(String questions, String answer_A, String answer_B, String answer_C, String answer_D, String correctedAnswer) {
        this.answer_A = answer_A;
        this.answer_B = answer_B;
        this.answer_C = answer_C;
        this.answer_D = answer_D;
        this.correctedAnswer = correctedAnswer;
        this.isSelectedAnswer = false;
    }

    public String getAnswer_A() {
        return this.answer_A;
    }

    public void setAnswer_A(String answer_A) {
        this.answer_A = answer_A;
    }

    public String getAnswer_B() {
        return this.answer_B;
    }

    public void setAnswer_B(String answer_B) {
        this.answer_B = answer_B;
    }

    public String getAnswer_C() {
        return this.answer_C;
    }

    public void setAnswer_C(String answer_C) {
        this.answer_C = answer_C;
    }

    public String getAnswer_D() {
        return this.answer_D;
    }

    public void setAnswer_D(String answer_D) {
        this.answer_D = answer_D;
    }

    public String getQuestions() {
        return this.questions;
    }

    public void setQuestions(String questions) {
        this.questions = questions;
    }

    public String getCorrectedAnswer() {
        if (correctedAnswer == "A") {
            return answer_A;
        } else if (correctedAnswer == "B") {
            return answer_B;
        } else if (correctedAnswer == "C") {
            return answer_C;
        } else {
            return answer_D;
        }
    }

    public void setCorrectedAnswer(String correctedAnswer) {
        this.correctedAnswer = correctedAnswer;
    }

    public boolean isSelectedAnswer() {
        return this.isSelectedAnswer;
    }

    public void setSelectedAnswer(boolean selectedAnswer) {
        this.isSelectedAnswer = selectedAnswer;
    }
}
