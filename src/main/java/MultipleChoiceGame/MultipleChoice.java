package MultipleChoiceGame;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MultipleChoice {
    private ArrayList<QuestionsInGame> gameQuestions = new ArrayList<>();
    private int numberOfQuestions;
    protected int score;

    public QuestionsInGame returnRandomQuestions() {
        List<QuestionsInGame> availableQuestions = this.gameQuestions.stream()
                .filter(questions -> !questions.isSelectedAnswer()) // lọc ra những câu hỏi chưa được chọn
                .collect(Collectors.toList()); // chuyển thành list

        if (availableQuestions.isEmpty()) {
            return null; // Hoặc xử lí khi khong còn câu hỏi nào chưa được chọn
        }

        int randomIndex = (int) (Math.random() * availableQuestions.size()); // chọn ngẫu nhiên 1 câu hỏi chưa được chọn
        QuestionsInGame randomQuestion = availableQuestions.get(randomIndex); // lấy câu hỏi ngãu nhiên
        randomQuestion.setSelectedAnswer(true); // đánh dấu câu hỏi đã được chọn

        return randomQuestion; // trả về câu hỏi ngẫu nhiên đã chọn ở trên
    }

    public ArrayList<QuestionsInGame> getGameQuestions() {
        return this.gameQuestions;
    }

    public int getNumberOfQuestions() {
        return this.numberOfQuestions;
    }

    public void addQuestions(QuestionsInGame q) {
        this.gameQuestions.add(q);
        numberOfQuestions = this.gameQuestions.size();
    }

    public static MultipleChoice getMultipleChoice() {
        MultipleChoice multipleChoice = new MultipleChoice();

        multipleChoice.addQuestions(new QuestionsInGame("....you ever been to Holland?", "Have", "Do", "Will","Are", "A"));
        multipleChoice.addQuestions(new QuestionsInGame("My village....part in the sporting event soon.", "taking", "takes", "is going to take","will takes", "D"));
        multipleChoice.addQuestions(new QuestionsInGame("Where will the World Cup 2020....?", "be held", "held", "hold","be hold", "A"));
        multipleChoice.addQuestions(new QuestionsInGame("Gustave Eiffel was well-known for....Eiffel tower.", "design", "designing", "to design","designed", "B"));
        multipleChoice.addQuestions(new QuestionsInGame(".... you ever been to Holland?", "Have", "Do", "Will","Are", "A"));
        multipleChoice.addQuestions(new QuestionsInGame("She is going to....television tonight.", "sing", "play", "stay","watch", "D"));
        multipleChoice.addQuestions(new QuestionsInGame("I don't like Maths....it is difficult.", "and", "but", "because","so", "C"));
        multipleChoice.addQuestions(new QuestionsInGame("My sister likes fashion. She....lots of on clothes.", "uses", "consumes", "spends","pays", "C"));
        multipleChoice.addQuestions(new QuestionsInGame("The United State has a....of around 250 million.", "separation", "population", "addition","introduction", "B"));
        multipleChoice.addQuestions(new QuestionsInGame("The 'ao dai' is the....dress of Vietnamese women.", "traditional", "beautiful", "baggy","casual", "A"));

        return multipleChoice;
    }

    public int getScore() {
        return this.score;
    }
    public void setScore(int score) {
        this.score = score;
    }
    public void increaseScoreGame() {
        this.score++;
    }
}
